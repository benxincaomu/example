package org.sft.sample.web.user.model;

import org.apache.ibatis.type.Alias;

@Alias("permission")
public class Permission {
	private String id;
	private String name;
	private String path;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
