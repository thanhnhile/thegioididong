package fa.trainning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.trainning.entity.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	Order findOneById(Integer id);
}
