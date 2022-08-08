package fa.trainning.controller;

import javax.annotation.security.RolesAllowed;

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
import fa.trainning.dto.DataResponse;
import fa.trainning.service.impl.AccountServiceImpl;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	@Autowired
	private AccountServiceImpl accountImpl;

	@GetMapping()
	@RolesAllowed({"ROLE_ADMIN", "ROLE_CUSTOMER"})
	public DataResponse getAccount() {
		return  new DataResponse( accountImpl.getAllAccount());
	}

	@GetMapping("/{id}")
	@RolesAllowed({"ROLE_ADMIN", "ROLE_CUSTOMER"})

	public DataResponse getAccount(@PathVariable(value = "id") Integer id) {
		return  new DataResponse( accountImpl.getAccount(id));
	}

	@PostMapping("/access")
	public DataResponse addAccount(@RequestBody AccountDto accountDto) {
		return  new DataResponse( accountImpl.addAccount(accountDto));
	}

	@DeleteMapping("/{id}")
	@RolesAllowed({"ROLE_ADMIN", "ROLE_CUSTOMER"})
	public void deleteAccount(@PathVariable(value = "id") Integer id) {
		accountImpl.deleteAccount(id);
	}

	@PutMapping("/{id}")
	@RolesAllowed({"ROLE_ADMIN", "ROLE_CUSTOMER"})
	public DataResponse updateAccount(@PathVariable(value = "id") Integer id, @RequestBody AccountDto accountDto) {
		return  new DataResponse(accountImpl.updateAccount(id, accountDto));
	}

}
