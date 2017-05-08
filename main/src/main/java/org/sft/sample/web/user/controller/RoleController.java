package org.sft.sample.web.user.controller;

import javax.annotation.Resource;

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
public class RoleController {
	@Resource
	private RoleService roleService;

	@PostMapping("addRole")
	public int addRole(Role role) {
		return roleService.addRole(role);
	}

	@GetMapping("findRoles")
	public PageInfo<Role> findRoles(String roleName, Page<Role> page) {

		return roleService.findRoles(roleName, page);
	}

	@PostMapping("deleteRole")
	public int deleteRole(String id) {
		return roleService.deleteRole(id);
	}
	@GetMapping("getRole")
	public Role getRole(String id){
		return roleService.findRoleById(id);
	}
	@PostMapping("updateRole")
	public int  updateRole(Role role){
		return roleService.updateRole(role);
	}
}
