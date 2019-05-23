package calculatorTest;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.*;
import org.junit.*;

import calculator.CalculateCostDAO;
import calculator.CalculateCostDTO;

public class CalculateCostDAOTest {
	private static CalculateCostDAO cDao = null;
	private static CalculateCostDTO cDto = null;
	
	/**
	 * https://www.mkyong.com/unittest/junit-how-to-test-a-list/
	 * */
	
	@BeforeClass
	public static void beforeClassTest() {
		
	}
	
	@Before
	public void beforeTest() {
		cDao = new CalculateCostDAO();
		cDto = new CalculateCostDTO();
		System.out.println("beforeTest()");
	}
	
	@Test
	public void selectMonthSalesTest() {
		ArrayList<CalculateCostDTO> actual = new ArrayList<>(cDao.selectMonthSales("2018-01"));
		CalculateCostDTO cDto1 = new CalculateCostDTO("010-8781-5799", "2018-01-27 00:02", 22320, 0, 0, 30001, "CI몰");
		CalculateCostDTO cDto2 = new CalculateCostDTO("010-1726-9876", "2018-01-20 15:31", 45200, 0, 0, 30003, "쿠팽");
		CalculateCostDTO cDto3 = new CalculateCostDTO("010-7678-7807", "2018-01-03 23:25", 20890, 0, 0, 30002, "G-마트");
		ArrayList<CalculateCostDTO> expected = new ArrayList<>(Arrays.asList(cDto1, cDto2, cDto3));
		assertThat(actual, is(expected));
		System.out.println("selectMonthSalesTest()");
	}
	
	@Test
	public void selectMonthOrderTest() {
		ArrayList<CalculateCostDTO> actual = new ArrayList<>(cDao.selectMonthOrder("2018-01"));
		CalculateCostDTO cDto1 = new CalculateCostDTO("010-8781-5799", "2018-01-27 00:02", 0, 11200, 0, 70003, "올리브올드");
		CalculateCostDTO cDto2 = new CalculateCostDTO("010-1726-9876", "2018-01-20 15:31", 0, 32000, 0, 70005, "스위트홈");
		CalculateCostDTO cDto3 = new CalculateCostDTO("010-7678-7807", "2018-01-03 23:25", 0, 9900, 0, 70004, "오렌지씨");
		ArrayList<CalculateCostDTO> expected = new ArrayList<>(Arrays.asList(cDto1, cDto2, cDto3));
		assertThat(actual, is(expected));
		System.out.println("selectMonthOrderTest()");
	}
	
	@Test
	public void selectMonthTransitTest() {
		ArrayList<CalculateCostDTO> actual = new ArrayList<>(cDao.selectMonthTransit("2018-01"));
		CalculateCostDTO cDto1 = new CalculateCostDTO("010-8781-5799", "2018-01-27 00:02", 0, 0, 10000, 50004, "서부물류");
		CalculateCostDTO cDto2 = new CalculateCostDTO("010-1726-9876", "2018-01-20 15:31", 0, 0, 10000, 50001, "경기물류");
		CalculateCostDTO cDto3 = new CalculateCostDTO("010-7678-7807", "2018-01-03 23:25", 0, 0, 10000, 50003, "영남물류");
		ArrayList<CalculateCostDTO> expected = new ArrayList<>(Arrays.asList(cDto1, cDto2, cDto3));
		assertThat(actual, is(expected));
		System.out.println("selectMonthTransitTest()");
	}
	
	@Test
	public void totalSalesChartTest() {
		int actual = cDao.totalSalesChart(2019, 05);
		assertEquals(38390, actual);
		System.out.println("totalSalesChartTest()");
	}
	
	@Test
	public void selectShoppingPageSelectMonthTest() {
		ArrayList<CalculateCostDTO> actual = new ArrayList<>(cDao.selectShoppingPageSelectMonth("2019-05", 1));
		CalculateCostDTO cDto1 = new CalculateCostDTO("010-1111-2546", "2019-05-17 18:31", 19900, 0, 0, 30001, "CI몰");
		CalculateCostDTO cDto2 = new CalculateCostDTO("010-6666-2670", "2019-05-17 09:25", 35300, 0, 0, 30003, "쿠팽");
		CalculateCostDTO cDto3 = new CalculateCostDTO("010-1313-8393", "2019-05-17 08:30", 21990, 0, 0, 30003, "쿠팽");
		CalculateCostDTO cDto4 = new CalculateCostDTO("010-1111-2546", "2019-05-16 19:21", 35300, 0, 0, 30001, "CI몰");
		CalculateCostDTO cDto5 = new CalculateCostDTO("010-1111-2546", "2019-05-16 18:31", 19900, 0, 0, 30001, "CI몰");
		CalculateCostDTO cDto6 = new CalculateCostDTO("010-6666-2670", "2019-05-16 17:25", 21990, 0, 0, 30003, "쿠팽");
		CalculateCostDTO cDto7 = new CalculateCostDTO("010-6666-2670", "2019-05-16 09:25", 35300, 0, 0, 30003, "쿠팽");
		CalculateCostDTO cDto8 = new CalculateCostDTO("010-1313-8393", "2019-05-16 08:30", 21990, 0, 0, 30003, "쿠팽");
		CalculateCostDTO cDto9 = new CalculateCostDTO("010-6666-7777", "2019-05-13 16:58", 35190, 0, 0, 30003, "쿠팽");
		CalculateCostDTO cDto10 = new CalculateCostDTO("010-1111-2222", "2019-05-08 15:31", 29800, 0, 0, 30001, "CI몰");
		ArrayList<CalculateCostDTO> expected = new ArrayList<>(Arrays.asList(cDto1, cDto2, cDto3, cDto4, cDto5, cDto6, cDto7, cDto8, cDto9, cDto10));
		assertThat(actual, is(expected));
		System.out.println("selectShoppingPageSelectMonthTest()");
		
	}
	
	@Test
	public void getCountShoppingListSelectMonthTest() {
		int actual = cDao.getCountShoppingListSelectMonth("2019-05");
		assertEquals(20, actual);
		System.out.println("getCountShoppingListSelectMonthTest()");
	}
	
	@After
	public void afterTest() {
		System.out.println("afterTest()\n");
	}
	
	@AfterClass
	public static void afterClassTest() {
		cDao.close();
		System.out.println("AfterClassTest()");
	}
	
}
