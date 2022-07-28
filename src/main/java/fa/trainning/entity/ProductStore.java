package fa.trainning.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product_store")
@IdClass(ProductStoreId.class)
public class ProductStore {
	
	@Id
	@ManyToOne
	@JoinColumn(name ="product_id")
	private Product product;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;
	
	private int inStock;
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public int getInStock() {
		return inStock;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}
	
	
	
	
}
