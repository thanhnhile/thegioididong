package fa.trainning.entity;

import java.util.List;

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
	
	@OneToMany(mappedBy = "store")
	private List<Order> listOfOrder;
	
	
//	private List<ProductStore> productStores;
	
	public Store(String storeName, String cityName, String address) {
		super();
		this.storeName = storeName;
		this.cityName = cityName;
		this.address = address;
	}
	public Store() {
		super();
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
	
//	@OneToMany(mappedBy="pk.store")
//	public List<Order> getListOfOrder() {
//		return listOfOrder;
//	}
//	public void setListOfOrder(List<Order> listOfOrder) {
//		this.listOfOrder = listOfOrder;
//	}
	
	
	
}
