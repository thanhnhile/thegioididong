package fa.trainning.dto;


import com.fasterxml.jackson.annotation.JsonProperty;


public class OrderDetailDto {
	@JsonProperty("detailId")
	private Integer id;
	
	@JsonProperty("product_id")
	private Integer product;
	
	@JsonProperty("price")
	private float price;
	
	@JsonProperty("quantity")
	private int quantity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public Integer getProduct() {
		return product;
	}

	public void setProduct(Integer product) {
		this.product = product;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	
}
