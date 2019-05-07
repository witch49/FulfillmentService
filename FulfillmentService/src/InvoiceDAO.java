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
		String sql = "select i_id, i_consigneeName, i_orderDate, i_sId, i_tId, i_check from invoice;";
		
		try {
			pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				InvoiceDTO i = new InvoiceDTO();
				i.setiId(rs.getInt(1));
				i.setiConsigneeName(rs.getString(2));
				i.setiOrderDate(rs.getString(3).substring(0, 16));
				//LOG.trace("날짜"+rs.getString(3));
				i.setI_sId(rs.getInt(4));
				i.setI_tId(rs.getInt(5));
				i.setiCheck(rs.getString(6));
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
	
	public List<InvoiceDTO> selectInvoiceDatailAll(int iId) {
		LOG.trace("InvoiceDAO selectInvoiceDatailAll() start");
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
			LOG.trace("InvoiceDAO selectInvoiceDatailAll() ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOG.trace("InvoiceDAO selectInvoiceDatailAll() success");
		return invoiceDetailList;
	}
	
	
}
