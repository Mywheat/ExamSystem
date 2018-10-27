package com.lingnan.examsys.business.controller;

import com.lingnan.examsys.business.service.ExaminationService;
import com.lingnan.examsys.business.service.ExaminationServiceImpl;

public class ExaminationController {

	// 测试用指示常量：输出程序执行到的类名
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName() + ":";
	// 获取用户Service实例,用以业务处理
	ExaminationService examinationService = ExaminationServiceImpl.getInstance();
	
	public boolean insertExam(int user_id,String exam_name,java.util.Date exam_begin,java.util.Date exam_end) 
	{
		boolean flag = false;
		try {
			flag = examinationService.insertExam(user_id, exam_name, exam_begin, exam_end);
		} catch (Exception e) {
			System.out.println("3.教师完善试卷信息失败" + e.getMessage());
		}
		return flag;
	}
	
	public int findExam_id(int user_id, String exam_name){
		int exam_id = 0;
		try{
			exam_id = examinationService.findExam_id(user_id, exam_name);
		} catch (Exception e) {
			System.out.println("3.查找试卷号失败" + e.getMessage());
		}
		return exam_id;
	}
}
