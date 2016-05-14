<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<html>
<%@ include file="login.jsp"%>
<head>
    <meta charset="utf8">
    <title>Đổi mật khẩu</title>
  	<style>
	    .active {
	    font-size: 14px;
	    border-bottom: 0px;
		}
  </style>
</head>
<body>
    <div class="container text-center">    
		<div class="row">
	    <div class="col-sm-3" style="margin-top: 15px;">
	      <div class="well">
	        <p><a href="#">My Profile</a></p>
	        <img src="img/${taiKhoan.anhDaiDien}" class="img-circle" height="100" width="100" alt="Avatar">
	      </div>
	      <div class="well">
			<ul class="nav nav-pills nav-stacked" role="tablist">
			    <li><html:link action="thongTinTK">Thông tin tài khoản</html:link></li>
				<li class="active"><a href="/MSS/doi-mat-khau.do">Đổi mật khẩu</a></li>
			    <li><a href="/MSS/danh-sach-da-luu.do">Đã lưu</a></li>
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
			            </div>
			        </div>
			    </html:form>
			   </div>
		    </div>
	    </div>

		</div>
	</div>
	</div>
	</div>
	<script src="js/jquery-2.1.3.min.js"></script>   
	<script src="js/jquery.validate.min.js"></script>
	<script src="js/additional-methods.min.js"></script>
	<script src="js/validation.js"></script>
	<%@ include file="_footer.jsp"%>
</body>
</html>