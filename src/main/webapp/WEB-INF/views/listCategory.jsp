
<%@ include file="header.jsp" %>
<p> ${message} </p> 
<section class="container">
		<div class="row">
			<table width=97%  border="1"  style="margin:20px">
			<tr>
			<td>Id</td>
			<td>Category</td>
			<td>Action</td>
			
			</tr>
			<c:forEach items="${listcategory}" var="category">
				<tr>
					
					<td>${category.id}</td>
					<td>${category.type}</td>
					
					<td><a href="editCategory/${category.id}">Edit</a> | 
					<a href="deleteCategory/${category.id}">Delete</a></a> |
					<a href="listproduct/${category.id}">Details</a></a>
					
					</td>
					
		
				</tr>
			</c:forEach>
			</table>
		</div>
	</section>
	<%@ include file="footer.jsp" %>
