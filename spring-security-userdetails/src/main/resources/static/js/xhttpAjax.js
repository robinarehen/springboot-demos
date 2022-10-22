function ajax(method, url, data) {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			ajaxResponse(this.responseText);
		} else {
			if (this.readyState == 4 && this.status >= 400) {				
				ajaxError(this.status, this);
			}
		}
	};
	xhttp.open(method, url, true);
	xhttp.send();
}

function ajaxResponse(responseData) {

}

function ajaxError(statusCode, error) {

}