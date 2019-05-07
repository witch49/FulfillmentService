
public class CalculateCostDTO {
	private int c_iId;
	private String c_iTel;
	private String c_iDate;
	private int c_sCost;
	private int c_oCost;
	private int c_tCost;

	public CalculateCostDTO(int c_iId, String c_iTel, String c_iDate, int c_sCost, int c_oCost, int c_tCost) {
		this.c_iId = c_iId;
		this.c_iTel = c_iTel;
		this.c_iDate = c_iDate;
		this.c_sCost = c_sCost;
		this.c_oCost = c_oCost;
		this.c_tCost = c_tCost;
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

	public int getC_sCost() {
		return c_sCost;
	}

	public void setC_sCost(int c_sCost) {
		this.c_sCost = c_sCost;
	}

	public int getC_oCost() {
		return c_oCost;
	}

	public void setC_oCost(int c_oCost) {
		this.c_oCost = c_oCost;
	}

	public int getC_tCost() {
		return c_tCost;
	}

	public void setC_tCost(int c_tCost) {
		this.c_tCost = c_tCost;
	}

	@Override
	public String toString() {
		return "CalculateCostDTO [c_iId=" + c_iId + ", c_iTel=" + c_iTel + ", c_iDate=" + c_iDate + ", c_sCost="
				+ c_sCost + ", c_oCost=" + c_oCost + ", c_tCost=" + c_tCost + "]";
	}

}
