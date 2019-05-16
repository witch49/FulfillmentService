import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileDAO {
	private static final Logger LOG = LoggerFactory.getLogger(FileDAO.class);
	private Connection conn;
	private static final String USERNAME = "javauser";
	private static final String PASSWORD = "javapass";
	private static final String URL = "jdbc:mysql://localhost:3306/fulfillment?verifyServerCertificate=false&useSSL=false";
	
	public FileDAO() {
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
	
	public void insertFileIntoTable(String path) {
		LOG.trace("insertFileIntoTable 시작(invoice table에 csv 파일 데이터 집어넣기)");
		LOG.trace("path - " + path);
		String sql = "load data local infile ?" + 
				" ignore into table invoice" + 
				" character set utf8" + 
				" fields terminated by ','" + 
				" lines terminated by '\\r\\n'" + 
				" ignore 1 rows" + 
				" (i_consigneeName, i_consigneeTel, i_consigneeAddr, i_pId, i_pName, i_amount, @var1, i_sId, i_tId)" + 
				" set i_orderDate = timestamp(str_to_date(@var1, '%Y-%m-%d %H:%i'));";
		PreparedStatement pStmt = null;

		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, path);
			pStmt.executeQuery();
			LOG.trace("insertFileIntoTable 성공");
		} catch (Exception e) {
			LOG.trace("FileDAO insertFileIntoTable() ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void orderInvoiceIdSet() {
		LOG.trace("orderInvoiceIdSet() start");
		String sql ="set @CNT = 100000;";
		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.executeQuery();
			LOG.trace("orderInvoiceIdSet() 성공");
		} catch (Exception e) {
			LOG.trace("orderInvoiceIdSet() ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void orderInvoiceIdUpdate() {
		LOG.trace("orderInvoiceIdUpdate() start");
		String sql = "update invoice set invoice.i_id = @CNT:=@CNT+1;";
		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.executeUpdate();
			LOG.trace("orderInvoiceIdUpdate() 성공");
		} catch (Exception e) {
			LOG.trace("orderInvoiceIdUpdate() ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
