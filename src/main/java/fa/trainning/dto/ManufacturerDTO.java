package fa.trainning.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManufacturerDTO {
	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("branchName")
	private String branchName;
	
	@JsonProperty("manufacturerAddress")
	private String address;
}
