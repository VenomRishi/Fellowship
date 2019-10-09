
/******************************************************************************
 *  Purpose: Servlet which is created for sending the email for forgot password
 *  		 operation
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   07-10-2019
 *
 ******************************************************************************/
package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.dao.Dao;

/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/forgotpassword")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Properties properties = null;
	private String from = "forgotbridge70@gmail.com";
	private String password = "8855220088";
	private String to = "";
	private Session session = null;
	private Dao dao = new Dao();
	String email = "";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		// should check whether that email is provided by user is available in database
//		// or not

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		email = request.getParameter("email");
		try {
			if (dao.checkUser(email) == 1) {
				if (sendEmail() == 1) {
					out.print("<script>alert('Password change link send on email')</script>");
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					rd.include(request, response);
					//response.sendRedirect("login.jsp");
				}
			} else {
				System.out.println("Failed in sending mail");
				out.print("<script>alert('Email not found in database please enter valid email')</script>");
				RequestDispatcher rd = request.getRequestDispatcher("forgotpassword.jsp");
				rd.include(request, response);
			}

		} catch (ClassNotFoundException | SQLException e1) {

			e1.printStackTrace();
		}

	}

	private int sendEmail() {
		to += email;
		properties = new Properties();

		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		session = Session.getDefaultInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);

			}
		});
		Message message = prepareMessage(session, from, to);
		try {
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		System.out.println("Mail send");
		return 1;
	}

	private Message prepareMessage(Session session, String from, String to) {
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(from));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Password change email");
			message.setText("http://localhost:8080/LoginPageApplication/changepassword.jsp?email=" + to + "");

		} catch (MessagingException e) {

			e.printStackTrace();
		}
		return message;
	}

}
