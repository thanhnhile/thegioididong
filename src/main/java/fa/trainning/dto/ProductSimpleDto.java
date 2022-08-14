package fa.trainning.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductSimpleDto {
	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("productName")
	private String name;

	public ProductSimpleDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductSimpleDto(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
