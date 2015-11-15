<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shopping just one click away</title>
</head>
<body>

	<table>
		<c:if test="${not empty cart.items}">
			<h1>Your Shopping cart</h1>

			<tr>

				<th>Quantity</th>
				<th>Product</th>
				<th>Price</th>
			</tr>
		</c:if>
		<c:forEach var="item" items="${cart.items}">
			<tr>
				<td>${item.quanity}</td>
				<td>${item.product.name}</td>
				<td>${item.totalprice}</td>
				<td><a href="carts/remove/${item.product.productcode}">Remove
						from Cart</a></td>

			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<br>
	<h1>Products currently with us</h1>
	<table>
		<c:forEach var="product" items="${products}">
			<tr>
				<td>${product.name}</td>
				<td>${product.description}</td>
				<td>${product.unitPrice}</td>
				<td><a href="carts/add/${product.productcode}">Add to Cart</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>