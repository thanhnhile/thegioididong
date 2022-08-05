package fa.trainning.service;

import java.util.List;

import fa.trainning.dto.CategoryDto;
import fa.trainning.dto.PagingDto;


public interface CategoryService {
	List<CategoryDto> getAllCategorys();
	
	PagingDto getAllProductPagnation(int offSet,int pageSize);

	CategoryDto getCategory(Integer id);

	void addCategory(CategoryDto categoryDto);

	void deleteCategory(Integer id);

	CategoryDto updateCategory(Integer id, CategoryDto categoryDto);
}
