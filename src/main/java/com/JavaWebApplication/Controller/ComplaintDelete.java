package com.JavaWebApplication.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaWebApplication.Model.DataHandlerComplaint;
import com.JavaWebApplication.Model.DataHandlerReviews;

/**
 * Servlet implementation class ComplaintDelete
 */
public class ComplaintDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplaintDelete() {
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
		boolean result;
		int complaintID=Integer.parseInt(request.getParameter("complaintID"));
		DataHandlerComplaint DHC = new DataHandlerComplaint();
		result=DHC.DeleteUserComplaint(complaintID);
		if(result) {
			request.setAttribute("deleteStatus", "success");
			rd=request.getRequestDispatcher("ComplaintDelete.jsp");
		}else {
			request.setAttribute("deleteStatus", "error");
			rd=request.getRequestDispatcher("ComplaintDelete.jsp");
		}
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
