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
	
	
	//Inserting Complaint Details into Database
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
	
	//checkMenuItem
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
	
//	public ResultSet CheckQuantity(Cart c) {
//		ResultSet rs=null;
//		MyDB db=new MyDB();
//		Connection con=db.getCon();
//		try {
//			PreparedStatement ps=con.prepareStatement("SELECT Quantity FROM cart WHERE Menu_Item_ID=? AND CartID=?");
//			ps.setInt(1,c.getMenuItemID());
//			ps.setInt(2,c.getCardID());
//			rs=ps.executeQuery();
//			return rs;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return rs;
//		
//	}
//	
//	public boolean updateQuantity(Cart c,int Cartid,int MenuItemid) {
//		boolean update=false;
//		MyDB db=new MyDB();
//		Connection con=db.getCon();
//		try {
//			PreparedStatement ps=con.prepareStatement("UPDATE cart SET Quantity=? WHERE CartID=? AND Menu_Item_ID=?");
//			ps.setInt(1, c.getQuantity());
//			ps.setInt(2, Cartid);
//			ps.setInt(3, MenuItemid);
//			update=ps.executeUpdate()>0;
//			return update;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return update;
//	}
//	
//	public boolean deleteQuantity(Cart c,int Cartid,int MenuItemid) {
//		boolean delete=false;
//		MyDB db=new MyDB();
//		Connection con=db.getCon();
//		try {
//			PreparedStatement ps=con.prepareStatement("DELETE FROM cart WHERE CartID=? AND Menu_Item_Id=?;");
//			ps.setInt(1, Cartid);
//			ps.setInt(2, MenuItemid);
//			delete=ps.executeUpdate()>0;
//			return delete;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return delete;
//	}
	
	//Select all the complaint details
	public List<Complaint> ListAllComplaintDetails(){
		List<Complaint>ComplaintList=new ArrayList<>();
		MyDB db=new MyDB();
		ResultSet rs=null;
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("SELECT * FROM complaint ORDER BY timestamp DESC");
			rs=stmt.executeQuery();
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
}
