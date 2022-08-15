package fa.trainning.service;


import fa.trainning.dto.OrderDetailInPutDto;

public interface OrderDetailService {
	Object getAllOrderDetail();
	Object getOrderDetail(Integer id);
	void deleteOrderDetail(Integer id);
	Object addOrderDetail(OrderDetailInPutDto orderDetailInPutDto);
	Object updateOrderDetail(Integer id,Integer quanlity);
}
