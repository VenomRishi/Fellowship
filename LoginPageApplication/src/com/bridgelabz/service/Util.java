package com.bridgelabz.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

	private static Pattern pattern = null;
	private static Matcher matcher = null;

	/**
	 * Purpose: this method will validate password
	 * 
	 * @param password this is input from login form
	 * @return returns true if valid password or else returns false
	 */
	public static boolean validatePassword(String password) {
		String passwordPattern = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
		pattern = Pattern.compile(passwordPattern);
		matcher = pattern.matcher(password);
		return matcher.matches();
	}

	/**
	 * Purpose: method for name should not contain numbers
	 * 
	 * @param name input from user
	 * @return returns true if pattern matches else returns false
	 */
	public static boolean validateName(String name) {
		String patternStr = "^[a-zA-Z]{3,15}$";
		pattern = Pattern.compile(patternStr);
		matcher = pattern.matcher(name);
		return matcher.matches();
	}

	/**
	 * Purpose: method for validating email
	 * 
	 * @param email input from user
	 * @return returns true if pattern matches else returns false
	 */
	public static boolean validateEmail(String email) {
		String patternStr = "^[A-Za-z0-9+_.-]+@(.+)$";
		pattern = Pattern.compile(patternStr);
		matcher = pattern.matcher(email);
		return matcher.matches();
	}
}
