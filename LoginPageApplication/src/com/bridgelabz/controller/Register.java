package com.bridgelabz.controller;

/******************************************************************************
 *  Purpose: Servlet which is created for registering new user into application
 *  		 in this class we are storing new user into database and redirecting
 *  		 user to index page
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   04-10-2019
 *
 ******************************************************************************/

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.dao.Dao;
import com.bridgelabz.model.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao = new Dao();
	private User user = new User();

	/**
	 * Purpose: method for handling the request from jsp page in the form of post
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 * @param request  request from jsp page
	 * @param response response from jsp page
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		user.setFname(request.getParameter("fname"));
		user.setLname(request.getParameter("lname"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		user.setDateupdated(format.format(date));
		try {
			if (!dao.checkUsernameFromDatabase(user.getUsername())) {
				if (dao.insertIntoDatabase(user)) {
					dao.close();
					HttpSession session = request.getSession();
					session.setMaxInactiveInterval(30 * 60);
					session.setAttribute("username", user.getUsername());
					response.sendRedirect("index.jsp");
				}
			} else {
				// user already available in database
				out.print("<script>alert('User already exist in database with this username')</script>");
				RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
				rd.include(request, response);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
