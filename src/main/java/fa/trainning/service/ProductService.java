package fa.trainning.service;

import java.util.List;


import fa.trainning.dto.PagingDto;
import fa.trainning.dto.ProductDto;


public interface ProductService {
	List<ProductDto> getAllProducts();
	
	PagingDto getAllProductPagnation(int offSet,int pageSize);
	
	ProductDto getProduct(Integer id);
	
	ProductDto addProduct(ProductDto productDto);
	
	ProductDto updateProrduct(Integer id, ProductDto productDto);
	
	void deleteProduct(Integer id);
	
	PagingDto getProductByCategoryPaging(Integer categoryId,int offSet, int pageSize);
}
