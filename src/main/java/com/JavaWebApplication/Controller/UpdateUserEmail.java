package com.JavaWebApplication.Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.JavaWebApplication.Beans.user;
import com.JavaWebApplication.Model.DataProvider;

/**
 * Servlet implementation class UpdateUserEmail
 */
public class UpdateUserEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserEmail() {
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
		RequestDispatcher d2 = null;
		HttpSession session=request.getSession();
		String email=request.getParameter("user_Email");
		boolean update;
		int userID=Integer.parseInt(request.getParameter("userID1"));
		user u1=new user();
		u1.setEmail(email);
		DataProvider d1=new DataProvider();
		ResultSet rs=d1.CheckEmail(u1);
		System.out.println("hello");
		try {
			if(rs.next()) {
				request.setAttribute("present", "error");
				d2=request.getRequestDispatcher("userProfilePage.jsp");
			}else {
				update=d1.updateUserEmail(u1,userID);
				if(update) {
					request.setAttribute("present", "success");
					session.setAttribute("Email_Address",u1.getEmail());
					d2=request.getRequestDispatcher("userProfilePage.jsp");
				}else {
					request.setAttribute("present", "error");
					d2=request.getRequestDispatcher("userProfilePage.jsp");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		d2.forward(request, response);
	}

}
