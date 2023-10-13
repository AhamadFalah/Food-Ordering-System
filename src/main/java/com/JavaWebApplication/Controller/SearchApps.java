package com.JavaWebApplication.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaWebApplication.Beans.MenuItem;
import com.JavaWebApplication.Model.DataHandlerMenuItem;

/**
 * Servlet implementation class SearchDessertItem
 */
public class SearchApps extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchApps() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		List<MenuItem>listMenuItems=new ArrayList<>();
		RequestDispatcher d1=null;
		String search=request.getParameter("search");
		DataHandlerMenuItem DHMI=new DataHandlerMenuItem();
		listMenuItems=DHMI.SearchAppestiserCoursesItems(search);
		if(listMenuItems.isEmpty()) {
			request.setAttribute("search", "error");
			d1=request.getRequestDispatcher("AppetisersInHomePage.jsp");
		}else {
			request.setAttribute("search", "success");
			request.setAttribute("listMenuItems",listMenuItems );
			d1=request.getRequestDispatcher("AppetisersInHomePage.jsp");
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
