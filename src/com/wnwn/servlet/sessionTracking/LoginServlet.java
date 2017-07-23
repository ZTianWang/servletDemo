package com.wnwn.servlet.sessionTracking;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = -8650007598533720689L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		if ("admin".equals(name) && "12345".equals(password)) {
			HttpSession session = req.getSession();
			session.setAttribute("user", name);
			resp.setHeader("Content-Type", "text/html;charset=UTF-8");
			/*若Cookie功能被禁用，则使用encodeURL方法返回带jsessionid的url
			 *encodeURL方法在禁用Cookie时被浏览器自动调用，开启时不调用 
			 *在HTML中通过js得到jsessionid*/
			resp.getWriter().write("欢迎"+name+"访问！<br/><a href='"+resp.encodeURL("index.html")+"'>返回主页</a>");
		}else {
			resp.sendRedirect("pages/login.html");
		}
	}
}
