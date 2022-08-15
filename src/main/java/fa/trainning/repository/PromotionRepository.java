package fa.trainning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fa.trainning.entity.Promotion;

public interface PromotionRepository extends JpaRepository<Promotion, Integer>{
	Promotion findOneById(Integer id);
}
