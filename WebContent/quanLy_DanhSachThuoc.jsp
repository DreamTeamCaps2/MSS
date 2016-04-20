
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
<title>Danh Sách Thuốc</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" />
<link href="css/style.css" rel="stylesheet" type="text/css"
	media="screen,print" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="quanLy_TrangChu.jsp"%>
</head>
<body>
	<div class="container">
		<div class="row">
			<html:form action="/quan-ly-danh-sach-thuoc" method="get">
				<div class="col-lg-3">

					<html:select property="maLoaiThuoc" styleClass="form-control" styleId="select-maLoaiThuoc">
						<option value="">-- Chọn loại thuoc --</option>
						<html:optionsCollection name="thuocForm" property="listLoaiThuoc"
							label="tenLoaiThuoc" value="maLoaiThuoc" />
					</html:select>
					<script>
					$("#select-maLoaiThuoc").change(function(){

					   var maLoaiThuoc = $("#select-maLoaiThuoc").val();
					   var maNhomThuoc = $("#select-maNhomThuoc").val();
					   var timThuoc = $("#select-timThuoc").val();
					   
					   window.location.assign("/MSS/quan-ly-danh-sach-thuoc.do?maLoaiThuoc="+maLoaiThuoc
							   +"&maNhomThuoc="+maNhomThuoc+"&timThuoc="+timThuoc);
					});
					</script> 
				</div>
				<div class="col-lg-3">

					<html:select property="maNhomThuoc" styleClass="form-control" styleId="select-maNhomThuoc">
						<option value="">-- Chọn nhomThuoc --</option>
						<html:optionsCollection name="thuocForm" property="listNhomThuoc"
							label="tenNhomThuoc" value="maNhomThuoc" />
					</html:select>

					<script>
					$("#select-maNhomThuoc").change(function(){

					   var maLoaiThuoc = $("#select-maLoaiThuoc").val();
					   var maNhomThuoc = $("#select-maNhomThuoc").val();
					   var timThuoc = $("#select-timThuoc").val();
					   
					   
					   window.location.assign("/MSS/quan-ly-danh-sach-thuoc.do?maLoaiThuoc="+maLoaiThuoc
							   +"&maNhomThuoc="+maNhomThuoc+"&timThuoc="+timThuoc);
					});
					</script> 

				</div>
				<div class="col-lg-3">
					<html:text property="timThuoc" name="thuocForm"
						styleClass="form-control font-size:50px" styleId="select-timThuoc">
					</html:text>
					<script>
					$("#select-timThuoc").change(function(){

					   var maLoaiThuoc = $("#select-maLoaiThuoc").val();
					   var maNhomThuoc = $("#select-maNhomThuoc").val();
					   var timThuoc = $("#select-timThuoc").val();
					   
					   
					   window.location.assign("/MSS/quan-ly-danh-sach-thuoc.do?maLoaiThuoc="+maLoaiThuoc
							   +"&maNhomThuoc="+maNhomThuoc+"&timThuoc="+timThuoc);
					});
					</script> 						
				</div>
				<div class="col-lg-1">
					<html:link styleClass="btn btn-primary font-size:500px"
						action="/them-thuoc">+</html:link>
				</div>
				<br>
			</html:form>
		</div>
		<div class="panel-body">
			<div class="table-responsive">
				<table class="table table-striped table-bordered table-hover"
					id="dataTables-example">
					<thead>
						<tr>
							<th>Mã thuốc</th>
							<th>Tên thuốc</th>
							<th>Loại thuốc</th>
							<th>Nhóm thuốc</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<logic:iterate name="thuocForm" property="listThuoc" id="t">
							<tr>
								<th scope="row"><bean:write name="t" property="maThuoc" />
								</th>
								<td><bean:write name="t" property="tenThuoc" /></td>
								<td><bean:write name="t" property="tenLoaiThuoc" /></td>
								<td><bean:write name="t" property="tenNhomThuoc" /></td>
								<td><bean:define id="maThuoc" name="t" property="maThuoc"></bean:define>
									<html:link action="/sua-thuoc?maThuoc=${maThuoc}&kt=${0}">
										<span class="glyphicon glyphicon-list"></span>
									</html:link> <html:link action="/xoa-thuoc?maThuoc=${maThuoc}"
										onclick="return confirm('Bạn có muốn xóa thuốc này ?')"
										style="margin-left: 20px;">
										<span class="glyphicon glyphicon-trash"></span>
									</html:link></td>
							</tr>
						</logic:iterate>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>