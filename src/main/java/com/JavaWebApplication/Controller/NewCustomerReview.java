package com.JavaWebApplication.Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaWebApplication.Beans.Review;
import com.JavaWebApplication.Model.DataHandlerReviews;

/**
 * Servlet implementation class NewCustomerReview
 */
public class NewCustomerReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewCustomerReview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		RequestDispatcher d1=null;
		ResultSet rs;
		int OrderID=Integer.parseInt( request.getParameter("orderID"));
		int customerID=Integer.parseInt(request.getParameter("CustomerID"));
		int rating=Integer.parseInt(request.getParameter("rating"));
		String review=request.getParameter("review");
		boolean result;
		
		Review r=new Review();
		r.setOrder_id(OrderID);
		r.setCustomer_id(customerID);
		r.setRating(rating);
		r.setReview(review);
		
		DataHandlerReviews DHR=new DataHandlerReviews();
		rs=DHR.ChecIfReviewPresent(r);
		try {
			if(rs.next()) {
				request.setAttribute("present","error");
				d1=request.getRequestDispatcher("CustomerReview.jsp");
			}else {
				result=DHR.InserIntoReviews(r);
				
				if(result) {
					request.setAttribute("update", "success");
					d1=request.getRequestDispatcher("CustomerReview.jsp");
				}else {
					request.setAttribute("update", "error");
					d1=request.getRequestDispatcher("CustomerReview.jsp");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		d1.forward(request, response);
		
	}

}
