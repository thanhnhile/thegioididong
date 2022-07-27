package fa.trainning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fa.trainning.entity.Product;

public interface ProductsRepository extends JpaRepository<Product, Integer> {
	Product findOneById(Integer id);

	List<Product> findByCategory(Integer category_id);

	List<Product> findByManufacturer(Integer manufacturer_id);
}