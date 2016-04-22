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
	        <p><a href="#">My Profile</a></p>
	        <img src="img/bird.jpg" class="img-circle" height="100" width="100" alt="Avatar">
	      </div>
	      <div class="well">
			<ul class="nav nav-pills nav-stacked" role="tablist">
			    <li class="active"><html:link action="thongTinTK?tenDangNhap=${taiKhoan1.tenDangNhap}">Thông tin tài khoản</html:link></li>
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
    	<h3>THÔNG TIN TÀI KHOẢN	</h3>
      <div class="row">
        <div class="col-sm-12">
        	<div class="panel panel-default text-left">
            <div class="panel-body">
				<html:form action="/thongTinTK" method="post">
			        <div class="row form-group">
			            <label class="col-lg-4">Tên Đăng Nhập</label>
			            <div class="col-lg-6">
			            	<html:text name="taiKhoan1" property="tenDangNhap" styleClass="form-control" disabled="true"></html:text>
			            </div>
			        </div>
					<div class="row form-group">
			            <label class="col-lg-4">SDT</label>
			            <div class="col-lg-6">
			            	<html:text property="SDT" styleClass="form-control" disabled="true"></html:text>
			            </div>
			        </div>
			        <div class="row form-group">
			            <label class="col-lg-4">Địa chỉ</label>
			            <div class="col-lg-6">
			            	<html:text property="diaChi" styleClass="form-control" disabled="true"></html:text>
			            </div>
			        </div>       
			        <div class="row form-group">
			            <label class="col-lg-4">Loại tài khoản</label>
			            <div class="col-lg-6">
			            <logic:notEmpty name="taiKhoanForm" property="cmnd"><html:text property="loaiTK" styleClass="form-control" value="Thành Viên" disabled="true"></html:text>
			            </logic:notEmpty>
			            <logic:notEmpty name="taiKhoanForm" property="tenPhongKham">Phòng Khám
			            </logic:notEmpty>
			            <logic:notEmpty name="taiKhoanForm" property="tenNhaThuoc">Nhà Thuốc
			            </logic:notEmpty>
			            </div>
			        </div>      
			        <logic:notEmpty name="taiKhoan1" property="cmnd">     
			        <div class="row form-group">
			            <label class="col-lg-4">CMND</label>
			            <div class="col-lg-6">
			            	<html:text property="cmnd" styleClass="form-control" disabled="true"></html:text>
			            </div>
			        </div>       
			        </logic:notEmpty>     
			        <logic:notEmpty name="taiKhoan1" property="email">    
			        <div class="row form-group">
			            <label class="col-lg-4">Email</label>
			            <div class="col-lg-6">
			            	<html:text property="email" styleClass="form-control" disabled="true"></html:text>
			            </div>
			        </div>            
			        </logic:notEmpty>       
			        <logic:notEmpty name="taiKhoan1" property="tenPhongKham">  
			        <div class="row form-group">
			            <label class="col-lg-4">Tên Phòng Khám</label>
			            <div class="col-lg-6">
			            	<html:text property="tenPhongKham" styleClass="form-control" disabled="true"></html:text>
			            </div>
			        </div>      
			        </logic:notEmpty>
			        <logic:notEmpty name="taiKhoan1" property="tenNhaThuoc">          
			        <div class="row form-group">
			            <label class="col-lg-4">Tên Nhà Thuốc</label>
			            <div class="col-lg-6">
			            	<html:text property="tenNhaThuoc" styleClass="form-control" disabled="true"></html:text>
			            </div>
			        </div>              
			        </logic:notEmpty>
			        <logic:notEmpty name="taiKhoan1" property="moTa">  
			        <div class="row form-group">
			            <label class="col-lg-4">Mô tả</label>
			            <div class="col-lg-6">
			            	<html:text property="moTa" styleClass="form-control" disabled="true"></html:text>
			            </div>
			        </div>            
			        </logic:notEmpty>
			        <logic:notEmpty name="taiKhoan1" property="thoiGian">    
			        <div class="row form-group">
			            <label class="col-lg-4">Thời gian</label>
			            <div class="col-lg-6">
			            	<html:text property="thoiGian" styleClass="form-control" disabled="true"></html:text>
			            </div>
			        </div>              
			        </logic:notEmpty>
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
</body>
</html>