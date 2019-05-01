public class ShoppingMallDTO {
	private int sId;
	private String sName;

	public ShoppingMallDTO(int sId, String sName) {
		this.sId = sId;
		this.sName = sName;
	}

	public ShoppingMallDTO() {
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	@Override
	public String toString() {
		return "ShoppingMallDTO [sId=" + sId + ", sName=" + sName + "]";
	}

}
