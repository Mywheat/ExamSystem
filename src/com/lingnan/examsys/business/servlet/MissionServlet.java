package com.lingnan.examsys.business.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import com.lingnan.examsys.business.controller.MissionController;

public class MissionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public MissionServlet() {
		super();
	}
	@Override
	protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) 
			throws javax.servlet.ServletException ,java.io.IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) 
			throws javax.servlet.ServletException ,java.io.IOException {
		HttpSession session = req.getSession();
		int num = 0;
		num = (Integer)session.getAttribute("num");
		int[] stu_id = new int[num];
		stu_id = (int[])session.getAttribute("stu_id");
		int exam_id = (Integer)session.getAttribute("exam_id");
		
		for(int i=0;i<num;i++){
			int user_id = stu_id[i];
			MissionController mc = new MissionController();
			mc.insertMission(exam_id, user_id);
		}
		
	}
}
