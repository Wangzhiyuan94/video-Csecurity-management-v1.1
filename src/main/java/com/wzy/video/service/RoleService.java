package com.wzy.video.service;

import com.wzy.video.bean.Permissions;
import com.wzy.video.bean.Role;

import java.util.List;

public interface RoleService {

	

	public void save(Role role);


	public List<Role> findAll(Integer page, Integer size);

	public Role findById(String RoleId);
	
	public List<Permissions> findOtherPermissions(String PermissionId);
	
	public void addPermissionToRole(String roleId, String[] permissionIds);
}
