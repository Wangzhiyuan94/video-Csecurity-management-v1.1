package com.wzy.video.dao;

import com.wzy.video.bean.Role;
import com.wzy.video.bean.UserData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
/*主页业务*/
/*登录业务*/
/*关联业务*/
@Mapper
public interface UserDao {

    /*主页业务*/
    @Select("select id,name,password,status,user_email,user_tel,user_birthday from user")
    public List<UserData> findAllUser();

    @Select("select id from user where id = #{id}")
    public UserData SelectOne(String id);

    @Delete("delete from user where id = #{id}")
    public void deleteById(String id);

    @Insert(" insert into user\n" +
            "\t\t(id,name,password,status,user_email,user_tel,user_birthday)values\n" +
            "\t\t(#{id},#{name},#{password},#{status},#{user_email},#{user_tel},#{user_birthday})")
    void save(UserData userData);

    void update(String id);

    /*登录业务*/
    @Select("select * from user\n" +
            "\t\twhere\n" +
            "\t\tname = #{name} and password = #{pwd}\t")
    public UserData queryByNameAndPwd(@Param("name")String name, @Param("pwd")String pwd);

    /*关联业务*/
    @Select("select * from role where id not in(select rid from user_role where uid = #{userId})")
    public List<Role> findOtherRoles(String userId);


    @Insert("insert into user_role(uid,rid) values(#{userId},#{roleId})")
    public void addRoleToUser(@Param("userId")String userId,@Param("roleId")String roleId);


    @Select("select * from user where name = #{username}")
    @Results({
            @Result(id = true, property = "id", column= "id"),
            @Result(property = "name", column="name"),
            @Result(property = "password", column="password"),
            @Result(property = "status", column="status"),
            @Result(property = "user_sex", column="user_sex"),
            @Result(property = "user_email", column="user_email"),
            @Result(property = "user_tel", column="user_tel"),
            @Result(property = "user_birthday", column="user_birthday"),
            @Result(property = "roles",column = "id",javaType = List.class,many = @Many(select = "com.wzy.video.dao.RoleDao.findRoleByUserId"))
    })
    public UserData findByUsername(String username);


}
