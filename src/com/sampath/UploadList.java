package com.sampath;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/UploadList")
public class UploadList extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	//	Article[] articles = (Article[]) request.getAttribute("articles");

		 System.out.println("Get method in");
		 System.out.println("UploadList");
		 //ServletOutputStream out = response.getOutputStream();
			
	      

	    /*   out.println("<html>");
	       out.println("<head><title>Hello Servlet</title></head>");
	        
	       out.println("<body>");
	       out.println("<center><h2><font color=\"Green\">My Upload File List</font></h2></center>");
	       out.println("<form action=\"UploadList\"></form>");*/
		String FileNames1 ="";
		String FileNames2="";
		String dirPath = "C:\\Upload";
		 System.out.println(dirPath);
		File dir = new File(dirPath);
		String[] files = dir.list();
		int count=1;
		List<String> myList = new ArrayList<>();
		
        HttpSession session = request.getSession();
        System.out.println("http");
        System.out.println("http --> length "+files.length );
		if (files.length == 0) {
		    System.out.println("The directory is empty");
		} else {
		    for (String aFile : files) {
		      System.out.println("file name : "+aFile);
		     // aFile=aFile+"*";
		//      FileNames1=aFile;
		      myList.add(aFile);
		      
		      
			       //out.println("<font name=\"currentDeleteName\" color=\"black\"><a href=\"DeleteServlet\">"+"("+count+")."+aFile+"</a></font> <br><br>");	
			      
			     //  count++;
		    }
		}
		
	
	/*	out.println("</form>");
	       out.println("</body>");
	       out.println("<html>");*/
		System.out.println("file List length : "+myList.size());
		session.setAttribute("fileNamesList",myList);
		//System.out.println("session setted..");
		response.sendRedirect("uploaded.jsp"); 
		System.out.println("respond sended...");
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
