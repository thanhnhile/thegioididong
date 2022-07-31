package fa.trainning.service;

import java.util.List;

import fa.trainning.dto.CategoryDto;


public interface CategoryService {
	List<CategoryDto> getAllCategorys();

	CategoryDto getCategory(Integer id);

	void addCategory(CategoryDto categoryDto);

	void deleteCategory(Integer id);

	CategoryDto updateCategory(Integer id, CategoryDto categoryDto);
}
