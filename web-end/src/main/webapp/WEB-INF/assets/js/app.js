function windowunload(e) {

	return false;
}
function setMenu(item) {
	item.onclick = function(evt) {
		var srcEl = evt.srcElement || evt.target;
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
	};
}
var app = {
	main : function() {
		var tablinks = Array.from(document.getElementById('navMenu').children);
		tablinks.forEach(setMenu);
	}
};
$(document).ready(app.main);
window.onbeforeunload = windowunload;