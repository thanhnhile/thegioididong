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

import fa.trainning.dto.DataResponse;
import fa.trainning.dto.RoleDto;
import fa.trainning.service.impl.RoleServiceImpl;

@RestController
@RequestMapping("/roles")
public class RoleController {
	@Autowired
	private RoleServiceImpl roleImpl;

	@GetMapping()
	public DataResponse getAllRole() {
		return new DataResponse( roleImpl.getAllRole());
	}

	@GetMapping("/{offSet}/{pageSize}")
	public DataResponse getAllRole(@PathVariable int offSet, @PathVariable int pageSize) {
		return new DataResponse( roleImpl.getAllRolePagnation(offSet, pageSize));
	}

	@GetMapping("/{role_id}")
	public DataResponse getCategory(@PathVariable(value = "role_id") Integer role_id) {
		return new DataResponse( roleImpl.getRole(role_id));
	}

	@PostMapping()
	public DataResponse addRole(@RequestBody RoleDto roleDto) {
		return new DataResponse(roleImpl.addRole(roleDto));
	}

	@DeleteMapping("/{role_id}")
	public void deleteRole(@PathVariable(value = "role_id") Integer role_id) {
		roleImpl.deleteRole(role_id);
	}

	@PutMapping("/{role_id}")
	public DataResponse updateRole(@PathVariable(value = "role_id") Integer role_id, @RequestBody RoleDto roleDto) {
		return new DataResponse(roleImpl.updateRole(role_id, roleDto));
	}
}
