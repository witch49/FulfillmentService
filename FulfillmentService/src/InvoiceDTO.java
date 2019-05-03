
public class InvoiceDTO {
	private int iId;
	private String iConsigneeName;
	private String iConsigneeTel;
	private String iConsigneeAddr;
	private int i_pId;
	private String i_pName;
	private int iAmount;
	private String iOrderDate;
	private int i_sId;
	private int i_tId;
	private String iCheck;

	public InvoiceDTO(int iId, String iConsigneeName, String iConsigneeTel, String iConsigneeAddr, int i_pId,
			String i_pName, int iAmount, String iOrderDate, int i_sId, int i_tId, String iCheck) {
		this.iId = iId;
		this.iConsigneeName = iConsigneeName;
		this.iConsigneeTel = iConsigneeTel;
		this.iConsigneeAddr = iConsigneeAddr;
		this.i_pId = i_pId;
		this.i_pName = i_pName;
		this.iAmount = iAmount;
		this.iOrderDate = iOrderDate;
		this.i_sId = i_sId;
		this.i_tId = i_tId;
		this.iCheck = iCheck;
	}

	public InvoiceDTO() {
	}

	public int getiId() {
		return iId;
	}

	public void setiId(int iId) {
		this.iId = iId;
	}

	public String getiConsigneeName() {
		return iConsigneeName;
	}

	public void setiConsigneeName(String iConsigneeName) {
		this.iConsigneeName = iConsigneeName;
	}

	public String getiConsigneeTel() {
		return iConsigneeTel;
	}

	public void setiConsigneeTel(String iConsigneeTel) {
		this.iConsigneeTel = iConsigneeTel;
	}

	public String getiConsigneeAddr() {
		return iConsigneeAddr;
	}

	public void setiConsigneeAddr(String iConsigneeAddr) {
		this.iConsigneeAddr = iConsigneeAddr;
	}

	public int getI_pId() {
		return i_pId;
	}

	public void setI_pId(int i_pId) {
		this.i_pId = i_pId;
	}

	public String getI_pName() {
		return i_pName;
	}

	public void setI_pName(String i_pName) {
		this.i_pName = i_pName;
	}

	public int getiAmount() {
		return iAmount;
	}

	public void setiAmount(int iAmount) {
		this.iAmount = iAmount;
	}

	public String getiOrderDate() {
		return iOrderDate;
	}

	public void setiOrderDate(String iOrderDate) {
		this.iOrderDate = iOrderDate;
	}

	public int getI_sId() {
		return i_sId;
	}

	public void setI_sId(int i_sId) {
		this.i_sId = i_sId;
	}

	public int getI_tId() {
		return i_tId;
	}

	public void setI_tId(int i_tId) {
		this.i_tId = i_tId;
	}

	public String getiCheck() {
		return iCheck;
	}

	public void setiCheck(String iCheck) {
		this.iCheck = iCheck;
	}

	@Override
	public String toString() {
		return "InvoiceDTO [iId=" + iId + ", iConsigneeName=" + iConsigneeName + ", iConsigneeTel=" + iConsigneeTel
				+ ", iConsigneeAddr=" + iConsigneeAddr + ", i_pId=" + i_pId + ", i_pName=" + i_pName + ", iAmount="
				+ iAmount + ", iOrderDate=" + iOrderDate + ", i_sId=" + i_sId + ", i_tId=" + i_tId + ", iCheck="
				+ iCheck + "]";
	}

}
