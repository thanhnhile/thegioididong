package fa.trainning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.trainning.dto.OrderDto;
import fa.trainning.dto.OrderInPutDto;
import fa.trainning.entity.Order;
import fa.trainning.entity.OrderDetail;
import fa.trainning.mapstruct.OrderMapper;
import fa.trainning.repository.CustomerRepository;
import fa.trainning.repository.OrderDetailRepository;
import fa.trainning.repository.OrderRepository;
import fa.trainning.repository.StoreRepository;
import fa.trainning.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private CustomerRepository customerRepo;
	@Autowired
	private StoreRepository storeRepo;
	@Autowired
	private OrderDetailRepository orderDetailRepo;

	@Autowired
	private OrderMapper orderMapper;

	@Override
	public Object getAllOrders() {
		return orderMapper.ordersToOrderDtos(orderRepo.findAll());
	}

	@Override
	public Object getOrder(Integer id) {
		Order order = orderRepo.getReferenceById(id);
		return orderMapper.orderToOrderDto(order);
	}

	@Override
	public Object addOrder(OrderInPutDto orderInPutDto) {
		Order order = orderMapper.orderInPutDtoToOrder(orderInPutDto);
		order.setCustomer(customerRepo.findOneById(orderInPutDto.getCustomer_id()));
		order.setStore(storeRepo.findOneById(orderInPutDto.getStore_id()));
		orderRepo.save(order);
		OrderDto orderDto = orderMapper.orderToOrderDto(order);
		return orderDto;
	}

	@Override
	public void deleteOrder(Integer id) {
		orderRepo.deleteById(id);
	}

}
