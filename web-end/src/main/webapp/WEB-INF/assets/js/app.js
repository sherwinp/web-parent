var contextSegment = '/web-end/';
function windowunload(e) {
	 var text = "The Brown Fox.";
	 e.returnValue = text;
	 return text;
}

function activeClick(srcEl){
	var createdLink = document.getElementById('category').getElementsByTagName("a")[0];
	createdLink.setAttribute('href', contextSegment + srcEl.id + '/1');
	createdLink.textContent = srcEl.textContent;
	createdLink.click = function(e){
		e.preventDefault();
		var link = document.getElementById('category');
		var location = $(link).find('a').attr('href');
		console.log(location);
		window.location.href = location;
	};
	
	var navItems = Array.from(srcEl.parentNode.getElementsByClassName('active'));
	navItems.forEach(function(item){
		item.className = '';
	});
	srcEl.className = 'active';
	
	document.getElementById('indx').setAttribute('value', srcEl.id);
}

function setMenu(item) {
	item.onclick = function(evt){
		activeClick(evt.srcElement || evt.target);
	}
}

var app = {
	main : function() {
		var tablinks = Array.from(document.getElementById('navMenu').children);
		tablinks.forEach(setMenu);
		var selctd = document.getElementById('indx').value;
		tablinks.forEach(function(item){
			if(item.id == selctd){
				activeClick(item);
			}
		});
		
		////// js tree //////
		$('#tree, #core').jstree({ plugins : ["checkbox","sort","types","wholerow"], "core" : {}, "types" : {} });
	}
};

function initialize(e){
switch (document.readyState){
  case 'complete':
	  clearInterval(timerId);
    // The page is fully loaded.
    console.log('fully loaded. ');
    app.main();
    break;
  default:
	  console.log(document.readyState);
  }
}

window.onbeforeunload = windowunload;
var timerId = window.setInterval(initialize, 100);

initialize(null);
