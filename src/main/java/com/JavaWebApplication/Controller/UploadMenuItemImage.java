package com.JavaWebApplication.Controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.JavaWebApplication.Beans.MenuItem;
import com.JavaWebApplication.Model.DataHandlerMenuItem;

/**
 * Servlet implementation class UploadMenuItemImage
 */
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024, // 1 MB
	    maxFileSize = 1024 * 1024 * 10, // 10 MB
	    maxRequestSize = 1024 * 1024 * 50 // 50 MB
	)
public class UploadMenuItemImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadMenuItemImage() {
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
		boolean update;
		int id=Integer.parseInt(request.getParameter("MenuItemId"));
		Part file=request.getPart("picture");
		
		String filename=file.getSubmittedFileName();
		System.out.println(filename);
		
		String uploadPath="C:/Users/Asiri Jayawardena/Desktop/JAVA WEB PROJECT/JAVAWebApplication/src/main/webapp/MenuItemImages/"+filename;
		
		try {
			FileOutputStream fos=new FileOutputStream(uploadPath);
			InputStream is=file.getInputStream();
			
			byte[] data=new byte [is.available()];
			is.read(data);
			fos.write(data);
			fos.close();
			
		}catch(IOException e) {
			System.out.println(e);
		}
		
		String uploadpath1="MenuItemImages/"+filename;
		
		MenuItem item=new MenuItem();
		item.setMenuItemImageUrl(uploadpath1);
		
		DataHandlerMenuItem DHMI=new DataHandlerMenuItem();
		
		update=DHMI.AddMenuItemImage(item, id);
		
		if(update) {
			request.setAttribute("update", "success");
			d1=request.getRequestDispatcher("uploadMenuItemImage.jsp");
		}
		else {
			request.setAttribute("update", "error");
			d1=request.getRequestDispatcher("uploadMenuItemImage.jsp");
		}
		d1.forward(request, response);
		
		
	}

}
