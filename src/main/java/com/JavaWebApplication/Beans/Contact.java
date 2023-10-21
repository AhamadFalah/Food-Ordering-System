package com.JavaWebApplication.Beans;

public class Contact {
	private int contactID;
	private String name;
	private String email;
	private String inquery;
	private String Answer;
	private int UserID;
	private String date;
	public Contact(String name, String email, String inquery,String Answer,int UserID) {
	
		this.name = name;
		this.email = email;
		this.inquery = inquery;
		this.Answer=Answer;
		this.UserID=UserID;
	}
	
	public Contact() {
		
		this.name = "";
		this.email = "";
		this.inquery = "";
	}
	
	public int getContactID() {
		return contactID;
	}

	public void setContactID(int contactID) {
		this.contactID = contactID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInquery() {
		return inquery;
	}

	public void setInquery(String inquery) {
		this.inquery = inquery;
	}

	public String getAnswer() {
		return Answer;
	}

	public void setAnswer(String answer) {
		Answer = answer;
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
