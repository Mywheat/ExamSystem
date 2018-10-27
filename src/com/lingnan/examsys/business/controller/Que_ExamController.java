package com.lingnan.examsys.business.controller;

import com.lingnan.examsys.business.service.Que_ExamService;
import com.lingnan.examsys.business.service.Que_ExamServiceImpl;

public class Que_ExamController {

	// 测试用指示常量：输出程序执行到的类名
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName() + ":";
	// 获取用户Service实例,用以业务处理
	Que_ExamService qe = Que_ExamServiceImpl.getInstance();

	public boolean addQue_Exam(int num,int Exam_id,int Que_id) {
		boolean flag = false;
		try {
			flag = qe.addQue_Exam(num, Exam_id, Que_id);			
		} catch (Exception e) {
			System.out.println("3.试卷添加试题失败" + e.getMessage());
		}
		return flag;
	}
}
