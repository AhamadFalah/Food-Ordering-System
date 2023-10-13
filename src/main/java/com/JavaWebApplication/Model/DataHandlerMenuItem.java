package com.JavaWebApplication.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.JavaWebApplication.Beans.MenuItem;

public class DataHandlerMenuItem {
	
	//Inserting menu item values to the database
	public int insertMenuItemDetails(MenuItem mi) {
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("INSERT INTO menuitem(Menu_Item_Name,Menu_Item_Catagory,Menu_Item_Price) values(?,?,?)");
			stmt.setString(1, mi.getMenuItemName());
			stmt.setString(2, mi.getMenuItemCategory());
			stmt.setDouble(3, mi.getMenuItemPrice());
			int row=stmt.executeUpdate();
			System.out.println("Data successfully entered in to the databse");
			return row;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	public ResultSet CheckMenuItem(MenuItem mi) {
		MyDB db=new MyDB();
		ResultSet rs = null;
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("SELECT * FROM menuitem WHERE Menu_Item_Name=? AND Menu_Item_Catagory=?");
			stmt.setString(1,mi.getMenuItemName());
			stmt.setString(2,mi.getMenuItemCategory() );
			rs=stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
		
	}
	//selecting a menu item from the database
	public MenuItem selectMenuItem(int menuItemID) {
		MenuItem item = null;
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try{
			PreparedStatement stmt=con.prepareStatement("SELECT * FROM menuitem where MenuItem_ID= ? ");
			stmt.setInt(1, menuItemID);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				String MenuItem_Name=rs.getString("Menu_Item_Name");
				String MenuItemCategory=rs.getString("Menu_Item_Catagory");
				double MenuItem_price=rs.getDouble("Menu_Item_Price");
				item=new MenuItem(MenuItem_Name,MenuItemCategory,MenuItem_price);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return item;
	}
	
	//selecting all the menu items from the database
	public List<MenuItem> SelectAllTheMenuItems(){
		List<MenuItem>Items=new ArrayList<>();
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("SELECT * FROM menuitem");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				int ItemId=rs.getInt("MenuItem_ID");
				String ItemName=rs.getString("Menu_Item_Name");
				String ItemCategory=rs.getString("Menu_Item_Catagory");
				double ItemPrice=rs.getDouble("Menu_Item_Price");
				String ItemImageURL=rs.getString("Menu_Item_Image_URL");
				MenuItem item=new MenuItem();
				item.setMenuItemID(ItemId);
				item.setMenuItemName(ItemName);
				item.setMenuItemCategory(ItemCategory);
				item.setMenuItemPrice(ItemPrice);
				item.setMenuItemImageUrl(ItemImageURL);
				Items.add(item);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return Items;
	}
	
	//updating the menu item
	public boolean updateMenuItem(MenuItem item) {
		boolean rowUpdated = false;
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
		PreparedStatement stmt=con.prepareStatement("UPDATE menuitem set Menu_Item_Name=?,Menu_Item_Catagory=?,Menu_Item_Price=? where MenuItem_ID=?");
		stmt.setString(1,item.getMenuItemName());
		stmt.setString(2,item.getMenuItemCategory());
		stmt.setDouble(3,item.getMenuItemPrice());
		stmt.setInt(4, item.getMenuItemID());
		rowUpdated=stmt.executeUpdate()>0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rowUpdated;
	}
	
	//deleting a menu item
	public boolean deletemenuitem(int menuitemID) {
		boolean rowDeleted = false;
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("DELETE FROM menuitem WHERE MenuItem_ID=?");
			stmt.setInt(1, menuitemID);
			rowDeleted=stmt.executeUpdate()>0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rowDeleted;
		
	}
	
	
	//selecting all the main courses from the database
	public List<MenuItem> SelectAllMainCoursesItems(){
		List<MenuItem>Items=new ArrayList<>();
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("SELECT * FROM menuitem WHERE Menu_Item_Catagory=?");
			stmt.setString(1, "Main course");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				int ItemId=rs.getInt("MenuItem_ID");
				String ItemName=rs.getString("Menu_Item_Name");
				String ItemCategory=rs.getString("Menu_Item_Catagory");
				double ItemPrice=rs.getDouble("Menu_Item_Price");
				String ItemImageURL=rs.getString("Menu_Item_Image_URL");
				MenuItem item=new MenuItem();
				item.setMenuItemID(ItemId);
				item.setMenuItemName(ItemName);
				item.setMenuItemCategory(ItemCategory);
				item.setMenuItemPrice(ItemPrice);
				item.setMenuItemImageUrl(ItemImageURL);
				Items.add(item);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return Items;
	}
	
	//selects all the apps from the database
	public List<MenuItem> SelectAllAppsCoursesItems(){
		List<MenuItem>Items=new ArrayList<>();
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("SELECT * FROM menuitem WHERE Menu_Item_Catagory=?");
			stmt.setString(1, "Appetizer");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				int ItemId=rs.getInt("MenuItem_ID");
				String ItemName=rs.getString("Menu_Item_Name");
				String ItemCategory=rs.getString("Menu_Item_Catagory");
				double ItemPrice=rs.getDouble("Menu_Item_Price");
				String ItemImageURL=rs.getString("Menu_Item_Image_URL");
				MenuItem item=new MenuItem();
				item.setMenuItemID(ItemId);
				item.setMenuItemName(ItemName);
				item.setMenuItemCategory(ItemCategory);
				item.setMenuItemPrice(ItemPrice);
				item.setMenuItemImageUrl(ItemImageURL);
				Items.add(item);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return Items;
	}
	
	//Selects all the desserts from the database
	public List<MenuItem> SelectAllDessertsCoursesItems(){
		List<MenuItem>Items=new ArrayList<>();
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("SELECT * FROM menuitem WHERE Menu_Item_Catagory=?");
			stmt.setString(1, "Dessert");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				int ItemId=rs.getInt("MenuItem_ID");
				String ItemName=rs.getString("Menu_Item_Name");
				String ItemCategory=rs.getString("Menu_Item_Catagory");
				double ItemPrice=rs.getDouble("Menu_Item_Price");
				String ItemImageURL=rs.getString("Menu_Item_Image_URL");
				MenuItem item=new MenuItem();
				item.setMenuItemID(ItemId);
				item.setMenuItemName(ItemName);
				item.setMenuItemCategory(ItemCategory);
				item.setMenuItemPrice(ItemPrice);
				item.setMenuItemImageUrl(ItemImageURL);
				Items.add(item);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return Items;
	}
	
	//Select all the drinks from the database
	public List<MenuItem> SelectDrinkCoursesItems(){
		List<MenuItem>Items=new ArrayList<>();
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("SELECT * FROM menuitem WHERE Menu_Item_Catagory=?");
			stmt.setString(1, "Drink");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				int ItemId=rs.getInt("MenuItem_ID");
				String ItemName=rs.getString("Menu_Item_Name");
				String ItemCategory=rs.getString("Menu_Item_Catagory");
				double ItemPrice=rs.getDouble("Menu_Item_Price");
				String ItemImageURL=rs.getString("Menu_Item_Image_URL");
				MenuItem item=new MenuItem();
				item.setMenuItemID(ItemId);
				item.setMenuItemName(ItemName);
				item.setMenuItemCategory(ItemCategory);
				item.setMenuItemPrice(ItemPrice);
				item.setMenuItemImageUrl(ItemImageURL);
				Items.add(item);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return Items;
	}
	
	//Search menu item Dessert
	public List<MenuItem> SearchDessertCoursesItems(String userInput){
		List<MenuItem>Items=new ArrayList<>();
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("SELECT * FROM menuitem WHERE Menu_Item_Catagory=? AND Menu_Item_Name=?");
			stmt.setString(1, "Dessert");
			stmt.setString(2, userInput);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				int ItemId=rs.getInt("MenuItem_ID");
				String ItemName=rs.getString("Menu_Item_Name");
				String ItemCategory=rs.getString("Menu_Item_Catagory");
				double ItemPrice=rs.getDouble("Menu_Item_Price");
				String ItemImageURL=rs.getString("Menu_Item_Image_URL");
				MenuItem item=new MenuItem();
				item.setMenuItemID(ItemId);
				item.setMenuItemName(ItemName);
				item.setMenuItemCategory(ItemCategory);
				item.setMenuItemPrice(ItemPrice);
				item.setMenuItemImageUrl(ItemImageURL);
				Items.add(item);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return Items;
	}
	
	//Search maincourse
	public List<MenuItem> SearchMainCoursesItems(String userInput){
		List<MenuItem>Items=new ArrayList<>();
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("SELECT * FROM menuitem WHERE Menu_Item_Catagory=? AND Menu_Item_Name=?");
			stmt.setString(1, "Main course");
			stmt.setString(2, userInput);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				int ItemId=rs.getInt("MenuItem_ID");
				String ItemName=rs.getString("Menu_Item_Name");
				String ItemCategory=rs.getString("Menu_Item_Catagory");
				double ItemPrice=rs.getDouble("Menu_Item_Price");
				String ItemImageURL=rs.getString("Menu_Item_Image_URL");
				MenuItem item=new MenuItem();
				item.setMenuItemID(ItemId);
				item.setMenuItemName(ItemName);
				item.setMenuItemCategory(ItemCategory);
				item.setMenuItemPrice(ItemPrice);
				item.setMenuItemImageUrl(ItemImageURL);
				Items.add(item);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return Items;
	}
	
	//search drink
	public List<MenuItem> SearchDrinkCoursesItems(String userInput){
		List<MenuItem>Items=new ArrayList<>();
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("SELECT * FROM menuitem WHERE Menu_Item_Catagory=? AND Menu_Item_Name=?");
			stmt.setString(1, "Drink");
			stmt.setString(2, userInput);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				int ItemId=rs.getInt("MenuItem_ID");
				String ItemName=rs.getString("Menu_Item_Name");
				String ItemCategory=rs.getString("Menu_Item_Catagory");
				double ItemPrice=rs.getDouble("Menu_Item_Price");
				String ItemImageURL=rs.getString("Menu_Item_Image_URL");
				MenuItem item=new MenuItem();
				item.setMenuItemID(ItemId);
				item.setMenuItemName(ItemName);
				item.setMenuItemCategory(ItemCategory);
				item.setMenuItemPrice(ItemPrice);
				item.setMenuItemImageUrl(ItemImageURL);
				Items.add(item);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return Items;
	}
	
	//search apps
	public List<MenuItem> SearchAppestiserCoursesItems(String userInput){
		List<MenuItem>Items=new ArrayList<>();
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("SELECT * FROM menuitem WHERE Menu_Item_Catagory=? AND Menu_Item_Name=?");
			stmt.setString(1, "Appetizer");
			stmt.setString(2, userInput);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				int ItemId=rs.getInt("MenuItem_ID");
				String ItemName=rs.getString("Menu_Item_Name");
				String ItemCategory=rs.getString("Menu_Item_Catagory");
				double ItemPrice=rs.getDouble("Menu_Item_Price");
				String ItemImageURL=rs.getString("Menu_Item_Image_URL");
				MenuItem item=new MenuItem();
				item.setMenuItemID(ItemId);
				item.setMenuItemName(ItemName);
				item.setMenuItemCategory(ItemCategory);
				item.setMenuItemPrice(ItemPrice);
				item.setMenuItemImageUrl(ItemImageURL);
				Items.add(item);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return Items;
	}
	
	//inserting menu item image url
	public boolean AddMenuItemImage(MenuItem item,int menuitemID) {
		boolean rowUpdate=false;
		
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("UPDATE menuitem SET Menu_Item_Image_URL=? WHERE MenuItem_ID=?");
			stmt.setString(1, item.getMenuItemImageUrl());
			stmt.setInt(2, menuitemID);
			rowUpdate=stmt.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowUpdate;
		
	}
	
}
