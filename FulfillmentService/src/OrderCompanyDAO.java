import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderCompanyDAO {
	public static final int ID_PASSWORD_MATCH = 1;
	public static final int ID_DOES_NOT_EXIST = 2;
	public static final int PASSWORD_IS_WRONG = 3;
	public static final int DATABASE_ERROR = -1;
	private static final Logger LOG = LoggerFactory.getLogger(OrderCompanyDAO.class);

	private Connection conn;
	private static final String USERNAME = "javauser";
	private static final String PASSWORD = "javapass";
	private static final String URL = "jdbc:mysql://localhost:3306/fulfillment?verifyServerCertificate=false&useSSL=false";
	
	public OrderCompanyDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (conn != null && conn.isClosed())
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* 회원 로그인 (id, password 검증) */
	public int verifyLogin(int oId, String oPwd) {
		LOG.trace("OrderCompanyDAO verifyLogin() start");
		String query = "select o_pwd from order_company where o_id=?";
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		String password = "";
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setInt(1, oId);
			rs = pStmt.executeQuery();
			while (rs.next()) {
				password = rs.getString(1);
				if (oPwd.equals(password)) {
					LOG.trace("OrderCompanyDAO verifyLogin() success - login success");
					return ID_PASSWORD_MATCH; // 로그인 성공
				} else {
					LOG.trace("OrderCompanyDAO verifyLogin() success - password ERROR!!");
					return PASSWORD_IS_WRONG;
				}
			}
			LOG.trace("OrderCompanyDAO verifyLogin() success - ID ERROR!!");
			return ID_DOES_NOT_EXIST;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		LOG.trace("OrderCompanyDAO verifyLogin() fail - DB ERROR!!");
		return DATABASE_ERROR;
	}
	
	/* 주어진 query에 해당하는 데이터 목록 출력 */
	public OrderCompanyDTO selectOne(String query) {
		LOG.trace("OrderCompanyDTO selectOne start");
		PreparedStatement pStmt= null;
		OrderCompanyDTO member = new OrderCompanyDTO();
		try {
			pStmt = conn.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				member.setoId(rs.getInt(1));
				member.setoPwd(rs.getString(2));
				member.setoName(rs.getString(3));
			}
		} catch (Exception e) {
			LOG.trace("OrderCompanyDTO selectOne() fail - DB ERROR!!");
	        e.printStackTrace();
	    } finally {
	        try {
	        	if (pStmt != null && !pStmt.isClosed())
	        		pStmt.close();
	        } catch (SQLException se) {
                se.printStackTrace();
            }
	    }
		LOG.trace("OrderCompanyDTO selectOne() success");
		return member;
	}
	
	/* o_id 출력 */
	public OrderCompanyDTO searchById(int oId) {
    	String query = "select * from order_company where o_id=" + oId + ";";
    	OrderCompanyDTO oDto = selectOne(query);
    	return oDto;
    }
}
