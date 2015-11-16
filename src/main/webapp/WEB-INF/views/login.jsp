<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container" style="text-align: center">
				<h3>Shop Online</h3>
			</div>
		</div>
	</section>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<b>Sign In</b>
						</h3>
					</div>
					<div class="panel-body">
						<c:if test="${not empty error}">
							<div class="alert alert-danger">
								<spring:message
									code="AbstractUserDetailsAuthenticationProvider.badCredentials" />
								<br />
							</div>
						</c:if>
						<form action="<spring:url value="/postLogin"></spring:url>"
							method="post">
							<fieldset>
								<div class="form-group">
									<input class="form:input-large" placeholder="User Name"
										name='username' type="text">
								</div>
								<div class="form-group">
									<input class=" form:input-large" placeholder="Password"
										name='password' type="password" value="">
								</div>
								<input class="" type="submit" value="Login">
							</fieldset>
						</form>
						<a href="customer/addCustomer">New Customer</a>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>