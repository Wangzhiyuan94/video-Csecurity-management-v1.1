package com.wzy.video.service;


import com.wzy.video.bean.Role;
import com.wzy.video.bean.UserData;
import com.wzy.video.dao.UserDao;
import com.wzy.video.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		
		if(username==""){
			throw new CustomException("用户名不能为空");
		}
		
		UserData userInfo = userDao.findByUsername(username);
		System.out.println("userInfo:"+userInfo);
		/*if(null!=users&& users.size()>0 && null!=users.get(0)){
			 userInfo = users.get(0);
			 
			 System.out.println(users);
			 if(null != userInfo.getRoles()&&userInfo.getRoles().size()>0&&null!=userInfo.getRoles().get(0)){
				 
				 for (User user : users) {
					 
					 userInfo.getRoles().add(user.getRoles().get(0));	
				 }
				userInfo.getRoles().remove(0); 
			 }
		}
		System.out.println(userInfo);*/
		
		//处理自己的用户对象封装成UserDetails
		/*org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(userInfo.getName(),userInfo.getPassword(),getAuthority(userInfo.getRoles()));*/
		org.springframework.security.core.userdetails.User user1 = new org.springframework.security.core.userdetails.User( userInfo.getName(),userInfo.getPassword(),userInfo.getStatus()==0?false:true,true,true,true,getAuthority(userInfo.getRoles()));
		return user1;

	}
	//返回一个List集合 集合中装入权限集合
	public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
		
		
		List<SimpleGrantedAuthority> list = new ArrayList<>();
		for(Role role:roles)
		{
			list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
		}
		System.out.println(list);
		return list;
	}
	

}
