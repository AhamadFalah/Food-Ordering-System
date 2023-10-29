package com.JavaWebApplication.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaWebApplication.Beans.Promo;
import com.JavaWebApplication.Model.PromoCodeHandler;

/**
 * Servlet implementation class DeletePromoCode
 */
public class DeletePromoCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePromoCode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher d1=null;
		boolean result;
		int promoID=Integer.parseInt(request.getParameter("id"));
		Promo p=new Promo();
		p.setPromoID(promoID);
		PromoCodeHandler PCH=new PromoCodeHandler();
		result=PCH.DeletePromoCode(p);
		if(result) {
			d1=request.getRequestDispatcher("PromoCRUD.jsp");
			request.setAttribute("delete", "success");
		}else {
			d1=request.getRequestDispatcher("PromoCRUD.jsp");
			request.setAttribute("delete", "error");
		}
		d1.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
