package com.JavaWebApplication.Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.JavaWebApplication.Beans.Cart;
import com.JavaWebApplication.Model.DataHandlerCart;


/**
 * Servlet implementation class UpdateQuantity
 */
public class DeleteCartItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCartItem() {
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
		doGet(request, response);
		boolean delete;
		RequestDispatcher rd;
		int CartID=Integer.parseInt(request.getParameter("CartID"));
		int MenuItemID=Integer.parseInt(request.getParameter("MenuItemID"));
		Cart cr=new Cart();
		DataHandlerCart dhc =new DataHandlerCart();
		delete = dhc.deleteQuantity(cr, CartID, MenuItemID);
		if(delete) {
			System.out.println("code is executed");
			request.setAttribute("delete", "success");
			rd=request.getRequestDispatcher("DeleteCartItem.jsp");
		}else {
			request.setAttribute("delete", "error");
			rd=request.getRequestDispatcher("DeleteCartItem.jsp");
		}
		rd.forward(request, response);
	}

}
