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
<title>Mua Thuốc</title>

<style type="text/css">
.row p {
	margin: 10px 0px;
	text-align: justify;
}
</style>
<script type="text/javascript"
	src="http://maps.googleapis.com/maps/api/js?sensor=false&libraries=geometry"></script>
<script>
	var string = JSON.stringify(data);

	var data = eval(eval(string));
	var kca = new Array();

	navigator.geolocation
			.getCurrentPosition(
					function(position) {
						var here = new google.maps.LatLng(
								position.coords.latitude,
								position.coords.longitude);

						for ( var i in data) {
							var kc = google.maps.geometry.spherical
									.computeDistanceBetween(
											new google.maps.LatLng(
													data[parseInt(i)].lat,
													data[parseInt(i)].longi),
											new google.maps.LatLng(
													position.coords.latitude,
													position.coords.longitude));

							data[parseInt(i)].kc = Math
									.round(parseFloat(kc) / 100) / 10;

							var id = "#kcmadd" + data[parseInt(i)].ma;
							var kt = document.getElementById("kcmadd"
									+ data[parseInt(i)].ma);
							if (kt != null) {
								document.getElementById("kcmadd"
										+ data[parseInt(i)].ma).innerHTML = document
										.getElementById("kcmadd"
												+ data[parseInt(i)].ma).innerHTML
										+ data[parseInt(i)].kc + " Km";
								console.log(document.getElementById("kcmadd"
										+ data[parseInt(i)].ma).innerHTML);
							}
						}
						for ( var i in data) {
							for ( var j in data) {
								var t;
								var maTiem = document.getElementById("maTiem").value;
								console.log(maTiem);
								if (parseFloat(data[parseInt(j)].kc) > parseFloat(data[parseInt(i)].kc)) {
									t = data[parseInt(i)]
									data[parseInt(i)] = data[parseInt(j)];
									data[parseInt(j)] = t;

								}
							}
						}
						console.log(data);
						var str = "";
						for ( var i in data) {
							kca[i * 2] = data[parseInt(i)].ma;

						}
						for ( var i in kca) {

							var str = str + kca[i] + ",";

						}

						document.getElementById("kca").value = str;

					}, function() {
						handleNoGeolocation(true);
					});
</script>
</head>
<body>
	<html:form action="/mua-thuoc" method="get">
		<div class="container" style="min-height: 100vh;">
			<div class="row">
				<div class="col-lg-8 col-md-8 col-sm-8">
					<div class="title-mua-thuoc">
						<div style="float: left; margin-right: 20px; margin-bottom: 10px;">
							<img
								src="img/<bean:write name="danhSachGiaForm" property="hinhAnh"/>"
								alt="some_text" width="256" height="256">
						</div>
						<div class="thong-tin-thuoc">
							<p style="font-size: 18px;">
								Thuốc : <a
									href="/MSS/chi-tiet-thuoc.do?ma=<bean:write name="danhSachGiaForm" property="maThuoc" />">
									<bean:write name="danhSachGiaForm" property="tenThuoc" />
								</a> <br>
							</p>
							<p style="font-size: 14px;">
								Nhóm Thuốc : <a
									href="/MSS/danh-sach-thuoc.do?maNhomThuoc=<bean:write name="danhSachGiaForm" property="maNhomThuoc" />"><bean:write
										name="danhSachGiaForm" property="tenNhomThuoc" /></a> <br>
							</p>
							<p style="font-size: 14px;">
								Loai Thuốc : <a
									href="/MSS/danh-sach-thuoc.do?maLoaiThuoc=<bean:write name="danhSachGiaForm" property="maNhomThuoc" />"><bean:write
										name="danhSachGiaForm" property="tenLoaiThuoc" /></a> <br>
							</p>
						</div>
					</div>

					<div>
						<h3>
							Danh Sách Các Nhà Thuốc Bán :
							<bean:write name="danhSachGiaForm" property="tenThuoc" />
						</h3>
						<div class="sapxep-mua-thuoc">
							<p >Lọc Kết Quả Theo :</p>
							<html:select property="loaiDiaDiem" styleId="mode">

								<html:option value="1">Theo Tên</html:option>
								<html:option value="2">Theo Giá</html:option>
								<html:option value="3">Theo Khoảng Cách</html:option>


							</html:select>

							<script>
								$("#mode")
										.change(
												function() {
													var maThuoc = <bean:write name="danhSachGiaForm" property="maThuoc" />;
													var t = document
															.getElementById("mode").value
															+ "";
													var kca = document
															.getElementById("kca").value;
													window.location
															.assign("/MSS/mua-thuoc.do?maThuoc="
																	+ maThuoc
																	+ "&loaiDiaDiem="
																	+ t
																	+ "&khoangCach="
																	+ kca);
												});
							</script>
						</div>
						<div class="item-result1">



							<input id="maTiem" type="hidden" name="maThuoc"
								value="<bean:write name="danhSachGiaForm" property="maThuoc" />">
							<script type="text/javascript">
									/* $("[name='loaiDiaDiem']").val('<bean:write name="danhSachGiaForm" property="loaiDiaDiem"/>'); */
								</script>
							<input type="hidden" id="kca" name="kc">


							<logic:iterate name="danhSachGiaForm" property="listGiaThuoc"
								id="tk">
								<div class="item timkiem">
									<bean:define id="ma" name="tk" property="maTiem"></bean:define>
									<div class="item-title">
										
										<a
											href="/MSS/thongTinTKChiTiet.do?tenDangNhap=<bean:write name="tk" property="maTiem"/>">
											Nhà Thuốc: <bean:write name="tk" property="tenTiem" />
										</a>
									</div>
									<div>
										Giá:
										<bean:write name="tk" property="giaThuoc" />
									</div>
									<div id="kcmadd${ma}">Khoảng Cách:</div>
								</div>
							</logic:iterate>
						</div>
					</div>
					<div class="page-navigation" id="pagination" align="center"></div>
					<script>
						jQuery(function($) {
							var items = $(".item.timkiem");
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
							if(numItems<8){
								$("#pagination").hide();
							}
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