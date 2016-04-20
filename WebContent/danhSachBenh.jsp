
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

<title>Danh Sách Bệnh</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" />
<link href="css/style.css" rel="stylesheet" type="text/css"
	media="screen,print" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- CSS file -->
<script src="js/jquery.simplePagination.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/simplePagination.css">


</head>
<body>
	<html:form action="/danh-sach-benh">
		<div class="row">
			<!-- //khoang trang -->
			<div class="col-lg-2"></div>
			<!-- side bar -->
			<div class="col-lg-2">
				<div class="sidebar fn-sidebar-fixed">
					<ul class="list-group"
						style="max-height: 800px; overflow-y: scroll;">
						<li class="list-group-item"><a
							href="/MSS/danh-sach-benh.do?maLoaiDanhSach=0">
								Tất Cả </a></li>
						<logic:iterate id="x" name="danhSachBenhForm"
							property="listLoaiBenh">
							<li class="list-group-item"><a
								href="/MSS/danh-sach-benh.do?maLoaiDanhSach=<bean:write name="x" property="maLoaiBenh"/>">
									<bean:write name="x" property="tenLoaiBenh" />
							</a></li>
						</logic:iterate>

					</ul>
				</div>


			</div>
			<!-- noi dung -->
			<div class="col-lg-6">
				<div class="row">
				<div class="content">
					<logic:iterate id="x" name="danhSachBenhForm" property="listBenh">
						<div class="item-result">
							<div>
								<a style="font-size: 17px;"
									href="/MSS/chi-tiet-benh.do?ma=<bean:write name="x" property="maBenh"/>">
									<img src="img/<bean:write name="x" property="hinhAnh"/>"
									alt="some_text" width="200px" height="200px">
								</a>
								<div>
									<a
										href="/MSS/chi-tiet-benh.do?ma=<bean:write name="x" property="maBenh"/>">
										<bean:write name="x" property="tenBenh" />
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