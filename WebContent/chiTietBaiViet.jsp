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
<title>Bài Viết</title>
	
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