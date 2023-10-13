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
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		String name=request.getParameter("user_name");
		String email=request.getParameter("user_email");
		String password=request.getParameter("user_password");
		String hashPassword=BCrypt.hashpw(password, BCrypt.gensalt());
		user u1=new user();
		u1.setName(name);
		u1.setEmail(email);
		u1.setPassword(hashPassword);
		d1=request.getRequestDispatcher("Signup.jsp");
		DataProvider dp=new DataProvider();
		ResultSet present=dp.CheckEmail(u1);
		try {
			if(present.next()) {
				request.setAttribute("status2","error");
				System.out.println("Email is present");
			}
			else{
				int row=dp.writeData(u1);
				if(row>0) {
					request.setAttribute("status","success");
					//response.sendRedirect("Signup.jsp");
				}else {
					request.setAttribute("status", "error");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		d1.forward(request, response);
		//d1=request.getRequestDispatcher("Login.jsp");;
	}

}
