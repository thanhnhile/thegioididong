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
import fa.trainning.dto.DataResponse;
import fa.trainning.dto.StoreDto;
import fa.trainning.service.impl.AccountServiceImpl;
import fa.trainning.service.impl.StoreServiceImpl;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	@Autowired
	private AccountServiceImpl accountImpl;

	@GetMapping("/{userName}")
	public DataResponse getAccount(@PathVariable(value = "userName") String userName) {
		return  new DataResponse( accountImpl.getAccount(userName));
	}

	@PostMapping()
	public DataResponse addAccount(@RequestBody AccountDto accountDto) {
		return  new DataResponse( accountImpl.addAccount(accountDto));
	}

	@DeleteMapping("/{userName}")
	public void deleteAccount(@PathVariable(value = "userName") String userName) {
		accountImpl.deleteAccount(userName);
	}

	@PutMapping("/{userName}")
	public DataResponse updateAccount(@PathVariable(value = "userName") String userName, @RequestBody AccountDto accountDto) {
		return  new DataResponse(accountImpl.updateAccount(userName, accountDto));
	}

	@PutMapping("/property/{userName}")
	public DataResponse updatePropertyAccount(@PathVariable(value = "userName") String userName,
			@RequestBody AccountDto accountDto) {
		return new DataResponse(accountImpl.updatePropertyAccount(userName, accountDto));
	}
}
