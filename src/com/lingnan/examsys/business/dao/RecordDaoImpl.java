package com.lingnan.examsys.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lingnan.examsys.business.domain.Ans_RecordVO;
import com.lingnan.examsys.business.domain.RankingVO;
import com.lingnan.examsys.common.util.DBUtils;

public class RecordDaoImpl implements RecordDao {
	//测试用指示常量：输出程序执行到的类名
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName()+":";
	//连接对象
	private Connection conn;
	
	public RecordDaoImpl(Connection conn) {
		this.conn = conn;
	}
	public List<Ans_RecordVO> findStudentAnswerRecord(RankingVO user){
		ResultSet rs = null;
		PreparedStatement prep = null;
		List<Ans_RecordVO> list = new ArrayList<Ans_RecordVO>();
		int user_id=user.getUser_id();
		String user_name=user.getUser_name();
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select r.user_id user_id,user_name,que_content,r.error_flag error_flag,r.time time"
					+ "					from record r,user u,question_bank qb"
					+ "					where r.user_id=u.user_id and r.que_id=qb.que_id"
					+ "					and r.user_id=? and user_name=?");
			//给问号赋值
			prep.setInt(1, user_id);
			prep.setString(2, user_name);
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			rs = prep.executeQuery();
			while(rs.next()){
				Ans_RecordVO ans_Record = new Ans_RecordVO(); //创建一个新用户对象，赋值给用户对象变量
				//调用结果集对象的getxxx的方法，取出各个字段的值
				//再调用用户对象的setxxx方法，给属性赋值
				//最后新创建的对象中包含了查询结果中的所有字段的值
				ans_Record.setUser_id(user_id);
				ans_Record.setUser_name(user_name);
				ans_Record.setQue_content(rs.getString("que_content"));
				ans_Record.setError_flag(rs.getInt("error_flag"));
				ans_Record.setTime(rs.getDate("time"));
				list.add(ans_Record); //将对象放入集合中
			}
			
		}catch(Exception e){
			System.out.println("查询排名信息时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep);; //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return list;
	}
}
