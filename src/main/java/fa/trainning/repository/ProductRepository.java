package fa.trainning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fa.trainning.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
