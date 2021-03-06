package org.sft.sample.web.user.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sft.sample.web.user.model.Permission;
import org.sft.sample.web.user.model.Role;
import org.sft.sample.web.user.model.RolePermission;

@Mapper
public interface RoleMapper {
	/**
	 * 
	 * @param role
	 * @return
	 */
	int addRole(Role role);
	
	/**
	 * 获取角色详情
	 * @param id
	 * @return
	 */
	Role findRoleById(@Param("id") String id);
	
	/**
	 * 根据角色名获取角色详情
	 * @param roleName 角色名
	 * @return
	 */
	Role getRoleByRoleName(@Param("roleName") String roleName);
	/**
	 * 查找角色
	 * @param roleName
	 * @return
	 */
	List<Role> findRoles(@Param("roleName") String roleName);
	
	/**
	 * 更新角色信息
	 * @param role 角色
	 * @return
	 */
	int updateRole(Role role);
	
	/**
	 * 删除角色
	 * @param id id
	 * @return
	 */
	int deleteRole(@Param("id")String id);
	
	
	
	/**
	 * 删除角色授权
	 * @param roleId 角色id
	 * @return
	 */
	int deleteRolePermissions(String roleId);
	
	/**
	 * 添加角色授权
	 * @param rolePermission
	 * @return
	 */
	int addRolePermission(RolePermission rolePermission);
	/**
	 * 获取所有的权限列表
	 * @return
	 */
	public List<Permission> getAllPermissions();
}
