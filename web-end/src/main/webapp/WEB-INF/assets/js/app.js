function setMenu(item){
	item.onclick = function(evt){
      	 var srcEl = evt.srcElement || evt.target;
      	 console.log("clicked.");
    };
}	
var app={
		main:function(){
			 var tablinks = Array.from( document.getElementById('navMenu').children );
			 tablinks.forEach(setMenu);
		}
	};
	$(document).ready(app.main);