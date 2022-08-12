package fa.trainning.service;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import fa.trainning.dto.ProductDto;
import fa.trainning.entity.Product;


public interface ProductService {
	Object getAllProducts();
	
	Object getAllProductPagnation(int offSet,int pageSize);
	
	Object getProduct(Integer id);
	
	Object addProduct(ProductDto productDto);
	
	Object updateProrduct(Integer id, ProductDto productDto);
	
	void deleteProduct(Integer id);
	
	Object getProductByCategoryPaging(Integer categoryId,int offSet, int pageSize);
	
	//Filter
	Object findBySearchCriteria(Specification<Product> spec,int offSet, int pageSize,String sortBy, Boolean asc);

}
