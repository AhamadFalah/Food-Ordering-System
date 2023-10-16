package com.JavaWebApplication.Model;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.JavaWebApplication.Beans.Payment;
import com.JavaWebApplication.Beans.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataProvider {
	
	public int writeData(user u1) {
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("INSERT INTO signupdata(user_Name,user_Email,user_Password,user_ProfileImage) values(?,?,?,?)");
			String defaultImage="images/default.png";
			stmt.setString(1, u1.getName());
			stmt.setString(2, u1.getEmail());
			stmt.setString(3,u1.getPassword());
			stmt.setString(4, defaultImage);
			int rowcount=stmt.executeUpdate();
			System.out.println("Data successfully entered into the database");
			return rowcount;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public ResultSet readData(user u1) {
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("SELECT user_Email,user_Password FROM signupdata WHERE user_Email= ? AND user_Password= ?");
			stmt.setString(1, u1.getEmail());
			stmt.setString(2, u1.getPassword());
			ResultSet rs=stmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet CheckEmail(user u1) {
		ResultSet rs=null;
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("SELECT * FROM signupdata where user_Email=?");
			stmt.setString(1, u1.getEmail());
			rs=stmt.executeQuery();
			System.out.println("code is here");
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
		
	}
	
	public boolean UpdatePassword(user u1,int UserID) {
		boolean update=false;
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("UPDATE signupdata SET user_Password=? WHERE userID=?");
			stmt.setString(1, u1.getPassword());
			stmt.setInt(2, UserID);
			update=stmt.executeUpdate()>0;
			return update;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return update;
	}
	
	public boolean updateUserProfile(user u1,int UserId) {
		boolean update=false;
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("UPDATE signupdata SET user_Name=?,user_PhoneNumber=?,user_Address=?,user_ProfileImage=? WHERE userID=?");
			stmt.setString(1, u1.getName());
			stmt.setString(2, u1.getPhoneNo());
			stmt.setString(3, u1.getAddress());
			stmt.setString(4, u1.getProfileImage());
			stmt.setInt(5, UserId);
			update=stmt.executeUpdate()>0;
			return update;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public boolean updateUserEmail(user u1,int Userid) {
		boolean update=false;
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("UPDATE signupdata SET user_Email=? WHERE userID=?");
			stmt.setString(1, u1.getEmail());
			stmt.setInt(2, Userid);
			update=stmt.executeUpdate()>0;
			return update;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return update;
	}
	
	public List<user> ListAllUsers(){
		List<user>UserList=new ArrayList<>();
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("SELECT * FROM signupdata");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				int customerID=rs.getInt("userID");
				String customerName=rs.getString("user_Name");
				String customeremail=rs.getString("user_Email");
				String customerNo=rs.getString("user_PhoneNumber");
				String Address=rs.getString("user_Address");
				
				user p=new user();
				p.setUserID(customerID);
				p.setName(customerName);
				p.setEmail(customeremail);
				p.setPhoneNo(customerNo);
				p.setAddress(Address);
				UserList.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return UserList;
		
	}
		
		
		public boolean deleteuser(int userID) {
			boolean rowDeleted = false;
			MyDB db=new MyDB();
			Connection con=db.getCon();
			try {
				PreparedStatement stmt=con.prepareStatement("DELETE FROM signupdata WHERE userID=? ");
				stmt.setInt(1, userID);
				rowDeleted=stmt.executeUpdate()>0;
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return rowDeleted;
			
		}
		
		
	}
	
	
	
	
	

