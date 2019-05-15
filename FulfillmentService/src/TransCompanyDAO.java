import java.sql.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransCompanyDAO {
	public static final int ID_PASSWORD_MATCH = 1;
	public static final int ID_DOES_NOT_EXIST = 2;
	public static final int PASSWORD_IS_WRONG = 3;
	public static final int DATABASE_ERROR = -1;
	private static final Logger LOG = LoggerFactory.getLogger(TransCompanyDAO.class);

	private Connection conn;
	private static final String USERNAME = "javauser";
	private static final String PASSWORD = "javapass";
	private static final String URL = "jdbc:mysql://localhost:3306/fulfillment?verifyServerCertificate=false&useSSL=false";
	
	public TransCompanyDAO() {
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
	public int verifyLogin(int tId, String tPwd) {
		LOG.trace("TransCompanyDAO verifyLogin() start");
		String query = "select t_pwd from trans_company where t_id=?";
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		String password = "";
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setInt(1, tId);
			rs = pStmt.executeQuery();
			while (rs.next()) {
				password = rs.getString(1);
				if (tPwd.equals(password)) {
					LOG.trace("TransCompanyDAO verifyLogin() success - login success");
					return ID_PASSWORD_MATCH; // 로그인 성공
				} else {
					LOG.trace("TransCompanyDAO verifyLogin() success - password ERROR!!");
					return PASSWORD_IS_WRONG;
				}
			}
			LOG.trace("TransCompanyDAO verifyLogin() success - ID ERROR!!");
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
		LOG.trace("TransCompanyDAO verifyLogin() fail - DB ERROR!!");
		return DATABASE_ERROR;
	}
	
	/* 주어진 query에 해당하는 데이터 목록 출력 */
	public TransCompanyDTO selectOne(String query) {
		LOG.trace("TransCompanyDTO selectOne start");
		PreparedStatement pStmt= null;
		TransCompanyDTO member = new TransCompanyDTO();
		try {
			pStmt = conn.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				member.settId(rs.getInt(1));
				member.settPwd(rs.getString(2));
				member.settName(rs.getString(3));
			}
		} catch (Exception e) {
			LOG.trace("TransCompanyDTO selectOne() fail - DB ERROR!!");
	        e.printStackTrace();
	    } finally {
	        try {
	        	if (pStmt != null && !pStmt.isClosed())
	        		pStmt.close();
	        } catch (SQLException se) {
                se.printStackTrace();
            }
	    }
		LOG.trace("TransCompanyDTO selectOne() success");
		return member;
	}
	
	/* t_id 출력 */
	public TransCompanyDTO searchById(int tId) {
    	String query = "select * from trans_company where t_id=" + tId + ";";
    	TransCompanyDTO tDto = selectOne(query);
    	return tDto;
    }
	
}
