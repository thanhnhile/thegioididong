package fa.trainning.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import fa.trainning.dto.ProductsStoresDto;
import fa.trainning.entity.ProductsStores;

@Mapper(componentModel="spring")
public interface ProductsStoresMapper {
	//-------------------Entity To Dto------------------------
	@Mapping(source="store.id",target="store")
	@Mapping(source="product.id",target="product")
	ProductsStoresDto toProductsStoresDto(ProductsStores productsStores);
	
	List<ProductsStoresDto> toListProductsStoresDto(List<ProductsStores> list);
	//-------------------Dto To Entity------------------------
	@Mapping(source="store",target="store.id")
	@Mapping(source="product",target="product.id")
	ProductsStores toProductsStores(ProductsStoresDto productsStoresDto);
	
	List<ProductsStoresDto> toListProductsStores(List<ProductsStoresDto> list);
}
