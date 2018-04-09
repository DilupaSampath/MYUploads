<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    <%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
#download {
    background-color: #7B8FF4; /* Green */
    color: white;
    cursor: pointer;
        padding: 10px;
}
#delete {
    background-color: #EA7B63; /* Green */
    color: white;
    cursor: pointer;
        padding: 10px;
}
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}
th{background-color:#F0A35A;}

tr:hover {background-color:#E0F7E6;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>File List</h2>
<table>
 <tr>
    <th>File Name</th>
    <th>Action</th> 
 </tr>
 
  <c:set var="counter" value="1" />
  <c:forEach items="${fileNamesList}" var="item">      

<tr>
<td>  ${item} </td>
<td> <button id="delete">Delete File  </button><button id="download" >Download</button> </td>
</tr>
  </c:forEach>
</table>
</body>
</html>