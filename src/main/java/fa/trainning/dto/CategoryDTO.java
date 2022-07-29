package fa.trainning.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {
	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("categoryName")
	private String name;
	
	
}
