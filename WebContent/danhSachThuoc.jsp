
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

<title>Danh Sách Thuốc</title>
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
<link rel="stylesheet" type="text/css"
	href="font-awesome/css/font-awesome.min.css">
<script src="js/jquery.simplePagination.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/simplePagination.css">

</head>
<body>
	<html:form action="/danh-sach-thuoc">
		<div class="row">
			<!-- //khoang trang -->
			<div class="col-lg-2"></div>
			<!-- side bar -->
			<div class="col-lg-2">
				<div class="sidebar fn-sidebar-fixed">
					<ul class="list-group"
						style="max-height: 800px; overflow-y: scroll;">
						<li class="list-group-item"><a
							href="/MSS/danh-sach-thuoc.do?maLoaiThuoc=0">
								Tất Cả </a></li>
						<logic:iterate id="x" name="danhSachThuocForm"
							property="listLoaiThuoc">
							<li class="list-group-item loaiThuoc"><a
								href="/MSS/danh-sach-thuoc.do?maLoaiThuoc=<bean:write name="x" property="maLoaiThuoc"/>">
									<bean:write name="x" property="tenLoaiThuoc" />
							</a></li>
							<bean:define id="prodName" name="x" property="maLoaiThuoc" />
							<logic:iterate name="danhSachThuocForm" property="listNhomThuoc"
								id="a">
								<logic:equal name="a" property="maLoaiThuoc"
								value="${prodName}" >
									<li class="list-group-item "><a
										href="/MSS/danh-sach-thuoc.do?maNhomThuoc=<bean:write name="a" property="maNhomThuoc"/>">
											<bean:write name="a" property="tenNhomThuoc" />
									</a></li>
								</logic:equal>
							</logic:iterate>
						</logic:iterate>

					</ul>
				</div>


			</div>
			<!-- noi dung -->
			<div class="col-lg-6">
			<div class="row">
				<div class="content">
					<logic:iterate id="x" name="danhSachThuocForm" property="listThuoc">
						<div class="item-result">
							<div>
								<a style="font-size: 17px;"
									href="/MSS/chi-tiet-thuoc.do?ma=<bean:write name="x" property="maThuoc"/>">
									<img src="img/<bean:write name="x" property="hinhAnh"/>"
									alt="some_text" width="200px" height="200px">
								</a>
								<div>
									<a
										href="/MSS/chi-tiet-thuoc.do?ma=<bean:write name="x" property="maThuoc"/>">
										<bean:write name="x" property="tenThuoc" />
									</a>
								</div>
							</div>
						</div>
					</logic:iterate>
				</div>
				</div>
				<div class="row">
				<div class="page-navigation" id="pagination"></div>
				<script>
					jQuery(function($) {
						var items = $(".item-result");
						var numItems = items.length;
						var perPage = 5;
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
								items.hide() // first hide everything, then show for the new page
								.slice(showFrom, showTo).show();
							}
						});
					});
				</script>

				</div>
			</div>

			<!-- khoang trang -->
			<div class="col-lg-2"></div>
		</div>
	</html:form>

</body>
</html>