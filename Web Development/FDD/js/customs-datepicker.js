
jQuery(function($) {

	"use strict";

	$.dateRangePickerLanguages = {
		'default':  //default language: English
		{
			'selected': 'You selected from: ',
			'day':'Day',
			'days': 'Days',
			'apply': 'Close',
			'week-1' : 'mo',
			'week-2' : 'tu',
			'week-3' : 'we',
			'week-4' : 'th',
			'week-5' : 'fr',
			'week-6' : 'sa',
			'week-7' : 'su',
			'week-number': 'W',
			'month-name': ['january','february','march','april','may','june','july','august','september','october','november','december'],
			'shortcuts' : 'Shortcuts',
			'custom-values': 'Custom Values',
			'past': 'Past',
			'following':'Following',
			'previous' : 'Previous',
			'prev-week' : 'Week',
			'prev-month' : 'Month',
			'prev-year' : 'Year',
			'next':'Next',
			'next-week':'Week',
			'next-month':'Month',
			'next-year':'Year',
			'less-than' : 'Date range should not be more than %d days',
			'more-than' : 'Date range should not be less than %d days',
			'default-more' : 'Please select a date range longer than %d days',
			'default-single' : 'Please select a date',
			'default-less' : 'Please select a date range less than %d days',
			'default-range' : 'Please select your travelling days',
			'default-default': 'Please select from and to date',
			'time':'Time',
			'hour':'Hour',
			'minute':'Minute'
		}
	};

	
	$('#rangeDatePicker > div > div').dateRangePicker({
		separator : ' to ',
		autoClose: true,
		format: 'MMM D, YYYY',
		minDays: 4,
		maxDays: 4,
		stickyMonths: true,
		startDate: new Date(),
		showTopbar: false,
		getValue: function()
		{
			if ($('#rangeDatePickerTo').val() && $('#rangeDatePickerFrom').val() )
				return $('#rangeDatePickerTo').val() + ' to ' + $('#rangeDatePickerFrom').val();
			else
				return '';
		},
		setValue: function(s,s1,s2)
		{
			$('#rangeDatePickerTo').val(s1);
			$('#rangeDatePickerFrom').val(s2);
		},
		beforeShowDay: function(t){
			var valid = !(t.getDate() == 5 || t.getDate() == 17 || t.getDate() == 18 || t.getDate() == 19  || t.getDate() == 26 );
			var _class = '';
			var _tooltip = valid ? '' : 'not available';
			return [valid,_class,_tooltip];
		},
		customArrowPrevSymbol: '<i class="fa fa-arrow-circle-left"></i>',
		customArrowNextSymbol: '<i class="fa fa-arrow-circle-right"></i>'
		
	});

	
});

