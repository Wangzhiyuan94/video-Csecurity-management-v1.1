package com.wzy.video.bean;

import java.util.List;

public class Role {

	
	private String id;
	private String roleName;
	private String roleDesc;
	private List<Permissions> permissions;
	private List<UserData> userData;
	public String getId() {
		return id;
	}
	
	
	public Role() {
		super();
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
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public List<Permissions> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Permissions> permissions) {
		this.permissions = permissions;
	}
	public List<UserData> getUserData() {
		return userData;
	}
	public void setUserData(List<UserData> userData) {
		this.userData = userData;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", roleDesc=" + roleDesc + ", permissions=" + permissions
				+ ", users=" + userData + "]";
	}
	
	
}
