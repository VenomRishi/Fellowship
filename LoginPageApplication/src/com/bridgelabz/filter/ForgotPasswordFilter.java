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
 * Servlet Filter implementation class ForgotPasswordFilter
 */
@WebFilter("/forgotpassword")
public class ForgotPasswordFilter implements Filter {

	/**
	 * Purpose: method is used to filtering the data coming from jsp page
	 * 
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");

		if (!Util.validateEmail(email)) {
			out.print("<script>alert('Please enter valid email')</script>");
			RequestDispatcher rd = request.getRequestDispatcher("forgotpassword.jsp");
			rd.include(request, response);
		} else {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}

	}

}
