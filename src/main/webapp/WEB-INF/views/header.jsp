<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Shopping</title>

</head>
<body>
<div style="border:1px solid gray;background:#999999;height:100px;position:absolute;top:0px;width:100%">
<p style="text-align:center;font-family:Verdana, Arial, Helvetica, sans-serif;font-weight:bold;color:#FFFFFF;font-size:26px">Online Shopping</p>
</div>

<div id="list1">
    <ul>
      <li><a href="${pageContext.request.contextPath}/admin/listCategory">List Category</a>|</li>
      <li><a href="${pageContext.request.contextPath}/admin/addCategory">Add Category</a>|</li>
      <li><a href="${pageContext.request.contextPath}/admin/addProduct">Add Product</a></li>|
     <li> Language: [<a href="?language=en">English</a> | <a href="?language=fn_FN">French</a>]</li>
      <li><a href="#">Logout</a></li>
   </ul>
</div>   
