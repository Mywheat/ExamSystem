package com.lingnan.examsys.business.controller;

import java.util.ArrayList;
import java.util.List;

import com.lingnan.examsys.business.domain.Stu_ClassVO;
import com.lingnan.examsys.business.service.Stu_ClassService;
import com.lingnan.examsys.business.service.Stu_ClassServiceImpl;

public class Stu_ClassController {

	// 测试用指示常量：输出程序执行到的类名
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName() + ":";
	// 获取用户Service实例,用以业务处理
	Stu_ClassService scs = Stu_ClassServiceImpl.getInstance();

	public List<Stu_ClassVO> findExam_Stu(int class_id) {
		List<Stu_ClassVO> list = new ArrayList<Stu_ClassVO>();
		try {
			list = scs.findExam_Stu(class_id);
		} catch (Exception e) {
			System.out.println("3.根据班级编号查找学生编号失败" + e.getMessage());
		}
		return list;
	}
}
