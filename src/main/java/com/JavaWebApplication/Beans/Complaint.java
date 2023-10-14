package com.JavaWebApplication.Beans;

public class Complaint {
	private int complaintId;
	private int userId;
	private int orderId;
	
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
	
}
