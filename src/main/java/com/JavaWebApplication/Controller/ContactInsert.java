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
 * Servlet implementation class contactsev
 */
public class ContactInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis=null;
		int UserID = 200;
		
		String UserIDPara=request.getParameter("userID");
		
		if(UserIDPara != null && !UserIDPara.isEmpty()) {
			try {
				UserID=Integer.parseInt(UserIDPara);
			}catch(NumberFormatException e) {
				e.printStackTrace();
			}
		}
		/*if(request.getParameter("userID") == null) {
			UserID=200;
		}
		if(request.getParameter("userID")!=null){
			UserID=Integer.parseInt(request.getParameter("userID"));	
		}*/
		String name = request.getParameter("uname");
		String email = request.getParameter("uemail");
		String inquery = request.getParameter("question");
		Contact c=new Contact();	
		c.setName(name);
		c.setEmail(email);
		c.setInquery(inquery);
		c.setUserID(UserID);
		System.out.println(UserID);
		boolean isTrue;
		isTrue = ContactDataHandler.insertcontact(c);
		
		if (isTrue == true) {
				dis = request.getRequestDispatcher("contact.jsp");
				request.setAttribute("update", "success");
		}
		else {
				dis =  request.getRequestDispatcher("contact.jsp");
				request.setAttribute("update", "fail");
		}
		dis.forward(request, response);
	}

}
