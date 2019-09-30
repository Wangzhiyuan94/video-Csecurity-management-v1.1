package com.wzy.video.controller;

import com.github.pagehelper.PageInfo;
import com.wzy.video.bean.SysLog;
import com.wzy.video.service.SysLogService;
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
@RequestMapping("/syslog")
public class syslogManageController {

	@Autowired
	private SysLogService sysLogService;

	
	
	@RequestMapping("/findAll")
	public ModelAndView findAll(@RequestParam(required = true,defaultValue = "1",value = "page")Integer page,
                                  @RequestParam(required = true,defaultValue = "10",value = "size")Integer size)
	{
		
    	ModelAndView mv = new ModelAndView();
    	List<SysLog> sysLogs = sysLogService.findAll(page, size);
    	//使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<>(sysLogs);
        
        
        mv.addObject("pageInfo", pageInfo);
    	mv.setViewName("syslog-page-list");
		return mv;
 
    }	
  
	@RequestMapping("/main")
	public ModelAndView findAll()
	{
		
    	ModelAndView mv = new ModelAndView();
    	List<SysLog> sysLogs = sysLogService.main();
    	//使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        
        
        mv.addObject("sysLogs", sysLogs);
    	mv.setViewName("main");
		return mv;
 
    }		
	
}
