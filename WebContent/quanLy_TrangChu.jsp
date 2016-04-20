
<%@page import="form.ThongBaoForm"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<html>
<head lang="en">
<meta charset="UTF-8">
<title>Trang chủ</title>

<link rel="stylesheet" href="css/bootstrap.min.css" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
	<div class="example">
		<div id="header">
			<nav class="navbar navbar-default">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#menu">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>

				</div>

				<div class="navbar-collapse collapse" id="menu">
					<ul class="nav navbar-nav">
						<li><a href="quanLy_TrangChu.jsp">Trang chủ</a></li>

						<li><a href="/MSS/quan-ly-danh-sach-benh.do">Bệnh</a></li>
						<li><a href="/MSS/quan-ly-danh-sach-thuoc.do">Thuốc</a></li>
						<li class="dropdown"><a href="quanLy_DanhSachTrieuChung.jsp" class="dropdown-toggle"
						data-toggle="dropdown">Khác<span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="/MSS/quan-ly-loai-thuoc.do">Loại thuốc</a></li>
								<li><a href="#">Nhóm thuốc</a></li>
								<li class="divider"></li>
								<li><a href="/MSS/quan-ly-loai-benh.do">Loại bệnh</a></li>
								<li><a href="#">Triệu chứng</a></li>
							</ul>
						</li>
						<li><a href="/MSS/quan-ly-danh-sach-tai-khoan.do">Tài Khoản</a></li>
						<li><a href="/MSS/quan-ly-bai-viet.do">Bài Viết</a></li>
						<li class="dropdown"><a data-toggle="dropdown" href="">
								<span class="glyphicon glyphicon-bell" aria-hidden="true"></span>
						</a></li>
						<li><a href="/MSS/home.do">WEB</a></li>
					</ul>
				</div>
			</nav>
		</div>
	</div>
</body>
</html>