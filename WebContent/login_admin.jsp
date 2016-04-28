<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>Đăng Nhập</title>
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<link rel="stylesheet" href="css/login-register/AdminLTE.min.css" />
<link rel="stylesheet" href="css/login-register/blue.css" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<%@ include file="login.jsp"%>
<body class="hold-transition register-page">
	<div class="register-box" style="width: 500px;">
		<div class="register-box-body">
        	<p class="login-box-msg">Sign in to start your session</p>
<%--         	<logic:notPresent name="kiemtra">
        		<h5><p class="alert alert-danger alert-dismissable" style="text-align: center;font-weight: 700;"><i class="icon fa fa-ban"></i>ĐĂNG NHẬP KHÔNG THÀNH CÔNG</p></h5>
        	</logic:notPresent> --%>
<%--         	<logic:notEmpty name="kiemtra">
        		<h5><p class="alert alert-danger alert-dismissable" style="text-align: center;font-weight: 700;"><i class="icon fa fa-ban"></i>ĐĂNG NHẬP KHÔNG THÀNH CÔNG</p></h5>
        	</logic:notEmpty> --%>
        	<logic:equal name="kiemtra" value="1">
        		<h5><p class="alert alert-danger alert-dismissable" style="text-align: center;font-weight: 700;"><i class="icon fa fa-ban"></i>ĐĂNG NHẬP KHÔNG THÀNH CÔNG</p></h5>
        	</logic:equal>
        	<logic:equal name="kiemtra" value="3">
        		<h5><p class="alert alert-danger alert-dismissable" style="text-align: center;font-weight: 700;"><i class="icon fa fa-ban"></i>TÀI KHOẢN ĐÃ BỊ KHÓA</p></h5>
        	</logic:equal>
        	
			<html:form action="/login" method="post">
				<div class="form-group has-feedback">
	            	<input name="tenDangNhap" type="text" class="form-control" placeholder="Username">
	            	<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
	          	</div>
	          	<div class="form-group has-feedback">
	          	  	<input name="matKhau" type="password" class="form-control" placeholder="Password">
	            	<span class="glyphicon glyphicon-lock form-control-feedback"></span>
	          	</div>
				<div class="row">
					<div class="col-xs-8">
						<div class="checkbox icheck">
			                <label>
			                  <input type="checkbox"> Remember Me
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
	        <a href="#" style="    color: #337ab7;">I forgot my password</a><br>
	        <a href="register.jsp" style="    color: #337ab7;" class="text-center">Register a new membership</a>
		</div>
	</div>
    <script src="js/login-register/jQuery-2.1.4.min.js"></script>
    <!-- Bootstrap 3.3.5 -->
    <script src="js/bootstrap.min.js"></script>
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
    </script>	
</body>
</html>