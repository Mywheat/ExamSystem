package com.lingnan.examsys.business.controller;

import com.lingnan.examsys.business.service.MissionService;
import com.lingnan.examsys.business.service.MissionServiceImpl;

public class MissionController {

	// 测试用指示常量：输出程序执行到的类名
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName() + ":";
	// 获取用户Service实例,用以业务处理
	MissionService missionService = MissionServiceImpl.getInstance();
	public boolean insertMission(int exam_id, int user_id){
		boolean flag = false;
		try {
			flag = missionService.insertMission(exam_id, user_id);
		} catch (Exception e) {
			System.out.println("3.添加试卷任务表失败" + e.getMessage());
		}
		return flag;
	}
}
