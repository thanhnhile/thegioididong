package fa.trainning.service;

import java.util.List;

import fa.trainning.dto.CategoryDto;
import fa.trainning.dto.PagingDto;


public interface CategoryService {
	Object getAllCategorys();
	
	Object getAllProductPagnation(int offSet,int pageSize);

	Object getCategory(Integer id);

	Object addCategory(CategoryDto categoryDto);

	void deleteCategory(Integer id);

	Object updateCategory(Integer id, CategoryDto categoryDto);
}
