package com.lingnan.examsys.business.service;

import java.sql.Connection;
import java.util.Date;

import com.lingnan.examsys.business.dao.ExaminationDao;
import com.lingnan.examsys.common.constant.EnumType;
import com.lingnan.examsys.common.dao.DaoFactory;
import com.lingnan.examsys.common.exception.DaoException;
import com.lingnan.examsys.common.exception.ServiceException;
import com.lingnan.examsys.common.util.DBUtils;

public class ExaminationServiceImpl implements ExaminationService{

    //测试用指示常量：输出程序执行到的类名
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName()+":";
	
	/**
	 * 用户Service类唯一实例(饿汉式)
	 */
	private static ExaminationService examinationService = new ExaminationServiceImpl();
	
	/**
	 * 获取唯一的Service实例
	 * @return Service实例
	 */
	public static ExaminationService getInstance() {
		return examinationService;
	}
		
	@Override
	public boolean insertExam(int user_id, String exam_name, Date exam_begin,
			Date exam_end) {
		boolean flag = false;		
		Connection conn = null; //声明数据库连接对象，用于保存数据库连接对象
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//通过dao工厂类的getDao方法，取得指定类型的dao接口的实现类，并赋值给dao接口变量
			ExaminationDao examinationdao = (ExaminationDao)DaoFactory.getDao(conn, EnumType.EXAMUNATION_DAO);
			//调用dao的login方法，进行登录操作，然后赋值给登录结果变量
			flag = examinationdao.insertExam(user_id, exam_name, exam_begin, exam_end);
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("2.教师完善试卷信息失败",e);
		}finally{
			DBUtils.closeConnection(conn);
		}		
		return flag;
	}
	

	@Override
	public int findExam_id(int user_id, String exam_name) {
		int exam_id = 0;
		Connection conn = null;
		try{
			conn = DBUtils.getConnection();
			ExaminationDao examinationdao = (ExaminationDao)DaoFactory.getDao(conn, EnumType.EXAMUNATION_DAO);
			exam_id = examinationdao.findExam_id(user_id, exam_name);
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("2.查找试卷号失败",e);
		}finally{
			DBUtils.closeConnection(conn);
		}	
		return exam_id;
	}

}
