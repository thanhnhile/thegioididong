package fa.trainning.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;

import fa.trainning.dto.RoleDto;
import fa.trainning.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
	// ----------------------------Entity To DTO---------------------------
	RoleDto roleToRleDto(Role role);

	List<RoleDto> rolesToRoleDtos(List<Role> roles);

	
	// ---------------------------DTO To Entity----------------------
	Role roleDtoToRole(RoleDto roleDto);

}
