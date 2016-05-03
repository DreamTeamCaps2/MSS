
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<%@ include file="login.jsp"%>
<head lang="en">
<meta charset="UTF-8">

<title>Danh Sách Trung Tâm Y Tế</title>

<script>
	var loai = document.getElementById("mode");
	var data = <bean:write name="diaDiemForm" property="loaiDiaDiem" />
	if (data == "1") {

	}
</script>
</head>
<body>
	<div
		style="background-color: rgba(234, 234, 234, 0.91); position: absolute; width: 50%; left: 25%; top: 25%; line-height: 3em; overflow: auto; padding: 5px;">
		<h1>Danh Sách Các Trung Tâm Y Tế</h1>
		<hr>

		<logic:iterate name="diaDiemForm" property="listDiaDiem" id="tb">
			<bean:define id="madd" name="tb" property="maDiaDiem"></bean:define>
			<bean:define id="loai1" name="tb" property="loai"></bean:define>

			<div class="listDiaDiem">
				<a href="thongTinTKChiTiet.do?tenDangNhap=<bean:write name="tb" property="tenDangNhap" />"><h3>
						<logic:equal name="tb" property="loai" value="1">Bệnh Viện 
					</logic:equal>
						<logic:equal name="tb" property="loai" value="2"> Nhà Thuốc 
					</logic:equal>
						<logic:equal name="tb" property="loai" value="3">Phòng Khám 
					</logic:equal>
						
						<bean:write name="tb" property="ten" />
					</h3> </a>
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

			<hr>
		</logic:iterate>
	</div>


	<div id="floating-panel" style="z-index: 5;">
		<html:form action="/dia-diem" method="get">
			<b>Tìm Theo: </b>
			<html:select property="loaiDiaDiem" styleId="mode">
				<html:option value="0">Tất cả</html:option>
				<html:option value="1">Bệnh viện</html:option>
				<html:option value="2">Tiệm thuốc</html:option>
				<html:option value="3">Phòng Khám</html:option>
			</html:select>
			<input type="text" id="test" size="20" name="search">
			<input type="submit" name="submit" value="tim">
			<a href="/MSS/ban-do.do">Bản đồ</a>
	</div>
	<script type="text/javascript">
		$("#mode").change(
				function() {

					var t = "" + document.getElementById("mode").value;
					window.location.assign("/MSS/dia-diem.do?loaiDiaDiem=" + t
							+ "&search=?")
				});
	</script>


	</html:form>
</body>
</html>