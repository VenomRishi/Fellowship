/******************************************************************************
 *  Purpose: Program is written for model of user table of database
 *
 *  @author  Rishikesh Mhatre
 *  @version 1.0
 *  @since   05-10-2019
 *
 ******************************************************************************/

package com.bridgelabz.model;

public class User {

	private String fname;
	private String lname;
	private String username;
	private String password;
	private String dateupdated;

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDateupdated() {
		return dateupdated;
	}

	public void setDateupdated(String dateupdated) {
		this.dateupdated = dateupdated;
	}

	@Override
	public String toString() {
		return "User [fname=" + fname + ", lname=" + lname + ", username=" + username + ", password="
				+ password + ", dateupdated=" + dateupdated + "]";
	}

}
