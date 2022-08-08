package fa.trainning.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;

import fa.trainning.dto.AccountDto;
import fa.trainning.dto.AccountNoPassDto;
import fa.trainning.entity.Account;


@Mapper(componentModel = "spring")
public interface AccountMapper {
	// ----------------------------Entity To DTO---------------------------

	AccountDto accountToAccountDto(Account account);
	
	AccountNoPassDto accountToAccountNoPassDto(Account account);

	List<AccountDto> accountsToAccountDtos(List<Account> accounts);
	
	List<AccountNoPassDto> accountsToAccountNoPassDtos(List<Account> accounts);


	// ---------------------------DTO To Entity----------------------

	Account accountDtoToAccount(AccountDto accountDto);
	

}
