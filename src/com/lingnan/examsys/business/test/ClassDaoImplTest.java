package com.lingnan.examsys.business.test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;



import com.lingnan.examsys.business.dao.ClassDao;
import com.lingnan.examsys.business.dao.ClassDaoImpl;
import com.lingnan.examsys.business.domain.ClassVO;
import com.lingnan.examsys.common.util.DBUtils;

public class ClassDaoImplTest {

	
	public void testFindClassID() {
		Connection conn = DBUtils.getConnection();
		ClassDao classdao = new ClassDaoImpl(conn);
		List<ClassVO> list = new ArrayList<ClassVO>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("请输入所要选择的班级数");
		int num;
		try {
			num = Integer.parseInt(br.readLine());
			for(int i=0;i<num;i++){
				System.out.print("请输入班级名称");
				String class_name;
				class_name = br.readLine();
				list = classdao.findClassID(class_name);
				for(ClassVO classvo : list){
					System.out.println(classvo.getClass_id()+" "+classvo.getClass_name());
				}
			}
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
	}

}
