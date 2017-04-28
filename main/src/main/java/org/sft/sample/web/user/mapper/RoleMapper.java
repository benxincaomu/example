package org.sft.sample.web.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.sft.sample.web.user.model.Role;

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
	 * 查找角色
	 * @param roleName
	 * @return
	 */
	List<Role> findRoles(@Param("roleName") String roleName);
}
