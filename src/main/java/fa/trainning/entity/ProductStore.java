package fa.trainning.entity;

import java.beans.Transient;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

//@Entity
//@Table(name = "product_store")
//@AssociationOverrides({
//		@AssociationOverride(name = "pk.product", 
//			joinColumns = @JoinColumn(name = "product_id")),
//		@AssociationOverride(name = "pk.store", 
//			joinColumns = @JoinColumn(name = "store_id")) })
public class ProductStore {

	private ProductStoreId pk = new ProductStoreId();
	
	private int stock;

	@EmbeddedId
	public ProductStoreId getPk() {
		return pk;
	}

	public void setPk(ProductStoreId pk) {
		this.pk = pk;
	}
	
	@Transient
	public Product getProduct() {
		return pk.getProduct();
	}
	public void setProduct(Product p) {
		pk.setProduct(p);
	}
	
	@Transient
	public Store getStore() {
		return pk.getStore();
	}
	public void setStore(Store store) {
		pk.setStore(store);
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
}	
