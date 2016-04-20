<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<html>
<%@ include file="login.jsp"%>
<head>
    <meta charset="utf8">
    <title>jQuery Dropdown Login Freebie | The Finished Box</title>
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
	        <p><a href="#">My Profile</a></p>
	        <img src="img/bird.jpg" class="img-circle" height="100" width="100" alt="Avatar">
	      </div>
	      <div class="well">
			<ul class="nav nav-pills nav-stacked" role="tablist">
			    <li><html:link action="thongTinTK?tenDangNhap=${taiKhoan1.tenDangNhap}">Thông tin tài khoản</html:link></li>
				<li class="active"><a href="changePassWord.jsp">Đổi mật khẩu</a></li>
			    <li><a href="#">Thông báo</a></li>
			    <li><a href="#">Tin nhắn</a></li>
			    <li><a href="#">Đã lưu</a></li>
		  	</ul>
	      </div>
	      <div class="well">
	        <p><a href="#">Interests</a></p>
	        <p>
	          <span class="label label-default">News</span>
	          <span class="label label-primary">W3Schools</span>
	          <span class="label label-success">Labels</span>
	          <span class="label label-info">Football</span>
	          <span class="label label-warning">Gaming</span>
	          <span class="label label-danger">Friends</span>
	        </p>
	      </div>
	    </div>
    <div class="col-sm-7">
    	<h3>ĐỔI MẬT KHẨU</h3>
      <div class="row">
        <div class="col-sm-12">
        	<div class="panel panel-default text-left">
            <div class="panel-body">
				<html:form action="/doi-mat-khau" method="post" styleId="changePass-form">
			        <div class="row form-group">
			            <label class="col-lg-4">Mật Khẩu cũ</label>
			            <div class="col-lg-6">
			            	<input name="matKhau" type="password" class="form-control" placeholder="Old Password">
			            </div>
			        </div>
			        <div class="row form-group">
			            <label class="col-lg-4">Mật Khẩu mới</label>
			            <div class="col-lg-6">
			            	<input name="matKhauNew" id="password" type="password" class="form-control" placeholder="Password">
			            </div>
			        </div>
			        <div class="row form-group">
			            <label class="col-lg-4">Nhập lại Mật Khẩu</label>
			            <div class="col-lg-6">
			            	<input name="matKhau2" type="password" class="form-control" placeholder="Password">
			            </div>
			        </div>			        			        
			        <div class="row form-group">
			            <div class="col-lg-4 col-lg-offset-6">
			            	<html:submit styleClass="btn btn-primary" property="submit" value="OK">Thêm mới</html:submit>
			            	<html:link action="/login.jsp" styleClass="btn btn-primary">Trang chủ</html:link>
			            </div>
			        </div>
			    </html:form>
			   </div>
		    </div>
	    </div>

		</div>
	</div>
		    <div class="col-sm-2 well">
	    </div>
	</div>
	</div>
	<footer class="container-fluid text-center" >
	  <p>Footer Text</p>
	</footer>
	<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.3.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>
  	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/additional-methods.min.js"></script>
	<script src="js/validation.js"></script>
</body>
</html>