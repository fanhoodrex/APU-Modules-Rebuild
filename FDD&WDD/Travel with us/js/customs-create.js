
jQuery(function($) {

	"use strict";

		
	/**
	 * Input Spinner
	*/
	$(".form-spin").TouchSpin({
		buttondown_class: 'btn btn-spinner-down',
		buttonup_class: 'btn btn-spinner-up',
		buttondown_txt: '<i class="ion-minus"></i>',
		buttonup_txt: '<i class="ion-plus"></i>'
	});
		

	/**
	 * Dropzone - a custom file upload
	*/
	if( $('.dropzone').length > 0 ) {
		Dropzone.autoDiscover = false;
		$("#file-submit").dropzone({
				url: "upload",
				addRemoveLinks: true
		});

		$("#profile-picture").dropzone({
				url: "upload",
				addRemoveLinks: true
		});
		
		$(".itinerary-menu-image").dropzone({
				url: "upload",
				maxFiles: 10,
				addRemoveLinks: true
		});
	}
	
	
	/**
	 * Time Picker
	*/
	if( $('.oh-timepicker').length > 0 ) {
		$('.oh-timepicker').timepicker();
	}
	
	
	/**
	 * Tokenfield for Bootstrap
	 * http://sliptree.github.io/bootstrap-tokenfield/
	*/
	
	// Autocomplete Tagging
	var engine = new Bloodhound({
		local: [{value: 'Paris'}, {value: 'London'}, {value: 'Bangkok'} , {value: 'Bali'}, {value: 'Hongkong'}, {value: 'Rome'}, {value: 'Dubai'}, {value: 'Cairo'}, {value: 'Istanbul'}],
		datumTokenizer: function(d) {
			return Bloodhound.tokenizers.whitespace(d.value);
		},
		queryTokenizer: Bloodhound.tokenizers.whitespace
	});
	engine.initialize();
	$('#autocompleteTagging').tokenfield({
		typeahead: [null, { source: engine.ttAdapter() }],
		limit: '4',
	});
	
	// Autocomplete Tagging 
	var engine = new Bloodhound({
		local: [{value: 'Romantic'}, {value: 'Adventure'}, {value: 'Lifestyle'} , {value: 'Shopping'}, {value: 'Backpack'}, {value: 'One day trip'}, {value: 'City tour'}, {value: 'Cruise'}, {value: 'Business'}],
		datumTokenizer: function(d) {
			return Bloodhound.tokenizers.whitespace(d.value);
		},
		queryTokenizer: Bloodhound.tokenizers.whitespace
	});
	engine.initialize();
	$('#autocompleteTagging2').tokenfield({
		typeahead: [null, { source: engine.ttAdapter() }],
		limit: '5',
	});

	
});

