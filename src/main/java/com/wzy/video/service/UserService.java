package com.wzy.video.service;

import com.wzy.video.bean.Role;
import com.wzy.video.bean.UserData;

import java.util.List;

public interface UserService {

    /*主页业务*/
    //查所有
    public List<UserData> findAllUser(Integer page,Integer size);
    //查一个
    public UserData findById(String id);
    //删一个
    public void deleteById(String id);
    //保存
    public UserData save(UserData userData);
    //修改
    public void updateById(String id);


    /*登录业务*/
    public UserData queryByNameAndPwd(String name,String pwd);

    //关联业务
    public List<Role> findOtherRoles(String userid);

    public void addRoleToUser(String userId, String[] roleIds);
}
