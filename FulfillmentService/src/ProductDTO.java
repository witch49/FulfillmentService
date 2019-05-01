public class ProductDTO {
	private int pId;
	private String pName;
	private String pImg;
	private String pPrice;
	private int pAmount;
	private int p_oId;

	public ProductDTO(int pId, String pName, String pImg, String pPrice, int pAmount, int p_oId) {
		this.pId = pId;
		this.pName = pName;
		this.pImg = pImg;
		this.pPrice = pPrice;
		this.pAmount = pAmount;
		this.p_oId = p_oId;
	}

	public ProductDTO() {
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpImg() {
		return pImg;
	}

	public void setpImg(String pImg) {
		this.pImg = pImg;
	}

	public String getpPrice() {
		return pPrice;
	}

	public void setpPrice(String pPrice) {
		this.pPrice = pPrice;
	}

	public int getpAmount() {
		return pAmount;
	}

	public void setpAmount(int pAmount) {
		this.pAmount = pAmount;
	}

	public int getP_oId() {
		return p_oId;
	}

	public void setP_oId(int p_oId) {
		this.p_oId = p_oId;
	}

	@Override
	public String toString() {
		return "ProductDTO [pId=" + pId + ", pName=" + pName + ", pImg=" + pImg + ", pPrice=" + pPrice + ", pAmount="
				+ pAmount + ", p_oId=" + p_oId + "]";
	}

}
