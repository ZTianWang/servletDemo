package com.wnwn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*doFilter方法会被多线程调用，init方法和destory方法只会被调用一次*/
public class FilterLifeCycle implements Filter {

	@Override
	public void init(FilterConfig config) throws ServletException {
		print("filter init");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
//		print("filter doFilter");
		chain.doFilter(req, resp);
		print("filter chain doFilter");
	}

	@Override
	public void destroy() {
		print("filter destory");
	}
	
	void print(String info){
		System.out.println(info+" thread name:"+Thread.currentThread().getName());
	}

}
