<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript">
var Msg ='<%=session.getAttribute("getAlert")%>';
    if (Msg != "null") {
 function alertName(){
 alert("Form has been submitted");
 } 
 }
 </script> 
</head>
<body>
<%
if(session.getAttribute("userName")==null)
{
response.sendRedirect("Login.jsp");
}
%>
<center><h2 style="background-color:#bbc4a5" ><font color="#bb0017"> <br>File Upload center </font></h2></center>
<center><form action="UploadSer" method="POST" enctype="multipart/form-data" style="background-color:#dbea96">

<br><br>
<br><br>
<input type="file" name="file" multiple/> <br><br>
<input type="submit" value="Upload File"/>
<br><br>
<br><br>


<br><br>
</form></center>
<form action="UploadList" >
<input type="submit" value="View Uploads" />
</form>

</body>
<script type="text/javascript"> window.onload = alertName; </script>
</html>