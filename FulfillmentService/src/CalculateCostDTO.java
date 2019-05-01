
public class CalculateCostDTO {
	private int c_iId;
	private String c_iTel;
	private String c_iDate;
	private int c_sId;
	private int c_tId;

	public CalculateCostDTO(int c_iId, String c_iTel, String c_iDate, int c_sId, int c_tId) {
		this.c_iId = c_iId;
		this.c_iTel = c_iTel;
		this.c_iDate = c_iDate;
		this.c_sId = c_sId;
		this.c_tId = c_tId;
	}

	public CalculateCostDTO() {
	}

	public int getC_iId() {
		return c_iId;
	}

	public void setC_iId(int c_iId) {
		this.c_iId = c_iId;
	}

	public String getC_iTel() {
		return c_iTel;
	}

	public void setC_iTel(String c_iTel) {
		this.c_iTel = c_iTel;
	}

	public String getC_iDate() {
		return c_iDate;
	}

	public void setC_iDate(String c_iDate) {
		this.c_iDate = c_iDate;
	}

	public int getC_sId() {
		return c_sId;
	}

	public void setC_sId(int c_sId) {
		this.c_sId = c_sId;
	}

	public int getC_tId() {
		return c_tId;
	}

	public void setC_tId(int c_tId) {
		this.c_tId = c_tId;
	}

	@Override
	public String toString() {
		return "CalculateCostDTO [c_iId=" + c_iId + ", c_iTel=" + c_iTel + ", c_iDate=" + c_iDate + ", c_sId=" + c_sId
				+ ", c_tId=" + c_tId + "]";
	}

}
