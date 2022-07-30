package fa.trainning.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer id;

	private String name;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "manufacturer_id")
	private Manufacturer manufacturer;

	@Column(length = 1000)
	private String description;

	private float price;

	private float discount;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Image> images;

	private String video;

	private String productWarranty;

	private Boolean status;

	private String unit;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "products")
	private List<Store> stores = new ArrayList<>();

	public Product() {
	}

	public Product(Integer id, String name, Category category, Manufacturer manufacturer, String description,
			float price, float discount, List<Image> images, String video, String productWarranty, Boolean status,
			String unit, List<Store> stores) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.manufacturer = manufacturer;
		this.description = description;
		this.price = price;
		this.discount = discount;
		this.images = images;
		this.video = video;
		this.productWarranty = productWarranty;
		this.status = status;
		this.unit = unit;
		this.stores = stores;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getProductWarranty() {
		return productWarranty;
	}

	public void setProductWarranty(String productWarranty) {
		this.productWarranty = productWarranty;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public List<Store> getStores() {
		return stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

	public Integer getId() {
		return id;
	}

	

}
