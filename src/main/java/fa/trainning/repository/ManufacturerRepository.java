package fa.trainning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fa.trainning.entity.Manufacturer;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer> {
	Manufacturer findOneById(Integer id);
}
