package com.lingnan.examsys.business.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginOutServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		    throws IOException, ServletException
		    {

			HttpSession s =req.getSession();
			s.invalidate();
			resp.sendRedirect(req.getContextPath()+"/index.jsp");		    
		    }
}
