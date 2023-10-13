package com.JavaWebApplication.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaWebApplication.Beans.Contact;
import com.JavaWebApplication.Model.ContactDataHandler;

/**
 * Servlet implementation class DeleteUserSideInquiry
 */
public class DeleteUserSideInquiry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserSideInquiry() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		boolean result;
		RequestDispatcher d1=null;
		int id=Integer.parseInt(request.getParameter("id"));
		Contact c=new Contact();
		c.setContactID(id);
		ContactDataHandler CDH=new ContactDataHandler();
		result=CDH.deleteInquriry(c);
		if(result) {
			request.setAttribute("update1", "success");
			d1=request.getRequestDispatcher("userProfilePage.jsp");
		}
		else {
			request.setAttribute("update1", "error");
			d1=request.getRequestDispatcher("userProfilePage.jsp");
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
