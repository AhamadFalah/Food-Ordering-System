package com.JavaWebApplication.Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaWebApplication.Beans.Complaint;
import com.JavaWebApplication.Model.DataHandlerComplaint;

/**
 * Servlet implementation class ComplaintsCreate
 */
public class ComplaintsCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplaintsCreate() {
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
		System.out.println("Hello");
		doGet(request, response);
		ResultSet rs=null;
		RequestDispatcher rd=null;
		boolean result=false;
		String UserId=request.getParameter("userId");
		int UserID=Integer.parseInt(UserId);
		int OrderID=Integer.parseInt(request.getParameter("orderId"));
		String Reason=request.getParameter("reason");
		String OtherReason=request.getParameter("otherReason");
		String message=request.getParameter("complaintMessage");
		
		Complaint comp = new Complaint();
		comp.setUserId(UserID);
		comp.setOrderId(OrderID);
		comp.setReason(Reason);
		comp.setOtherReason(OtherReason);
//		ComplaintChat compC = new ComplaintChat();
//		compC.s
		DataHandlerComplaint DHC=new DataHandlerComplaint();
		rs=DHC.CheckComplaint(comp);
		try {
			if(rs.next()) {
				request.setAttribute("complaintPresent","error");
				rd=request.getRequestDispatcher("ComplaintCreate.jsp");
			}else {
				result=DHC.InsertComplaintDetails(comp, UserID);
				
				if(result) {
					request.setAttribute("insertStatus", "success");
					rd=request.getRequestDispatcher("ComplaintCreate.jsp");
				}else {
					request.setAttribute("insertStatus", "error");
					rd=request.getRequestDispatcher("ComplaintCreate.jsp");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rd.forward(request, response);
		
	}

}
