package com.lingnan.examsys.business.domain;

import java.util.Date;

public class UserVO {
	private int user_id;
	private String user_pwd;
	private String user_name;
	private int supervalue;
	private int blocked_flag;
	private Date blocked_time;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getSupervalue() {
		return supervalue;
	}
	public void setSupervalue(int supervalue) {
		this.supervalue = supervalue;
	}
	public int getBlocked_flag() {
		return blocked_flag;
	}
	public void setBlocked_flag(int blocked_flag) {
		this.blocked_flag = blocked_flag;
	}
	public Date getBlocked_time() {
		return blocked_time;
	}
	public void setBlocked_time(Date blocked_time) {
		this.blocked_time = blocked_time;
	}
}
