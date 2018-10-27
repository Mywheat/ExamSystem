package com.lingnan.examsys.business.domain;

import java.util.Date;

public class ExaminationVO {
	private int exam_id;
	private int user_id;
	private String exam_name;
	private Date exam_begin;
	private Date exam_end;
	public int getExam_id() {
		return exam_id;
	}
	public void setExam_id(int exam_id) {
		this.exam_id = exam_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getExam_name() {
		return exam_name;
	}
	public void setExam_name(String exam_name) {
		this.exam_name = exam_name;
	}
	public Date getExam_begin() {
		return exam_begin;
	}
	public void setExam_begin(Date exam_begin) {
		this.exam_begin = exam_begin;
	}
	public Date getExam_end() {
		return exam_end;
	}
	public void setExam_end(Date exam_end) {
		this.exam_end = exam_end;
	}
}
