package fa.trainning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fa.trainning.entity.ProductStoreId;
import fa.trainning.entity.ProductsStores;

@Repository
public interface ProductsStoresRepository extends JpaRepository<ProductsStores, ProductStoreId>{
	
	@Query("SELECT p from ProductsStores p where product_id = :productId and store_id = :storeId")
	ProductsStores getProductStore(Integer productId,Integer storeId);
	
	@Modifying
	@Transactional
	@Query(value = "insert into products_stores (product_id,store_id,in_stock) values(:productId, :storeId, :inStock)", nativeQuery = true)
	void insertIntoProductsStores(Integer productId, Integer storeId, Integer inStock);
	
	@Modifying
	@Transactional
	@Query(value = "update products_stores set in_stock = :inStock where product_id = :productId and store_id = :storeId", nativeQuery = true)
	void updateIntoProductsStores(Integer productId, Integer storeId, Integer inStock);
}
