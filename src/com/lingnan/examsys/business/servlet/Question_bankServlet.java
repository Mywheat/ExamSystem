package com.lingnan.examsys.business.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lingnan.examsys.business.controller.Question_bankController;
import com.lingnan.examsys.business.domain.Question_bankVO;
import com.lingnan.examsys.business.service.Question_bankService;
import com.lingnan.examsys.business.service.Question_bankServiceImpl;

public class Question_bankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Question_bankServlet(){
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Question_bankVO qbVO = new Question_bankVO();
		int user_id = Integer.parseInt(req.getParameter("user_id"));
	    int Que_chapter = Integer.parseInt(req.getParameter("Que_chapter"));
	    String Que_type = new String(req.getParameter("Que_type").getBytes("ISO-8859-1"),"utf-8");
	    String Que_content = new String(req.getParameter("Que_content").getBytes("ISO-8859-1"),"utf-8");
	    String Que_options = new String(req.getParameter("Que_options").getBytes("ISO-8859-1"),"utf-8");
	    String Que_answer = new String(req.getParameter("Que_answer").getBytes("ISO-8859-1"),"utf-8");
//	    System.out.println(user_id+" "+Que_answer);
	    qbVO.setUser_id(user_id);
		qbVO.setQue_charpter(Que_chapter);
		qbVO.setQue_type(Que_type);
		qbVO.setQue_content(Que_content);
		qbVO.setQue_options(Que_options);
		qbVO.setQue_answer(Que_answer);
//		System.out.println(qbVO.getQue_id()+" "+qbVO.getQue_charpter()+" "+qbVO.getQue_type());
//		System.out.println(qbVO.getQue_content()+" "+qbVO.getQue_options()+" "+qbVO.getQue_answer());
		Question_bankService question_bankService = new Question_bankServiceImpl();			
		boolean flag = question_bankService.insertQuestion(qbVO);
		System.out.println("2.flag:"+flag);
	    resp.sendRedirect(req.getContextPath()+"/teachers/Question_bankTest.jsp");
	}
}
