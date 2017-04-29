var contextSegment = '/web-end/home/';
function windowunload(e) {
}

function activeClick(srcEl, item_slct){
	var createdLink = document.getElementById('category').getElementsByTagName("a")[0];
	createdLink.setAttribute('href', contextSegment + srcEl.id + '/' + item_slct);
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
		var item_slct = $('#tree, #core').jstree('get_selected', false)[0];
		item_slct = item_slct===undefined?'1':item_slct;
		activeClick(evt.srcElement || evt.target, item_slct);
	}
}

var app = {
	main : function() {
		
		////// js tree //////
		$('#tree, #core').jstree({ plugins : ["checkbox","sort","types","wholerow"], "core" : {"multiple" : false}, "types" : {} })
		.on("changed.jstree", function(evt, data){
			$('input[name="tselector"]').val( data.node.id );
		});
		
		var tablinks = Array.from(document.getElementById('navMenu').children);
		tablinks.forEach(setMenu);
		var selctd = document.getElementById('indx').value;
		tablinks.forEach(function(item){
			if(item.id == selctd){
				activeClick(item);
			}
		});		

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
