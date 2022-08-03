package fa.trainning.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fa.trainning.dto.PagingProductDto;
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
			productToUpdate.setId(id);
			List<Image> newImages = productDto.getImages();
			List<Image> oldImages = productRepo.getReferenceById(id).getImages();
			oldImages.forEach(image -> {
				image.setProduct(null);
				imageRepo.save(image);
			});
			for(Image image:newImages) {
				image.setProduct(productToUpdate);
			}
			productToUpdate.setImages(newImages);
			
			return productMapper.productToProductDto(productRepo.save(productToUpdate));
		}else return null;
	}

	@Override
	public void deleteProduct(Integer id) {
		productRepo.deleteById(id);
	}

	@Override
	public PagingProductDto getAllProductPagnation(int offSet, int pageSize) {
		Pageable pageable = PageRequest.of(offSet-1, pageSize);
		Page<Product> page = productRepo.findAll(pageable);
		PagingProductDto response = new PagingProductDto();
		response.setCurrentPage(offSet);
		response.setPageSize(pageSize);
		response.setTotalElements(page.getTotalElements());
		response.setTotalPages(page.getTotalPages());
		List<ProductDto> listProductDtos = productMapper.productsToProductDtos(page.getContent());
		response.setListDtos(listProductDtos);
		return response;
	}

	@Override
	public PagingProductDto getProductByCategoryPaging(Integer categoryId, int offSet, int pageSize) {
		Pageable pageable = PageRequest.of(offSet-1, pageSize);
		Page<Product> page = productRepo.findByCategoryId(categoryId, pageable);
		PagingProductDto response = new PagingProductDto();
		response.setCurrentPage(offSet);
		response.setPageSize(pageSize);
		response.setTotalElements(page.getTotalElements());
		response.setTotalPages(page.getTotalPages());
		response.setListDtos(productMapper.productsToProductDtos(page.getContent()));
		return response;
	}


	

}
