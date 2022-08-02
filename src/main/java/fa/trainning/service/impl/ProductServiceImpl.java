package fa.trainning.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import fa.trainning.dto.ProductDto;
import fa.trainning.entity.Image;
import fa.trainning.entity.Product;
import fa.trainning.mapstruct.ProductMapper;
import fa.trainning.repository.ImageRepository;
import fa.trainning.repository.ProductRepository;
import fa.trainning.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private ImageRepository imageRepo;
	
	@Autowired
	private ProductMapper productMapper;

	@Override
	public List<ProductDto> getAllProducts() {
		return productMapper.productsToProductDtos(productRepo.findAll());
	}

	@Override
	public ProductDto getProduct(Integer id) {
		Product product = productRepo.getReferenceById(id);
		return productMapper.productToProductDto(product);
	}

	@Override
	public ProductDto addProduct(ProductDto productDto) {
		Product productToAdd = productMapper.productDtoToProduct(productDto);
		Product newestProduct = productRepo.save(productToAdd);
		for(Image image : newestProduct.getImages()) {
			image.setProduct(newestProduct);
			imageRepo.save(image);
		}
		return productMapper.productToProductDto(newestProduct);
	}

	@Override
	public ProductDto updateProrduct(Integer id, ProductDto productDto) {
		if(productRepo.findById(id).isPresent()) {
			Product productToUpdate = productMapper.productDtoToProduct(productDto);
			return productMapper.productToProductDto(productRepo.save(productToUpdate));
		}else return null;
	}

	@Override
	public void deleteProduct(Integer id) {
		productRepo.deleteById(id);
	}

}
