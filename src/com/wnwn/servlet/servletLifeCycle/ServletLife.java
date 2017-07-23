package com.wnwn.servlet.servletLifeCycle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLife extends HttpServlet {
	
	private static final long serialVersionUID = 8881828471540050580L;
	
	@Override
	public void init() throws ServletException {
		print("init");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		print("service");
		System.out.println(getServletContext().hashCode());
	}
	
	@Override
	public void destroy() {
		print("destroy");
	}
	
	void print(String content){
		System.out.println(getClass().getSimpleName()+" method name:"+content+" thread name:"+Thread.currentThread().getName());
	}
	
}
