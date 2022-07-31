package fa.trainning.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StoreDto {
	@JsonProperty("storeID")
	private Integer id;
	
	@JsonProperty("storeName")
	private String storeName;
	
	@JsonProperty("cityName")
	private String cityName;
	
	@JsonProperty("address")
	private String address;

	public StoreDto(Integer id, String storeName, String cityName, String address) {
		super();
		this.id = id;
		this.storeName = storeName;
		this.cityName = cityName;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	
}
