package com.JavaWebApplication.Beans;

import java.util.Date;

public class Complaint {
	private int complaintId;
	private int userId;
	private int orderId;
	private boolean status;
	private Date timestamp;
	
	public Complaint(int userID, int orderID) {
		this.setUserId(userID);
		this.setOrderId(orderID);
	}
	
public Complaint() {
		this.setUserId(0);
		this.setOrderId(0);
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

public boolean isStatus() {
	return status;
}

public void setStatus(boolean status) {
	this.status = status;
}

public Date getTimestamp() {
	return timestamp;
}

public void setTimestamp(Date timestamp) {
	this.timestamp = timestamp;
}
	
}
