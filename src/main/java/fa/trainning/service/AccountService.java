package fa.trainning.service;

import java.util.List;

import fa.trainning.dto.AccountDto;
import fa.trainning.dto.AccountNoPassDto;


public interface AccountService {
	AccountNoPassDto getAccount(String userName);

	Boolean addAccount(AccountDto accountDto);

	void deleteAccount(String userName);

	AccountDto updateAccount(String userName, AccountDto accountDto);
	
	AccountDto updatePropertyAccount(String userName, AccountDto accountDto);
}
