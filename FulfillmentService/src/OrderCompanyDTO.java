public class OrderCompanyDTO {
	private int oId;
	private String oPwd;
	private String oName;

	public OrderCompanyDTO(int oId, String oPwd, String oName) {
		this.oId = oId;
		this.oPwd = oPwd;
		this.oName = oName;
	}

	public OrderCompanyDTO() {
	}

	public int getoId() {
		return oId;
	}

	public void setoId(int oId) {
		this.oId = oId;
	}

	public String getoPwd() {
		return oPwd;
	}

	public void setoPwd(String oPwd) {
		this.oPwd = oPwd;
	}

	public String getoName() {
		return oName;
	}

	public void setoName(String oName) {
		this.oName = oName;
	}

	@Override
	public String toString() {
		return "OrderCompanyDTO [oId=" + oId + ", oPwd=" + oPwd + ", oName=" + oName + "]";
	}

}
