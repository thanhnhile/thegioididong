package fa.trainning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fa.trainning.entity.ProductPromotionId;
import fa.trainning.entity.ProductsPromotions;

@Repository
public interface ProductsPromotionsRepository extends JpaRepository<ProductsPromotions, ProductPromotionId>{
	@Modifying
	@Transactional
	@Query(value = "insert into products_promotions (product_id,promotion_id) values(:productId, :promotionId)", nativeQuery = true)
	void insertIntoProductsPromotions(Integer productId, Integer promotionId);
}
