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
	<!-- <script src="https://cdn.ckeditor.com/4.4.3/standard/ckeditor.js"></script> -->
</head>
<body>
	<html:form action="/sua-bai-viet" method="post" enctype="multipart/form-data">
		<div class="container" style="padding-bottom: 50px">
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
	                      <label for="exampleInputFile">File input</label>
	                      <input name="file" type="file" id="exampleInputFile">
	                    </div>
						<div class="box-body pad" style="padding: 0px; margin-top: 20px;">
							<form>
                				<%-- <html:textarea property="noiDung" rows="10" cols="80" styleId="noiDung"></html:textarea> --%>
                				<html:textarea styleClass="noiDung" styleId="noiDung" property="noiDung"
									style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;">
								</html:textarea>
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
			$(".noiDung").wysihtml5();
		});
	</script>
</body>
</html>