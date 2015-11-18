<%@ include file="header.jsp" %>

<form:form  modelAttribute="editCategory" action="editCategory" >
<form:errors path="*" cssStyle="Color:RED"></form:errors>
<fieldset>
        <p>
            <label for="type"><spring:message code="category.type" /> </label>
            <form:input path="type" id="type" value="${category.type}" />
            <form:hidden path="id" id="id" value="${category.id}" />
        </p>    
        <p id="buttons">
            <input name="reset" type="reset" >
            <input name="submit" type="submit"  value="Edit Category">
        </p>
       
    </fieldset>

</form:form>
<%@ include file="footer.jsp" %>