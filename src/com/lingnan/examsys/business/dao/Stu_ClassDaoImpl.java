package com.lingnan.examsys.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lingnan.examsys.business.domain.RankingVO;
import com.lingnan.examsys.business.domain.Stu_ClassVO;
import com.lingnan.examsys.common.exception.DaoException;
import com.lingnan.examsys.common.util.DBUtils;

public class Stu_ClassDaoImpl implements Stu_ClassDao {
	//测试用指示常量：输出程序执行到的类名
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName()+":";
	//连接对象
	private Connection conn;
	
	public Stu_ClassDaoImpl(Connection conn) {
		this.conn = conn;
	}
	public int findSTNumberByCn(String class_name){
		ResultSet rs = null;
		PreparedStatement prep = null;
		int number=0;
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select count(user_id) count from stu_class "
					+ "						where class_id=(select class_id from class where class_name=?)");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			prep.setString(1, class_name);
			rs = prep.executeQuery();
			if(rs.next()){
				
				//调用结果集对象的getxxx的方法，取出各个字段的值
				//再调用用户对象的setxxx方法，给属性赋值
				//最后新创建的对象中包含了查询结果中的所有字段的值
				number=rs.getInt("count");
			}
			
		}catch(Exception e){
			System.out.println("统计班级人数信息时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return number;
	}
	
	
	public List<Stu_ClassVO> findExam_Stu(int class_id) {
		List<Stu_ClassVO> list = new ArrayList<Stu_ClassVO>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from stu_class where class_id = ? ");
			ps.setInt(1, class_id);
			rs = ps.executeQuery();
			while(rs.next()){
				Stu_ClassVO sc = new Stu_ClassVO();
				sc.setClass_id(rs.getInt("class_id"));
				sc.setUser_id(rs.getInt("user_id"));
				list.add(sc);
			}
		} catch (SQLException e) {
			throw new DaoException("1.根据班级编号查找学生编号失败", e);
		}finally{
			DBUtils.closeStatement(rs, ps);
		}
		return list;
	}
}
