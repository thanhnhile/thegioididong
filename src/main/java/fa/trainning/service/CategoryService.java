package fa.trainning.service;

import fa.trainning.dto.CategoryDto;




public interface CategoryService {
	Object getAllCategorys();
	
	Object getAllProductPagnation(int offSet,int pageSize);

	Object getCategory(Integer id);

	Object addCategory(CategoryDto categoryDto);

	Object deleteCategory(Integer id);

	Object updateCategory(Integer id, CategoryDto categoryDto);
}
