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
 * Servlet implementation class PromoCodeCheckCal
 */
public class PromoCodeCheckCal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PromoCodeCheckCal() {
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
		ResultSet rs=null;
		RequestDispatcher d1=null;
		String promo=request.getParameter("promocode");
		double total=Double.parseDouble(request.getParameter("total"));
		Promo p=new Promo();
		p.setPromoCodeName(promo);
		PromoCodeHandler PCH=new PromoCodeHandler();
		rs=PCH.checkPromoCode(p);
		try {
			if(rs.next()) {
				double value=rs.getDouble("promovalue");
				double discount=total*value;
				double finalvalue=total-discount;
				request.setAttribute("discount", discount);
				System.out.println(discount);
				System.out.println(finalvalue);
				request.setAttribute("finalvalue", finalvalue);
				d1=request.getRequestDispatcher("Payment.jsp");
			}else {
				request.setAttribute("present", "error");
				d1=request.getRequestDispatcher("Payment.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		d1.forward(request, response);
	}

}
