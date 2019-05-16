import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

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
		List<ProductDTO> pList = null, pListBook = null, pListAnimalGoods = null, pListCosmetic = null, pListFruit = null, pListHomeAppliances = null;
		List<ProductDTO> pListItemDetail = null;
		List<EventDTO> eListId = null, eListAmount = null;
		HttpSession session = request.getSession();
		RequestDispatcher rd = null;
		int pId = 0, orderAmount = 0, alertCount = 0;
		String action = request.getParameter("action");
		
		switch(action) {
		/////////////////////////////////////////////////////////////////
		case "showItems":	// 관리자 - 재고 목록 화면 띄워주는 부분
			LOG.trace("showItems 시작");
			pDao = new ProductDAO();
			pListBook = pDao.selectAllBook();
			pListAnimalGoods = pDao.selectAllAnimalGoods();
			pListCosmetic = pDao.selectAllCosmetic();
			pListFruit = pDao.selectAllFruit();
			pListHomeAppliances = pDao.selectAllHomeAppliances();
			alertCount = pDao.selectProductCount();
			session.setAttribute("alertCount", alertCount);
			
			request.setAttribute("pListBook", pListBook);
			request.setAttribute("pListAnimalGoods", pListAnimalGoods);
			request.setAttribute("pListCosmetic", pListCosmetic);
			request.setAttribute("pListFruit", pListFruit);
			request.setAttribute("pListHomeAppliances", pListHomeAppliances);
			
			rd = request.getRequestDispatcher("view/checkInventory.jsp");
			rd.forward(request, response);
			LOG.trace("showItems 성공");
			break;
			
		/////////////////////////////////////////////////////////////////
		case "showItemsDetail":	// 관리자 - 재고 목록 화면 중 이미지 클릭 시 상세 화면 띄워주는 부분
			LOG.trace("showItemsDetail 시작");
			if (!request.getParameter("pId").equals("")) {
				pId = Integer.parseInt(request.getParameter("pId"));
			}
			
			pDao = new ProductDAO();
			pListItemDetail = pDao.selectDetail(pId);
			
			request.setAttribute("pListItemDetail", pListItemDetail);
			request.setAttribute("pId", pId);
			rd = request.getRequestDispatcher("view/checkInventoryDetail.jsp");
			rd.forward(request, response);
			LOG.trace("showItemsDetail success");
			break;

		/////////////////////////////////////////////////////////////////
		case "requestItems":	// 관리자 - 발주 요청 화면 띄워주는 부분
			LOG.trace("requestItems 시작");
			pDao = new ProductDAO();
			pList = pDao.selectAllItems();
			eListId = pDao.selectEventpId();
			eListAmount = pDao.selectEventpAmount();
			alertCount = pDao.selectProductCount();
			session.setAttribute("alertCount", alertCount);
			request.setAttribute("pList", pList);
			request.setAttribute("eListId", eListId);
			request.setAttribute("eListAmount", eListAmount);
			
			rd = request.getRequestDispatcher("view/orderRequest.jsp");
			rd.forward(request, response);
			LOG.trace("requestItems 성공");
			break;
			
		/////////////////////////////////////////////////////////////////
		case "requestItemsDetail":		// 관리자 - 발주 요청 화면에서 GO버튼 클릭시 상세화면 이동
			LOG.trace("requestItemsDetail 시작");
			if (!request.getParameter("pId").equals("")) {
				pId = Integer.parseInt(request.getParameter("pId"));
			}
			
			pDao = new ProductDAO();
			pList = pDao.selectAllItemsDetail(pId);
			
			request.setAttribute("pList", pList);
			request.setAttribute("pId", pId);
			rd = request.getRequestDispatcher("view/orderRequestDetail.jsp");
			rd.forward(request, response);
			LOG.trace("requestItemsDetail success");
			break;
			
			/////////////////////////////////////////////////////////////////
			case "requestItemsToOrder":		// 관리자 - 발주 상세화면에서 발주하기 버튼 누르면 일어나는 부분
			LOG.trace("requestItemsToOrder 시작");
			
			if (!request.getParameter("pId").equals(""))
				pId = Integer.parseInt(request.getParameter("pId").trim());

			String temp = request.getParameter("orderAmount");
			if(!Pattern.matches("^[0-9]*$", temp) || temp.equals("")) {
				request.setAttribute("message", "숫자를 입력하세요.");
				request.setAttribute("url", "ProductProc?action=requestItemsDetail&pId=" + pId);
				rd = request.getRequestDispatcher("alertMsg.jsp");
				rd.forward(request, response);
				LOG.trace("발주 확인 버튼 - 입력 오류");
				break;
			}
			
			orderAmount = Integer.parseInt(request.getParameter("orderAmount"));
			pDao = new ProductDAO();
			pDao.SendOrderRequest(orderAmount, pId);
			
			String message = "발주 요청 완료. 내일 오전 10시에 입고됩니다.";
			request.setAttribute("message", message);
			request.setAttribute("url", "ProductProc?action=requestItems");
			rd = request.getRequestDispatcher("alertMsg.jsp");
			rd.forward(request, response);
			
			LOG.trace("requestItemsToOrder success");
			break;
						
			
		/////////////////////////////////////////////////////////////////
		default:
		LOG.trace("action이 잘못된 값으로 설정됨");
			
		}
	}
}