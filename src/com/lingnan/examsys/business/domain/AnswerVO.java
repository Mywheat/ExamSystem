package com.lingnan.examsys.business.domain;

import java.util.Date;

public class AnswerVO {
	private int user_id;
	private int exam_id;
	private int ans_id;
	private Date ans_begin;
	private Date ans_end;
	private int error_sum;
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
	public Date getAns_begin() {
		return ans_begin;
	}
	public void setAns_begin(Date ans_begin) {
		this.ans_begin = ans_begin;
	}
	public Date getAns_end() {
		return ans_end;
	}
	public void setAns_end(Date ans_end) {
		this.ans_end = ans_end;
	}
	public int getError_sum() {
		return error_sum;
	}
	public void setError_sum(int error_sum) {
		this.error_sum = error_sum;
	}
}
