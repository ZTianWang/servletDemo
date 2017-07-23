package com.wnwn.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("SessionListener created "+event.getSession());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("SessionListener destoryed "+event.getSession());
	}

}
