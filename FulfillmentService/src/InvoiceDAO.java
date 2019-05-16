import java.sql.*;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvoiceDAO {
	private static final Logger LOG = LoggerFactory.getLogger(InvoiceDAO.class);

	private Connection conn;
	private static final String USERNAME = "javauser";
	private static final String PASSWORD = "javapass";
	private static final String URL = "jdbc:mysql://localhost:3306/fulfillment?verifyServerCertificate=false&useSSL=false";
	
	public InvoiceDAO() {
		try {
		    Class.forName("com.mysql.jdbc.Driver");
		    conn = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception ex) {
            ex.printStackTrace();
        } 
	}
	
	public void close() {
		try {
			if ( conn != null && !conn.isClosed())
				conn.close();
		} catch (SQLException E) {
			E.printStackTrace();
		}
	}
	
	/* csv 파일을 읽어와 리스트에 반환하는 메소드 - 송장 내역 확인&처리 화면에 사용 */
	public List<InvoiceDTO> selectInvoiceAll() {
		LOG.trace("InvoiceDAO selectInvoiceAll() start");
		PreparedStatement pStmt = null;
		List<InvoiceDTO> invoiceList = new ArrayList<>();
		String sql = "select I.i_id, I.i_consigneeName, I.i_orderDate, S.s_id, S.s_name, T.t_id, T.t_name, i_check from invoice as I" + 
				" inner join shopping_mall as S on I.i_sId = S.s_id" + 
				" inner join trans_company as T on I.i_tId = T.t_id" + 
				" order by i_orderDate desc;";
		try {
			pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				InvoiceDTO i = new InvoiceDTO();
				i.setiId(rs.getInt(1));
				i.setiConsigneeName(rs.getString(2));
				i.setiOrderDate(rs.getString(3).substring(0, 16));
				i.setI_sId(rs.getInt(4));
				i.setI_sName(rs.getString(5));
				i.setI_tId(rs.getInt(6));
				i.setI_tName(rs.getString(7));
				i.setiCheck(rs.getString(8));
				invoiceList.add(i);
			}
		} catch (Exception e) {
			LOG.trace("InvoiceDAO selectInvoiceAll() ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOG.trace("InvoiceDAO selectInvoiceAll() success");
		return invoiceList;
	}
	
	public List<InvoiceDTO> selectInvoiceDetailAll(int iId) {
		LOG.trace("InvoiceDAO selectInvoiceDetailAll() start");
		PreparedStatement pStmt = null;
		List<InvoiceDTO> invoiceDetailList = new ArrayList<>();
		String sql = "select * from invoice where i_id=?;";
		
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, iId);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				InvoiceDTO i = new InvoiceDTO();
				i.setiId(rs.getInt(1));
				i.setiConsigneeName(rs.getString(2));
				i.setiConsigneeTel(rs.getString(3));
				i.setiConsigneeAddr(rs.getString(4));
				i.setI_pId(rs.getInt(5));
				i.setI_pName(rs.getString(6));
				i.setiAmount(rs.getInt(7));
				i.setiOrderDate( rs.getString(8).substring(0, 16));
				i.setI_sId(rs.getInt(9));
				i.setI_tId(rs.getInt(10));
				i.setiCheck(rs.getString(11));
				invoiceDetailList.add(i);
			}
		} catch (Exception e) {
			LOG.trace("InvoiceDAO selectInvoiceDetailAll() ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOG.trace("InvoiceDAO selectInvoiceDetailAll() success");
		return invoiceDetailList;
	}
	
	
	/* 송장 처리 버튼을 누르면 일어나는 부분 */
	public void updateInvoiceAll() {
		LOG.trace("InvoiceDAO updateInvoiceAll() start");
		PreparedStatement pStmt = null;
		String sql = "update invoice as I inner join product as P on P.p_id=I.i_pId" + 
				" set I.i_check='Y', P.p_amount=P.p_amount-I.i_amount" + 
				" where P.p_amount - I.i_amount > 1 and I.i_check='N'" + 
				" and (" + 
				" 	(date(I.i_orderDate) <= date(date_sub(now(), interval 2 day)))" + 
				" 	or ( date(I.i_orderDate) = date(date_sub(now(), interval 1 day)) and hour(I.i_orderDate) < 18 )" + 
				" 	or (" + 
				" 	 ((day(I.i_orderDate) = day(date_sub(now(), interval 1 day))) and hour(I.i_orderDate) >= 18)" + 
				"	 or (day(I.i_orderDate) = day(now()) and hour(I.i_orderDate) < 9)" + 
				"	 and (hour(now()) >= 9)" + 
				"	)" + 
				"	or (" + 
				"	 day(I.i_orderDate) = day(now())" + 
				"	 and (hour(I.i_orderDate) >= 9 and hour(I.i_orderDate) < 18)" + 
				"	 and (hour(now()) >= 18)" + 
				"	)" + 
				");";
		
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.executeUpdate();
		} catch (Exception e) {
			LOG.trace("InvoiceDAO updateInvoiceAll() ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOG.trace("InvoiceDAO updateInvoiceAll() success");
	}
	
	
	/* 운송 회사가 일별 주문 내역을 확인하는 화면. default = TODAY */
	public List<InvoiceDTO> selectTodayTransitCom(int id) {
		LOG.trace("InvoiceDAO selectTodayTransitCom() start");
		PreparedStatement pStmt = null;
		List<InvoiceDTO> invoiceDetailList = new ArrayList<>();
		String sql = "select I.i_id, I.i_consigneeName, I.i_consigneeTel, I.i_orderDate, C.c_tCost from invoice as I" + 
				" inner join calculate_cost as C on C.c_iTel = I.i_consigneeTel and C.c_iDate = I.i_orderDate" + 
				" inner join trans_company as T on T.t_id=I.i_tId" + 
				" where date(I.i_orderDate) = date(now()) and I.i_tId = ?" + 
				" group by I.i_consigneeTel, I.i_orderDate" + 
				" order by I.i_orderDate desc;";
		try {
			pStmt = conn.prepareStatement(sql);	
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				InvoiceDTO i = new InvoiceDTO();
				i.setiId(rs.getInt(1));
				i.setiConsigneeName(rs.getString(2));
				i.setiConsigneeTel(rs.getString(3));
				i.setiOrderDate( rs.getString(4).substring(0, 16));
				i.setCost(rs.getInt(5));
				invoiceDetailList.add(i);
			}
		} catch (Exception e) {
			LOG.trace("InvoiceDAO selectTodayTransitCom() ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOG.trace("InvoiceDAO selectTodayTransitCom() success");
		return invoiceDetailList;
		
	}
	
	
	/*  운송 회사가 일별 주문 내역 화면에서 날짜 선택 시 처리하는 부분 */
	public List<InvoiceDTO> selectDateTransitCom(String date, int id) {
		LOG.trace("InvoiceDAO selectDateTransitCom() start");
		PreparedStatement pStmt = null;
		List<InvoiceDTO> invoiceDetailList = new ArrayList<>();
		String sql = "select I.i_id, I.i_consigneeName, I.i_consigneeTel, I.i_orderDate, C.c_tCost from invoice as I" + 
				" inner join calculate_cost as C on C.c_iTel = I.i_consigneeTel and C.c_iDate = I.i_orderDate" + 
				" inner join trans_company as T on T.t_id = I.i_tId" +
				" where I.i_orderDate like '%" + date + "%' and I.i_tId = ?" + 
				" group by I.i_consigneeTel, I.i_orderDate" + 
				" order by I.i_orderDate desc;";
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				InvoiceDTO i = new InvoiceDTO();
				i.setiId(rs.getInt(1));
				i.setiConsigneeName(rs.getString(2));
				i.setiConsigneeTel(rs.getString(3));
				i.setiOrderDate( rs.getString(4).substring(0, 16));
				i.setCost(rs.getInt(5));
				invoiceDetailList.add(i);
			}
		} catch (Exception e) {
			LOG.trace("InvoiceDAO selectDateTransitCom() ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOG.trace("InvoiceDAO selectDateTransitCom() success");
		return invoiceDetailList;
	}
	
	
	/* 운송 회사가 월별 주문 내역을 확인하는 화면. default = 현재 달 */
	public List<InvoiceDTO> selectNowMonthTransitCom(int id) {
		LOG.trace("InvoiceDAO selectNowMonthTransitCom() start");
		PreparedStatement pStmt = null;
		List<InvoiceDTO> invoiceDetailList = new ArrayList<>();
		String sql = "select I.i_id, I.i_consigneeName, I.i_consigneeTel, I.i_orderDate, C.c_tCost from invoice as I" + 
				" inner join calculate_cost as C on C.c_iTel=I.i_consigneeTel and C.c_iDate=I.i_orderDate" + 
				" inner join trans_company as T on T.t_id=I.i_tId" + 
				" where year(I.i_orderDate) = year(now()) and month(I.i_orderDate)=month(now()) and I.i_tId=?" + 
				" group by I.i_consigneeTel, I.i_orderDate" + 
				" order by I.i_orderDate desc;";
		try {
			pStmt = conn.prepareStatement(sql);	
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				InvoiceDTO i = new InvoiceDTO();
				i.setiId(rs.getInt(1));
				i.setiConsigneeName(rs.getString(2));
				i.setiConsigneeTel(rs.getString(3));
				i.setiOrderDate( rs.getString(4).substring(0, 16));
				i.setCost(rs.getInt(5));
				invoiceDetailList.add(i);
			}
		} catch (Exception e) {
			LOG.trace("InvoiceDAO selectNowMonthTransitCom() ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOG.trace("InvoiceDAO selectNowMonthTransitCom() success");
		return invoiceDetailList;
		
	}
	
	
	/*  운송 회사가 월별 주문 내역 화면에서 날짜 선택 시 처리하는 부분 */
	public List<InvoiceDTO> selectMonthTransitCom(String date, int id) {
		LOG.trace("InvoiceDAO selectMonthTransitCom() start");
		PreparedStatement pStmt = null;
		List<InvoiceDTO> invoiceDetailList = new ArrayList<>();
		String sql = "select I.i_id, I.i_consigneeName, I.i_consigneeTel, I.i_orderDate, C.c_tCost from invoice as I" + 
				" inner join calculate_cost as C on C.c_iTel=I.i_consigneeTel and C.c_iDate=I.i_orderDate" + 
				" inner join trans_company as T on T.t_id=I.i_tId" + 
				" where I.i_orderDate like '%" + date + "%' and I.i_tId = ?" + 
				" group by I.i_consigneeTel, I.i_orderDate" + 
				" order by I.i_orderDate desc;";
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				InvoiceDTO i = new InvoiceDTO();
				i.setiId(rs.getInt(1));
				i.setiConsigneeName(rs.getString(2));
				i.setiConsigneeTel(rs.getString(3));
				i.setiOrderDate( rs.getString(4).substring(0, 16));
				i.setCost(rs.getInt(5));
				invoiceDetailList.add(i);
			}
		} catch (Exception e) {
			LOG.trace("InvoiceDAO selectMonthTransitCom() ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOG.trace("InvoiceDAO selectMonthTransitCom() success");
		return invoiceDetailList;
	}
	
	
	/* 구매처가 일별 주문 내역을 확인하는 화면. default = TODAY */
	public List<InvoiceDTO> selectTodayOrderCom(int id) {
		LOG.trace("InvoiceDAO selectTodayOrderCom() start");
		PreparedStatement pStmt = null;
		List<InvoiceDTO> invoiceDetailList = new ArrayList<>();
		String sql = "select I.i_id, I.i_consigneeName, I.i_consigneeTel, I.i_orderDate, C.c_oCost from invoice as I" + 
				" inner join calculate_cost as C on C.c_iTel=I.i_consigneeTel and C.c_iDate=I.i_orderDate" + 
				" inner join product as P on I.i_pId=P.p_id" + 
				" inner join order_company as O on O.o_id=P.p_oId" + 
				" where date(I.i_orderDate) = date(now()) and O.o_id = ?" + 
				" group by I.i_consigneeTel, I.i_orderDate" + 
				" order by I.i_orderDate desc;";
		try {
			pStmt = conn.prepareStatement(sql);	
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				InvoiceDTO i = new InvoiceDTO();
				i.setiId(rs.getInt(1));
				i.setiConsigneeName(rs.getString(2));
				i.setiConsigneeTel(rs.getString(3));
				i.setiOrderDate( rs.getString(4).substring(0, 16));
				i.setCost(rs.getInt(5));
				invoiceDetailList.add(i);
			}
		} catch (Exception e) {
			LOG.trace("InvoiceDAO selectTodayOrderCom() ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOG.trace("InvoiceDAO selectTodayOrderCom() success");
		return invoiceDetailList;
		
	}
	
	
	/*  구매처가 일별 주문 내역 화면에서 날짜 선택 시 처리하는 부분 */
	public List<InvoiceDTO> selectDateOrderCom(String date, int id) {
		LOG.trace("InvoiceDAO selectDateOrderCom() start");
		PreparedStatement pStmt = null;
		List<InvoiceDTO> invoiceDetailList = new ArrayList<>();
		String sql = "select I.i_id, I.i_consigneeName, I.i_consigneeTel, I.i_orderDate, C.c_oCost from invoice as I" + 
				" inner join calculate_cost as C on C.c_iTel=I.i_consigneeTel and C.c_iDate=I.i_orderDate" + 
				" inner join product as P on I.i_pId=P.p_id" + 
				" inner join order_company as O on O.o_id=P.p_oId" + 
				" where date(I.i_orderDate) = date(?) and O.o_id = ?" + 
				" group by I.i_consigneeTel, I.i_orderDate" + 
				" order by I.i_orderDate desc;";
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, date);
			pStmt.setInt(2, id);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				InvoiceDTO i = new InvoiceDTO();
				i.setiId(rs.getInt(1));
				i.setiConsigneeName(rs.getString(2));
				i.setiConsigneeTel(rs.getString(3));
				i.setiOrderDate( rs.getString(4).substring(0, 16));
				i.setCost(rs.getInt(5));
				invoiceDetailList.add(i);
			}
		} catch (Exception e) {
			LOG.trace("InvoiceDAO selectDateOrderCom() ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOG.trace("InvoiceDAO selectDateOrderCom() success");
		return invoiceDetailList;
	}
	
	/* 구매처가 월별 주문 내역을 확인하는 화면. default = 현재 달 */
	public List<InvoiceDTO> selectNowMonthOrderCom(int id) {
		LOG.trace("InvoiceDAO selectNowMonthOrderCom() start");
		PreparedStatement pStmt = null;
		List<InvoiceDTO> invoiceDetailList = new ArrayList<>();
		String sql = "select I.i_id, I.i_consigneeName, I.i_consigneeTel, I.i_orderDate, C.c_oCost from invoice as I" + 
				" inner join calculate_cost as C on C.c_iTel=I.i_consigneeTel and C.c_iDate=I.i_orderDate" + 
				" inner join product as P on I.i_pId=P.p_id" + 
				" inner join order_company as O on O.o_id=P.p_oId" + 
				" where year(I.i_orderDate) = year(now()) and month(I.i_orderDate)=month(now()) and O.o_id = ?" + 
				" group by I.i_consigneeTel, I.i_orderDate" + 
				" order by I.i_orderDate desc;";
		try {
			pStmt = conn.prepareStatement(sql);	
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				InvoiceDTO i = new InvoiceDTO();
				i.setiId(rs.getInt(1));
				i.setiConsigneeName(rs.getString(2));
				i.setiConsigneeTel(rs.getString(3));
				i.setiOrderDate( rs.getString(4).substring(0, 16));
				i.setCost(rs.getInt(5));
				invoiceDetailList.add(i);
			}
		} catch (Exception e) {
			LOG.trace("InvoiceDAO selectNowMonthOrderCom() ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOG.trace("InvoiceDAO selectNowMonthOrderCom() success");
		return invoiceDetailList;
		
	}
	
	/*  구매처가 월별 주문 내역 화면에서 날짜 선택 시 처리하는 부분 */
	public List<InvoiceDTO> selectMonthOrderCom(String date, int id) {
		LOG.trace("InvoiceDAO selectMonthOrderCom() start");
		PreparedStatement pStmt = null;
		List<InvoiceDTO> invoiceDetailList = new ArrayList<>();
		String sql = "select I.i_id, I.i_consigneeName, I.i_consigneeTel, I.i_orderDate, C.c_oCost from invoice as I" + 
				" inner join calculate_cost as C on C.c_iTel=I.i_consigneeTel and C.c_iDate=I.i_orderDate" + 
				" inner join product as P on I.i_pId=P.p_id" + 
				" inner join order_company as O on O.o_id=P.p_oId" + 
				" where I.i_orderDate like '%" + date + "%' and O.o_id = ?" + 
				" group by I.i_consigneeTel, I.i_orderDate" + 
				" order by I.i_orderDate desc;";
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				InvoiceDTO i = new InvoiceDTO();
				i.setiId(rs.getInt(1));
				i.setiConsigneeName(rs.getString(2));
				i.setiConsigneeTel(rs.getString(3));
				i.setiOrderDate( rs.getString(4).substring(0, 16));
				i.setCost(rs.getInt(5));
				invoiceDetailList.add(i);
			}
		} catch (Exception e) {
			LOG.trace("InvoiceDAO selectMonthOrderCom() ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOG.trace("InvoiceDAO selectMonthOrderCom() success");
		return invoiceDetailList;
	}
	
	
}
