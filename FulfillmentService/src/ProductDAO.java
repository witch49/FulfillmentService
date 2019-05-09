import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductDAO {
	public static final int ID_PASSWORD_MATCH = 1;
	public static final int ID_DOES_NOT_EXIST = 2;
	public static final int PASSWORD_IS_WRONG = 3;
	public static final int DATABASE_ERROR = -1;
	private static final Logger LOG = LoggerFactory.getLogger(ProductDAO.class);

	private Connection conn;
	private static final String USERNAME = "javauser";
	private static final String PASSWORD = "javapass";
	private static final String URL = "jdbc:mysql://localhost:3306/fulfillment?verifyServerCertificate=false&useSSL=false";
	
	public ProductDAO() {
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
	
	/* 관리자 - 재고 목록 화면 : 책 카테고리 출력 부분 */
	public List<ProductDTO> selectAllBook() {
		LOG.trace("ProductDAO selectAllBook() start");
		String sql = "select * from product where p_img like '%book%';";
		PreparedStatement pStmt = null;
		List<ProductDTO> pList = new ArrayList<ProductDTO>();

		try {
			pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				ProductDTO p = new ProductDTO();
				p.setpId(rs.getInt(1));
				p.setpName(rs.getString(2));
				p.setpImg(rs.getString(3));
				p.setpPrice(rs.getInt(4));
				p.setpAmount(rs.getInt(5));
				p.setP_oId(rs.getInt(6));
				pList.add(p);
			}
		} catch (Exception e) {
			LOG.trace("ProductDAO selectAllBook() ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOG.trace("ProductDAO selectAllBook() success");
		return pList;
	}
	
	/* 관리자 - 재고 목록 화면 : 애완용품 카테고리 출력 부분 */
	public List<ProductDTO> selectAllAnimalGoods() {
		LOG.trace("ProductDAO selectAllAnimalGoods() start");
		String sql = "select * from product where p_img like '%animal%';";
		PreparedStatement pStmt = null;
		List<ProductDTO> pList = new ArrayList<ProductDTO>();

		try {
			pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				ProductDTO p = new ProductDTO();
				p.setpId(rs.getInt(1));
				p.setpName(rs.getString(2));
				p.setpImg(rs.getString(3));
				p.setpPrice(rs.getInt(4));
				p.setpAmount(rs.getInt(5));
				p.setP_oId(rs.getInt(6));
				pList.add(p);
			}
		} catch (Exception e) {
			LOG.trace("ProductDAO selectAllAnimalGoods() ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOG.trace("ProductDAO selectAllAnimalGoods() success");
		return pList;
	}
	
	/* 관리자 - 재고 목록 화면 : 화장품 카테고리 출력 부분 */
	public List<ProductDTO> selectAllCosmetic() {
		LOG.trace("ProductDAO selectAllCosmetic() start");
		String sql = "select * from product where p_img like '%cosmetic%';";
		PreparedStatement pStmt = null;
		List<ProductDTO> pList = new ArrayList<ProductDTO>();

		try {
			pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				ProductDTO p = new ProductDTO();
				p.setpId(rs.getInt(1));
				p.setpName(rs.getString(2));
				p.setpImg(rs.getString(3));
				p.setpPrice(rs.getInt(4));
				p.setpAmount(rs.getInt(5));
				p.setP_oId(rs.getInt(6));
				pList.add(p);
			}
		} catch (Exception e) {
			LOG.trace("ProductDAO selectAllCosmetic() ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOG.trace("ProductDAO selectAllCosmetic() success");
		return pList;
	}
	
	
	/* 관리자 - 재고 목록 화면 : 과일 카테고리 출력 부분 */
	public List<ProductDTO> selectAllFruit() {
		LOG.trace("ProductDAO selectAllFruit() start");
		String sql = "select * from product where p_img like '%fruit%';";
		PreparedStatement pStmt = null;
		List<ProductDTO> pList = new ArrayList<ProductDTO>();

		try {
			pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				ProductDTO p = new ProductDTO();
				p.setpId(rs.getInt(1));
				p.setpName(rs.getString(2));
				p.setpImg(rs.getString(3));
				p.setpPrice(rs.getInt(4));
				p.setpAmount(rs.getInt(5));
				p.setP_oId(rs.getInt(6));
				pList.add(p);
			}
		} catch (Exception e) {
			LOG.trace("ProductDAO selectAllFruit() ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOG.trace("ProductDAO selectAllFruit() success");
		return pList;
	}
	
	
	/* 관리자 - 재고 목록 화면 : 과일 카테고리 출력 부분 */
	public List<ProductDTO> selectAllHomeAppliances() {
		LOG.trace("ProductDAO selectAllHomeAppliances() start");
		String sql = "select * from product where p_img like '%homeappliances%';";
		PreparedStatement pStmt = null;
		List<ProductDTO> pList = new ArrayList<ProductDTO>();

		try {
			pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				ProductDTO p = new ProductDTO();
				p.setpId(rs.getInt(1));
				p.setpName(rs.getString(2));
				p.setpImg(rs.getString(3));
				p.setpPrice(rs.getInt(4));
				p.setpAmount(rs.getInt(5));
				p.setP_oId(rs.getInt(6));
				pList.add(p);
			}
		} catch (Exception e) {
			LOG.trace("ProductDAO selectAllHomeAppliances() ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOG.trace("ProductDAO selectAllHomeAppliances() success");
		return pList;
	}

	
	/* 관리자 - 발주 요청 화면 : 모든 item 출력 부분 */
	public List<ProductDTO> selectAllItems() {
		LOG.trace("ProductDAO selectAllItems() start");
		String sql = "select P.p_id, P.p_name, P.p_price, P.p_amount, P.p_oId, O.o_name from product as P" + 
				" inner join order_company as O on P.p_oId=O.o_id;";
		PreparedStatement pStmt = null;
		List<ProductDTO> pList = new ArrayList<ProductDTO>();

		try {
			pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				ProductDTO p = new ProductDTO();
				p.setpId(rs.getInt(1));
				p.setpName(rs.getString(2));
				p.setpPrice(rs.getInt(3));
				p.setpAmount(rs.getInt(4));
				p.setP_oId(rs.getInt(5));
				p.setP_oName(rs.getString(6));
				pList.add(p);
			}
		} catch (Exception e) {
			LOG.trace("ProductDAO selectAllItems() ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOG.trace("ProductDAO selectAllItems() success");
		return pList;
	}
	
	/* 관리자 - 발주 요청 상세화면 : 모든 item 출력 부분 */
	public List<ProductDTO> selectAllItemsDetail(int pId) {
		LOG.trace("ProductDAO selectAllItemsDetail() start");
		String sql = "select P.p_id, P.p_name, P.p_price, P.p_amount, P.p_oId, O.o_name from product as P" + 
				" inner join order_company as O on P.p_oId=O.o_id where p_id=?;";
		PreparedStatement pStmt = null;
		List<ProductDTO> pList = new ArrayList<ProductDTO>();

		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, pId);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				ProductDTO p = new ProductDTO();
				p.setpId(rs.getInt(1));
				p.setpName(rs.getString(2));
				p.setpPrice(rs.getInt(3));
				p.setpAmount(rs.getInt(4));
				p.setP_oId(rs.getInt(5));
				p.setP_oName(rs.getString(6));
				pList.add(p);
			}
		} catch (Exception e) {
			LOG.trace("ProductDAO selectAllItemsDetail() ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOG.trace("ProductDAO selectAllItemsDetail() success");
		return pList;
	}
	
	
	/* 관리자 - 재고 목록 화면 : 아이템 클릭 시 상세 화면 출력 부분 */
	public List<ProductDTO> selectDetail(int pId) {
		LOG.trace("ProductDAO selectDetail() start");
		String sql = "select * from product where p_id=?;";
		PreparedStatement pStmt = null;
		List<ProductDTO> pList = new ArrayList<ProductDTO>();

		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, pId);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				ProductDTO p = new ProductDTO();
				p.setpId(rs.getInt(1));
				p.setpName(rs.getString(2));
				p.setpImg(rs.getString(3));
				p.setpPrice(rs.getInt(4));
				p.setpAmount(rs.getInt(5));
				p.setP_oId(rs.getInt(6));
				pList.add(p);
			}
		} catch (Exception e) {
			LOG.trace("ProductDAO selectDetail( ERROR");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOG.trace("ProductDAO selectDetail() success");
		return pList;
	}
	
	
	/* 관리자 - 발주 상세화면에서 발주하기 버튼 누르면 일어나는 부분 */
	public void SendOrderRequest(int orderAmount, int pId) {
		LOG.trace("ProductDAO SendOrderRequest() start");
		
		StringBuffer temp = new StringBuffer();
		Random rnd = new Random();
		for (int i = 0; i < 20; i++) {
			int rIndex = rnd.nextInt(3);
			switch (rIndex) {
			case 0: // a-z
				temp.append((char) ((int) (rnd.nextInt(26)) + 97));
				break;
			case 1: // A-Z
				temp.append((char) ((int) (rnd.nextInt(26)) + 65));
				break;
			case 2:// 0-9
				temp.append((rnd.nextInt(10)));
				break;
			}
		}
		
		String sql = "CREATE EVENT " + temp.toString() + 
				" ON SCHEDULE" + 
				" at (CURDATE() + INTERVAL 0 SECOND + INTERVAL 1 DAY + INTERVAL 10 HOUR)" + 
				" DO update product set p_amount = p_amount + ? where p_id = ?;";
		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, orderAmount);
			pStmt.setInt(2, pId);
			pStmt.executeUpdate();
	
		} catch (Exception e) {
			LOG.trace("ProductDAO SendOrderRequest() Exception ERROR!");
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOG.trace("ProductDAO SendOrderRequest() success");
	}
	
}