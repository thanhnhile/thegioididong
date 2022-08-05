package fa.trainning.service;

import java.util.List;

import fa.trainning.dto.PagingDto;
import fa.trainning.dto.StoreDto;


public interface StoreService {
	Object getAllStore();
	
	Object getAllStorePagnation(int offSet,int pageSize);

	Object getStore(Integer id);

	Object addStore(StoreDto storeDto);

	void deleteStore(Integer id);

	Object updateStore(Integer id, StoreDto storeDto);
	
	Object updatePropertyStore(Integer id, StoreDto storeDto);
}
