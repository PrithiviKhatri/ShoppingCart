<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Products currently available with us</title>
</head>
<body>
	<%@ include file="headerClient.jsp"%>
	<table width="100%" border="1"
		style="margin-top: 50px; min-height: 400px">
		<tr>
			<td width="20%" valign="top"><table width="100%" border="1">
					<tr>
						<td class="header">Category</td>
					</tr>

					<c:forEach var="category" items="${categories}">
						<tr>
							<td><a href="${category.id}">${category.type}</a></td>
						</tr>
					</c:forEach>
				</table></td>
			<td width="60%" valign="top">
				<table>
					<c:forEach var="product" items="${products}">
						<tr>
							<td><img height="100px" width="100px"
								src='data:image/jpg;base64,${product.imageFile}' /></td>

							<td>${product.name}</td>
							<td>${product.description}</td>
							<td>${product.unitPrice}</td>
							<td><a href="carts/add/${product.productcode}">Add to
									Cart</a></td>
						</tr>
					</c:forEach>
				</table>
			</td>
			<td width="20%" valign="top"><table>
					<c:if test="${not empty cart.items}">
						<h3>Your Shopping cart</h3>

						<tr>

							<th>Qty</th>
							<th>Product</th>
							<th>Price</th>
							<th>Action</th>
						</tr>

						<c:forEach var="item" items="${cart.items}">
							<tr>
								<td>${item.quanity}</td>
								<td>${item.product.name}</td>
								<td>${item.totalprice}</td>
								<td><a href="carts/remove/${item.product.productcode}">Remove</a></td>

							</tr>


						</c:forEach>
						<tr>
							<td colspan="4"><b>Cart Total Amount: ${cart.totalamout}
							</b></td>
						</tr>
						<tr>
							<td colspan="4" style="text-align: center"><a
								href="carts/checkout"><b>Checkout</b></a></td>
						</tr>
					</c:if>
				</table></td>
		</tr>
	</table>



	<%@ include file="footerClient.jsp"%>
</body>
</html>


