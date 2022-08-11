package fa.trainning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fa.trainning.dto.DataResponse;
import fa.trainning.dto.ProductSearchDto;
import fa.trainning.dto.SearchCriteria;
import fa.trainning.service.impl.ProductServiceImpl;
import fa.trainning.specification.ProductSpecificationBuilder;

@RestController
@RequestMapping("/api")
public class FilterProductController {

	@Autowired
	private ProductServiceImpl productService;

	// products/filter?pageSize=10&pageNum=1&sortBy=price
	@PostMapping("/filter")
	public DataResponse filterProduct(@RequestParam String sortBy, 
			@RequestParam int pageNum, @RequestParam(defaultValue="20") int pageSize,
			@RequestBody ProductSearchDto searchDto) {
		ProductSpecificationBuilder builder = new ProductSpecificationBuilder();
		List<SearchCriteria> searchCriterias = searchDto.getSearchCriterias();
		if (searchCriterias != null) {
			searchCriterias.forEach(x -> {
				x.setDataOption(searchDto.getDataOption());
				builder.with(x);
			});
		}
		Object result = productService.findBySearchCriteria(builder.build(), pageNum, pageSize, sortBy);
		DataResponse dataResponse = new DataResponse(result);
		return dataResponse;
	}

}
