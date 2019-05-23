package calculator;

import java.util.Objects;

public class InvoiceDTO {
	private int iId = 0;
	private String iConsigneeName = "";
	private String iConsigneeTel = "";
	private String iConsigneeAddr = "";
	private int i_pId = 0;
	private String i_pName = "";
	private int iAmount = 0;
	private String iOrderDate = "";
	private int i_sId = 0;
	private String i_sName = "";
	private int i_tId = 0;
	private String i_tName = "";
	private String iCheck = "";
	private int cost = 0;

	public InvoiceDTO(int iId, String iConsigneeName, String iConsigneeTel, String iConsigneeAddr, int i_pId,
			String i_pName, int iAmount, String iOrderDate, int i_sId, String i_sName, int i_tId, String i_tName,
			String iCheck, int cost) {
		this.iId = iId;
		this.iConsigneeName = iConsigneeName;
		this.iConsigneeTel = iConsigneeTel;
		this.iConsigneeAddr = iConsigneeAddr;
		this.i_pId = i_pId;
		this.i_pName = i_pName;
		this.iAmount = iAmount;
		this.iOrderDate = iOrderDate;
		this.i_sId = i_sId;
		this.i_sName = i_sName;
		this.i_tId = i_tId;
		this.i_tName = i_tName;
		this.iCheck = iCheck;
		this.cost = cost;
	}

	public InvoiceDTO(int iId, String iConsigneeName, String iConsigneeTel, String iOrderDate, int cost) {
		this.iId = iId;
		this.iConsigneeName = iConsigneeName;
		this.iConsigneeTel = iConsigneeTel;
		this.iOrderDate = iOrderDate;
		this.cost = cost;
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

	public String getI_sName() {
		return i_sName;
	}

	public void setI_sName(String i_sName) {
		this.i_sName = i_sName;
	}

	public int getI_tId() {
		return i_tId;
	}

	public void setI_tId(int i_tId) {
		this.i_tId = i_tId;
	}

	public String getI_tName() {
		return i_tName;
	}

	public void setI_tName(String i_tName) {
		this.i_tName = i_tName;
	}

	public String getiCheck() {
		return iCheck;
	}

	public void setiCheck(String iCheck) {
		this.iCheck = iCheck;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "InvoiceDTO [iId=" + iId + ", iConsigneeName=" + iConsigneeName + ", iConsigneeTel=" + iConsigneeTel
				+ ", iConsigneeAddr=" + iConsigneeAddr + ", i_pId=" + i_pId + ", i_pName=" + i_pName + ", iAmount="
				+ iAmount + ", iOrderDate=" + iOrderDate + ", i_sId=" + i_sId + ", i_sName=" + i_sName + ", i_tId="
				+ i_tId + ", i_tName=" + i_tName + ", iCheck=" + iCheck + ", cost=" + cost + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(iId, iConsigneeName, iConsigneeTel, iConsigneeAddr, i_pId, i_pName, iAmount, iOrderDate, i_sId, i_sName, i_tId, i_tName, iCheck, cost);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof InvoiceDTO) {
			InvoiceDTO iDto = (InvoiceDTO) obj;
			if ((iId == iDto.iId) && iConsigneeName.equals(iDto.iConsigneeName)
					&& iConsigneeTel.equals(iDto.iConsigneeTel) && iConsigneeAddr.equals(iDto.iConsigneeAddr)
					&& (i_pId == iDto.i_pId) && i_pName.equals(iDto.i_pName) && (iAmount == iDto.iAmount)
					&& iOrderDate.equals(iDto.iOrderDate) && (i_sId == iDto.i_sId) && i_sName.equals(iDto.i_sName)
					&& (i_tId == iDto.i_tId) && i_tName.equals(iDto.i_tName) && iCheck.equals(iDto.iCheck)
					&& (cost == iDto.cost))
				return true;
		}
		return false;
	}
	
}
