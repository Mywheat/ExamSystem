package com.lingnan.examsys.common.dao;

import java.sql.Connection;

import com.lingnan.examsys.business.dao.AnswerDao;
import com.lingnan.examsys.business.dao.AnswerDaoImpl;
import com.lingnan.examsys.business.dao.ClassDao;
import com.lingnan.examsys.business.dao.ClassDaoImpl;
import com.lingnan.examsys.business.dao.ExaminationDao;
import com.lingnan.examsys.business.dao.ExaminationDaoImpl;
import com.lingnan.examsys.business.dao.MissionDao;
import com.lingnan.examsys.business.dao.MissionDaoImpl;
import com.lingnan.examsys.business.dao.Que_ExamDao;
import com.lingnan.examsys.business.dao.Que_ExamDaoImpl;
import com.lingnan.examsys.business.dao.Question_bankDao;
import com.lingnan.examsys.business.dao.Question_bankDaoImpl;
import com.lingnan.examsys.business.dao.RecordDao;
import com.lingnan.examsys.business.dao.RecordDaoImpl;
import com.lingnan.examsys.business.dao.Stu_ClassDao;
import com.lingnan.examsys.business.dao.Stu_ClassDaoImpl;
import com.lingnan.examsys.business.dao.Tea_ClassDao;
import com.lingnan.examsys.business.dao.Tea_ClassDaoImpl;
import com.lingnan.examsys.business.dao.UserDao;
import com.lingnan.examsys.business.dao.UserDaoImpl;
import com.lingnan.examsys.common.exception.ServiceException;

/**
 * Dao工厂类(工厂方法模式)
 * @author Heyouth
 *
 */
public class DaoFactory {
	//测试用指示常量：输出程序执行到的类名
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName()+":";
	
	/**
	 * 获取Dao方法:根据type类型返回指定的Dao实例
	 * @param conn 连接对象
	 * @param type 请求Dao的类型
	 * @return Dao实例
	 */
	public static BaseDao getDao(Connection conn,String type) {
		//判断dao请求类型
		if("user".equals(type)) {
			UserDao dao = new UserDaoImpl(conn);
			return dao;
		}
		else if("answer".equals(type)) {
			AnswerDao dao = new AnswerDaoImpl(conn);
			return dao;
		}
		else if("class".equals(type)) {
			ClassDao dao = new ClassDaoImpl(conn);
			return dao;
		}
		else if("examination".equals(type)) {
			ExaminationDao dao = new ExaminationDaoImpl(conn);
			return dao;
		}
		else if("mission".equals(type)) {
			MissionDao dao = new MissionDaoImpl(conn);
			return dao;
		}
		else if("que_exam".equals(type)) {
			Que_ExamDao dao = new Que_ExamDaoImpl(conn);
			return dao;
		}
//		else if("que_exam".equals(type)) {
//			Que_ExamDao dao = new Que_ExamDaoImpl(conn);
//			return dao;
//		}
		else if("question_bank".equals(type)) {
			Question_bankDao dao = new Question_bankDaoImpl(conn);
			return dao;
		}
		else if("record".equals(type)) {
			RecordDao dao = new RecordDaoImpl(conn);
			return dao;
		}
		else if("stu_class".equals(type)) {
			Stu_ClassDao dao = new Stu_ClassDaoImpl(conn);
			return dao;
		}
		else if("tea_class".equals(type)) {
			Tea_ClassDao dao = new Tea_ClassDaoImpl(conn);
			return dao;
		}
		else {
			throw new ServiceException(Ca+"找不到对应的工厂方法类!");
		}
	}
}
