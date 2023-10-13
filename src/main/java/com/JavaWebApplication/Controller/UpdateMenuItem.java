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
 * Servlet implementation class UpdateMenuItem
 */
public class UpdateMenuItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMenuItem() {
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
		boolean updated;
		RequestDispatcher d1;
		int id=Integer.parseInt(request.getParameter("MenuItemId"));
		String MenuItemName=request.getParameter("menuItemName");
		double MenuItemPrice=Double.parseDouble(request.getParameter("price"));
		String MenuItemCategory=request.getParameter("category");
		MenuItem mi=new MenuItem();
		mi.setMenuItemID(id);
		mi.setMenuItemName(MenuItemName);
		mi.setMenuItemPrice(MenuItemPrice);
		mi.setMenuItemCategory(MenuItemCategory);
		DataHandlerMenuItem DHMI=new DataHandlerMenuItem();
		ResultSet present=DHMI.CheckMenuItem(mi);
		System.out.println("Code is here");
		updated=DHMI.updateMenuItem(mi);
		if(updated) {
			System.out.println("code is here4");
			request.setAttribute("update", "success");
			request.setAttribute("MenuItemCategory", mi.getMenuItemCategory());
			request.setAttribute("MenuItemName", mi.getMenuItemName());
			request.setAttribute("MenuItemPrice",mi.getMenuItemPrice());
			d1=request.getRequestDispatcher("UpdateMenuItem.jsp");
		}else {
			request.setAttribute("update", "error");
			d1=request.getRequestDispatcher("UpdateMenuItem.jsp");
		}
		d1.forward(request, response);

	}

}
