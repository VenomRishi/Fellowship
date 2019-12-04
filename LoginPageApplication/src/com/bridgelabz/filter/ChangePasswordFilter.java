/******************************************************************************
 *  Purpose: Filter is used to check whether user putting proper mail or not
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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.bridgelabz.service.Util;

/**
 * Servlet Filter implementation class ChangePasswordFilter
 */
@WebFilter("/changepassword")
public class ChangePasswordFilter implements Filter {
	private RequestDispatcher rd;
	private String password;
	private String cpassword;
	private PrintWriter out;

	/**
	 * Purpose: method is used for filtering the data coming from jsp page
	 * 
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// we are going to check both password is matches or not
		password = request.getParameter("password");
		cpassword = request.getParameter("cpassword");
		response.setContentType("text/html");
		out = response.getWriter();
		rd = request.getRequestDispatcher("changepassword.jsp");

		if (!password.equals(cpassword)) {
			out.print("<script>alert('Both password is not matching')</script>");
			rd.include(request, response);
		} else if (!Util.validatePassword(password)) {
			out.print("<script>alert('Password is not strong')</script>");
			rd.include(request, response);
		} else
			chain.doFilter(request, response);

		// pass the request along the filter chain

	}

}
