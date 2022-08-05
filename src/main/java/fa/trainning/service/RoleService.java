package fa.trainning.service;

import java.util.List;

import fa.trainning.dto.RoleDto;

public interface RoleService {
	Object getAllRole();

	Object getAllRolePagnation(int offSet, int pageSize);

	Object getRole(Integer id);

	Object addRole(RoleDto roleDto);

	void deleteRole(Integer id);

	Object updateRole(Integer id, RoleDto roleDto);
}
