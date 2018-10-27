package com.lingnan.examsys.business.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lingnan.examsys.business.dao.Question_bankDao;
import com.lingnan.examsys.business.dao.Question_bankDaoImpl;
import com.lingnan.examsys.business.domain.Question_bankVO;
import com.lingnan.examsys.common.util.DBUtils;

public class Question_bankDaoImplTest {

	@Test
	public void testFindAllQuestion_bank() {
		Connection conn = DBUtils.getConnection();
		Question_bankDao que_bankDAO = new Question_bankDaoImpl(conn);
		List<Question_bankVO> list = new ArrayList<Question_bankVO>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int pageNum,pageSize;
		System.out.print("请输入页码数:");
		try {
			pageNum = Integer.parseInt(br.readLine());
			System.out.print("请输入每页的数据容纳量:");
			pageSize = Integer.parseInt(br.readLine());
			list = que_bankDAO.findAllQuestion_bank(pageNum,pageSize);
//			System.out.println("list.size:"+list.size());  //输出list列表的对象量
			for(Question_bankVO que_bankVO: list){
				System.out.println(que_bankVO.getQue_charpter()+" "+que_bankVO.getQue_type()
						+" "+que_bankVO.getQue_content()+" "+que_bankVO.getQue_options()+" "
						+que_bankVO.getQue_answer());
			}
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Test
	public void testInsertQuestion() {
		Connection conn = DBUtils.getConnection();
		Question_bankDao que_bankDAO = new Question_bankDaoImpl(conn);
		Question_bankVO qbVO = new Question_bankVO(); 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int user_id,Que_chapter;
		String Que_type,Que_content,Que_options,Que_answer;
		System.out.print("请输入教师编号:");
		try {
			user_id = Integer.parseInt(br.readLine());
			System.out.print("请输入试题单元号:");
			Que_chapter = Integer.parseInt(br.readLine());
			System.out.print("请输入试题类型（单选/多选）:");
			Que_type = br.readLine();
			System.out.print("请输入试题内容:");
			Que_content = br.readLine();
			System.out.print("请输入试题选项内容:");
			Que_options = br.readLine();
			System.out.print("请输入试题答案:");
			Que_answer = br.readLine();
			qbVO.setUser_id(user_id);
			qbVO.setQue_charpter(Que_chapter);
			qbVO.setQue_type(Que_type);
			qbVO.setQue_content(Que_content);
			qbVO.setQue_options(Que_options);
			qbVO.setQue_answer(Que_answer);	
			boolean flag = que_bankDAO.insertQuestion(qbVO);
			System.out.println(flag);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
