package com.wnwn.servlet.formProcessing;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*重定向方式使用另一个servlet响应用户请求*/
public class Redirect1 extends HttpServlet {
	private static final long serialVersionUID = -1903229518693812988L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*不会显示Redirect1中的响应*/
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().write("Redirect1 servelt!");
		/*重定向给Redirect2*/
		resp.sendRedirect("red2");
		System.out.println("Redirect1 servlet!");
	}
	
}
