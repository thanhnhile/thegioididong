package fa.trainning.service;

import fa.trainning.dto.ManufacturerDto;


public interface ManufacturerService {
	Object getAllManufacturer();

	Object getManufacturer(Integer id);

	Object addManufacturer(ManufacturerDto manufacturerDto);

	void deleteManufacturer(Integer id);

	Object updateManufacturer(Integer id, ManufacturerDto manufacturerDto);
}
