package com.wnwn.filter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginTestFilterServlet extends HttpServlet {
	private static final long serialVersionUID = -7496960976560789666L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		String name = (String)session.getAttribute("user");
		String test = req.getParameter("test");
//		resp.setHeader("Content-Type", "text/html;charset=UTF-8");
		resp.getWriter().write(test+",欢迎"+name+"访问Filter Servlet！<br/><a href='../index.html'>返回首页</a>");
	}
}
