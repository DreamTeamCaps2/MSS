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
<title>Đăng Ký Tài Khoản</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/font-awesome.css" />
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<link rel="stylesheet" href="css/login-register/AdminLTE.min.css" />
<link rel="stylesheet" href="css/login-register/blue.css" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
	<script src="https://cdn.ckeditor.com/4.4.3/standard/ckeditor.js"></script>
</head>
<body>
	<html:form action="/them-bai-viet" method="post" enctype="multipart/form-data">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="box box-info">
					<div class="box-header">
						<h3 class="box-title">
							CK Editor <small>Advanced and full of features</small>
						</h3>
						<!-- tools box -->
						<div class="pull-right box-tools">
							<button class="btn btn-info btn-sm" data-widget="collapse"
								data-toggle="tooltip" title="Collapse">
								<i class="fa fa-minus"></i>
							</button>
							<button class="btn btn-info btn-sm" data-widget="remove"
								data-toggle="tooltip" title="Remove">
								<i class="fa fa-times"></i>
							</button>
						</div>
						<!-- /. tools -->
					</div>

					<!-- /.box-header -->
					<input name="tieuDe" class="form-control input-lg pad" type="text" placeholder="TIÊU ĐỀ">
					<textarea name="tomTat" class="form-control" style="margin-top: 20px;"  rows="3" placeholder="TÓM TẮT ..."></textarea>
					<div class="form-group">
                      <label for="exampleInputFile">File input</label>
                      <input name="file" type="file" id="exampleInputFile">
                    </div>
					<div class="box-body pad" style="padding: 0px;     margin-top: 20px;">
						<form>
							<textarea id="noiDung" name="noiDung" rows="10" cols="80">
                                           
                			</textarea>
						</form>
					</div>
					<html:submit styleClass="btn btn-primary btn-block btn-flat" property="submit" value="OK">Register</html:submit>
				</div>
			</div>
		</div>
	</div>
	</html:form>
<script>
      $(function () {
        // Replace the <textarea id="editor1"> with a CKEditor
        // instance, using default configuration.
        CKEDITOR.replace('noiDung');
      });
      
      $('#printHTML').click(function()
    		  {
    				var value = CKEDITOR.instances['noiDung'].getData();	  
	    	  			console.log('abc:'+value);
    	  $('#hienthi').html(value);
    	  
    		  });
    </script>
</body>
</html>