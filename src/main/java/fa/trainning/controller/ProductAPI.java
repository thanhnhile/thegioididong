package fa.trainning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fa.trainning.dto.ProductDTO;
import fa.trainning.service.impl.ProductImpl;

@RestController
public class ProductAPI {
	@Autowired
	private ProductImpl productImpl;

	@GetMapping(value = "/allproduct")
	public List<ProductDTO> getAllProducts() {
		return productImpl.getAllProducts();
	}

	@GetMapping(value = "/categoryproduct/{category_id}")
	public List<ProductDTO> getProductsByCategory(@PathVariable Integer category_id) {
		return productImpl.getProductsByCategory(category_id);
	}

	@GetMapping(value = "/manufacturerproduct/{manufacturer_id}")
	public List<ProductDTO> getProductsByManufacturer(@PathVariable Integer manufacturer_id) {
		return productImpl.getProductsByManufacturer(manufacturer_id);
	}

	@GetMapping(value = "/product/{id}")
	public ProductDTO getProduct(@PathVariable Integer id) {
		return productImpl.getProduct(id);
	}

	@PostMapping(value = "/product")
	public ProductDTO addProducts(@RequestBody ProductDTO model) {
		return productImpl.addProducts(model);
	}

	/*
	 * @PutMapping(value = "/content/{id}") public ProductDTO
	 * updateContent(@PathVariable("id") Integer id, @RequestBody ProductDTO model)
	 * { model.setId(id); return productImpl.updateAllPropertyProducts(id,model); }
	 */

	@DeleteMapping(value = "/content/{id}")
	public String deleteContent(@PathVariable Integer id) {
		productImpl.deleteProduct(id);
		return "Delelte sucess";
	}
}
