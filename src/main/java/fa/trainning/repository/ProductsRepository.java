package fa.trainning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fa.trainning.entity.ProductsEntity;


public interface ProductsRepository extends JpaRepository<ProductsEntity, Long> {

}
