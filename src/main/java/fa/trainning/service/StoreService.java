package fa.trainning.service;

import java.util.List;

import fa.trainning.dto.StoreDto;


public interface StoreService {
	List<StoreDto> getAllStore();

	StoreDto getStore(Integer id);

	void addStore(StoreDto storeDto);

	void deleteStore(Integer id);

	StoreDto updateStore(Integer id, StoreDto storeDto);
	
	StoreDto updatePropertyStore(Integer id, StoreDto storeDto);
}
