package com.sampath;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.sun.org.apache.xml.internal.serialize.Printer;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import java.util.*;


public class UploadSer extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String Isfile="";
		PrintWriter out = response.getWriter();
		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
		try {
			List<FileItem> multifile = sf.parseRequest(request);
		int count=1;
		for(FileItem f1 :multifile )
		{
			
			String fileName = f1.getName();
			if (fileName != null) {
				fileName = FilenameUtils.getName(fileName);
				Isfile = "A";
			} 
	
		 try {
				 f1.write(new File("C:/Upload/"+fileName));
				// out.println("Uploded succes fully..!!");
				// HttpSession session = request.getSession();
				//	session.setAttribute("file", fileName);
				
				// response.sendRedirect("FileUpload.jsp");
				 
		
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		HttpSession session = request.getSession();
		session.setAttribute("getAlert", "Yes");
		
		response.sendRedirect("FileUpload.jsp"); 
	   /*    out.println("<html>");
	       out.println("<head><title>Hello Servlet</title></head>");
	        
	       out.println("<body>");
	 
	       out.println("<form action=\"UploadList\"><input type=\"submit\" value=\"View Uploads\" /></form>");
	      // out.println("<br><br><br><input type=\"button\" value=\"View Uploads\">");
	       out.println("</body>");
	       out.println("<html>");*/
		
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
