function addtocart(productcode) {
	console.log("productcode" + productcode);
	var productQty = $('#products .' + productcode).val();
	var lineItemQty = $('#lineitem .' + productcode).val();
	if (lineItemQty == undefined) {
		lineItemQty = 0;
	}

	if (productQty == 0) {
		alert("Product is out of Stock!!!!");
	} else if (lineItemQty >= productQty) {
		alert("We currently dont have more Product ");
	} else {
		window.location = "carts/add/" + productcode;
	}
}