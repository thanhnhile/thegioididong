package fa.trainning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.trainning.dto.OrderDto;
import fa.trainning.entity.Order;
import fa.trainning.entity.OrderDetail;
import fa.trainning.mapstruct.OrderMapper;
import fa.trainning.repository.OrderDetailRepository;
import fa.trainning.repository.OrderRepository;
import fa.trainning.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private OrderDetailRepository orderDetailRepo;

	@Autowired
	private OrderMapper orderMapper;

	@Override
	public List<OrderDto> getAllOrders() {
		return orderMapper.ordersToOrderDtos(orderRepo.findAll());
	}

	@Override
	public OrderDto getOrder(Integer id) {
		Order order = orderRepo.getReferenceById(id);
		return orderMapper.orderToOrderDto(order);
	}

	@Override
	public OrderDto addOrder(OrderDto orderDto) {
		Order orderToAdd = orderMapper.orderDtoToOrder(orderDto);
		Order order = orderRepo.save(orderToAdd);
		for (OrderDetail orderDetail : order.getDetails()) {
			orderDetail.setOrder(order);
			orderDetailRepo.save(orderDetail);
		}
		return orderMapper.orderToOrderDto(order);
	}

	@Override
	public OrderDto updateOrder(Integer id, OrderDto orderDto) {
//		if (orderRepo.findById(id).isPresent()) {
//			Order orderToUpdate = orderMapper.orderDtoToOrder(orderDto);
//			orderToUpdate.setId(id);
//			List<OrderDetail> newOrderDetails = orderDto.getDetails();
//			List<OrderDetail> oldOrderDetails = orderRepo.getReferenceById(id).getDetails();
//			oldOrderDetails.forEach(detail -> {
//				detail.setOrder(null);
//				orderDetailRepo.save(detail);
//			});
//			for (OrderDetail orderDetail : newOrderDetails) {
//				orderDetail.setOrder(orderToUpdate);
//			}
//			orderToUpdate.setDetails(newOrderDetails);
//			return orderMapper.orderToOrderDto(orderRepo.save(orderToUpdate));
//		} else
			return null;
	}

	@Override
	public void deleteOrder(Integer id) {
		orderRepo.deleteById(id);
	}

}
