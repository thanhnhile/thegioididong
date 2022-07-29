package fa.trainning.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fa.trainning.dto.CategoryDTO;
import fa.trainning.entity.Category;

@Mapper
public interface CategoryMapper {
	CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

	CategoryDTO toCategoryDTO(Category category);

	List<CategoryDTO> toCategoryDTOs(List<Category> categories);

	Category toCategoryEntity(CategoryDTO categoryDTO);

	Category toCategoryEntity(CategoryDTO categoryDTO, Category category);
}