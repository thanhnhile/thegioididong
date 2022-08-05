package fa.trainning.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.trainning.dto.AccountDto;
import fa.trainning.dto.AccountNoPassDto;
import fa.trainning.entity.Account;
import fa.trainning.entity.Role;
import fa.trainning.mapstruct.AccountMapper;
import fa.trainning.repository.AccountRepository;
import fa.trainning.repository.RoleRepository;
import fa.trainning.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	//Get Role ADD To Account
	@Autowired
	private RoleRepository roleRepo;

	//Account

	@Autowired
	private AccountRepository accountRepo;
	@Autowired
	private AccountMapper accountMapper;
	
	
	@Autowired
	public AccountServiceImpl(AccountMapper accountMapper, AccountRepository accountRepo) {
		this.accountMapper = accountMapper;
		this.accountRepo = accountRepo;
	}
	
	
	@Override
	public Object getAccount(String userName) {
		Account account = accountRepo.findOneByUserName(userName);
		AccountNoPassDto accountNoPassDto = accountMapper.accountToAccountNoPassDto(account);
		accountNoPassDto.setRole_id(account.getRole().getId());
		return accountNoPassDto;
	}

	@Override
	public Object addAccount(AccountDto accountDto) {
		Account account = accountMapper.accountDtoToAccount(accountDto);
		Role role = new Role();
		role = roleRepo.findOneById(accountDto.getRole_id());
		if (!role.equals(null)) {
			account.setRole(role);
			accountRepo.save(account);
			return true;
		}
		return false;
		
	}

	@Override
	public void deleteAccount(String userName) {
		accountRepo.delete(accountRepo.findOneByUserName(userName));
	}

	@Override
	public Object updateAccount(String userName, AccountDto accountDto) {
		Account accountNew = accountMapper.accountDtoToAccount(accountDto);
		Account accountOld = accountRepo.findOneByUserName(userName);
		Role role = roleRepo.findOneById(accountDto.getRole_id());
		if(!role.equals(null))
		{
			accountOld.setPassWord(accountNew.getPassWord());
			accountOld.setRole(role);
			accountRepo.save(accountOld);
			return accountMapper.accountToAccountDto(accountOld);
		}
		return null;
		
	}

	@Override
	public Object updatePropertyAccount(String userName, AccountDto accountDto) {
		Account accountNew = accountMapper.accountDtoToAccount(accountDto);
		Account accountOld = accountRepo.findOneByUserName(userName);
		if (!(accountNew.getPassWord() == null)) {
			accountOld.setPassWord(accountNew.getPassWord());
		}
		if (!(accountDto.getRole_id() == null)) {
			accountOld.setRole(roleRepo.findOneById(accountDto.getRole_id()));
		}
		accountRepo.save(accountOld);
		return accountMapper.accountToAccountDto(accountOld);
	}

}
