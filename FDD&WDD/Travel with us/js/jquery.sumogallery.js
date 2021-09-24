/*!
 * jquery.sumogallery - v1.0.0
 * http://hemantnegi.github.io/jquery.sumogallery
 * created : 2015-01-21
 *
 * Copyright 2014 Hemant Negi
 * Email : hemant.frnz@gmail.com
 * Compressor http://refresh-sf.com/yui/
 */

(function ($) {
    'namespace sg';

    sgallery = {

        settings: {
            sattr: 'data-sgallery', // attrribute on image to be looked by plugin. by which we can set group name.
            showImgCount: true,       //display image counts on bottom right
            showThumbs: true
        },

        //bind all generic events here.
        bindEvents: function () {
            var O = this;
            var S = O.settings;

            //add click to all the images having attribute data-sgallery
            $('img[' + S.sattr + ']').on('click.sg', function () {
                O.SG.reset();
                var _d = O.prepareData($(this));
                O.prepareHTML(_d);
            });

        },

        //accepts current clicked element.
        //returns a json object
        prepareData: function (c_img) {
            var O = this;
            var S = O.settings;

            gname = c_img.attr(S.sattr);
            var imgs = [];
            $('img[data-sgallery="' + gname + '"]').each(function (i, e) {
                e = $(e);
                var d = {};
                d['thumb'] = e.data('thumb') || false;
                d['full'] = e.data('full') || false;
                d['title'] = e.attr('title') || '';
                d['alt'] = e.attr('alt') || '';
                if (d['thumb'] && d['full']) imgs.push(d); // exclude if thumb or full is not set.
                else return;

                //collect the index of selected item.
                if (e.is(c_img)) O.SG.sindex = i;

            });
            return imgs;
        },

        //prepares all the required markup for the gallery.
        prepareHTML: function (imgs) {
            var O = this;
            O.SG.imgs = imgs;

            //dont do any thing if no proper data available.
            if (imgs.length == 0) {
                console.log('no images with appropriate data!!');
                return;
            }

            $('.SumoGallery').remove();
            O.SG._SG = $('<div class="SumoGallery" style="display:none;">');
            if (!O.settings.showThumbs)O.SG._SG.addClass('nothumbs');

            O.SG.title = $('<p>Sumo Gallery</p>');
            O.SG.close = $('<a>&times;</a>');
            O.SG.body = $('<div class="Sbody">');
            O.SG.footer = $('<div class="Sfooter">');
            O.SG.thumbs = $('<ul class="Sthumbnails">');
            O.SG.footer.append(O.SG.thumbs);
            O.SG.left = $('<a class="Sarrow l">&#10092;</a>');
            O.SG.right = $('<a class="Sarrow r">&#10093;</a>');
            O.SG.count = $('<p class="SimgCount"></p>');
            O.SG.arrow = $('<a title="Toggle thumbnails." class="toggle-thumbs">&#8226;&#8226;&#8226;</a>');
            O.SG._SG.append($('<div class="Sheader">').append(O.SG.title).append(O.SG.close))
                .append(O.SG.body).append(O.SG.footer).append(O.SG.left).append(O.SG.right);
            O.SG.footer.append(O.SG.arrow).append(O.SG.count);

            for (var i in imgs) {
                // preload images technique
                O.SG.body.append($('<a>').append(
                    $('<img alt="' + imgs[i].full + '" title="' + imgs[i].title + '" style="display:none;" />').on('load', function () {
                        $(this).fadeIn(300);
                    }).attr('src', imgs[i].full)
                ));

                O.SG.thumbs.append('<li><a style="background-image:url(\'' + imgs[i].thumb + '\')"></a></li>');
            }


            $('body').append(O.SG._SG);
            O.SG.init();
            O.SG._SG.fadeIn(300);
        },

        // actual sumogallery object
        SG: {imgs: {}, sindex: 0, //title:'',close:'',body:'',left:'',right:'',thumbs:''
            reset: function () {
                this.sindex = 0;
            },
            setEvents: function () {
                var O = this;

                //close button on top right;
                O.close.on('click.sg', function () {
                    $('.SumoGallery').fadeOut(300, function () {
                        $('.SumoGallery').remove();
                    });
                    $(document).off('keydown.sg');
                });

                O.left.on('click.sg', function () {
                    O.prev();
                });
                O.right.on('click.sg', function () {
                    O.next();
                });

                O.thumbs.find('li>a').on('click.sg', function () {
                    O.select($(this).parent().index());
                });

                //touch events
                O.body.find('a').on('swipeleft', function () {
                    O.next();
                });
                O.body.find('a').on('swiperight', function () {
                    O.prev();
                });

                O.arrow.on('click', function () {
                    O._SG.toggleClass('nothumbs');
                })

                //connect keyboard keys
                $(document).on('keydown.sg', function (e) {
                    switch (e.which) {
                        case 37: // left
                            O.prev();
                            break;

                        case 39: // right
                            O.next();
                            break;

                        case 27: // esc
                            O.close.trigger('click.sg');
                            break;

                        default:
                            return; // exit this handler for other keys
                    }
                    e.preventDefault(); // prevent the default action (scroll / move caret)
                });

            },
            // set selected an image in gallery by a given index.
            select: function (i) {
                var O = this;
                if (i > O.imgs.length - 1 || i < 0) return;

                O.thumbs.children('li.sel').removeClass('sel');
                O.thumbs.children('li').eq(i).addClass('sel')

                //put sel thumb in center
                var centre = O.thumbs.width() / 2 - O.thumbs.children('li').width() / 2
                O.thumbs.stop().animate({scrollLeft: O.thumbs.children('li.sel').index() * O.thumbs.children('li').outerWidth(true) - centre});


                var _new = O.body.children('a').eq(i)//.addClass('sel');
                var _old = O.body.children('a.sel')//.removeClass('sel');
                if (!_old.length)_new.addClass('sel anim');

                if (i < this.sindex) { //slide to right
                    _old.addClass('right');
                    setTimeout(function () {
                        _old.removeClass('right sel anim')
                    }, 300);
                    _new.removeClass('anim right').addClass('sel left');
                    setTimeout(function () {
                        _new.addClass('anim').removeClass('left')
                    }, 5);
                }
                else if (i > this.sindex) { //slide to left
                    _old.addClass('left');
                    setTimeout(function () {
                        _old.removeClass('left sel anim')
                    }, 300);
                    _new.removeClass('anim left').addClass('sel right');
                    setTimeout(function () {
                        _new.addClass('anim').removeClass('right')
                    }, 5);
                }

                this.sindex = i;

                //set title of image
                O.title.text(_new.children('img').attr('title'));

                //set counts depending on settings.
                if (sgallery.settings.showImgCount) O.count.text('image ' + (i + 1) + ' of ' + O.imgs.length);

                O.left.toggleClass('last-item', i < 1);
                O.right.toggleClass('last-item', i > O.imgs.length - 2);
            },

            next: function () {
                this.select(this.sindex + 1);
            },
            prev: function () {
                this.select(this.sindex - 1);
            },

            init: function () {
                var O = this;
                O.setEvents();
                O.select(O.sindex);
            }
        },

        init: function () {
            var O = this;
            this.bindEvents();
        }

    };

    sgallery.init();
}(jQuery));

