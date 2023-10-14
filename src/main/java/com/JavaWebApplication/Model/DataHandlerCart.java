package com.JavaWebApplication.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public ResultSet CheckQuantity(Cart c) {
		ResultSet rs=null;
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement ps=con.prepareStatement("SELECT Quantity FROM cart WHERE Menu_Item_ID=? AND CartID=?");
			ps.setInt(1,c.getMenuItemID());
			ps.setInt(2,c.getCardID());
			rs=ps.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	
	public boolean updateQuantity(Cart c,int Cartid,int MenuItemid) {
		boolean update=false;
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement ps=con.prepareStatement("UPDATE cart SET Quantity=? WHERE CartID=? AND Menu_Item_ID=?");
			ps.setInt(1, c.getQuantity());
			ps.setInt(2, Cartid);
			ps.setInt(3, MenuItemid);
			update=ps.executeUpdate()>0;
			return update;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return update;
	}
	
	public boolean deleteQuantity(Cart c,int Cartid,int MenuItemid) {
		boolean delete=false;
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement ps=con.prepareStatement("DELETE FROM cart WHERE CartID=? AND Menu_Item_Id=?;");
			ps.setInt(1, Cartid);
			ps.setInt(2, MenuItemid);
			delete=ps.executeUpdate()>0;
			return delete;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return delete;
	}
	
	//Select all the cart details
	public List<Cart> SelectAllCartdetails(int userID){
		List<Cart>CartList=new ArrayList<>();
		MyDB db=new MyDB();
		ResultSet rs=null;
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("SELECT * FROM cart WHERE User_ID=?");
			stmt.setInt(1, userID);
			rs=stmt.executeQuery();
			while(rs.next()) {
				int cartID=rs.getInt("CartID");
				int menuID=rs.getInt("Menu_Item_ID");
				String menuItemName=rs.getString("MenuName");
				String Catagory=rs.getString("Catagory");
				double price=rs.getDouble("Price");
				int quantity=rs.getInt("Quantity");
				Cart c=new Cart();
				c.setMenuItemID(menuID);
				c.setMenuItemName(menuItemName);
				c.setMenuItemCategory(Catagory);
				c.setQuantity(quantity);
				c.setMenuItemPrice(price);
				c.setCardID(cartID);
				CartList.add(c);
			}
			return CartList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CartList;
		
	}

}
