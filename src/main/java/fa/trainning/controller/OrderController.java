package fa.trainning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fa.trainning.dto.OrderDto;
import fa.trainning.service.impl.OrderServiceImpl;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {
	@Autowired
	private OrderServiceImpl orderService;

	@GetMapping
	public List<OrderDto> getAllOrders() {
		return orderService.getAllOrders();
	}

	@GetMapping(value = "/{id}")
	public OrderDto getOrder(@PathVariable(value = "id") Integer id) {
		return orderService.getOrder(id);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteOrder(@PathVariable(value = "id") Integer id) {
		orderService.deleteOrder(id);
	}

	@PostMapping
	public OrderDto addOrder(@Validated @RequestBody OrderDto OrderDto) {
		return orderService.addOrder(OrderDto);
	}

	@PutMapping(value = "/{id}")
	public OrderDto updateOrder(@PathVariable(value = "id") Integer id,
			@Validated @RequestBody OrderDto orderDto) {
		return orderService.updateOrder(id, orderDto);
	}
}
