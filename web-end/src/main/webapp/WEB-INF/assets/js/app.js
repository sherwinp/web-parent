function setMenu(item){
	item.onclick = function(evt){
      	 var srcEl = evt.srcElement || evt.target;
      	document.getElementById('category').textContent = srcEl.textContent;
    };
}	
var app={
		main:function(){
			 var tablinks = Array.from( document.getElementById('navMenu').children );
			 tablinks.forEach(setMenu);
		}
	};
	$(document).ready(app.main);