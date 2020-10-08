
jQuery(function($) {


	/**
	 * Form Validator
	*/
	
	$('#contact-form').validator();

    $('#contact-form').on('submit', function (e) {
        if (!e.isDefaultPrevented()) {
            var url = "contact.php";

            $.ajax({
                type: "POST",
                url: url,
                data: $(this).serialize(),
                success: function (data)
                {
                    var messageAlert = 'alert-' + data.type;
                    var messageText = data.message;

                    var alertBox = '<div class="alert ' + messageAlert + ' alert-dismissable"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>' + messageText + '</div>';
                    if (messageAlert && messageText) {
                        $('#contact-form').find('.messages').html(alertBox);
                        $('#contact-form')[0].reset();
                    }
                }
            });
            return false;
        }
    })
	
	
	/**
	 * Google Map
	*/
	function initialize() {

		// Create an array of styles.
		var styles = [{"featureType":"landscape","elementType":"all","stylers":[{"hue":"#ff9800"},{"gamma":1},{"visibility":"on"}]},{"featureType":"poi","elementType":"all","stylers":[{"hue":"#ffc100"},{"saturation":33.4},{"lightness":-25.4},{"gamma":1},{"visibility":"on"}]},{"featureType":"poi","elementType":"geometry.fill","stylers":[{"color":"#ffa03f"}]},{"featureType":"poi","elementType":"labels.text.stroke","stylers":[{"color":"#f5d8c8"}]},{"featureType":"poi.attraction","elementType":"geometry.fill","stylers":[{"color":"#ff9506"},{"visibility":"off"}]},{"featureType":"poi.government","elementType":"labels.text.fill","stylers":[{"hue":"#ffb000"}]},{"featureType":"poi.park","elementType":"geometry.fill","stylers":[{"saturation":"-34"},{"color":"#f3a25c"},{"visibility":"on"}]},{"featureType":"poi.park","elementType":"labels.text.stroke","stylers":[{"color":"#f6dbc3"},{"visibility":"on"}]},{"featureType":"poi.sports_complex","elementType":"geometry.fill","stylers":[{"color":"#e97a0a"}]},{"featureType":"poi.sports_complex","elementType":"labels.text.stroke","stylers":[{"color":"#f9e2cb"}]},{"featureType":"road.highway","elementType":"all","stylers":[{"hue":"#53FF00"},{"saturation":-73},{"lightness":40},{"gamma":1}]},{"featureType":"road.arterial","elementType":"all","stylers":[{"hue":"#FBFF00"},{"gamma":1}]},{"featureType":"road.local","elementType":"all","stylers":[{"hue":"#00FFFD"},{"lightness":30},{"gamma":1}]},{"featureType":"water","elementType":"all","stylers":[{"saturation":6},{"lightness":8},{"gamma":1},{"color":"#78c7e5"}]}];

		var loc, map, marker, infobox;

		var styledMap = new google.maps.StyledMapType(styles,  {name: "Styled Map"});

		loc = new google.maps.LatLng($("#map").attr("data-lat"), $("#map").attr("data-lon"));

		map = new google.maps.Map(document.getElementById("map"), {
			zoom: 15,
			center: loc,
			scrollwheel: false,
			//draggable:true,
			navigationControl: false,
			scaleControl: false,
			mapTypeControl:false,
			streetViewControl: false,
			mapTypeControlOptions: {
				mapTypeIds: [google.maps.MapTypeId.ROADMAP, 'map_style']
			},
			mapTypeId: google.maps.MapTypeId.ROADMAP,
		});

		//Associate the styled map with the MapTypeId and set it to display.
		map.mapTypes.set('map_style', styledMap);
		map.setMapTypeId('map_style');

		marker = new google.maps.Marker({
			map: map,
			position: loc,
			//disableDefaultUI:true,

			icon:'images/map-marker/00.png',
			//pixelOffset: new google.maps.Size(-140, -100),
			visible: true

			//animation: google.maps.Animation.DROP
		});

		infobox = new InfoBox({
			content: document.getElementById("infobox"),
			disableAutoPan: true,
			//maxWidth: 150,
			pixelOffset: new google.maps.Size(0, -50),
			zIndex: null,
			alignBottom: true,
			isHidden: false,
			//closeBoxMargin: "12px 4px 2px 2px",
			closeBoxURL: "images/infobox-close.png",
			closeBoxClass:"infoBox-close",
			infoBoxClearance: new google.maps.Size(1, 1)
		});

		openInfoBox(marker);

		google.maps.event.addListener(marker, 'click', function() {
			openInfoBox(this);
		});

		function openInfoBox(thisMarker){
			map.panTo(loc);
			map.panBy(0,-50);
			infobox.open(map, thisMarker);
		}

		var center;
		function calculateCenter() {
			center = map.getCenter();
		}
		google.maps.event.addDomListener(map, 'idle', function() {
			calculateCenter();
		});
		google.maps.event.addDomListener(window, 'resize', function() {
			map.setCenter(center);
		});

	}
	google.maps.event.addDomListener(window, 'load', initialize);

});

