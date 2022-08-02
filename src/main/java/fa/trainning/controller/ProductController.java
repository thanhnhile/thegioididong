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

import fa.trainning.dto.ProductDto;
import fa.trainning.service.impl.ProductServiceImpl;

@RestController
@RequestMapping(path="/products")
public class ProductController {
	
	@Autowired
	ProductServiceImpl productService;
	
	@GetMapping
	List<ProductDto> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping(value="/{id}")
	ProductDto getProduct(@PathVariable(value ="id") Integer id) {
		return productService.getProduct(id);
	}
	
	@DeleteMapping(value = "/{id}")
	void deleteProduct(@PathVariable(value = "id") Integer id) {
		productService.deleteProduct(id);
	}
	
	@PostMapping
	ProductDto addProduct(@Validated @RequestBody ProductDto productDto) {
		return productService.addProduct(productDto);
	}
	
	@PutMapping(value="/{id}")
	ProductDto updateProduct(@PathVariable(value="id") Integer id,@Validated @RequestBody ProductDto productDto) {
		return productService.updateProrduct(id, productDto);
	}
	
	
}
