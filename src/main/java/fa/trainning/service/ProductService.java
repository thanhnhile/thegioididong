package fa.trainning.service;

import java.util.List;


import fa.trainning.dto.PagingDto;
import fa.trainning.dto.ProductDto;


public interface ProductService {
	Object getAllProducts();
	
	Object getAllProductPagnation(int offSet,int pageSize);
	
	Object getProduct(Integer id);
	
	Object addProduct(ProductDto productDto);
	
	Object updateProrduct(Integer id, ProductDto productDto);
	
	void deleteProduct(Integer id);
	
	Object getProductByCategoryPaging(Integer categoryId,int offSet, int pageSize);
}
