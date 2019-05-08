import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class ProductProc
 */
@WebServlet("/ProductProc")
public class ProductProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger LOG = LoggerFactory.getLogger(ProductProc.class);

	
    public ProductProc() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ProductDAO pDao = null;
		ProductDTO pDto = null;
		List<ProductDTO> pList = null;
		HttpSession session = request.getSession();
		RequestDispatcher rd = null;
		String action = request.getParameter("action");
		
		switch(action) {
		/////////////////////////////////////////////////////////////////
		case "showBook":
			LOG.trace("showBook 시작");
			
			pDao = new ProductDAO();
			pList = pDao.selectAllBook();
			
			
			request.setAttribute("pList", pList);
			rd = request.getRequestDispatcher("admin/checkInventory.jsp");
			rd.forward(request, response);
			LOG.trace("showBook 성공");
			break;

		/////////////////////////////////////////////////////////////////
		default:
		LOG.trace("action이 잘못된 값으로 설정됨");
			
		}
	}
}