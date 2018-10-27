package com.lingnan.examsys.business.test;


import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.lingnan.examsys.business.dao.ExaminationDao;
import com.lingnan.examsys.business.dao.ExaminationDaoImpl;
import com.lingnan.examsys.common.util.DBUtils;

public class ExaminationDaoImplTest {

	
	public void testInsertExam() {
		Connection conn = DBUtils.getConnection();
		ExaminationDao ed = new ExaminationDaoImpl(conn);
		try {
			//date数据类型转换
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date exam_begin = sdf.parse("2017-08-08");
			Date exam_end = sdf.parse("2017-10-01");
			boolean flag = ed.insertExam(101,"烹饪2017-2018期末考试", exam_begin, exam_end);
			System.out.println("测试1:"+flag);
		} catch (ParseException e) {
			e.printStackTrace();
		}		
	}

	
	public void testFindExam_id() {
		Connection conn = DBUtils.getConnection();
		ExaminationDao ed = new ExaminationDaoImpl(conn);
		int flag = ed.findExam_id(101, "烹饪2017-2018期末考试");
		System.out.println("测试2:"+flag);
	}

}
