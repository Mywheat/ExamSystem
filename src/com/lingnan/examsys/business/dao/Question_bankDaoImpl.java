package com.lingnan.examsys.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.lingnan.examsys.business.domain.Question_bankVO;
import com.lingnan.examsys.common.exception.DaoException;
import com.lingnan.examsys.common.util.DBUtils;

public class Question_bankDaoImpl implements  Question_bankDao {
	//测试用指示常量：输出程序执行到的类名
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName()+":";
	//连接对象
	private Connection conn;
	
	public Question_bankDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	public boolean checkQuestion(int num){
		boolean flag = false;
		return flag;
	}
  
	//分页查看题库所有题目 2018/10/14 mai
	@Override
	public Vector<Question_bankVO> findAllQuestion_bank(int pageNum,int pageSize) {
		ResultSet rs = null;
		ResultSet rs1 = null;
		PreparedStatement ps = null;		
		PreparedStatement ps1 = null;
		Vector<Question_bankVO> v = new Vector<Question_bankVO>();
		try {
			/*firstIndex:起始索引
			 * pageSize:每页显示的数量
			 * orderColumn:排序的字段名
			 * sql:可以是简单的单表查询语句，也可以是复杂的多表联合查询语句
			 * rownum:行号
			 */
			int count = -1; //初始化数据库中数据的数量
			ps = conn.prepareStatement("select count(*) as count from question_bank");
			rs = ps.executeQuery();
			if(rs.next()){
				count = rs.getInt("count"); //计算出数据的总数量
			}
//			System.out.println("count:"+count);
			int a = count % pageSize;  //看是否有余数，有的话加一页
			int allPageNum = -1;  //allPageNum指的是一共分了多少页，PageNum指的是当前页数
			if(a==0){
				allPageNum = count/pageSize;
			}else{
				allPageNum = (count/pageSize)+1;
			}
			if(pageNum>allPageNum){
				System.out.println("没有该页数，请重新输入1~"+allPageNum+"之间的页数");
			}
//			System.out.println("PageNum:"+pageNum+" "+"pageSize:"+pageSize);
			ps1 = conn.prepareStatement(" select * from question_bank limit ?,?");  //limit 0, 10 表示从第0条开始，一共找10条
			ps1.setInt(1, (pageNum-1)*pageSize);
			ps1.setInt(2, pageSize);			
			rs1 = ps1.executeQuery();		
			while (rs1.next()) {
				Question_bankVO que_bankVO = new Question_bankVO();
				que_bankVO.setQue_charpter(rs1.getInt("que_chapter"));  //章节
				que_bankVO.setQue_type(rs1.getString("que_type"));  //单选或者多选
				que_bankVO.setQue_content(rs1.getString("que_content"));  //试题内容
				que_bankVO.setQue_options(rs1.getString("que_options"));  //试题选项内容
				que_bankVO.setQue_answer(rs1.getString("que_answer"));  //试题答案
				v.add(que_bankVO);
			}
//			System.out.println("count:"+count+" "+"allPageNum:"+allPageNum);
		} catch (SQLException e) {
			// 将异常封装成自定义异常
			throw new DaoException("分页查询试题失败", e);
		} finally {
			// 调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, ps);
			DBUtils.closeStatement(rs1, ps1);
		}
		return v;
	}
   
	//教师端添加试题 2018/10/24 mai
	@Override
	public boolean insertQuestion(Question_bankVO qbVO) {
		PreparedStatement ps = null;
		boolean flag = false;
		try {
			System.out.println("1.qbVO:"+qbVO.getQue_answer());
			ps = conn.prepareStatement("insert into question_bank(user_id,Que_chapter,Que_type,Que_content,"
					+ "Que_options,Que_answer) values(?,?,?,?,?,?)");
			ps.setInt(1, qbVO.getUser_id());
			ps.setInt(2, qbVO.getQue_charpter());
			ps.setString(3, qbVO.getQue_type());
			ps.setString(4, qbVO.getQue_content());
			ps.setString(5, qbVO.getQue_options());
			ps.setString(6, qbVO.getQue_answer());
			ps.executeUpdate();
			flag = true;
			System.out.println("1.flag:"+flag);
		} catch (SQLException e) {
			throw new DaoException("教师添加试题失败", e);
		} finally {
			DBUtils.closeStatement(null, ps);
		}
		return flag;
	}
}
