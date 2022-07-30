package fa.trainning.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.trainning.converter.ManufacturerMapper;
import fa.trainning.dto.ManufacturerDTO;
import fa.trainning.entity.Manufacturer;
import fa.trainning.repository.ManufacturerRepository;
import fa.trainning.service.ManufacturerService;

@Service
public class ManufacturerImpl implements ManufacturerService {
	@Autowired
	public ManufacturerRepository manufacturerRepo;
	@Autowired
	private ManufacturerMapper manufacturerMapper;

	@Override
	public List<ManufacturerDTO> getAllManufacturers() {
		List<Manufacturer> listManufacturer = new ArrayList<>();
		manufacturerRepo.findAll().forEach(listManufacturer::add);
		return manufacturerMapper.toManufacturerDTOs(listManufacturer);
	}

	@Override
	public ManufacturerDTO getManufacturer(Integer id) {
		Manufacturer manufacturer = new Manufacturer();
		manufacturerRepo.findOneById(id);
		return manufacturerMapper.toManufacturerDTO(manufacturer);
	}

	@Override
	public ManufacturerDTO addManufacturer(ManufacturerDTO manufacturersDTO) {
		Manufacturer manufacturer = manufacturerMapper.toManufacturerEntity(manufacturersDTO);
		manufacturer = manufacturerRepo.save(manufacturer);
		return manufacturerMapper.toManufacturerDTO(manufacturer);
	}
}