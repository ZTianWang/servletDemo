package com.wnwn.servlet.formProcessing;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Redirect2 extends HttpServlet {
	private static final long serialVersionUID = -1903229518693812988L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Redirect2 servlet");
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().write("Redirect2 servelt!");
	}
	
}
