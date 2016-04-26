<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<html>
<%@ include file="quanLy_TrangChu.jsp"%>
<head lang="en">
<meta charset="UTF-8">
<title>Sửa Bài Viết</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />

<script src="https://cdn.ckeditor.com/4.4.3/standard/ckeditor.js"></script>
</head>
<body>
	<html:form action="/sua-bai-viet" method="post">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="box box-info">
						<div class="box-header">
							<h3 class="box-title">SỬA BÀI VIẾT</h3>
						</div>

						<!-- /.box-header -->
						<bean:define id="maBaiViet" name="baiVietForm" property="maBaiViet" ></bean:define>
						<html:text property="maBaiViet" styleClass="form-control input-lg pad" readonly="true"></html:text>
						<html:text property="tieuDe" styleClass="form-control input-lg pad"></html:text>
						<html:textarea property="tomTat" styleClass="form-control" style="margin-top: 20px;" rows="3"></html:textarea>
						<div class="form-group">
							<label for="exampleInputFile">Hình ảnh</label> <html:file property="hinhAnh"></html:file>
						</div>
						<div class="box-body pad" style="padding: 0px; margin-top: 20px;">
							<form>
                				<html:textarea property="noiDung" rows="10" cols="80" styleId="noiDung"></html:textarea>
							</form>
						</div>
						<html:submit styleClass="btn btn-primary btn-block btn-flat"
							property="submit" value="OK" >Register</html:submit>
					</div>
				</div>
			</div>
		</div>
	</html:form>
	<script>

		$(function() {
			// Replace the <textarea id="editor1"> with a CKEditor
			// instance, using default configuration.
			CKEDITOR.replace('noiDung');
		});

		$('#printHTML').click(function() {
			var value = CKEDITOR.instances['noiDung'].getData();
			console.log('abc:' + value);

		});
	</script>
</body>
</html>