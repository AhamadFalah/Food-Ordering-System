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
        
	    
	    /*if(sheet.createRow(0) != null) {
		    //sheet.getRow(0).createCell(0).setCellValue(6.78);	
		    //System.out.println("Row created");
	    }*/
	    //HSSFRow rowhead = sheet.createRow((short) 0);
	    //rowhead.createCell((short) 0).setCellValue("CellHeadName1");
	    //rowhead.createCell((short) 1).setCellValue("CellHeadName2");
	    //rowhead.createCell((short) 2).setCellValue("CellHeadName3");
        //int rowNum = 0;
        // Create header row
        //Row headerRow = sheet.createRow(rowNum++);
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

        //int cellNum = 0;
        int datarowIndex=0;
        int cellcount=0;
    	XSSFRow headrow=sheet.createRow(datarowIndex);
        for (String header : headers) {
        	headrow.createCell(cellcount).setCellValue(header);
        	cellcount++;
        	//datarowIndex++;
            //XSSFCell cell = (XSSFCell) headerRow.createCell(cellNum++);
            //cell.setCellValue(header);
            //System.out.println(header);
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
        	//cellcount1++;
        	datarowIndex1++;
        }
        //System.out.println(cellNum);
        /*ResultSetMetaData rsmd = null;
		try {
			rsmd = rs.getMetaData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        int columnCount = 0;
		try {
			columnCount = rsmd.getColumnCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        
        /*Row headerRow = sheet.createRow(rowNum++);
        for (int i = 1; i <= columnCount; i++) {
            Cell cell = headerRow.createCell(i - 1);
            try {
				cell.setCellValue(rsmd.getColumnName(i));
				System.out.println(rsmd.getColumnName(i));
				System.out.println("code is here");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        System.out.println(columnCount);
        try {
			while (rs.next()) {
			    Row row = sheet.createRow(rowNum++);
			    for (int i = 1; i <= columnCount; i++) {
			        Cell cell = row.createCell(i - 1);
			        int columnType = rsmd.getColumnType(i);
			        System.out.println(rsmd.getColumnTypeName(i));
			        
			        if (columnType == java.sql.Types.NUMERIC || columnType == java.sql.Types.INTEGER) {
			            // Handle numeric data
			        	System.out.println("Number");
			            cell.setCellValue(rs.getDouble(i));
			        } else if (columnType == java.sql.Types.DATE) {
			            // Handle date data
			            java.util.Date date = rs.getDate(i);
			            if (date != null) {
			                cell.setCellValue(date);
			                // Apply date formatting if needed
			                CellStyle dateStyle = workbook.createCellStyle();
			                CreationHelper createHelper = workbook.getCreationHelper();
			                dateStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-MM-dd"));
			                cell.setCellStyle(dateStyle);
			                System.out.println("Date");
			            }
			        } else {
			            // Handle other data types as strings
			            cell.setCellValue(rs.getString(i));
			            System.out.println("String");
			        }
			    }
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
        /*for (ArrayList<Object> dataRow : PaymentList) {
            XSSFRow row = (XSSFRow) sheet.createRow(rowNum++);

            int cellNum = 0;
            for (Object cellData : dataRow) {
                XSSFCell cell = row.createCell(cellNum++);
                
                if (cellData instanceof Number) {
                    // Handle numeric data
                    cell.setCellValue(((Number) cellData).doubleValue());
                } else if (cellData instanceof java.util.Date) {
                    // Handle date data
                    cell.setCellValue((java.util.Date) cellData);
                    XSSFCellStyle dateStyle = workbook.createCellStyle();
                    dateStyle.setDataFormat(workbook.getCreationHelper().createDataFormat().getFormat("yyyy-MM-dd"));
                    cell.setCellStyle(dateStyle);
                } else {
                    // Handle other data types as strings
                    cell.setCellValue(cellData.toString());
                }
            }
        }*/
        
        
        //String saveDirectory = "";
        String filePath = "C:/Users/Asiri Jayawardena/Desktop/AdminReports/data.xlsx";

        // Save the Excel file to the specified path
        FileOutputStream fileOut = new FileOutputStream(filePath);
        workbook.write(fileOut);
        //ServletOutputStream fileOutStream = response.getOutputStream();
        //workbook.write(fileOutStream);
        //workbook.close();
        //RequestDispatcher d1=null;
        //d1=request.getRequestDispatcher("OrderCRUD.jsp");
        //request.setAttribute("FileODownload", "success");
        //d1.forward(request, response);
        // Set the response for download
        //response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        //fileOut.close();
        
        /*try {
            TimeUnit.SECONDS.sleep(10); // 5-second delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        

       
        
        // Get the response output stream and write the workbook data to it
        /*ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();*/
        
        //response.getOutputStream();
       
        // Write the Excel data to the response output stream

        
        // Close the file output stream
        //fileOutStream.close();
        System.out.println("Hello");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=data.xlsx");
        try (FileOutputStream fileOutStream = new FileOutputStream(filePath)) {
            workbook.write(fileOutStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
