package com.JavaWebApplication.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaWebApplication.Beans.MenuItem;
import com.JavaWebApplication.Model.DataHandlerMenuItem;

/**
 * Servlet implementation class MenuItemManagement
 */

public class MenuItemManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuItemManagement() {
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
		String action=request.getServletPath();
		System.out.println(action);
		switch(action) {
		case "/new":
			ShowNewForm(request,response);
			break;
		case "/MenuItemManagement/insert":
			InsertData(request,response);
			break;
		case "/delete":
			DeleteMenuItem(request,response);
			break;
		case "/edit":
			showEditForm(request,response);
			break;
		case "/update":
			UpdateMenuItem(request,response);
			break;
		default:
			listMenuItem(request,response);
			break;
		}
		
	}
	private void ShowNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher d1=request.getRequestDispatcher("NewMenuItem.jsp");
		System.out.println("code is here");
		d1.forward(request, response);
	}
	private void InsertData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher d1=null;
		String ItemName=request.getParameter("menuItemName");
		double ItemPrice=Double.parseDouble(request.getParameter("price"));
		String ItemCategory=request.getParameter("category");
		MenuItem item=new MenuItem();
		item.setMenuItemName(ItemName);
		item.setMenuItemPrice(ItemPrice);
		item.setMenuItemCategory(ItemCategory);
		DataHandlerMenuItem DHMI=new DataHandlerMenuItem();
		int rowcount=DHMI.insertMenuItemDetails(item);
		System.out.println("Data successfully entered in to the database");
		d1=request.getRequestDispatcher("ManageMenuItemCRUD.jsp");
		if(rowcount>0) {
			request.setAttribute("status1", "success");
		}else {
			request.setAttribute("status1", "error");
		}
		d1.forward(request, response);
	}
	
	private void DeleteMenuItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id=Integer.parseInt(request.getParameter("MenuItem_ID"));
		DataHandlerMenuItem DHMI=new DataHandlerMenuItem();
		DHMI.deletemenuitem(id);
		response.sendRedirect("list");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id=Integer.parseInt(request.getParameter("MenuItem_ID"));
		MenuItem existingMenuItem;
		DataHandlerMenuItem DHMI=new DataHandlerMenuItem();
		RequestDispatcher d1=request.getRequestDispatcher("NewMenuItem.jsp");
		existingMenuItem=DHMI.selectMenuItem(id);
		request.setAttribute("menu",existingMenuItem);
		d1.forward(request, response);
	}
	
	private void UpdateMenuItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id=Integer.parseInt(request.getParameter("MenuItem_ID"));
		String ItemName=request.getParameter("menuItemName");
		double ItemPrice=Double.parseDouble(request.getParameter("price"));
		String ItemCategory=request.getParameter("category");
		MenuItem item=new MenuItem();
		item.setMenuItemName(ItemName);
		item.setMenuItemPrice(ItemPrice);
		item.setMenuItemCategory(ItemCategory);
		DataHandlerMenuItem DHMI=new DataHandlerMenuItem();
		DHMI.updateMenuItem(item);
		response.sendRedirect("list");		
	}
	
	public void listMenuItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		DataHandlerMenuItem DHMI=new DataHandlerMenuItem();
		List<MenuItem>Items=DHMI.SelectAllTheMenuItems();
		request.setAttribute("listMenuItems", Items);
		RequestDispatcher d1=request.getRequestDispatcher("MenuItemList.jsp");
		d1.forward(request, response);
	}

}
