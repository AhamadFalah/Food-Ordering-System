package com.JavaWebApplication.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaWebApplication.Beans.Payment;
import com.JavaWebApplication.Model.DataHandlerCart;
import com.JavaWebApplication.Model.DataHandlerOrders;

/**
 * Servlet implementation class AddPayment
 */
public class AddPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPayment() {
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
		boolean result;
		System.out.println("Code is here");
		System.out.println(request.getParameter("UserID"));
		int UserId=Integer.parseInt(request.getParameter("UserID"));
		double price=Double.parseDouble(request.getParameter("Total"));
		String ItemList=request.getParameter("ItemList");
		String firstName=request.getParameter("firstname");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String paymentMethod=request.getParameter("paymentMethod");
		String cardName = null;
		long cardNo = 0;
		String expiaryMonth = null;
		String year = null;
		int cvv = 0;
		if(paymentMethod.equals("creditCard")) {
			cardName=request.getParameter("cardname");
			cardNo=Long.parseLong(request.getParameter("cardnumber"));
			expiaryMonth=request.getParameter("expmonth");
			year=request.getParameter("expyear");
			cvv=Integer.parseInt(request.getParameter("cvv"));
		}
		else if(paymentMethod.equals("CashOnDelivery")) {
			cardName="Default";
			cardNo=1;
			expiaryMonth="Default";
			year="Default";
			cvv=1;
		}
		Payment p=new Payment();
		p.setUserID(UserId);
		p.setTotal_Price(price);
		p.setOrder_Details(ItemList);
		p.setCustomerName(firstName);
		p.setEmail(email);
		p.setAddress(address);
		p.setPaymment_type(paymentMethod);
		p.setCard_Name(cardName);
		p.setCard_No(cardNo);
		p.setExpiary_Month(expiaryMonth);
		p.setExpiary_Year(year);
		p.setCVV(cvv);
		DataHandlerCart DHC= new DataHandlerCart();
		DHC.clearCart(UserId);
		DataHandlerOrders DHO=new DataHandlerOrders();
		result=DHO.InsertIntoOrder(p);
		if(result) {
			d1=request.getRequestDispatcher("PaymentSuccessfull.jsp");
		}else {
			System.out.println("Failed");
		}
		d1.forward(request, response);
	}

}
