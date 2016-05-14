<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<html>

<head lang="en">
<meta charset="UTF-8">
<title>Cập Nhật Phiên Bản</title>
<%@ include file="quanLy_TrangChu.jsp"%>
</head>
<body>
	<html:form action="/cap-nhat" method="post"
		enctype="multipart/form-data">
		<div class="container">
			<div class="row">
				<div class="form-group">
					<div class="col-lg-3">
						<label>CẬP NHẬT PHIÊN BẢN</label>
					</div>
					<div class="col-lg-3">
						<html:submit styleClass="btn btn-primary" property="submit"
							value="Update" styleId="btnUpdate"></html:submit>
					</div>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-lg-3">
					<label>CẬP NHẬT APK</label>
				</div>
				<div class="col-lg-3">
					<div class="form-group">
						<label for="exampleInputFile">File input</label> <input
							name="file" type="file" id="exampleInputFile">
					</div>
					<html:submit styleClass="btn btn-primary" property="submit"
						value="Upload" styleId="btnUpload"></html:submit>
				</div>
			</div>
		</div>
	</html:form>
	<script type="text/javascript">
		$('#btnUpdate').click(function() {
			alert("UPDATE");
		});
		$('#btnUpload').click(function() {

			alert("UPLOAD APK" + $('#exampleInputFile').val());
		});
	</script>
</body>
</html>