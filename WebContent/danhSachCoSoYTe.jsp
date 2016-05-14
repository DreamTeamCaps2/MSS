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
	<div class="container">
		<html:form action="/dia-diem" method="get">
			<div class="row danhSachCSYT">
				<div class="col-lg-8 col-md-8 col-sm-8">
					<div class="col-lg-3 col-md-3 col-sm-3">
						<html:select property="loaiDiaDiem" styleId="mode">
							<html:option value="0">Tất cả</html:option>
							<html:option value="1">Bệnh viện</html:option>
							<html:option value="2">Tiệm thuốc</html:option>
							<html:option value="3">Phòng Khám</html:option>
						</html:select>
					</div>
					<div class=" col-lg-5 col-md-5 col-sm-5">
						<input type="text" id="test" size="40" name="search">
					</div>
					<html:submit property="submit" value="tim" styleId="csytsubmit"
						styleClass="btn btn-default btn-lg">
						<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					</html:submit>
					<br>
					<br>
						<h3>
							<span class="glyphicon glyphicon-map-marker"></span> <a
								href="/MSS/ban-do.do">Tra Cứu Bằng Bản Đồ </a>
						</h3>
					<h2>Danh Sách Các Trung Tâm Y Tế</h2>

					<logic:iterate name="diaDiemForm" property="listDiaDiem" id="tb">
						<bean:define id="madd" name="tb" property="maDiaDiem"></bean:define>
						<bean:define id="loai1" name="tb" property="loai"></bean:define>

						<div class="listDiaDiem">
							<a
								href="thongTinTKChiTiet.do?tenDangNhap=<bean:write name="tb" property="tenDangNhap" />"><h3>
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
								<bean:write name="tb" property="diaChi" />
							</p>
							<p>
								<img src="img/phone.png">
								<bean:write name="tb" property="sdt" />
							</p>
							<div id="kcmadd${madd}"></div>
							<img src="img/directions.png" height="31px" width="30px"><a
								href="/MSS/chi-duong.do?maDiaDiem=${madd}&loai=${loai1}" style="color:green">
								Chỉ Đường</a>
						</div>
					</logic:iterate>

					<script>
						jQuery(function($) {
							var items = $(".listDiaDiem");
							var numItems = items.length;
							var perPage = 8;
							// only show the first 2 (or "first per_page") items initially
							items.slice(perPage).hide();
							// now setup pagination
							$("#pagination").pagination({
								items : numItems,
								itemsOnPage : perPage,
								cssStyle : "light-theme",
								onPageClick : function(pageNumber) { // this is where the magic happens
									// someone changed page, lets hide/show trs appropriately
									var showFrom = perPage * (pageNumber - 1);
									var showTo = showFrom + perPage;
									items.hide()
									// first hide everything, then show for the new page
									.slice(showFrom, showTo).show();
								}
							});
						});
					</script>
				</div>
				<%@ include file="_menuRight.jsp"%>
			</div>
			<div class="row">
				<div class="page-navigation" id="pagination"></div>
			</div>
		</html:form>
	</div>
	<%@ include file="_footer.jsp"%>
	<script type="text/javascript">
		$("#mode").change(
				function() {

					var t = "" + document.getElementById("mode").value;
					window.location.assign("/MSS/dia-diem.do?loaiDiaDiem=" + t
							+ "&search=?")
				});
	</script>
</body>
</html>