package com.wzy.video.dao;

import com.wzy.video.bean.Permissions;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDao {

	
	@Select("select * from permission where id in(select pid from role_permission where rid = #{id})")
	public List<Permissions> findPermissionByRoleId(String id);
	
	@Select("select * from permission")
	public List<Permissions> findAll();
	 
	@Insert("insert into permission values(#{id},#{permissionName},#{url})")
	public void save(Permissions permissions);
}
