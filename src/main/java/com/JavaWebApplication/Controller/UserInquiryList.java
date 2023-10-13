package com.JavaWebApplication.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaWebApplication.Beans.Contact;
import com.JavaWebApplication.Beans.user;
import com.JavaWebApplication.Model.ContactDataHandler;

/**
 * Servlet implementation class ListAllInquiries
 */
public class UserInquiryList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInquiryList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int id= Integer.parseInt(request.getParameter("userID"));
		user u1=new user();
		u1.setUserID(id);
		RequestDispatcher d1=null;
		ContactDataHandler CDH=new ContactDataHandler();
		List<Contact>ListInquiry=CDH.SelectListForUser(id);
		request.setAttribute("ListInquiry", ListInquiry);
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
