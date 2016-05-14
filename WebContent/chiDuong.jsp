<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chỉ đường</title>

<link rel="stylesheet" href="css/map.css" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="http://maps.googleapis.com/maps/api/js?sensor=false&libraries=geometry"></script>

<script type="text/javascript">
	var map;
	var tim="";
	var madiadiem = "<bean:write name="diaDiemForm" property="maDiaDiem"/>";
	var loai = "<bean:write name="diaDiemForm" property="loaiDiaDiem"/>";
	var data;
	function createJSON(json){
		data=json;
	}
			 var xhReq = new XMLHttpRequest();
			xhReq.open("POST", "JSON.jsp?tim="+tim+"&mode="+loai, false);
			xhReq.send(tim,loai);
			var jsonObject = JSON.parse(xhReq.responseText); 
			
			/* $(document).ready(function () {
				 $.ajax({
			         type: "POST",
			         url: "JSON.jsp?tim="+tim+"&mode="+mode,
			         data: pra,
			         dataType: "json",
			         success: function(json){
			         createJSON(json);
			
			         },
			
			     });
				
					
				
			
			}); */
		/* 	var string = JSON.stringify(data);
			
			var data = eval(eval(string));
			console.log(data); */
			var data;
			function createJSON(json){
				console.log(json);
				data=json;
				console.log(data);
			}
			data=eval(data);
			
			data = jsonObject;
			 console.log(data); 
		
	function createMap() {
		var map_canvas = document.getElementById('google-map');
		var directionsDisplay = new google.maps.DirectionsRenderer;
		var directionsService = new google.maps.DirectionsService;
		// Option map
		navigator.geolocation
				.getCurrentPosition(
						function(position) {
							var here = new google.maps.LatLng(
									position.coords.latitude,
									position.coords.longitude);
							
							//alert(position.coords.latitude);
							document.getElementById("long").value = position.coords.longitude;
							directionsDisplay.setMap(map);

							for ( var i in data) {

								//alert(data[parseInt(i)].ten);

								if (data[parseInt(i)].ma == madiadiem) {

									var dt = {
										origin : new google.maps.LatLng(
												position.coords.latitude,
												position.coords.longitude),
										destination : new google.maps.LatLng(
												data[parseInt(i)].lat,
												data[parseInt(i)].longi),
										travelMode : google.maps.TravelMode.DRIVING
									};
									directionsService
											.route(
													dt,
													function(response, status) {
														if (status == google.maps.DirectionsStatus.OK) {
															directionsDisplay
																	.setDirections(response);
														} else {
															window
																	.alert('Directions request failed due to '
																			+ status);
														}
													});
								}
							}
							map.setCenter(here);
						}, function() {
							handleNoGeolocation(true);
						});

		var map_options = {
			// Tọa độ thành phố Hà Nội
			zoom : 15,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};

		// Đối tương map
		map = new google.maps.Map(map_canvas, map_options);
	}

	// Class StoreBubble

	function chiduong() {

		for ( var i in data) {

			console.log(data[parseInt(i)].ma);

			if (data[parseInt(i)].ma == madd && data[parseInt(i)].maloai) {
				var pos = new google.maps.LatLng(data[parseInt(i)].lat,
						data[parseInt(i)].longi);
				var data = {
					origin : pos,
					destination : new google.maps.LatLng(document
							.getElementById("lat").value, document
							.getElementById("long").value),
					travelMode : google.maps.TravelMode.DRIVING
				};
				directionsService.route(data, function(response, status) {
					if (status == google.maps.DirectionsStatus.OK) {
						directionsDisplay.setDirections(response);
					} else {
						window.alert('Directions request failed due to '
								+ status);
					}
				});
			}

		}

	}

	//console.log(document.getElementById("lat").value);

	//console.log(document.getElementById("lat").value);	
	
	/*  marker.addListener('click', function() {
		
		navigator.geolocation.getCurrentPosition(function(position) {
			var here = new google.maps.LatLng(position.coords.latitude,
					position.coords.longitude);
			
			var distance = google.maps.geometry.spherical
					.computeDistanceBetween(marker.getPosition(), new google.maps.LatLng(document.getElementById("lat").value,
							document.getElementById("long").value));
			console.log(document.getElementById("lat").value);			
			
		});
	
	}); */
	function calculateAndDisplayRoute(directionsService, directionsDisplay) {

		var fromLatitude = 16.021494;
		var fromLongitude = 108.209638;

		var toLatitude = 21.014199;
		var toLongitude = 105.848317;

		console.log(toLatitude);
		var data = {
			origin : new google.maps.LatLng(fromLatitude, fromLongitude),
			destination : new google.maps.LatLng(toLatitude, toLongitude),
			travelMode : google.maps.TravelMode.DRIVING
		};
		directionsService.route(data
		/* origin:    {lat: 16.021494, lng: 108.209638},  // new google.maps.LatLng(document.getElementById("lat") ,document.getElementById("long")),  Haight.
		destination: {lat: 16.018596, lng: 108.212395},  // Ocean Beach., , 
		// Note that Javascript allows us to access the constant
		// using square brackets and a string value as its
		// "property."
		travelMode: google.maps.TravelMode[selectedMode]
		 */, function(response, status) {
			if (status == google.maps.DirectionsStatus.OK) {
				directionsDisplay.setDirections(response);
			} else {
				window.alert('Directions request failed due to ' + status);
			}
		});
	}
	var pos = new google.maps.LatLng();
	var infowindow = new google.maps.InfoWindow();

	$(function() {
		createMap();

		//console.log(document.getElementById("lat").value);
	});
</script>
<script>
	
</script>
</head>
<body>
	<input type="hidden" id="long" size="20" name="long">
	<input type="hidden" id="lat" size="20">




	<div id="google-map" style="width: 100vw; height: 99vh;"></div>
	
</body>
</html>

