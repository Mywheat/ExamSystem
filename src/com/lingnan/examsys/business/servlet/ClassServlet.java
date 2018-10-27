package com.lingnan.examsys.business.servlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.lingnan.examsys.business.controller.ClassController;
import com.lingnan.examsys.business.domain.ClassVO;

public class ClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ClassServlet() {
		super();
	}

	@Override
	protected void doGet(javax.servlet.http.HttpServletRequest req,javax.servlet.http.HttpServletResponse resp)
			throws javax.servlet.ServletException, java.io.IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(javax.servlet.http.HttpServletRequest req,javax.servlet.http.HttpServletResponse resp)
			throws javax.servlet.ServletException, java.io.IOException {
		resp.setContentType("text/html");
		int i = 0;
		int j = 0;
		int count = 0;		
//		HttpSession session = req.getSession();	
		String[] class_name = req.getParameterValues("class_name");
		ClassController cc = new ClassController();
		for (String a : class_name) {
			String[] b = a.split(",");
			for (String c : b) {
				count = count + 1;  //一共有多少个班级
			}
		}
		
		int[] classid = new int[count];

		for (String a : class_name) {
			String[] b = a.split(",");
			for (String c : b) {
				List<ClassVO> list = new ArrayList<ClassVO>();
				list = cc.findClassID(c);				
				for (ClassVO classvo : list) {
					int class_id = classvo.getClass_id();
//					System.out.println("aaaaaaaaa"+class_id);
//					System.out.println(i+" "+j);
					if(i==j){
						classid[i] = class_id;
//					    System.out.println("bbbbbbbbbbbb"+classid[j]);	
					}
					i++;
					j++;
				}
			}
			
		}		
		
		req.setAttribute("count", count);
		req.setAttribute("class_idList", classid);
		req.getRequestDispatcher("findExam_Stu.jsp").forward(req, resp);
//		session.setAttribute("count", count);
//		session.setAttribute("class_idList", classid);
//		System.out.println("ooo"+classid[0]+" "+classid[1]+" "+classid[2]);
//		resp.sendRedirect("findExam_Stu.jsp");
		
//		session.setAttribute("class_id"+i, classvo.getClass_id());  //加一个标识序号i,防止前面的被后面的覆盖,相当于class_id0,class_id1,class_id2这种				
//		System.out.println("测试servlet:" + classvo.getClass_id()+ " " + classvo.getClass_name());

	};
}
