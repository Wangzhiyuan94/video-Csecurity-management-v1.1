package com.wzy.video.service;

import com.wzy.video.bean.Permissions;

import java.util.List;

public interface PermissionService {

	

	public void save(Permissions permission);


	public List<Permissions> findAll(Integer page, Integer size);
	
	//public permission findById (String id);
	
}
