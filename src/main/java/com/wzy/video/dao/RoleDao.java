package com.wzy.video.dao;

import com.wzy.video.bean.Permissions;
import com.wzy.video.bean.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleDao {

	 
	//根据Id查询出所有对应的角色 3表关联不容易
	@Select("select * from role where id in (select rid from user_role where uid=#{uid})")
	@Results({
		@Result(id = true, property = "id", column= "id"),
		@Result(property = "roleName", column="roleName"),
		@Result(property = "roleDesc", column="roleDesc"),
		@Result(property = "permissions", column = "id", javaType= List.class, many = @Many(select = "com.wzy.video.dao.PermissionDao.findPermissionByRoleId"))
	})
	public List<Role> findRoleByUserId(String uid);

	@Select("select * from role where id = #{rid}")
	public Role findRoleById(String rid);

	@Select("select * from role")
	public List<Role> findAll();

	@Insert("insert into role values(#{id},#{roleName},#{roleDesc})")
	public void save(Role role);

	@Select("select * from permission where id not in(select pid from role_permission where rid = #{RoleId})")
	public List<Permissions> findOtherPermissions(String RoleId);

	@Insert("insert into role_permission(rid,pid) values(#{roleId},#{permissionId})")
	public void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId);
	
}
