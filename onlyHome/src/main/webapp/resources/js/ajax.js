var AjaxUtil = function(conf) {
	var xhr = new XMLHttpRequest();
	var url = conf.url;
	var method = conf.method ? conf.method : 'GET';
	var param = conf.params;
	var returnVar;
	
/*	this.getReturnVar = function(){
		return returnVar;
	}
*/
	var success = conf.success ? conf.success : function(res) {
		alert(res);
	}
	var error = conf.error ? conf.error : function(res) {
		alert(res);
	}

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			if (xhr.status == "200") {
				/*returnVar = */success(xhr.responseText);
			} else {
				error(xhr.responseText);
			}
		}
	}
	xhr.open(method, url/*,false*/);
	if (method != 'GET' && method != 'POST') {
		console.log(conf.method)
		xhr.setRequestHeader('Content-type', 'application/json;charset=utf-8');
	}

	this.send = function() {
		xhr.send(param);
	}
}

//
