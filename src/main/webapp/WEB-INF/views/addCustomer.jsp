<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Customer Registration</title>
</head>
<body>
	<spring:url value="/customer/saveCustomer" var="saveCustomer">
	</spring:url>
	<section class="container">
		<form:form modelAttribute="newCustomer" action="${saveCustomer}"
			class="form-horizontal" method="POST">
			<fieldset>
				<legend>Customer Registration</legend>



				<div class="form-group">
					<label class="control-label col-lg-2" for="firstName">First
						Name</label>
					<div class="col-lg-10">
						<form:input id="firstName" path="firstName" type="text"
							class="input-large" />
						<form:errors path="firstName" cssClass="text-danger" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="lastName">Last
						Name</label>
					<div class="col-lg-10">
						<form:input id="lastName" path="lastName" type="text"
							class="input-large" />
						<form:errors path="lastName" cssClass="text-danger" />

					</div>
				</div>


				<div class="form-group">
					<label class="control-label col-lg-2" for="emailAdress">Email
						Address</label>
					<div class="col-lg-10">
						<form:input id="emailAdress" path="emailAdress" type="text"
							class="input-large" />
						<form:errors path="emailAdress" cssClass="text-danger" />

					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="address">
						Address</label>
					<div class="col-lg-10">
						<form:input id="address" path="address" type="text"
							class="input-large" />
						<form:errors path="address" cssClass="text-danger" />

					</div>
				</div>





				<div class="form-group">
					<label class="control-label col-lg-2" for="username">User
						Name</label>
					<div class="col-lg-10">
						<div class="input-prepend">
							<form:input id="username" path="credential.username" type="text"
								class="input-large" />
							<form:errors path="credential.username" cssClass="text-danger" />

						</div>
					</div>
				</div>


				<div class="form-group">
					<label class="control-label col-lg-2" for="password">Password</label>
					<div class="col-lg-10">
						<div class="input-prepend">
							<form:password id="password" path="credential.password"
								class="input-large" />
							<form:errors path="credential.password" cssClass="text-danger" />

						</div>
					</div>
				</div>

				<form:hidden path="credential.role" value="ROLE_CUSTOMER" />

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Register" />
					</div>
				</div>

			</fieldset>
		</form:form>
	</section>
</body>
</html>
