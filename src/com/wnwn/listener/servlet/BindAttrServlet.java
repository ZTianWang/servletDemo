package com.wnwn.listener.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BindAttrServlet extends HttpServlet {
	private static final long serialVersionUID = 2071251912467540256L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("------------------------------");
		
		ServletContext context = getServletContext();
		System.out.println("ServletContext add");
		context.setAttribute("context", "context test");
		System.out.println("ServletContext added");
		System.out.println("ServletContext replace");
		context.setAttribute("context", "context replace");
		System.out.println("ServletContext replace");
		System.out.println("ServletContext remove");
		context.removeAttribute("context");
		System.out.println("ServletContext removed");
		System.out.println("------------------------------");
		
		HttpSession session = req.getSession();
		System.out.println("HttpSession add");
		session.setAttribute("session", "session test");
		System.out.println("HttpSession added");
		System.out.println("HttpSession replace");
		session.setAttribute("session", "session replace");
		System.out.println("HttpSession replace");
		System.out.println("HttpSession remove");
		session.removeAttribute("session");
		System.out.println("HttpSession removed");
		System.out.println("------------------------------");
		
		System.out.println("Request add");
		req.setAttribute("req", "req test");
		System.out.println("Request added");
		System.out.println("Request replace");
		req.setAttribute("req", "req replace");
		System.out.println("Request replace");
		System.out.println("Request remove");
		req.removeAttribute("req");
		System.out.println("Request removed");
	}
}
