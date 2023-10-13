package com.JavaWebApplication.Controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.JavaWebApplication.Beans.user;
import com.JavaWebApplication.Model.DataProvider;
import com.mysql.cj.Session;

/**
 * Servlet implementation class UpdateUserProfile
 */
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024, // 1 MB
	    maxFileSize = 1024 * 1024 * 10, // 10 MB
	    maxRequestSize = 1024 * 1024 * 50 // 50 MB
	)
public class UpdateUserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserProfile() {
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
		HttpSession session =request.getSession();
		ResultSet rs;
		RequestDispatcher d2=null;
		boolean update;
		Part file=request.getPart("profileImage");
		String imagefilename=file.getSubmittedFileName();
		//System.out.println(imagefilename);
		//String fileExtension = imagefilename.substring(imagefilename.lastIndexOf("."));
		//String uniqueFileName = System.currentTimeMillis() + "_" + generateRandomString(8) + fileExtension;
		
		String uploadPath="C:/Users/Asiri Jayawardena/Desktop/JAVA WEB PROJECT/JAVAWebApplication/src/main/webapp/profileimages/"+imagefilename;
		String uploadPath1="profileimages/"+imagefilename;
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
		
		String name=request.getParameter("userName");
		String phoneNo=request.getParameter("phoneNo");
		String address=request.getParameter("userAddress");
		String profileImagepath=uploadPath;
		//System.out.println(name);
		int UserId=Integer.parseInt(request.getParameter("userID"));
		user u1=new user();
		u1.setName(name);
		u1.setPhoneNo(phoneNo);
		u1.setAddress(address);
		u1.setProfileImage(uploadPath1);
		DataProvider d1=new DataProvider();
		rs=d1.CheckEmail(u1);
		update=d1.updateUserProfile(u1, UserId);
		if(update) {
			request.setAttribute("update", "success");
			session.setAttribute("name", u1.getName());
			session.setAttribute("Email_Address", u1.getEmail());
			session.setAttribute("phoneNo", u1.getPhoneNo());
			session.setAttribute("address", u1.getAddress());
			session.setAttribute("profileImage", u1.getProfileImage());
					//request.setAttribute("name", u1.getName());
			d2=request.getRequestDispatcher("userProfilePage.jsp");
					
		}
		else {
			request.setAttribute("update", "error");
			d2=request.getRequestDispatcher("userProfilePage.jsp");
		}

		d2.forward(request, response);
		
	}

	/*public class RandomStringUtil {
	    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	    private static final SecureRandom random = new SecureRandom();

	    public static String generateRandomString(int length) {
	        StringBuilder sb = new StringBuilder(length);
	        for (int i = 0; i < length; i++) {
	            int randomIndex = random.nextInt(CHARACTERS.length());
	            char randomChar = CHARACTERS.charAt(randomIndex);
	            sb.append(randomChar);
	        }
	        return sb.toString();
	    }*/

}
