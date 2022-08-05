package fa.trainning.service;

import java.util.List;

import fa.trainning.dto.AccountDto;
import fa.trainning.dto.AccountNoPassDto;


public interface AccountService {
	Object getAccount(String userName);

	Object addAccount(AccountDto accountDto);

	void deleteAccount(String userName);

	Object updateAccount(String userName, AccountDto accountDto);
	
	Object updatePropertyAccount(String userName, AccountDto accountDto);
}
