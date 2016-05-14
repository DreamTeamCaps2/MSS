<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<%@ include file="login.jsp"%>
<head>
<meta charset="utf8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Góp Ý</title>
<style type="text/css">
.row {
    margin-right: 0px;
    margin-left: 0px;
}
</style>
</head>
<body>
	<html:form action="/gop-y" method="post">
		<div class="container">
			<div class="row">
				<div class="form-style">


					<p>
						<label class="required">Chủ Đề<span>*</span></label> <input
							type="text" id="question-title" name="chuDe"> <span class="form-description"><html:errors
								property="chuDeError" /></span>
								
					</p>
					<p>
						<label class="required">Loại Góp Ý<span>*</span></label> <select
							name="loaiGopY">
							<option value="0">---Chọn Loại Cần Góp Ý-------</option>
							<option value="1">Bệnh</option>
							<option value="2">Thuốc</option>
							<option value="3">Khác</option>
						</select> <span class="form-description"><html:errors property="loaiGopYError" /></span>
					</p>
					<p>
						<label class="required">Nội Dung<span>*</span></label>
						<textarea rows="15" cols="100" name="noiDung"></textarea>
						<span class="form-description"><html:errors property="noiDungError" /></span>

					</p>



					<html:submit property="submit" value="GopY"
						style="margin-left:45%; margin-bottom: 40px;"></html:submit>
				</div>
			</div>
		</div>
	</html:form>
	<%@ include file="_footer.jsp"%>
</body>
</html>