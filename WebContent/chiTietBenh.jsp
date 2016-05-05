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
<!-- <link rel="stylesheet" href="css/bootstrap.min.css" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1"> -->
	<style type="text/css">
		p{
			text-align: justify;
		}
	</style>
</head>
<body>
	<div class="container">
		<html:form action="/chi-tiet-benh" method="get">
			<div class="row">

				<div class="col-lg-3 col-md-3 categories">
					<ul class="nav nav-pills nav-stacked" data-spy="affix">
						<li><h4 style="color: red;">Tra Cứu</h4></li>
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
						<logic:notEqual value="0" property="soLuongThuoc" name="benhForm">
							<li><a href="#thuocLienQuan">Thuốc Liên Quan </a>
						</logic:notEqual>
						<logic:notEqual value="0" property="soLuongBenh" name="benhForm">
							<li><a href="#benhLienQuan">Bệnh Liên Quan</a>
						</logic:notEqual>

					</ul>
				</div>
				<div class="col-lg-6 chitiet-content">
					<div class="row">
						<div class="title">
							<div >
								<img src="img/<bean:write name="benhForm" property="hinhAnh"/>"
									alt="some_text" width="256" height="256">
							</div>
							<div >

								<p style="font-size: 18px;">
									Bệnh :
									<bean:write name="benhForm" property="tenBenh" />
									<br>
							</div>

						</div>
					</div>
					<div class="row">
						<!-- Kiểm tra giá trị  Định Nghĩa-->
						<logic:notEmpty name="benhForm" property="dinhNghia">
							<div class="cut cut-top"></div>
							<div class="row">

								<div class="col-lg-12">
									<section id="dinhNghia"
										class="section section-padded itemSection">
										<h3 style="text-align: center;">
											Bệnh
											<bean:write name="benhForm" property="tenBenh" />
											Là Gì ?
										</h3>
										<c:out value="${benhForm.dinhNghia}" escapeXml="false" />
									</section>
								</div>
							</div>
						</logic:notEmpty>
						<!-- Kiểm tra giá trị  Nguyên Nhân-->
						<logic:notEmpty name="benhForm" property="nguyenNhan">
							<div class="row">
								<div class="col-lg-12">
									<section id="nguyenNhan"
										class="section section-padded itemSection">
										<h3 style="text-align: center;">Nguyên Nhân</h3>
										<p>
											<c:out value="${benhForm.nguyenNhan}" escapeXml="false" /> 
										</p>
									</section>
								</div>
							</div>
						</logic:notEmpty>
						<!-- Kiểm tra giá trị  Biến Chứng-->
						<logic:notEmpty name="benhForm" property="bienChung">
							<div class="row">
								<div class="col-lg-12">
									<section id="bienChung"
										class="section section-padded itemSection">
										<h3 style="text-align: center;">Biến Chứng</h3>
										<p>
												<c:out value="${benhForm.bienChung}" escapeXml="false" /> 
										</p>
									</section>
								</div>
							</div>
						</logic:notEmpty>
						<!-- Kiểm tra giá trị  Chẩn Đoán-->
						<logic:notEmpty name="benhForm" property="chanDoan">
							<div class="row">
								<div class="col-lg-12">
									<section id="chanDoan"
										class="section section-padded itemSection">
										<h3 style="text-align: center;">Chẩn Đoán</h3>
										<p>
												<c:out value="${benhForm.chanDoan}" escapeXml="false" /> 
										</p>
									</section>
								</div>
							</div>
						</logic:notEmpty>
						<!-- Kiểm tra giá trị  Điều Trị-->
						<logic:notEmpty name="benhForm" property="dieuTri">
							<div class="row">
								<div class="col-lg-12">
									<section id="dieuTri"
										class="section section-padded itemSection">
										<h3 style="text-align: center;">Điều Trị</h3>
										<p>
												<c:out value="${benhForm.dieuTri}" escapeXml="false" /> 
										</p>
									</section>
								</div>
							</div>
						</logic:notEmpty>
						<!-- Kiểm tra giá trị  Chế Độ Dinh Dưỡng-->
						<logic:notEmpty name="benhForm" property="cheDoDinhDuong">
							<div class="row">
								<div class="col-lg-12">
									<section id="cheDoDinhDuong"
										class="section section-padded itemSection">
										<h3 style="text-align: center;">Chế Độ Dinh Dưỡng</h3>
										<p>
											<c:out value="${benhForm.cheDoDinhDuong}" escapeXml="false" /> 
										</p>
									</section>
								</div>
							</div>
						</logic:notEmpty>
						<logic:notEqual value="0" property="soLuongThuoc" name="benhForm">
							<div class="row" style="margin-top: 20px;">
								<div class="col-lg-12 thuocLienQuan">
									<section id="thuocLienQuan"
										class="section section-padded itemSection">
										<h3 style="text-align: center;">List Thuốc Liên Quan</h3>
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
							<div class="row" style="margin-top: 20px;">
								<div class="col-lg-12 benhLienQuan">
									<section id="benhLienQuan"
										class="section section-padded itemSection">
										<h3 style="text-align: center;">Bài Viết Liên Quan</h3>
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
					</div>
				</div>
				<div class="col-lg-3 content">
					<div class="row listnhieunhat">
						<h3 style="text-align: center;">Những Bệnh Xem Nhiều Nhất</h3>
						<%
							int i = 1;
						%>
						<logic:iterate id="x" name="benhForm" property="listBenhXemNhieu">

							<div class="list sidebar">
								<div class="numb" style="float: left">

									<i id="number"><%=i%></i>
									<%
										i++;
									%>
								</div>
								<div class="item
								">

									<a style="font-size: 17px;"
										href="/MSS/chi-tiet-benh.do?ma=<bean:write name="x" property="maBenh"/>">
										<bean:write name="x" property="tenBenh" />
									</a> <br> <span><i class="fa fa-eye"><bean:write
												name="x" property="luotXem" /></i></span>
								</div>
							</div>
						</logic:iterate>
					</div>
					<div class="row listnhieunhat">
						<h3 style="text-align: center;">Những Thuốc Xem Nhiều Nhất</h3>
						<%
							int k = 1;
						%>
						<logic:iterate id="x" name="benhForm" property="listThuocXemNhieu">

							<div class="list sidebar">
								<div class="numb" style="float: left">

									<i id="number"><%=k%></i>
									<%
										k++;
									%>
								</div>
								<div class="item
								">

									<a style="font-size: 17px;"
										href="/MSS/chi-tiet-thuoc.do?ma=<bean:write name="x" property="maThuoc"/>">
										<bean:write name="x" property="tenThuoc" />
									</a> <br> <span><i class="fa fa-eye"><bean:write
												name="x" property="luotXem" /></i></span>
								</div>
							</div>
						</logic:iterate>
					</div>
				</div>
			</div>
		</html:form>
	</div>
</body>
</html>