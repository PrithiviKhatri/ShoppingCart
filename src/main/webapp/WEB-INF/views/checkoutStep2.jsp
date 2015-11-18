<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!DOCTYPE HTML>
<html>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript"
	src="<spring:url value="/resource/js/ajax.js"/>"></script>
<style type="text/css">
@import url("<spring:url value="/css/main.css"/>");</style>

<title>Online Shopping</title>

</head>
<body>
	<%@ include file="headerClient.jsp"%>

	<div align="left">
		<p>
			Billed to :<b> ${customer.firstName} ${customer.lastName}</b>
		</p>
		<p>
			Billed Amount: <b>${cart.totalamout} </b>
		</p>
		<p>
			Shipping Address: <b>${customer.address}</b>
		</p>
	</div>

	<div id="global">
		<h2>Items in the Cart</h2>

		<%
			int sn = 0;
		%>
		<table border="" style="width: 100%">
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


		<div align="left">
			<input type="button" value="Add Account"
				onclick="make_visible('formInput');return false;">
		</div>
		<div id="accountinfo">
			<br>Card Type :: <b>${customer.account.cardtype}</b> <br>Card
			Number :: <b>${customer.account.cardNo}</b> <br>Billing Adress::
			<b>${customer.account.billingAddress}</b>

		</div>
		<div></div>

	</div>

	<spring:url value="/account/checkoutStep3Payment/" var="checkoutStep3">
	</spring:url>
	<div align="center">
		<form action="${checkoutStep3}" method="post">
			<div align="left">
				<p>
					<b>Add Notes:</b>
				</p>
				<textarea rows="4" cols="50" name="comments"></textarea>
			</div>
			<input type="submit" value="Proceed For Payment" />
		</form>


	</div>






	<!-- Success - or Validation errors -->
	<div id="result" style="display: none">
		<p id="success"></p>
		<p id="errors"></p>
	</div>

	<div id="formInput" style="display: none">

		<h3 align="center">Add Account Information</h3>

		<!-- No action method .to be handled by AJAX-->
		<form id="accountForm" method="post">


			<p>
			
				<label for="cardtype"> Card Type :</label> <input type="radio"
					name="cardtype" value="visa">VISA
					 <input type="radio" name="cardtype" value="mastercard">MasterCard
			

			</p>

			<p>
				<label for="cardNo"> Card Number: </label> <input id="cardNo"
					name="cardNo" type="text" />
			</p>
			<p>
				<label for="billingAddress"> Billing Address: </label> <input
					id="billingAddress" name="billingAddress" type="text" />
			</p>



			<input type="button" value="Add Account"
				onclick="accountSubmit();return false;">

		</form>
		<h4 align="center">
			<a href="#"
				onclick="make_hidden('formInput'); make_hidden('result');resetForm('accountForm');">
				<b>EXIT</b>
			</a>
		</h4>

	</div>
	<%@ include file="footerClient.jsp"%>

</body>
</html>