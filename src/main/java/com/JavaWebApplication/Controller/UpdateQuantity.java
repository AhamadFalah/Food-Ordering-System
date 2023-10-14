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
public class UpdateQuantity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateQuantity() {
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
		boolean update;
		RequestDispatcher rd;
		int CartID=Integer.parseInt(request.getParameter("CartID"));
		int MenuItemID=Integer.parseInt(request.getParameter("MenuItemID"));
		int Quantity=Integer.parseInt(request.getParameter("Quantity"));
		
		Cart cr=new Cart();
		cr.setQuantity(Quantity);
		DataHandlerCart dhc =new DataHandlerCart();
		ResultSet rs=dhc.CheckQuantity(cr);
		System.out.println("hello");
		update = dhc.updateQuantity(cr, CartID, MenuItemID);
		if(update) {
			System.out.println("code is executed");
			request.setAttribute("update", "success");
			request.setAttribute("Quantity",cr.getQuantity());
			rd=request.getRequestDispatcher("UpdateQuantity.jsp");
		}else {
			request.setAttribute("update", "error");
			rd=request.getRequestDispatcher("UpdateQuantity.jsp");
		}
		rd.forward(request, response);
	}

}
