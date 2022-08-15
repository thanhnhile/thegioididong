package fa.trainning.service;

import fa.trainning.dto.OrderInPutDto;

public interface OrderService {
	Object getAllOrders();

	Object getOrder(Integer id);

	Object addOrder(OrderInPutDto orderInPutDto);
	
	void deleteOrder(Integer id);
}
