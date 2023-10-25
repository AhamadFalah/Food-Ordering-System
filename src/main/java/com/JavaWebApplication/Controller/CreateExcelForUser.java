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

import com.JavaWebApplication.Beans.user;
import com.JavaWebApplication.Model.DataProvider;

/**
 * Servlet implementation class CreateExcelForUser
 */
public class CreateExcelForUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateExcelForUser() {
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
		DataProvider DP=new DataProvider();
		List<user>UserList=new ArrayList<>();
		
		UserList=DP.ListAllUsers();
		
		
	    XSSFWorkbook workbook = new XSSFWorkbook();
	    XSSFSheet sheet = workbook.createSheet("InquiryList");
       
        String[] headers = {
        	    "User_ID",
        	    "User_Name",
        	    "Email",
        	    "Contact_No",
        	    "Address"
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
        for (user u:UserList) {
        	XSSFRow datarow=sheet.createRow(datarowIndex1);
        	datarow.createCell(0).setCellValue(u.getUserID());
        	datarow.createCell(1).setCellValue(u.getName());
        	datarow.createCell(2).setCellValue(u.getEmail());
        	datarow.createCell(3).setCellValue(u.getPhoneNo());
        	datarow.createCell(4).setCellValue(u.getAddress());
        	datarowIndex1++;
        }
        String filePath = "C:/Users/ahmed/OneDrive/Desktop/AdminReports/UserData.xlsx";
        FileOutputStream fileOut = new FileOutputStream(filePath);
        workbook.write(fileOut);
        workbook.close();
        RequestDispatcher d1=null;
        d1=request.getRequestDispatcher("ManageUserCRUD.jsp");
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
