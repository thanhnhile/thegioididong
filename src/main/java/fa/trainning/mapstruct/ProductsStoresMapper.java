package fa.trainning.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;

import fa.trainning.dto.ProductInStoreDto;
import fa.trainning.entity.ProductsStores;

//@Mapper(componentModel="spring")
public interface ProductsStoresMapper {
	//-------------------Entity To Dto------------------------
	ProductInStoreDto toProductInStoreDto(ProductsStores productsStores);
	List<ProductInStoreDto> toProductInStoreDtos (List<ProductsStores> list);
	//-------------------Dto To Entity------------------------
	ProductsStores toProductsStores(ProductInStoreDto productInStoreDto);
	List<ProductsStores> toProductsStores (List<ProductInStoreDto> list);
}
