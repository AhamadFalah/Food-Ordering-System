package com.JavaWebApplication.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.JavaWebApplication.Beans.Cart;

public class DataHandlerCart {
	
	
	//Inserting cart to database
	public boolean InsertCartDetails(Cart c,int UserID) {
		boolean result=false;
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("INSERT INTO cart(User_ID,Menu_Item_ID,MenuName,Catagory,Price,Quantity) values(?,?,?,?,?,?)");
			stmt.setInt(1, UserID);
			stmt.setInt(2, c.getMenuItemID());
			stmt.setString(3, c.getMenuItemName());
			stmt.setString(4, c.getMenuItemCategory());
			stmt.setDouble(5, c.getMenuItemPrice());
			stmt.setInt(6, c.getQuantity());
			result=stmt.executeUpdate()>0;
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	//checkMenuItem
	public ResultSet CheckMenuItem(Cart c) {
		ResultSet rs=null;
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("SELECT * FROM cart WHERE Menu_Item_ID=?");
			stmt.setInt(1,c.getMenuItemID());
			rs=stmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}

}
