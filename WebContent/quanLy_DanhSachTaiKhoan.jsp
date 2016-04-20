<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<html>
<head lang="en">
<meta charset="UTF-8">
<title>Danh Sách Bệnh</title>

<!-- <link rel="stylesheet" href="css/style.css" />
<link href="css/style.css" rel="stylesheet" type="text/css"
	media="screen,print" /> -->
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="quanLy_TrangChu.jsp"%>
<link rel="stylesheet" href="css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<div class="row">
			<html:form action="/quan-ly-danh-sach-tai-khoan" method="get">
			<div class="col-lg-3">
					<html:select property="maLoaiTaiKhoan" styleClass="form-control" styleId="select-maLoaiTaiKhoan">
						<option value="">-- Chọn loại tài khoản --</option>
						<html:optionsCollection name="taiKhoanForm"
						property="listLoaiTaiKhoan" label="tenLoaiTaiKhoan" value="maLoaiTaiKhoan" />
					</html:select>	
			</div>
			<script>
					$("#select-maLoaiTaiKhoan").change(function(){

					   var maLoaiTaiKhoan = $("#select-maLoaiTaiKhoan").val();
					   var timTaiKhoan = $("#select-timTaiKhoan").val();
					   
					   
					   window.location.assign("/MSS/quan-ly-danh-sach-tai-khoan.do?maLoaiTaiKhoan="+maLoaiTaiKhoan
							   +"&timTaiKhoan="+timTaiKhoan);
					});
			</script> 
			<div class="col-lg-3">
					<html:select property="maQuyen" styleClass="form-control" styleId="select-maQuyen">
						<option value="">-- Chọn Quyền --</option>
						<html:optionsCollection name="taiKhoanForm"
						property="listQuyen" label="tenQuyen" value="maQuyen" />
					</html:select>	
			</div>  
			<script>
					$("#select-maQuyen").change(function(){

					   var maQuyen = $("#select-maQuyen").val();
					   var timTaiKhoan = $("#select-timTaiKhoan").val();
					   
					   
					   window.location.assign("/MSS/quan-ly-danh-sach-tai-khoan.do?maQuyen="+maQuyen
							   +"&timTaiKhoan="+timTaiKhoan+"&maLoaiTaiKhoan="+0);
					});
			</script> 
			<div class="col-lg-3">
				<html:text property="timTaiKhoan" name="taiKhoanForm"
					styleClass="form-control font-size:50px" styleId="select-timTaiKhoan"></html:text>
			</div>
			<script>
					$("#select-timTaiKhoan").change(function(){

					   var maQuyen = $("#select-maQuyen").val();
					   var maLoaiTaiKhoan = $("#select-maLoaiTaiKhoan").val();
					   var timTaiKhoan = $("#select-timTaiKhoan").val();
					   
					   
					   window.location.assign("/MSS/quan-ly-danh-sach-tai-khoan.do?maQuyen="+maQuyen
							   +"&maLoaiTaiKhoan="+maLoaiTaiKhoan+"&timTaiKhoan="+timTaiKhoan);
					});
			</script> 
			</html:form>
		</div>
		<div class="panel-body">
			<div class="table-responsive">
				<table class="table table-striped table-bordered table-hover"
					id="dataTables-example">
					<thead>
						<tr>
							<th>Mã tài khoản</th>
							<th>Tên đăng nhập</th>
							<th>Loại tài khoản</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<logic:iterate name="taiKhoanForm" property="listTaiKhoan" id="tk">
							<tr>
								<th scope="row"><bean:write name="tk" property="maTaiKhoan" /></th>
								<td><bean:write name="tk" property="tenDangNhap" /></td>
								<td><bean:write name="tk" property="tenLoaiTaiKhoan" /></td>
								<td>
								<bean:define id="maTaiKhoan" name="tk" property="maTaiKhoan"></bean:define> 
									<html:link action="/xoa--tai-khoan?maTaiKhoan=${maTaiKhoan}"
										onclick="return confirm('Bạn có muốn xóa tài khoản này ?')">
										<span class="glyphicon glyphicon-trash"></span>
									</html:link>
									<logic:notEmpty name="tk" property="loaiTK">
									<html:link
										action="/phan-quyen?maTaiKhoan=${maTaiKhoan}" style="margin-left: 20px;">
										<span class="glyphicon glyphicon-list"></span>
									</html:link> 
									</logic:notEmpty>
								</td>
							</tr>
						</logic:iterate>
					</tbody>
				</table>
			</div>
		</div>
	</div>


</body>
</html>