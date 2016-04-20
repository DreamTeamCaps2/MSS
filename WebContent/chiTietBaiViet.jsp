<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%@ include file="login.jsp"%>
<head lang="en">
<meta charset="UTF-8">
<title></title>
	
	<link rel="stylesheet" href="css/bootstrap.min.css" />
	<link rel="stylesheet" href="css/font-awesome.css" />
	<script src="js/jquery-1.11.2.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="css/reviewdao.vn.css" />
	<style type="text/css">
		
		p{
			text-align: justify;
		}
	</style>
</head>
<body>
	<div class="container-fluid" style="width: 1200px;">
		<div class="acolumn">
			<div class="post-2 post">
			<h3><bean:write name="baiVietForm" property="tieuDe"/></h3>
			<div class="quote"><bean:write name="baiVietForm" property="tomTat"/></div>
        	<c:out value="${baiVietForm.noiDung}" escapeXml="false" />      
            </div>
		</div>
	</div>
<%@ include file="_footer.jsp"%>
</body>
</html>