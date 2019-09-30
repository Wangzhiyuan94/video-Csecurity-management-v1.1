package com.wzy.video.service;


import com.wzy.video.bean.SysLog;

import java.util.List;


public interface SysLogService {

	public void save(SysLog sysLog);
	
	public List<SysLog> findAll(Integer page, Integer size);
	
	public List<SysLog> main();
}
