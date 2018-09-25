package org.sft.sample.web.user.service;

import java.util.List;

import org.sft.sample.web.user.model.Permission;
import org.sft.sample.web.user.model.Role;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

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
	 * 查询并分页
	 * @param roleName 角色名
	 * @param page 分页信息
	 * @return
	 */
	PageInfo<Role> findRoles(String roleName,Page<Role> page);


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
	
	/**
	 * 获取所有权限列表
	 * @return
	 */
	List<Permission> getAllPermissions();
}
