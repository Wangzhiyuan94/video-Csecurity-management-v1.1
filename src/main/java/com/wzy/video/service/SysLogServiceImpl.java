package com.wzy.video.service;

import com.github.pagehelper.PageHelper;
import com.wzy.video.bean.SysLog;
import com.wzy.video.dao.SysLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class SysLogServiceImpl implements SysLogService{

	private static  final String LOGS_CACHE_NAME = "logs";

	@Autowired
	private SysLogDao sysLogDao;
	
	@Override
	public void save(SysLog sysLog) {
		sysLogDao.save(sysLog);
		
	}

	@Override
	public List<SysLog> findAll(Integer page, Integer size) {
		PageHelper.startPage(page,size);
		return sysLogDao.findAll();
	}

	@Override
	/*@Cacheable(value = LOGS_CACHE_NAME,key = "'log7'")*/
	public List<SysLog> main() {
		return sysLogDao.findAll();
	}

}
