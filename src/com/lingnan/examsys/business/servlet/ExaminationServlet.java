package com.lingnan.examsys.business.servlet;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.lingnan.examsys.business.controller.ExaminationController;
import com.lingnan.examsys.business.domain.TestVO;
import com.lingnan.examsys.business.domain.UserVO;


public class ExaminationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ExaminationServlet(){
		super();
	}

	protected void doGet(javax.servlet.http.HttpServletRequest req,javax.servlet.http.HttpServletResponse resp)
		throws javax.servlet.ServletException, java.io.IOException {
		doPost(req,resp);
	};

	protected void doPost(javax.servlet.http.HttpServletRequest req,javax.servlet.http.HttpServletResponse resp)
		throws javax.servlet.ServletException, java.io.IOException {
		resp.setContentType("text/html"); 
        PrintWriter out = resp.getWriter();  //向前台的JSP页面输出结果
        HttpSession session = req.getSession();
        int user_id = (Integer) session.getAttribute("user_id");
        int num = Integer.parseInt(req.getParameter("num"));
        String exam_name = req.getParameter("exam_name");
        System.out.println("bbbbbbbbbbb");
        System.out.println("aaaaaaaaaaa"+num);
        Date exam_begin = null;
        Date exam_end = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			exam_begin = sdf.parse(req.getParameter("exam_begin"));
			exam_end = sdf.parse(req.getParameter("exam_end"));
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("字符串转换成日期失败");
		}
		ExaminationController ec = new ExaminationController();		
		boolean flag = ec.insertExam(user_id, exam_name, exam_begin, exam_end);
		System.out.println("1.servlet测试:"+flag);
		
		int exam_id = ec.findExam_id(user_id, exam_name);
		System.out.println("2.servlet测试:"+exam_id);
		
		Gson gson=new Gson(); //Gson 是google解析Json的一个开源框架
		Map<String, Object> content = new HashMap<String, Object>();
        content.put("flag", flag);
        content.put("exam_id", exam_id);
        String tojson = gson.toJson(content);
        System.out.println("测试Gson:"+tojson);        
//      System.out.println("测试Gson:"+gson.toJson(content));
        out.write(tojson);	
        
        session.setAttribute("num", num);
        session.setAttribute("user_id", user_id);
        session.setAttribute("exam_id", exam_id);
        session.setAttribute("exam_name", exam_name);
		resp.sendRedirect("que_exam.jsp");
	};

}
