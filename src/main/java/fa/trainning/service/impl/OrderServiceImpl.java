package fa.trainning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.trainning.dto.OrderDto;
import fa.trainning.entity.Order;
import fa.trainning.entity.OrderDetail;
import fa.trainning.entity.Store;
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
	public OrderDto updateStateOrder(Integer id, OrderDto orderDto) {
		Order orderNew = orderMapper.orderDtoToOrder(orderDto);
		Order orderOld = orderRepo.findOneById(id);
		if (!(orderNew.getState() == null)) {
			orderOld.setState(orderNew.getState());;
		}
		orderRepo.save(orderOld);
		return orderMapper.orderToOrderDto(orderOld);
	}

	@Override
	public void deleteOrder(Integer id) {
		orderRepo.deleteById(id);
	}

}
