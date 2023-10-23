package com.JavaWebApplication.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaWebApplication.Beans.Review;
import com.JavaWebApplication.Model.DataHandlerReviews;

/**
 * Servlet implementation class ListAllCustomerReviews
 */
public class ListAllCustomerReviews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAllCustomerReviews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher d1=null;
		List<Review>ReviewList=new ArrayList<>();
		int CustomerID=Integer.parseInt(request.getParameter("userID"));
		DataHandlerReviews DHR=new DataHandlerReviews();
		ReviewList=DHR.GetAllTheReviews(CustomerID);
		request.setAttribute("ReviewList", ReviewList);
		d1=request.getRequestDispatcher("userProfilePage.jsp");
		d1.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
