package fa.trainning.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountDto {
	@JsonProperty("userName")
	private String userName;

	@JsonProperty("passWord")
	private String passWord;

	@JsonProperty("role_id")
	private Integer role_id;

	public AccountDto() {
	}

	public AccountDto(String userName, String passWord, Integer role_id) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.role_id = role_id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}



	
}
