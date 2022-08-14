package fa.trainning.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductInStoreDto {
	@JsonProperty("product")
	private ProductSimpleDto product;
	
	@JsonProperty("inStock")
	private int inStock;

	public ProductSimpleDto getProduct() {
		return product;
	}

	public void setProduct(ProductSimpleDto product) {
		this.product = product;
	}

	public int getInStock() {
		return inStock;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}
	
	
	
}
