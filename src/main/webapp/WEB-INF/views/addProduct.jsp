<%@ include file="header.jsp" %>

<form:form  modelAttribute="addProduct" action="addProduct" enctype="multipart/form-data">
<form:errors path="*" cssStyle="Color:RED"></form:errors>
<fieldset>
          <p>
            <label for="type"><spring:message code="product.type" /> </label>
				<form:select path="category.id" id="category">
					<c:forEach items="${category}" var="type">
						<form:option value="${type.id}" label="${type.type}" />
					</c:forEach>
				</form:select>

			</p>  
			
			<p>
            <label for="name"><spring:message code="product.name" /> </label>
            <form:input path="name" id="name" />
            
        </p> 
        
        <p>
            <label for="description"><spring:message code="product.description" /> </label>
            <form:input path="description" id="description" />
            
        </p> 
        
        
        <p>
            <label for="productcode"><spring:message code="product.productcode" /> </label>
            <form:input path="productcode" id="productcode" />
            
        </p>
        
         <p>
            <label for="unitprice"><spring:message code="product.unitprice" /> </label>
            <form:input path="unitPrice" id="unitPrice" />
            
        </p> 
        
          <p>
            <label for="quantity"><spring:message code="product.quantity" /> </label>
            <form:input path="quantity" id="quantity" />
            
        </p> 
        
         <p>
          <label for="productImage"><spring:message code="product.image" /> </label>
        <form:input id="productImage" path="productImage" type="file"  />
        </p>
			   
        <p id="buttons">
            <input name="reset" type="reset" >
            <input name="submit" type="submit"  value="Add Product">
        </p>
       
    </fieldset>

</form:form>

<%@ include file="footer.jsp" %>