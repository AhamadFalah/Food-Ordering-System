package com.JavaWebApplication.Beans;

import java.util.Date;

public class Complaint {
	private int complaintId;
	private int userId;
	private int orderId;
	private String reason;
	private String otherReason;
	private String status;
	private Date timeStamp;
	
	public Complaint(int userID, int orderID,String reason) {
		this.userId = userID;
		this.orderId = orderID;
		this.reason = reason;
		this.status = "Pending";
		this.timeStamp = new Date();
	}
	
public Complaint() {
	this.userId = 0;
	this.orderId = 0;
	this.reason = "";
	this.status = "";
	}

public int getComplaintId() {
	return complaintId;
}

public void setComplaintId(int complaintId) {
	this.complaintId = complaintId;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public int getOrderId() {
	return orderId;
}

public void setOrderId(int orderId) {
	this.orderId = orderId;
}

public Date getTimeStamp() {
	return timeStamp;
}

public void setTimeStamp(Date timeStamp) {
	this.timeStamp = timeStamp;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public String getReason() {
	return reason;
}

public void setReason(String reason) {
	this.reason = reason;
}

public String getOtherReason() {
	return otherReason;
}

public void setOtherReason(String otherReason) {
	this.otherReason = otherReason;
}
	
}
