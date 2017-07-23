package com.wnwn.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WebContextListener implements ServletContextListener {

	/*web应用启动时init；应用停止时destoryed*/
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("WebContextListener destroyed "+event.getServletContext());
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("WebContextListener initialized "+event.getServletContext());
	}

}
