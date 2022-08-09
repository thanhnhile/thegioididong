package fa.trainning.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;

import fa.trainning.dto.CustomerDto;
import fa.trainning.entity.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
	CustomerDto customerToCustomerDto(Customer customer);

	List<CustomerDto> customersToCustomerDtos(List<Customer> customers);

	Customer customerDtoToCustomer(CustomerDto customerDto);
}
