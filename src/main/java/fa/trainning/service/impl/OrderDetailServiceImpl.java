package fa.trainning.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.trainning.dto.OrderDetailDto;
import fa.trainning.entity.OrderDetail;
import fa.trainning.mapstruct.OrderMapper;
import fa.trainning.repository.OrderDetailRepository;
import fa.trainning.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{

	@Autowired
	OrderDetailRepository detailRepo;
	
	@Autowired
	OrderMapper detailMapper;
	
//	@Override
//	public List<OrderDetailDto> getOrderDetailsByOrderId(Integer orderId) {
//		return detailMapper.orderDetailsToOrderDetailDtos(detailRepo.getOrderDetailsByOrderId(orderId));
//	}

	@Override
	public OrderDetailDto getOrderDetail(Integer id) {
		return detailMapper.orderDetailToOrderDetailDto(detailRepo.getReferenceById(id));
	}

	@Override
	public OrderDetailDto addOrderDetail(OrderDetailDto orderDetailDto) {
		OrderDetail orderDetailToAdd = detailMapper.orderDetailDtoToOrderDetail(orderDetailDto);
		return detailMapper.orderDetailToOrderDetailDto(detailRepo.save(orderDetailToAdd));
	}


}
