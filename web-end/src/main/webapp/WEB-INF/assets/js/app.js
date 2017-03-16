	var app={
		main:function(){
			jQuery.ajax = ajax;
		}
	};
	$(document).ready(app.main);