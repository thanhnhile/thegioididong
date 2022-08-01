package fa.trainning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.trainning.dto.CategoryDto;
import fa.trainning.entity.Category;
import fa.trainning.mapstruct.MapStructMapper;
import fa.trainning.repository.CategoryRepository;
import fa.trainning.service.CategoryService;



@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;
	@Autowired
	private MapStructMapper mapStructMapper;

	@Autowired
	public CategoryServiceImpl(MapStructMapper mapStructMapper, CategoryRepository categoryRepo) {
		this.mapStructMapper = mapStructMapper;
		this.categoryRepo = categoryRepo;
	}

	@Override
	public List<CategoryDto> getAllCategorys() {
		return mapStructMapper.categoryToCategoryDtos(categoryRepo.findAll());
	}

	@Override
	public CategoryDto getCategory(Integer id) {
		return mapStructMapper.categoryToCategoryDto(categoryRepo.findOneById(id));
	}

	@Override
	public void addCategory(CategoryDto categoryDto) {
		categoryRepo.save(mapStructMapper.categoryDtoToCategory(categoryDto));
	}

	@Override
	public void deleteCategory(Integer id) {
		categoryRepo.delete(categoryRepo.findOneById(id));
	}

	@Override
	public CategoryDto updateCategory(Integer id, CategoryDto categoryDto) {
		Category categoryNew = mapStructMapper.categoryDtoToCategory(categoryDto);
		Category categoryOld = categoryRepo.findOneById(id);
		categoryOld.setName(categoryNew.getName());
		categoryRepo.save(categoryOld);
		return mapStructMapper.categoryToCategoryDto(categoryOld);
	}

}
