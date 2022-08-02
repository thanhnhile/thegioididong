package fa.trainning.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.trainning.converter.ProductMapper;
import fa.trainning.dto.ProductDTO;
import fa.trainning.entity.Product;
import fa.trainning.repository.ProductsRepository;
import fa.trainning.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	public ProductsRepository productRepo;
	@Autowired
	private ProductMapper productMapper;

	@Override
	public List<ProductDTO> getAllProducts() {
		List<Product> listproduct = new ArrayList<>();
		productRepo.findAll().forEach(listproduct::add);
		return productMapper.toProductDTOs(listproduct);
	}

//	@Override
//	public List<ProductDTO> getProductsByCategory(Integer category_id) {
//		List<Product> listproduct = new ArrayList<>();
//		productRepo.findByCategory(category_id).forEach(listproduct::add);
//		return productMapper.toProductDTOs(listproduct);
//	}
//
//	@Override
//	public List<ProductDTO> getProductsByManufacturer(Integer manufacturer_id) {
//		List<Product> listproduct = new ArrayList<>();
//		productRepo.findByManufacturer(manufacturer_id).forEach(listproduct::add);
//		return productMapper.toProductDTOs(listproduct);
//	}

	@Override
	public ProductDTO getProduct(Integer id) {
		Product product = new Product();
		productRepo.findOneById(id);
		return productMapper.toProductDTO(product);
	}

	@Override
	public ProductDTO addProducts(ProductDTO productsDTO) {
		Product product = productMapper.toProduct(productsDTO);
		product = productRepo.save(product);
		return productMapper.toProductDTO(product);
	}

	// Check update with no ID is create new object
	@Override
	public ProductDTO updateAllPropertyProducts(Integer id, ProductDTO productDTO) {
		/*
		 * Product product = new Product(); if (productDTO.getId() != null) { Product
		 * oldProduct = productRepo.findOneById(productDTO.getId()); product =
		 * productMapper.toProductEntity(productDTO, oldProduct); } else { product =
		 * productMapper.toProductEntity(productDTO); } product =
		 * productRepo.save(product); return productMapper.toProductDTO(product);
		 */
		return null;
	}


	@Override
	public void deleteProduct(Integer id) {
		productRepo.deleteById(id);
	}

	@Override
	public ProductDTO updateProducts(ProductDTO productsDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}