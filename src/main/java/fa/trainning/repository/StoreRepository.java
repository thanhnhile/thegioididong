package fa.trainning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.trainning.entity.Store;


@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {
	Store findOneById(Integer id);
	
}
