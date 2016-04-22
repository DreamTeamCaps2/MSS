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
<title>jQuery Dropdown Login Freebie | The Finished Box</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css" />
	<link rel="stylesheet" href="css/reviewdao.vn.css" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />	
<style>
.active {
    font-size: 13px;
    border-bottom: 0px;
}
</style>
</head>
<body>
	<div class="container text-center" style="width: 1200px;">
		<div class="row">
			<div class="col-sm-3 well">
				<div class="well">
					<p>
						<a href="#">My Profile</a>
					</p>
					<img src="img/bird.jpg" class="img-circle" height="100" width="100"
						alt="Avatar">
				</div>
				<div class="well">
					<ul class="nav nav-pills nav-stacked" role="tablist">
						<li><html:link action="thongTinTK?tenDangNhap=${taiKhoan.tenDangNhap}">Thông tin tài khoản</html:link></li>
						<li><a href="changePassWord.jsp">Đổi mật khẩu</a></li>
						<li><a href="#">Thông báo</a></li>
						<li><a href="#">Tin nhắn</a></li>
						<li><a href="#">Đã lưu</a></li>
						<logic:notEmpty name="taiKhoan1" property="tenNhaThuoc">
							<li class="active"><a href="#">Quản lý thuốc</a></li>
						</logic:notEmpty>
						<logic:notEmpty name="taiKhoan1" property="tenPhongKham">
							<li><a href="#">Quản lý phòng khám</a></li>
						</logic:notEmpty>
					</ul>
				</div>
				<div class="well">
					<p>
						<a href="#">Interests</a>
					</p>
					<p>
						<span class="label label-default">News</span> <span
							class="label label-primary">W3Schools</span> <span
							class="label label-success">Labels</span> <span
							class="label label-info">Football</span> <span
							class="label label-warning">Gaming</span> <span
							class="label label-danger">Friends</span>
					</p>
				</div>
			</div>
			<div class="col-sm-9">
				<h3>QUẢN LÝ GIÁ THUỐC</h3>
				<div class="row"></div>
				<div class="panel panel-default text-left">
					<div class="panel-body">
						<div class="col-lg-12" style="    padding-bottom: 20px;">
							<a data-toggle="modal" data-target="#myModal"
							class="btn btn-primary" href="#">Thêm thuốc cửa hàng</a>
						</div>
						<br>
						<div>
							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>Mã Thuốc</th>
										<th>Tên Thuốc</th>
										<th>Giá</th>
										<th>Thông tin</th>
									</tr>
								</thead>
								<tbody>
									<logic:iterate name="thuocForm" property="listThuocCuaHang" id="ch">
										<tr>
											<th scope="row"><bean:write name="ch" property="maThuoc" /></th>
											<td><bean:write name="ch" property="tenThuoc" /></td>

											<td>
												<html:text name="ch" property="giaThuoc" styleClass="form-control"></html:text>
												<html:button property="" styleClass="form-control">CẬP NHẬT</html:button>
											</td>
											<td>
											</td>
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

		<div class="modal fade" id="myModal" role="dialog" data-keyboard="false" data-backdrop="static">
			<div class="modal-dialog" style="width: 800px;">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header" style="padding: 20px 30px;">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4>
							<span class="glyphicon glyphicon-search"></span> Tra Cứu Thuốc
						</h4>
					</div>
					<div class="modal-body" style="padding: 20px 20px;">
						<table id="example" class="table table-striped"
							style="border: 2px solid gray; width: 100%;">
							<thead>
								<tr>
										<th>Mã Thuốc</th>
										<th>Tên Thuốc</th>
										<th>Giá</th>
										<th>Thông tin</th>
								</tr>
							</thead>
							<tbody id="tableSearch">
								<logic:iterate name="thuocForm" property="listThuoc" id="ch">
										<bean:define id="btnviet" name="ch" property="maThuoc"></bean:define>
										<bean:define id="txtviet" name="ch" property="giaThuoc"></bean:define>
										<tr id="rowThuoc${btnviet}">
											<th scope="row"><bean:write name="ch" property="maThuoc" /></th>
											<td><bean:write name="ch" property="tenThuoc" /></td>
											<td>
												<html:text styleId="txt_Input_Gia${btnviet}" name="ch" property="giaThuoc" styleClass="form-control"></html:text>
											</td>
											<td>
												<html:button onclick="Vietclick(${btnviet},${txtviet})" property="maThuoc" styleClass="form-control">CẬP NHẬT</html:button>
											</td>
										</tr>
									</logic:iterate>
									<script>
											function Vietclick(idthuoc,giathuoc) {
											   var requestData = {
													   idthuoc: idthuoc,
													   giathuoc: $('#txt_Input_Gia'+idthuoc).val()
										            };
											   console.log('#rowThuoc'+idthuoc);
											   $('#rowThuoc'+idthuoc).hide();
										            $.ajax({
										                url: '/MSS/quan-ly-thuoc-cua-hang.do',
										                type: 'POST',
										                data: requestData,
										                dataType: 'json',
										                success:function(data,status){
										                	$('#rowThuoc'+idthuoc).hide();
														},
														error:function(data,status){
														}
										            });
											}
											</script>
							</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="submit"
							class="btn btn-danger btn-default pull-right"
							data-dismiss="modal">
							<span class="glyphicon glyphicon-remove"></span> Cancel
						</button>
					</div>
				</div>

			</div>
		</div>


	<script src="js/dataTables/jquery.dataTables.js"></script>
	<script src="js/dataTables/dataTables.bootstrap.js"></script>
	<script>
            $(document).ready(function () {
                $('#dataTables-example').dataTable({
                	"order": [[ 3, "desc" ]],
                	"autoWidth": false,
	                "columnDefs": [
	                               { "targets": [2,3], "searchable": false }
	                           ]
                });
                $('#example').dataTable({
                	"order": [[ 3, "desc" ]],
                	"autoWidth": false,
	                "columnDefs": [
	                               { "targets": [2,3], "searchable": false }
	                           ]
                });
            });
            $('#myModal').on('hidden.bs.modal', function () {
            	window.location.assign("/MSS/quan-ly-thuoc-cua-hang.do");
            })
    </script>
</body>
<%@ include file="_footer.jsp"%>
</html>