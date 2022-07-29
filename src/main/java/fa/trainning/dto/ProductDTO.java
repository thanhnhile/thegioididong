package fa.trainning.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.Nullable;

import fa.trainning.entity.Image;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("productName")
	private String name;
	
	@JsonProperty("category")
	private CategoryDTO category;
	
	@JsonProperty("manufacturer")
	private ManufacturerDTO manufacturer;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("price")
	private float price;
	
	@JsonProperty("discount")
	@Nullable
	private float discount;
	
	@JsonProperty("images")
	private List<Image> images;
	
	@JsonProperty("videoURL")
	private String video;
	
	@JsonProperty("productWarranty")
	private String productWarranty;
	
	@JsonProperty("status")
	private Boolean status;
	
	@JsonProperty("unit")
	private String unit;
	
	@JsonProperty("inStores")
	List<ProductInStoreDTO> stores;
}