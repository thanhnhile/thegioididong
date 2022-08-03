package fa.trainning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fa.trainning.dto.RoleDto;
import fa.trainning.entity.Role;
import fa.trainning.mapstruct.RoleMapper;
import fa.trainning.repository.RoleRepository;
import fa.trainning.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	public RoleServiceImpl(RoleMapper roleMapper, RoleRepository roleRepo) {
		this.roleMapper = roleMapper;
		this.roleRepo = roleRepo;
	}

	@Override
	public List<RoleDto> getAllRolePagnation(int offSet,int pageSize) {
		Page<Role> page=  roleRepo.findAll(PageRequest.of(offSet, pageSize));
		return roleMapper.rolesToRoleDtos(page.getContent());
	}

	@Override
	public List<RoleDto> getAllRole() {
		return roleMapper.rolesToRoleDtos(roleRepo.findAll());
	}
	
	@Override
	public RoleDto getRole(Integer id) {
		return roleMapper.roleToRleDto(roleRepo.findOneById(id));
	}

	@Override
	public void addRole(RoleDto roleDto) {
		roleRepo.save(roleMapper.roleDtoToRole(roleDto));
	}

	@Override
	public void deleteRole(Integer id) {
		roleRepo.delete(roleRepo.findOneById(id));
	}

	@Override
	public RoleDto updateRole(Integer id, RoleDto roleDto) {
		Role RoleNew = roleMapper.roleDtoToRole(roleDto);
		Role RoleOld = roleRepo.findOneById(id);
		RoleOld.setName(RoleNew.getName());
		roleRepo.save(RoleOld);
		return roleMapper.roleToRleDto(RoleOld);
	}

}
