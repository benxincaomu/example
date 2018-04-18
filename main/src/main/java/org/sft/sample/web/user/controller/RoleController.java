package org.sft.sample.web.user.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.sft.sample.common.utils.SampleResultRender;
import org.sft.sample.web.user.model.Role;
import org.sft.sample.web.user.service.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("web/role")
public class RoleController{
	@Resource
	private RoleService roleService;

	/**
	 * 新增角色信息
	 * 
	 * @param role
	 * @return
	 */
	@PostMapping("addRole")
	public Map<String, Object> addRole(Role role){
		return SampleResultRender.render(roleService.addRole(role));
	}

	@GetMapping("findRoles")
	public PageInfo<Role> findRoles(String roleName,Page<Role> page){

		return roleService.findRoles(roleName, page);
	}

	@PostMapping("deleteRole")
	public Map<String, Object> deleteRole(String id){
		return SampleResultRender.render(roleService.deleteRole(id));
	}

	@GetMapping("getRole")
	public Role getRole(String id){
		return roleService.findRoleById(id);
	}

	@PostMapping("updateRole")
	public Map<String, Object> updateRole(Role role){
		return SampleResultRender.render(roleService.updateRole(role));
	}
	/**
	 * 获取所有权限列表
	 */
	public void getAllPermissions(){
		
	}
}
