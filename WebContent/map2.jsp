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


<script type="text/javascript" src="js/diadiemkc1.json"></script>
<script type="text/javascript">
	var map;
/* 	var string = JSON.stringify(data);
	
	var data = eval(eval(string));
	console.log(data); */
	var data;
	function createJSON(json){
		data=json;
	}
	
	 $.ajax({
         type: "GET",
         url: "JSON.jsp",
         dataType: "json",
         success: function(json){
         createJSON(json);

         },

         });
	 data=eval(data);
	 
	function createMap() {
		var map_canvas = document.getElementById('google-map');

	// Option map
	navigator.geolocation.getCurrentPosition(function(position) {
		var here = new google.maps.LatLng(position.coords.latitude,
				position.coords.longitude);
		var day = new google.maps.Marker({
			position : here,
			map : map,
			title : "ok",
			icon : 'http://localhost:8080/MSS/img/me.png'

		});
		
		for(var i in data){
			var kc=google.maps.geometry.spherical.computeDistanceBetween
			(new google.maps.LatLng(data[parseInt(i)].lat, data[parseInt(i)].longi), new google.maps.LatLng(position.coords.latitude, position.coords.longitude));
			
			data[parseInt(i)].kc= Math.round(parseFloat(kc)/100)/10;
			var kt= document.getElementById("kcmadd"+data[parseInt(i)].ma);
			if(kt!=null){
			document.getElementById("kcmadd"+data[parseInt(i)].ma).innerHTML=data[parseInt(i)].kc; 
			console.log(document.getElementById("kcmadd"+data[parseInt(i)].ma).innerHTML);
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

	function addMarker(data, map) {
		
		var directionsDisplay = new google.maps.DirectionsRenderer;
        var directionsService = new google.maps.DirectionsService;
        var pos = new google.maps.LatLng(data.lat, data.longi);
		var marker = new google.maps.Marker({
			position : pos,
			map : map,
		
			animation : google.maps.Animation.DROP
		});
		if(data.loai=="2"){
			marker.setIcon('http://localhost:8080/MSS/img/thuoc.png');
		}
		if(data.loai=="3"){
			marker.setIcon('http://localhost:8080/MSS/img/pk.png');
		}
		if(data.loai=="1"){
			marker.setIcon('http://localhost:8080/MSS/img/bv.png');
		}
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
		function bigImg(madd,loai) {
			
			 for(var i in data){
				var id="#madd"+madd+ "loai" +loai;
					 if(data[parseInt(i)].ma==madd && data[parseInt(i)].loai){
						 var pos = new google.maps.LatLng(data[parseInt(i)].lat, data[parseInt(i)].longi);
						 var marker = new google.maps.Marker({
							 position: pos,
							 map: map,
							 visible : false,
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
		
		
		
	/* $(function() {
		createMap();

		 //console.log(document.getElementById("lat").value);
		 for ( var i in data) {
			new addMarker(data[parseInt(i)], map);
		} 
	}); */
	
	function load(){
		createMap();
		for ( var i in data) {
			var kt= document.getElementById("kcmadd"+data[parseInt(i)].ma);
			if(kt!=null){
				new addMarker(data[parseInt(i)], map);
			}
		} 
		document.getElementById('mode').addEventListener('change', function(){
		
		if(document.getElementById('mode').value==1){
			createMap();
		 for ( var i in data) {
			 if(data[parseInt(i)].loai=="1"){
			new addMarker(data[parseInt(i)], map);
				}}
			} 
		else if(document.getElementById('mode').value==2){
			createMap();
			for ( var i in data) {
				 if(data[parseInt(i)].loai=="2"){
				new addMarker(data[parseInt(i)], map);
					}}
				}
		else if(document.getElementById('mode').value==3){
			createMap();
			for ( var i in data) {
				 if(data[parseInt(i)].loai=="3"){
				new addMarker(data[parseInt(i)], map);
					}}
				} 
		else 
			for ( var i in data) {
					new addMarker(data[parseInt(i)], map);
						}
		
		});
	}
	
</script>


</head>
<body>
	
	<input type="hidden" id="long" size="20">



	<div
		style="z-index: 5;top:15%;left:3%; background-color: rgba(234, 234, 234, 0.91); position: absolute; width: 300px; height: 450px; line-height: 3em; overflow: auto; background: white; box-shadow: 0 2px 6px rgba(0,0,0,.3);" >
		<div style="padding: 10px; background: whitesmoke;">
            <span class="results-heading-title"><h3>Kết quả tìm kiếm</h3></span>
        </div>
        <div>
		<logic:iterate name="diaDiemForm" property="listDiaDiem" id="tb">
			<bean:define id="madd" name="tb" property="maDiaDiem"></bean:define>
			<bean:define id="loai1" name="tb" property="loai"></bean:define>

			<div class="listDiaDiem"  style="padding: 10px; border-bottom: 1px solid #dedede;">
			<div onmouseover="bigImg(${madd},${loai1})"
				 id="madd${madd}loai${loai1}" boder="double">
				<a href="thongTinTKChiTiet.do?tenDangNhap=<bean:write name="tb" property="tenDangNhap" />"><h3>
						<logic:equal name="tb" property="loai" value="1">Bệnh Viện 
					</logic:equal>
						<logic:equal name="tb" property="loai" value="2">Nhà Thuốc 
					</logic:equal>
						<logic:equal name="tb" property="loai" value="3">Phòng Khám 
					</logic:equal>
					<bean:write name="tb" property="ten" />
					</h3> 
				</a>
					<p>
				<img src="img/address.png">
				<bean:write name="tb" property="diaChi" /></p>
				
				<img src="img/phone.png">
				<bean:write name="tb" property="sdt" />
				
				<div id="kcmadd${madd}"></div>

				<%-- <p id= "logg"><bean:write  name="tb" property="longi" /></p>
				<p><bean:write  name="tb" property="lati" /></p> --%>
				<a href="/MSS/chi-duong.do?maDiaDiem=${madd}&loai=${loai1}">chỉ
					đường</a>
			</div>

			</div>
		</logic:iterate>
		</div>
	</div>
	
<html:form action="/ban-do" method="get">
<b>Tìm theo </b> <html:select property="loaiDiaDiem" styleId="mode">
			<html:option value="0">Tất cả</html:option>
			<html:option value="1">Bệnh viện</html:option>
			<html:option value="2">Tiệm thuốc</html:option>
			<html:option value="3">Phòng Khám</html:option>
		</html:select>
	<input type="text" id="test" size="20" name="search">
	<html:submit property="submit" value="search" >
	</html:submit>
	<div id="google-map" style="width: 1400px; height: 600px;"></div>
	<div id="floating-panel" style="z-index: 5;">
	
		<b>Tìm theo </b> <html:select property="loaiDiaDiem" styleId="mode">
			<html:option value="0">Tất cả</html:option>
			<html:option value="1">Bệnh viện</html:option>
			<html:option value="2">Tiệm thuốc</html:option>
			<html:option value="3">Phòng Khám</html:option>
		</html:select>
	</div>
	<script type="text/javascript">
	
	$("#mode").change(function(){
		alert(document.getElementById("mode").value);
		var t = ""+document.getElementById("mode").value;
		if(t=="0"){
			$("div #benhVien").show();
			$("div #phongKham").show();
			$("div #nhaThuoc").show();
		}
		if(t=="1"){
		$("div #benhVien").hide();
		$("div #phongKham").hide();
		$("div #nhaThuoc").hide();
			
		}
		if(t=="3"){
			$("div #benhVien").hide();
			$("div #nhaThuoc").hide();
			$("div #phongKham").show();
		}	
		if(t=="2"){
			$("div #nhaThuoc").show();
			$("div #benhVien").hide();
			$("div #phongKham").hide();
		}	
	});
	</script>

	
	<script type="text/javascript"
		src="http://maps.googleapis.com/maps/api/js?sensor=false&libraries=geometry&callback=load"></script>
		</html:form>
</body>
</html>