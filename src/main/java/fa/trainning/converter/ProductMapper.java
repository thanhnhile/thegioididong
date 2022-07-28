package fa.trainning.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fa.trainning.dto.ProductDTO;
import fa.trainning.entity.Product;

import java.util.List;


@Mapper
public interface ProductMapper {
	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO toProductDTO(Product product);

    List<ProductDTO> toProductDTOs(List<Product> products);

    Product toProductEntity(ProductDTO productDTO);
    Product toProductEntity(ProductDTO productDTO, Product product);
}