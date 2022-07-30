package fa.trainning.service;

import java.util.List;

import fa.trainning.dto.ProductDTO;

public interface ProductService {
	List<ProductDTO> getAllProducts();

	List<ProductDTO> getProductsByCategory(Integer category_id);

	List<ProductDTO> getProductsByManufacturer(Integer manufacturer_id);

	ProductDTO getProduct(Integer id);

	ProductDTO addProducts(ProductDTO productsDTO);

	ProductDTO updateAllPropertyProducts(Integer id, ProductDTO productsDTO);

	ProductDTO updateProducts(Integer id, ProductDTO productsDTO);

	void deleteProduct(Integer id);
}