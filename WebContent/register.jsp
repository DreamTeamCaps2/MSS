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
<head>
<meta charset="UTF-8">
<title>Đăng Ký Tài Khoản</title>
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<link rel="stylesheet" href="css/login-register/AdminLTE.min.css" />
<link rel="stylesheet" href="css/login-register/blue.css" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/font-awesome.css" />
</head>

<body class="hold-transition register-page">
<div class="register-box" style="width: 500px;">
		<div class="register-box-body">
			<p class="login-box-msg">Register a new membership</p>
			<html:form action="/dangKyTK" method="post" styleId="register-form">
				<div class="form-group has-feedback">
					<span class="glyphicon glyphicon-user form-control-feedback"></span>				
					<input type="text" name="tenDangNhap" class="form-control" placeholder="Username">
				</div>
 				<div class="form-group has-feedback">
					<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
					<input name="email" id="email" type="email" class="form-control" placeholder="Email">
				</div>
				<div class="form-group has-feedback">
					<span class="glyphicon glyphicon-lock form-control-feedback"></span>				
					<input name="matKhau" id="password" type="password" class="form-control" placeholder="Password">
				</div>
				<div class="form-group has-feedback">
					<span class="glyphicon glyphicon-log-in form-control-feedback"></span>
					<input name="matKhau2" type="password" class="form-control"
						placeholder="Retype password"> 
				</div>
<!-- 				<div class="form-group has-feedback">
					<div class="radio">Giới tính:    
						<label>
							<input type="radio" name="gioiTinh" id="optionsRadios1" value="Nam" checked>Nam
						</label>
						<label>
							<input type="radio" name="gioiTinh" id="optionsRadios2" value="Nu">Nữ
						</label>
					</div>      
				</div> -->
				<div class="form-group has-feedback">
					<span class="glyphicon glyphicon-home form-control-feedback"></span>				
					<input name="diaChi" type="text" class="form-control" placeholder="Address">
				</div>
				<div class="form-group has-feedback">
					<span class="glyphicon glyphicon-earphone form-control-feedback"></span>				
					<input name="SDT" type="text" class="form-control" placeholder="Phone"> 
				</div>
				<div class="form-group has-feedback">
					<select class="form-control" id="loaiTK" name="loaiTK">
						<option value="0">Chọn loại Tài Khoản</option>
						<option value="3">Thành viên</option>
						<option value="4">Hiệu thuốc</option>
						<option value="5">Phòng khám</option>
					</select>
				</div>
				<div id="thanhVienPermission">
			        <div class="form-group has-feedback">
						<span class="glyphicon glyphicon-certificate form-control-feedback"></span>				
						<input name="cmnd" type="text" class="form-control" placeholder="ID Code"> 
					</div>
    			</div>
    			<div id="hieuThuocPermission">
			        <div class="form-group has-feedback">
						<span class="glyphicon glyphicon-plus form-control-feedback"></span>				
						<input name="tenNhaThuoc" type="text" class="form-control" placeholder="Drugstore"> 
					</div>
    			</div>
    			<div id="phongKhamPermission">
			        <div class="form-group has-feedback">
						<span class="glyphicon glyphicon-plus form-control-feedback"></span>				
						<input name="tenPhongKham" type="text" class="form-control" placeholder="Clinic"> 
					</div>
			        <div class="form-group has-feedback">
						<span class="glyphicon glyphicon-info-sign form-control-feedback"></span>				
						<textarea name="moTa" class="form-control" rows="3" placeholder="Description ..."></textarea>
					</div>
					<div class="form-group has-feedback">
						<span class="glyphicon glyphicon-time form-control-feedback"></span>				
						<input name="thoiGian" type="text" class="form-control" placeholder="Time"> 
					</div>
    			</div>
				<div class="row">
					<div class="col-xs-8">
						<div class="checkbox icheck">
							<label> 
								<input id="terms" name="terms" type="checkbox"> I agree to the <a href="#">terms</a>
							</label>
						</div>
					</div>
					<!-- /.col -->
					<div class="col-xs-4">
						<html:submit styleClass="btn btn-primary btn-block btn-flat" property="submit" value="OK">Register</html:submit>
					</div>
					<!-- /.col -->
				</div>
			</html:form>
			<a href="login_admin.jsp" class="text-center">I already have a membership</a>
		</div>
	</div>
    <script src="js/login-register/jQuery-2.1.4.min.js"></script>
    <!-- Bootstrap 3.3.5 -->
    <script src="js/bootstrap.min.js"></script>

  	<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.3.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>
  	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/additional-methods.min.js"></script>
	<script src="js/validation.js"></script>
	    <!-- iCheck -->
    <script src="js/login-register/icheck.min.js"></script>
    <script>
      $(function () {
        $('input').iCheck({
          checkboxClass: 'icheckbox_square-blue',
          radioClass: 'iradio_square-blue',
          increaseArea: '20%' // optional
        });
      });
      $(document).ready(function () {
    	    toggleFields(); 
    	    $("#loaiTK").change(function () {
    	        toggleFields();
    	    });

    	});
    	function toggleFields() {
    	    if ($("#loaiTK").val() == 3)
    	        $("#thanhVienPermission").show();
    	    else
    	        $("#thanhVienPermission").hide();
    	    if ($("#loaiTK").val() == 4)
    	        $("#hieuThuocPermission").show();
    	    else
    	        $("#hieuThuocPermission").hide();
    	    if ($("#loaiTK").val() == 5)
    	        $("#phongKhamPermission").show();
    	    else
    	        $("#phongKhamPermission").hide();
    	}
    </script>	
    
</body>
</html>