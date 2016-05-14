<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head lang="en">
<meta charset="UTF-8">
<title>Tìm Kiếm</title>
<%@ include file="login.jsp"%>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						var maLoaiTimKiem = <bean:write name="timKiemForm" property="maLoaiTimKiem"/>;
						if (maLoaiTimKiem == 0) {
							$("#active1").addClass('active-loaitimkiem');
						} else if (maLoaiTimKiem == 1) {
							$("#active2").addClass('active-loaitimkiem');
						} else {
							$("#active3").addClass('active-loaitimkiem');
						}
						$("div .checkBoxFilter").hide();
						$("#filter").click(function() {

							$(".checkBoxFilter").toggle();
						});
						var checkBoxABC = document.getElementById("cbABC");
						var checkBoxLuotXem = document
								.getElementById("cbLuotXem");
						var checkBoxMacDinh = document
								.getElementById("cbMacDinh");
						if (<bean:write name="timKiemForm" property="abc"/> == true) {
							checkBoxABC.checked = true;
							checkBoxMacDinh.checked = false;
						} else {
							checkBoxABC.checked = false;
						}
						if (<bean:write name="timKiemForm" property="abc"/> == false
								&& <bean:write name="timKiemForm" property="luotXem"/> == false) {
							checkBoxMacDinh.checked = true;
						}
						if (<bean:write name="timKiemForm" property="luotXem"/> == true) {
							checkBoxLuotXem.checked = true;
							checkBoxMacDinh.checked = false;
						} else {
							checkBoxLuotXem.checked = false;
						}
						$("#cbABC")
								.click(
										function() {
											window.location
													.assign("/MSS/tim-kiem.do?macDinh=false&luotXem=False&abc=true&timKiem=<bean:write name="timKiemForm" property="timKiem"/>&maLoaiTimKiem=<bean:write name="timKiemForm" property="maLoaiTimKiem"/>");
										});
						$("#cbMacDinh")
								.click(
										function() {
											window.location
													.assign("/MSS/tim-kiem.do?macDinh=true&luotXem=false&abc=false&timKiem=<bean:write name="timKiemForm" property="timKiem"/>&maLoaiTimKiem=<bean:write name="timKiemForm" property="maLoaiTimKiem"/>");
										});
						$("#cbLuotXem")
								.click(
										function() {
											window.location
													.assign("/MSS/tim-kiem.do?macDinh=false&luotXem=true&abc=false&timKiem=<bean:write name="timKiemForm" property="timKiem"/>&maLoaiTimKiem=<bean:write name="timKiemForm" property="maLoaiTimKiem"/>");
										});
					});
</script>

<body>
	<html:form action="/tim-kiem">
		<div class="container" style="padding-top: 20px;">
			<div class="row">
				<!-- NOI DUNG -->
				<div class="col-lg-8 tim-kiem-content">
					<div class="tab-menu group">
						<ul>

							<%
								String link;
							%>

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

					<div class="checkBoxFilter">
						<form name="checkBoxFilterForm">
							<label class="radio-inline"> <input type="radio"
								id="cbMacDinh" name="macDinh" checked="checked">
								Mặc Định
							</label> <label class="radio-inline"> <input type="radio"
								id="cbABC" name="abc"> Sắp Xếp Theo ABC
							</label> <label class="radio-inline"> <input type="radio"
								name="luotXem" id="cbLuotXem"> Sắp Xếp Theo Lượt Xem
							</label>
						</form>
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
										<a 
											href="/MSS/chi-tiet-benh.do?ma=<bean:write name="x" property="maBenh"/>"><bean:write
												name="x" property="tenBenh" /> </a>
									</div>
									<div class="loaiitem">
										<h5>
											Loại Bệnh : <a
												href="/MSS/danh-sach-benh.do?maLoaiDanhSach=<bean:write name="x" property="maLoaiBenh"/>"><bean:write
													name="x" property="tenLoaiBenh" />  </a> 
										</h5>
									</div>
									<div class="luotxem">
										<h5>
											Lượt Xem :
											<bean:write name="x" property="luotXem" />
										</h5>
									</div>
								</div>
							</logic:iterate>
						</logic:notEmpty>

						<logic:notEmpty property="listThuoc" name="timKiemForm">
							<logic:iterate id="x" name="timKiemForm" property="listThuoc">
								<div class="item timkiem">
									<div class="item-title">
										<a 
											href="/MSS/chi-tiet-thuoc.do?ma=<bean:write name="x" property="maThuoc"/>"><bean:write
												name="x" property="tenThuoc" /> </a>
									</div>
									<div class="loaiitem">
										<h5>
											Loại Thuốc : <a 
												href="/MSS/danh-sach-thuoc.do?maNhomThuoc=<bean:write name="x" property="maNhomThuoc"/>"><bean:write
													name="x" property="tenNhomThuoc" /> </a>
										</h5>
										
									</div>
									<div class="luotxem">
										<h5>
											Lượt Xem :
											<bean:write name="x" property="luotXem" />
										</h5>
									</div>
								</div>
							</logic:iterate>

						</logic:notEmpty>

					</div>
					<div class="page-navigation" id="pagination" align="center"></div>
					<script>
						jQuery(function($) {
							var items = $(".item");
							var numItems = items.length;
							var perPage = 8;
							// only show the first 2 (or "first per_page") items initially
							items.slice(perPage).hide();
							// now setup pagination
							$("#pagination").pagination({
								items : numItems,
								prevText: "",
								nextText: ">",
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
				<%@ include file="_menuRight.jsp"%>
			</div>
		</div>
	</html:form>
	<%@ include file="_footer.jsp"%>
</body>
</html>