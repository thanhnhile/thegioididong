package fa.trainning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fa.trainning.dto.CategoryDto;
import fa.trainning.dto.PagingDto;
import fa.trainning.entity.Category;
import fa.trainning.mapstruct.CategoryMapper;
import fa.trainning.repository.CategoryRepository;
import fa.trainning.service.CategoryService;



@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;
	@Autowired
	private CategoryMapper categoryMapper;

	@Autowired
	public CategoryServiceImpl(CategoryMapper categoryMapper, CategoryRepository categoryRepo) {
		this.categoryMapper = categoryMapper;
		this.categoryRepo = categoryRepo;
	}

	@Override
	public List<CategoryDto> getAllCategorys() {
		return categoryMapper.categorysToCategoryDtos(categoryRepo.findAll());
	}

	@Override
	public CategoryDto getCategory(Integer id) {
		return categoryMapper.categoryToCategoryDto(categoryRepo.findOneById(id));
	}

	@Override
	public void addCategory(CategoryDto categoryDto) {
		categoryRepo.save(categoryMapper.categoryDtoToCategory(categoryDto));
	}

	@Override
	public void deleteCategory(Integer id) {
		categoryRepo.delete(categoryRepo.findOneById(id));
	}

	@Override
	public CategoryDto updateCategory(Integer id, CategoryDto categoryDto) {
		Category categoryNew = categoryMapper.categoryDtoToCategory(categoryDto);
		Category categoryOld = categoryRepo.findOneById(id);
		categoryOld.setName(categoryNew.getName());
		categoryRepo.save(categoryOld);
		return categoryMapper.categoryToCategoryDto(categoryOld);
	}

	@Override
	public PagingDto getAllProductPagnation(int offSet, int pageSize) {
		PageRequest pageable = PageRequest.of(offSet-1, pageSize);
		Page<Category> page = categoryRepo.findAll(pageable);
		PagingDto pageDto = new PagingDto();
		pageDto.setCurrentPage(offSet);
		pageDto.setPageSize(pageSize);
		pageDto.setTotalElements(page.getTotalElements());
		pageDto.setTotalPages(page.getTotalPages());
		pageDto.setListDtos(categoryMapper.categorysToCategoryDtos(page.getContent()));
		return pageDto;
	}

}
