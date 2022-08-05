package fa.trainning.service;

import java.util.List;

import fa.trainning.dto.OrderDetailDto;

public interface OrderDetailService {
	List<OrderDetailDto> getOrderDetailsByOrderId(Integer orderId);
	
	OrderDetailDto getOrderDetail(Integer id);
	
	OrderDetailDto addOrderDetail(OrderDetailDto orderDetailDto);
}
