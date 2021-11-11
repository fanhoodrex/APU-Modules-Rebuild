
jQuery(function($) {

	"use strict";

	
		var $window = $(window),
			navbar = $("#navbar");
		
		/**
		 * introLoader - Preloader
		 */
		$("#introLoader").introLoader({
			animation: {
				name: 'gifLoader',
				options: {
					ease: "easeInOutCirc",
					style: 'dark bubble',
					delayBefore: 1000,
					exitTime: 500
				}
			}
		});	
		
		
		
		/**
		 * Sticky Header
		 */
		$(".container-wrapper").waypoint(function() {
			$(".navbar").toggleClass("navbar-sticky");
			return false;
		}, { offset: "-20px" });
		
		
		
		/**
		 * Main Menu Slide Down Effect
		 */
		 
		// Mouse-enter dropdown
		navbar.find('li').on("mouseenter", function() {
			$(this).find('ul').first().stop(true, true).delay(250).slideDown(500, 'easeInOutQuad');
		});

		// Mouse-leave dropdown
		navbar.find('li').on("mouseleave", function() {
			$(this).find('ul').first().stop(true, true).delay(100).slideUp(150, 'easeInOutQuad');
		});
		
		
		
		/**
		 * Slicknav - a Mobile Menu
		 */
		var $slicknav_label;
		$('#responsive-menu').slicknav({
			duration: 500,
			easingOpen: 'easeInExpo',
			easingClose: 'easeOutExpo',
			closedSymbol: '<i class="fa fa-plus"></i>',
			openedSymbol: '<i class="fa fa-minus"></i>',
			prependTo: '#slicknav-mobile',
			allowParentLinks: true,
			label:"" 
		});
		
		
		
		/**
		 * Smooth scroll to anchor
		 */
		$('a.anchor[href*=#]:not([href=#])').on("click",function() {
			if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') && location.hostname == this.hostname) {
				var target = $(this.hash);
				target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
				if (target.length) {
					$('html,body').animate({
						scrollTop: (target.offset().top - 70) // 70px offset for navbar menu
					}, 1000);
					return false;
				}
			}
		});
		
		

		/**
		 *  Arrow for Menu has sub-menu
		 */

		if ( $window.width() > 992 ) {
			$(".navbar-arrow ul ul > li").has("ul").children("a").append("<i class='arrow-indicator fa fa-angle-right'></i>");
		} 
		
		
		/**
		 * Payment Option
		 */
		var paymentoption = $("div.payment-option-form"); 
		paymentoption.hide();
		$("input[name$='payments']").on("click",function() {
			var test = $(this).val();
			paymentoption.hide();
			$("#" + test).show();
		});
		
		
		/**
		 * Icon Change on Collapse
		 */
		$('.collapse.in').prev('.panel-heading').addClass('active');
		$('.bootstrap-accordion, .bootstrap-toggle')
		.on('show.bs.collapse', function(a) {
			$(a.target).prev('.panel-heading').addClass('active');
		})
		.on('hide.bs.collapse', function(a) {
			$(a.target).prev('.panel-heading').removeClass('active');
		});
		
		
		
		/**
		 * Back To Top
		 */
		
		var backtoptop = $("#back-to-top");
		
		$window.scroll(function() {
			if($window.scrollTop() > 500){
				backtoptop.fadeIn(200);
			} else{
				backtoptop.fadeOut(200);
			}
		});
		backtoptop.on("click",function() {
			$('html, body').animate({ scrollTop:0 }, '800');
			return false;
		});
		
		/**
		 * Bootstrap Tooltip
		 */
		$(function () {
		  $('[data-toggle="tooltip"]').tooltip()
		})
		

		
		/**
		 * Placeholder
		 */
		$("input, textarea").placeholder();
		
		
		
		/**
		* Bootstrap rating
		*/

		var ratinglabel = $('.rating-label');

		ratinglabel.rating();
			
		ratinglabel.each(function () {
		$('<span class="label label-default"></span>')
			.text($(this).val() || ' ')
			.insertAfter(this);
		});
		ratinglabel.on('change', function () {
			$(this).next('.label').text($(this).val());
		});
		
		
		/**
		 * Sign-in Modal
		 */
		var $formLogin = $('#login-form');
		var $formLost = $('#lost-form');
		var $formRegister = $('#register-form');
		var $divForms = $('#modal-login-form-wrapper');
		var $modalAnimateTime = 300;
		
		$('#login_register_btn').on("click", function () { modalAnimate($formLogin, $formRegister) });
		$('#register_login_btn').on("click", function () { modalAnimate($formRegister, $formLogin); });
		$('#login_lost_btn').on("click", function () { modalAnimate($formLogin, $formLost); });
		$('#lost_login_btn').on("click", function () { modalAnimate($formLost, $formLogin); });
		$('#lost_register_btn').on("click", function () { modalAnimate($formLost, $formRegister); });
		
		function modalAnimate ($oldForm, $newForm) {
			var $oldH = $oldForm.height();
			var $newH = $newForm.height();
			$divForms.css("height",$oldH);
			$oldForm.fadeToggle($modalAnimateTime, function(){
				$divForms.animate({height: $newH}, $modalAnimateTime, function(){
					$newForm.fadeToggle($modalAnimateTime);
				});
			});
		}
		
		
		/**
		 * Read more-less paragraph
		 */
		var showTotalChar = 130, showChar = "read more +", hideChar = "read less -";
		$('.read-more-less').each(function() {
			var content = $(this).text();
			if (content.length > showTotalChar) {
				var con = content.substr(0, showTotalChar);
				var hcon = content.substr(showTotalChar, content.length - showTotalChar);
				var txt= con +  '<span class="dots">...</span><span class="morectnt"><span>' + hcon + '</span>&nbsp;&nbsp;<a href="" class="showmoretxt">' + showChar + '</a></span>';
			$(this).html(txt);
			}
		});
		$(".showmoretxt").on("click", function () {
			if ($(this).hasClass("sample")) {
				$(this).removeClass("sample");
				$(this).text(showChar);
			} else {
				$(this).addClass("sample");
				$(this).text(hideChar);
			}
			$(this).parent().prev().toggle();
			$(this).prev().toggle();
			return false;
		});

	
});

