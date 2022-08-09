package fa.trainning.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fa.trainning.dto.DataResponse;
import fa.trainning.dto.SearchCriteria;
import fa.trainning.service.impl.ProductServiceImpl;
import fa.trainning.specification.ProductSpecificationBuilder;

@RestController
@RequestMapping("/api")
public class FilterProductController {

	@Autowired
	private ProductServiceImpl productService;

	/// products/filter?c=dtdd?b=samsung,oppo?price=25000-60000?m=Korea?pageNum=1
	@GetMapping("/filter")
	public DataResponse filterProduct(@RequestParam(required = false) String c, 
			@RequestParam (required= true) String sortBy) {
		ProductSpecificationBuilder builder = new ProductSpecificationBuilder();
		List<SearchCriteria> searchCriterias = new ArrayList<SearchCriteria>();
		if (c != null) {
			String[] keywords = c.split(",");
			for(int i=0;i<keywords.length ;i++) {
				searchCriterias.add(new SearchCriteria("name", keywords[i], "cn"));
			}	
		}
		if (searchCriterias != null) {
			searchCriterias.forEach(x -> {
				builder.with(x);
			});
		}
		Object result = productService.findBySearchCriteria(builder.build(), 1, 2, sortBy);
		DataResponse dataResponse = new DataResponse(result);
		return dataResponse;
	}

}
