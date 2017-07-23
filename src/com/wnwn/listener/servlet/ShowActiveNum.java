package com.wnwn.listener.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

public class ShowActiveNum extends HttpServlet{
	private static final long serialVersionUID = 5324047938088548442L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*先建立一个session*/
		req.getSession();
		ServletContext context = getServletContext();
		Integer num = (Integer) context.getAttribute("total");
		resp.setContentType("text/html;charset=UTF-8");
		if (num != null) {
			resp.getWriter().write("当前浏览网页人数："+num);
		}
		resp.getWriter().write("<p><a href='total'>刷新</a></p>");
		resp.getWriter().write("<p><a href='../index.html'>返回首页</a></p>");
	}
}
