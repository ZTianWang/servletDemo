package com.wnwn.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class RequestAttributeListener implements ServletRequestAttributeListener {

	@Override
	public void attributeAdded(ServletRequestAttributeEvent event) {
		System.out.println("RequestAttributeListener added "+event.getName()+" value "+event.getValue());
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent event) {
		System.out.println("RequestAttributeListener removed "+event.getName()+" value "+event.getValue());

	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent event) {
		System.out.println("RequestAttributeListener replaced "+event.getName()+" value "+event.getValue());

	}

}
