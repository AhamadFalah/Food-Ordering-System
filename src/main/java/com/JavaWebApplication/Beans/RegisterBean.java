package com.JavaWebApplication.Beans;

public class RegisterBean {
	private String firstname;
	private String lastname;
	private String country;
	private String message;
	public RegisterBean(String firstname, String lastname, String country, String message) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.country = country;
		this.message = message;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
