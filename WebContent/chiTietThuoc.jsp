<%@page import="form.ThuocForm"%>
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
<title>Chi Tiết Thuốc</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<style type="text/css">
.row {
	margin-right: 0px;
	margin-left: 0px;
}

.row h4 {
    font-weight: 500;
    padding: 0px;
    margin: 0px;
    font-size: x-large;
}

.row p {
	margin: 10px 0px;
	text-align: justify;
}

ul.nav.nav-pills.nav-stacked {
	margin: 2% 10% 2% 10%;
}
</style>
<script>
	$(document).ready(function() {
		$(".checkBoxFilter").hide();
		$("#filter").click(function() {
			$(".checkBoxFilter").toggle();
		});
	});
</script>
</head>
<body>

	<html:form action="/chi-tiet-thuoc" method="get">
		<div class="container" style="padding-bottom: 30px;">
			<div class="row">
				<div class="col-lg-8 col-md-8 col-sm-8 content-center">
					<div class="row">
						<div class="main-content">
							<div>
								<div
									style="float: left; margin-right: 20px; margin-bottom: 10px;">
									<img
										src="img/<bean:write name="thuocForm" property="hinhAnh"/>"
										alt="some_text" width="256" height="256">
								</div>
								<div class="title1">

									<p style="font-size: 18px;">
										Thuốc :
										<bean:write name="thuocForm" property="tenThuoc" />
										<br>
									</p>
									<p style="font-size: 14px;">
										Nhóm Thuốc : <a
											href="/MSS/danh-sach-thuoc.do?maNhomThuoc=<bean:write name="thuocForm" property="maNhomThuoc" />"><bean:write
												name="thuocForm" property="tenNhomThuoc" /></a> <br>
									</p>
									<p style="font-size: 14px;">
										Loai Thuốc : <a
											href="/MSS/danh-sach-thuoc.do?maLoaiThuoc=<bean:write name="thuocForm" property="maNhomThuoc" />"><bean:write
												name="thuocForm" property="tenLoaiThuoc" /></a> <br>
									</p>


									<logic:notEmpty name="thuocForm" property="tenKhoaHoc">
										<p style="font-size: 18px;">Tên Khoa Học</p>
										<p>
											<c:out value="${thuocForm.tenKhoaHoc}" escapeXml="false" />
										</p>
									</logic:notEmpty>
									<!-- Kiểm tra giá trị  Nguyên Nhân-->
									<logic:notEmpty name="thuocForm" property="congThuc">
										<p style="font-size: 18px;">Công Thức</p>
										<p>
											<c:out value="${thuocForm.congThuc}" escapeXml="false" />
										</p>
									</logic:notEmpty>
									<a href="/MSS/mua-thuoc.do?maThuoc=<bean:write name="thuocForm" property="ma" />"> Mua <bean:write name="thuocForm" property="tenThuoc" /> !!</a>
								</div>
							</div>

						</div>
					</div>

					<div id="mucLuc">
						<p style="text-align: center;"><span><a
							style="font-weight: 700; margin: 0px;"
							id="filter"><i>Mục lục Tra Cứu(Ẩn /Hiện)</i> </a></span></p>

						<div class="checkBoxFilter">
							<form name="checkBoxFilterForm">
								<div class="row categories">
									<ul class="list-categories">
										<logic:notEmpty name="thuocForm" property="dieuChe">
											<li><a href="#dieuChe">Điều Chế</a></li>
										</logic:notEmpty>
										<logic:notEmpty name="thuocForm" property="tinhChat">
											<li><a href="#tinhChat">Tính Chất</a></li>
										</logic:notEmpty>
										<logic:notEmpty name="thuocForm" property="tacDung">
											<li><a href="#tacDung">Tác Dụng </a></li>
										</logic:notEmpty>
										<logic:notEmpty name="thuocForm" property="chiDinh">
											<li><a href="#chiDinh">Chỉ Định</a></li>
										</logic:notEmpty>
										<logic:notEmpty name="thuocForm" property="baoQuan">
											<li><a href="#baoQuan">Bảo Quản</a></li>
										</logic:notEmpty>
										<logic:notEmpty name="thuocForm" property="thanTrong">
											<li><a href="#thanTrong">Thận Trọng </a></li>
										</logic:notEmpty>
										<li><a href="#thuocLienQuan">Thuốc Liên Quan </a>
									</ul>
								</div>
							</form>
						</div>
					</div>


					<!-- Kiểm tra giá trị  Biến Chứng-->
					<logic:notEmpty name="thuocForm" property="dieuChe">
						<section id="dieuChe" class="section section-padded itemSection">
							<h4>Điều Chế</h4>
							<p>
								<c:out value="${thuocForm.dieuChe}" escapeXml="false" />
							</p>
						</section>

					</logic:notEmpty>
					<!-- Kiểm tra giá trị  Chẩn Đoán-->
					<logic:notEmpty name="thuocForm" property="tinhChat">
						<section id="tinhChat" class="section section-padded itemSection">
							<h4>Tính Chất</h4>
							<p>
								<c:out value="${thuocForm.tinhChat}" escapeXml="false" />
							</p>
						</section>
					</logic:notEmpty>
					<!-- Kiểm tra giá trị  Điều Trị-->
					<logic:notEmpty name="thuocForm" property="tacDung">
						<section id="tacDung" class="section section-padded itemSection">
							<h4>Tác Dụng</h4>
							<p>
								<c:out value="${thuocForm.tacDung}" escapeXml="false" />
							</p>
						</section>
					</logic:notEmpty>
					<!-- Kiểm tra giá trị  Chế Độ Dinh Dưỡng-->
					<logic:notEmpty name="thuocForm" property="chiDinh">
						<section id="chiDinh" class="section section-padded itemSection">
							<h4>Chỉ Định</h4>
							<p>
								<c:out value="${thuocForm.chiDinh}" escapeXml="false" />
							</p>
						</section>
					</logic:notEmpty>
					<logic:notEmpty name="thuocForm" property="baoQuan">
						<section id="baoQuan" class="section section-padded itemSection">
							<h4>Bảo Quản</h4>
							<p>
								<c:out value="${thuocForm.baoQuan}" escapeXml="false" />
							</p>
						</section>
					</logic:notEmpty>
					<logic:notEmpty name="thuocForm" property="thanTrong">
						<section id="thanTrong" class="section section-padded itemSection">
							<h4>Thận Trọng</h4>
							<p>
								<c:out value="${thuocForm.thanTrong}" escapeXml="false" />
							</p>
						</section>
					</logic:notEmpty>
					<p style="float:right;"><em>Theo B&agrave;i Giảng M&ocirc;n H&oacute;a Dược Trường Đại Học Duy T&acirc;n&nbsp;</em></p>
				</div>
				<%@ include file="_menuRight.jsp"%>	
			</div>
		</div>
	</html:form>
	<%@ include file="_footer.jsp"%>
</body>
</html>