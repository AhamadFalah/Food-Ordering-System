package com.JavaWebApplication.Beans;

import java.util.Date;

public class ComplaintDesc {
	private int complaintDescId;
	private int complaintId;
	private String complaintDes;
	private Date enteredDate;
	
	public ComplaintDesc(int complaintId, String complaintDes,Date enteredDate) {
		this.complaintId = complaintId;
		this.complaintDes = complaintDes;
		this.enteredDate = enteredDate;
	}
	
	public ComplaintDesc() {
		this.setComplaintId(0);
		this.setComplaintDes("");
	}

	public int getComplaintDescId() {
		return complaintDescId;
	}

	public void setComplaintDescId(int complaintDescId) {
		this.complaintDescId = complaintDescId;
	}

	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public String getComplaintDes() {
		return complaintDes;
	}

	public void setComplaintDes(String complaintDes) {
		this.complaintDes = complaintDes;
	}

	public Date getEnteredDate() {
		return enteredDate;
	}

	public void setEnteredDate(Date enteredDate) {
		this.enteredDate = enteredDate;
	}
}
