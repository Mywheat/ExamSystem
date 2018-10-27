package com.lingnan.examsys.business.domain;

public class Question_bankVO {
	private int que_id;
	private int user_id;
	private int que_charpter;
	private String que_type;
	private String que_content;
	private String que_options;
	private String que_answer;
	private String que_url;
	public int getQue_id() {
		return que_id;
	}
	public void setQue_id(int que_id) {
		this.que_id = que_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getQue_charpter() {
		return que_charpter;
	}
	public void setQue_charpter(int que_charpter) {
		this.que_charpter = que_charpter;
	}
	public String getQue_type() {
		return que_type;
	}
	public void setQue_type(String que_type) {
		this.que_type = que_type;
	}
	public String getQue_content() {
		return que_content;
	}
	public void setQue_content(String que_content) {
		this.que_content = que_content;
	}
	public String getQue_url() {
		return que_url;
	}
	public void setQue_url(String que_url) {
		this.que_url = que_url;
	}
	public String getQue_options() {
		return que_options;
	}
	public void setQue_options(String que_options) {
		this.que_options = que_options;
	}
	public String getQue_answer() {
		return que_answer;
	}
	public void setQue_answer(String que_answer) {
		this.que_answer = que_answer;
	}
}
