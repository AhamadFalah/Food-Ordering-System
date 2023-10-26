package com.JavaWebApplication.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaWebApplication.Model.DataHandlerReviews;

/**
 * Servlet implementation class DeleteReview
 */
public class DeleteReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteReview() {
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
		boolean result;
		int reviewID=Integer.parseInt(request.getParameter("ReviewID"));
		DataHandlerReviews DHR=new DataHandlerReviews();
		result=DHR.DeleteCustomerReview(reviewID);
		if(result) {
			request.setAttribute("status1", "success");
			d1=request.getRequestDispatcher("ReviewCRUD.jsp");
		}else {
			request.setAttribute("status1", "error");
			d1=request.getRequestDispatcher("ReviewCRUD.jsp");
		}
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
