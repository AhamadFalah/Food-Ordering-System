package com.JavaWebApplication.Model;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.JavaWebApplication.Beans.RegisterBean;

public class UserDB {
	String message=null;
	public String insertUser(RegisterBean rb) {
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			Statement stmt=con.createStatement();
			stmt.executeUpdate("INSERT INTO signupdata(user_FirstName,user_LastName,country,message) VALUES('"+rb.getFirstname()+"','"+rb.getLastname()+"','"+rb.getCountry()+"','"+rb.getMessage()+"')");
			message="Data inserted successfully";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}
}
