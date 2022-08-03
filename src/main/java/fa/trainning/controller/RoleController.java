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

import fa.trainning.dto.RoleDto;
import fa.trainning.service.impl.RoleServiceImpl;

@RestController
@RequestMapping("/roles")
public class RoleController {
	@Autowired
	private RoleServiceImpl roleImpl;

	@GetMapping()
	public List<RoleDto> getAllRole() {
		return roleImpl.getAllRole();
	}

	@GetMapping("/{offSet}/{pageSize}")
	public List<RoleDto> getAllRole(@PathVariable int offSet, @PathVariable int pageSize) {
		return roleImpl.getAllRolePagnation(offSet, pageSize);
	}

	@GetMapping("/{role_id}")
	public RoleDto getCategory(@PathVariable(value = "role_id") Integer role_id) {
		return roleImpl.getRole(role_id);
	}

	@PostMapping()
	public void addRole(@RequestBody RoleDto roleDto) {
		roleImpl.addRole(roleDto);
	}

	@DeleteMapping("/{role_id}")
	public void deleteRole(@PathVariable(value = "role_id") Integer role_id) {
		roleImpl.deleteRole(role_id);
	}

	@PutMapping("/{role_id}")
	public void updateRole(@PathVariable(value = "role_id") Integer role_id, @RequestBody RoleDto roleDto) {
		roleImpl.updateRole(role_id, roleDto);
	}
}
