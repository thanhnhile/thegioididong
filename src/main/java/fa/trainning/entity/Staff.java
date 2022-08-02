package fa.trainning.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Staff")

public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Staff_id")
	private Integer id;

	@Column(nullable = false)
	private String address;

	@Column(nullable = false)
	private String staff_name;

	@Column(name = "phone_number", nullable = false)
	private String phone;

	// Staff 1-->1 Account
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_name", referencedColumnName = "user_name")
	private Account account;

	// Staff N-->1 Store
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Store_id")
	private Store store;

	public Staff() {
	}

	public Staff(Integer id, String address, String staff_name, String phone, Account account) {
		super();
		this.id = id;
		this.address = address;
		this.staff_name = staff_name;
		this.phone = phone;
		this.account = account;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStaff_name() {
		return staff_name;
	}

	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Integer getId() {
		return id;
	}

}
