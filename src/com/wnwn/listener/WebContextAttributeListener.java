package com.wnwn.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class WebContextAttributeListener implements ServletContextAttributeListener{

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("WebContextAttributeListener added "+event.getName()+" value "+event.getValue());
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("WebContextAttributeListener removed "+event.getName()+" value "+event.getValue());
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("WebContextAttributeListener replaced "+event.getName()+" value "+event.getValue());
	}

}
