package fa.trainning.converter;

import java.util.List;

import org.mapstruct.Mapper;

import fa.trainning.dto.CategoryDTO;
import fa.trainning.dto.ManufacturerDTO;
import fa.trainning.dto.ProductInStoreDTO;
import fa.trainning.dto.StoreDTO;
import fa.trainning.entity.Category;
import fa.trainning.entity.Manufacturer;
import fa.trainning.entity.ProductStore;
import fa.trainning.entity.Store;

//khong generate file impl
@Mapper
public interface ProductStructMapper {
	
	CategoryDTO categoryToCategoryDTO(Category category);
	ManufacturerDTO manufacturerToManufacturerDTO(Manufacturer manufacturer);
	StoreDTO storeToStoreDTO(Store store);
	ProductInStoreDTO productStoreToProductInStoreDTO(ProductStore productStore);
	List<ProductInStoreDTO> productStoresToProductInStoreDTOs(List<ProductStore> list);
}
