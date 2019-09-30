package com.wzy.video.controller;

import com.github.pagehelper.PageInfo;
import com.wzy.video.bean.Permissions;
import com.wzy.video.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/*
 *客户管理
 *
 */

@Controller
@RequestMapping("/permission")
public class permissionManageController {

	@Autowired
	private PermissionService permissionService;

	
	
	@RequestMapping("/findAll")
	public ModelAndView findAll(@RequestParam(required = true,defaultValue = "1",value = "page")Integer page,
                                  @RequestParam(required = true,defaultValue = "4",value = "size")Integer size)
	{
		
    	ModelAndView mv = new ModelAndView();
    	List<Permissions> permissions = permissionService.findAll(page, size);
    	//使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<>(permissions);
        
        
        mv.addObject("pageInfo", pageInfo);
    	mv.setViewName("permission-page-list");
		return mv;
 
    }	
  

	
	//后台手动添加角色
	@RequestMapping(value="/save")
	public String save(Permissions permission){

		System.out.println(permission);
		permissionService.save(permission);
		return "redirect:/permission/findAll";
	}
	
/*	//通过ID获得详情
	@RequestMapping(value="findById")
	public ModelAndView findById(String id){
		System.out.println(id);
		ModelAndView mv = new ModelAndView();
		User userInfo = userService.findById(id);
		mv.addObject("user",userInfo);
		mv.setViewName("user-show");
		return mv;
	}*/	
	
}
