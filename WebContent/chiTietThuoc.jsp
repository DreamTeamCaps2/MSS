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
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body >

	<html:form action="/chi-tiet-thuoc" method="get">
		<div class="container">
			<div class="row">
				<div class="col-lg-2 col-md-2 categories">
					<ul class="nav nav-pills nav-stacked" data-spy="affix"
						data-offset-top="100">
						<li><h4 style="color: red;">Tra Cứu</h4></li>

						<logic:notEmpty name="thuocForm" property="tenKhoaHoc">
							<li><a href="#tenKhoaHoc">Tên Khoa Học</a></li>
						</logic:notEmpty>
						<logic:notEmpty name="thuocForm" property="congThuc">
							<li><a href="#congThuc">Công Thức</a></li>
						</logic:notEmpty>
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
				<div class="col-lg-10 col-md-10">
					<div class="row">
						<div class="title">
							<h2>
								<img src="img/<bean:write name="thuocForm" property="hinhAnh"/>"
									alt="some_text" width="256" height="256"> Thuốc :
								<bean:write name="thuocForm" property="tenThuoc" />
							</h2>
						</div>
					</div>

					<div class="row">
						<logic:notEmpty name="thuocForm" property="tenKhoaHoc">
							<section id="tenKhoaHoc">
								<h3 style="text-align: center;">Tên Khoa Học</h3>
								<p>
									<bean:write name="thuocForm" property="tenKhoaHoc" />
								</p>
							</section>
						</logic:notEmpty>
						<!-- Kiểm tra giá trị  Nguyên Nhân-->
						<logic:notEmpty name="thuocForm" property="congThuc">
							<section id="congThuc">
								<h3 style="text-align: center;">Công Thức</h3>
								<p>
									<bean:write name="thuocForm" property="congThuc" />
								</p>
							</section>
						</logic:notEmpty>
						<!-- Kiểm tra giá trị  Biến Chứng-->
						<logic:notEmpty name="thuocForm" property="dieuChe">
							<section id="dieuChe">
								<h3 style="text-align: center;">Điều Chế</h3>
								<p>
									<bean:write name="thuocForm" property="dieuChe" />
								</p>
							</section>

						</logic:notEmpty>
						<!-- Kiểm tra giá trị  Chẩn Đoán-->
						<logic:notEmpty name="thuocForm" property="tinhChat">
							<section id="tinhChat">
								<h3 style="text-align: center;">Tính Chất</h3>
								<p>
									<bean:write name="thuocForm" property="tinhChat" />
								</p>
							</section>
						</logic:notEmpty>
						<!-- Kiểm tra giá trị  Điều Trị-->
						<logic:notEmpty name="thuocForm" property="tacDung">
							<section id="tacDung">
								<h3 style="text-align: center;">Tác Dụng</h3>
								<p>
									<bean:write name="thuocForm" property="tacDung" />
								</p>
							</section>
						</logic:notEmpty>
						<!-- Kiểm tra giá trị  Chế Độ Dinh Dưỡng-->
						<logic:notEmpty name="thuocForm" property="chiDinh">
							<section id="chiDinh">
								<h3 style="text-align: center;">Chỉ Định</h3>
								<p>
									<bean:write name="thuocForm" property="chiDinh" />
								</p>
							</section>
						</logic:notEmpty>
						<logic:notEmpty name="thuocForm" property="baoQuan">
							<section id="baoQuan">
								<h3 style="text-align: center;">Bảo Quản</h3>
								<p>
									<bean:write name="thuocForm" property="baoQuan" />
								</p>
							</section>
						</logic:notEmpty>
						<logic:notEmpty name="thuocForm" property="thanTrong">
							<section id="thanTrong">
								<h3 style="text-align: center;">Thận Trọng</h3>
								<p>
									<bean:write name="thuocForm" property="thanTrong" />
								</p>
							</section>
						</logic:notEmpty>
					</div>
				</div>
			</div>
		</div>
	</html:form>

</body>
</html>