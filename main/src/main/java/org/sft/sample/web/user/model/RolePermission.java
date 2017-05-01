package org.sft.sample.web.user.model;

import org.apache.ibatis.type.Alias;

@Alias("rolePermission")
public class RolePermission {
	
	
	public RolePermission() {
		super();
	}

	public RolePermission(String roleId, String permissionId) {
		super();
		this.roleId = roleId;
		this.permissionId = permissionId;
	}

	private String id;
	/** 角色id */
	private String roleId;
	/** 权限id */
	private String permissionId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}

}
