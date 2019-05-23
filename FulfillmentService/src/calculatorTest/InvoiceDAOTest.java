package calculatorTest;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.*;
import org.junit.*;

import calculator.InvoiceDAO;
import calculator.InvoiceDTO;

public class InvoiceDAOTest {
	private InvoiceDAO iDao = null;
	private InvoiceDTO iDto = null;
	
	@Before
	public void beforeTest() {
		iDao = new InvoiceDAO();
		iDto = new InvoiceDTO();
	}
	
	@Test
	public void selectInvoiceDetailAlltest() {
		ArrayList<InvoiceDTO> actual = new ArrayList<> (iDao.selectInvoiceDetailAll(100001));
		iDto = new InvoiceDTO(100001, "홍길동", "010-1111-2222", "수원시 장안구 정자1동", 2, "고려열전", 1, "2019-04-28 13:00", 30001, "CI몰", 50001, "경기물류", "Y", 11000);
		ArrayList<InvoiceDTO> expected = new ArrayList<> ((Arrays.asList(iDto)));
		assertThat(actual, is(expected));
	}
	
	@Test
	public void selectDateTransitComTest() {
		ArrayList<InvoiceDTO> actual = new ArrayList<> (iDao.selectDateTransitCom("2019-05-08", 50001));
		iDto.setiId(100019);
		iDto.setiConsigneeName("홍길동");
		iDto.setiConsigneeTel("010-1111-2222");
		iDto.setiOrderDate("2019-05-08 15:31");
		iDto.setCost(10000);
		ArrayList<InvoiceDTO> expected = new ArrayList<> ((Arrays.asList(iDto)));
		assertThat(actual, is(expected));
	}
	
	@Test
	public void selectNowMonthTransitComTest() {
		ArrayList<InvoiceDTO> actual = new ArrayList<> (iDao.selectNowMonthTransitCom(50001));
		InvoiceDTO iDto1 = new InvoiceDTO(100153, "홍아윤", "010-1111-2546", "2019-05-17 18:31", 10000);
		InvoiceDTO iDto2 = new InvoiceDTO(100150, "홍아윤", "010-1111-2546", "2019-05-16 19:21", 10000);
		InvoiceDTO iDto3 = new InvoiceDTO(100149, "홍아윤", "010-1111-2546", "2019-05-16 18:31", 10000);
		InvoiceDTO iDto4 = new InvoiceDTO(100019, "홍길동", "010-1111-2222", "2019-05-08 15:31", 10000);
		ArrayList<InvoiceDTO> expected = new ArrayList<> ((Arrays.asList(iDto1, iDto2, iDto3, iDto4)));
		assertThat(actual, is(expected));
	}
	
	@Test
	public void selectMonthTransitComTest() {
		ArrayList<InvoiceDTO> actual = new ArrayList<> (iDao.selectMonthTransitCom("2019-01", 50001));
		InvoiceDTO iDto1 = new InvoiceDTO(100054, "김코난", "010-1111-2452", "2019-01-16 15:31", 10000);
		InvoiceDTO iDto2 = new InvoiceDTO(100040, "송은이", "010-2121-3133", "2019-01-02 09:01", 10000);
		InvoiceDTO iDto3 = new InvoiceDTO(100039, "송은이", "010-2121-3133", "2019-01-01 04:00", 10000);
		ArrayList<InvoiceDTO> expected = new ArrayList<> ((Arrays.asList(iDto1, iDto2, iDto3)));
		assertThat(actual, is(expected));
	}
	

}
