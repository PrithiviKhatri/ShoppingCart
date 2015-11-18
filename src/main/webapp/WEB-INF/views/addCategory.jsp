<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Shopping</title>
</head>
<body>
<form:form  modelAttribute="addCategory" action="addCategory" >
<form:errors path="*" cssStyle="Color:RED"></form:errors>
<fieldset>
        
        <p>
            <label for="type"><spring:message code="category.type" /> </label>
            <form:input path="type" id="type"  />
            
        </p>    
        <p id="buttons">
            <input name="reset" type="reset" >
            <input name="submit" type="submit"  value="Add Category">
        </p>
       
    </fieldset>

</form:form>
<%@ include file="footer.jsp" %>