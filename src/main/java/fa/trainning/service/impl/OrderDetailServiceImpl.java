package fa.trainning.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.trainning.dto.OrderDetailInPutDto;
import fa.trainning.entity.Order;
import fa.trainning.entity.OrderDetail;
import fa.trainning.entity.Product;
import fa.trainning.mapstruct.OrderDetailMapper;
import fa.trainning.repository.OrderDetailRepository;
import fa.trainning.repository.OrderRepository;
import fa.trainning.repository.ProductRepository;
import fa.trainning.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	OrderDetailRepository detailRepo;
	@Autowired
	ProductRepository productRepo;
	@Autowired
	OrderRepository orderRepo;
	@Autowired
	OrderDetailMapper detailMapper;

	@Override
	public Object getOrderDetail(Integer id) {
		return detailMapper.orderDetailToOrderDetailDto(detailRepo.getReferenceById(id));
	}

	@Override
	public Object addOrderDetail(OrderDetailInPutDto orderDetailInPutDto) {
		OrderDetail orderDetailToAdd = detailMapper.orderDetailInPutDtoToOrderDetail(orderDetailInPutDto);
		Product product = productRepo.findOneById(orderDetailInPutDto.getProduct_id());
		Order order = orderRepo.findOneById(orderDetailInPutDto.getOrder_id());
		orderDetailToAdd.setOrder(order);
		orderDetailToAdd.setProduct(product);
		//Gia x so luong
		orderDetailToAdd.setTotalprice(product.getPrice() * orderDetailInPutDto.getQuantity());
		detailRepo.save(orderDetailToAdd);
		//set lai gia cua oder
		order.setTotal(order.getTotal() + orderDetailToAdd.getTotalprice());
		orderRepo.save(order);
		return detailMapper.orderDetailToOrderDetailDto(orderDetailToAdd);
	}

	@Override
	public void deleteOrderDetail(Integer id) {
		OrderDetail detail = detailRepo.findOneById(id);
		Order order = orderRepo.findOneById(detail.getOrder().getId());
		// Tru gia detail xoa
		order.setTotal(order.getTotal() - detail.getTotalprice());
		orderRepo.save(order);
		detailRepo.delete(detail);
	}

	@Override
	public Object updateOrderDetail(Integer id, Integer quanlity) {
		OrderDetail detail = detailRepo.findOneById(id);
		Order order = orderRepo.findOneById(detail.getOrder().getId());
		// Tru gia detail hien tai
		order.setTotal(order.getTotal() - detail.getTotalprice());
		orderRepo.save(order);
		// set lai gia moi update cua oderdetail
		detail.setQuantity(quanlity);
		detail.setTotalprice(detail.getQuantity() * detail.getProduct().getPrice());
		detailRepo.save(detail);
		// Cong lai vao Oder
		order.setTotal(order.getTotal() + detail.getTotalprice());
		orderRepo.save(order);
		return detailMapper.orderDetailToOrderDetailDto(detail);
	}

	@Override
	public Object getAllOrderDetail() {
		return detailMapper.orderDetailsToOrderDetailDtos(detailRepo.findAll());
	}

}
