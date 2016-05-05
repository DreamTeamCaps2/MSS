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

<script>
	$(document)
			.ready(
					function() {
						var soLuongBenh = <bean:write name="danhSachBenhForm" property="soLuongBenh" />;
						/* 	var height= (parseInt((soLuongBenh%20)/4 )+1);
						 */var height = $(window).height();
						/* $(".list-group.scroll").css("max-height",
								height + "px"); */
						var maLoaiDanhSach = <bean:write name="danhSachBenhForm" property="maLoaiDanhSach"/>;

						$("#loai-danh-sach-" + maLoaiDanhSach).addClass(
								'active-loaidanhsach');

					});
</script>

</head>
<body>
	<html:form action="/danh-sach-benh">
		<div class="container">
			<div class="row ">
				<!-- side bar -->
				<div class="col-lg-3 col-md-3  categories">
					<div class="sidebar-danhsach">
						<ul class="list-group scroll">
							<li class="list-group-item loaidanhsach" id="loai-danh-sach-0"><a
								href="/MSS/danh-sach-benh.do?maLoaiDanhSach=0"> TẤT CẢ </a></li>
							<logic:iterate id="x" name="danhSachBenhForm"
								property="listLoaiBenh">
								<li class="list-group-item loaidanhsach"
									id="loai-danh-sach-<bean:write name="x" property="maLoaiBenh"/>">
									<a
									href="/MSS/danh-sach-benh.do?maLoaiDanhSach=<bean:write name="x" property="maLoaiBenh"/>">
										<bean:write name="x" property="tenLoaiBenh" />
								</a>
								</li>
							</logic:iterate>

						</ul>
					</div>
				</div>
				<!-- noi dung -->
				<div class="col-lg-9 col-md-9">
					<div class="row">
						<logic:equal value="0" property="soLuongBenh"
							name="danhSachBenhForm">
							<h3>Không có kết quả cho nhóm bệnh loại này</h3>
							<script>
								$(document).ready(function() {
									$("div #pagination").hide();
								});
							</script>
						</logic:equal>
						<div class="content">
							<logic:iterate id="x" name="danhSachBenhForm" property="listBenh">
								<div class="item-result">
									<div>
										<a
											href="/MSS/chi-tiet-benh.do?ma=<bean:write name="x" property="maBenh"/>">
											<img src="img/<bean:write name="x" property="hinhAnh"/>"
											alt="some_text" width="200px" height="200px">
										</a>
										<div class="title-item-result">
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

					<script>
						jQuery(function($) {
							var items = $(".item-result");
							var numItems = items.length;
							var perPage = 20;
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
			</div>
			<div class="row">

				<div class="page-navigation" id="pagination"></div>
			</div>
		</div>
	</html:form>
	<%@ include file="_footer.jsp"%>
</body>
</html>