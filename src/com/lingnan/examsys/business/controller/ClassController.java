package com.lingnan.examsys.business.controller;

import java.util.ArrayList;
import java.util.List;

import com.lingnan.examsys.business.domain.ClassVO;
import com.lingnan.examsys.business.service.ClassService;
import com.lingnan.examsys.business.service.ClassServiceImpl;

public class ClassController {

	// 测试用指示常量：输出程序执行到的类名
	private static final String Ca = Thread.currentThread().getStackTrace()[1]
			.getClassName() + ":";
	// 获取用户Service实例,用以业务处理
	ClassService cs = ClassServiceImpl.getInstance();

	public List<ClassVO> findClassID(String class_name) {
		List<ClassVO> list = new ArrayList<ClassVO>();
		try {
			list = cs.findClassID(class_name);
		} catch (Exception e) {
			System.out.println("3.根据班级名称查找班级编号失败" + e.getMessage());
		}
		return list;
	}

}
