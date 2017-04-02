function windowunload(e) {
	 var text = "The Brown Fox.";
	 e.returnValue = text;
	 return text;
}

function activeClick(srcEl){
	var createdLink = document.createElement('a');
	createdLink.setAttribute('href', srcEl.id);

	createdLink.appendChild(document.createTextNode(srcEl.textContent + ' - [' + createdLink.getAttribute('href') + ']'));
	
	document.getElementById('category').removeChild(document.getElementById('category').getElementsByTagName('a')[0]);
	document.getElementById('category').appendChild(createdLink);
	$(document.getElementById('category')).find('a').on('click', function(e){
		var link = document.getElementById('category');
		window.location = $(link).find('a').attr('href');
		console.log(e);
		e.preventDefault();
	});
	
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
