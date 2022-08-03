package fa.trainning.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fa.trainning.dto.PagingProductDto;
import fa.trainning.dto.ProductDto;
import fa.trainning.service.impl.ProductServiceImpl;

@RestController
@RequestMapping(path="/products")
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productService;
	
	@GetMapping
	public List<ProductDto> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping(value="/{id}")
	public ProductDto getProduct(@PathVariable(value ="id") Integer id) {
		return productService.getProduct(id);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteProduct(@PathVariable(value = "id") Integer id) {
		productService.deleteProduct(id);
	}
	
	@PostMapping
	public ProductDto addProduct(@Validated @RequestBody ProductDto productDto) {
		return productService.addProduct(productDto);
	}
	
	@PutMapping(value="/{id}")
	public ProductDto updateProduct(@PathVariable(value="id") Integer id,@Validated @RequestBody ProductDto productDto) {
		return productService.updateProrduct(id, productDto);
	}
	
	@GetMapping(value="/{offset}/{pageSize}")
	public PagingProductDto getProductPaging(@PathVariable(value = "offset") int offSet,
			@PathVariable(value = "pageSize") int pageSize){
		return productService.getAllProductPagnation(offSet, pageSize);
		
	}
	
	@GetMapping("/category/{id}/{offset}/{pageSize}")
	public PagingProductDto getProductByCategoryPaging(@PathVariable(value = "id") Integer categoryId, 
			@PathVariable(value="offset") int offSet, @PathVariable int pageSize){
		return productService.getProductByCategoryPaging(categoryId, offSet, pageSize);
	}
	
}
