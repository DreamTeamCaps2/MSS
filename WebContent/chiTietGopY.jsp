<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>TRANG CHỦ</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/font-awesome.css" />
<link rel="stylesheet" href="css/login.css" />
<link rel="stylesheet" href="css/style.css" />

<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.easy-autocomplete.min.js" type="text/javascript"></script>

<link href="css/easy-autocomplete.min.css" rel="stylesheet">
<link href="css/easy-autocomplete.themes.min.css" rel="stylesheet">
</head>
<body>
	<html:form action="/chi-tiet-gop-y" method="get">
		<div class="container">
			
					<div class="form-style">


						<p>
							<%-- <label class="required">Chủ Đề<span>*</span></label> <input
								type="text" id="question-title" name="chuDe" > <span
								class="form-description"><html:errors
									property="chuDeError" /></span> --%>
							<label class="required">Chủ Đề<span>*</span></label>
							<html:text property="chuDe" name="gopYForm"
								styleId="question-title" readonly="true"></html:text>
							<span class="form-description"><html:errors
									property="chuDeError" /></span>

						</p>
						<p>
							<label class="required">Loại Góp Ý<span>*</span></label>
							<logic:equal value="1" name="gopYForm" property="loaiGopY">
							</logic:equal>
							<label style="width: 80%;"> Bệnh</label>
							<logic:equal value="2" name="gopYForm" property="loaiGopY">
								<label style="width: 80%;"> Thuốc</label>
							</logic:equal>
							<logic:equal value="3" name="gopYForm" property="loaiGopY">
								<label style="width: 80%;"> Khác</label>
							</logic:equal>
						</p>
						<p>
							<label class="required">Nội Dung<span>*</span></label>
							<html:textarea rows="15" cols="100" name="gopYForm"
								readonly="true" property="noiDung"></html:textarea>
							<span class="form-description"><html:errors
									property="noiDungError" /></span>

						</p>
							<p>
								<label class="required">Thời Gian<span>*</span></label>
							<html:text property="thoiGian" name="gopYForm"
								styleId="question-title" readonly="true"></html:text>
							<span class="form-description"><html:errors
									property="chuDeError" /></span>
						</p>

						<a href="/MSS/quan-ly-gop-y.do"style="margin-left:50%;"> Quản Lý Góp Ý</a>
					</div>
				</div>
	</html:form>
</body>
</html>