package com.lingnan.examsys.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lingnan.examsys.business.domain.UserVO;
import com.lingnan.examsys.common.util.DBUtils;


public class UserDaoImpl implements UserDao {
	//测试用指示常量：输出程序执行到的类名
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName()+":";
	//连接对象
	private Connection conn;

	public UserDaoImpl(Connection conn) {
		this.conn=conn;
	}
	/**
	 * 黄润志2018.08.10
	 * 根据账号和密码查找用户
	 */
	public List<UserVO> findUserByIdAndPassword(UserVO user){
		ResultSet rs = null;
		PreparedStatement prep = null;
		List<UserVO> list = new ArrayList<UserVO>();
		try{
			int userId = user.getUser_id();
			String userPassword = user.getUser_pwd();
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select * from user where user_id=? and user_pwd=?");
			//给？赋值
			prep.setInt(1,userId);
			prep.setString(2, userPassword);
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			rs = prep.executeQuery();
			while(rs.next()){
				UserVO user1 = new UserVO(); //创建一个新用户对象，赋值给用户对象变量
				//调用结果集对象的getxxx的方法，取出各个字段的值
				//再调用用户对象的setxxx方法，给属性赋值
				//最后新创建的对象中包含了查询结果中的所有字段的值
				user1.setUser_id(rs.getInt("user_id"));
				user1.setUser_pwd(rs.getString("user_pwd"));
				user1.setUser_name(rs.getString("user_name"));
				user1.setSupervalue(rs.getInt("supervalue"));
				user1.setBlocked_flag(rs.getInt("blocked_flag"));;
				user1.setBlocked_time(rs.getDate("blocked_time"));
				list.add(user1); //将对象放入集合中
			}
			
		}catch(Exception e){
			System.out.println("查询user信息时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep);; //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return list;
	}
}
