
$(document).ready(function() {

	$('.js-toggle').bind('click', function() {
		$('.js-sidebar').toggleClass('is-toggled');
		$('.js-content').toggleClass('is-toggled');
	});

	linkSelecionado();

});

function linkSelecionado() {
	var link = $(location).attr('pathname').toLowerCase();
	$('.menuPrincipal > li:has(a)').each(function(i) {
		var item = $(this).text().toLowerCase().trim();
		item = item.substr(0, 4);
		item = "/" + item;
		item = removeAcentosECedilha(item);
		if (link.indexOf(item) >= 0) {
			$(this).addClass("is-selected");
		}
	});
}

function removeAcentosECedilha(text) {
	text = text.replace(new RegExp('[ÁÀÂÃ]', 'gi'), 'A');
	text = text.replace(new RegExp('[ÉÈÊ]', 'gi'), 'E');
	text = text.replace(new RegExp('[ÍÌÎ]', 'gi'), 'I');
	text = text.replace(new RegExp('[ÓÒÔÕ]', 'gi'), 'O');
	text = text.replace(new RegExp('[ÚÙÛ]', 'gi'), 'U');
	text = text.replace(new RegExp('[Ç]', 'gi'), 'C');
	return text.toLowerCase();
}
