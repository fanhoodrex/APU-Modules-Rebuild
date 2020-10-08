$(function() {
    
    "use strict";
    
    /*=============================================
    =                Prealoder                  =
    =============================================*/
    
    $(window).on('load', function(event) {
        $('#preloader').delay(500).fadeOut(500);
    });
    
    /*=====  End of Prealoder  ======*/

    
    /*=============================================
    =                   Sticky                   =
    =============================================*/
    
    $(window).on('scroll', function(event) {    
        var scroll = $(window).scrollTop();
        if (scroll < 350) {
            $(".navigation").removeClass("sticky");
        } else{
            $(".navigation").addClass("sticky");
        }
    });

    /*=====  End of Sticky  ======*/   
    

    /*=============================================
    =             Mobile Script                   =
    =============================================*/
   

    // Script Navigation
	! function(n, e, i, a) {
		n.navigation = function(t, s) {
			var o = {
					responsive: !0,
					mobileBreakpoint:991,
					showDuration: 300,
					hideDuration: 300,
					showDelayDuration: 0,
					hideDelayDuration: 0,
					submenuTrigger: "hover",
					effect: "fade",
					submenuIndicator: !0,
					hideSubWhenGoOut: !0,
					visibleSubmenusOnMobile: !1,
					fixed: !1,
					overlay: !0,
					overlayColor: "rgba(0, 0, 0, 0.5)",
					hidden: !1,
					offCanvasSide: "left",
					onInit: function() {},
					onShowOffCanvas: function() {},
					onHideOffCanvas: function() {}
				},
				u = this,
				r = Number.MAX_VALUE,
				d = 1,
				f = "click.nav touchstart.nav",
				l = "mouseenter.nav",
				c = "mouseleave.nav";
			u.settings = {};
			var t = (n(t), t);
			n(t).find(".nav-menus-wrapper").prepend("<span class='nav-menus-wrapper-close-button'>✕</span>"), n(t).find(".nav-search").length > 0 && n(t).find(".nav-search").find("form").prepend("<span class='nav-search-close-button'>âœ•</span>"), u.init = function() {
				u.settings = n.extend({}, o, s), "right" == u.settings.offCanvasSide && n(t).find(".nav-menus-wrapper").addClass("nav-menus-wrapper-right"), u.settings.hidden && (n(t).addClass("navigation-hidden"), u.settings.mobileBreakpoint = 99999), v(), u.settings.fixed && n(t).addClass("navigation-fixed"), n(t).find(".nav-toggle").on("click touchstart", function(n) {
					n.stopPropagation(), n.preventDefault(), u.showOffcanvas(), s !== a && u.callback("onShowOffCanvas")
				}), n(t).find(".nav-menus-wrapper-close-button").on("click touchstart", function() {
					u.hideOffcanvas(), s !== a && u.callback("onHideOffCanvas")
				}), n(t).find(".nav-search-button").on("click touchstart", function(n) {
					n.stopPropagation(), n.preventDefault(), u.toggleSearch()
				}), n(t).find(".nav-search-close-button").on("click touchstart", function() {
					u.toggleSearch()
				}), n(t).find(".megamenu-tabs").length > 0 && y(), n(e).resize(function() {
					m(), C()
				}), m(), s !== a && u.callback("onInit")
			};
			var v = function() {
				n(t).find("li").each(function() {
					n(this).children(".nav-dropdown,.megamenu-panel").length > 0 && (n(this).children(".nav-dropdown,.megamenu-panel").addClass("nav-submenu"), u.settings.submenuIndicator && n(this).children("a").append("<span class='submenu-indicator'><span class='submenu-indicator-chevron'></span></span>"))
				})
			};
			u.showSubmenu = function(e, i) {
				g() > u.settings.mobileBreakpoint && n(t).find(".nav-search").find("form").slideUp(), "fade" == i ? n(e).children(".nav-submenu").stop(!0, !0).delay(u.settings.showDelayDuration).slideDown(u.settings.showDuration) : n(e).children(".nav-submenu").stop(!0, !0).delay(u.settings.showDelayDuration).slideDown(u.settings.showDuration), n(e).addClass("nav-submenu-open")
            },
             u.hideSubmenu = function(e, i) {
				"fade" == i ? n(e).find(".nav-submenu").stop(!0, !0).delay(u.settings.hideDelayDuration).slideUp(u.settings.hideDuration) : n(e).find(".nav-submenu").stop(!0, !0).delay(u.settings.hideDelayDuration).slideUp(u.settings.hideDuration), n(e).removeClass("nav-submenu-open").find(".nav-submenu-open").removeClass("nav-submenu-open")
			};
			var h = function() {
					n("body").addClass("no-scroll"), u.settings.overlay && (n(t).append("<div class='nav-overlay-panel'></div>"), n(t).find(".nav-overlay-panel").css("background-color", u.settings.overlayColor).fadeIn(300).on("click touchstart", function(n) {
						u.hideOffcanvas()
					}))
				},
				p = function() {
					n("body").removeClass("no-scroll"), u.settings.overlay && n(t).find(".nav-overlay-panel").fadeOut(400, function() {
						n(this).remove()
					})
				};
			u.showOffcanvas = function() {
				h(), "left" == u.settings.offCanvasSide ? n(t).find(".nav-menus-wrapper").css("transition-property", "left").addClass("nav-menus-wrapper-open") : n(t).find(".nav-menus-wrapper").css("transition-property", "right").addClass("nav-menus-wrapper-open")
			}, u.hideOffcanvas = function() {
				n(t).find(".nav-menus-wrapper").removeClass("nav-menus-wrapper-open").on("webkitTransitionEnd moztransitionend transitionend oTransitionEnd", function() {
					n(t).find(".nav-menus-wrapper").css("transition-property", "none").off()
				}), p()
			}, u.toggleOffcanvas = function() {
				g() <= u.settings.mobileBreakpoint && (n(t).find(".nav-menus-wrapper").hasClass("nav-menus-wrapper-open") ? (u.hideOffcanvas(), s !== a && u.callback("onHideOffCanvas")) : (u.showOffcanvas(), s !== a && u.callback("onShowOffCanvas")))
			}, u.toggleSearch = function() {
				"none" == n(t).find(".nav-search").find("form").css("display") ? (n(t).find(".nav-search").find("form").slideDown(), n(t).find(".nav-submenu").fadeOut(200)) : n(t).find(".nav-search").find("form").slideUp()
			};
			var m = function() {
					u.settings.responsive ? (g() <= u.settings.mobileBreakpoint && r > u.settings.mobileBreakpoint && (n(t).addClass("navigation-portrait").removeClass("navigation-landscape"), D()), g() > u.settings.mobileBreakpoint && d <= u.settings.mobileBreakpoint && (n(t).addClass("navigation-landscape").removeClass("navigation-portrait"), k(), p(), u.hideOffcanvas()), r = g(), d = g()) : k()
				},
				b = function() {
					n("body").on("click.body touchstart.body", function(e) {
						0 === n(e.target).closest(".navigation").length && (n(t).find(".nav-submenu").fadeOut(), n(t).find(".nav-submenu-open").removeClass("nav-submenu-open"), n(t).find(".nav-search").find("form").slideUp())
					})
				},
				g = function() {
					return e.innerWidth || i.documentElement.clientWidth || i.body.clientWidth
				},
				w = function() {
					n(t).find(".nav-menu").find("li, a").off(f).off(l).off(c)
				},
				C = function() {
					if (g() > u.settings.mobileBreakpoint) {
						var e = n(t).outerWidth(!0);
						n(t).find(".nav-menu").children("li").children(".nav-submenu").each(function() {
							n(this).parent().position().left + n(this).outerWidth() > e ? n(this).css("right", 0) : n(this).css("right", "auto")
						})
					}
				},
				y = function() {
					function e(e) {
						var i = n(e).children(".megamenu-tabs-nav").children("li"),
							a = n(e).children(".megamenu-tabs-pane");
						n(i).on("click.tabs touchstart.tabs", function(e) {
							e.stopPropagation(), e.preventDefault(), n(i).removeClass("active"), n(this).addClass("active"), n(a).hide(0).removeClass("active"), n(a[n(this).index()]).show(0).addClass("active")
						})
					}
					if (n(t).find(".megamenu-tabs").length > 0)
						for (var i = n(t).find(".megamenu-tabs"), a = 0; a < i.length; a++) e(i[a])
				},
				k = function() {
					w(), n(t).find(".nav-submenu").hide(0), navigator.userAgent.match(/Mobi/i) || navigator.maxTouchPoints > 0 || "click" == u.settings.submenuTrigger ? n(t).find(".nav-menu, .nav-dropdown").children("li").children("a").on(f, function(i) {
						if (u.hideSubmenu(n(this).parent("li").siblings("li"), u.settings.effect), n(this).closest(".nav-menu").siblings(".nav-menu").find(".nav-submenu").fadeOut(u.settings.hideDuration), n(this).siblings(".nav-submenu").length > 0) {
							if (i.stopPropagation(), i.preventDefault(), "none" == n(this).siblings(".nav-submenu").css("display")) return u.showSubmenu(n(this).parent("li"), u.settings.effect), C(), !1;
							if (u.hideSubmenu(n(this).parent("li"), u.settings.effect), "_blank" == n(this).attr("target") || "blank" == n(this).attr("target")) e.open(n(this).attr("href"));
							else {
								if ("#" == n(this).attr("href") || "" == n(this).attr("href")) return !1;
								e.location.href = n(this).attr("href")
							}
						}
					}) : n(t).find(".nav-menu").find("li").on(l, function() {
						u.showSubmenu(this, u.settings.effect), C()
					}).on(c, function() {
						u.hideSubmenu(this, u.settings.effect)
					}), u.settings.hideSubWhenGoOut && b()
				},
				D = function() {
					w(), n(t).find(".nav-submenu").hide(0), u.settings.visibleSubmenusOnMobile ? n(t).find(".nav-submenu").show(0) : (n(t).find(".nav-submenu").hide(0), n(t).find(".submenu-indicator").removeClass("submenu-indicator-up"), u.settings.submenuIndicator ? n(t).find(".submenu-indicator").on(f, function(e) {
						return e.stopPropagation(), e.preventDefault(), u.hideSubmenu(n(this).parent("a").parent("li").siblings("li"), "slide"), u.hideSubmenu(n(this).closest(".nav-menu").siblings(".nav-menu").children("li"), "slide"), "none" == n(this).parent("a").siblings(".nav-submenu").css("display") ? (n(this).addClass("submenu-indicator-up"), n(this).parent("a").parent("li").siblings("li").find(".submenu-indicator").removeClass("submenu-indicator-up"), n(this).closest(".nav-menu").siblings(".nav-menu").find(".submenu-indicator").removeClass("submenu-indicator-up"), u.showSubmenu(n(this).parent("a").parent("li"), "slide"), !1) : (n(this).parent("a").parent("li").find(".submenu-indicator").removeClass("submenu-indicator-up"), void u.hideSubmenu(n(this).parent("a").parent("li"), "slide"))
					}) : k())
				};
			u.callback = function(n) {
				s[n] !== a && s[n].call(t)
			}, u.init()
		}, n.fn.navigation = function(e) {
			return this.each(function() {
				if (a === n(this).data("navigation")) {
					var i = new n.navigation(this, e);
					n(this).data("navigation", i)
				}
			})
		}
	}
	(jQuery, window, document), $(document).ready(function() {
		$("#navigation").navigation()
	});


    /*=====  End of Mobile Mean menu  ======*/   
    

    /*=============================================
    =                 Slick Slider                =
    =============================================*/
    
    function mainSlider() {
            
        var BasicSlider = $('.slider-active');
            
        BasicSlider.on('init', function(e, slick) {
            var $firstAnimatingElements = $('.single-slider:first-child').find('[data-animation]');
            doAnimations($firstAnimatingElements);
        });
            
        BasicSlider.on('beforeChange', function(e, slick, currentSlide, nextSlide) {
            var $animatingElements = $('.single-slider[data-slick-index="' + nextSlide + '"]').find('[data-animation]');
            doAnimations($animatingElements);
        });
            
        BasicSlider.slick({
            autoplay: true,
            autoplaySpeed: 10000,
            pauseOnHover: false,
            dots: false,
            fade: true,
			arrows: true,
            prevArrow:'<span class="prev"><i class="fal fa-chevron-left"></i></span>',
            nextArrow: '<span class="next"><i class="fal fa-chevron-right"></i></span>',
            responsive: [
                { breakpoint: 767, settings: {} }
            ]
        });

        function doAnimations(elements) {
            var animationEndEvents = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
            elements.each(function() {
                var $this = $(this);
                var $animationDelay = $this.data('delay');
                var $animationType = 'animated ' + $this.data('animation');
                $this.css({
                    'animation-delay': $animationDelay,
                    '-webkit-animation-delay': $animationDelay
                });
                $this.addClass($animationType).one(animationEndEvents, function() {
                    $this.removeClass($animationType);
                });
            });
        }
    }
    mainSlider();

    /*=====  End of Slick Slider  ======*/
    

    /*=============================================
    =              Magnific Popup                 =
    =============================================*/

    $('.video-popup').magnificPopup({
        type: 'iframe'
        // other options
    });

    $('.image-popup').magnificPopup({
        type: 'image',
        gallery:{
          enabled:true
        }
    });

    /*=====  End of Magnific Popup ======*/


    /*=============================================
    =         specialty Hover Active             =
    =============================================*/

    
    $('.specialty-area').on('mouseover', '.single-specialty', function() {
        $('.single-specialty.active').removeClass('active');
        $(this).addClass('active');
    });

    /*=====  End of specialty Hover Active ======*/
       
    
    /*=============================================
    =           Slick Campus Image               =
    =============================================*/   

    $('.campus-image').slick({
        dots: false,
        infinite: false,
        arrows: true,
        prevArrow:'<span class="prev"><i class="fal fa-chevron-left"></i>Prev</span>',
        nextArrow: '<span class="next">Next <i class="fal fa-chevron-right"></i></span>',
        speed: 800,
        slidesToShow: 1,
        slidesToScroll: 1,
    });

    /*===== End of Slick Campus Image ======*/
       
    
    /*=============================================
    =             Slick Testimonials              =
    =============================================*/
    
    $('.testimonials-image').slick({
        slidesToShow: 1,
        slidesToScroll: 1,
        dots: false,
        fade: true,
        asNavFor: '.testimonials-content',
        speed: 800,
        arrows: true,
        prevArrow: false,
        nextArrow: '<span class="next">Next <i class="far fa-long-arrow-right"></i></span>',
    });
    
    $('.testimonials-content').slick({
        slidesToShow: 1,
        slidesToScroll: 1,
        asNavFor: '.testimonials-image',
        dots: false,
        arrows: false,
        focusOnSelect: true,
        speed: 800,
    });    

    /*===== End of Slick Testimonials ======*/


    /*=============================================
    =                 Counter Up                  =
    =============================================*/

    if($('.count').length){
        $('.count').appear(function () {
            $(this).prop('Counter',0).animate({
                Counter: $(this).text()
            }, {
                duration: 4000,
                easing: 'swing',
                step: function (now) {
                    $(this).text(Math.ceil(now));
                }
            });
        },{accY: 0});
    }

    /*=====  End of Counter Up  ======*/


    /*=============================================
    =             Slick Blog Active               =
    =============================================*/

    $('.blog-active').slick({
        dots: false,
        infinite: false,
        arrows: false,
        prevArrow:'<span class="prev"><i class="fal fa-chevron-left"></i></span>',
        nextArrow: '<span class="next"><i class="fal fa-chevron-right"></i></span>',
        autoplay: true,
        speed: 800,
        slidesToShow: 3,
        slidesToScroll: 1,
        responsive: [
            {
              breakpoint: 992,
              settings: {
                slidesToShow: 2,
              }
            },
            {
              breakpoint: 768,
              settings: {
                slidesToShow: 1,
              }
            },
            {
              breakpoint: 576,
              settings: {
                slidesToShow: 1,
              }
            }
        ]
    });

    /*=====  End of Slick Collection Active  ======*/

    
    /*=============================================
    =               Isotope Filter                =
    =============================================*/

    $('.container').imagesLoaded(function () {
        var $grid = $('.grid').isotope({
        // options            
            transitionDuration: '1s',
        });
        
        // filter items on button click
        $('.menu-items').on( 'click', 'li', function() {
          var filterValue = $(this).attr('data-filter');
          $grid.isotope({ filter: filterValue });
        });
        
        //for menu active class
        $('.menu-items li').on('click', function (event) {
            $(this).siblings('.active').removeClass('active');
            $(this).addClass('active');
            event.preventDefault();
        });
    });

    /*=====  End of Isotope Filter ======*/
       
    
    /*=============================================
    =             Gallery Masonry                 =
    =============================================*/

    $('.container').imagesLoaded(function () {

        var $grid = $('.grid-masonry').isotope({
            // options            
            itemSelector: '.grid-item',
            percentPosition: true,
            masonry: {
                // use outer width of grid-sizer for columnWidth
                columnWidth: 1,
            },
        });
    });

    /*=====  End of Gallery Masonry ======*/
       
    
    /*=============================================
    =               Rating Active                 =
    =============================================*/

    /* 1. Visualizing things on Hover - See next part for action on click */
    $('#stars li').on('mouseover', function(){
        var onStar = parseInt($(this).data('value'), 10); // The star currently mouse on
        
        // Now highlight all the stars that's not after the current hovered star
        $(this).parent().children('li.star').each(function(e){
            if (e < onStar) {
                $(this).addClass('hover');
            }
            else {
                $(this).removeClass('hover');
            }
        });
        
    }).on('mouseout', function(){
        $(this).parent().children('li.star').each(function(e){
            $(this).removeClass('hover');
        });
    });
    
    
    /* 2. Action to perform on click */
    var spansCounts =  $('#stars li').length
    $('#stars li').on('click', function(e) {
        console.log($(this).index())
        $('#stars li').removeClass('selected');

        for(var i=0 ; i < $(this).index() + 1; i++){
            $('#stars li').eq(i).addClass('selected')
        }
    })    

    /*=====  End of Rating Active ======*/


    /*=============================================
    =           Product Size Active               =
    =============================================*/

	$('.product-size li').on("click", function() {
		$(this).siblings(this).removeClass('active').end().addClass('active');
	});
    
    /*=====  End of Product Size Active ======*/


    /*=============================================
    =           Product Color Active               =
    =============================================*/

    $('.product-color li').each(function() {
		var get_color = $(this).attr('data-color');
		$(this).css("background-color", get_color);
    });
    
	$('.product-color li').on("click", function() {
		$(this).siblings(this).removeClass('active').end().addClass('active');
    });
    
    /*=====  End of Product Size Active ======*/
    
    
    /*=============================================
    =             product quantity                =
    =============================================*/

    $('.add').on('click', function () {
        if ($(this).prev().val()) {
            $(this).prev().val(+$(this).prev().val() + 1);
        }
    });
    $('.sub').on('click', function () {
        if ($(this).next().val() > 1) {
            if ($(this).next().val() > 1) $(this).next().val(+$(this).next().val() - 1);
        }
    });

    /*=====  End of product quantity ======*/

    
    /*=============================================
    =                WOW active                   =
    =============================================*/

    // Iterate over each select element
    $('select').each(function() {

        // Cache the number of options
        var $this = $(this),
        numberOfOptions = $(this).children('option').length;
    
        // Hides the select element
        $this.addClass('s-hidden');
    
        // Wrap the select element in a div
        $this.wrap('<div class="select"></div>');
    
        // Insert a styled div to sit over the top of the hidden select element
        $this.after('<div class="styledSelect"></div>');
    
        // Cache the styled div
        var $styledSelect = $this.next('div.styledSelect');
    
        // Show the first select option in the styled div
        $styledSelect.text($this.children('option').eq(0).text());
    
        // Insert an unordered list after the styled div and also cache the list
        var $list = $('<ul />', {
            'class': 'options'
        }).insertAfter($styledSelect);
    
        // Insert a list item into the unordered list for each select option
        for (var i = 0; i < numberOfOptions; i++) {
        $('<li />', {
            text: $this.children('option').eq(i).text(),
            rel: $this.children('option').eq(i).val()
        }).appendTo($list);
        }
    
        // Cache the list items
        var $listItems = $list.children('li');
    
        // Show the unordered list when the styled div is clicked (also hides it if the div is clicked again)
        $styledSelect.on('click',function(e) {
            e.stopPropagation();
            $('div.styledSelect.active').each(function() {
                $(this).removeClass('active').next('ul.options').hide();
            });
            $(this).toggleClass('active').next('ul.options').toggle();
        });
    
        // Hides the unordered list when a list item is clicked and updates the styled div to show the selected list item
        // Updates the select element to have the value of the equivalent option
        $listItems.on('click',function(e) {
            e.stopPropagation();
            $styledSelect.text($(this).text()).removeClass('active');
            $this.val($(this).attr('rel'));
            $list.hide();
        /* alert($this.val()); Uncomment this for demonstration! */
        });
    
        // Hides the unordered list when clicking outside of it
        $(document).on('click', function() {
            $styledSelect.removeClass('active');
            $list.hide();
        });
    
    });

    /*=====  End of product quantity ======*/

    
    /*=============================================
    =                WOW active                   =
    =============================================*/
    
    var wow = new WOW({
        boxClass: 'wow', //
        mobile: false, // 
    })
    wow.init();

    /*=====  End of WOW active ======*/

    
    /*=============================================
    =                Back to top                  =
    =============================================*/

    // Show or hide the sticky footer button
    $(window).on('scroll', function(event) {
        if($(this).scrollTop() > 600){
            $('.back-to-top').fadeIn(200)
        } else{
            $('.back-to-top').fadeOut(200)
        }
    });
    
    
    //Animate the scroll to yop
    $('.back-to-top').on('click', function(event) {
        event.preventDefault();
        
        $('html, body').animate({
            scrollTop: 0,
        }, 1500);
    });

    /*=====  End of Back to top ======*/    
    
    
});