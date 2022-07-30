package fa.trainning.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.trainning.converter.CategoryMapper;
import fa.trainning.dto.CategoryDTO;
import fa.trainning.entity.Category;
import fa.trainning.repository.CategoryRepository;
import fa.trainning.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepository repo;
	
	@Autowired
	CategoryMapper categoryMapper;

	@Override
	public List<CategoryDTO> getAllCategorys() {
		List<Category> list = new ArrayList<Category>();
		repo.findAll().forEach(list::add);
		return categoryMapper.toCategoryDTOs(list);
	}

	@Override
	public CategoryDTO getCategory(Integer id) {
		Category category = new Category();
		category = repo.getReferenceById(id);
		return categoryMapper.toCategoryDTO(category);
	}

	@Override
	public CategoryDTO addCategory(CategoryDTO categoryDTO) {
		Category category = categoryMapper.toCategory(categoryDTO);
		return categoryMapper.toCategoryDTO(repo.save(category));
	}
	
	

	

}
