function windowunload(e) {

	return false;
}

function activeClick(srcEl){
	var createdLink = document.createElement('a');
	var nhref =  srcEl.id ;
	if( window.location.href.endsWith('index')){
		nhref =  'index/' + srcEl.id ;
	}
	createdLink.setAttribute('href', nhref);

	createdLink.appendChild(document.createTextNode(srcEl.textContent + ' - [' + createdLink.getAttribute('href') + ']'));

	document.getElementById('category').replaceChild(createdLink, document.getElementById('category').firstChild);
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
	}
};
$(document).ready(app.main);
window.onbeforeunload = windowunload;