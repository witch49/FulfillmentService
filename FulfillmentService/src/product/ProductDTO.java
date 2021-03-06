package product;
public class ProductDTO {
	private int pId;
	private String pName;
	private String pImg;
	private int pPrice;
	private int pAmount;
	private int p_oId;
	private String p_oName;

	public ProductDTO(int pId, String pName, String pImg, int pPrice, int pAmount, int p_oId, String p_oName) {
		this.pId = pId;
		this.pName = pName;
		this.pImg = pImg;
		this.pPrice = pPrice;
		this.pAmount = pAmount;
		this.p_oId = p_oId;
		this.p_oName = p_oName;
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

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
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

	public String getP_oName() {
		return p_oName;
	}

	public void setP_oName(String p_oName) {
		this.p_oName = p_oName;
	}

	@Override
	public String toString() {
		return "ProductDTO [pId=" + pId + ", pName=" + pName + ", pImg=" + pImg + ", pPrice=" + pPrice + ", pAmount="
				+ pAmount + ", p_oId=" + p_oId + ", p_oName=" + p_oName + "]";
	}

}
