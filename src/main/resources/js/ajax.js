 
function makeAjaxCall(){
	//alert("sasa");
	var dataToSend = JSON.stringify(serializeObject($('#productdetails')));
	
	$.ajax({
		
		url: 'addAccountSetting',
		type: 'GET',
		dataType: "JSON",           // Accepts
 		data:dataToSend,
 		contentType: 'application/json',   // Sends
 		success: function(product) {
 			$('#formInput').html("");
 			$("#formInput").append( '<H3 align="center"> Account Setting Saved With Info:- <H3>');                
			$('#formInput').append("<H4 align='center'>Address:  " + product.address  + "</h4>"  );
			$('#formInput').append("<H4 align='center'>Company Name: " + product.companyName  + "</h4>" );
			$('#formInput').append("<H4 align='center'>Short Name: " + product.shortName   + "</h4>");
			/*make_visible('formInput');
			$("#address").val("");
			$("#companyName").val("");
			$("#shortName").val("");
			make_hidden('errors');*/
		},

	error: function(errorObject ){}
	
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

