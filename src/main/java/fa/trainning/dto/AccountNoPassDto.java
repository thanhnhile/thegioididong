package fa.trainning.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountNoPassDto {
	@JsonProperty("userName")
	private String userName;

	
	@JsonProperty("role_id")
	private Integer role_id;

	public AccountNoPassDto() {
	}

	public AccountNoPassDto(String userName, Integer role_id) {
		super();
		this.userName = userName;
		this.role_id = role_id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	

	
}
