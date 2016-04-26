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
	    .active {
	    font-size: 14px;
	    border-bottom: 0px;
		}
  </style>
</head>
<body>
    <div class="container text-center" style="width: 1200px;">    
	  <div class="row">
	    <div class="col-sm-3 well">
	      <div class="well">
	        <p><a href="#">My Profile</a></p>
	        <img src="img/${taiKhoan.anhDaiDien}" class="img-circle" height="100" width="100" alt="Avatar">
	      </div>
	      <div class="well">
			<ul class="nav nav-pills nav-stacked" role="tablist">
			    <li><html:link action="thongTinTK">Thông tin tài khoản</html:link></li>
				<li class="active"><a href="/MSS/doi-mat-khau.do">Đổi mật khẩu</a></li>
			    <li><a href="#">Thông báo</a></li>
			    <li><a href="#">Tin nhắn</a></li>
			    <li><a href="#">Đã lưu</a></li>
			    <logic:notEmpty name="taiKhoan1" property="tenNhaThuoc">
			    <li><html:link action="/quan-ly-thuoc-cua-hang">Quản lý thuốc</html:link></li>
			    </logic:notEmpty>
			    <logic:notEmpty name="taiKhoan1" property="tenPhongKham">
			    <li><a href="#">Quản lý phòng khám</a></li>
			    </logic:notEmpty>
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
			            	<html:link action="/login.jsp" styleClass="btn btn-primary">Trang chủ</html:link>
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
	<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.3.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>
  	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/additional-methods.min.js"></script>
	<script src="js/validation.js"></script>
	<%@ include file="_footer.jsp"%>
</body>
</html>