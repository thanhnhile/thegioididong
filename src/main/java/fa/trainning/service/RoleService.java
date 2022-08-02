package fa.trainning.service;

import java.util.List;

import fa.trainning.dto.RoleDto;

public interface RoleService {
	List<RoleDto> getAllRole();

	List<RoleDto> getAllRolePagnation(int offSet, int pageSize);

	RoleDto getRole(Integer id);

	void addRole(RoleDto roleDto);

	void deleteRole(Integer id);

	RoleDto updateRole(Integer id, RoleDto roleDto);
}
