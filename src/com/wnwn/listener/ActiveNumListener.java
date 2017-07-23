package com.wnwn.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ActiveNumListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		ServletContext context = session.getServletContext();
		Integer num = (Integer) context.getAttribute("total");
		if (num == null) {
			context.setAttribute("total", 1);
		}else {
			context.setAttribute("total", num+1);
		}
		System.out.println("total "+context.getAttribute("total"));
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		ServletContext context = session.getServletContext();
		Integer num = (Integer) context.getAttribute("total");
		context.setAttribute("total", num-1);
	}

}
