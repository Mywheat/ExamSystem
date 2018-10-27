package com.lingnan.examsys.business.test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import com.lingnan.examsys.business.dao.Que_ExamDao;
import com.lingnan.examsys.business.dao.Que_ExamDaoImpl;
import com.lingnan.examsys.business.domain.Que_ExamVO;
import com.lingnan.examsys.common.util.DBUtils;

public class Que_ExamDaoImplTest {

	
	public void testAddQue() {
		Connection conn = DBUtils.getConnection();
		Que_ExamDao qe = new Que_ExamDaoImpl(conn);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));	
		int num = 0;
		int exam_id = 0;
		int que_id = 0;
		boolean flag = false;
		try {
			System.out.println("请输入题目数量");
			num = Integer.parseInt(br.readLine());
			for (int i = 0; i < num; i++) {
				System.out.println("请输入exam_id");
				exam_id = Integer.parseInt(br1.readLine());
				System.out.println("请输入que_id");
				que_id = Integer.parseInt(br2.readLine());
				flag = qe.addQue_Exam(2,exam_id,que_id);
			}			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("批量添加信息的行数是:" + num + " "+flag);
	}

}
