

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
 * Servlet implementation class CalculateCostProc
 */
@WebServlet("/CalculateCostProc")
public class CalculateCostProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger LOG = LoggerFactory.getLogger(CalculateCostProc.class);

    public CalculateCostProc() {
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
		CalculateCostDAO cDao = null;
		CalculateCostDTO cDto = null;
		List<CalculateCostDTO> calList = null;
		InvoiceDTO iDto = null;
		InvoiceDAO iDao = null;
		List<InvoiceDTO> invoiceList = null;
		List<InvoiceDTO> invoiceDetailList = null;
		int id = 0;
		int iId = 0;
		HttpSession session = request.getSession();
		RequestDispatcher rd = null;
		String action = request.getParameter("action");
		
		switch(action) {
		/////////////////////////////////////////////////////////////////
		case "calculateShop":	// 월단위 판매 내역(쇼핑몰) 화면으로 이동
			LOG.trace("calculateShop 시작");
			cDao = new CalculateCostDAO();
			calList = cDao.selectAllShopping();
			request.setAttribute("calList", calList);
			rd = request.getRequestDispatcher("admin/monthlySalesHistory.jsp");
			rd.forward(request, response);
			LOG.trace("calculateShop 성공");
			break;

		/////////////////////////////////////////////////////////////////
		case "calculateOrder": // 월단위 발주 내역(구매처) 화면으로 이동
			LOG.trace("calculateOrder 시작");
			cDao = new CalculateCostDAO();
			calList = cDao.selectAllOrder();
			request.setAttribute("calList", calList);
			rd = request.getRequestDispatcher("admin/monthlyOrderHistory.jsp");
			rd.forward(request, response);
			LOG.trace("calculateOrder 성공");
			break;

		/////////////////////////////////////////////////////////////////
		case "calculateTransit": // 월단위 운송 내역(운송 회사) 화면으로 이동
			LOG.trace("calculateTransit 시작");
			cDao = new CalculateCostDAO();
			calList = cDao.selectAllTrans();
			request.setAttribute("calList", calList);
			rd = request.getRequestDispatcher("admin/monthlyTransitHistory.jsp");
			rd.forward(request, response);
			LOG.trace("calculateTransit 성공");
			break;

		/////////////////////////////////////////////////////////////////
		case "invoiceCheck": // 관리자 - 송장 처리 화면으로 이동하는 부분
			LOG.trace("관리자 - 송장 처리 화면으로 넘어가기 start");
			iDao = new InvoiceDAO();

			invoiceList = iDao.selectInvoiceAll();

			request.setAttribute("invoiceList", invoiceList);
			rd = request.getRequestDispatcher("admin/invoiceProcess.jsp");
			rd.forward(request, response);
			LOG.trace("관리자 - 송장 처리 화면으로 넘어가기 success");
			break;
		/////////////////////////////////////////////////////////////////
			
		case "invoiceCheckDetail":	// 관리자 - 송장 처리 화면에서 상세화면으로 이동하는 부분
			LOG.trace("관리자 - 송장 처리 상세화면으로 넘어가기 start");
			if (!request.getParameter("iId").equals("")) {
				iId = Integer.parseInt(request.getParameter("iId"));
			}
			iDao = new InvoiceDAO();
			
			invoiceDetailList = iDao.selectInvoiceDatailAll(iId);
			
			request.setAttribute("invoiceDetailList", invoiceDetailList);
			request.setAttribute("iId", iId);
			rd = request.getRequestDispatcher("admin/invoiceProcessDetail.jsp");
			rd.forward(request, response);
			LOG.trace("관리자 - 송장 처리 상세화면으로 넘어가기 success");
			break;
			
		/////////////////////////////////////////////////////////////////
			
		case "invoiceUpdate":	// 송장 처리 화면에서 송장 처리 버튼을 누르면 일어나는 부분
			LOG.trace("invoiceUpdate start");
			iDao = new InvoiceDAO();
			iDao.updateInvoiceAll();	// Y로 수정할 거 고치기
			cDao = new CalculateCostDAO();
			cDao.deleteDBTable();
			cDao.insertDBTable();	// 판매내역 관련 DB 테이블에 데이터 추가
			
			//invoiceList = request.getParameter("invoiceList");
			request.setAttribute("invoiceList", invoiceList);
			
			rd = request.getRequestDispatcher("CalculateCostProc?action=invoiceCheck");
			rd.forward(request, response);
			LOG.trace("invoiceUpdate 성공");
			
			break;
			
		/////////////////////////////////////////////////////////////////
		default:
			LOG.trace("action이 잘못된 값으로 설정됨");

		}
		
	}
}
