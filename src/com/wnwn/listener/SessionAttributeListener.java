package com.wnwn.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SessionAttributeListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("SessionAttributeListener added name:"+event.getName()+" value:"+event.getValue());

	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("SessionAttributeListener removed name:"+event.getName()+" value:"+event.getValue());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("SessionAttributeListener replaced name:"+event.getName()+" value:"+event.getValue());
	}

}
