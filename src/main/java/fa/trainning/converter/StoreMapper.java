package fa.trainning.converter;

import java.util.List;

import org.mapstruct.Mapper;

import fa.trainning.dto.StoreDTO;
import fa.trainning.entity.Store;


@Mapper
public interface StoreMapper {
	StoreDTO toStoreDTO (Store store);
	
	List<StoreDTO> toStoreDTOs (List<Store> list);
	
	Store toStore(StoreDTO storeDTO);
	
	List<Store> toStores (List<StoreDTO> list);
}
