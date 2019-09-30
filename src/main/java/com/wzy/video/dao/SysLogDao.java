package com.wzy.video.dao;

import com.wzy.video.bean.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysLogDao {

	
	
	
	@Insert("insert into syslog(id,visitTime,username,ip,url,executionTime,method) values(#{id},#{visitTime},#{username},INET_ATON(#{ip}),#{url},#{executionTime},#{method})")
	public void save(SysLog sysLog);

	@Select("select id,visitTime,username,url,executionTime,method,INET_NTOA(ip) as ip from syslog order by visitTime desc")
	public List<SysLog> findAll();
		
	
}
