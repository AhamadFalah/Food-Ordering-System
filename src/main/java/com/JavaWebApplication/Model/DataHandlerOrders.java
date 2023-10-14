package com.JavaWebApplication.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.JavaWebApplication.Beans.Payment;

public class DataHandlerOrders {

	//Insert Into the order
	public boolean InsertIntoOrder(Payment p) {
		boolean result=false;
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("INSERT INTO order(Customer_ID,Email,Address,Payment_Type,Card_Name,Card_No,Expiary_Month,Expiary_Year,CVV,Total_Price,Transaction_Date,Order_Details) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)" );
			stmt.setInt(1, p.getUserID());
			stmt.setString(2,p.getEmail());
			stmt.setString(3,p.getAddress());
			stmt.setString(4, p.getPaymment_type());
			stmt.setString(5,p.getCard_Name());
			stmt.setInt(6, p.getCard_No());
			stmt.setString(7, p.getExpiary_Month());
			stmt.setString(8, p.getExpiary_Year());
			stmt.setInt(9, p.getCVV());
			stmt.setDouble(10, p.getTotal_Price());
			stmt.setString(11, p.getTransaction_Date());
			stmt.setString(12, p.getOrder_Details());
			result=stmt.executeUpdate()>0;
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
}
