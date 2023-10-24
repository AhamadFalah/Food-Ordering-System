package com.JavaWebApplication.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaWebApplication.Beans.Review;
import com.JavaWebApplication.Model.DataHandlerReviews;

/**
 * Servlet implementation class EditReview
 */
public class EditReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditReview() {
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
		boolean update;
		int orderID=Integer.parseInt(request.getParameter("orderID"));
		int customerID=Integer.parseInt(request.getParameter("CustomerID"));
		int rating=Integer.parseInt(request.getParameter("rating"));
		String review=request.getParameter("review");
		Review r =new Review();
		r.setOrder_id(orderID);
		r.setCustomer_id(customerID);
		r.setRating(rating);
		r.setReview(review);
		DataHandlerReviews DHR=new DataHandlerReviews();
		update=DHR.EditReview(r);
		if(update) {
			request.setAttribute("update","success");
			d1=request.getRequestDispatcher("EditReview.jsp");
		}else {
			request.setAttribute("update", "error");
			d1=request.getRequestDispatcher("EditReview.jsp");
		}
		d1.forward(request, response);
		
	}

}
