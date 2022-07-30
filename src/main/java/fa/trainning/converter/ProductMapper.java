package fa.trainning.converter;

import org.mapstruct.Mapper;
import fa.trainning.dto.ProductDTO;
import fa.trainning.entity.Product;

import java.util.List;


@Mapper
public interface ProductMapper {
	ProductDTO toProductDTO(Product product);

	List<ProductDTO> toProductDTOs(List<Product> list);

	Product toProduct(ProductDTO productDTO);

	List<Product> toProducts(List<ProductDTO> list);
}