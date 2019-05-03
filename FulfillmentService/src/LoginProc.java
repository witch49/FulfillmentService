

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
			
			// id 범위가 30000에서 50000 사이인 경우 쇼핑몰 아이디
			if (Integer.parseInt(id) > 30000 && Integer.parseInt(id) < 50001) {
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
					session.setAttribute("id", id);
					response.sendRedirect("temp.jsp");
					LOG.trace("쇼핑몰 회사 로그인 성공");
					break;
				} else {
					request.setAttribute("message", errorMessage);
					request.setAttribute("url", "login.jsp");
					rd = request.getRequestDispatcher("alertMsg.jsp");
					rd.forward(request, response);
					LOG.trace("쇼핑몰 회사 로그인 성공 - 패스워드 틀림");
				}
			}
			
			// id 범위가 50001에서 70000 사이인 경우 운송 회사 아이디
			if (Integer.parseInt(id) > 50000 && Integer.parseInt(id) < 70001) {
				session.setAttribute("id", id);
				response.sendRedirect("temp.jsp");
				LOG.trace("운송 회사 로그인 성공");
				break;
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
