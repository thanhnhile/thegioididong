package fa.trainning.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderDetailDto {
	@JsonProperty("detailId")
	private Integer id;
	
	@JsonProperty("product")
	private ProductSimpleDto product;
	
	@JsonProperty("price")
	private float price;
	
	@JsonProperty("quantity")
	private int quantity;

	public OrderDetailDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetailDto(Integer id, ProductSimpleDto product, float price, int quantity) {
		super();
		this.id = id;
		this.product = product;
		this.price = price;
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ProductSimpleDto getProduct() {
		return product;
	}

	public void setProduct(ProductSimpleDto product) {
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
