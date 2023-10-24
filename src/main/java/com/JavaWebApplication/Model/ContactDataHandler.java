package com.JavaWebApplication.Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.JavaWebApplication.Beans.Contact;
import com.JavaWebApplication.Beans.user;

public class ContactDataHandler {

	//Inserts into the database
	public static boolean insertcontact(Contact c ) {
		boolean isSuccess = false;
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try{
			//validation
		//	Statement stmt = con.createStatement();
		//	String sql= "select userID from signupdata where user_Email='"+uemail+"'";
		//	ResultSet rs = stmt.executeQuery(sql);
		//	if(rs.next()) {		
				PreparedStatement stmt=con.prepareStatement("INSERT INTO contact(UserID,Email,Name,Question,Answer) VALUES(?,?,?,?,?) ");
				stmt.setInt(1, c.getUserID());
				stmt.setString(2, c.getEmail());
				stmt.setString(3, c.getName());
				stmt.setString(4, c.getInquery());
				stmt.setString(5, "Pending");
				//String sql= "INSERT INTO contact(Email,name,question) VALUES('"+uemail+"','"+uname+"','"+inquery+"')";
				int rs = stmt.executeUpdate();
				if(rs > 0) {
					isSuccess = true;
				}
				else {
					isSuccess = false;
				}
				
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return isSuccess;	
		
	}
	
	//Getting all the user
	public List<Contact> SelectAllInquiries(){
		List<Contact> ListInquiry=new ArrayList<>();
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("SELECT * FROM contact");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				int ContactID=rs.getInt("Contact_ID");
				int UserID=rs.getInt("UserID");
				String Email=rs.getString("Email");
				String Name=rs.getNString("Name");
				String Question=rs.getString("Question");
				String answer=rs.getString("Answer");
				Contact c1=new Contact();
				c1.setContactID(ContactID);
				c1.setUserID(UserID);
				c1.setEmail(Email);
				c1.setName(Name);
				c1.setInquery(Question);
				c1.setAnswer(answer);
				ListInquiry.add(c1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ListInquiry;
		
	}
	
	//Update Answer
	public boolean updateAnswer(Contact c) {
		boolean result=false;
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("UPDATE contact SET Answer=? WHERE Contact_ID=?");
			stmt.setString(1, c.getAnswer());
			stmt.setInt(2, c.getUserID());
			result=stmt.executeUpdate()>0;
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	//Delete inquiry
	public boolean deleteInquriry(Contact c) {
		boolean result=false;
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("DELETE FROM contact WHERE Contact_ID=?");
			stmt.setInt(1, c.getContactID());
			result=stmt.executeUpdate()>0;
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	//Select for sepcifi User
	public List<Contact>SelectListForUser(int userID){
		List<Contact>UserList=new ArrayList<>();
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("SELECT * FROM contact where UserID=?");
			stmt.setInt(1, userID);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				int ContactID=rs.getInt("Contact_ID");
				int UserID=rs.getInt("UserID");
				String Email=rs.getString("Email");
				String Name=rs.getNString("Name");
				String Question=rs.getString("Question");
				String answer=rs.getString("Answer");
				Contact c1=new Contact();
				c1.setContactID(ContactID);
				c1.setUserID(UserID);
				c1.setEmail(Email);
				c1.setName(Name);
				c1.setInquery(Question);
				c1.setAnswer(answer);
				UserList.add(c1);
			}
			return UserList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return UserList;
		
	}
	
	public List<Contact> SelectAllInquiriesData(){
		List<Contact> ListInquiry=new ArrayList<>();
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("SELECT * FROM contact");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				int ContactID=rs.getInt("Contact_ID");
				int UserID=rs.getInt("UserID");
				String Email=rs.getString("Email");
				String Name=rs.getNString("Name");
				String Question=rs.getString("Question");
				String answer=rs.getString("Answer");
				String date=rs.getString("Date");
				Contact c1=new Contact();
				c1.setContactID(ContactID);
				c1.setUserID(UserID);
				c1.setEmail(Email);
				c1.setName(Name);
				c1.setInquery(Question);
				c1.setAnswer(answer);
				c1.setDate(date);
				ListInquiry.add(c1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ListInquiry;
		
	}
	
}
