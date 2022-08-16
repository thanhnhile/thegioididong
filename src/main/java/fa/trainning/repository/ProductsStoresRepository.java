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
	
	@Query(value = "SELECT p FROM products_stores p WHERE product_id = :productId AND store_id = :storeId", nativeQuery = true)
	ProductsStores getProductStore(Integer productId,Integer storeId);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO products_stores (product_id,store_id,in_stock) VALUES(:productId, :storeId, :inStock)", nativeQuery = true)
	void insertIntoProductsStores(Integer productId, Integer storeId, Integer inStock);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE products_stores set in_stock = :inStock WHERE product_id = :productId AND store_id = :storeId", nativeQuery = true)
	void updateIntoProductsStores(Integer productId, Integer storeId, Integer inStock);
}
