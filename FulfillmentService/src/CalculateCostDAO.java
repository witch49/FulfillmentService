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
	
	/* 1 - 관리자 : 월단위 판매내역(쇼핑몰) 확인하는 부분 */
	public List<CalculateCostDTO> selectAll() {
		LOG.trace("CalculateCostDAO selectAll() start");
		String sql = "select c_iId, c_iTel, c_iDate, c_sCost from calculate_cost;";
		
		//String sql = "select c_iId, c_i from calculate_cost order by id;";
		List<CalculateCostDTO> iList = selectCondition(sql);
		LOG.trace("CalculateCostDAO selectAll() end");
		return iList;
	}

	/* 주어진 query에 해당하는 데이터 목록 출력 */
	public List<CalculateCostDTO> selectCondition(String query) {
		LOG.trace("CalculateCostDAO selectCondition() start");
		PreparedStatement pStmt = null;
		List<CalculateCostDTO> list = new ArrayList<CalculateCostDTO>();

		try {
			pStmt = conn.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				CalculateCostDTO c = new CalculateCostDTO();
				c.setC_iId(rs.getInt(1));
				c.setC_iTel(rs.getString(2));
				c.setC_iDate(rs.getString(3).substring(0, 16));
				c.setC_sCost(rs.getInt(4));
				list.add(c);
			}
		} catch (Exception e) {
			LOG.trace("CalculateCostDAO selectCondition() ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOG.trace("CalculateCostDAO selectCondition() success");
		return list;
	}
	
	public void close() {
		try {
			if ( conn != null && !conn.isClosed())
				conn.close();
		} catch (SQLException E) {
			E.printStackTrace();
		}
	}
}
