<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<html>
<head lang="en">
<meta charset="UTF-8">
<title>Quản Lý Nhóm Thuốc</title>
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
		<html:form action="/quan-ly-nhom-thuoc">
					<script>
						var t=<bean:write name="nhomThuocForm" property="thongBao"/>
						if(t=="1"){
							alert("Không thể xóa vì loại này chứa nhiều thuốc!!!");
						}
						if(t=="2"){
							alert("xóa Thành Công !!!!");
						}
					</script>
			<div class="row">
				<div class="col-lg-12">
					<div class="row">
						<div class=row>
							<div class="col-lg-2">Tên Nhóm Thuốc</div>
							<div class=col-lg-7>
								<input type="text" name="tenNhomThuoc"
									placeholder="Tên Nhóm Thuốc" size="50px;">
								<html:errors property="tenNhomThuocError"/>	
							</div>
							

						</div>
						<div class="row">
							<div class="col-lg-7" style="padding-top: 30px; padding-bottom: 30px;">
								<html:select property="maLoaiThuoc" styleClass="form-control">
									<option value="">-- Chọn Loại Thuốc --</option>
									<html:optionsCollection name="nhomThuocForm"
										property="listLoaiThuoc" label="tenLoaiThuoc"
										value="maLoaiThuoc" />
								</html:select>
								<html:errors property="loaiThuocError"/>
							</div>
						</div>
						<div class="col-lg-3 col-lg-offset-2">
							<html:submit styleClass="btn btn-primary" property="submit"
								value="Add"></html:submit>
						</div>



					</div>
					
					<div class="row">
						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr>
										<th>Mã Nhóm Thuốc</th>
										<th>Tên Nhóm Thuốc</th>
										<th>Thuộc Loại Thuốc</th>
									</tr>
								</thead>
								<tbody>
									<logic:iterate id="x" property="listNhomThuoc" name="nhomThuocForm">
										<tr>
											<td><bean:write name="x" property="maNhomThuoc"/></td>
											<td><bean:write name="x" property="tenNhomThuoc"/></td>
											<td><bean:write name="x" property="tenLoaiThuoc"/></td>
											<td><a onclick="return confirm('Bạn có chắc chắn muốn xóa  ?')" href="/MSS/quan-ly-nhom-thuoc-xoa.do?maNhomThuoc=<bean:write name="x" property="maNhomThuoc"/>"><span class="glyphicon glyphicon-trash"></span></a></td>
										</tr>
									</logic:iterate>
								
								</tbody>
							</table>
						</div>
					</div>


				</div>
			</div>
		</html:form>
	</div>
</body>
</html>