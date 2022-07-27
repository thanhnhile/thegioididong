package fa.trainning.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import fa.trainning.entity.Products;


public interface ProductsRepository extends JpaRepository<Products, Long> {
	Products findOneById(Long code);
}
