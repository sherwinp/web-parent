
"use strict";
function setTab(item) {
            item.onblur = function(evt){
            	 var srcEl = evt.srcElement || evt.target;
            	 srcEl.className = "";
            };
            item.onclick = function(evt){
           	 var srcEl = evt.srcElement || evt.target;
        	 srcEl.className = "active";
            };
};
var app={

		main:function(){
		  var tablinks = Array.from( document.getElementById('nav').children );
		  tablinks.forEach(setTab);
		}
	};
	window.onload = app.main;