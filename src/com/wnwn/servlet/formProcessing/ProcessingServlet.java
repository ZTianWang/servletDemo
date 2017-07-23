package com.wnwn.servlet.formProcessing;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessingServlet extends HttpServlet {
	private static final long serialVersionUID = -4793329526658659448L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		/*doget方法解决中文乱码：当get请求编码格式为“ISO8859-1”时，对其转换编码需使用字符串的转换，不可使用设置字符编码的方式*/
//		name = new String(name.getBytes("ISO8859-1"),"UTF-8");
		String age = req.getParameter("age");
		System.out.println(name+" "+age);
		/*为输出流添加头部，设置MIME类型为html，编码为UTF-8，否则出现中文乱码*/
		resp.setHeader("Content-Type", "text/html;charset=UTF-8");
		resp.getWriter().write("name:"+name+";age:"+age);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*dopost方法解决中文乱码：转换编码即可使用字符串的转换，也可使用设置字符编码的方式，常使用设置字符编码的方式*/
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
//		name = new String(name.getBytes("ISO8859-1"),"UTF-8");
		String age = req.getParameter("age");
		System.out.println(name+" "+age);
		resp.setHeader("Content-Type", "text/html;charset=UTF-8");
		resp.getWriter().write("name:"+name+";age:"+age);
	}
	
}
