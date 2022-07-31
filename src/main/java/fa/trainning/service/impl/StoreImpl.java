package fa.trainning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.trainning.dto.StoreDto;
import fa.trainning.entity.Store;
import fa.trainning.mapstruct.MapStructMapper;
import fa.trainning.repository.StoreRepository;
import fa.trainning.service.StoreService;

@Service
public class StoreImpl implements StoreService {

	@Autowired
	private StoreRepository storeRepo;
	@Autowired
	private MapStructMapper mapStructMapper;

	@Autowired
	public StoreImpl(MapStructMapper mapStructMapper, StoreRepository storeRepo) {
		this.mapStructMapper = mapStructMapper;
		this.storeRepo = storeRepo;
	}

	@Override
	public List<StoreDto> getAllStore() {
		return mapStructMapper.storeToStoreDtos(storeRepo.findAll());
	}

	@Override
	public StoreDto getStore(Integer id) {
		return mapStructMapper.storeToStoreDto(storeRepo.findOneById(id));
	}

	@Override
	public void addStore(StoreDto storeDto) {
		storeRepo.save(mapStructMapper.storeDtoToStore(storeDto));
	}

	@Override
	public void deleteStore(Integer id) {
		storeRepo.delete(storeRepo.findOneById(id));
	}

	@Override
	public StoreDto updateStore(Integer id, StoreDto storeDto) {
		Store storeNew = mapStructMapper.storeDtoToStore(storeDto);
		Store storeOld = storeRepo.findOneById(id);
		storeOld.setAddress(storeNew.getAddress());
		storeOld.setCityName(storeNew.getCityName());
		storeOld.setStoreName(storeNew.getStoreName());
		storeRepo.save(storeOld);
		return mapStructMapper.storeToStoreDto(storeOld);
	}

	@Override
	public StoreDto updatePropertyStore(Integer id, StoreDto storeDto) {
		Store storeNew = mapStructMapper.storeDtoToStore(storeDto);
		Store storeOld = storeRepo.findOneById(id);
		if (!(storeNew.getAddress() == null)) {
			storeOld.setAddress(storeNew.getAddress());
		}
		if (!(storeNew.getCityName() == null)) {
			storeOld.setCityName(storeNew.getCityName());
		}
		if (!(storeNew.getStoreName()==null)) {
			storeOld.setStoreName(storeNew.getStoreName());
		}

		storeRepo.save(storeOld);
		return mapStructMapper.storeToStoreDto(storeOld);
	}

}
