package com.bridgelabz.controller;
/******************************************************************************
 *  Purpose: Servlet which is created for login validation in this we are
 *  		 validating user from database whether that user is exist in 
 *  		 database or not if exist then user will redirect to index page
 *  		 else user will stays on same page
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   04-10-2019
 *
 ******************************************************************************/


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.dao.Dao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao = new Dao();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// for printing the response
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		System.out.println("in login servlet");
		try {
			// checking whether user exist with this username
			if (!dao.readFromDatabase(username, password)) {
				// checking username and password is exist or not
				dao.close();
				out.print("<script>alert('This username and password is not exist in database')</script>");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			} else {
				dao.close();
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(30 * 60);
				session.setAttribute("username", username);
				response.sendRedirect("index.jsp");
//				response.sendRedirect("login.jsp");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
