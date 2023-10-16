package com.JavaWebApplication.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaWebApplication.Beans.MenuItem;
import com.JavaWebApplication.Beans.user;
import com.JavaWebApplication.Model.DataHandlerMenuItem;
import com.JavaWebApplication.Model.DataProvider;

/**
 * Servlet implementation class DeleteUsers
 */
public class DeleteUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUsers() {
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
		boolean deleted;
		RequestDispatcher d1;
		int userId=Integer.parseInt(request.getParameter("userId"));
		user mi=new user();
		mi.setUserID(userId);
		DataProvider DHMI=new DataProvider();
		deleted=DHMI.deleteuser(userId);
		if(deleted) {
			request.setAttribute("delete", "success");
			d1=request.getRequestDispatcher("DeleteUser.jsp");
		}
		else {
			request.setAttribute("delete", "error");
			d1=request.getRequestDispatcher("DeleteUser.jsp");
		}
		d1.forward(request, response);
		
	}

}
