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
	
	
	/* 관리자 : 월단위 발주내역(구매처) 확인하는 부분 */
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
				" select I.i_consigneeTel, I.i_orderDate, sum(P.p_price*I.i_amount), (sum(P.p_price*I.i_amount)*1.1 + 10000) from invoice as I" + 
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

}
