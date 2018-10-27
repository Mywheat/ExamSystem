package com.lingnan.examsys.business.service;

import java.sql.Connection;
import java.util.List;

import com.lingnan.examsys.business.dao.UserDao;
import com.lingnan.examsys.business.domain.ClassVO;
import com.lingnan.examsys.business.domain.Tea_ClassVO;
import com.lingnan.examsys.business.domain.UserVO;
import com.lingnan.examsys.common.constant.EnumType;
import com.lingnan.examsys.common.dao.DaoFactory;
import com.lingnan.examsys.common.exception.DaoException;
import com.lingnan.examsys.common.exception.ServiceException;
import com.lingnan.examsys.common.util.DBUtils;

public class UserServiceImpl implements UserService {
	//测试用指示常量：输出程序执行到的类名
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName()+":";
	
	/**
	 * 用户Service类唯一实例(饿汉式)
	 */
	private static UserServiceImpl userService = new UserServiceImpl();
	
	/**
	 * 获取唯一的Service实例
	 * @return Service实例
	 */
	public static UserService getInstance() {
		return userService;
	}
	/**
	 * 黄润志2018.08.10
	 * 根据账号和密码查找用户
	 */
	public List<UserVO> findUserByIdAndPassword(UserVO user){
		Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
		List<UserVO> list = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//调用dao工厂类的getDao方法，去得指定类型dao接口的实现类，并赋值给dao接口变量
			UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn,EnumType.USER_DAO);			
			//调用dao中的findUserByName方法，进行登录操作，结果赋值给登录结果变量
			list = userMgrDao.findUserByIdAndPassword(user);
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("1Service:查找动态信息错误：",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		//返回用户登录结果
		return list;
	}
	

}
