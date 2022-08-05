package fa.trainning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.trainning.entity.OrderDetail;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer>{
	
//	@Query("SELECT o FROM order_detail o WHERE order_id = :orderId ORDER BY order_detail_ID")
//	List<OrderDetail> getOrderDetailsByOrderId(Integer orderId);
}
