package fa.trainning.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Store {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="store_id")
	private Integer id;
	
	@Column(nullable = false)
	private String storeName;
	
	private String cityName;
	
	private String address;
	
	@OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
	private List<Order> orders;
	
	@OneToMany(mappedBy="store", cascade = CascadeType.ALL)
	private List<ProductStore> productStores;

	public Store() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Store(String storeName, String cityName, String address, List<Order> orders,
			List<ProductStore> productStores) {
		super();
		this.storeName = storeName;
		this.cityName = cityName;
		this.address = address;
		this.orders = orders;
		this.productStores = productStores;
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

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<ProductStore> getProductStores() {
		return productStores;
	}

	public void setProductStores(List<ProductStore> productStores) {
		this.productStores = productStores;
	}
	
	
	
}
