<%@page import="form.BenhForm"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<%@ include file="login.jsp"%>
<head lang="en">
<meta charset="UTF-8">
<title>Chi tiết bệnh</title>
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
	<div class="container">
		<html:form action="/chi-tiet-benh" method="get">
			<div class="row">

				<div class="col-lg-8 col-md-8 col-sm-8 chitiet-content">
					<div class="row">
						<div >
							<div style="float: left; margin-right: 20px; margin-bottom: 10px;">
								<img src="img/<bean:write name="benhForm" property="hinhAnh"/>"
									alt="some_text" width="256" height="256">
							</div>
							<div class="title1">

								<p style="font-size: 18px;">
									Bệnh :
									<bean:write name="benhForm" property="tenBenh" />
									<br>
								</p>

								<p style="font-size: 14px;">
									Loại Bệnh :
									<a href="/MSS/danh-sach-benh.do?maLoaiBenh=<bean:write name="benhForm" property="maLoaiBenh" />"><bean:write name="benhForm" property="tenLoaiBenh" /></a>
									<br>
								</p>
							</div>

						</div>
					</div>
					<div id="mucLuc">
						<p style="text-align: center;">
							<span><a style="font-weight: 700; margin: 0px;"
								id="filter"><i>Mục lục Tra Cứu(Ẩn /Hiện)</i> </a></span>
						</p>

						<div class="checkBoxFilter">
							<form name="checkBoxFilterForm">
								<div class="row categories">
									<ul class="list-categories">
										<logic:notEmpty name="benhForm" property="dinhNghia">
											<li style="margin-right: 5px;"><a href="#dinhNghia">Bệnh
													<bean:write name="benhForm" property="tenBenh" /> Là Gì ?
											</a></li>
										</logic:notEmpty>
										<logic:notEmpty name="benhForm" property="nguyenNhan">
											<li><a href="#nguyenNhan">Nguyên Nhân Bệnh ?</a></li>
										</logic:notEmpty>
										<logic:notEmpty name="benhForm" property="chanDoan">
											<li><a href="#chanDoan">Chẩn Đoán ?</a></li>
										</logic:notEmpty>
										<logic:notEmpty name="benhForm" property="bienChung">
											<li><a href="#bienChung">Biến Chứng</a></li>
										</logic:notEmpty>
										<logic:notEmpty name="benhForm" property="dieuTri">
											<li><a href="#dieuTri">Điều Trị</a></li>
										</logic:notEmpty>
										<logic:notEmpty name="benhForm" property="cheDoDinhDuong">
											<li><a href="#cheDoDinhDuong">Chế Độ Dinh Dưỡng </a></li>
										</logic:notEmpty>
										<logic:notEqual value="0" property="soLuongThuoc"
											name="benhForm">
											<li><a href="#thuocLienQuan">Thuốc Liên Quan </a>
										</logic:notEqual>
										<logic:notEqual value="0" property="soLuongBenh"
											name="benhForm">
											<li><a href="#benhLienQuan">Bệnh Liên Quan</a>
										</logic:notEqual>

									</ul>
								</div>
							</form>
						</div>
					</div>








					<!-- Kiểm tra giá trị  Định Nghĩa-->
					<logic:notEmpty name="benhForm" property="dinhNghia">
						<div class="cut cut-top"></div>
						<div class="row">

							<div class="col-lg-12">
								<section id="dinhNghia"
									class="section section-padded itemSection">
									<h4>
										Bệnh
										<bean:write name="benhForm" property="tenBenh" />
										Là Gì ?
									</h4>
									<c:out value="${benhForm.dinhNghia}" escapeXml="false" />
								</section>
							</div>
						</div>
					</logic:notEmpty>
					<!-- Kiểm tra giá trị  Nguyên Nhân-->
					<logic:notEmpty name="benhForm" property="nguyenNhan">
						<section id="nguyenNhan"
							class="section section-padded itemSection">
							<h4>Nguyên Nhân</h4>
							<p>
								<c:out value="${benhForm.nguyenNhan}" escapeXml="false" />
							</p>
						</section>
					</logic:notEmpty>
					<!-- Kiểm tra giá trị  Biến Chứng-->
					<logic:notEmpty name="benhForm" property="bienChung">
						<section id="bienChung" class="section section-padded itemSection">
							<h4>Biến Chứng</h4>
							<p>
								<c:out value="${benhForm.bienChung}" escapeXml="false" />
							</p>
						</section>
					</logic:notEmpty>
					<!-- Kiểm tra giá trị  Chẩn Đoán-->
					<logic:notEmpty name="benhForm" property="chanDoan">
						<section id="chanDoan" class="section section-padded itemSection">
							<h4>Chẩn Đoán</h4>
							<p>
								<c:out value="${benhForm.chanDoan}" escapeXml="false" />
							</p>
						</section>
					</logic:notEmpty>
					<!-- Kiểm tra giá trị  Điều Trị-->
					<logic:notEmpty name="benhForm" property="dieuTri">
						<section id="dieuTri" class="section section-padded itemSection">
							<h4>Điều Trị</h4>
							<p>
								<c:out value="${benhForm.dieuTri}" escapeXml="false" />
							</p>
						</section>
					</logic:notEmpty>
					<!-- Kiểm tra giá trị  Chế Độ Dinh Dưỡng-->
					<logic:notEmpty name="benhForm" property="cheDoDinhDuong">
						<section id="cheDoDinhDuong"
							class="section section-padded itemSection">
							<h4>Chế Độ Chăm Sóc</h4>
							<p>
								<c:out value="${benhForm.cheDoDinhDuong}" escapeXml="false" />
							</p>
						</section>
					</logic:notEmpty>
					<logic:notEqual value="0" property="soLuongThuoc" name="benhForm">
						<div class="row" style="margin-top: 20px;">
							<div class="col-lg-12 thuocLienQuan">
								<section id="thuocLienQuan"
									class="section section-padded itemSection">
									<h4>List Thuốc Liên Quan</h4>
									<div class="list-group">

										<logic:iterate id="x" property="listThuoc" name="benhForm">
											<a class="list-group-item" style="font-size: 17px;"
												href="/MSS/chi-tiet-thuoc.do?ma=<bean:write name="x" property="maThuoc"/>">
												<bean:write name="x" property="tenThuoc" />
											</a>
										</logic:iterate>
										<h5 style="text-align: right;">
											<span class="badge">Tổng cộng :<bean:write
													name="benhForm" property="soLuongThuoc" /></span>
										</h5>

									</div>
								</section>
							</div>
						</div>
					</logic:notEqual>
					<logic:notEqual value="0" property="soLuongBenh" name="benhForm">
						<div style="margin-top: 20px;">
							<div class="benhLienQuan">
								<section id="benhLienQuan"
									class="section section-padded itemSection">
									<h4>Bài Viết Liên Quan</h4>
									<logic:iterate id="x" name="benhForm" property="listBenh">
										<a style="font-size: 17px;"
											href="/MSS/chi-tiet-benh.do?ma=<bean:write name="x" property="maBenh"/>">
											<img src="img/<bean:write name="x" property="hinhAnh"/>"
											alt="some_text" width="100px" height="100px"> <bean:write
												name="x" property="tenBenh" />
										</a>
										<a></a>
										<br>
										<br>
									</logic:iterate>
								</section>
							</div>
						</div>
					</logic:notEqual>
					<p style="float:right;"><em>Theo B&agrave;i Giảng M&ocirc;n H&oacute;a Dược Trường Đại Học Duy T&acirc;n&nbsp;</em></p>

					
				</div>
				<%@ include file="_menuRight.jsp"%>	
			</div>
		</html:form>
	</div>
	<%@ include file="_footer.jsp"%>	
</body>
</html>