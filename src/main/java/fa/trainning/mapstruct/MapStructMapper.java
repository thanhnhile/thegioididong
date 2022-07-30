package fa.trainning.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;

import fa.trainning.dto.CategoryDto;
import fa.trainning.dto.ManufacturerDto;
import fa.trainning.entity.Category;
import fa.trainning.entity.Manufacturer;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
	// Entity To DTO
	CategoryDto categoryToCategoryDto(Category category);
	
	List<CategoryDto> categoryToCategoryDtos(List<Category> category);
	
	ManufacturerDto manufacturerToManufacturerDto(Manufacturer manufacturer);

	List<ManufacturerDto> manufacturerToManufacturerDtos(List<Manufacturer> manufacturer);
	// DTO To Entity
	Category categoryDtoToCategory(CategoryDto categoryDto);

	Manufacturer manufacturerDtoToManufacturer(ManufacturerDto manufacturerDTO);
}
