package com.wnwn.servlet.servletLifeCycle;

import java.io.IOException;

//import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLife1 extends HttpServlet {
	private static final long serialVersionUID = 8881828471540050580L;

//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		print("init");
//		System.out.println("init-param:"+config.getInitParameter("test"));
//	}
	/*重写init方法时用不带参数的init()!*/
	@Override
	public void init() throws ServletException {
		print("init");
		String test = getInitParameter("test");
		System.out.println("InitParameter:"+test);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		print("service");
	}
	
	@Override
	public void destroy() {
		print("destroy");
	}
	
	void print(String content){
		System.out.println(getClass().getSimpleName()+" method name:"+content+" thread name:"+Thread.currentThread().getName());
	}
}
