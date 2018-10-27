package com.lingnan.examsys.business.controller;

import com.lingnan.examsys.business.service.UserService;
import com.lingnan.examsys.business.service.UserServiceImpl;

public class UseController {
	//测试用指示常量：输出程序执行到的类名
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName()+":";
	//获取用户Service实例,用以业务处理
	UserService userMgrService = UserServiceImpl.getInstance();
}
