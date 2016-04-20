
<%@page import="java.util.ArrayList"%>
<%@page import="form.TimKiemForm"%>
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
<title>Tìm Kiếm</title>
<%@ include file="login.jsp"%>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" />
<link href="css/style.css" rel="stylesheet" type="text/css"
	media="screen,print" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/easy-autocomplete.min.css" rel="stylesheet"
	type="text/css">

<script src="js/jquery.easy-autocomplete.min.js" type="text/javascript"></script>

<!-- CSS file -->
<link rel="stylesheet" href="js/easy-autocomplete.min.css">
<link rel="stylesheet" href="css/simplePagination.css">
<script src="js/jquery.simplePagination.js" type="text/javascript"></script>
</head>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$(".tableFilter").hide();
						var maLoaiTimKiem = <bean:write name="timKiemForm" property="maLoaiTimKiem"/>;
						if (maLoaiTimKiem == 0) {
							$("#active1").addClass('active');
						} else if (maLoaiTimKiem == 1) {
							$("#active2").addClass('active');
						} else {
							$("#active3").addClass('active');
						}
						$("#filter").click(function() {

							$(".tableFilter").toggle();
						});

					});
</script>
<body>
	<html:form action="/tim-kiem">
		<div class="row">
			<div class="col-lg-2">
				<!-- KHOANG TRANG -->
			</div>
			<!-- NOI DUNG -->
			<div class="col-lg-6">
				<div class="tab-menu group">
					<ul>
						<li id="active1"><a
							href="/MSS/tim-kiem.do?timKiem=<bean:write name="timKiemForm" property="timKiem"/>&maLoaiTimKiem=0">
								Tất Cả</a></li>
						<li id="active2"><a
							href="/MSS/tim-kiem.do?timKiem=<bean:write name="timKiemForm" property="timKiem"/>&maLoaiTimKiem=1">
								Bệnh </a></li>
						<li id="active3"><a
							href="/MSS/tim-kiem.do?timKiem=<bean:write name="timKiemForm" property="timKiem"/>&maLoaiTimKiem=2">
								Thuốc</a></li>
						<span class="toggle-filter pull-right fn-show" id="filter">Lọc
							kết quả<i></i>
						</span>
					</ul>


				</div>

				<div class="tableFilter">
					<table class="table filter">
						<thead>
							<tr>
								<th>Sắp Xếp Theo</th>
								<th>Thời Gian Đăng</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Mặc Định</td>
								<td>Mọi lúc</td>

							</tr>
							<tr>
								<td>Xem Nhiều Nhất/td>
								<td>Trong Ngày</td>

							</tr>
							<tr>
								<td>Mới Nhất</td>
								<td>Trong Tuần</td>


							</tr>
							<tr>
								<td></td>
								<td>Trong Tháng</td>
							</tr>
							<tr>
								<td></td>
								<td>Trong Năm</td>
							</tr>

						</tbody>
					</table>

				</div>

				<div class="number-result">
					<h5>
						Từ Khóa "
						<bean:write name="timKiemForm" property="timKiem" />
						" có
						<bean:write name="timKiemForm" property="soKetQua" />
						kết quả
					</h5>
				</div>
				<div id="item-result1">
					<logic:notEmpty property="listBenh" name="timKiemForm">
						<logic:iterate id="x" name="timKiemForm" property="listBenh">
							<div class="item timkiem">
								<div class="item-title">
									<a style="font-size: 30px;"
										href="/MSS/chi-tiet-benh.do?ma=<bean:write name="x" property="maBenh"/>"><bean:write
											name="x" property="tenBenh" /> </a>
								</div>
								<div class="loaiBenh">
									<h5>
										Loại Bệnh : <a
											href="/MSS/danh-sach-benh.do?maLoai=<bean:write name="x" property="maLoaiBenh"/>"><bean:write
												name="x" property="tenLoaiBenh" /> - </a> Lượt Xem :
										<bean:write name="x" property="luotXem" />
									</h5>
								</div>
								<div class="ngayCapNhat">
									<h5>
										Ngày Cập Nhật :
										<bean:write name="x" property="ngayCapNhat" />
									</h5>
								</div>
							</div>
						</logic:iterate>
					</logic:notEmpty>

					<logic:notEmpty property="listThuoc" name="timKiemForm">
						<logic:iterate id="x" name="timKiemForm" property="listThuoc">
							<div class="item timkiem">
								<div class="item-title">
									<a style="font-size: 30px;"
										href="/MSS/chi-tiet-thuoc.do?ma=<bean:write name="x" property="maThuoc"/>"><bean:write
											name="x" property="tenThuoc" /> </a>
								</div>
								<div class="loaiBenh">
									<h5>
										Loại Thuốc : <a
											href="/MSS/danh-sach-thuoc.do?maLoai=<bean:write name="x" property="maNhomThuoc"/>"><bean:write
												name="x" property="tenNhomThuoc" /> - </a>
									</h5>
									<h5>
										Lượt Xem :
										<bean:write name="x" property="luotXem" />
									</h5>
								</div>
								<div class="ngayCapNhat">
									<h5>
										Ngày Cập Nhật :
										<bean:write name="x" property="ngayCapNhat" />
									</h5>
								</div>
							</div>
						</logic:iterate>

					</logic:notEmpty>

				</div>
				<div class="page-navigation" id="pagination"></div>
				<script>
				jQuery(function($) {
	                var items = $(".item");
	                var numItems = items.length;
	                var perPage = 5;
	                // only show the first 2 (or "first per_page") items initially
	                items.slice(perPage).hide();
	                // now setup pagination
	                $("#pagination").pagination({
	                    items: numItems,
	                    itemsOnPage: perPage,
	                    cssStyle: "light-theme",
	                    onPageClick: function(pageNumber) { // this is where the magic happens
	                        // someone changed page, lets hide/show trs appropriately
	                        var showFrom = perPage * (pageNumber - 1);
	                        var showTo = showFrom + perPage;
	                        items.hide() // first hide everything, then show for the new page
	                             .slice(showFrom, showTo).show();
	                    }
	                });
	            });
				</script>

			</div>
			<!-- QUANG CAO -->
			<div class="col-lg-4"></div>

		</div>
	</html:form>
</body>
</html>