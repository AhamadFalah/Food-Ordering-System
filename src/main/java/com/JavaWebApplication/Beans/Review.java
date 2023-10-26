package com.JavaWebApplication.Beans;

public class Review extends user{
	private int review_ID;
	private int order_id;
	private int customer_id;
	private int rating;
	private String review;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public int getReview_ID() {
		return review_ID;
	}
	public void setReview_ID(int review_ID) {
		this.review_ID = review_ID;
	}
	
}
