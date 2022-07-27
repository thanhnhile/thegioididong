package fa.trainning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class OrderDetail {
	@Id
	@Column(name = "order_detail_id", unique = true, nullable = false)
	private String id;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
	
	@OneToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	private float price;
	
	private int quantity;
	
	

	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}



	public OrderDetail(String id, Order order, Product product, float price, int quantity) {
		super();
		this.id = id;
		this.order = order;
		this.product = product;
		this.price = price;
		this.quantity = quantity;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public Order getOrder() {
		return order;
	}



	public void setOrder(Order order) {
		this.order = order;
	}



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	public float getPrice() {
		return price;
	}



	public void setPrice(float price) {
		this.price = price;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
