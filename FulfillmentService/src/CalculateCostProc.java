

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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
		List<InvoiceDTO> invoiceList = null, invoiceDetailList = null;
		List<String> pageList = new ArrayList<String>();
		int id = 0, iId = 0, curPage= 1;
		String date = "", idStr = "";
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
			rd = request.getRequestDispatcher("view/monthlySalesHistory.jsp");
			rd.forward(request, response);
			LOG.trace("calculateShop 성공");
			break;

		/////////////////////////////////////////////////////////////////
		case "calculateOrder": // 월단위 발주 내역(구매처) 화면으로 이동
			LOG.trace("calculateOrder 시작");
			cDao = new CalculateCostDAO();
			calList = cDao.selectAllOrder();
			request.setAttribute("calList", calList);
			rd = request.getRequestDispatcher("view/monthlyOrderHistory.jsp");
			rd.forward(request, response);
			LOG.trace("calculateOrder 성공");
			break;

		/////////////////////////////////////////////////////////////////
		case "calculateTransit": // 월단위 운송 내역(운송 회사) 화면으로 이동
			LOG.trace("calculateTransit 시작");
			cDao = new CalculateCostDAO();
			calList = cDao.selectAllTrans();
			request.setAttribute("calList", calList);
			rd = request.getRequestDispatcher("view/monthlyTransitHistory.jsp");
			rd.forward(request, response);
			LOG.trace("calculateTransit 성공");
			break;

		/////////////////////////////////////////////////////////////////
		case "invoiceCheck": // 관리자 - 송장 처리 화면으로 이동하는 부분
			LOG.trace("관리자 - 송장 처리 화면으로 넘어가기 start");
			iDao = new InvoiceDAO();
			invoiceList = iDao.selectInvoiceAll();
			request.setAttribute("invoiceList", invoiceList);
			rd = request.getRequestDispatcher("view/invoiceProcess.jsp");
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
			invoiceDetailList = iDao.selectInvoiceDetailAll(iId);
			request.setAttribute("invoiceDetailList", invoiceDetailList);
			request.setAttribute("iId", iId);
			rd = request.getRequestDispatcher("view/invoiceProcessDetail.jsp");
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
			request.setAttribute("invoiceList", invoiceList);
			rd = request.getRequestDispatcher("CalculateCostProc?action=invoiceCheck");
			rd.forward(request, response);
			LOG.trace("invoiceUpdate 성공");
			
			break;
			
		/////////////////////////////////////////////////////////////////
		case "pickMonthForSales":	// 월단위 판매내역(쇼핑몰)에서 달력 선택 시 일어나는 부분
			LOG.trace("pickMonthForSales start");
			if (!request.getParameter("selectMonth").equals(""))
				date = request.getParameter("selectMonth");
			//LOG.trace("date = " + date);
			cDao = new CalculateCostDAO();
			calList = cDao.selectMonthSales(date);
			request.setAttribute("calList", calList);
			rd = request.getRequestDispatcher("view/monthlySalesHistory.jsp");
			rd.forward(request, response);

			LOG.trace("pickMonthForSales success");
			break;

		/////////////////////////////////////////////////////////////////

		case "pickMonthForOrder": // 월단위 발주내역(구매처)에서 달력 선택 시 일어나는 부분
			LOG.trace("pickMonthForOrder start");
			if (!request.getParameter("selectMonth").equals(""))
				date = request.getParameter("selectMonth");
			cDao = new CalculateCostDAO();
			calList = cDao.selectMonthOrder(date);
			request.setAttribute("calList", calList);
			rd = request.getRequestDispatcher("view/monthlyOrderHistory.jsp");
			rd.forward(request, response);
			LOG.trace("pickMonthForOrder success");
			break;

		/////////////////////////////////////////////////////////////////
		case "pickMonthForTransit": // 월단위 운송내역(운송 회사)에서 달력 선택 시 일어나는 부분
			LOG.trace("pickMonthForTransit start");
			if (!request.getParameter("selectMonth").equals(""))
				date = request.getParameter("selectMonth");
			cDao = new CalculateCostDAO();
			calList = cDao.selectMonthTransit(date);
			request.setAttribute("calList", calList);
			rd = request.getRequestDispatcher("view/monthlyTransitHistory.jsp");
			rd.forward(request, response);
			LOG.trace("pickMonthForTransit success");
			break;

		/////////////////////////////////////////////////////////////////

		case "totalSales_2017": // 매출 총이익 (17년도)
			LOG.trace("totalSales_2017 start");
			cDao = new CalculateCostDAO();
			request.setAttribute("Jan", cDao.totalSalesChart(2017, 1));
			request.setAttribute("Feb", cDao.totalSalesChart(2017, 2));
			request.setAttribute("Mar", cDao.totalSalesChart(2017, 3));
			request.setAttribute("Apr", cDao.totalSalesChart(2017, 4));
			request.setAttribute("May", cDao.totalSalesChart(2017, 5));
			request.setAttribute("Jun", cDao.totalSalesChart(2017, 6));
			request.setAttribute("Jul", cDao.totalSalesChart(2017, 7));
			request.setAttribute("Aug", cDao.totalSalesChart(2017, 8));
			request.setAttribute("Sep", cDao.totalSalesChart(2017, 9));
			request.setAttribute("Oct", cDao.totalSalesChart(2017, 10));
			request.setAttribute("Nov", cDao.totalSalesChart(2017, 11));
			request.setAttribute("Dec", cDao.totalSalesChart(2017, 12));
			request.setAttribute("year", 2017);
			rd = request.getRequestDispatcher("view/totalSales.jsp");
			rd.forward(request, response);

			LOG.trace("totalSales_2017 success");
			break;

		/////////////////////////////////////////////////////////////////

		case "totalSales_2018": // 매출 총이익 (18년도)
			LOG.trace("totalSales_2018 start");
			cDao = new CalculateCostDAO();
			request.setAttribute("Jan", cDao.totalSalesChart(2018, 1));
			request.setAttribute("Feb", cDao.totalSalesChart(2018, 2));
			request.setAttribute("Mar", cDao.totalSalesChart(2018, 3));
			request.setAttribute("Apr", cDao.totalSalesChart(2018, 4));
			request.setAttribute("May", cDao.totalSalesChart(2018, 5));
			request.setAttribute("Jun", cDao.totalSalesChart(2018, 6));
			request.setAttribute("Jul", cDao.totalSalesChart(2018, 7));
			request.setAttribute("Aug", cDao.totalSalesChart(2018, 8));
			request.setAttribute("Sep", cDao.totalSalesChart(2018, 9));
			request.setAttribute("Oct", cDao.totalSalesChart(2018, 10));
			request.setAttribute("Nov", cDao.totalSalesChart(2018, 11));
			request.setAttribute("Dec", cDao.totalSalesChart(2018, 12));
			request.setAttribute("year", 2018);
			rd = request.getRequestDispatcher("view/totalSales.jsp");
			rd.forward(request, response);

			LOG.trace("totalSales_2018 success");
			break;

		/////////////////////////////////////////////////////////////////

		case "totalSales_2019": // 매출 총이익으로 화면 전환하는 부분(19년도로 고정)
			LOG.trace("totalSales_2019 start");
			cDao = new CalculateCostDAO();
			request.setAttribute("Jan", cDao.totalSalesChart(2019, 1));
			request.setAttribute("Feb", cDao.totalSalesChart(2019, 2));
			request.setAttribute("Mar", cDao.totalSalesChart(2019, 3));
			request.setAttribute("Apr", cDao.totalSalesChart(2019, 4));
			request.setAttribute("May", cDao.totalSalesChart(2019, 5));
			request.setAttribute("Jun", cDao.totalSalesChart(2019, 6));
			request.setAttribute("Jul", cDao.totalSalesChart(2019, 7));
			request.setAttribute("Aug", cDao.totalSalesChart(2019, 8));
			request.setAttribute("Sep", cDao.totalSalesChart(2019, 9));
			request.setAttribute("Oct", cDao.totalSalesChart(2019, 10));
			request.setAttribute("Nov", cDao.totalSalesChart(2019, 11));
			request.setAttribute("Dec", cDao.totalSalesChart(2019, 12));
			request.setAttribute("year", 2019);
			rd = request.getRequestDispatcher("view/totalSales.jsp");
			rd.forward(request, response);

			LOG.trace("totalSales_2019 success");
			break;

		/////////////////////////////////////////////////////////////////

		case "cTodayHistory": // 운송 회사&구매처의 일별 주문내역 화면으로 전환하는 부분. default값은 오늘날짜 화면.
			LOG.trace("cTransitComTodayHistory start");
			idStr = (String) session.getAttribute("id");
			id = Integer.parseInt(idStr);
			LOG.trace("id=" + id);
			iDao = new InvoiceDAO();
			if(id >= 50001 && id <= 70000)	// 운송 회사
				invoiceList = iDao.selectTodayTransitCom(id);
			if(id >= 70001 && id <= 90000)	// 구매처
				invoiceList = iDao.selectTodayOrderCom(id);
			
			request.setAttribute("invoiceList", invoiceList);
			rd = request.getRequestDispatcher("view/cDailyOrderHistory.jsp");
			rd.forward(request, response);
			LOG.trace("cTransitComTodayHistory success");
			break;
			
		/////////////////////////////////////////////////////////////////

		case "cSelectDate": // 운송 회사&구매처의 일별 주문내역 확인 시 날짜 선택하면 일어나는 부분
			LOG.trace("cTransitComSelectDate start");
			idStr = (String) session.getAttribute("id");
			id = Integer.parseInt(idStr);
			LOG.trace("id=" + id);
			if (!request.getParameter("selectDate").equals(""))
				date = request.getParameter("selectDate");
			
			iDao = new InvoiceDAO();
			if(id >= 50001 && id <= 70000)	// 운송 회사
				invoiceList = iDao.selectDateTransitCom(date, id);
			if(id >= 70001 && id <= 90000)	// 구매처
				invoiceList = iDao.selectDateOrderCom(date, id);

			request.setAttribute("invoiceList", invoiceList);
			rd = request.getRequestDispatcher("view/cDailyOrderHistory.jsp");
			rd.forward(request, response);
			LOG.trace("cTransitComSelectDate success");
			break;
		/////////////////////////////////////////////////////////////////
			
		case "cNowMonthHistory": // 운송 회사&구매처의 월별 주문내역 화면으로 전환하는 부분. default값은 이번달
			LOG.trace("cTransitComNowMonthHistory start");
			idStr = (String) session.getAttribute("id");
			id = Integer.parseInt(idStr);
			LOG.trace("id=" + id);
			iDao = new InvoiceDAO();
			if(id >= 50001 && id <= 70000)	// 운송 회사
				invoiceList = iDao.selectNowMonthTransitCom(id);
			if(id >= 70001 && id <= 90000)	// 구매처
				invoiceList = iDao.selectNowMonthOrderCom(id);
			
			request.setAttribute("invoiceList", invoiceList);
			rd = request.getRequestDispatcher("view/cMonthlyOrderHistory.jsp");
			rd.forward(request, response);
			LOG.trace("cTransitComNowMonthHistory success");
			break;
			
		/////////////////////////////////////////////////////////////////
			
		case "cSelectMonth": // 운송 회사&구매처의 월별 주문내역 화면으로 전환하는 부분. default값은 이번달
			LOG.trace("cTransitComSelectMonth start");
			idStr = (String) session.getAttribute("id");
			id = Integer.parseInt(idStr);
			LOG.trace("id=" + id);
			if (!request.getParameter("selectMonth").equals(""))
				date = request.getParameter("selectMonth");
			
			iDao = new InvoiceDAO();
			if(id >= 50001 && id <= 70000)	// 운송 회사
				invoiceList = iDao.selectMonthTransitCom(date, id);
			if(id >= 70001 && id <= 90000)	// 구매처
				invoiceList = iDao.selectMonthOrderCom(date, id);
			
			request.setAttribute("invoiceList", invoiceList);
			rd = request.getRequestDispatcher("view/cMonthlyOrderHistory.jsp");
			rd.forward(request, response);
			LOG.trace("cTransitComSelectMonth success");
			break;
			
		/////////////////////////////////////////////////////////////////
			
		case "shoppingList":	//쇼핑몰 페이지 나누는 부분
			if (!request.getParameter("page").equals("")) {
				curPage = Integer.parseInt(request.getParameter("page"));
			}
			LOG.trace("curPage:" + curPage);
			cDao = new CalculateCostDAO();
			int count = cDao.getShoppingCount();
			if (count == 0)			// 데이터가 없을 때 대비
				count = 1;
			int pageNo = (int)Math.ceil(count/10.0);
			if (curPage > pageNo)	// 경계선에 걸렸을 때 대비
				curPage--;
			
			session.setAttribute("currentBbsPage", curPage);
			
			// 리스트 페이지의 하단 페이지 데이터 만들어 주기
			String page = null;
			page = "<a href=#>&laquo;</a>&nbsp;";
			pageList.add(page);
			for (int i=1; i<=pageNo; i++) {
				page = "&nbsp;<a href=CalculateCostProc?action=shoppingList&page=" + i + ">" + i + "</a>&nbsp;";
				pageList.add(page);
			}
			page = "&nbsp;<a href=#>&raquo;</a>";
			pageList.add(page);
			
			List<CalculateCostDTO> ipList = cDao.selectShoppingPage(curPage);
			//LOG.trace("ipList:" + ipList.toString());
			request.setAttribute("ipList", ipList);
			request.setAttribute("pageList", pageList);
			rd = request.getRequestDispatcher("view/monthlySalesHistory.jsp");
	        rd.forward(request, response);
			break;	
			
		////////////////////////////////////////////////////////////////////////
		case "pickMonthForSalesList":	// 월단위 판매내역(쇼핑몰) 달 선택 시 - 페이징 쓴 거
			if (!request.getParameter("page").equals("")) 
				curPage = Integer.parseInt(request.getParameter("page"));
			
			cDao = new CalculateCostDAO();
			
			count = cDao.getCountShoppingListSelectMonth(date);
			LOG.trace("count: " + count);
			if (count == 0)			// 데이터가 없을 때 대비
				count = 1;
			pageNo = (int) Math.ceil(count/10.0);
			if (curPage > pageNo)	// 경계선에 걸렸을 때 대비
				curPage--;
			
			// 페이징 시작 전에 전부 리셋해놓기
			pageList = new ArrayList<String>();
			page = null;
			
			// 리스트 페이지의 하단 페이지 데이터 만들어 주기
			page = "<a href=#>&laquo;</a>&nbsp;";
			pageList.add(page);
			for (int i=1; i<=pageNo; i++) {
				page = "&nbsp;<a href=CalculateCostProc?action=pickMonthForSalesList&page=" + i + ">" + i + "</a>&nbsp;";
				pageList.add(page);
			}
			page = "&nbsp;<a href=#>&raquo;</a>";
			pageList.add(page);
			
			if(request.getParameter("selectMonth") != null && !request.getParameter("selectMonth").equals("")) {
				date = request.getParameter("selectMonth");
				ipList = cDao.selectShoppingPageSelectMonth(date, curPage);
				session.setAttribute("date", date);
			} else {
				ipList = cDao.selectShoppingPageSelectMonth((String) session.getAttribute("date"), curPage);
				LOG.trace("date session:" + (String) session.getAttribute("date"));
				//session.removeAttribute("date");
			}

			request.setAttribute("ipList", ipList);
			request.setAttribute("pageList", pageList);
			rd = request.getRequestDispatcher("view/monthlySalesHistory.jsp");
	        rd.forward(request, response);
			
			
			break;
			
		////////////////////////////////////////////////////////////////////////	
			
		case "orderList": // 구매처 페이지 나누는 부분
			if (!request.getParameter("page").equals("")) {
				curPage = Integer.parseInt(request.getParameter("page"));
			}
			LOG.trace("curPage:" + curPage);
			cDao = new CalculateCostDAO();
			count = cDao.getOrderCount();
			if (count == 0) // 데이터가 없을 때 대비
				count = 1;
			pageNo = (int) Math.ceil(count / 10.0);
			if (curPage > pageNo) // 경계선에 걸렸을 때 대비
				curPage--;

			session.setAttribute("currentBbsPage", curPage);

			// 리스트 페이지의 하단 페이지 데이터 만들어 주기
			page = null;
			page = "<a href=#>&laquo;</a>&nbsp;";
			pageList.add(page);
			for (int i = 1; i <= pageNo; i++) {
				page = "&nbsp;<a href=CalculateCostProc?action=orderList&page=" + i + ">" + i + "</a>&nbsp;";
				pageList.add(page);
			}
			page = "&nbsp;<a href=#>&raquo;</a>";
			pageList.add(page);

			List<CalculateCostDTO> opList = cDao.selectOrderPage(curPage);
			// LOG.trace("opList:" + opList.toString());
			request.setAttribute("opList", opList);
			request.setAttribute("pageList", pageList);
			rd = request.getRequestDispatcher("view/monthlyOrderHistory.jsp");
			rd.forward(request, response);
			break;
			
			////////////////////////////////////////////////////////////////////////
		case "pickMonthForOrderList": // 월단위 판매내역(구매처) 달 선택 시 - 페이징 쓴 거
			if (!request.getParameter("page").equals(""))
				curPage = Integer.parseInt(request.getParameter("page"));

			cDao = new CalculateCostDAO();

			count = cDao.getCountOrderListSelectMonth(date);
			LOG.trace("count: " + count);
			if (count == 0) // 데이터가 없을 때 대비
				count = 1;
			pageNo = (int) Math.ceil(count / 10.0);
			if (curPage > pageNo) // 경계선에 걸렸을 때 대비
				curPage--;

			// 페이징 시작 전에 전부 리셋해놓기
			pageList = new ArrayList<String>();
			page = null;

			// 리스트 페이지의 하단 페이지 데이터 만들어 주기
			page = "<a href=#>&laquo;</a>&nbsp;";
			pageList.add(page);
			for (int i = 1; i <= pageNo; i++) {
				page = "&nbsp;<a href=CalculateCostProc?action=pickMonthForOrderList&page=" + i + ">" + i
						+ "</a>&nbsp;";
				pageList.add(page);
			}
			page = "&nbsp;<a href=#>&raquo;</a>";
			pageList.add(page);

			if (request.getParameter("selectMonth") != null && !request.getParameter("selectMonth").equals("")) {
				date = request.getParameter("selectMonth");
				opList = cDao.selectOrderPageSelectMonth(date, curPage);
				session.setAttribute("date", date);
			} else {
				opList = cDao.selectOrderPageSelectMonth((String) session.getAttribute("date"), curPage);
				LOG.trace("date session:" + (String) session.getAttribute("date"));
				// session.removeAttribute("date");
			}

			request.setAttribute("opList", opList);
			request.setAttribute("pageList", pageList);
			rd = request.getRequestDispatcher("view/monthlyOrderHistory.jsp");
			rd.forward(request, response);

			break;
			
		////////////////////////////////////////////////////////////////////////
			
		case "transitList": // 운송 회사 페이지 나누는 부분
			if (!request.getParameter("page").equals("")) {
				curPage = Integer.parseInt(request.getParameter("page"));
			}
			LOG.trace("curPage:" + curPage);
			cDao = new CalculateCostDAO();
			count = cDao.getTransitCount();
			if (count == 0) // 데이터가 없을 때 대비
				count = 1;
			pageNo = (int) Math.ceil(count / 10.0);
			if (curPage > pageNo) // 경계선에 걸렸을 때 대비
				curPage--;

			session.setAttribute("currentBbsPage", curPage);

			// 리스트 페이지의 하단 페이지 데이터 만들어 주기
			page = null;
			page = "<a href=#>&laquo;</a>&nbsp;";
			pageList.add(page);
			for (int i = 1; i <= pageNo; i++) {
				page = "&nbsp;<a href=CalculateCostProc?action=transitList&page=" + i + ">" + i + "</a>&nbsp;";
				pageList.add(page);
			}
			page = "&nbsp;<a href=#>&raquo;</a>";
			pageList.add(page);

			List<CalculateCostDTO> tpList = cDao.selectTransitPage(curPage);
			// LOG.trace("tpList:" + tpList.toString());
			request.setAttribute("tpList", tpList);
			request.setAttribute("pageList", pageList);
			rd = request.getRequestDispatcher("view/monthlyTransitHistory.jsp");
			rd.forward(request, response);
			break;
			
			////////////////////////////////////////////////////////////////////////
		case "pickMonthForTransitList": // 월단위 발주내역(운송 회사) 달 선택 시 - 페이징 쓴 거
			if (!request.getParameter("page").equals(""))
				curPage = Integer.parseInt(request.getParameter("page"));

			cDao = new CalculateCostDAO();

			count = cDao.getCountTransitListSelectMonth(date);
			LOG.trace("count: " + count);
			if (count == 0) // 데이터가 없을 때 대비
				count = 1;
			pageNo = (int) Math.ceil(count / 10.0);
			if (curPage > pageNo) // 경계선에 걸렸을 때 대비
				curPage--;

			// 페이징 시작 전에 전부 리셋해놓기 List<CalculateCostDTO> 
			pageList = new ArrayList<String>();
			page = null;
			//tpList = new ArrayList<CalculateCostDTO>();
			//tpList.clear();
			//pageList.clear();
			
			// 리스트 페이지의 하단 페이지 데이터 만들어 주기
			page = "<a href=#>&laquo;</a>&nbsp;";
			pageList.add(page);
			for (int i = 1; i <= pageNo; i++) {
				page = "&nbsp;<a href=CalculateCostProc?action=pickMonthForTransitList&page=" + i + ">" + i
						+ "</a>&nbsp;";
				pageList.add(page);
			}
			page = "&nbsp;<a href=#>&raquo;</a>";
			pageList.add(page);
			
			if (request.getParameter("selectMonth") != null && !request.getParameter("selectMonth").equals("")) {
				date = request.getParameter("selectMonth");
				tpList = cDao.selectTransitPageSelectMonth(date, curPage);
				session.setAttribute("date", date);
			} else {
				tpList = cDao.selectTransitPageSelectMonth((String) session.getAttribute("date"), curPage);
				LOG.trace("date session:" + (String) session.getAttribute("date"));
				// session.removeAttribute("date");
			}

			request.setAttribute("tpList", tpList);
			request.setAttribute("pageList", pageList);
			rd = request.getRequestDispatcher("view/monthlyTransitHistory.jsp");
			rd.forward(request, response);

			break;
			
		////////////////////////////////////////////////////////////////////////	
		default:
			LOG.trace("action이 잘못된 값으로 설정됨");

		}
		
	}
}
