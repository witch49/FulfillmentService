import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalculateCostDAO {
	private static final Logger LOG = LoggerFactory.getLogger(CalculateCostDAO.class);
	public static final int ID_PASSWORD_MATCH = 1;
	public static final int ID_DOES_NOT_EXIST = 2;
	public static final int PASSWORD_IS_WRONG = 3;
	public static final int DATABASE_ERROR = -1;
	private Connection conn;
	private static final String USERNAME = "javauser";
	private static final String PASSWORD = "javapass";
	private static final String URL = "jdbc:mysql://localhost:3306/fulfillment?verifyServerCertificate=false&useSSL=false";

	public CalculateCostDAO() {
		try {
		    Class.forName("com.mysql.jdbc.Driver");
		    conn = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception ex) {
            ex.printStackTrace();
        } 
	}
	
	/* 관리자 : 월단위 판매내역(쇼핑몰) 확인하는 부분 */
	public List<CalculateCostDTO> selectAllShopping() {
		LOG.trace("CalculateCostDAO selectAllShopping() start");
		String sql = "select distinct C.c_iTel, C.c_iDate, C.c_sCost, I.i_sId, S.s_name from calculate_cost as C" + 
				" inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate" + 
				" inner join shopping_mall as S on S.s_id=I.i_sId" + 
				" order by C.c_iDate desc;";
		PreparedStatement pStmt = null;
		List<CalculateCostDTO> iList = new ArrayList<CalculateCostDTO>();

		try {
			pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				CalculateCostDTO c = new CalculateCostDTO();
				c.setC_iTel(rs.getString(1));
				c.setC_iDate(rs.getString(2).substring(0, 16));
				c.setC_sCost(rs.getInt(3));
				c.setC_comId(rs.getInt(4));
				c.setC_comName(rs.getString(5));
				iList.add(c);
			}
		} catch (Exception e) {
			LOG.trace("CalculateCostDAO selectAllShopping() ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOG.trace("CalculateCostDAO selectAllShopping() success");
		return iList;
	}
	
	/* 관리자 : 월단위 발주내역(구매처) 확인하는 부분 */
	public List<CalculateCostDTO> selectAllOrder() {
		LOG.trace("CalculateCostDAO selectAllOrder() start");
		String sql = "select distinct C.c_iTel, C.c_iDate, C.c_oCost, O.o_id, O.o_name from calculate_cost as C" + 
				" inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate" + 
				" inner join product as P on P.p_id=I.i_pId" + 
				" inner join order_company as O on O.o_id=P.p_oId" + 
				" order by C.c_iDate desc;";
		PreparedStatement pStmt = null;
		List<CalculateCostDTO> oList = new ArrayList<CalculateCostDTO>();

		try {
			pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				CalculateCostDTO c = new CalculateCostDTO();
				c.setC_iTel(rs.getString(1));
				c.setC_iDate(rs.getString(2).substring(0, 16));
				c.setC_oCost(rs.getInt(3));
				c.setC_comId(rs.getInt(4));
				c.setC_comName(rs.getString(5));
				oList.add(c);
			}
		} catch (Exception e) {
			LOG.trace("CalculateCostDAO selectAllOrder() ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOG.trace("CalculateCostDAO selectAllOrder() success");
		return oList;
	}
	
	
	/* 관리자 : 월단위 발주내역(운송 회사) 확인하는 부분 */
	public List<CalculateCostDTO> selectAllTrans() {
		LOG.trace("CalculateCostDAO selectAllTrans() start");
		String sql = "select distinct C.c_iTel, C.c_iDate, C.c_tCost, T.t_id, T.t_name from calculate_cost as C" + 
				" inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate" + 
				" inner join trans_company as T on T.t_id=I.i_tId" + 
				" order by C.c_iDate desc;";
		PreparedStatement pStmt = null;
		List<CalculateCostDTO> tList = new ArrayList<CalculateCostDTO>();

		try {
			pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				CalculateCostDTO c = new CalculateCostDTO();
				c.setC_iTel(rs.getString(1));
				c.setC_iDate(rs.getString(2).substring(0, 16));
				c.setC_tCost(rs.getInt(3));
				c.setC_comId(rs.getInt(4));
				c.setC_comName(rs.getString(5));
				tList.add(c);
			}
		} catch (Exception e) {
			LOG.trace("CalculateCostDAO selectAllTrans() ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOG.trace("CalculateCostDAO selectAllTrans() success");
		return tList;
	}
	
	/* 관리자 : 월단위 내역 출력 전 실행해야 하는 메소드1 */
	public void deleteDBTable() {
		LOG.trace("CalculateCostDAO deleteDBTable() start");
		String sql = "delete from calculate_cost;";
		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.executeUpdate();
		} catch (Exception e) {
			LOG.trace("CalculateCostDAO deleteDBTable() ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOG.trace("CalculateCostDAO deleteDBTable() success");
	}
	
	/* 관리자 : 월단위 내역 출력 전 실행해야 하는 메소드2 */
	public void insertDBTable() {
		LOG.trace("CalculateCostDAO insertDBTable() start");
		String sql = "insert into calculate_cost(c_iTel, c_iDate, c_sCost, c_oCost)" + 
				" select I.i_consigneeTel, I.i_orderDate, (sum(P.p_price*I.i_amount)*1.1 + 10000), sum(P.p_price*I.i_amount) from invoice as I" + 
				" inner join product as P on I.i_pId=P.p_id and I.i_check='Y'" + 
				" group by I.i_consigneeTel, I.i_orderDate order by I.i_id;";
		PreparedStatement pStmt = null;

		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.executeUpdate();
		} catch (Exception e) {
			LOG.trace("CalculateCostDAO insertDBTable() ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOG.trace("CalculateCostDAO insertDBTable() success");
	}
	
	
	/* 관리자 : 월단위 판매내역(쇼핑몰) 날짜 선택 시 발생하는 부분 */
	public List<CalculateCostDTO> selectMonthSales(String date) {
		LOG.trace("CalculateCostDAO selectMonthSales() start");
		String sql = "select distinct C.c_iTel, C.c_iDate, C.c_sCost, I.i_sId, S.s_name from calculate_cost as C" + 
				" inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate" + 
				" inner join shopping_mall as S on S.s_id=I.i_sId" +
				" where C.c_iDate like '%" + date + "%'" +
				" order by C.c_iDate desc;";
		PreparedStatement pStmt = null;
		List<CalculateCostDTO> iList = new ArrayList<CalculateCostDTO>();

		try {
			pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				CalculateCostDTO c = new CalculateCostDTO();
				c.setC_iTel(rs.getString(1));
				c.setC_iDate(rs.getString(2).substring(0, 16));
				c.setC_sCost(rs.getInt(3));
				c.setC_comId(rs.getInt(4));
				c.setC_comName(rs.getString(5));
				iList.add(c);
			}
		} catch (Exception e) {
			LOG.trace("CalculateCostDAO selectMonthSales() Exception ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOG.trace("CalculateCostDAO selectMonthSales() success");
		return iList;
	}
	
	/* 관리자 : 월단위 발주내역(구매처) 날짜 선택 시 발생하는 부분 */
	public List<CalculateCostDTO> selectMonthOrder(String date) {
		LOG.trace("CalculateCostDAO selectMonthOrder() start");	
		String sql = "select distinct C.c_iTel, C.c_iDate, C.c_oCost, O.o_id, O.o_name from calculate_cost as C" + 
				" inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate" + 
				" inner join product as P on P.p_id=I.i_pId" + 
				" inner join order_company as O on O.o_id=P.p_oId" + 
				" where C.c_iDate like '%" + date + "%'" +
				" order by C.c_iDate desc;";
		PreparedStatement pStmt = null;
		List<CalculateCostDTO> iList = new ArrayList<CalculateCostDTO>();

		try {
			pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				CalculateCostDTO c = new CalculateCostDTO();
				c.setC_iTel(rs.getString(1));
				c.setC_iDate(rs.getString(2).substring(0, 16));
				c.setC_oCost(rs.getInt(3));
				c.setC_comId(rs.getInt(4));
				c.setC_comName(rs.getString(5));
				iList.add(c);
			}
		} catch (Exception e) {
			LOG.trace("CalculateCostDAO selectMonthOrder() Exception ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOG.trace("CalculateCostDAO selectMonthOrder() success");
		return iList;
	}
	
	/* 관리자 : 월단위 운송내역(운송 회사) 날짜 선택 시 발생하는 부분 */
	public List<CalculateCostDTO> selectMonthTransit(String date) {
		LOG.trace("CalculateCostDAO selectMonthTransit() start");	
		String sql = "select distinct C.c_iTel, C.c_iDate, C.c_tCost, T.t_id, T.t_name from calculate_cost as C" + 
				" inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate" + 
				" inner join trans_company as T on T.t_id=I.i_tId" + 
				" where C.c_iDate like '%" + date + "%'" +
				" order by C.c_iDate desc;";
		PreparedStatement pStmt = null;
		List<CalculateCostDTO> iList = new ArrayList<CalculateCostDTO>();

		try {
			pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				CalculateCostDTO c = new CalculateCostDTO();
				c.setC_iTel(rs.getString(1));
				c.setC_iDate(rs.getString(2).substring(0, 16));
				c.setC_tCost(rs.getInt(3));
				c.setC_comId(rs.getInt(4));
				c.setC_comName(rs.getString(5));
				iList.add(c);
			}
		} catch (Exception e) {
			LOG.trace("CalculateCostDAO selectMonthTransit() Exception ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOG.trace("CalculateCostDAO selectMonthTransit() success");
		return iList;
	}
	
	/* 관리자 : 매출 총이익 가져오는 부분(xx년도 xx월) */
	public int totalSalesChart (int year, int month) {
		LOG.trace("CalculateCostDAO totalSalesChart() start");	
		String sql = "select sum(c_sCost - c_oCost - c_tCost) from calculate_cost" + 
				" where year(c_iDate) = " + year + 
				" and month(c_iDate) = " + month + ";";
		PreparedStatement pStmt = null;
		int temp = 0;
		try {
			pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				temp = rs.getInt(1);
			}
		} catch (Exception e) {
			LOG.trace("CalculateCostDAO totalSalesChart() Exception ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOG.trace("CalculateCostDAO totalSalesChart() success");
		return temp;
	}
	
	/* ***************************************************************************** */
	/* ***************************************************************************** */
	
	/* 관리자 : 월단위 판매내역(쇼핑몰) 페이지 넘기는 부분 */
	public List<CalculateCostDTO> selectShoppingPage(int page) {
		LOG.trace("CalculateCostDAO selectShoppingPage() start");	
		int offset = 0;
		String query = null;
		if (page == 0) {	// page가 0이면 모든 데이터를 보냄
			query = "select distinct C.c_iTel, C.c_iDate, C.c_sCost, I.i_sId, S.s_name from calculate_cost as C" + 
					" inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate" + 
					" inner join shopping_mall as S on S.s_id=I.i_sId" + 
					" order by C.c_iDate desc;";
		} else {			// page가 0이 아니면 해당 페이지 데이터만 보냄
			query = "select distinct C.c_iTel, C.c_iDate, C.c_sCost, I.i_sId, S.s_name from calculate_cost as C" + 
					" inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate" + 
					" inner join shopping_mall as S on S.s_id=I.i_sId" + 
					" order by C.c_iDate desc limit ?, 10;";
			offset = (page - 1) * 10;
		}
		PreparedStatement pStmt = null;
		List<CalculateCostDTO> ipList = new ArrayList<CalculateCostDTO>();
		try {
			pStmt = conn.prepareStatement(query);
			if (page != 0)
				pStmt.setInt(1, offset);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {	
				CalculateCostDTO c = new CalculateCostDTO();
				c.setC_iTel(rs.getString(1));
				c.setC_iDate(rs.getString(2).substring(0, 16));
				c.setC_sCost(rs.getInt(3));
				c.setC_comId(rs.getInt(4));
				c.setC_comName(rs.getString(5));
				ipList.add(c);
			}
			rs.close();
		} catch (Exception e) {
			LOG.trace("CalculateCostDAO selectShoppingPage() Exception ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed()) 
					pStmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		LOG.trace("CalculateCostDAO selectShoppingPage() success");
		return ipList;
	}
 
	/* 관리자 : 월단위 판매내역(쇼핑몰) 페이지 카운트 세는 부분 */
	public int getShoppingCount() {
		LOG.trace("CalculateCostDAO getShoppingCount() start");	
		String query = "select count(distinct c.c_iTel, c.c_iDate) from calculate_cost as c" + 
				" inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate" + 
				" inner join shopping_mall as S on S.s_id=I.i_sId;";
		PreparedStatement pStmt = null;
		int count = 0;
		try {
			pStmt = conn.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {				
				count = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			LOG.trace("CalculateCostDAO getShoppingCount() Exception ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed()) 
					pStmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		LOG.trace("CalculateCostDAO getShoppingCount() success");
		return count;
	}
	
	/* 관리자 : 월단위 판매내역(쇼핑몰) 페이지 넘기는 부분 (선택한 월만) */
	public List<CalculateCostDTO> selectShoppingPageSelectMonth(String date, int page) {
		LOG.trace("CalculateCostDAO selectShoppingPageSelectMonth() start");	
		int offset = 0;
		String query = null;
		if (page == 0) {	// page가 0이면 모든 데이터를 보냄
			query = "select distinct C.c_iTel, C.c_iDate, C.c_sCost, I.i_sId, S.s_name from calculate_cost as C" + 
					" inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate" + 
					" inner join shopping_mall as S on S.s_id=I.i_sId" + 
					" where C.c_iDate like '%" + date + "%'" + 
					" order by C.c_iDate desc;";
		} else {			// page가 0이 아니면 해당 페이지 데이터만 보냄
			query = "select distinct C.c_iTel, C.c_iDate, C.c_sCost, I.i_sId, S.s_name from calculate_cost as C" + 
					" inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate" + 
					" inner join shopping_mall as S on S.s_id=I.i_sId" + 
					" where C.c_iDate like '%" + date + "%'" + 
					" order by C.c_iDate desc limit ?, 10;";
			offset = (page - 1) * 10;
		}
		PreparedStatement pStmt = null;
		List<CalculateCostDTO> ipList = new ArrayList<CalculateCostDTO>();
		try {
			pStmt = conn.prepareStatement(query);
			if (page != 0)
				pStmt.setInt(1, offset);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {	
				CalculateCostDTO c = new CalculateCostDTO();
				c.setC_iTel(rs.getString(1));
				c.setC_iDate(rs.getString(2).substring(0, 16));
				c.setC_sCost(rs.getInt(3));
				c.setC_comId(rs.getInt(4));
				c.setC_comName(rs.getString(5));
				ipList.add(c);
			}
			rs.close();
		} catch (Exception e) {
			LOG.trace("CalculateCostDAO selectShoppingPageSelectMonth() Exception ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed()) 
					pStmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		LOG.trace("CalculateCostDAO selectShoppingPageSelectMonth() success");
		return ipList;
	}
	
	/* 관리자 : 월단위 판매내역(쇼핑몰) 페이지 카운트 세는 부분 (선택한 월만) */
	public int getCountShoppingListSelectMonth(String date) {
		LOG.trace("CalculateCostDAO getCountShoppingListSelectMonth() start");	
		String query = "select count(distinct C.c_iTel, C.c_iDate) from calculate_cost as C" + 
				" inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate" + 
				" inner join shopping_mall as S on S.s_id=I.i_sId" + 
				" where C.c_iDate like '%" + date + "%'" + 
				" order by C.c_iDate desc;";
		LOG.trace("date: " + date);
		PreparedStatement pStmt = null;
		int count = 0;
		try {
			pStmt = conn.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {				
				count = rs.getInt(1);
			}
			//rs.close();
		} catch (Exception e) {
			LOG.trace("CalculateCostDAO getCountShoppingListSelectMonth() Exception ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed()) 
					pStmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		LOG.trace("CalculateCostDAO getCountShoppingListSelectMonth() success");
		return count;
	}
	

	/* ***************************************************************************** */
	/* ***************************************************************************** */
	
	
	/* 관리자 : 월단위 구매내역(구매처) 페이지 넘기는 부분 */
	public List<CalculateCostDTO> selectOrderPage(int page) {
		LOG.trace("CalculateCostDAO selectOrderPage() start");	
		int offset = 0;
		String query = null;
		if (page == 0) {	// page가 0이면 모든 데이터를 보냄
			query = "select distinct C.c_iTel, C.c_iDate, C.c_oCost, O.o_id, O.o_name from calculate_cost as C" + 
					" inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate" + 
					" inner join product as P on P.p_id=I.i_pId" + 
					" inner join order_company as O on O.o_id=P.p_oId" + 
					" order by C.c_iDate desc;";
		} else {			// page가 0이 아니면 해당 페이지 데이터만 보냄
			query = "select distinct C.c_iTel, C.c_iDate, C.c_oCost, O.o_id, O.o_name from calculate_cost as C" + 
					" inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate" + 
					" inner join product as P on P.p_id=I.i_pId" + 
					" inner join order_company as O on O.o_id=P.p_oId" + 
					" order by C.c_iDate desc limit ?, 10;";
			offset = (page - 1) * 10;
		}
		PreparedStatement pStmt = null;
		List<CalculateCostDTO> opList = new ArrayList<CalculateCostDTO>();
		try {
			pStmt = conn.prepareStatement(query);
			if (page != 0)
				pStmt.setInt(1, offset);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {	
				CalculateCostDTO c = new CalculateCostDTO();
				c.setC_iTel(rs.getString(1));
				c.setC_iDate(rs.getString(2).substring(0, 16));
				c.setC_oCost(rs.getInt(3));
				c.setC_comId(rs.getInt(4));
				c.setC_comName(rs.getString(5));
				opList.add(c);
			}
			rs.close();
		} catch (Exception e) {
			LOG.trace("CalculateCostDAO selectOrderPage() Exception ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed()) 
					pStmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		LOG.trace("CalculateCostDAO selectOrderPage() success");
		return opList;
	}

	/* 관리자 : 월단위 구매내역(구매처) 페이지 카운트 세는 부분 */
	public int getOrderCount() {
		LOG.trace("CalculateCostDAO getOrderCount() start");	
		String query = "select count(distinct C.c_iTel, C.c_iDate) from calculate_cost as C"+ 
				" inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate"+ 
				" inner join product as P on P.p_id=I.i_pId"+ 
				" inner join order_company as O on O.o_id=P.p_oId;";
		PreparedStatement pStmt = null;
		int count = 0;
		try {
			pStmt = conn.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {				
				count = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			LOG.trace("CalculateCostDAO getOrderCount() Exception ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed()) 
					pStmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		LOG.trace("CalculateCostDAO getOrderCount() success");
		return count;
	}
	
	
	/* 관리자 : 월단위 구매내역(쇼핑몰) 페이지 넘기는 부분 (선택한 월만) */
	public List<CalculateCostDTO> selectOrderPageSelectMonth(String date, int page) {
		LOG.trace("CalculateCostDAO selectOrderPageSelectMonth() start");	
		int offset = 0;
		String query = null;
		if (page == 0) {	// page가 0이면 모든 데이터를 보냄
			query = "select distinct C.c_iTel, C.c_iDate, C.c_oCost, O.o_id, O.o_name from calculate_cost as C" + 
					" inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate" + 
					" inner join product as P on P.p_id=I.i_pId" + 
					" inner join order_company as O on O.o_id=P.p_oId" + 
					" where C.c_iDate like '%" + date + "%'" + 
					" order by C.c_iDate desc;";
		} else {			// page가 0이 아니면 해당 페이지 데이터만 보냄
			query = "select distinct C.c_iTel, C.c_iDate, C.c_oCost, O.o_id, O.o_name from calculate_cost as C" + 
					" inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate" + 
					" inner join product as P on P.p_id=I.i_pId" + 
					" inner join order_company as O on O.o_id=P.p_oId" + 
					" where C.c_iDate like '%" + date + "%'" + 
					" order by C.c_iDate desc limit ?, 10;";
			offset = (page - 1) * 10;
		}
		PreparedStatement pStmt = null;
		List<CalculateCostDTO> ipList = new ArrayList<CalculateCostDTO>();
		try {
			pStmt = conn.prepareStatement(query);
			if (page != 0)
				pStmt.setInt(1, offset);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {	
				CalculateCostDTO c = new CalculateCostDTO();
				c.setC_iTel(rs.getString(1));
				c.setC_iDate(rs.getString(2).substring(0, 16));
				c.setC_oCost(rs.getInt(3));
				c.setC_comId(rs.getInt(4));
				c.setC_comName(rs.getString(5));
				ipList.add(c);
			}
			rs.close();
		} catch (Exception e) {
			LOG.trace("CalculateCostDAO selectOrderPageSelectMonth() Exception ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed()) 
					pStmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		LOG.trace("CalculateCostDAO selectOrderPageSelectMonth() success");
		return ipList;
	}
	
	/* 관리자 : 월단위 구매내역(쇼핑몰) 페이지 카운트 세는 부분 (선택한 월만) */
	public int getCountOrderListSelectMonth(String date) {
		LOG.trace("CalculateCostDAO getCountOrderListSelectMonth() start");	
		String query = "select count(distinct C.c_iTel, C.c_iDate) from calculate_cost as C" + 
				" inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate" + 
				" inner join product as P on P.p_id=I.i_pId" + 
				" inner join order_company as O on O.o_id=P.p_oId" + 
				" where C.c_iDate like '%" + date + "%'" + 
				" order by C.c_iDate desc;";
		PreparedStatement pStmt = null;
		int count = 0;
		try {
			pStmt = conn.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {				
				count = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			LOG.trace("CalculateCostDAO getCountOrderListSelectMonth() Exception ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed()) 
					pStmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		LOG.trace("CalculateCostDAO getCountOrderListSelectMonth() success");
		return count;
	}
	
	
	/* ***************************************************************************** */
	/* ***************************************************************************** */
	
	
	/* 관리자 : 월단위 발주내역(운송 회사) 페이지 넘기는 부분 */
	public List<CalculateCostDTO> selectTransitPage(int page) {
		LOG.trace("CalculateCostDAO selectTransPage() start");	
		int offset = 0;
		String query = null;
		if (page == 0) {	// page가 0이면 모든 데이터를 보냄
			query = "select distinct C.c_iTel, C.c_iDate, C.c_tCost, T.t_id, T.t_name from calculate_cost as C" + 
					" inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate" + 
					" inner join trans_company as T on T.t_id=I.i_tId" + 
					" order by C.c_iDate desc;";
		} else {			// page가 0이 아니면 해당 페이지 데이터만 보냄
			query = "select distinct C.c_iTel, C.c_iDate, C.c_tCost, T.t_id, T.t_name from calculate_cost as C" + 
					" inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate" + 
					" inner join trans_company as T on T.t_id=I.i_tId" + 
					" order by C.c_iDate desc limit ?, 10;";
			offset = (page - 1) * 10;
		}
		PreparedStatement pStmt = null;
		List<CalculateCostDTO> tpList = new ArrayList<CalculateCostDTO>();
		try {
			pStmt = conn.prepareStatement(query);
			if (page != 0)
				pStmt.setInt(1, offset);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {	
				CalculateCostDTO c = new CalculateCostDTO();
				c.setC_iTel(rs.getString(1));
				c.setC_iDate(rs.getString(2).substring(0, 16));
				c.setC_tCost(rs.getInt(3));
				c.setC_comId(rs.getInt(4));
				c.setC_comName(rs.getString(5));
				tpList.add(c);
			}
			rs.close();
		} catch (Exception e) {
			LOG.trace("CalculateCostDAO selectTransPage() Exception ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed()) 
					pStmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		LOG.trace("CalculateCostDAO selectTransPage() success");
		return tpList;
	}

	/* 관리자 : 월단위 발주내역(운송 회사) 페이지 카운트 세는 부분 */
	public int getTransitCount() {
		LOG.trace("CalculateCostDAO getOrderCount() start");	
		String query = "select count(distinct C.c_iTel, C.c_iDate) from calculate_cost as C" + 
				" inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate" + 
				" inner join trans_company as T on T.t_id=I.i_tId;";
		PreparedStatement pStmt = null;
		int count = 0;
		try {
			pStmt = conn.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {				
				count = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			LOG.trace("CalculateCostDAO getTransCount() Exception ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed()) 
					pStmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		LOG.trace("CalculateCostDAO getTransCount() success");
		return count;
	}
	
	/* 관리자 : 월단위 발주내역(운송 회사) 페이지 넘기는 부분 (선택한 월만) */
	public List<CalculateCostDTO> selectTransitPageSelectMonth(String date, int page) {
		LOG.trace("CalculateCostDAO selectTransitPageSelectMonth() start");	
		int offset = 0;
		String query = null;
		if (page == 0) {	// page가 0이면 모든 데이터를 보냄
			query = "select distinct C.c_iTel, C.c_iDate, C.c_tCost, T.t_id, T.t_name from calculate_cost as C" + 
					" inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate" + 
					" inner join trans_company as T on T.t_id=I.i_tId" + 
					" where C.c_iDate like '%" + date + "%'" + 
					" order by C.c_iDate desc;";
		} else {			// page가 0이 아니면 해당 페이지 데이터만 보냄
			query = "select distinct C.c_iTel, C.c_iDate, C.c_tCost, T.t_id, T.t_name from calculate_cost as C" + 
					" inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate" + 
					" inner join trans_company as T on T.t_id=I.i_tId" + 
					" where C.c_iDate like '%" + date + "%'" + 
					" order by C.c_iDate desc limit ?, 10;";
			offset = (page - 1) * 10;
		}
		PreparedStatement pStmt = null;
		List<CalculateCostDTO> ipList = new ArrayList<CalculateCostDTO>();
		try {
			pStmt = conn.prepareStatement(query);
			if (page != 0)
				pStmt.setInt(1, offset);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {	
				CalculateCostDTO c = new CalculateCostDTO();
				c.setC_iTel(rs.getString(1));
				c.setC_iDate(rs.getString(2).substring(0, 16));
				c.setC_tCost(rs.getInt(3));
				c.setC_comId(rs.getInt(4));
				c.setC_comName(rs.getString(5));
				ipList.add(c);
			}
			rs.close();
		} catch (Exception e) {
			LOG.trace("CalculateCostDAO selectTransitPageSelectMonth() Exception ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed()) 
					pStmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		LOG.trace("CalculateCostDAO selectTransitPageSelectMonth() success");
		return ipList;
	}
	
	/* 관리자 : 월단위 발주내역(운송 회사) 페이지 카운트 세는 부분 (선택한 월만) */
	public int getCountTransitListSelectMonth(String date) {
		LOG.trace("CalculateCostDAO getCountTransitListSelectMonth() start");	
		String query = "select count(distinct C.c_iTel, C.c_iDate) from calculate_cost as C" + 
				" inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate" + 
				" inner join trans_company as T on T.t_id=I.i_tId" + 
				" where C.c_iDate like '%" + date + "%'" + 
				" order by C.c_iDate desc;";
		PreparedStatement pStmt = null;
		int count = 0;
		try {
			pStmt = conn.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {				
				count = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			LOG.trace("CalculateCostDAO getCountTransitListSelectMonth() Exception ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed()) 
					pStmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		LOG.trace("CalculateCostDAO getCountTransitListSelectMonth() success");
		return count;
	}
	
}
