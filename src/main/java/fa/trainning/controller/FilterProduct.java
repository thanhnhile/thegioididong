package fa.trainning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fa.trainning.dto.DataResponse;
import fa.trainning.dto.FilterItemDto;
import fa.trainning.service.impl.ProductServiceImpl;

@RestController
@RequestMapping("/api")
public class FilterProduct {
	
	@Autowired
	private ProductServiceImpl productService;
	
	/// products/filter?pageNum=1&pageSize=20&sortBy=price
	@PostMapping("/products/filter")
	public DataResponse filterProduct(@RequestBody List<FilterItemDto> listFilters,
			@RequestParam int pageNum, @RequestParam(defaultValue = "20") int pageSize,
			@RequestParam(defaultValue = "id") String sortBy) {
		
		return null;
	}
}
