package com.lingnan.examsys.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lingnan.examsys.business.domain.ExaminationVO;
import com.lingnan.examsys.business.domain.StuFinishStatusVO;
import com.lingnan.examsys.common.exception.DaoException;
import com.lingnan.examsys.common.util.DBUtils;

public class ExaminationDaoImpl implements ExaminationDao {
	//测试用指示常量：输出程序执行到的类名
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName()+":";
	//连接对象
	private Connection conn;
	
	public ExaminationDaoImpl(Connection conn) {
		this.conn = conn;
	}
	/**
	 * 统计完成人数
	 */
	public int findFinishSt(int exam_id){
		ResultSet rs = null;
		PreparedStatement prep = null;
		int num=0;
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select count(user_id) count from mission  where exam_id=? and finish_flag='完成'");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			prep.setInt(1, exam_id);

			rs = prep.executeQuery();
			while(rs.next()){	
				num= rs.getInt("count");
			}
			
		}catch(Exception e){
			System.out.println("查找试卷时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return num;
	}
	/**
	 * 查找试卷
	 */
	public List<ExaminationVO> findExamByUid(int user_id,String class_name){
		ResultSet rs = null;
		PreparedStatement prep = null;
		List<ExaminationVO> list = new ArrayList<ExaminationVO>();
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select examination.*,b.a a from examination,(select exam_id,count(m.user_id) a "
					+ "from mission m,stu_class st,class c where m.user_id=st.user_id and st.class_id=c.class_id "
					+ "and c.class_name=? group by exam_id) b where  user_id=? and b.exam_id=examination.exam_id "
					+ " ");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量
			prep.setString(1, class_name);
			prep.setInt(2, user_id);

			rs = prep.executeQuery();
			while(rs.next()){
				ExaminationVO ExaminationShow = new ExaminationVO(); //创建一个新用户对象，赋值给用户对象变量
				//调用结果集对象的getxxx的方法，取出各个字段的值
				//再调用用户对象的setxxx方法，给属性赋值
				//最后新创建的对象中包含了查询结果中的所有字段的值
				 int exam_id=rs.getInt("exam_id");
				ExaminationShow.setExam_id(exam_id);
				int numb = findFinishSt(exam_id);
				ExaminationShow.setUser_id(numb);
				ExaminationShow.setExam_name(rs.getString("exam_name"));
				ExaminationShow.setExam_begin(rs.getDate("exam_begin"));
				ExaminationShow.setExam_end(rs.getDate("exam_end"));
				list.add(ExaminationShow); //将对象放入集合中
				
			}
			
		}catch(Exception e){
			System.out.println("查找试卷时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return list;
	}
	/**
	 * 查找学生完成情况
	 */
	public List<StuFinishStatusVO> findStuStatus(int exam_id){
		ResultSet rs = null;
		PreparedStatement prep = null;
		List<StuFinishStatusVO> list = new ArrayList<StuFinishStatusVO>();
		try{
			//调用连接对象的prepareStatement方法，得到预编对象，赋值给预编译对象变量
			prep = conn.prepareStatement("select user_name,m.user_id,finish_flag "
					+ "from user,(select user_id,finish_flag from mission where exam_id=?) m "
					+ "where m.user_id=user.user_id");
			//调用连接对象的executeQuery方法，执行查询结果，赋值给结果集译对象变量

			prep.setInt(1, exam_id);

			rs = prep.executeQuery();
			while(rs.next()){
				StuFinishStatusVO ExaminationShow = new StuFinishStatusVO(); //创建一个新用户对象，赋值给用户对象变量
				//调用结果集对象的getxxx的方法，取出各个字段的值
				//再调用用户对象的setxxx方法，给属性赋值
				//最后新创建的对象中包含了查询结果中的所有字段的值
				ExaminationShow.setUser_id(rs.getInt("user_id"));
				ExaminationShow.setUser_name(rs.getString("user_name"));
				
				ExaminationShow.setStatus(rs.getString("finish_flag"));
				list.add(ExaminationShow); //将对象放入集合中
				
			}
			
		}catch(Exception e){
			System.out.println("查找学生完成情况时候出错： "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, prep); //调用数据库工具类的closeStatement的方法，关闭结果集合声明对象
		}
		return list;
	}
	public boolean insertExam(int user_id,String exam_name, java.util.Date exam_begin, java.util.Date exam_end) {
		boolean flag = false;
		PreparedStatement ps = null;
		try {
			ps = conn
					.prepareStatement("insert into examination(user_id,exam_name,exam_begin,exam_end) values (?,?,?,?)");
			ps.setInt(1, user_id);
			ps.setString(2, exam_name);		
			ps.setDate(3, new java.sql.Date(exam_begin.getTime()));
			ps.setDate(4, new java.sql.Date(exam_end.getTime()));
			int i = ps.executeUpdate();
			if (i > 0) {
				flag = true;
				System.out.println("第一步：教师添加试卷信息完善成功");
			} else {
				flag = false;
				System.out.println("教师添加试卷第一步失败");
			}
		} catch (SQLException e) {
			throw new DaoException("1.教师完善试卷信息失败", e);
		} finally {
			DBUtils.closeStatement(null, ps);
		}
		return flag;
	}

	@Override
	public int findExam_id(int user_id, String exam_name) {
		int exam_id = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn
					.prepareStatement("select * from examination where user_id = ? and exam_name = ?");
			ps.setInt(1, user_id);
			ps.setString(2, exam_name);
			rs = ps.executeQuery();
			if (rs.next()) {
				exam_id = rs.getInt("exam_id");
			}
		} catch (SQLException e) {
			throw new DaoException("1.查找试卷号失败", e);
		}
		return exam_id;
	}
}
