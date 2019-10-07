package com.bridgelabz.filter;

/******************************************************************************
 *  Purpose: Filter is used to check whether registration page validation is 
 *  		 proper or not
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   07-10-2019
 *
 ******************************************************************************/

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.bridgelabz.service.Util;

/**
 * Servlet Filter implementation class RegisterFilter
 */
@WebFilter("/register")
public class RegisterFilter implements Filter {

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String cpassword = request.getParameter("cpassword");

		boolean validate = true;
		if (!Util.validateName(fname)) {
			out.print("<script>alert('invalid first name')</script>");
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.include(request, response);
			validate = false;
		} else if (!Util.validateName(lname)) {
			out.print("<script>alert('invalid last name')</script>");
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.include(request, response);
			validate = false;
		} else if (!Util.validateEmail(username)) {
			out.print("<script>alert('invalid email')</script>");
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.include(request, response);
			validate = false;
		} else if (!Util.validatePassword(password)) {
			out.print("<script>alert('invalid password')</script>");
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.include(request, response);
			validate = false;
		} else if (!password.equals(cpassword)) {
			out.print("<script>alert('password not matches')</script>");
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.include(request, response);
			validate = false;
		}
		if (validate)
			chain.doFilter(request, response);
		// pass the request along the filter chain.

	}

}
