package com.wnwn.servlet.sessionTracking;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveCookieServlet extends HttpServlet{
	private static final long serialVersionUID = -2712219860524077929L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie c1 = new Cookie("test1", "t1 value");
		resp.addCookie(c1);
		/*setMaxAge方法定义生命周期，为-1时关闭浏览器删除，为0时立即删除*/
		c1.setMaxAge(0);
		resp.addCookie(c1);
		resp.sendRedirect("index.html");
	}

}
