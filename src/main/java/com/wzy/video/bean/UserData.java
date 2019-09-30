package com.wzy.video.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserData {

	private String id;
	private String name;
	private String password;
	//性别
	private Integer user_sex;
	//邮箱
	private String user_email;
	//生日
	private Date user_birthday;
	//手机号
	private String user_tel;
	//用户状态
	private String statusStr;
	//用户状态
	private int status;
	//用户角色
	private List<Role> roles;
	//用户权限
	private List<Permissions> permissions;
		

	public String getStatusStr() {
		//0未开启1开启
		if(status==0){
			statusStr="未开启";
		}else if(status==1){
			statusStr="开启";
		}
		return statusStr;
	}




	

}
