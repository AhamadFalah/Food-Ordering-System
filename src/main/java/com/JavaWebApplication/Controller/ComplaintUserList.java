package com.JavaWebApplication.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaWebApplication.Beans.Complaint;
import com.JavaWebApplication.Model.DataHandlerComplaint;

/**
 * Servlet implementation class ComplaintUserList
 */
public class ComplaintUserList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplaintUserList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd=null;
		int userId=Integer.parseInt(request.getParameter("userID"));
		System.out.println(userId);
		List<Complaint>UserListComplaints=new ArrayList<>();
		DataHandlerComplaint DHC =new DataHandlerComplaint();
		UserListComplaints= DHC.ListUserComplaintDetails(userId);
		request.setAttribute("UserListComplaint", UserListComplaints);
		rd=request.getRequestDispatcher("userProfilePage.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
