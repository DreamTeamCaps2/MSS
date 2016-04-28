<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>Sửa sinh viên</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" />

<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/diadiemkc.json"></script>
<link href="js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
<script type="text/javascript"
	src="http://maps.googleapis.com/maps/api/js?sensor=false&libraries=geometry"></script>
<script>
	var string = JSON.stringify(data);

	var data = eval(eval(string));
	var kca = new Array();

	navigator.geolocation
			.getCurrentPosition(
					function(position) {
						var here = new google.maps.LatLng(
								position.coords.latitude,
								position.coords.longitude);

						for ( var i in data) {
							var kc = google.maps.geometry.spherical
									.computeDistanceBetween(
											new google.maps.LatLng(
													data[parseInt(i)].lat,
													data[parseInt(i)].longi),
											new google.maps.LatLng(
													position.coords.latitude,
													position.coords.longitude));

							data[parseInt(i)].kc = Math
									.round(parseFloat(kc) / 100) / 10;

							var id = "#kcmadd" + data[parseInt(i)].ma;
							var kt = document.getElementById("kcmadd"
									+ data[parseInt(i)].ma);
							if (kt != null) {
								document.getElementById("kcmadd"
										+ data[parseInt(i)].ma).innerHTML = data[parseInt(i)].kc;
								console.log(document.getElementById("kcmadd"
										+ data[parseInt(i)].ma).innerHTML);
							}
						}
						for ( var i in data) {
							for ( var j in data) {
								var t;
								var maTiem = document.getElementById("maTiem").value;
								console.log(maTiem);
								if (parseFloat(data[parseInt(j)].kc) > parseFloat(data[parseInt(i)].kc)) {
									t = data[parseInt(i)]
									data[parseInt(i)] = data[parseInt(j)];
									data[parseInt(j)] = t;

								}
							}
						}
						console.log(data);
						var str = "";
						for ( var i in data) {
							kca[i * 2] = data[parseInt(i)].ma;

						}
						for ( var i in kca) {

							var str = str + kca[i] + ",";

						}

						document.getElementById("kca").value = str;

					}, function() {
						handleNoGeolocation(true);
					});
</script>
</head>
<body>
	<div class="container">
		<div class="box">
			<div class="box-body">
				<html:form action="/suaSV" method="get">
					<select name="loaiDiaDiem" id="mode">
						<option value="">Sắp Xếp</option>
						<option value="1">Theo Tên</option>
						<option value="2">Theo Giá</option>
						<option value="3">Theo Khoảng Cách</option>


					</select>

					<input id="maTiem" type="hidden" name="msv"
						value="<bean:write name="danhSachGiaForm" property="msv" />">
					<script type="text/javascript">
						/* $("[name='loaiDiaDiem']").val('<bean:write name="danhSachGiaForm" property="loaiDiaDiem"/>'); */
					</script>
					<input type="hidden" id="kca" name="kc">
					<html:submit>Xem</html:submit>

						<logic:iterate name="danhSachGiaForm" property="listGiaThuoc"
							id="tk">
							<bean:define id="ma" name="tk" property="maTiem"></bean:define>
							<div>
								<bean:write name="tk" property="tenTiem" />
							</div>
							<div>
								<bean:write name="tk" property="giaThuoc" />
							</div>
							<div id="kcmadd${ma}"></div>
							<br>

						</logic:iterate>
				</html:form>
			</div>

		</div>

	</div>

</body>
</html>