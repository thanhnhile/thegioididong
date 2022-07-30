package fa.trainning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.trainning.dto.ManufacturerDto;
import fa.trainning.entity.Manufacturer;
import fa.trainning.mapstruct.MapStructMapper;
import fa.trainning.repository.ManufacturerRepository;
import fa.trainning.service.ManufacturerService;



@Service
public class ManufacturerImpl implements ManufacturerService {

	@Autowired
	private ManufacturerRepository manufacturerRepo;
	@Autowired
	private MapStructMapper mapStructMapper;

	@Autowired
	public ManufacturerImpl(MapStructMapper mapStructMapper, ManufacturerRepository manufacturerRepo) {
		this.mapStructMapper = mapStructMapper;
		this.manufacturerRepo = manufacturerRepo;
	}

	@Override
	public List<ManufacturerDto> getAllManufacturer() {
		return mapStructMapper.manufacturerToManufacturerDtos(manufacturerRepo.findAll());
	}

	@Override
	public ManufacturerDto getManufacturer(Integer id) {
		return mapStructMapper.manufacturerToManufacturerDto(manufacturerRepo.findOneById(id));
	}

	@Override
	public void addManufacturer(ManufacturerDto manufacturerDto) {
		manufacturerRepo.save(mapStructMapper.manufacturerDtoToManufacturer(manufacturerDto));
	}

	@Override
	public void deleteManufacturer(Integer id) {
		manufacturerRepo.delete(manufacturerRepo.findOneById(id));
	}

	@Override
	public ManufacturerDto updateManufacturer(Integer id, ManufacturerDto manufacturerDto) {
		Manufacturer manufacturerNew = mapStructMapper.manufacturerDtoToManufacturer(manufacturerDto);
		Manufacturer manufacturerOld = manufacturerRepo.findOneById(id);
		manufacturerOld.setAddress(manufacturerNew.getAddress());
		manufacturerOld.setBranchName(manufacturerNew.getBranchName());
		manufacturerRepo.save(manufacturerOld);
		return mapStructMapper.manufacturerToManufacturerDto(manufacturerOld);
	}

	

	

}
