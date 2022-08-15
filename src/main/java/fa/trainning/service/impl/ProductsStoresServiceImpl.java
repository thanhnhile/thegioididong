package fa.trainning.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.trainning.dto.ProductsStoresDto;
import fa.trainning.entity.ProductsStores;
import fa.trainning.mapstruct.ProductsStoresMapper;
import fa.trainning.repository.ProductRepository;
import fa.trainning.repository.ProductsStoresRepository;
import fa.trainning.repository.StoreRepository;
import fa.trainning.service.ProductsStoresService;

@Service
public class ProductsStoresServiceImpl implements ProductsStoresService {
	
	@Autowired
	private ProductsStoresRepository repo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private StoreRepository storeRepo;
	
	@Autowired
	private ProductsStoresMapper mapper;
		
	@Override
	public Object getAllProductsStores() {
		return mapper.toListProductsStoresDto(repo.findAll());
	}

	@Override
	public Object getProductsStores(Integer productId, Integer storeId) {
		ProductsStores productStore = repo.getProductStore(productId, storeId);
		return mapper.toProductsStoresDto(productStore);
	}

	@Override
	public Object addProductToStore(ProductsStoresDto productsStoresDto) {
		Integer productId = productsStoresDto.getProduct();
		Integer storeId = productsStoresDto.getStore();
		if(productRepo.findById(productId).isPresent() && storeRepo.findById(storeId).isPresent()) {
			repo.insertIntoProductsStores(productId,storeId, productsStoresDto.getInStock());
			return productsStoresDto;
		}
		return null;
	}

	@Override
	public Object updateProductInStore(ProductsStoresDto productsStoresDto) {
		Integer productId = productsStoresDto.getProduct();
		Integer storeId = productsStoresDto.getStore();
		ProductsStores productStore = repo.getProductStore(productId, storeId);
		if(productStore != null) {
			repo.updateIntoProductsStores(productId, storeId, productsStoresDto.getInStock());
			productStore.setInStock(productsStoresDto.getInStock());
			return mapper.toProductsStoresDto(productStore);
		}
		return null;
	}

}
