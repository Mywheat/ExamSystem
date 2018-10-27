package com.lingnan.examsys.business.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.lingnan.examsys.business.dao.ClassDao;
import com.lingnan.examsys.business.domain.ClassVO;
import com.lingnan.examsys.common.constant.EnumType;
import com.lingnan.examsys.common.dao.DaoFactory;
import com.lingnan.examsys.common.exception.DaoException;
import com.lingnan.examsys.common.util.DBUtils;

public class ClassServiceImpl implements ClassService {

	// 测试用指示常量：输出程序执行到的类名
	private static final String Ca = Thread.currentThread().getStackTrace()[1]
			.getClassName() + ":";

	/**
	 * 用户Service类唯一实例(饿汉式)
	 */
	private static ClassService classservice = new ClassServiceImpl();

	/**
	 * 获取唯一的Service实例
	 * 
	 * @return Service实例
	 */
	public static ClassService getInstance() {
		return classservice;
	}

	@Override
	public List<ClassVO> findClassID(String class_name) {
		List<ClassVO> list = new ArrayList<ClassVO>();
		Connection conn = null; // 声明数据库连接对象，用于保存数据库连接对象
		try {
			conn = DBUtils.getConnection();
			ClassDao classdao = (ClassDao) DaoFactory.getDao(conn,
					EnumType.CLASS_DAO);
			list = classdao.findClassID(class_name);
		} catch (DaoException e) {
			throw e;
		} catch (Exception e) {
			throw new DaoException("2.根据班级名称查找班级编号失败", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return list;
	}

}
