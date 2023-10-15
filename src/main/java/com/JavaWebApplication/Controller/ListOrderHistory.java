package com.JavaWebApplication.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaWebApplication.Beans.Payment;
import com.JavaWebApplication.Model.DataHandlerOrders;

/**
 * Servlet implementation class ListOrderHistory
 */
public class ListOrderHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListOrderHistory() {
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
		int customerID=Integer.parseInt(request.getParameter("userID"));
		List<Payment>ListOrder=new ArrayList<>();
		DataHandlerOrders DHO=new DataHandlerOrders();
		ListOrder=DHO.ListAllCustomerOrders(customerID);
		request.setAttribute("ListOrder", ListOrder);
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
