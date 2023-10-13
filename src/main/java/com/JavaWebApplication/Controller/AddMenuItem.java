package com.JavaWebApplication.Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaWebApplication.Beans.MenuItem;
import com.JavaWebApplication.Model.DataHandlerMenuItem;

/**
 * Servlet implementation class AddMenuItem
 */
public class AddMenuItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMenuItem() {
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
		RequestDispatcher d1=null;
		String ItemName=request.getParameter("menuItemName");
		double ItemPrice=Double.parseDouble(request.getParameter("price"));
		String ItemCategory=request.getParameter("category");
		MenuItem item=new MenuItem();
		item.setMenuItemName(ItemName);
		item.setMenuItemPrice(ItemPrice);
		item.setMenuItemCategory(ItemCategory);
		DataHandlerMenuItem DHMI=new DataHandlerMenuItem();
		ResultSet present=DHMI.CheckMenuItem(item);
		try {
			if(present.next()) {
				request.setAttribute("present", "error");
				d1=request.getRequestDispatcher("NewMenuItem.jsp");
			}
			else {
				int rowcount=DHMI.insertMenuItemDetails(item);
				d1=request.getRequestDispatcher("NewMenuItem.jsp");
				if(rowcount>0) {
					request.setAttribute("status1", "success");
				}else {
					request.setAttribute("status1", "error");
				}
			}
			d1.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
