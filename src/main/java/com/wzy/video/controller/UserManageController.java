package com.wzy.video.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.wzy.video.bean.UserData;
import com.wzy.video.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserManageController {

    @Autowired
    private UserService userService;

    @GetMapping("users")
    public ModelAndView findAll(@RequestParam(required = true,defaultValue = "1",value = "page")Integer page,
                          @RequestParam(required = true,defaultValue = "4",value = "size")Integer size){
        List<UserData> userData = userService.findAllUser(page,size);
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<>(userData);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("user-page-list");
        return mv;
    }
    //后台手动删除用户
    @DeleteMapping(value="/{id}")
    public String deleteById(@PathVariable String id){
        userService.deleteById(id);
        return id;
    }

    //后台手动添加用户
    @PostMapping
    public String save(UserData userData){
        /*String status = request.getParameter("status");*/
        /*userData.setStatus(1);*/
        userService.save(userData);
        return userData.toString();
    }

    //通过ID获得详情
    @GetMapping(value="/{id}")
    public String  findById(@PathVariable String id){
        UserData userDataInfo = userService.findById(id);
        return userDataInfo+"";
    }

    //通过ID修改表单数据
    @PutMapping(value="/{id}")
    public String updateById(@PathVariable String id){
        userService.updateById(id);
        return "ok";
    }
/*    @RequestMapping("findUserByIdAllRole")
    public ModelAndView findUserByIdAllRole(@RequestParam(value="id",required = true) String userid){
        ModelAndView mv = new ModelAndView();
        //1.根据Id查询用户
        UserData userDataInfo = userService.findById(userid);
        //2.根据用户id查询可以添加的角色
        List<Role> otherRoles = userService.findOtherRoles(userid);

        mv.addObject("user", userDataInfo);
        mv.addObject("roleList",otherRoles);
        mv.setViewName("addRoleToUser");
        return mv;
    }*/

/*    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam(name = "userId",required = true ) String userId,@RequestParam(name="ids",required = true)String[] roleIds){
        userService.addRoleToUser(userId,roleIds);
        return "redirect:userList";
    }*/

    @PostMapping("/login")
    public String doLogin(HttpServletResponse response,
                                @RequestParam("username") String username,
                                @RequestParam("password") String password) {
//        ModelAndView mv = new ModelAndView();
        //登录
        log.info("用户登录：username:{}, password:{}", username, password);
        //判断用户名是否存在
        UserData userData = userService.queryByNameAndPwd(username, password);
        if(null==userData){
//            mv.setViewName("failer");
            return "failer";
        }
        /*mv.setViewName("main");*/
        return "ok";
    }
}

