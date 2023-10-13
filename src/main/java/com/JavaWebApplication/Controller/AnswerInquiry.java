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
 * Servlet implementation class AnswerInquiry
 */
public class AnswerInquiry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnswerInquiry() {
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
		RequestDispatcher d1=null;
		Contact c=new Contact();
		ContactDataHandler CDH=new ContactDataHandler();
		boolean update;
		int id=Integer.parseInt(request.getParameter("contactID"));
		String answer=request.getParameter("answer");
		c.setUserID(id);
		c.setAnswer(answer);
		update=CDH.updateAnswer(c);
		if(update) {
			request.setAttribute("update", "success");
			d1=request.getRequestDispatcher("AnswerInquiry.jsp");
		}else {
			request.setAttribute("update", "error");
			d1=request.getRequestDispatcher("AnswerInquiry.jsp");
		}
		d1.forward(request, response);
	}

}
