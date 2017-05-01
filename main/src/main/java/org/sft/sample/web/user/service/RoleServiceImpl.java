package org.sft.sample.web.user.service;

import javax.annotation.Resource;

import org.sft.sample.web.user.mapper.RoleMapper;
import org.sft.sample.web.user.model.Permission;
import org.sft.sample.web.user.model.Role;
import org.sft.sample.web.user.model.RolePermission;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {
	@Resource
	private RoleMapper roleMapper;

	@Override
	public int addRole(Role role) {
		return roleMapper.addRole(role);
	}

	@Override
	public int updateRole(Role role) {
		return roleMapper.updateRole(role);
	}

	@Override
	public Role findRoleById(String id) {
		return roleMapper.findRoleById(id);
	}

	@Override
	public int deleteRole(String id) {
		return roleMapper.deleteRole(id);
	}

	@Override
	@Transactional
	public int updateRolePermissions(Role role) {
		int a = 0;
		for (Permission permission : role.getPermissions()) {
			RolePermission rolePermission = new RolePermission(role.getId(), permission.getId());
			a += roleMapper.addRolePermission(rolePermission);
		}
		return a;
	}

}
