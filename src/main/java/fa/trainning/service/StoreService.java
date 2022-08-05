package fa.trainning.service;

import java.util.List;

import fa.trainning.dto.PagingDto;
import fa.trainning.dto.StoreDto;


public interface StoreService {
	List<StoreDto> getAllStore();
	
	PagingDto getAllStorePagnation(int offSet,int pageSize);

	StoreDto getStore(Integer id);

	Object addStore(StoreDto storeDto);

	void deleteStore(Integer id);

	StoreDto updateStore(Integer id, StoreDto storeDto);
	
	StoreDto updatePropertyStore(Integer id, StoreDto storeDto);
}
