package com.JavaWebApplication.Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.JavaWebApplication.Beans.user;
import com.JavaWebApplication.Model.DataProvider;

/**
 * Servlet implementation class ResetPassword1
 */
public class ResetPassword1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPassword1() {
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
		boolean update;
		int UserId=Integer.parseInt(request.getParameter("userID"));
		String newpassword=request.getParameter("user_password1");
		String hashPassword=BCrypt.hashpw(newpassword, BCrypt.gensalt());
		user u1=new user();
		u1.setPassword(hashPassword);
		DataProvider dp=new DataProvider();
		update=dp.UpdatePassword(u1, UserId);
		System.out.println("code is here3");
		if(update==true) {
			request.setAttribute("update","success");
			d1=request.getRequestDispatcher("ResetPasswordPage2.jsp");
		}else {
			request.setAttribute("update","error");
			d1=request.getRequestDispatcher("ResetPasswordPage2.jsp");
		}
		d1.forward(request, response);
		
		
	}

}
