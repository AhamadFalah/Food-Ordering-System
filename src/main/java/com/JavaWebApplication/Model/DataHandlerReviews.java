package com.JavaWebApplication.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.JavaWebApplication.Beans.Review;

public class DataHandlerReviews {
	
	
	//insert into reviews
	public boolean InserIntoReviews(Review r){
		boolean result=false;
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("INSERT INTO review(Order_ID,Customer_ID,Rating,Review) VALUES(?,?,?,?)");
			stmt.setInt(1, r.getOrder_id());
			stmt.setInt(2, r.getCustomer_id());
			stmt.setInt(3, r.getRating());
			stmt.setString(4, r.getReview());
			result=stmt.executeUpdate()>0;
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
		
	}
	//check id review already present
	public ResultSet ChecIfReviewPresent(Review r) {
		ResultSet rs = null;
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("SELECT * FROM review WHERE Order_ID=? AND Customer_ID=?");
			stmt.setInt(1, r.getOrder_id());
			stmt.setInt(2, r.getCustomer_id());
			rs=stmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	
	//Get all the reviews of the customer
	public List<Review> GetAllTheReviews(int customerID){
		List<Review>ALLCustomerReviews=new ArrayList<>();
		ResultSet rs;
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("SELECT * from review WHERE Customer_ID=?");
			stmt.setInt(1, customerID);
			rs=stmt.executeQuery();
			while(rs.next()) {
				int OrderID=rs.getInt("Order_ID");
				int CustomerID=rs.getInt("Customer_ID");
				int rating=rs.getInt("Rating");
				String review=rs.getString("Review");
				Review r=new Review();
				r.setOrder_id(OrderID);
				r.setCustomer_id(CustomerID);
				r.setRating(rating);
				r.setReview(review);
				ALLCustomerReviews.add(r);
			}
			return ALLCustomerReviews;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ALLCustomerReviews;
	}
	
	//update Review
	public boolean EditReview(Review r) {
		boolean result = false;
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("UPDATE review SET Rating=?,Review=? WHERE Order_ID=? AND Customer_ID=?");
			stmt.setInt(1, r.getRating());
			stmt.setString(2, r.getReview());
			stmt.setInt(3, r.getOrder_id());
			stmt.setInt(4,r.getCustomer_id());
			result=stmt.executeUpdate()>0;
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	//list all the reviews
	public List<Review> GetAllTheReviewsInReviewPage(){
		List<Review>ALLCustomerReviews=new ArrayList<>();
		ResultSet rs;
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("SELECT * from review r,signupdata s WHERE r.Customer_ID=s.userID");
			rs=stmt.executeQuery();
			while(rs.next()) {
				int reviewID=rs.getInt("ReviewID");
				int OrderID=rs.getInt("r.Order_ID");
				int CustomerID=rs.getInt("r.Customer_ID");
				int rating=rs.getInt("r.Rating");
				String name=rs.getString("s.user_Name");
				String userProfileImage=rs.getString("s.user_ProfileImage");
				String review=rs.getString("r.Review");
				Review r=new Review();
				r.setReview_ID(reviewID);
				r.setOrder_id(OrderID);
				r.setCustomer_id(CustomerID);
				r.setRating(rating);
				r.setReview(review);
				r.setName(name);
				r.setProfileImage(userProfileImage);
				ALLCustomerReviews.add(r);
			}
			return ALLCustomerReviews;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ALLCustomerReviews;
	}
	
	//delete customer reviews
	public boolean DeleteCustomerReview(int reviewID) {
		boolean result=false;
		MyDB db=new MyDB();
		Connection con= db.getCon();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("DELETE  FROM review WHERE ReviewID=?");
			stmt.setInt(1, reviewID);
			result=stmt.executeUpdate()>0;
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
