package fa.trainning.converter;

import java.util.List;

import org.mapstruct.Mapper;

import fa.trainning.dto.ProductDTO;
import fa.trainning.entity.Product;

@Mapper
public interface ProductStructMapper {

	ProductDTO toProductDTO(Product product);

	List<ProductDTO> toProductDTOs(List<Product> list);

	Product toProduct(ProductDTO productDTO);

	List<Product> toProducts(List<ProductDTO> list);
}
