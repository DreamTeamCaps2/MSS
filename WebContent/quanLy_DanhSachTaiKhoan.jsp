<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<html>
<head lang="en">
<meta charset="UTF-8">
<title>Danh Sách Tài Khoản</title>
<%@ include file="quanLy_TrangChu.jsp"%>
</head>
<body>
	<div class="container" style="padding-bottom: 50px">
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
		<br>
		<div class="box">
			<div class="box-body">
				<table class="table table-striped table-bordered dt-bootstrap" id="dataTables-example">
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
									<a onclick="khoaTKClick(${maTaiKhoan})" id="lock-toggle${maTaiKhoan}" href="#">
										<logic:equal name="tk" property="trangThai" value="1" >
											<span class="glyphicon glyphicon-ok-circle" style="margin-left: 20px;"></span>
										</logic:equal>
										<logic:equal name="tk" property="trangThai" value="0" >
											<span class="glyphicon glyphicon-ban-circle" style="margin-left: 20px;"></span>
										</logic:equal>
									</a> 
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
	<script type="text/javascript">
		$(document).ready(function() {
			$('#dataTables-example').dataTable({
				"order" : [ [ 0, "desc" ] ],
				"searching": false,
				"columnDefs" : [ 
				  	{"width": "10%", "targets": 0},
					{"width": "30%", "targets": 1},
					{"width": "50%", "targets": 2},
					{"width": "10%", "targets": 3},
					{ "orderable": false, "targets": -1 }
				  ]
			});
		});
		function khoaTKClick(maTaiKhoan) {
			var result = confirm('Bạn có chắc chắn ?');
			if(result){
			  //$('#lock-toggle'+maTaiKhoan).find('span').toggleClass('glyphicon glyphicon-ok-circle').toggleClass('glyphicon glyphicon-ban-circle');
			  var sa =  $('#lock-toggle'+maTaiKhoan).find('span');
			  var tt = 0;
			  if(sa.hasClass('glyphicon glyphicon-ok-circle')){
			   		sa.removeClass('glyphicon glyphicon-ok-circle').addClass('glyphicon glyphicon-ban-circle');
			   		tt = 0;
			  }
			  else{
				  sa.removeClass('glyphicon glyphicon-ban-circle').addClass('glyphicon glyphicon-ok-circle');
				  tt = 1;
			  } 
			   var requestData = {
					   maTaiKhoanKhoa: maTaiKhoan,
					   trangThai: tt
		            };
		            $.ajax({
		                url: '/MSS/quan-ly-danh-sach-tai-khoan.do',
		                type: 'POST',
		                data: requestData,
		                dataType: 'json',
		                success:function(data,status){
						},
						error:function(data,status){
						}
		            });
			}
		}
	</script>

</body>
</html>