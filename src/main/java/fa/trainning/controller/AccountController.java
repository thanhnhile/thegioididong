package fa.trainning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fa.trainning.dto.AccountDto;
import fa.trainning.dto.AccountNoPassDto;
import fa.trainning.dto.StoreDto;
import fa.trainning.service.impl.AccountServiceImpl;
import fa.trainning.service.impl.StoreServiceImpl;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	@Autowired
	private AccountServiceImpl accountImpl;

	@GetMapping("/{userName}")
	public AccountNoPassDto getAccount(@PathVariable(value = "userName") String userName) {
		return accountImpl.getAccount(userName);
	}

	@PostMapping()
	public Boolean addAccount(@RequestBody AccountDto accountDto) {
		return accountImpl.addAccount(accountDto);
	}

	@DeleteMapping("/{userName}")
	public void deleteAccount(@PathVariable(value = "userName") String userName) {
		accountImpl.deleteAccount(userName);
	}

	@PutMapping("/{userName}")
	public void updateAccount(@PathVariable(value = "userName") String userName, @RequestBody AccountDto accountDto) {
		accountImpl.updateAccount(userName, accountDto);
	}

	@PutMapping("/property/{userName}")
	public void updatePropertyAccount(@PathVariable(value = "userName") String userName,
			@RequestBody AccountDto accountDto) {
		accountImpl.updatePropertyAccount(userName, accountDto);
	}
}
