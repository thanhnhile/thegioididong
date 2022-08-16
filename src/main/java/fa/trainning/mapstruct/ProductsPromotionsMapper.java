package fa.trainning.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import fa.trainning.dto.ProductsPromotionsDto;
import fa.trainning.entity.ProductsPromotions;

@Mapper(componentModel="spring")
public interface ProductsPromotionsMapper {
	//-------------------Entity To Dto------------------------
		@Mapping(source="promotion.id",target="promotion")
		@Mapping(source="product.id",target="product")
		ProductsPromotionsDto toProductsPromotionsDto(ProductsPromotions productsPromotions);
		
		List<ProductsPromotionsDto> toListProductsPromotionsDto(List<ProductsPromotions> list);
		//-------------------Dto To Entity------------------------
		@Mapping(source="promotion",target="promotion.id")
		@Mapping(source="product",target="product.id")
		ProductsPromotions toProductsPromotions(ProductsPromotionsDto productsPromotionsDto);
		
		List<ProductsPromotionsDto> toListProductsPromotions(List<ProductsPromotionsDto> list);
}
