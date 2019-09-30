package com.wzy.video.service;

import com.github.pagehelper.PageHelper;
import com.wzy.video.bean.Permissions;
import com.wzy.video.dao.PermissionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionDao permissionDao;
	

/*	@Override
	public User queryByNameAndPwd(String name, String pwd) {
		
		User user =null;
		user = permissionDao.queryByNameAndPwd(name, pwd);
		 return user;
	}*/

	@Override
	public void save(Permissions permission) {
		permission.setId(UUID.randomUUID().toString());
		permissionDao.save(permission);
	}


	@Override
	public List<Permissions> findAll(Integer page,Integer size) {
		PageHelper.startPage(page,size);
		return permissionDao.findAll();
	}
	

/*	@Override
	public User findById(String id) {
		
		return userdao.findById(id);
	}*/

}
