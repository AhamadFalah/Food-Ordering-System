package com.JavaWebApplication.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.JavaWebApplication.Beans.user;
import com.JavaWebApplication.Model.DataProvider;
import com.JavaWebApplication.Model.MyDB;



/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session=request.getSession();
		RequestDispatcher d1=null;
		PrintWriter out=response.getWriter();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String email=request.getParameter("user_email");
		String password=request.getParameter("user_password");
		user u1=new user();
		u1.setEmail(email);
		//u1.setPassword(password);
		
		MyDB db=new MyDB();
		Connection con=db.getCon();
		try {
			PreparedStatement stmt=con.prepareStatement("SELECT UserID,user_Name,user_Email,user_PhoneNumber,user_Address,user_ProfileImage,user_Password FROM signupdata WHERE user_Email= ?");
			stmt.setString(1, u1.getEmail());
			//stmt.setString(2, u1.getPassword());
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				session.setAttribute("id", rs.getString("UserID"));
				session.setAttribute("name", rs.getString("user_Name"));
				session.setAttribute("Email_Address", rs.getString("user_Email"));
				session.setAttribute("password", rs.getString("user_Password"));
				session.setAttribute("profileImage", rs.getString("user_ProfileImage"));
				session.setAttribute("phoneNo", rs.getString("user_PhoneNumber"));
				session.setAttribute("address", rs.getString("user_Address"));
				String email2=rs.getString("user_Email");
				String password2=rs.getString("user_Password");
				session.setAttribute("loggedIn",true);
				if(email2.equals("AdminHarry@gmail.com")&&BCrypt.checkpw(password,password2)){
					session.setAttribute("Admin", "Admin");
					d1=request.getRequestDispatcher("AdminUI.jsp");
				}else if (BCrypt.checkpw(password,password2)){
					d1=request.getRequestDispatcher("index.jsp");
				}
				else{
					request.setAttribute("status4","error");
					d1=request.getRequestDispatcher("Login.jsp");
					}
			}else{
				request.setAttribute("status4","error");
				d1=request.getRequestDispatcher("Login.jsp");
				}
			d1.forward(request, response);
			//Statement stmt=con.createStatement();
			//ResultSet rs=stmt.executeQuery("SELECT user_Email,user_Password FROM signupdata WHERE user_Email='"+u1.getEmail()+"' AND user_Password='"+u1.getPassword()+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*DataProvider dp=new DataProvider();
		ResultSet s1=dp.readData(u1);
		try {
			boolean s2=s1.next();
			if(s2) {
				session.setAttribute("name", s1.getString("User_Name"));
				d1=request.getRequestDispatcher("index.jsp");
			}
			else {
				request.setAttribute("status", "error");
				d1=request.getRequestDispatcher("Login.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*if(s1.equals("success")) {
			response.sendRedirect("index.jsp");
		}else {
			out.println("Invalid login credentails");
		}*/
	}

}
