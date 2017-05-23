package entity;

public class PromotionBean {
	private String id;
	private String goodId;
	private Integer promotion;//1.满减;2.买赠
	private String description;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGoodId() {
		return goodId;
	}
	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}
	public Integer getPromotion() {
		return promotion;
	}
	public void setPromotion(Integer promotion) {
		this.promotion = promotion;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
