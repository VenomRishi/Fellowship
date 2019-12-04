/******************************************************************************
 *  Purpose: Servlet which is created for changing the password in database
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   09-10-2019
 *
 ******************************************************************************/

package com.bridgelabz.controller;

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
 * Servlet implementation class ChangePassword
 */
@WebServlet("/changepassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Dao dao = new Dao();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("email");

		String password = request.getParameter("cpassword");
		try {
			if (dao.changePassword(username, password)) {
				// password is updated now go to index page
				dao.close();
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(30 * 60);
				session.setAttribute("username", username);
				response.sendRedirect("index.jsp");
			} else {
				dao.close();
				out.print("<script>alert('Error in changing password')</script>");
				RequestDispatcher rd = request.getRequestDispatcher("changepassword.jsp");
				rd.include(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
