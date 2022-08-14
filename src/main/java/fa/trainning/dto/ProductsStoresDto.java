package fa.trainning.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductsStoresDto {
	
	@JsonProperty("store")
	private StoreDto store;
	
	@JsonProperty("productsInStore")
	private List<ProductInStoreDto> productsStores;
	
}
