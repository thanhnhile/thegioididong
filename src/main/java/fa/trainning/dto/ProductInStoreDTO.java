package fa.trainning.dto;

import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
@Setter
public class ProductInStoreDTO {
	@JsonProperty("store")
	private StoreDTO storeDTO;
	
	@JsonProperty("inStock")
	private int inStock;
}
