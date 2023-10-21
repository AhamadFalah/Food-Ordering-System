package com.JavaWebApplication.Controller;


import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.JavaWebApplication.Beans.Payment;
import com.JavaWebApplication.Model.DataHandlerOrders;

/**
 * Servlet implementation class CreateExcelWorkSheet
 */
public class CreateExcelWorkSheet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateExcelWorkSheet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ResultSet rs;
		DataHandlerOrders DHO=new DataHandlerOrders();
		List<Payment>PaymentList=new ArrayList<>();
		PaymentList=DHO.ListAllOrdersDetails();
		rs=DHO.ALLOrders();
		
		
	    XSSFWorkbook workbook = new XSSFWorkbook();
	    XSSFSheet sheet = workbook.createSheet("OrderList");
       
        String[] headers = {
        	    "Order_ID",
        	    "Customer_ID",
        	    "Customer_name",
        	    "Email",
        	    "Address",
        	    "Payment_Type",
        	    "Total_Price",
        	    "Transaction_Date"
        	};
        int datarowIndex=0;
        int cellcount=0;
    	XSSFRow headrow=sheet.createRow(datarowIndex);
        for (String header : headers) {
        	headrow.createCell(cellcount).setCellValue(header);
        	cellcount++;
        }
        int cellcount1=0;
        int datarowIndex1=1;
        for (Payment p:PaymentList) {
        	XSSFRow datarow=sheet.createRow(datarowIndex1);
        	datarow.createCell(0).setCellValue(p.getOrderID());
        	datarow.createCell(1).setCellValue(p.getUserID());
        	datarow.createCell(2).setCellValue(p.getCustomerName());
        	datarow.createCell(3).setCellValue(p.getEmail());
        	datarow.createCell(4).setCellValue(p.getAddress());
        	datarow.createCell(5).setCellValue(p.getPaymment_type());
        	datarow.createCell(6).setCellValue(p.getTotal_Price());
        	datarow.createCell(7).setCellValue(p.getTransaction_Date());
        	datarowIndex1++;
        }
        String filePath = "C:/Users/Asiri Jayawardena/Desktop/AdminReports/data.xlsx";
        FileOutputStream fileOut = new FileOutputStream(filePath);
        workbook.write(fileOut);
        workbook.close();
        RequestDispatcher d1=null;
        d1=request.getRequestDispatcher("OrderCRUD.jsp");
        request.setAttribute("FileODownload", "success");
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
