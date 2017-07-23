package com.wnwn.servlet.sessionTracking;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveCookieServlet extends HttpServlet {

	private static final long serialVersionUID = 2999474766640847345L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie c1 = new Cookie("test1", "t1 value");
		resp.addCookie(c1);
		Cookie c2 = new Cookie("test2", "t2 value");
		/*设置访问路径为当前应用程序根路径，当前应用下所有路径均可访问，不安全*/
		c2.setPath("/");
		resp.addCookie(c2);
		Cookie c3 = new Cookie("test3", "t3 value");
		/*设置访问路径为/temp*/
		c3.setPath("/temp/");
		resp.addCookie(c3);
		resp.sendRedirect("index.html");
	}
}
