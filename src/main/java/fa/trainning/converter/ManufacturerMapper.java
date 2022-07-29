package fa.trainning.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fa.trainning.dto.ManufacturerDTO;
import fa.trainning.entity.Manufacturer;

@Mapper
public interface ManufacturerMapper {
	ManufacturerMapper INSTANCE = Mappers.getMapper(ManufacturerMapper.class);

	ManufacturerDTO toManufacturerDTO(Manufacturer manufacturer);

	List<ManufacturerDTO> toManufacturerDTOs(List<Manufacturer> manufacturers);

	Manufacturer toManufacturer(ManufacturerDTO manufacturerDTO);

	List<Manufacturer> toManufacturers (List<ManufacturerDTO> list);
}