package com.lingnan.examsys.business.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.lingnan.examsys.business.dao.Stu_ClassDao;
import com.lingnan.examsys.business.dao.Stu_ClassDaoImpl;
import com.lingnan.examsys.business.domain.Stu_ClassVO;
import com.lingnan.examsys.common.util.DBUtils;

public class Stu_ClassDaoImplTest {
	public void testFindExam_Stu() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Connection conn = DBUtils.getConnection();
		Stu_ClassDao scd = new Stu_ClassDaoImpl(conn);
		List<Stu_ClassVO> list = new ArrayList<Stu_ClassVO> ();
		for(int i=0;i<3;i++){
			System.out.println("请输入班级id号");		
			try {
				String class_id1;
				class_id1 = br.readLine();
				int class_id = Integer.parseInt(class_id1);
				list = scd.findExam_Stu(class_id);
				for(Stu_ClassVO sc : list){
					System.out.println(sc.getClass_id()+" "+sc.getUser_id());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
