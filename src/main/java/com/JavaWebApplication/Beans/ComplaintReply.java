package com.JavaWebApplication.Beans;

import java.util.Date;

public class ComplaintReply {
	private int complaintReplyId;
	private int complaintId;
	private String replyDes;
	private Date enteredDate;
	
	public ComplaintReply(int complaintId, String replyDes,Date enteredDate) {
		this.complaintId = complaintId;
		this.replyDes = replyDes;
		this.enteredDate = enteredDate;
		}
	
	public ComplaintReply() {
		this.setComplaintId(0);
		this.setReplyDes("");
	}

	public int getComplaintReplyId() {
		return complaintReplyId;
	}

	public void setComplaintReplyId(int complaintReplyId) {
		this.complaintReplyId = complaintReplyId;
	}

	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public String getReplyDes() {
		return replyDes;
	}

	public void setReplyDes(String replyDes) {
		this.replyDes = replyDes;
	}

	public Date getEnteredDate() {
		return enteredDate;
	}

	public void setEnteredDate(Date enteredDate) {
		this.enteredDate = enteredDate;
	}
	


}