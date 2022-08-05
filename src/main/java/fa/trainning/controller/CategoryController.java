package fa.trainning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fa.trainning.dto.CategoryDto;
import fa.trainning.dto.PagingDto;
import fa.trainning.service.impl.CategoryServiceImpl;



@RestController
@RequestMapping("/categories")
public class CategoryController {
	@Autowired
	private CategoryServiceImpl categoryImpl;

	@GetMapping()
	public List<CategoryDto> getAllCategory() {
		return categoryImpl.getAllCategorys();
	}
	
	@GetMapping("/{offset}/{pageSize}")
	public PagingDto getAllCategoryPagnation(@PathVariable (value = "offset") int offSet, @PathVariable(value="pageSize") int pageSize) {
		return categoryImpl.getAllProductPagnation(offSet, pageSize);
	}
	
	@GetMapping("/{category_id}")
	public CategoryDto getCategory(@PathVariable(value = "category_id") Integer category_id) {
		return categoryImpl.getCategory(category_id);
	}

	@PostMapping()
	public void addCategory(@RequestBody CategoryDto categoryDto) {
		categoryImpl.addCategory(categoryDto);
	}

	@DeleteMapping("/{category_id}")
	public void deleteCategory(@PathVariable(value = "category_id") Integer category_id) {
		categoryImpl.deleteCategory(category_id);
	}

	@PutMapping("/{category_id}")
	public void updateCategory(@PathVariable(value = "category_id") Integer category_id, @RequestBody CategoryDto categoryDto ) {
		categoryImpl.updateCategory(category_id, categoryDto);
	}
}
