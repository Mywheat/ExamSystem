package com.lingnan.examsys.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.lingnan.examsys.common.exception.DaoException;
import com.lingnan.examsys.common.util.DBUtils;

public class Que_ExamDaoImpl implements Que_ExamDao {
	//测试用指示常量：输出程序执行到的类名
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName()+":";
	//连接对象
	private Connection conn;
	
	public Que_ExamDaoImpl(Connection conn) {
		this.conn = conn;
	}
	public boolean addQue_Exam(int num,int Exam_id,int Que_id){
		PreparedStatement ps = null;
		boolean flag = false;
		try{
		String sql = "insert into Que_Exam(Exam_id,Que_id) values(?,?)";
		ps = (PreparedStatement) conn.prepareStatement(sql);
		{			
//			Random random = new Random();		
			ps.setInt(1, Exam_id);
			ps.setInt(2, Que_id);
			ps.addBatch();
		}	
		ps.executeBatch();;
		flag = true;
		}catch(SQLException e){
			throw new DaoException("1.试卷添加试题失败", e);
		}finally{
			DBUtils.closeStatement(null, ps);
		}
		return flag;
		}
}
