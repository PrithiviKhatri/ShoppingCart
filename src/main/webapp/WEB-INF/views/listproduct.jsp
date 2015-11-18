<%@ include file="header.jsp" %>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<%-- <script type="text/javascript" src="<spring:url value="/resource/js/ajax.js"/>"></script> --%>
<script>
var id;
function makeAjaxCall(id){
	//alert("sasa");
	//var dataToSend = JSON.stringify(serializeObject($('#productdetails')));
	
	$.ajax({
		
		url: '../productDetailsAjax/' + id,
		type: 'POST',
		dataType: "JSON",           // Accepts
 		data: JSON.stringify({ "id": id}),
 		contentType: 'application/json',   // Sends
 		success: function(product) {
 			$('#formInput').html("");
 			$("#formInput").append( '<H3 align="center"> Details Of Product:- <H3>');                
			$('#formInput').append("<H4 align='center'>Product Name:  " + product.name  + "</h4>"  );
			$('#formInput').append("<H4 align='center'>Product Description: " + product.description  + "</h4>" );
			$('#formInput').append("<H4 align='center'>Product Quantity: " + product.quantity   + "</h4>");
			$('#formInput').append("<H4 align='center'>Product UnitPrice: " + product.unitPrice   + "</h4>");
			$('#formInput').append("<H4 align='center'>Product Code: " + product.productcode   + "</h4>");
			//$('#formInput').append("<img src='/resource/images/"+${product.image} +" alt='image'  style = 'width:100px'/>");
		},

	error: function(errorObject ){
	}
	
	});
}


// Translate form to array
// Then put in JSON format
 function serializeObject (form)
{
    var jsonObject = {};
    var array = form.serializeArray();
    $.each(array, function() {
         	jsonObject[this.name] = this.value;
    });
    return jsonObject;

};


</script>
<section class="container">
		<div class="row">
			<table width=97%  border="1"  style="margin:20px">
			<tr>
			<td>Name</td>
			<td>Quantity</td>
			<td>Action</td>
			
			</tr>
			<c:forEach items="${products}" var="product">
				<tr>
					
					<td>${product.name}</td>
					<td>${product.quantity}</td>
					<td><img src='data:image/jpg;base64,${product.imageFile}' /></td>
					<td><a href="editProduct/${product.id}">Edit</a> | 
					<a href="deleteProduct/${product.id}">Delete</a> |
					<a href="#" onclick="makeAjaxCall(${product.id})">Details</a>
					</td>
					
		
				</tr>
			</c:forEach>
			</table>
		</div>
	</section>
	<div id="formInput" style="color:RED;min-height: 400px;"></div>
	
	
	
	<div style="border:1px solid gray;background:#999999;height:100px;width:100%">
<p style="text-align:center;font-family:Verdana, Arial, Helvetica, sans-serif;font-weight:bold;color:#FFFFFF;">Online Shopping. &copy; 2015</p>
</div>
<style>
#list1 {margin-top:120px;width:100%;text-align:left;font-size: 12px;font-weight: bold;font-family: verdana; }
#list1 ul { list-style:none; text-align:center; border-top:1px solid #eee; border-bottom:1px solid #eee; padding:10px 0; }
#list1 ul li { display:inline; text-transform:uppercase; padding:0 10px; }
#list1 ul li a { text-decoration:none; color:#000033; }
#list1 ul li a:hover { text-decoration:underline; }

table {
    width:100%;
}
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
    text-align: left;
}
table#t01 tr:nth-child(even) {
    background-color: #eee;
}
table#t01 tr:nth-child(odd) {
   background-color:#fff;
}
table#t01 th	{
    background-color: black;
    color: white;
}
</style>


</body>
</html>
