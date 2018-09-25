package org.sft.sample.web.user.model;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("permission")
public class Permission{
	private String id;
	private String name;
	private String path;
	private String parentId;
	private List<Permission> subPermissions;

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getPath(){
		return path;
	}

	public void setPath(String path){
		this.path = path;
	}

	public String getParentId(){
		return parentId;
	}

	public void setParentId(String parentId){
		this.parentId = parentId;
	}

	public List<Permission> getSubPermissions(){
		return subPermissions;
	}

	public void setSubPermissions(List<Permission> subPermissions){
		this.subPermissions = subPermissions;
	}

}
