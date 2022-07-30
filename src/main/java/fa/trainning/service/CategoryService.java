package fa.trainning.service;

import java.util.List;

import fa.trainning.dto.CategoryDTO;


public interface CategoryService {
	List<CategoryDTO> getAllCategorys();
	CategoryDTO getCategory(Integer id);
	CategoryDTO addCategory(CategoryDTO categoryDTO);
}
