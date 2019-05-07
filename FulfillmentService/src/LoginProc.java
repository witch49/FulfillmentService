

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
		String errorMessage;
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		RequestDispatcher rd = null;
		TransCompanyDAO tDao = null;
		TransCompanyDTO tDto = null;
		OrderCompanyDAO oDao = null;
		OrderCompanyDTO oDto = null;
		
		
		switch(action) {

		////////////////////////////////////////////////////////////////////////////////////
		case "login": // 로그인
			LOG.trace("Login start");
			if (!request.getParameter("id").equals(""))
				id = request.getParameter("id");
			if (!request.getParameter("password").equals(""))
				password = request.getParameter("password");

			if (id.equals("admin") && password.equals("admin")) {
				// rd = request.getRequestDispatcher("/admin/monthlySalesHistory.jsp");
				// rd.forward(request, response);
				session.setAttribute("id", id);
				response.sendRedirect("loginMain.jsp");
				LOG.trace("관리자 로그인 성공");
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
					errorMessage = "";
				}
				if (result == TransCompanyDAO.ID_PASSWORD_MATCH) {
					tDto = tDao.searchById(Integer.parseInt(id));
					session.setAttribute("id", id);
					session.setAttribute("memberName", tDto.gettName());
					response.sendRedirect("cLoginMain.jsp");
					LOG.trace("운송 회사 로그인 성공");
					break;
				} else {
					request.setAttribute("message", errorMessage);
					request.setAttribute("url", "login.jsp");
					rd = request.getRequestDispatcher("alertMsg.jsp");
					rd.forward(request, response);
					LOG.trace("운송 회사 로그인 성공 - 패스워드 틀림");
				}
			}
			
			// id 범위가 70001에서 90000 사이인 경우 구매 회사 아이디
			if (Integer.parseInt(id) > 70000 && Integer.parseInt(id) < 90001) {
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
					errorMessage = "";
				}
				if (result == OrderCompanyDAO.ID_PASSWORD_MATCH) {
					oDto = oDao.searchById(Integer.parseInt(id));
					session.setAttribute("id", id);
					session.setAttribute("memberName", oDto.getoName());
					response.sendRedirect("cLoginMain.jsp");
					LOG.trace("구매 회사 로그인 성공");
					break;
				} else {
					request.setAttribute("message", errorMessage);
					request.setAttribute("url", "login.jsp");
					rd = request.getRequestDispatcher("alertMsg.jsp");
					rd.forward(request, response);
					LOG.trace("구매 회사 로그인 성공 - 패스워드 틀림");
				}
			}
			break;
		
		////////////////////////////////////////////////////////////////////////////////////
		case "logout":			//로그아웃
			LOG.trace("Logout start");
			session.removeAttribute("id");
			response.sendRedirect("index.jsp");
			LOG.trace("로그아웃 성공");
			break;
			
			////////////////////////////////////////////////////////////////////////////////////
		default:
			LOG.trace("action값이 잘못 설정되었음");
			break;

		}
	}
}
