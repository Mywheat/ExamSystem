package com.lingnan.examsys.business.domain;

public class MissionVO {
	private int user_id;
	private int exam_id;
	private int finish_flag;
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
	public int getFinish_flag() {
		return finish_flag;
	}
	public void setFinish_flag(int finish_flag) {
		this.finish_flag = finish_flag;
	}
}
