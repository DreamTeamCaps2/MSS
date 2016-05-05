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
		padding: 0px;
		margin: 0px;
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
							<div class="title1">

								<div
									style="float: left; margin-right: 20px; margin-bottom: 10px;">
									<img
										src="img/<bean:write name="thuocForm" property="hinhAnh"/>"
										alt="some_text" width="256" height="256">
								</div>
								<div>

									<p style="font-size: 18px;">
										Thuốc :
										<bean:write name="thuocForm" property="tenThuoc" />
										<br>
									</p>
									<p style="font-size: 14px;">
										Nhóm Thuốc :
										<bean:write name="thuocForm" property="tenNhomThuoc" />
										<br>
									</p>
									<p style="font-size: 14px;">
										Loai Thuốc :
										<bean:write name="thuocForm" property="tenNhomThuoc" />
										<br>
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
								</div>

							</div>
							<div>
								<a style="text-align: center;" id="filter"><i>Mục lục
										Tra Cứu(Ẩn /Hiện)</i> </a>

								<div class="checkBoxFilter">
									<form name="checkBoxFilterForm">
										<div class="row categories">
											<ul class="nav nav-pills nav-stacked">
												<li><h4 style="color: red; text-align: center">Tra
														Cứu</h4></li>
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
						</div>
					</div>

					<div class="row">



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
							<section id="thanTrong"
								class="section section-padded itemSection">
								<h4>Thận Trọng</h4>
								<p>
									<c:out value="${thuocForm.thanTrong}" escapeXml="false" />
								</p>
							</section>
						</logic:notEmpty>
					</div>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-4 advertise"></div>
			</div>
		</div>
	</html:form>
<%@ include file="_footer.jsp"%>
</body>
</html>