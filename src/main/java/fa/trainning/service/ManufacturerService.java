package fa.trainning.service;

import java.util.List;

import fa.trainning.dto.ManufacturerDTO;

public interface ManufacturerService {
	List<ManufacturerDTO> getAllManufacturers();

	ManufacturerDTO getManufacturer(Integer id);

	ManufacturerDTO addManufacturer(ManufacturerDTO ManufacturersDTO);
}