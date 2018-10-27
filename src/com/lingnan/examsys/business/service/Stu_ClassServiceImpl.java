package com.lingnan.examsys.business.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lingnan.examsys.business.dao.Stu_ClassDao;
import com.lingnan.examsys.business.domain.Stu_ClassVO;
import com.lingnan.examsys.common.constant.EnumType;
import com.lingnan.examsys.common.dao.DaoFactory;
import com.lingnan.examsys.common.exception.DaoException;
import com.lingnan.examsys.common.util.DBUtils;

public class Stu_ClassServiceImpl implements Stu_ClassService {
	// 测试用指示常量：输出程序执行到的类名
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName() + ":";

	/**
	 * 用户Service类唯一实例(饿汉式)
	 */
	private static Stu_ClassService stu_ClassService = new Stu_ClassServiceImpl();

	/**
	 * 获取唯一的Service实例
	 * 
	 * @return Service实例
	 */
	public static Stu_ClassService getInstance() {
		return stu_ClassService;
	}

	@Override
	public List<Stu_ClassVO> findExam_Stu(int class_id) {
		List<Stu_ClassVO> list = new ArrayList<Stu_ClassVO>();
		Connection conn = null;
		try{
			conn = DBUtils.getConnection();
			Stu_ClassDao scd = (Stu_ClassDao) DaoFactory.getDao(conn, EnumType.STU_CLASS_DAO);
			list = scd.findExam_Stu(class_id);
		} catch (DaoException e) {
			throw e;
		} catch (Exception e) {
			throw new DaoException("2.根据班级编号查找学生编号失败", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return list;
	}

}
