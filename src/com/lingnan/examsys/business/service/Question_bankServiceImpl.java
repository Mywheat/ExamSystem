package com.lingnan.examsys.business.service;

import java.sql.Connection;
import java.util.Vector;

import com.lingnan.examsys.business.dao.Question_bankDao;
import com.lingnan.examsys.business.dao.RecordDao;
import com.lingnan.examsys.business.domain.Question_bankVO;
import com.lingnan.examsys.common.constant.EnumType;
import com.lingnan.examsys.common.dao.DaoFactory;
import com.lingnan.examsys.common.exception.DaoException;
import com.lingnan.examsys.common.exception.ServiceException;
import com.lingnan.examsys.common.util.DBUtils;

public class Question_bankServiceImpl implements Question_bankService{
	
//	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName()+":";
//	private static Question_bankServiceImpl question_bankService = new Question_bankServiceImpl();
//	public static Question_bankService getInstance() {
//		return question_bankService;
//	}
	

	//分页查看题库所有题目 2018/10/14 mai
	@Override
	public Vector<Question_bankVO> findAllQuestion_bank(int pageNum,int pageSize) {
		Vector<Question_bankVO> v = new Vector<Question_bankVO>();
		Connection conn = null; 
		try{
			conn = DBUtils.getConnection();
			Question_bankDao question_bankdao = (Question_bankDao)DaoFactory.getDao(conn, EnumType.QUESTION_BANK_DAO);
			v = question_bankdao.findAllQuestion_bank(pageNum, pageSize);
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("2.分页查看题库失败",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		return v;
	}

	//教师端添加试题 2018/10/24 mai
	@Override
	public boolean insertQuestion(Question_bankVO qbVO) {
		
		boolean flag = false;		
		Connection conn = null; 
		try{
			conn = DBUtils.getConnection();
			Question_bankDao question_bankdao = (Question_bankDao)DaoFactory.getDao(conn, EnumType.QUESTION_BANK_DAO);
			flag = question_bankdao.insertQuestion(qbVO);
			
		}catch(DaoException e){
			throw e;
		}catch(Exception e){
			throw new ServiceException("2.教师端添加试题失败",e);
		}finally{
			DBUtils.closeConnection(conn);
		}		
		return flag;
	}

}
