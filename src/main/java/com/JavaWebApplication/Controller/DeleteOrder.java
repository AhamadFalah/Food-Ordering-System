package com.JavaWebApplication.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaWebApplication.Model.DataHandlerOrders;

/**
 * Servlet implementation class DeleteOrder
 */
public class DeleteOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteOrder() {
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
		int orderID=Integer.parseInt(request.getParameter("OrderID"));
		DataHandlerOrders DHO=new DataHandlerOrders();
		result=DHO.DeleteOrder(orderID);
		if(result) {
			request.setAttribute("update", "success");
			d1=request.getRequestDispatcher("OrderCRUD.jsp");
		}else {
			request.setAttribute("update", "error");
			d1=request.getRequestDispatcher("OrderCRUD.jsp");
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
