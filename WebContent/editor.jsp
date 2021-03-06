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
<!-- 	<script src="https://cdn.ckeditor.com/4.4.3/standard/ckeditor.js"></script> -->
    <link rel="stylesheet" href="css/login-register/AdminLTE.min.css" />
	<title>Thêm Bài Viết</title>
	<%@ include file="quanLy_TrangChu.jsp"%>
	<link rel="stylesheet" href="css/font-awesome.css" />
</head>
<body>
	<html:form action="/them-bai-viet" method="post" enctype="multipart/form-data">
	<div class="container" style="padding-bottom: 50px">
		<div class="row">
			<div class="col-md-12">
				<div class="box box-info">
					<div class="box-header">
						<h3 class="box-title">
							THÊM BÀI VIẾT
						</h3>
					</div>

					<!-- /.box-header -->
					<input name="tieuDe" class="form-control input-lg pad" type="text" placeholder="TIÊU ĐỀ">
					<textarea name="tomTat" class="form-control" style="margin-top: 20px;"  rows="3" placeholder="TÓM TẮT ..."></textarea>
					<div class="form-group">
                      <label for="exampleInputFile">File input</label>
                      <input name="file" type="file" id="exampleInputFile">
                    </div>
					<div class="box-body pad" style="padding: 0px;   margin-top: 20px;">
						<form>
 							<!--<textarea id="noiDung" name="noiDung" rows="10" cols="80">
                                           
                			</textarea> -->
                			<textarea class="textarea" id="noiDung" name="noiDung" placeholder="Place some text here"
								style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;">
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
	$(function() {
		$(".textarea").wysihtml5();
	});
    </script>
</body>
</html>