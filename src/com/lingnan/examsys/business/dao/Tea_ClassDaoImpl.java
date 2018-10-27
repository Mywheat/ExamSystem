package com.lingnan.examsys.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lingnan.examsys.business.domain.ClassVO;
import com.lingnan.examsys.business.domain.RankingVO;
import com.lingnan.examsys.business.domain.Tea_ClassVO;
import com.lingnan.examsys.common.util.DBUtils;
/**
 * 
 * @author Administrator
 *
 */
public class Tea_ClassDaoImpl implements Tea_ClassDao {
	//测试用指示常量：输出程序执行到的类名
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName()+":";
	//连接对象
	private Connection conn;
	
	public Tea_ClassDaoImpl(Connection conn) {
		this.conn = conn;
	}
	/**
	 * 黄润志2018.08.11
	 * 查找排名
	 */
	public List<RankingVO> findStudentAnswerRank(int user_id){
		ResultSet rs = null;
		PreparedStatement prep = null;
		List<RankingVO> list = new ArrayList<RankingVO>();
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select r.user_id user_id,user_name,count(exam_id) count "
					+ "					from record r,user u"
					+ "					where r.user_id=u.user_id and "
					+ "					r.user_id in (select stu_class.user_id"
					+ "					from stu_class,tea_class"
					+ "					where tea_class.user_id=? and stu_class.class_id=tea_class.class_id) "
					+ "					group by r.user_id,user_name ");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			prep.setInt(1, user_id);
			rs = prep.executeQuery();
			int rank_id=1;
			while(rs.next()){
				RankingVO answer_rank = new RankingVO(); //创建一个新用户对象，赋值给用户对象变量
				//调用结果集对象的getxxx的方法，取出各个字段的值
				//再调用用户对象的setxxx方法，给属性赋值
				//最后新创建的对象中包含了查询结果中的所有字段的值
				answer_rank.setRank_id(rank_id);
				answer_rank.setUser_id(rs.getInt("user_id"));
				answer_rank.setUser_name(rs.getString("user_name"));
				answer_rank.setCount(rs.getInt("count"));
				list.add(answer_rank); //将对象放入集合中
				rank_id=rank_id+1;
			}
			
		}catch(Exception e){
			System.out.println("查询排名信息时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return list;
	}
	
	/**
	 * 2018.08.12
	 * 查找老师所教班级
	 */
	public List<ClassVO> findClassByTeaId(int user_id){
		ResultSet rs = null;
		PreparedStatement prep = null;
		List<ClassVO> list = new ArrayList<ClassVO>();
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select * from class,tea_class"
					+ "					where tea_class.user_id=? and class.class_id=tea_class.class_id ");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			prep.setInt(1, user_id);
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
			System.out.println("查询班级信息时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return list;
	}
	/**
	 * 查看该班级是否存在
	 */
	public boolean findClassByClassName(String class_name){
		ResultSet rs = null;
		PreparedStatement prep = null;
		boolean flag=false;
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select * from class where class_name=? ");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			prep.setString(1, class_name);
			rs = prep.executeQuery();
			if(rs.next()){
				flag=true;
			}
			
		}catch(Exception e){
			System.out.println("查询班级是否存在时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return flag;
	}
	/**
	 * 查看该老师未添加的班级
	 */
	 public List<ClassVO> findNotClassByTeaId(int user_id){
		 ResultSet rs = null;
			PreparedStatement prep = null;
			List<ClassVO> list = new ArrayList<ClassVO>();
			try{
				//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
				prep = conn.prepareStatement("select * from class where class_id not in(select class_id from tea_class where user_id=?) ");
				//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
				prep.setInt(1, user_id);
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
				System.out.println("查询该老师还未添加的班级的时候出错： "+e.getMessage());
			}finally{
				DBUtils.closeStatement(rs, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
			}
			return list;
	 }
	 /**
	  * 查找该老师是否已经添加过该班级
	  */
	 public boolean findClassByClassid(String class_name){
		 ResultSet rs = null;
			PreparedStatement prep = null;
			boolean flag=false;
			try{
				//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
				prep = conn.prepareStatement("select * from tea_class where class_id=(select class_id from class where class_name=?) ");
				//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
				prep.setString(1, class_name);;
				rs = prep.executeQuery();
				if(rs.next()){
					flag=true;
				}
				
			}catch(Exception e){
				System.out.println("查询该老师是否添加过该班级时候出错： "+e.getMessage());
			}finally{
				DBUtils.closeStatement(rs, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
			}
			return flag; 
	 }
	 /**
	  * 根据班级名查找班级id
	  */
	 public ClassVO findClassIdByClassname(String class_name){
		 ResultSet rs = null;
			PreparedStatement prep = null;
			ClassVO classshow = new ClassVO(); //创建一个新用户对象，赋值给用户对象变量
			try{
				//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
				prep = conn.prepareStatement("select * from class where class_name=? ");
				//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
				prep.setString(1, class_name);
				rs = prep.executeQuery();
				if(rs.next()){
					
					//调用结果集对象的getxxx的方法，取出各个字段的值
					//再调用用户对象的setxxx方法，给属性赋值
					//最后新创建的对象中包含了查询结果中的所有字段的值
					classshow.setClass_id(rs.getInt("class_id"));
					classshow.setClass_name(rs.getString("class_name"));					
				}
				
			}catch(Exception e){
				System.out.println("查询该老师还未添加的班级的时候出错： "+e.getMessage());
			}finally{
				DBUtils.closeStatement(rs, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
			}
			return classshow;
	 }
	 /**
	  * 添加到老师班级中
	  */
	 public  boolean insertClassByClassName(Tea_ClassVO tea_class){
		
			PreparedStatement prep = null;
			boolean flag=false;
			try{
				int Tuser_id=tea_class.getUser_id();
				int class_id=tea_class.getClass_id();
				//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
				prep = conn.prepareStatement("insert into tea_class values(?,?) ");
				//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
				prep.setInt(1, Tuser_id);
				prep.setInt(2, class_id);
				prep.executeUpdate();
				flag=true;
				
			}catch(Exception e){
				System.out.println("查询添加老师班级时候出错： "+e.getMessage());
			}finally{
				DBUtils.closeStatement(null,prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
			}
			return flag; 
	 }
	 /**
	  * 教师删除班级
	  */
	 public  boolean deleteTeaClass(ClassVO tea_class){
			PreparedStatement prep = null;
			boolean flag=false;
			try{
				
				String class_name=tea_class.getClass_name();
				//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
				prep = conn.prepareStatement("delete from tea_class where class_id=(select class_id from class where class_name=?) ");
				//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
				prep.setString(1, class_name);
				prep.executeUpdate();
				flag=true;
				
			}catch(Exception e){
				System.out.println("删除老师班级时候出错： "+e.getMessage());
			}finally{
				DBUtils.closeStatement(null,prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
			}
			return flag; 
	 }
	
	
	
}
