package fa.trainning.converter;

import org.mapstruct.Mapper;

import fa.trainning.dto.ProductDTO;
import fa.trainning.entity.Product;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductDTO toProductDTO(Product product);

    List<ProductDTO> toProductDTOs(List<Product> products);

    Product toProductEntity(ProductDTO productDTO);
    Product toProductEntity(ProductDTO productDTO, Product product);
}