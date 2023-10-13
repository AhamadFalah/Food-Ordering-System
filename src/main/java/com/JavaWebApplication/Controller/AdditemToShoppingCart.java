package com.JavaWebApplication.Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaWebApplication.Beans.Cart;
import com.JavaWebApplication.Model.DataHandlerCart;
import com.JavaWebApplication.Model.DataHandlerMenuItem;

/**
 * Servlet implementation class AdditemToShoppingCart
 */
public class AdditemToShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdditemToShoppingCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ResultSet rs=null;
		RequestDispatcher d1=null;
		boolean result=false;
		String userID=request.getParameter("UserID");
		int userID1=Integer.parseInt(userID);
		int id=Integer.parseInt(request.getParameter("id"));
		String catagory=request.getParameter("MenuItemCategory");
		String name=request.getParameter("MenuItemName");
		String price=request.getParameter("MenuItemPrice");
		double price1=Double.parseDouble(price);
		Cart c1=new Cart();
		c1.setMenuItemID(id);
		c1.setMenuItemName(name);
		c1.setMenuItemCategory(catagory);
		c1.setMenuItemPrice(price1);
		c1.setQuantity(1);
		DataHandlerCart DHC=new DataHandlerCart();
		rs=DHC.CheckMenuItem(c1);
		try {
			if(rs.next()) {
				request.setAttribute("present", "success");
				d1=request.getRequestDispatcher("AppetisersInHomePage.jsp");
			}
			else {
				result=DHC.InsertCartDetails(c1, userID1);
				if(result) {
					request.setAttribute("update", "success");
					d1=request.getRequestDispatcher("AppetisersInHomePage.jsp");
				}
				else {
					request.setAttribute("update", "error");
					d1=request.getRequestDispatcher("AppetisersInHomePage.jsp");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
