package fa.trainning.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderDetailDto {
	@JsonProperty("detailId")
	private Integer id;

	@JsonProperty("order_id")
	private Integer order_id;
	@JsonProperty("product")
	private ProductDto product;

	@JsonProperty("totalprice")
	private float totalprice;

	@JsonProperty("quantity")
	private int quantity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public OrderDetailDto() {
	}

	public OrderDetailDto(Integer id, Integer order_id, ProductDto product, float totalprice, int quantity) {
		super();
		this.id = id;
		this.order_id = order_id;
		this.product = product;
		this.totalprice = totalprice;
		this.quantity = quantity;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public ProductDto getProduct() {
		return product;
	}

	public void setProduct(ProductDto product) {
		this.product = product;
	}

	public float getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
