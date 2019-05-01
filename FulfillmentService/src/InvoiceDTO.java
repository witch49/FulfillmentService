
public class InvoiceDTO {
	private int iId;
	private String iConsigneeName;
	private String iConsigneeTel;
	private String iConsigneeAddr;
	private int i_pId;
	private String i_pName;
	private int iAmount;
	private String i_orderDate;
	private int i_sId;

	public InvoiceDTO(int iId, String iConsigneeName, String iConsigneeTel, String iConsigneeAddr, int i_pId,
			String i_pName, int iAmount, String i_orderDate, int i_sId) {
		this.iId = iId;
		this.iConsigneeName = iConsigneeName;
		this.iConsigneeTel = iConsigneeTel;
		this.iConsigneeAddr = iConsigneeAddr;
		this.i_pId = i_pId;
		this.i_pName = i_pName;
		this.iAmount = iAmount;
		this.i_orderDate = i_orderDate;
		this.i_sId = i_sId;
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

	public String getI_orderDate() {
		return i_orderDate;
	}

	public void setI_orderDate(String i_orderDate) {
		this.i_orderDate = i_orderDate;
	}

	public int getI_sId() {
		return i_sId;
	}

	public void setI_sId(int i_sId) {
		this.i_sId = i_sId;
	}

	@Override
	public String toString() {
		return "InvoiceDTO [iId=" + iId + ", iConsigneeName=" + iConsigneeName + ", iConsigneeTel=" + iConsigneeTel
				+ ", iConsigneeAddr=" + iConsigneeAddr + ", i_pId=" + i_pId + ", i_pName=" + i_pName + ", iAmount="
				+ iAmount + ", i_orderDate=" + i_orderDate + ", i_sId=" + i_sId + "]";
	}

}
