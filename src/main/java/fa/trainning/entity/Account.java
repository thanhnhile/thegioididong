package fa.trainning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")

public class Account {
	@Id
	@Column()
	private String userName;

	@Column(nullable = false)
	private String passWord;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

	@OneToOne(mappedBy = "account")
	private Customer customer;


	public Account() {
	}


	public Account(String userName, String passWord, Role role, Customer customer) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.role = role;
		this.customer = customer;
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


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
}
