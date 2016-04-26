<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<html>
<head lang="en">
<meta charset="UTF-8">
<title>Danh Sách Bệnh</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" />
<link href="css/style.css" rel="stylesheet" type="text/css"
	media="screen,print" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="quanLy_TrangChu.jsp"%>
</head>
<body>
<body>
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">Phân quyền</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-12">
							<html:form action="/phan-quyen" method="post">
								<div class="row form-group">
									<label class="col-lg-4">Mã thành viên </label>
									<div class="col-lg-3">
										<html:text property="maTaiKhoan" styleClass="form-control"
											readonly="true"></html:text>
									</div>
								</div>
								<div class="row form-group">
									<div>
										<label class="col-lg-4">Quyền</label>
									</div>
									<div>
										<label class="col-lg-1">Chọn</label>
									</div>
									<div>
										<label class="col-lg-2">Không chọn</label>
									</div>
								</div>
								<div class="row form-group">
									<label class="col-lg-4">Bệnh</label>
									<div>
										<label class="col-lg-1"><html:radio property="benh"
												value="1"></html:radio>
									</div>
									<div>
										<label class="col-lg-2"><html:radio property="benh"
												value="0"></html:radio>
									</div>
								</div>
								<div class="row form-group">
									<label class="col-lg-4">Thuốc</label>
									<div>
										<label class="col-lg-1"><html:radio property="thuoc"
												value="1"></html:radio>
									</div>
									<div>
										<label class="col-lg-2"><html:radio property="thuoc"
												value="0"></html:radio>
									</div>
								</div>
								<div class="row form-group">
									<label class="col-lg-4">Triệu chứng</label>
									<div>
										<label class="col-lg-1"><html:radio
												property="trieuChung" value="1"></html:radio>
									</div>
									<div>
										<label class="col-lg-2"><html:radio
												property="trieuChung" value="0"></html:radio>
									</div>
								</div>
								<div class="row form-group">
									<label class="col-lg-4">Phân quyền</label>
									<div>
										<label class="col-lg-1"><html:radio
												property="phanQuyen" value="1"></html:radio>
									</div>
									<div>
										<label class="col-lg-2"><html:radio
												property="phanQuyen" value="0"></html:radio>
									</div>
								</div>
								<div class="row form-group">
									<label class="col-lg-4">Đăng bài</label>
									<div>
										<label class="col-lg-1"><html:radio property="dangBai"
												value="1"></html:radio>
									</div>
									<div>
										<label class="col-lg-2"><html:radio property="dangBai"
												value="0"></html:radio>
									</div>
								</div>
								<div class="row form-group">
									<div class="col-lg-3 col-lg-offset-2">
										<html:submit styleClass="btn btn-primary" property="submit"
											value="submit">Lưu lại</html:submit>
									</div>
								</div>
							</html:form>

						</div>
					</div>
				</div>
				<div class="panel-body">
			        <div class="row form-group">
			            <label class="col-lg-4">Tên Đăng Nhập</label>
			            <div class="col-lg-6">
			            	<html:text name="taiKhoanPhanQuyen" property="tenDangNhap" styleClass="form-control" disabled="true"></html:text>
			            </div>
			        </div>
			         
					<div class="row form-group">
			            <label class="col-lg-4">SDT</label>
			            <div class="col-lg-6">
			            	<html:text name="taiKhoanPhanQuyen" property="SDT" styleClass="form-control" disabled="true"></html:text>
			            </div>
			        </div>
			        <div class="row form-group">
			            <label class="col-lg-4">Địa chỉ</label>
			            <div class="col-lg-6">
			            	<html:text name="taiKhoanPhanQuyen" property="diaChi" styleClass="form-control" disabled="true"></html:text>
			            </div>
			        </div>  
			        <logic:notEmpty name="taiKhoanPhanQuyen" property="cmnd">     
			        <div class="row form-group">
			            <label class="col-lg-4">CMND</label>
			            <div class="col-lg-6">
			            	<html:text name="taiKhoanPhanQuyen" property="cmnd" styleClass="form-control" disabled="true"></html:text>
			            </div>
			        </div>       
			        </logic:notEmpty>     
			        <logic:notEmpty name="taiKhoanPhanQuyen" property="email">    
			        <div class="row form-group">
			            <label class="col-lg-4">Email</label>
			            <div class="col-lg-6">
			            	<html:text name="taiKhoanPhanQuyen" property="email" styleClass="form-control" disabled="true"></html:text>
			            </div>
			        </div>            
			        </logic:notEmpty>      
			   </div>
			</div>
		</div>
	</div>

</body>
</html>