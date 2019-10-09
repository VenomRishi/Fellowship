//package com.bridgelabz.controller;
///******************************************************************************
// *  Purpose: Servlet which is created for sending the email for forgot password
// *  		 operation
// *
// *  @author  Rishikesh Mhatre
// *  @version 1.0
// *  @since   07-10-2019
// *
// ******************************************************************************/
//
//
//import java.io.IOException;
//import java.util.Properties;
//
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class ForgotPassword
// */
//@WebServlet("/forgotpassword")
//public class ForgotPassword extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	private String to = "";
//	private String from = "mhatrerishikesh@gmail.com";
//	private String host = "localhost";
//	private Properties properties = null;
//	private Session session = null;
//	private MimeMessage message = null;
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		// should check whether that email is provided by user is available in database
//		// or not
//		String email = request.getParameter("email");
//
//		to += email;
//
//		// mail configuration
//		// Get system properties
//		properties = System.getProperties();
//
//		// Setup mail server
//		properties.setProperty("mail.smtp.host", host);
//
//		// Get the default Session object.
//		session = Session.getDefaultInstance(properties);
//
//		try {
//			// Create a default MimeMessage object.
//			message = new MimeMessage(session);
//
//			// Set From: header field of the header.
//			message.setFrom(new InternetAddress(from));
//
//			// Set To: header field of the header.
//			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//
//			// Set Subject: header field
//			message.setSubject("Email is generated for creating new password to email");
//
//			// Send the actual HTML message, as big as you like
//			message.setContent("<h1>This is actual message</h1>", "text/html");
//
//			// Send message
//			Transport.send(message);
//			System.out.println("Sent message successfully....");
//		} catch (MessagingException msgex) {
//			msgex.printStackTrace();
//		}
//
//	}
//
//}
