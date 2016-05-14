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
<title>Bản Đồ</title>
 <link rel="stylesheet" href="css/style_mss.css" />
<link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css" />
<link rel="stylesheet" href="css/jquery.mCustomScrollbar.css" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>


<script type="text/javascript">
var tim= '<bean:write name="diaDiemForm" property="search" />'
	tim = decodeURIComponent(escape(tim));
//tim = encodeURIComponent(tim);
var mode='<bean:write name="diaDiemForm" property="loaiDiaDiem" />'
var pra= tim +","+ mode;
	 var xhReq = new XMLHttpRequest();
	xhReq.open("POST", "JSON.jsp?tim="+tim+"&mode="+mode, false);
	xhReq.send(tim,mode);
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
	console.log(pra);
	var map;
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
			document.getElementById("kcmadd"+data[parseInt(i)].ma).innerHTML= "Khoảng Cách: "+data[parseInt(i)].kc+" Km"; 
			//console.log(document.getElementById("kcmadd"+data[parseInt(i)].ma).innerHTML);
			}
		}
		map.setCenter(here);
	}, function() {
		handleNoGeolocation(true);
	});
	
	var map_options = {
		// Tọa độ thành phố Hà Nội
		zoom : 14,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	};
	
	// Đối tương map
	map = new google.maps.Map(map_canvas, map_options);	
	
	
	
         
	
	
	 }
	/* $(document).ready(function(){
		$("#mode").on('change', function() {
			 var xhReq = new XMLHttpRequest();
				xhReq.open("POST", "JSON.jsp?tim="+""+"&mode="+document.getElementById('mode').value, false);
				xhReq.send(tim,mode);
				var jsonObject = JSON.parse(xhReq.responseText); 
				
				
				console.log(pra);
				var map;
				var data;
				function createJSON(json){
					console.log(json);
					data=json;
					console.log(data);
				}
				data=eval(data);
				
				data = jsonObject;
				 console.log(data); 
			
				var t = "" + document.getElementById("mode").value;
			window.location.assign("/MSS/ban-do.do?loaiDiaDiem=" + t
						+ "&search=?")	 
			
			if(document.getElementById('mode').value=="1"){
				createMap();
			 for ( var i in data) {
				 
				new addMarker(data[parseInt(i)], map);
					}}
				
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
				createMap();
				for ( var i in data) {
						new addMarker(data[parseInt(i)], map);
							}
		}
	);
	}); */
	
	
	// Class StoreBubble

	function addMarker(data, map) {
		
		var directionsDisplay = new google.maps.DirectionsRenderer;
        var directionsService = new google.maps.DirectionsService;
        var pos = new google.maps.LatLng(data.lat, data.longi);
		var marker = new google.maps.Marker({
			position : pos,
			map : map,
			zIndex: 4,
		
			animation : google.maps.Animation.DROP
		});
		if(data.loai=="1"){
			
			marker.setIcon('http://localhost:8080/MSS/img/bv.png');
			 var infowindow = new google.maps.InfoWindow()
			 var infowindow1= new google.maps.InfoWindow()
			 var content='<h4>'+data.ten+'</h4>'+	'Địa chỉ: ' +   data.diachi+'<br><p>Số Điện Thoại: '+data.sdt+'</p';
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
		        
		        google.maps.event.addListener(marker, 'click', (function (marker, content, infowindow1) {
		            return function () {
		            	 infowindow1.setContent(content);
		                 infowindow1.open(map, marker);
		            };
		        })(marker, content, infowindow1));}
		else
			{if(data.loai=="2"){
			marker.setIcon('http://localhost:8080/MSS/img/thuoc.png');
		}
		if(data.loai=="3"){
			marker.setIcon('http://localhost:8080/MSS/img/pk.png');
		}
		
		 var infowindow = new google.maps.InfoWindow()
		 var infowindow1= new google.maps.InfoWindow()

		 var content='<h4><a href="/MSS/thongTinTKChiTiet.do?tenDangNhap='+data.tendangnhap+'">'+ data.ten+'</a></h4>'+	'Địa chỉ: ' +   data.diachi+'<br><p>Số Điện Thoại: '+data.sdt+'</p';
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
        
        google.maps.event.addListener(marker, 'click', (function (marker, content, infowindow1) {
            return function () {
            	 infowindow1.setContent(content);
                 infowindow1.open(map, marker);
            };
        })(marker, content, infowindow1));

			}
       
      } 
		function bigImg(madd,loai,tenDN) {
			//alert(tenDN);
			 for(var i in data){
				 
				var id="#madd"+madd+ "loai" +loai;
					 if(data[parseInt(i)].ma==madd && data[parseInt(i)].loai==loai){
						 var pos = new google.maps.LatLng(data[parseInt(i)].lat, data[parseInt(i)].longi);
						 var marker = new google.maps.Marker({
							 position: pos,
							 map: map,
							 zIndex: 9,
							
						 });
						 if(loai=="1"){
								
								marker.setIcon('http://localhost:8080/MSS/img/bvon.png');}
							if(loai=="2"){
								marker.setIcon('http://localhost:8080/MSS/img/thuocon.png');
							}
							if(loai=="3"){
								marker.setIcon('http://localhost:8080/MSS/img/pkon.png');
							}
						/*  var infowindow = new google.maps.InfoWindow();
						 
						 var te= '<a href="/MSS/chi-duong.do?maDiaDiem='+data[parseInt(i)].ma+"&loai="+data[parseInt(i)].loai+'">';
						 var trr ='<a href="/MSS/thongTinTKChiTiet.do?tenDangNhap='+tenDN+'">';
						 console.log(trr);
						 console.log(te);
						// var content = '<a href="/MSS/chi-duong.do?maDiaDiem='+data[parseInt(i)].ma+"&loai="+data[parseInt(i)].loai+'">'+ data[parseInt(i)].ten+'</a>';
						var content='<h4><a href="/MSS/thongTinTKChiTiet.do?tenDangNhap='+tenDN+'">'+ data[parseInt(i)].ten+'</a></h4>'+	'<img src="img/address.png">' +   data[parseInt(i)].diachi+'</p>';
								
								
									
						 
						 infowindow.setContent(content);
						// infowindow.open(map,marker);
						
						 
						       
						 
						 
						    */
						 map.setCenter(pos);
						 //return marker;
						  $(id).mouseout(function(){
						       //infowindow.close();
						    marker.setVisible(false);
							   
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
		var mod='<bean:write name="diaDiemForm" property="loaiDiaDiem" />'
	
		if(tim.length==0){
			console.log(document.getElementById('mode').value);
		
		if(mod=="1"){
			createMap();
			
			console.log(document.getElementById('mode').value);
		  for ( var i in data) {
			 if(data[parseInt(i)].loai=="1"){
			new addMarker(data[parseInt(i)], map);
				}} 
			} 
		else if(mod=="2"){
			createMap();
			console.log(document.getElementById('mode').value);
			for ( var i in data) {
				 if(data[parseInt(i)].loai=="2"){
				new addMarker(data[parseInt(i)], map);
					}}
				}
		else if(mod=="3"){
			createMap();
			for ( var i in data) {
				 if(data[parseInt(i)].loai=="3"){
				new addMarker(data[parseInt(i)], map);
					}}
				} 
		else {
			createMap();
		console.log(document.getElementById('mode').value);
			for ( var i in data) {
					new addMarker(data[parseInt(i)], map);
			}	
						}
		}
		else
		{

			console.log(document.getElementById('mode').value);
		
		if(document.getElementById('mode').value=="1"){
			createMap();
			
		  for ( var i in data) {
			 if(data[parseInt(i)].loai=="1"&& data[parseInt(i)].ten.toLowerCase().contains(tim)==true){
			new addMarker(data[parseInt(i)], map);
				}} 
			} 
		else if(document.getElementById('mode').value=="2"){
			createMap();
			for ( var i in data) {
				 if(data[parseInt(i)].loai=="2"&& data[parseInt(i)].ten.toLowerCase().contains(tim)==true){
				new addMarker(data[parseInt(i)], map);
					}}
				}
		else if(document.getElementById('mode').value=="3"){
			createMap();
			for ( var i in data) {
				 if(data[parseInt(i)].loai=="3"&& data[parseInt(i)].ten.toLowerCase().contains(tim)==true){
				new addMarker(data[parseInt(i)], map);
					}}
				} 
		else if (document.getElementById('mode').value=="0"){
			createMap();
			for ( var i in data) {
					new addMarker(data[parseInt(i)], map);
			}	
						}
		}
		
			
		/* createMap();
		for ( var i in data) {
		//	var kt= document.getElementById("kcmadd"+data[parseInt(i)].ma);
		//	if(kt!=null){
				new addMarker(data[parseInt(i)], map);
			//} */
			
		 
	
	}
		function filter(madd,loai){
			createMap();
		
			 for(var i in data){
				 
						 if(data[parseInt(i)].ma==madd && data[parseInt(i)].loai==loai){
							 new addMarker(data[parseInt(i)], map);
						 }
		}
		}
	
</script>
</head>
<body style="background:#fff!important;">
	<div class="listresultcsyt">
		<div class="listDiaDiem">
			<p style="font-size:16px;padding-top:2vh;"> Kết Quả Tìm kiếm </p>
		</div>

		<logic:iterate name="diaDiemForm" property="listDiaDiem" id="tb">
			<bean:define id="madd" name="tb" property="maDiaDiem"></bean:define>
			<bean:define id="loai" name="tb" property="loai"></bean:define>
			<logic:notEmpty name="tb" property="tenDangNhap">
				<bean:define id="tenDN" name="tb" property="tenDangNhap"></bean:define>
			</logic:notEmpty>
			<div class="listDiaDiem">
				<div onmouseover="bigImg(${madd},${loai},'${tenDN}')"
					 id="madd${madd}loai${loai}">
					<a style="font-size: 16px;font-weight: 700;" href="thongTinTKChiTiet.do?tenDangNhap=<bean:write name="tb" property="tenDangNhap"  />">
						<logic:equal name="tb" property="loai" value="1">
							<p>Bệnh Viện </p>
					</logic:equal>
						<logic:equal name="tb" property="loai" value="2">Nhà Thuốc 
					</logic:equal>
						<logic:equal name="tb" property="loai" value="3">Phòng Khám 
					</logic:equal>
					
						<bean:write name="tb" property="ten" />
					</a>
						
					
					<p>
						<img src="img/address.png">
						<bean:write name="tb" property="diaChi" />
					</p>

					<img src="img/phone.png">
					<bean:write name="tb" property="sdt" />
					 
					<div id="kcmadd${madd}" style="margin-top:5px;"></div>

					<%-- <p id= "logg"><bean:write  name="tb" property="longi" /></p>
				<p><bean:write  name="tb" property="lati" /></p> --%>
					<a href="/MSS/chi-duong.do?maDiaDiem=${madd}&loai=${loai}">Chỉ
						Đường</a>
				</div>

			</div>
		</logic:iterate>
	</div>
	<html:form action="/ban-do" method="get">
		<div class="headercsyt">
			
			<div class="navbarcsyt">	
				<div style="margin-bottom: 5px;">
				<a href="/MSS/"><img src="img/me.png" alt="Map" width="50px" height="50px" style="float:left;margin-right:20px; background:transparent;">
				</a>
				</div>
				<html:select property="loaiDiaDiem" styleId="mode">
					<html:option value="0">Tất cả</html:option>
					<html:option value="1">Bệnh viện</html:option>
					<html:option value="2">Tiệm thuốc</html:option>
					<html:option value="3">Phòng Khám</html:option>
				</html:select>
				<input type="text" id="test"  name="search">
				<html:submit property="submit" value="search" style="width:12vw;" styleId="csytsubmit" styleClass="btn btn-default btn-lg">
				<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
				</html:submit>
  					

			</div>
		</div>
			<div id="google-map" style="width: 100vw; height: 89vh;"></div>
			<script type="text/javascript">
		   $("#mode").change(
				function() {

					var t = "" + document.getElementById("mode").value;
					window.location.assign("/MSS/ban-do.do?loaiDiaDiem=" + t
							+ "&search=&submit=search")
				});   
	</script>


			<script type="text/javascript"
				src="http://maps.googleapis.com/maps/api/js?sensor=false&libraries=geometry&callback=load"></script>
	</html:form>
</body>
</html>