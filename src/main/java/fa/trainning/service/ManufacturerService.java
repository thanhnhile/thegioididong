package fa.trainning.service;

import java.util.List;

import fa.trainning.dto.ManufacturerDto;


public interface ManufacturerService {
	List<ManufacturerDto> getAllManufacturer();

	ManufacturerDto getManufacturer(Integer id);

	void addManufacturer(ManufacturerDto manufacturerDto);

	void deleteManufacturer(Integer id);

	ManufacturerDto updateManufacturer(Integer id, ManufacturerDto manufacturerDto);
}
