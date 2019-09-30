package com.wzy.video.bean;

//import com.mysql.jdbc.Clob;

import java.util.List;

public class QueryVo {

	
	//评论详细ID
	private Integer id;
	//视频信息
	private Video video;
	//评论总数++select count(*)
	private Integer cmmt_count;
	//每个用户评论内容
//	private Clob cmmt_content;
	//评论作者
	private List<UserData> cmmt_uid;
	

	
}
