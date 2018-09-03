package org.sft.sample.web.user.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sft.sample.common.utils.SampleResultRender;
import org.sft.sample.web.user.model.Permission;
import org.sft.sample.web.user.model.Role;
import org.sft.sample.web.user.service.RoleService;
import org.springframework.beans.factory.annotation.Value;
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
	@Value("remoteP")
	private String remoteP;
	
	private final Logger log=LogManager.getLogger(getClass());

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
		log.info("remoteP="+remoteP);
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
	@GetMapping("permissions")
	public List<Permission> getAllPermissions(){
		return roleService.getAllPermissions();
	}
	/**
	 * 获取当前角色所拥有的权限
	 * @return
	 */
	@GetMapping("rolePermissions")
	public List<Permission> getRolePermissions(){
		return null;
	}
}
