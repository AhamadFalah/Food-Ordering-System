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
 * Servlet implementation class AddNewPromoCode
 */
public class AddNewPromoCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewPromoCode() {
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
		ResultSet rs=null;
		boolean result=false;
		String promoName=request.getParameter("name");
		String promoDesc=request.getParameter("desc");
		double value=Double.parseDouble(request.getParameter("value"));
		PromoCodeHandler PCH=new PromoCodeHandler();
		Promo p=new Promo();
		p.setPromoCodeName(promoName);
		p.setPromoDesc(promoDesc);
		p.setValue(value);
		rs=PCH.checkPromoCode(p);
		try {
			if(rs.next()) {
				request.setAttribute("present", "success");
				d1=request.getRequestDispatcher("AddNewPromoCode.jsp");
			}else {
				result=PCH.InsertNewPromocode(p);
				if(result) {
					request.setAttribute("status1","success");
					d1=request.getRequestDispatcher("AddNewPromoCode.jsp");
				}
				else {
					request.setAttribute("status1","error");
					d1=request.getRequestDispatcher("AddNewPromoCode.jsp");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		d1.forward(request, response);
	}

}
