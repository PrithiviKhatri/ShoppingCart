
<div style="text-align:center">
<h1>Online Shopping</h1>
</div>
<div style="float: right">
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
</div>