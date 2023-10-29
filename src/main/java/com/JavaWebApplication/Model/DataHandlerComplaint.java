package com.JavaWebApplication.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.JavaWebApplication.Beans.Complaint;

public class DataHandlerComplaint {
	
	
	//Inserting Complaint Details Into Database
	public boolean InsertComplaintDetails(Complaint c,int UserID) {
		boolean result=false;
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement ps=con.prepareStatement("INSERT INTO complaint(User_ID,Order_ID,reason,other_reason) values(?,?,?,?)");
			ps.setInt(1, UserID);
			ps.setInt(2, c.getOrderId());
			ps.setString(3, c.getReason());
			ps.setString(4, c.getOtherReason());
			
			result=ps.executeUpdate()>0;
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	//Check Complaint Details In The Database
	public ResultSet CheckComplaint(Complaint c) {
		ResultSet rs=null;
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement ps=con.prepareStatement("SELECT * FROM complaint WHERE Order_ID=?");
			ps.setInt(1,c.getOrderId());
			rs=ps.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	
	//Update Complaint Details In The Database
	public boolean updateComplaint(Complaint comp) {
		boolean update=false;
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement ps=con.prepareStatement("UPDATE complaint SET reason = ?, other_reason = ? WHERE Complaint_ID = ?");
			ps.setString(1, comp.getReason());
			ps.setString(2, comp.getOtherReason());
			ps.setInt(3, comp.getComplaintId());
			update=ps.executeUpdate()>0;
			return update;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return update;
	}

	//Delete Complaint Details In The Database
	public boolean DeleteUserComplaint(int ComplaintID) {
		boolean delete=false;
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement ps=con.prepareStatement("DELETE FROM complaint WHERE Complaint_ID=?;");
			ps.setInt(1, ComplaintID);
			delete=ps.executeUpdate()>0;
			return delete;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return delete;
	}
	
	
	
	//Select All The Complaints In The DataBase
	public List<Complaint> ListAllComplaintDetails(){
		List<Complaint>ComplaintList=new ArrayList<>();
		MyDB db=new MyDB();
		ResultSet rs=null;
		Connection con=db.getCon();
		try {
			PreparedStatement ps=con.prepareStatement("SELECT * FROM complaint ORDER BY timestamp DESC");
			
			rs=ps.executeQuery();
			while(rs.next()) {
				int complaintId=rs.getInt("Complaint_ID");
				int userId=rs.getInt("User_ID");
				int orderId=rs.getInt("Order_ID");
				String reason = rs.getString("reason");
				String otherReason=rs.getString("other_reason");
				String status=rs.getString("Status");
				Date timeStamp=rs.getDate("TimeStamp");
				Complaint comp = new Complaint();
				comp.setComplaintId(complaintId);
				comp.setUserId(userId);
				comp.setOrderId(orderId);
				comp.setReason(reason);
				comp.setOtherReason(otherReason);
				comp.setStatus(status);
				comp.setTimeStamp(timeStamp);
				ComplaintList.add(comp);
			}
			return ComplaintList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ComplaintList;
		
	}
	
	//Select The Complaints In The Database Linked To The UserID
	public List<Complaint> ListUserComplaintDetails(int UserID){
		List<Complaint>UserComplaintList = new ArrayList<>();
		MyDB db=new MyDB();
		ResultSet rs=null;
		Connection con=db.getCon();
		try {
			PreparedStatement ps=con.prepareStatement("SELECT * FROM complaint WHERE User_ID=? ;");
			ps.setInt(1, UserID);
			rs=ps.executeQuery();
			while(rs.next()) {
				int complaintId=rs.getInt("Complaint_ID");
				int orderId=rs.getInt("Order_ID");
				String reason = rs.getString("reason");
				String otherReason=rs.getString("other_reason");
				String status=rs.getString("Status");
				Date timeStamp=rs.getDate("TimeStamp");
				Complaint comp = new Complaint();
				comp.setComplaintId(complaintId);
				comp.setOrderId(orderId);
				comp.setReason(reason);
				comp.setOtherReason(otherReason);
				comp.setStatus(status);
				comp.setTimeStamp(timeStamp);
				UserComplaintList.add(comp);
			}
			return UserComplaintList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return UserComplaintList;
		
	}
}
