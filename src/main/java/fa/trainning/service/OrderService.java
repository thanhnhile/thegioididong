package fa.trainning.service;

import java.util.List;

import fa.trainning.dto.OrderDto;

public interface OrderService {
	List<OrderDto> getAllOrders();

	OrderDto getOrder(Integer id);

	OrderDto addOrder(OrderDto orderDto);

	OrderDto updateStateOrder(Integer id, OrderDto orderDto);

	void deleteOrder(Integer id);
}
