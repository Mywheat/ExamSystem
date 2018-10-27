package com.lingnan.examsys.business.service;

import java.sql.Connection;

import com.lingnan.examsys.business.dao.Que_ExamDao;
import com.lingnan.examsys.common.constant.EnumType;
import com.lingnan.examsys.common.dao.DaoFactory;
import com.lingnan.examsys.common.exception.DaoException;
import com.lingnan.examsys.common.util.DBUtils;

public class Que_ExamServiceImpl implements Que_ExamService {

	// 测试用指示常量：输出程序执行到的类名
	private static final String Ca = Thread.currentThread().getStackTrace()[1]
			.getClassName() + ":";

	/**
	 * 用户Service类唯一实例(饿汉式)
	 */
	private static Que_ExamService Que_ExamService = new Que_ExamServiceImpl();

	/**
	 * 获取唯一的Service实例
	 * 
	 * @return Service实例
	 */
	public static Que_ExamService getInstance() {
		return Que_ExamService;
	}

	@Override
	public boolean addQue_Exam(int num, int Exam_id, int Que_id) {
		boolean flag = false;
		Connection conn = null; // 声明数据库连接对象，用于保存数据库连接对象
		try {
			conn = DBUtils.getConnection();
			Que_ExamDao qe = (Que_ExamDao) DaoFactory.getDao(conn,
					EnumType.QUE_EXAM_DAO);
			flag = qe.addQue_Exam(num, Exam_id, Que_id);
		} catch (DaoException e) {
			throw e;
		} catch (Exception e) {
			throw new DaoException("2.试卷添加试题失败", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return flag;
	}

}
