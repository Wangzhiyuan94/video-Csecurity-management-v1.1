package com.wzy.video.service;

import com.github.pagehelper.PageHelper;
import com.wzy.video.bean.Role;
import com.wzy.video.bean.UserData;
import com.wzy.video.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private static  final String USERS_CACHE_NAME = "users";

    @Autowired
    private UserDao userdao;

    /*主页业务*/
    @Override
    @Cacheable(value = USERS_CACHE_NAME,key = "#page+'-'+#size")
    public List<UserData> findAllUser(Integer page,Integer size) {
        PageHelper.startPage(page,size);
        return userdao.findAllUser();
    }

    @Override
/*    @Cacheable(value = USERS_CACHE_NAME,key = "'users_id'+#id",unless="#result == null")*/
    public UserData findById(String id) {
        return userdao.SelectOne(id);
    }

    @Override
    public void deleteById(String id) {
         userdao.deleteById(id);
    }

    @Override
    @CacheEvict(value = USERS_CACHE_NAME,allEntries = true,beforeInvocation = true)
    public UserData save(UserData userData) {
        userData.setId(UUID.randomUUID().toString());
        /*userData.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));*/
        userdao.save(userData);
        return userData;
    }

    @Override
    public void updateById(String id) {
        userdao.update(id);
    }

    /*登录业务*/
    @Override
    public UserData queryByNameAndPwd(String name, String pwd) {
        return userdao.queryByNameAndPwd(name, pwd);
    }

    /*关联业务*/
    @Override
    public List<Role> findOtherRoles(String userid) {
        return null;
    }

    @Override
    public void addRoleToUser(String userId, String[] roleIds) {

    }
}
