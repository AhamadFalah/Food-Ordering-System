package com.JavaWebApplication.Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaWebApplication.Beans.Promo;
import com.JavaWebApplication.Model.PromoCodeHandler;

/**
 * Servlet implementation class EditPromoCode
 */
public class EditPromoCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPromoCode() {
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
		boolean result=false;
		RequestDispatcher d1=null;
		ResultSet rs=null;
		int promoID=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String desc=request.getParameter("desc");
		double value=Double.parseDouble(request.getParameter("value"));
		
		Promo p=new Promo();
		p.setPromoID(promoID);
		p.setPromoCodeName(name);
		p.setPromoDesc(desc);
		p.setValue(value);
		
		PromoCodeHandler PCH=new PromoCodeHandler();
		rs=PCH.checkPromoCode(p);
		try {
			if(rs.next()) {
				request.setAttribute("present", "success");
				d1=request.getRequestDispatcher("EditPromoCode.jsp");
			}else {
				result=PCH.promocodeUpdate(p);
				if(result) {
					request.setAttribute("status1", "success");
					d1=request.getRequestDispatcher("EditPromoCode.jsp");
				}else {
					request.setAttribute("status1", "error");
					d1=request.getRequestDispatcher("EditPromoCode.jsp");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		d1.forward(request, response);
	}

}
