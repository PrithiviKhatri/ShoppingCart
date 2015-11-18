<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!DOCTYPE HTML>
<html>
<head>

<title>Online Shopping</title>

</head>
<body>
	<%@ include file="headerClient.jsp"%>

	<div align=center>
		<a href="/ShoppingCart">Continue Shopping</a>
	</div>
	<div id="global">
		<h2>Items in the Cart</h2>

		<%
			int sn = 0;
		%>
		<table border="" style="width: 100%, min-height=300px">
			<tr>
				<th>SN</th>
				<th>Product</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Total</th>

			</tr>
			<c:forEach var="item" items="${cart.items}">
				<tr>
					<td><%=++sn%></td>
					<td>${item.product.name}</td>
					<td>${item.quanity}</td>
					<td>${item.product.unitPrice}</td>
					<td>${item.totalprice}</td>

				</tr>

			</c:forEach>
		</table>
		<div align="right">
			<b>Cart Total Amount: ${cart.totalamout} </b>
		</div>

		<spring:url value="/carts/checkoutStep2/" var="checkoutStep2">
		</spring:url>
		<div align="center">
			<a href="${checkoutStep2} ">Next</a>
		</div>

	</div>
	<%@ include file="footerClient.jsp"%>

</body>
</html>