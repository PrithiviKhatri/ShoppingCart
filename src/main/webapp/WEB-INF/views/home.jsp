<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Products currently available with us</title>
</head>
<body>
	<h1>Products currently in the shop</h1>
	<table>
	<c:forEach var="product" items="${products}">
	<tr>
		<td>${product.productcode}</td>
		<td>${product.name}</td>
		<td>${product.description}</td>
		<td>${product.unitPrice}</td>
		<td><a href="carts/${product.id}">Add to Cart</a></td>
	</tr>
	</c:forEach>
	</table>
	
</body>
</html>