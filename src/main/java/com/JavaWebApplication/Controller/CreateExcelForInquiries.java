package com.JavaWebApplication.Controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.JavaWebApplication.Beans.Contact;
import com.JavaWebApplication.Beans.Payment;
import com.JavaWebApplication.Model.ContactDataHandler;
import com.JavaWebApplication.Model.DataHandlerOrders;

/**
 * Servlet implementation class CreateExcelForInquiries
 */
public class CreateExcelForInquiries extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateExcelForInquiries() {
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
		ContactDataHandler CDH=new ContactDataHandler();
		List<Contact>ContactList=new ArrayList<>();
		ContactList=CDH.SelectAllInquiriesData();
		
		
	    XSSFWorkbook workbook = new XSSFWorkbook();
	    XSSFSheet sheet = workbook.createSheet("InquiryList");
       
        String[] headers = {
        	    "Contact_ID",
        	    "User_ID",
        	    "Customer_name",
        	    "Email",
        	    "Question",
        	    "Answer",
        	    "Contact_Date"
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
        for (Contact c:ContactList) {
        	XSSFRow datarow=sheet.createRow(datarowIndex1);
        	datarow.createCell(0).setCellValue(c.getContactID());
        	datarow.createCell(1).setCellValue(c.getUserID());
        	datarow.createCell(2).setCellValue(c.getName());
        	datarow.createCell(3).setCellValue(c.getEmail());
        	datarow.createCell(4).setCellValue(c.getInquery());
        	datarow.createCell(5).setCellValue(c.getAnswer());
        	datarow.createCell(6).setCellValue(c.getDate());
        	datarowIndex1++;
        }
        String filePath = "C:/Users/Asiri Jayawardena/Desktop/AdminReports/InquiryData.xlsx";
        FileOutputStream fileOut = new FileOutputStream(filePath);
        workbook.write(fileOut);
        workbook.close();
        RequestDispatcher d1=null;
        d1=request.getRequestDispatcher("ManageInquiryCRUD.jsp");
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
