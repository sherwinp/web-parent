function windowunload(e) {

	return false;
}
function setMenu(item) {
	item.onclick = function(evt) {
		var srcEl = evt.srcElement || evt.target;
		var createdLink = document.createElement('a');

		createdLink.setAttribute('href', window.location.href.concat('/' + srcEl.id));

		createdLink.appendChild(document.createTextNode(srcEl.textContent + ' - [' + createdLink.getAttribute('href') + ']'));

		document.getElementById('category').replaceChild(createdLink, document.getElementById('category').firstChild);
		$(document.getElementById('category')).find('a').on('click', function(e){
			var link = document.getElementById('category');
			window.location = $(link).find('a').attr('href');
			console.log(e);
			e.preventDefault();
		});
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