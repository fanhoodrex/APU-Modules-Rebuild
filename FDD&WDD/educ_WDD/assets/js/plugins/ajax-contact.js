$(function() {

	var form = $('#contact-form');

	var formMessages = $('.form-message');

	$(form).submit(function(e) {

		e.preventDefault();

		var formData = $(form).serialize();

		$.ajax({
			type: 'POST',
			url: $(form).attr('action'),
			data: formData
		})
		.done(function(response) {
			
			$(formMessages).removeClass('error');
			$(formMessages).addClass('success');
			
			$(formMessages).text('Our consultant will be replied your enquires within 48 hours.');

			$('#contact-form input,#contact-form textarea').val('');
		})
		.fail(function(data) {
			$(formMessages).removeClass('success');
			$(formMessages).addClass('error');

			if (data.responseText !== '') {
				$(formMessages).text('Please do complete the required elements!');
			} else {
				$(formMessages).text('Oops! An error occured and your message could not be sent.');
			}
		});
	});
});