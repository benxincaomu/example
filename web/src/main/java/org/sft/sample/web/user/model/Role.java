package org.sft.sample.web.user.model;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("role")
public class Role {
	
	private String id;
	private String roleName;
	private String description;
	private Date createTime;
	private boolean canDeleted;
	
	private List<Permission> permissions;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public boolean isCanDeleted() {
		return canDeleted;
	}

	public void setCanDeleted(boolean canDeleted) {
		this.canDeleted = canDeleted;
	}


}
