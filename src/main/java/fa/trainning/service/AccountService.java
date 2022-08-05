package fa.trainning.service;

import fa.trainning.dto.AccountDto;


public interface AccountService {
	Object getAccount(String userName);

	Object addAccount(AccountDto accountDto);

	void deleteAccount(String userName);

	Object updateAccount(String userName, AccountDto accountDto);
	
	Object updatePropertyAccount(String userName, AccountDto accountDto);
}
