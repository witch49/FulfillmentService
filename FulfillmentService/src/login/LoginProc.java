package login;


import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import company.OrderCompanyDAO;
import company.OrderCompanyDTO;
import company.TransCompanyDAO;
import company.TransCompanyDTO;
import product.ProductDAO;


/**
 * Servlet implementation class LoginProc
 */
@WebServlet("/LoginProc")
public class LoginProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(LoginProc.class);

	public LoginProc() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = "", password = "";
		String errorMessage = "";
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		Cookie[] cookies = null;
		RequestDispatcher rd = null;
		TransCompanyDAO tDao = null;
		TransCompanyDTO tDto = null;
		OrderCompanyDAO oDao = null;
		OrderCompanyDTO oDto = null;
		ProductDAO pDao = null;
		int alertCount = 0;
		
		
		switch(action) {

		////////////////////////////////////////////////////////////////////////////////////
		case "login": // 로그인
			LOG.trace("Login start");
			if (!request.getParameter("id").equals(""))
				id = request.getParameter("id");
			password = request.getParameter("password");		

			/* 관리자 로그인하는 부분 */
			if (id.equals("admin") && password.equals("admin")) {
				session.setAttribute("id", id);
				
				cookies = request.getCookies();
				Cookie c = new Cookie("fulfillment", session.getId() + "" + new java.util.Date().toString().replace(" ", ""));
				LOG.trace("c1쿠키명: " + c.getName() + ", c1쿠키값: " + c.getValue());
				
				if(cookies != null) {					
					for(Cookie cookie : cookies)
						LOG.trace("c2쿠키명: " + cookie.getName() + ",  c2쿠키값: " + cookie.getValue());
				}
				
				c.setPath("/FulfillmentService/view/login.jsp");
				response.addCookie(c);
				
				pDao = new ProductDAO();
				alertCount = pDao.selectProductCount();
				session.setAttribute("alertCount", alertCount);
				response.sendRedirect("view/loginMain.jsp");
				LOG.trace("관리자 로그인 성공");
				break;
			}
			
			if(id.equals("admin") && !password.equals("admin")) {
				request.setAttribute("message", "패스워드 오류입니다. 다시 입력해 주세요.");
				request.setAttribute("url", "view/login.jsp");
				rd = request.getRequestDispatcher("alertMsg.jsp");
				rd.forward(request, response);
				LOG.trace("관리자 로그인 성공 - 비밀번호 오류");	
				break;
			}
			
			if(!Pattern.matches("[0-9]*", id)) {
				request.setAttribute("message", "아이디 오류입니다. 고객이라면 숫자만 입력해 주세요.");
				request.setAttribute("url", "view/login.jsp");
				rd = request.getRequestDispatcher("alertMsg.jsp");
				rd.forward(request, response);
				LOG.trace("관리자 성공 - 아이디 오류");	
				break;
			}
			
			// id 범위가 50000에서 70000 사이인 경우 운송회사 아이디
			if (Integer.parseInt(id) > 50000 && Integer.parseInt(id) < 70001) {
				tDao = new TransCompanyDAO();
				int result = tDao.verifyLogin(Integer.parseInt(id), password);
				
				switch (result) {
				case TransCompanyDAO.ID_PASSWORD_MATCH:
					errorMessage = "";
					break;
				case TransCompanyDAO.ID_DOES_NOT_EXIST:
					errorMessage = "없는 아이디";
					break;
				case TransCompanyDAO.PASSWORD_IS_WRONG:
					errorMessage = "패스워드 오류";
					break;
				case TransCompanyDAO.DATABASE_ERROR:
					errorMessage = "DB 오류";
					break;
				default:
					errorMessage = "ERROR!";
				}
				
				if (result == TransCompanyDAO.ID_PASSWORD_MATCH) {
					tDto = tDao.searchById(Integer.parseInt(id));
					session.setAttribute("id", id);
					session.setAttribute("memberName", tDto.gettName());
					response.sendRedirect("view/cLoginMain.jsp");
					LOG.trace("운송 회사 로그인 성공");
					break;
				} else {
					request.setAttribute("message", errorMessage);
					request.setAttribute("url", "view/login.jsp");
					rd = request.getRequestDispatcher("alertMsg.jsp");
					rd.forward(request, response);
					LOG.trace("운송 회사 로그인 성공 - 패스워드 틀림");
				}
			}
			
			// id 범위가 70001에서 90000 사이인 경우 구매 회사 아이디
			else if (Integer.parseInt(id) > 70000 && Integer.parseInt(id) < 90001) {
				oDao = new OrderCompanyDAO();
				int result = oDao.verifyLogin(Integer.parseInt(id), password);
				
				switch (result) {
				case OrderCompanyDAO.ID_PASSWORD_MATCH:
					errorMessage = "";
					break;
				case OrderCompanyDAO.ID_DOES_NOT_EXIST:
					errorMessage = "없는 아이디";
					break;
				case OrderCompanyDAO.PASSWORD_IS_WRONG:
					errorMessage = "패스워드 오류";
					break;
				case OrderCompanyDAO.DATABASE_ERROR:
					errorMessage = "DB 오류";
					break;
				default:
					errorMessage = "ERROR!";
				}
				if (result == OrderCompanyDAO.ID_PASSWORD_MATCH) {
					oDto = oDao.searchById(Integer.parseInt(id));
					session.setAttribute("id", id);
					session.setAttribute("memberName", oDto.getoName());
					response.sendRedirect("view/cLoginMain.jsp");
					LOG.trace("구매 회사 로그인 성공");
					break;
				} else {
					request.setAttribute("message", errorMessage);
					request.setAttribute("url", "view/login.jsp");
					rd = request.getRequestDispatcher("alertMsg.jsp");
					rd.forward(request, response);
					LOG.trace("구매 회사 로그인 성공 - 패스워드 틀림");
				}
			}
			else {
				request.setAttribute("message", "없는 아이디입니다.");
				request.setAttribute("url", "view/login.jsp");
				rd = request.getRequestDispatcher("alertMsg.jsp");
				rd.forward(request, response);
				LOG.trace("구매 회사 로그인 성공 - 아이디 없음");
			}
			break;
		
		////////////////////////////////////////////////////////////////////////////////////
		case "logout":			//로그아웃
			LOG.trace("Logout start");
			if(session.getAttribute("id") != "")
				session.removeAttribute("id");
			if(session.getAttribute("memberName") != "")
				session.removeAttribute("memberName");
			if(session.getAttribute("invoiceList") != "")
				session.removeAttribute("invoiceList");
			if(session.getAttribute("selectMonth") != "")
				session.removeAttribute("selectMonth");
			if(session.getAttribute("selectDate") != "")
				session.removeAttribute("selectDate");
			if(session.getAttribute("alertCount") != "")
				session.removeAttribute("alertCount");
			response.sendRedirect("view/index.jsp");
			LOG.trace("로그아웃 성공");
			break;
			
			////////////////////////////////////////////////////////////////////////////////////
		case "loginView":
			response.sendRedirect("view/login.jsp");
			break;
			
			////////////////////////////////////////////////////////////////////////////////////
		default:
			LOG.trace("action값이 잘못 설정되었음");
			break;

		}
	}
}
