package com.JavaWebApplication.Beans;

import java.util.Date;

public class ComplaintChat {
	private int complaintChatId;
	private int complaintId;
	private int managerId;
	private int userID;
	private String message;
	private Date timeStamp;
	
	public ComplaintChat(int complaintId, String message,Date timeStamp) {
		this.complaintId = complaintId;
		this.message = message;
		this.timeStamp = timeStamp;
		}
	
	public ComplaintChat() {
		this.complaintId = 0;
		this.message = "";
		
	}


	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getComplaintChatId() {
		return complaintChatId;
	}

	public void setComplaintChatId(int complaintChatId) {
		this.complaintChatId = complaintChatId;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	


}