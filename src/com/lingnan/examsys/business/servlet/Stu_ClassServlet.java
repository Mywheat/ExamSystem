package com.lingnan.examsys.business.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import com.lingnan.examsys.business.controller.Stu_ClassController;
import com.lingnan.examsys.business.domain.Stu_ClassVO;

public class Stu_ClassServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public Stu_ClassServlet() {
		super();
	}

	protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) 
			throws javax.servlet.ServletException ,java.io.IOException {
		doPost(req,resp);
	};
	
	protected void doPost(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) 
			throws javax.servlet.ServletException ,java.io.IOException {
		resp.setContentType("text/html");
		int num = 0;  //一共要添加num个学生完成这张试卷
		HttpSession session = req.getSession();
		int[] stu_id = new int[500];
		Stu_ClassController scc = new Stu_ClassController();
		List<Stu_ClassVO> list = new ArrayList<Stu_ClassVO>();
		int count = (Integer)session.getAttribute("count");
		int[] class_id = new int[count];
		class_id = (int[])session.getAttribute("class_id");
		for(int i=0;i<count;i++){
			list = scc.findExam_Stu(class_id[i]);
//			System.out.println("测试1servlet:"+class_id[i]);
			for(Stu_ClassVO sc : list){
				if(sc.getClass_id()!=0){
					stu_id[num] = sc.getUser_id();
					num = num + 1;
				}			
			}
		}
		
		System.out.println(stu_id[0]+" "+stu_id[1]);
//		System.out.println("测试num:"+" "+num);
		req.setAttribute("num", num);
		req.setAttribute("stu_idList", stu_id);
		req.getRequestDispatcher("Mission.jsp").forward(req, resp);
	};
	
	
	
}
