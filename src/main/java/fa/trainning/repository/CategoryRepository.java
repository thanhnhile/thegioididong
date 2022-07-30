package fa.trainning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.trainning.entity.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	Category findOneById(Integer id);
}
