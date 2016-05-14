<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<html>
<%@ include file="login.jsp"%>
<head>
<meta charset="utf8">
<title>Đã Lưu</title>

<style>
.active {
    font-size: 13px;
    border-bottom: 0px;
}
</style>
</head>
<body>
	<div class="container text-center">
		<div class="row" style="width: inherit; margin-left: 0px; margin-right: 0px;">
	    <div class="col-sm-3" style="margin-top: 15px;">
				<div class="well">
					<p>
						<a href="#">My Profile</a>
					</p>
					<img src="img/${taiKhoan.anhDaiDien}" class="img-circle" height="100" width="100"
						alt="Avatar">
				</div>
				<div class="well">
					<ul class="nav nav-pills nav-stacked" role="tablist">
					    <li><html:link action="thongTinTK">Thông tin tài khoản</html:link></li>
						<li><a href="/MSS/doi-mat-khau.do">Đổi mật khẩu</a></li>
					    <li class="active"><a href="/MSS/danh-sach-da-luu.do">Đã lưu</a></li>
					    <logic:notEmpty name="taiKhoan1" property="tenNhaThuoc">
					    <li><html:link action="/quan-ly-thuoc-cua-hang">Quản lý thuốc</html:link></li>
					    </logic:notEmpty>
					    <logic:notEmpty name="taiKhoan1" property="tenPhongKham">
					    <li><a href="#">Quản lý phòng khám</a></li>
					    </logic:notEmpty>
				  	</ul>
				</div>
			</div>
			<div class="col-sm-9">
				<h3>ĐÃ LƯU</h3>
				<div class="row"></div>
				<div class="panel panel-default text-left">
					<div class="panel-body">
						<br>
						<div>
							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>Mã </th>
										<th>Tên</th>
										<th>Thông tin</th>
									</tr>
								</thead>
								<tbody>
									<logic:iterate name="taiKhoanForm" property="listDanhDau" id="ch">
										<tr>
											<th scope="row"><bean:write name="ch" property="id" /></th>
											<td><bean:write name="ch" property="tenDanhDau" /></td>
											<td></td>
										</tr>

									</logic:iterate>

								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>



	<script src="js/dataTables/jquery.dataTables.js"></script>
	<script src="js/dataTables/dataTables.bootstrap.js"></script>
	<script>
            $(document).ready(function () {
                $('#dataTables-example').dataTable({
                	"autoWidth": false,
	                "columnDefs": [
	                               { "targets": [2], "searchable": false }
	                           ]
                });
            });
    </script>
</body>
<%@ include file="_footer.jsp"%>
</html>