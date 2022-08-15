package fa.trainning.service;

import fa.trainning.dto.ProductsStoresDto;

public interface ProductsStoresService {
	Object getAllProductsStores();
	
	Object getProductsStores(Integer productId,Integer storeId);
	
	Object addProductToStore(ProductsStoresDto productsStoresDto);
	
	Object updateProductInStore(ProductsStoresDto productsStoresDto);
	
}	
