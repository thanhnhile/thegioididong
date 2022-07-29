package fa.trainning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fa.trainning.dto.CategoryDTO;
import fa.trainning.service.impl.CategoryServiceImpl;

@RestController
@RequestMapping(path="categories")
public class CategoryController {
	
	@Autowired
	CategoryServiceImpl cateService;
	
	@GetMapping("/all")
	public List<CategoryDTO> getAll(){
		return cateService.getAllCategorys();
	}
	
	@PostMapping
	public CategoryDTO addCategory(@Validated @RequestBody CategoryDTO categoryDTO) {
		return cateService.addCategory(categoryDTO);
	}
}
