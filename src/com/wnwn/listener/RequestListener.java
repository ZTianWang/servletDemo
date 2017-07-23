package com.wnwn.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent event) {
		System.out.println("RequestListener destroyed "+event.getServletContext());
	}

	@Override
	public void requestInitialized(ServletRequestEvent event) {
		System.out.println("RequestListener initialized "+event.getServletContext());
	}

}
