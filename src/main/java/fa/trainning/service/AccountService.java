package fa.trainning.service;

import fa.trainning.dto.AccountDto;


public interface AccountService {
	Object getAccount(Integer id);
	
	Object getAllAccount();

	Object addAccount(AccountDto accountDto);

	void deleteAccount(Integer id);

	Object updateAccount(Integer id, AccountDto accountDto);
	
}
