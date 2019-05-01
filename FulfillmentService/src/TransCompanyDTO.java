public class TransCompanyDTO {
	private int tId;
	private String tPwd;
	private String tName;

	public TransCompanyDTO(int tId, String tPwd, String tName) {
		this.tId = tId;
		this.tPwd = tPwd;
		this.tName = tName;
	}

	public TransCompanyDTO() {
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public String gettPwd() {
		return tPwd;
	}

	public void settPwd(String tPwd) {
		this.tPwd = tPwd;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	@Override
	public String toString() {
		return "TransCompanyDTO [tId=" + tId + ", tPwd=" + tPwd + ", tName=" + tName + "]";
	}

}
