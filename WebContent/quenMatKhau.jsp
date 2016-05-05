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
<head lang="en">
<meta charset="UTF-8">
<title>Quên Mật Khẩu</title>
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
<body class="hold-transition register-page">
<div class="container" style="height: 450px;  background-color: #F2F2F2;">
	<div class="register-box" style="width: 500px;">
		<div class="register-box-body">
        	<p class="login-box-msg">QUÊN MẬT KHẨU</p>
        	<html:form action="/quen-mat-khau" method="post" styleId="quenMatKhau-form">
				<div class="form-group has-feedback">
					<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
	            	<input name="email" type="text" class="form-control" placeholder="Nhập địa chỉ email">
	          	</div>
				<div class="row">
					<!-- /.col -->
					<div class="col-xs-4">
						<html:submit styleClass="btn btn-primary btn-block btn-flat" property="submit" value="OK">Register</html:submit>
					</div>
					<!-- /.col -->
				</div>
			</html:form>
		</div>
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
    </script>	
    <%@ include file="_footer.jsp"%> 
</body>
</html>