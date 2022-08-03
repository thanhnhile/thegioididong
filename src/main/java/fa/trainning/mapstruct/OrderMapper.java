package fa.trainning.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;

import fa.trainning.dto.OrderDetailDto;
import fa.trainning.entity.OrderDetail;

@Mapper(componentModel = "spring")
public interface OrderMapper {
	//----------------------------OrderDetail---------------------------
	//Entity to Dto
	OrderDetailDto orderDetailToOrderDetailDto(OrderDetail orderDetail);
	List<OrderDetailDto> orderDetailsToOrderDetailDtos(List<OrderDetail> list);
	//Dto to Entity
	OrderDetail orderDetailDtoToOrderDetail(OrderDetailDto detailDto);
	List<OrderDetail> orderDetailDtosToOrderDetails(List<OrderDetailDto> list);
	
	//----------------------------Order---------------------------------
}
