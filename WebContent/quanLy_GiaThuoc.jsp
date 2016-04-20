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
<style>
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}
</style>
</head>
<body>
	<div class="container text-center" style="padding-top: 0px">
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
						<li><html:link action="thongTinTK">Thông tin tài khoản</html:link></li>
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
				<h3>THÔNG TIN TÀI KHOẢN</h3>
				<div class="row"></div>
				<div class="panel panel-default text-left">
					<div class="panel-body">
						<div class="col-lg-3">
							<a data-toggle="modal" data-target="#myModal"
							class="btn btn-primary" href="#">Tra Cứu Thuốc cửa hàng</a>
						</div>
						<html:link style="margin-bottom: 20px;"
							styleClass="btn btn-primary " action="/them-thuoc-cho-cua-hang">Thêm thuốc cho cửa hàng</html:link>
						<br>
						<div class="table-responsive">
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
									<logic:iterate name="thuocForm" property="listThuoc" id="ch">
										<tr>
											<th scope="row"><bean:write name="ch" property="maThuoc" /></th>
											<td><bean:write name="ch" property="tenThuoc" /></td>

											<td>
												<html:text name="ch" property="giaThuoc" styleClass="form-control"></html:text>
												<html:button property="" styleClass="form-control">CẬP NHẬT</html:button>
											</td>

											<td>
												<%-- 												<bean:define id="maMatHang" name="ch" property="maMatHang"></bean:define>
												<html:link action="/suaMH?maMatHang=${maMatHang}"
													style="margin-left: 20px;">
													<span class="glyphicon glyphicon-edit"></span>
												</html:link>
												<html:link  action="/xoaMH?maMatHang=${maMatHang}"
														onclick="return confirm('Bạn có muốn xóa mặt hàng ${tenMatHang} ?')"
														style="margin-left: 20px;">
													<span class="glyphicon glyphicon-trash"></span>
												</html:link> --%>
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
	<div>
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog" style="width: 800px;">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header" style="padding: 20px 30px;">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4>
							<span class="glyphicon glyphicon-search"></span> Tra Cứu Khách
							Hàng
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
											<th scope="row"><bean:write name="ch" property="maThuoc" />ashvd</th>
											<td><bean:write name="ch" property="tenThuoc" /></td>
											<td>
												<html:text styleId="txt_Input_Gia${btnviet}" name="ch" property="giaThuoc" styleClass="form-control"></html:text>
											</td>
											<td>
												<html:button onclick="Vietclick(${btnviet},${txtviet})" property="maThuoc" styleClass="form-control">CẬP NHẬT</html:button>
											</td>
											<script>
											function Vietclick(idthuoc,giathuoc) {
											   alert(idthuoc);
											   
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
															//
										                	console.log('fuck');
										                	// xl database
										                	$('#rowThuoc'+idthuoc).hide();
															
															
														},
														error:function(data,status){
															
														}
										            });
											   
											   alert($('#txt_Input_Gia'+idthuoc).val());
											}
											</script>
										</tr>
									</logic:iterate>
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
	</div>

	<footer class="container-fluid text-center">
		<p>Footer Text</p>
	</footer>
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
            });
            
            $('#btn_CapNhat').click(function(){
            	console.log('idthuoc : '+this.data('idthuoc'));
            	
            });
            
/*             $(document).ready(function() {
                $('#example').DataTable( {
                    select: true,
                    language: {
                        select: {
                            rows: {
                                _: "You have selected %d rows",
                                0: "Click a row to select it",
                                1: "Only 1 row selected"
                            }
                        }
                    }
                } );
            } ); */
            var table = $('#example').dataTable();
            
            $('#example tbody').on( 'click', 'td', function () {
            	
                alert( table.cell( this ).$('input, select').serialize() );
            } );
    </script>
</body>
</html>