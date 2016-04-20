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
<title>Insert title here</title>

<link rel="stylesheet" href="css/map.css" />
<link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css" />
<link rel="stylesheet" href="css/jquery.mCustomScrollbar.css" />
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="http://maps.googleapis.com/maps/api/js?sensor=false&libraries=geometry"></script>

<script type="text/javascript" src="js/diadiemkc.json"></script>
<script type="text/javascript">
	var map;
	

	
	var string = JSON.stringify(data);
	
	var data = eval(eval(string));
	console.log(data);
	
	function createMap() {var map_canvas = document.getElementById('google-map');

	// Option map
	var t;
	navigator.geolocation.getCurrentPosition(function(position) {
		var here = new google.maps.LatLng(position.coords.latitude,
				position.coords.longitude);
		var day = new google.maps.Marker({
			position : here,
			map : map,
			title : "ok"

		});
		for(var i in data){
			var kc=google.maps.geometry.spherical.computeDistanceBetween
			(new google.maps.LatLng(data[parseInt(i)].lat, data[parseInt(i)].longi), new google.maps.LatLng(position.coords.latitude, position.coords.longitude));
			
			data[parseInt(i)].kc= Math.round(parseFloat(kc)/100)/10;
			var id="#kcmadd"+data[parseInt(i)].ma;
			document.getElementById("kcmadd"+data[parseInt(i)].ma).innerHTML=data[parseInt(i)].kc;
			console.log(id);
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
	map = new google.maps.Map(map_canvas, map_options);	}
	
	// Class StoreBubble

	function addMarker(data, map) {
		
		var directionsDisplay = new google.maps.DirectionsRenderer;
        var directionsService = new google.maps.DirectionsService;
        var pos = new google.maps.LatLng(data.lat, data.longi);
		var marker = new google.maps.Marker({
			position : pos,
			map : map,
			animation : google.maps.Animation.DROP
		});
		 var infowindow = new google.maps.InfoWindow()

        
        var content = data.ten;
        google.maps.event.addListener(marker, 'mouseover', (function (marker, content, infowindow) {
            return function () {
                infowindow.setContent(content);
                infowindow.open(map, marker);
            };
        })(marker, content, infowindow));
        google.maps.event.addListener(marker, 'mouseout', (function (marker, content, infowindow) {
            return function () {
                infowindow.close();
            };
        })(marker, content, infowindow));

        
       
      } 

      //console.log(document.getElementById("lat").value);
      
		//console.log(document.getElementById("lat").value);	
		/* var pos = new google.maps.LatLng(data.latitude, data.longtitude);
		var marker = new google.maps.Marker({
			position : pos,
			map : map,
			animation : google.maps.Animation.DROP
		}); */
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
		
/* 	  function calculateAndDisplayRoute(directionsService, directionsDisplay) {
      
        var fromLatitude =  16.021494;
        var fromLongitude = 108.209638;
        
        var toLatitude = 21.014199;
        var toLongitude = 105.848317;
       
        console.log(toLatitude);
        var data={
        	    origin: new google.maps.LatLng(fromLatitude, fromLongitude),
        	    destination: new google.maps.LatLng(toLatitude, toLongitude),
        	    travelMode: google.maps.TravelMode.DRIVING
        	};
        directionsService.route(data, function(response, status) {
          if (status == google.maps.DirectionsStatus.OK) {
            directionsDisplay.setDirections(response);
          } else {
            window.alert('Directions request failed due to ' + status);
          }
        });
        }  */
		
		
		function bigImg(madd,loai) {
			
			 for(var i in data){
				var id="#hungNgumadd"+madd+ "loai" +loai;
					 if(data[parseInt(i)].ma==madd && data[parseInt(i)].loai){
						 var pos = new google.maps.LatLng(data[parseInt(i)].lat, data[parseInt(i)].longi);
						 var marker = new google.maps.Marker({
							 position: pos,
							 map: map,
						 });
						 var infowindow = new google.maps.InfoWindow();
						 
						 var content = data[parseInt(i)].ten;
						 
						 infowindow.setContent(content);
						 infowindow.open(map,marker);
						 
						       
						 
						 
						   
						 map.setCenter(pos);
						 //return marker;
						 $(id).mouseout(function(){
						       infowindow.close();
						    });
					} 
				} 
			
}
		function outmouse(madd,loai) {
			bigImg(madd,loai).inforwindow.close();
		}
		
	$(function() {
		createMap();

		 //console.log(document.getElementById("lat").value);
		 for ( var i in data) {
			new addMarker(data[parseInt(i)], map);
		} 
	});
	
	
	
</script>


</head>
<body>
	<input type="hidden" id="long" size="20">
	<input type="text" id="lat" size="20">


	<div
style="z-index: 5; background-color: rgba(234, 234, 234, 0.91); position: absolute; width: 300px; height: 450px; line-height: 3em; overflow: auto; padding: 5px; border: double;">
		<h1>List Address</h1>
		<hr style="border-top: 5px solid #2B2626">
		<logic:iterate name="diaDiemForm" property="listDiaDiem" id="tb">
			<bean:define id="madd" name="tb" property="maDiaDiem"></bean:define>
			<bean:define id="loai1" name="tb" property="loai"></bean:define>
			<div onmouseover="bigImg(${madd},${loai1})"
				 id="hungNgumadd${madd}loai${loai1}" boder="double">
				<h3>
					<logic:equal name="tb" property="loai" value="1">Ten Benh Vien:<br>
					</logic:equal>
					<logic:equal name="tb" property="loai" value="2">Ten Nha Thuoc:<br>
					</logic:equal>
					<logic:equal name="tb" property="loai" value="3">Ten Phong Kham: <br>
					</logic:equal>
					<bean:write name="tb" property="ten" />
				</h3>
				Dia Chi:
				<bean:write name="tb" property="diaChi" />
				<br> So Dien Thoai:
				<bean:write name="tb" property="sdt" />
				<div id="kcmadd${madd}" ></div>
				<br>

				<%-- <p id= "logg"><bean:write  name="tb" property="longi" /></p>
				<p><bean:write  name="tb" property="lati" /></p> --%>
				<a href="/Caps2/chi-duong.do?maDiaDiem=${madd}&loai=${loai1}">chỉ
					đường</a>
				
			</div>


			<hr style="border-top: 5px solid #2B2626">
		</logic:iterate>
	</div>

	<div id="google-map" style="width: 1400px; height: 600px;"></div>
</body>
</body>
</html>