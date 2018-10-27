package com.lingnan.examsys.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lingnan.examsys.business.domain.ClassVO;
import com.lingnan.examsys.common.exception.DaoException;
import com.lingnan.examsys.common.util.DBUtils;

public class ClassDaoImpl implements ClassDao {
	//测试用指示常量：输出程序执行到的类名
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName()+":";
	//连接对象
	private Connection conn;
	
	public ClassDaoImpl(Connection conn) {
		this.conn = conn;
	}
	/**
	 * 班级搜索搜索框
	 * 模糊查询
	 */
	 public List<ClassVO> findClassByTeaIdAndCn(int user_id,String class_name){
		 ResultSet rs = null;
			PreparedStatement prep = null;
			List<ClassVO> list = new ArrayList<ClassVO>();
			try{
				//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
				prep = conn.prepareStatement("select * from class"
						+ "					where class_name like ? and class_id in"
						+ "					(select class_id from tea_class where user_id=?) ");
				//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
				prep.setString(1, '%'+class_name+'%');
				prep.setInt(2, user_id);
				rs = prep.executeQuery();
				while(rs.next()){
					ClassVO classshow = new ClassVO(); //创建一个新用户对象，赋值给用户对象变量
					//调用结果集对象的getxxx的方法，取出各个字段的值
					//再调用用户对象的setxxx方法，给属性赋值
					//最后新创建的对象中包含了查询结果中的所有字段的值
					classshow.setClass_id(rs.getInt("class_id"));
					classshow.setClass_name(rs.getString("class_name"));
					list.add(classshow); //将对象放入集合中
					
				}
				
			}catch(Exception e){
				System.out.println("模糊查询班级信息时候出错： "+e.getMessage());
			}finally{
				DBUtils.closeStatement(rs, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
			}
			return list;
	 }
	 /**
	  * 查找班级
	  */
	 public List<ClassVO> findClassID(String class_name) {
			List<ClassVO> list = new ArrayList<ClassVO>();
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = conn.prepareStatement("select * from class where class_name = ?");
				ps.setString(1, class_name);
				rs = ps.executeQuery();
				if(rs.next()){
					ClassVO classvo = new ClassVO();
					classvo.setClass_id(rs.getInt("class_id"));
					classvo.setClass_name(rs.getString("class_name"));
					list.add(classvo);
				}
			} catch(SQLException e){
				throw new DaoException("1.根据班级名称查找班级编号失败", e);
			}finally{
				DBUtils.closeStatement(rs, ps);
			}
			return list;
		}
}
