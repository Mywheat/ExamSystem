package com.lingnan.examsys.business.servlet;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.lingnan.examsys.business.controller.Que_ExamController;

public class Que_ExamServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	public Que_ExamServlet(){
		super();
	}
	
	@Override
	protected void doGet(javax.servlet.http.HttpServletRequest req,javax.servlet.http.HttpServletResponse resp)
			throws javax.servlet.ServletException, java.io.IOException {
		doPost(req,resp);
	}
	
	@Override
	protected void doPost(javax.servlet.http.HttpServletRequest req,javax.servlet.http.HttpServletResponse resp)
			throws javax.servlet.ServletException, java.io.IOException {
		resp.setContentType("text/html"); 
        boolean flag = false;
        Que_ExamController qe = new Que_ExamController();
        HttpSession session = req.getSession();
        int num = (Integer)session.getAttribute("num");
        int exam_id = (Integer)session.getAttribute("exam_id");
        String[] que_id = req.getParameterValues("que_id");
        String exam_name = (String)session.getAttribute("exam_name");
        int user_id = (Integer)session.getAttribute("user_id");
        int i = 0;
        for(String a : que_id){
			String[] b = a.split(",");
			for(String c : b)
			    i=i+1;
		}
                    
        if(i == num){
        	for(String a : que_id){
    			String[] b = a.split(",");
    			for(String c : b)
    			flag = qe.addQue_Exam(num, exam_id, Integer.parseInt(c));
    		}       		
        }if(i > num){
        	System.out.println("添加的试题超过上限，请重新添加试题");
        }if(i < num){
        	System.out.println("你所添加的试题不够，请继续添加试题");
        }	
		System.out.println("servlet测试:"+num+" "+exam_id+" "+ flag);
		
        session.setAttribute("exam_name", exam_name);
        session.setAttribute("user_id", user_id);
//        resp.sendRedirect("AllResource.jsp");
        resp.sendRedirect("AllResource.jsp");
        
		
//		session.setAttribute("exam_id", exam_id);
//		System.out.println("sdjfhcdkjvcnjkdvn"+exam_id);
//		resp.sendRedirect("Mission.jsp");
		
        Gson gson=new Gson(); //Gson 是google解析Json的一个开源框架
		Map<String, Object> content = new HashMap<String, Object>();
        content.put("flag", flag);   
        
	};
}
