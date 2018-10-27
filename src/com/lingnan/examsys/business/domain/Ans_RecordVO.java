package com.lingnan.examsys.business.domain;

import java.util.Date;

public class Ans_RecordVO {
	private int user_id;
	private String user_name;
	private String que_content;
	private int error_flag;
	private Date time;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getQue_content() {
		return que_content;
	}
	public void setQue_content(String que_content) {
		this.que_content = que_content;
	}
	public int getError_flag() {
		return error_flag;
	}
	public void setError_flag(int error_flag) {
		this.error_flag = error_flag;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
}
