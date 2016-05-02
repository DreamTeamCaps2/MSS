
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<html>
<head lang="en">
<meta charset="UTF-8">
<title>Danh Sách Góp Ý</title>

<!-- <link rel="stylesheet" href="css/style.css" />
<link href="css/style.css" rel="stylesheet" type="text/css"
	media="screen,print" /> -->
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="quanLy_TrangChu.jsp"%>
<link rel="stylesheet" href="css/bootstrap.min.css" />
</head>
<script>
	
	$(document).ready(function(){
	    $("#selectGopY").change(function(){
	    	window.location.assign("/MSS/quan-ly-gop-y.do?loaiGopY="+$('#selectGopY').val()+"&tinhTrang="+$('#selectTinhTrang').val());
	    });
	    $("#selectTinhTrang").change(function(){
	    	window.location.assign("/MSS/quan-ly-gop-y.do?loaiGopY="+$('#selectGopY').val()+"&tinhTrang="+$('#selectTinhTrang').val());
	    });
	});
	
</script>
<body>
	<html:form action="/quan-ly-gop-y" onsubmit="return false">
		<div class="container">
			<div class="form-style">
				<p>
					<label>Loại Góp Ý</label>
					<html:select property="loaiGopY" styleId="selectGopY"
						name="thongBaoForm">
						<html:option value="0">-- Chọn loại Góp Ý --</html:option>
						<html:option value="1">Bệnh</html:option>
						<html:option value="2">Thuốc</html:option>
						<html:option value="4">Khác</html:option>
					</html:select>
				</p>
			</div>
			<div class="form-style">
				<p>
					<label>Tình Trạng</label>
					<html:select property="tinhTrang" name="thongBaoForm"
						styleId="selectTinhTrang">
						<html:option value="0">Chưa Xem</html:option>
						<html:option value="1">Đã Xem</html:option>
						<html:option value="2">Tất Cả</html:option>
					</html:select>
				</p>
			</div>

			<!-- table -->
			<div class="">
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th style="width: 30%;">Chủ Đề</th>
								<th style="width: 40%;">Nội Dung</th>
								<th style="width: 20%;">Thời Gian</th>
								<th style="width: 10%;">Chức Năng</th>
							</tr>
						</thead>
						<tbody>
							<logic:iterate id="x" property="listThongBao" name="thongBaoForm">
								<tr>
									<td><bean:write name="x" property="chuDe" /></td>
									<td><bean:write name="x" property="noiDung" /></td>
									<td><bean:write name="x" property="thoiGian" /></td>

									<td><a
										href="/MSS/chi-tiet-gop-y.do?maGopY=<bean:write name="x" property="maGopY"/>"><span
											class="glyphicon glyphicon-list-alt"></span></a> <a
										href="/MSS/quan-ly-gop-y.do?maGopY=<bean:write name="x" property="maGopY"/>&xoa=1"><span
											class="glyphicon glyphicon-trash"></span></a> <logic:equal
											value="2" name="thongBaoForm" property="tinhTrang">

											<logic:equal value="0" name="x" property="tinhTrang">
												<a
													href="/MSS/quan-ly-gop-y.do?maGopY=<bean:write name="x" property="maGopY"/>&tinhTrang=2&loaiGopY=
												<bean:write name="thongBaoForm" property="loaiGopY"/>&tinhTrangUpdate=0"><span
													class="	glyphicon glyphicon-check"></span></a>
											</logic:equal>
											<logic:equal value="1" name="x" property="tinhTrang">
												<a
													href="/MSS/quan-ly-gop-y.do?maGopY=<bean:write name="x" property="maGopY"/>&tinhTrang=2&loaiGopY=
												<bean:write name="thongBaoForm" property="loaiGopY"/>&tinhTrangUpdate=1"><span
													class="	glyphicon glyphicon-unchecked"></span></a>
											</logic:equal>
										</logic:equal> <logic:equal value="0" name="thongBaoForm"
											property="tinhTrang">
											<a
												href="/MSS/quan-ly-gop-y.do?maGopY=<bean:write name="x" property="maGopY"/>&tinhTrang=0&loaiGopY=
												<bean:write name="thongBaoForm" property="loaiGopY"/>&tinhTrangUpdate=0"><span
												class="	glyphicon glyphicon-check"></span></a>
										</logic:equal> 
										<logic:equal value="1" name="thongBaoForm"
											property="tinhTrang">
											<a
												href="/MSS/quan-ly-gop-y.do?maGopY=<bean:write name="x" property="maGopY"/>&tinhTrang=1&loaiGopY=
												<bean:write name="thongBaoForm" property="loaiGopY"/>&tinhTrangUpdate=1"><span
												class="	glyphicon glyphicon-unchecked"></span></a>
										</logic:equal></td>

								</tr>
							</logic:iterate>

						</tbody>
					</table>
				</div>
			</div>
		</div>

	</html:form>
</body>
</html>