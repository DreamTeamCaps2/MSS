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
</head>
<body class="hold-transition register-page">
<div class="container" style="height: 450px;  background-color: #F2F2F2;">
	<div class="register-box" style="width: 500px;">
		<div class="register-box-body">
        	<p class="login-box-msg">ĐỔI MẬT KHẨU</p>
        	<html:form action="/mat-khau" method="post" styleId="forgetPass-form">
				<div class="form-group has-feedback">
					<html:text property="tenDangNhap" styleClass="form-control" readonly="true"></html:text>
	          	</div>
	       		<div class="form-group has-feedback">
	       			<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
	            	<input name="matKhau" id="password" type="password" class="form-control" placeholder="Nhập mật khẩu mới">
	          	</div>
	       		<div class="form-group has-feedback">
	       			<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
	            	<input name="matKhau2" type="password" class="form-control" placeholder="Xác nhận mật khẩu">
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
	<%@ include file="_footer.jsp"%> 
</body>
</html>