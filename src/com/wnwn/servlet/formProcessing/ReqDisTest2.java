package com.wnwn.servlet.formProcessing;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReqDisTest2 extends HttpServlet{
	private static final long serialVersionUID = 7657535223704170311L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("t2 doget");
		double d = (double)req.getAttribute("test");
		/*ReqDisTest1的resp的响应类型也被传到ReqDisTest2，因此不会出现中文乱码*/
		resp.getWriter().write("servlet2测试:<br/>");
		resp.getWriter().write("req attr test:"+d+"<br/>");
	}
}
