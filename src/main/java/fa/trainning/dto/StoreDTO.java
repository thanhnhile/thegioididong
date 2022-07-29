package fa.trainning.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreDTO {
	@JsonProperty("storeID")
	private Integer id;
	
	@JsonProperty("storeName")
	private String name;
	
	@JsonProperty("cityName")
	private String cityName;
	
	@JsonProperty("streetName")
	private String address;
}
