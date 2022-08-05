package fa.trainning.service;


import fa.trainning.dto.OrderDetailDto;

public interface OrderDetailService {
	//List<OrderDetailDto> getOrderDetailsByOrderId(Integer orderId);
	
	Object getOrderDetail(Integer id);
	
	Object addOrderDetail(OrderDetailDto orderDetailDto);
}
