/******************************************************************************
 *  Purpose: Filter is used to check whether Login page validation is 
 *  		 proper or not
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   07-10-2019
 *
 ******************************************************************************/
package com.bridgelabz.filter;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.bridgelabz.service.Util;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/login")
public class LoginFilter implements Filter {

	/**
	 * Purpose: method is used to filtering the data coming from jsp page
	 * 
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println("In filter");
		if (username.length() < 5) {
			out.print("<script>alert('Invalid username')</script>");

		} else if (!Util.validatePassword(password)) {
			out.print("<script>alert('Invalid password')</script>");

		} else
			chain.doFilter(request, response);
	}

}
