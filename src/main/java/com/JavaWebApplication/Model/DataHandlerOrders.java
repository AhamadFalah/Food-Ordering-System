package com.JavaWebApplication.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.JavaWebApplication.Beans.Payment;

public class DataHandlerOrders {

	//Insert Into the order
	public boolean InsertIntoOrder(Payment p) {
		boolean result=false;
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("INSERT INTO customer_order(Customer_ID,Customer_name,Email,Address,Payment_Type,Card_Name,Card_No,Expiary_Month,Expiary_Year,CVV,Total_Price,Order_Details) values(?,?,?,?,?,?,?,?,?,?,?,?)" );
			stmt.setInt(1, p.getUserID());
			stmt.setString(2,p.getCustomerName());
			stmt.setString(3,p.getEmail());
			stmt.setString(4,p.getAddress());
			stmt.setString(5, p.getPaymment_type());
			stmt.setString(6,p.getCard_Name());
			stmt.setLong(7, p.getCard_No());
			stmt.setString(8, p.getExpiary_Month());
			stmt.setString(9, p.getExpiary_Year());
			stmt.setInt(10, p.getCVV());
			stmt.setDouble(11, p.getTotal_Price());
			stmt.setString(12, p.getOrder_Details());
			result=stmt.executeUpdate()>0;
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Payment> ListAllCustomerOrders(int Customet_ID){
		List<Payment>CustomerOrderList=new ArrayList<>();
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("SELECT * FROM customer_order WHERE Customer_ID=?");
			stmt.setInt(1, Customet_ID);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				String customerName=rs.getString("Customer_name");
				String payment=rs.getString("Payment_Type");
				double total=rs.getDouble("Total_Price");
				String transactionDate=rs.getString("Transaction_Date");
				String orderDetails=rs.getString("Order_Details");
				Payment p=new Payment();
				p.setCustomerName(customerName);
				p.setPaymment_type(payment);
				p.setTotal_Price(total);
				p.setTransaction_Date(transactionDate);
				p.setOrder_Details(orderDetails);
				CustomerOrderList.add(p);
			}
			return CustomerOrderList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CustomerOrderList;
	}
	
	
	//List all the order
	public List<Payment> ListAllOrders(){
		List<Payment>CustomerOrderList=new ArrayList<>();
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("SELECT * FROM customer_order");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				int OrderID=rs.getInt("Order_ID");
				int CustomerID=rs.getInt("Customer_ID");
				String customerName=rs.getString("Customer_name");
				String payment=rs.getString("Payment_Type");
				double total=rs.getDouble("Total_Price");
				String transactionDate=rs.getString("Transaction_Date");
				String orderDetails=rs.getString("Order_Details");
				Payment p=new Payment();
				p.setOrderID(OrderID);
				p.setUserID(CustomerID);
				p.setCustomerName(customerName);
				p.setPaymment_type(payment);
				p.setTotal_Price(total);
				p.setTransaction_Date(transactionDate);
				p.setOrder_Details(orderDetails);
				CustomerOrderList.add(p);
			}
			return CustomerOrderList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CustomerOrderList;
	}
	
	//Delete Order
	public boolean DeleteOrder(int orderID) {
		boolean result=false;
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("DELETE FROM customer_order WHERE Order_ID=?");
			stmt.setInt(1, orderID);
			result=stmt.executeUpdate()>0;
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	
	//Return all customer orders as a result set
	public ResultSet ALLOrders() {
		ResultSet rs = null;
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("SELECT * FROM customer_order");
			rs=stmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	//List all the order details
	public List<Payment> ListAllOrdersDetails(){
		List<Payment>CustomerOrderList=new ArrayList<>();
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("SELECT * FROM customer_order");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				int OrderID=rs.getInt("Order_ID");
				int CustomerID=rs.getInt("Customer_ID");
				String customerName=rs.getString("Customer_name");
				String email=rs.getString("Email");
				String address=rs.getString("Address");
				String payment=rs.getString("Payment_Type");
				String cardname=rs.getString("Card_name");
				double total=rs.getDouble("Total_Price");
				String transactionDate=rs.getString("Transaction_Date");
				String orderDetails=rs.getString("Order_Details");
				Payment p=new Payment();
				p.setOrderID(OrderID);
				p.setUserID(CustomerID);
				p.setCustomerName(customerName);
				p.setEmail(email);
				p.setAddress(address);
				p.setPaymment_type(payment);
				p.setCard_Name(cardname);
				p.setTotal_Price(total);
				p.setTransaction_Date(transactionDate);
				p.setOrder_Details(orderDetails);
				CustomerOrderList.add(p);
			}
			return CustomerOrderList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CustomerOrderList;
	}
}
