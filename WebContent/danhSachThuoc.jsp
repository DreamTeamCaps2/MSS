
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
<script>
	$(document)
			.ready(
					function() {
						var soLuongThuoc = <bean:write name="danhSachThuocForm" property="soLuongThuoc" />;
						/* 	var height= (parseInt((soLuongBenh%20)/4 )+1);
						 */var height = $(window).height();
						$(".list-group.scroll")
								.css("max-height", height + "px");
						var maLoaiThuoc = <bean:write name="danhSachThuocForm" property="maLoaiThuoc"/>;
						var maNhomThuoc = <bean:write name="danhSachThuocForm" property="maNhomThuoc"/>
						if(maNhomThuoc=="0"){
							$("li#loai-thuoc-"+maLoaiThuoc).addClass('active-loaidanhsach');
						}
						else 
							$("li#nhom-thuoc-"+maNhomThuoc).addClass('active-loaidanhsach');
						
 
					});
</script>
</head>
<body>
	<html:form action="/danh-sach-thuoc">
		<div class="container">
			<div class="row">
				<!-- //khoang trang -->
				<!-- side bar -->
				<div class="col-lg-3">
					<div class="sidebar-danhsach">
						<ul class="list-group scroll">
							<li class="list-group-item loaidanhsach" id="loai-thuoc-0" ><a								
								href="/MSS/danh-sach-thuoc.do?maLoaiThuoc=0" > Tất Cả </a></li>
							<logic:iterate id="x" name="danhSachThuocForm"
								property="listLoaiThuoc">
								<li class="list-group-item loaidanhsach"
									id="loai-thuoc-<bean:write name="x" property="maLoaiThuoc"/>">
									<a
									href="/MSS/danh-sach-thuoc.do?maLoaiThuoc=<bean:write name="x" property="maLoaiThuoc"/>">
										<bean:write name="x" property="tenLoaiThuoc" />
								</a>
								</li>
								<bean:define id="prodName" name="x" property="maLoaiThuoc" />
								<logic:iterate name="danhSachThuocForm" property="listNhomThuoc"
									id="a">
									<logic:equal name="a" property="maLoaiThuoc"
										value="${prodName}">
										<li class="list-group-item nhomdanhsach " id ="nhom-thuoc-<bean:write name="a" property="maNhomThuoc"/>"><a
											id="nhom-thuoc-<bean:write name="a" property="maNhomThuoc"/>"
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
				<div class="col-lg-9">
					<div class="row">
						<div class="content">
							<logic:iterate id="x" name="danhSachThuocForm"
								property="listThuoc">
								<div class="item-result">
									<div>
										<a
											href="/MSS/chi-tiet-thuoc.do?ma=<bean:write name="x" property="maThuoc"/>">
											<img src="img/<bean:write name="x" property="hinhAnh"/>"
											alt="some_text" width="200px" height="200px">
										</a>
										<div class="title-item-result">
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

				</div>

				<!-- khoang trang -->
			</div>
			<div class="row">
				<div class="page-navigation" id="pagination"></div>
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
	</html:form>

</body>
</html>