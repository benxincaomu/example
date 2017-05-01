package org.sft.sample.web.user.controller;

import javax.annotation.Resource;

import org.sft.sample.web.user.model.Role;
import org.sft.sample.web.user.service.RoleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("web/role")
public class RoleController {
	@Resource
	private RoleService roleService;

	@PostMapping("addRole")
	public int addRole(Role role) {
		return roleService.addRole(role);
	}
}
