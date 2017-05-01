package org.sft.sample.web.user.service;

import org.sft.sample.web.user.model.Role;

public interface RoleService {
	/**
	 * 新增角色
	 * 
	 * @param role
	 *            角色信息
	 * @return result
	 */
	int addRole(Role role);

	/**
	 * 修改角色
	 * 
	 * @param role
	 *            角色信息
	 * @return result
	 */
	int updateRole(Role role);

	/**
	 * 根据id获取角色信息
	 * 
	 * @param id
	 *            id
	 * @return
	 */
	Role findRoleById(String id);

	/**
	 * 删除角色
	 * 
	 * @param id
	 *            id
	 * @return
	 */
	int deleteRole(String id);

	/**
	 * 修改角色授权
	 * @param role 角色信息，至少包含id和permissions
	 * @return
	 */
	int updateRolePermissions(Role role);
}
