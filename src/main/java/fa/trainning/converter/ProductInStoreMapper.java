package fa.trainning.converter;

import java.util.List;

import org.mapstruct.Mapper;

import fa.trainning.dto.ProductInStoreDTO;
import fa.trainning.entity.ProductStore;

@Mapper
public interface ProductInStoreMapper {
	
	ProductInStoreDTO toProductInStoreDTO(ProductStore productStore);

	List<ProductInStoreDTO> toProductInStoreDTOs(List<ProductStore> list);
	
	ProductStore toProductStore (ProductInStoreDTO productInStoreDTO);
	
	List<ProductInStoreDTO> toProductStores (List<ProductInStoreDTO> list);
}
