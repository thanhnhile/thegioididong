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
	private String password;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

	@OneToOne(mappedBy = "account")
	private Customer customer;

	@OneToOne(mappedBy = "account")
	private Staff staff;

	public Account() {
	}

	public Account(String userName, String password, Role role, Customer customer, Staff staff) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.customer = customer;
		this.staff = staff;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	

}
