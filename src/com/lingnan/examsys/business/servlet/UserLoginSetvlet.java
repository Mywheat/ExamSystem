package com.lingnan.examsys.business.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.lingnan.examsys.business.domain.TestVO;
import com.lingnan.examsys.business.domain.UserVO;
import com.lingnan.examsys.business.service.UserService;
import com.lingnan.examsys.business.service.UserServiceImpl;


public class UserLoginSetvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserLoginSetvlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
	        PrintWriter out = resp.getWriter();
	        String user_id=req.getParameter("user_id");
	        String password=req.getParameter("password");
	 
	        System.out.println("UserName:"+user_id+";"+"PassWord:"+password);
	        UserVO user=new UserVO();
	        user.setUser_id(Integer.parseInt(user_id));
	        user.setUser_pwd(password);;
			HttpSession se = req.getSession();
			// 调用Service方法
			UserService UserService = new UserServiceImpl();
			List<UserVO> UserList = UserService.findUserByIdAndPassword(user);
			se.setAttribute("UserList",UserList);
			resp.sendRedirect(req.getContextPath()+"/teachers/manage_students.jsp");
			System.out.println("UserName2:"+user_id+";"+"PassWord2:"+password);
			
//			resp.setContentType("/teacher/manage_students.jsp");
	}

}