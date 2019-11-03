/*
*
* ---------------------------------------------------------------------------
*
* Template: http://demo.iamhafiz.me/letigation/
* Author: wpthemeshaper
* Author URI: wpthemeshaperwd
* Version:     1.0
*
* ---------------------------------------------------------------------------
*
*/

(function ($) {

'use strict';

/*  ======================================
    Mobile Menu
    ======================================*/
    
    var mobileMenu = $('.main-navigation ul.menu');
    mobileMenu.slicknav({
        prependTo: '.mobile-menu'
    });

/*  ======================================
    Banner Slide
    ====================================== */

    var mainBannerArea = $('.banner-area');

    mainBannerArea.owlCarousel({
        items: 1,
        loop: true,
        dots: false,
        thumbs: false,
        nav: true,
        navText: ['<i class="fa fa-angle-left" aria-hidden="true"></i><div class="itemprebg"></div>', '<div class="itemnextbg"></div><i class="fa fa-angle-right" aria-hidden="true"></i>'],
        mouseDrag: false,
        autoplay: true,
        autoplayTimeout: 6000 // auto play time
    });

    var itemBg = $('.itembg');

    $('.banner-area .single-banner').each(function () {
        var itmeImg = $(this).find('.itembg img').attr('src');
        $(this).css({
            background: 'url(' + itmeImg + ')'
        });
    });

    function slideThumb() {

        $('.banner-area .owl-item').removeClass('next prev');

        var currenSlide = $('.banner-area .owl-item.active');
        currenSlide.next('.owl-item').addClass('next');
        currenSlide.prev('.owl-item').addClass('prev');

        var nextSlideImg = $('.owl-item.next').find('.itembg img').attr('src');
        var prevSlideImg = $('.owl-item.prev').find('.itembg img').attr('src');

        $('.banner-area .owl-nav .owl-prev .itemprebg').css({
            background: 'url(' + prevSlideImg + ')'
        });

        $('.banner-area .owl-nav .owl-next .itemnextbg').css({
            background: 'url(' + nextSlideImg + ')'
        });

    }

    slideThumb();

    mainBannerArea.on('translate.owl.carousel', function () {
        $('.single-banner h1 span, .single-banner h1, .single-banner a').removeClass('slideInUp animated').hide();
    });

    mainBannerArea.on('translated.owl.carousel', function () {
        slideThumb();
        $('.owl-item.active .single-banner h1 span, .owl-item.active .single-banner h1, .owl-item.active .single-banner a').addClass('slideInUp animated').show();
    });

/*  ======================================
    Banner Slide Two
    ====================================== */

    var mainBannerAreaTwo = $('.banner-area-two');

    mainBannerAreaTwo.owlCarousel({
        items: 1,
        loop: true,
        dots: false,
        thumbs: false,
        nav: true,
        navText: ['<i class="fa fa-angle-left" aria-hidden="true"></i><div class="itemprebg"></div>', '<div class="itemnextbg"></div><i class="fa fa-angle-right" aria-hidden="true"></i>'],
        mouseDrag: false,
        autoplay: true,
        autoplayTimeout: 6000 // auto play time
    });

    var itemBg = $('.itembgtwo');

    $('.banner-area-two .single-banner').each(function () {
        var itmeImg = $(this).find('.itembgtwo img').attr('src');
        $(this).css({
            background: 'url(' + itmeImg + ')'
        });
    });

    function slideThumbTwo() {

        $('.banner-area-two .owl-item').removeClass('next prev');

        var currenSlide = $('.banner-area-two .owl-item.active');
        currenSlide.next('.owl-item').addClass('next');
        currenSlide.prev('.owl-item').addClass('prev');

        var nextSlideImg = $('.owl-item.next').find('.itembgtwo img').attr('src');
        var prevSlideImg = $('.owl-item.prev').find('.itembgtwo img').attr('src');

        $('.banner-area-two .owl-nav .owl-prev .itemprebg').css({
            background: 'url(' + prevSlideImg + ')'
        });

        $('.banner-area-two .owl-nav .owl-next .itemnextbg').css({
            background: 'url(' + nextSlideImg + ')'
        });

    }

    slideThumbTwo()

    mainBannerAreaTwo.on('translate.owl.carousel', function () {
        $('.single-banner h1 span, .single-banner h1, .single-banner a').removeClass('slideInUp animated').hide();
    });

    mainBannerAreaTwo.on('translated.owl.carousel', function () {
        slideThumbTwo()
        $('.owl-item.active .single-banner h1 span, .owl-item.active .single-banner h1, .owl-item.active .single-banner a').addClass('slideInUp animated').show();
    });

/*  ======================================
    Attorney Carousel
    ====================================== */

    var attorneyCarousel = $('.attorney-carousel');
    
    attorneyCarousel.owlCarousel({
        items: 2,
        loop: true,
        margin: 30,
        mouseDrag: false,
        autoplay: true,
        autoplayTimeout: 6000 // auto play time
    });

/*  ======================================
    Counter
    ====================================== */

    var counter = $('.counter');
    counter.counterUp({
        delay: 10,
        time: 1000
    });

/*  ======================================
    Progress bar
    ====================================== */
    var $progress = $('.barfiller');

	$progress.waypoint(function () {

		/*** Progress Bar ***/
		var skillOne = $('#bar1');
		var skillTwo = $('#bar2');
		var skillThree = $('#bar3');
		var skillFour = $('#bar4');

		skillOne.barfiller({
			barColor: '#3c8dbc',
		});
		skillTwo.barfiller({
			barColor: '#3c8dbc',
		});
		skillThree.barfiller({
			barColor: '#3c8dbc',
		});
		skillFour.barfiller({
			barColor: '#3c8dbc',
		});

		this.destroy();

	}, {
		offset: '80%'
	});

/*  ======================================
    Contact us map
    ====================================== */

    if ($('#contact-map').length > 0){

        var myCenter = new google.maps.LatLng(43.8619274,125.3755957);

        function initialize() {
            var mapProp = {
                zoom: 12,
                center: myCenter,
                disableDefaultUI: true,
                scrollwheel: false,
                mapTpeIdy: google.maps.MapTypeId.ROADMAP
            };
            var map = new google.maps.Map(document.getElementById("contact-map"), mapProp);
            // Marker js
            var marker = new google.maps.Marker({
                position : new google.maps.LatLng(43.8619274,125.3755957),
                map : map
            });
        }
        google.maps.event.addDomListener(window, 'load', initialize);

    }

/*  ======================================
    History carousel
    ====================================== */

    var historycaro = $('.history-carousel');

    historycaro.owlCarousel({
        loop: true,
        items: 1,
        thumbs: true,
        thumbImage: false,
        dots: false,
        thumbContainerClass: 'owl-thumbs',
        thumbItemClass: 'owl-thumb-item'
    });

/*  ======================================
    Banner Slide
    ====================================== */

    var gallerywidget = $('.img-gallery-widget');

    gallerywidget.owlCarousel({
        items: 1,
        loop: true,
        thumbs: false,
        autoplay: true,
        autoplayTimeout: 6000 // auto play time
    });

/*  ======================================
    Popup video
    ====================================== */
    
    var videBg = $('.video-btn');
    videBg.YouTubePopUp({
        autoplay: 1
    });

    $(window).on('load', function () {

        /*  ======================================
            Preloader
            ====================================== */

        /*  ======================================
            Portfolio
            ====================================== */

        $('.portfolio-menu button').on('click', function () {
            $('.portfolio-menu button').removeClass('active-portfolio');
            $(this).addClass('active-portfolio');
        });

        var $container = $('.portfolio-container');
        $container.isotope({
            itemSelector: '.portfolio-container .single-portfolio'
        });

        // MASONRY

        var $container = $('.portfolio-container-masonry');
        $container.isotope({
            itemSelector: '.portfolio-container-masonry .single-portfolio-width-two',
            percentPosition: true,
            masonry: {
                // use outer width of grid-sizer for columnWidth
                columnWidth: 1
            }
        });

        $('#filters').on('click', 'button', function () {
            var filterValue = $(this).attr('data-filter');
            $container.isotope({
                filter: filterValue
            });
            return false;
        });

        // imagesLoaded

        //var masonryLoaded = $('.portfolio-container-masonry');
        //masonryLoaded.imagesLoaded(function () {
            // images have loaded
        //});

    });

}(jQuery));
