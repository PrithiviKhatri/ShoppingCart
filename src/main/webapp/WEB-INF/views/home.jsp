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
	<c:choose>
		<c:when test="${empty customer}">
			<div align="right">
				<a href="<c:url value="/login"/>">Login</a>
			</div>
		</c:when>
		<c:otherwise>
			<div align="right">
				<b>Welcome! You are logged in as ${customer.firstName}
					${customer.lastName} </b><i></i><br> <a
					href="<c:url value="/logout"/>">Logout</a>
			</div>
		</c:otherwise>
	</c:choose>
	<table>
		<c:if test="${not empty cart.items}">
			<h1>Your Shopping cart</h1>

			<tr>

				<th>Quantity</th>
				<th>Product</th>
				<th>Price</th>

			</tr>

			<c:forEach var="item" items="${cart.items}">
				<tr>
					<td>${item.quanity}</td>
					<td>${item.product.name}</td>
					<td>${item.totalprice}</td>
					<td><a href="carts/remove/${item.product.productcode}">Remove
							from Cart</a></td>

				</tr>


			</c:forEach>
			<tr>
				<td><b>Cart Total Amount: ${cart.totalamout} </b></td>
			</tr>
			<tr>
				<td><h3>
						<a href="carts/checkout">Proceed to Checkout</a>
					</h3></td>
			</tr>
		</c:if>
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