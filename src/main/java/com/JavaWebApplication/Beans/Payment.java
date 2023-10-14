package com.JavaWebApplication.Beans;

public class Payment {
	private int UserID;
	private int orderID;
	private String Email;
	private String Address;
	private String Paymment_type;
	private String Card_Name;
	private int card_No;
	private String Expiary_Month;
	private String Expiary_Year;
	public int getCard_No() {
		return card_No;
	}
	public void setCard_No(int card_No) {
		this.card_No = card_No;
	}
	private int CVV;
	private double Total_Price;
	private String transaction_Date;
	private String Order_Details;
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPaymment_type() {
		return Paymment_type;
	}
	public void setPaymment_type(String paymment_type) {
		Paymment_type = paymment_type;
	}
	public String getCard_Name() {
		return Card_Name;
	}
	public void setCard_Name(String card_Name) {
		Card_Name = card_Name;
	}
	public String getExpiary_Month() {
		return Expiary_Month;
	}
	public void setExpiary_Month(String expiary_Month) {
		Expiary_Month = expiary_Month;
	}
	public String getExpiary_Year() {
		return Expiary_Year;
	}
	public void setExpiary_Year(String expiary_Year) {
		Expiary_Year = expiary_Year;
	}
	public int getCVV() {
		return CVV;
	}
	public void setCVV(int cVV) {
		CVV = cVV;
	}
	public double getTotal_Price() {
		return Total_Price;
	}
	public void setTotal_Price(double total_Price) {
		Total_Price = total_Price;
	}
	public String getTransaction_Date() {
		return transaction_Date;
	}
	public void setTransaction_Date(String transaction_Date) {
		this.transaction_Date = transaction_Date;
	}
	public String getOrder_Details() {
		return Order_Details;
	}
	public void setOrder_Details(String order_Details) {
		Order_Details = order_Details;
	}
	
	
	
}
