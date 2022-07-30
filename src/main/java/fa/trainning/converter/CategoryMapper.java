package fa.trainning.converter;

import java.util.List;

import org.mapstruct.Mapper;

import fa.trainning.dto.CategoryDTO;
import fa.trainning.entity.Category;

@Mapper
public interface CategoryMapper {
	
	CategoryDTO toCategoryDTO(Category category);

	List<CategoryDTO> toCategoryDTOs(List<Category> categories);

	Category toCategory(CategoryDTO categoryDTO);

	List<Category> toCategories (List<CategoryDTO> list);
}