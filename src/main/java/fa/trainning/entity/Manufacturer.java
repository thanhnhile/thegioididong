package fa.trainning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Manufacturer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="manufacturer_id")
	private Integer id;
	
	private String branchName;
	private String address;
	
	
	public Manufacturer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Manufacturer(String branchName, String address) {
		super();
		this.branchName = branchName;
		this.address = address;
	}


	public String getBranchName() {
		return branchName;
	}


	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
