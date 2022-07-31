package fa.trainning.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "store_id")
	private Integer id;

	@Column(nullable = false,unique = true)
	private String storeName;
	@Column
	private String cityName;
	@Column
	private String address;
	/*
	 * @OneToMany(mappedBy = "store", cascade = CascadeType.ALL) private List<Order>
	 * orders;
	 */

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "product_store", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "store_id"))
	private List<Product> products = new ArrayList<>();

	public Store() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Store(Integer id, String storeName, String cityName, String address, List<Product> products) {
		super();
		this.id = id;
		this.storeName = storeName;
		this.cityName = cityName;
		this.address = address;
		this.products = products;
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Integer getId() {
		return id;
	}

	
}
