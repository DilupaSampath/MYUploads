package com.sampath;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.*;
import com.sun.org.apache.xml.internal.serialize.Printer;
/**
 * Servlet implementation class UploadServelet
 */

public class UploadServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private File file=null;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doPost(request,response);
		System.out.println("get methord");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("post works");
		
		boolean isMultipart;
String filePath;
int maxfileSize=50*1024*10;
int maxMemSize=5*1024*10;
System.out.println("post works1");
//filePath= getServletContext().getInitParameter("file_Upload");
isMultipart = ServletFileUpload.isMultipartContent(request);
response.setContentType("text/html");
PrintWriter out = response.getWriter();
System.out.println("post works2");

try {
	

//if(!isMultipart)
//{
//	out.print("File not upload1");
//	return;
//}
	System.out.println("post works3");
DiskFileItemFactory factry = new DiskFileItemFactory();
factry.setSizeThreshold(maxfileSize);
factry.setRepository(new File("C:\\SLIIT"));
ServletFileUpload upload = new ServletFileUpload(factry);
upload.setSizeMax(maxfileSize);
System.out.println("post works4");

try {
	List<FileItem> fileItems = upload.parseRequest(request);
	System.out.println("post works5");
	Iterator i = fileItems.iterator();
	while(i.hasNext())
	{	out.print("File not upload2");
		FileItem f1 = (FileItem)i.next();
		if(f1.isFormField())
		{	out.print("File not upload3");
			String fieldName = f1.getFieldName();
			String fieName = f1.getName();
			String contextType = f1.getContentType();
			boolean isInMemory = f1.isInMemory();
			long sizeInBytes = f1.getSize();
			out.print("File name :" +fieName);
			
			if(fieName.lastIndexOf("\\")>=0)
			{	out.print("File not upload4");
				file = new File("C:\\Upload"+fieName.substring(fieldName.lastIndexOf("\\")));
				
			}else
			{	out.print("File not upload5");
				file = new File("C:\\Upload"+fieName.substring(fieldName.lastIndexOf("\\")+1));
			}
			out.print("File not upload6");
			f1.write(file);
			out.println("file uploded  :  "+fieldName);
			
			
		}
		
	}
	
	
} catch (Exception e) {
	out.println(e);
}
} catch (Exception e) {
	// TODO: handle exception
}

	}



}
