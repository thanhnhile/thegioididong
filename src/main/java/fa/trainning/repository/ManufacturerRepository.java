package fa.trainning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.trainning.entity.Manufacturer;


@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer> {
	Manufacturer findOneById(Integer id);
}
