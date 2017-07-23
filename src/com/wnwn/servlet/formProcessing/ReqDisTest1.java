package com.wnwn.servlet.formProcessing;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReqDisTest1 extends HttpServlet{
	private static final long serialVersionUID = -2823887040500048137L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("t1 doget");
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().write("servlet1 doGet!<br/>");
		RequestDispatcher rd = req.getRequestDispatcher("dis2");
		req.setAttribute("test", Math.random());
		/*使用forward方法，第一个servlet响应不会发生，由servlet2响应客户*/
//		rd.forward(req, resp);
		/*使用include方法，获取包含在servlet2中的请求内容
		 * 使用servlet1响应客户
		 * 使请求看起来像一个servlet响应*/
		rd.include(req, resp);
		double d = (double)req.getAttribute("test");
		resp.getWriter().write("include servlet2 double value:"+d+"<br/>");
	}
}
