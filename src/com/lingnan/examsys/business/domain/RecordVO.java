package com.lingnan.examsys.business.domain;

import java.util.Date;

public class RecordVO {
	private int user_id;
	private int exam_id;
	private int ans_id;
	private int error_flag;
	private Date time;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getExam_id() {
		return exam_id;
	}
	public void setExam_id(int exam_id) {
		this.exam_id = exam_id;
	}
	public int getAns_id() {
		return ans_id;
	}
	public void setAns_id(int ans_id) {
		this.ans_id = ans_id;
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
