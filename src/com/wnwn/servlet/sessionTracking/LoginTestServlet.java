package com.wnwn.servlet.sessionTracking;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginTestServlet extends HttpServlet {
	private static final long serialVersionUID = -7496960976560789666L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		/*对没有登录的用户的处理*/
		if (session == null || session.getAttribute("user") == null) {
			resp.sendRedirect("../pages/login.html");
		}else {
			resp.setHeader("Content-Type", "text/html;charset=UTF-8");
			resp.getWriter().write("欢迎"+session.getAttribute("user")+"访问LTServlet！<br/><a href='../index.html'>返回首页</a>");
		}
	}
}
