package fa.trainning.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;

import fa.trainning.dto.StoreDto;
import fa.trainning.entity.Store;

@Mapper(componentModel = "spring")
public interface StoreMapper {
	// ----------------------------Entity To DTO---------------------------

	StoreDto storeToStoreDto(Store store);

	List<StoreDto> storesToStoreDtos(List<Store> stores);

	// ---------------------------DTO To Entity----------------------

	// Store
	Store storeDtoToStore(StoreDto storeDto);

}
