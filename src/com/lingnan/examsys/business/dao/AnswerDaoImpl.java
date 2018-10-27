package com.lingnan.examsys.business.dao;

import java.sql.Connection;

public class AnswerDaoImpl implements AnswerDao {
	//测试用指示常量：输出程序执行到的类名
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName()+":";
	//连接对象
	private Connection conn;

	public AnswerDaoImpl(Connection conn) {
		this.conn = conn;
	}
}
