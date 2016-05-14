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
<head>
</head>
<body>
<div class="col-lg-4 col-md-4 col-sm-4" style="padding-left: 40px;">
<div class="bcolumn">
	<div style="width:272px;">
	<p style=" font-size: 16px;font-weight: 700; text-align: center; padding-bottom: 5px; margin: 10px 0 0 0; border-bottom: 2px solid #25af61;">XEM NHIỀU</p>
	<div class="tabPanel-widget" >
	    <label for="tab-1" tabindex="0"></label>
	      <input id="tab-1" type="radio" name="tabs" checked="true" aria-hidden="true">
	    <h2>BỆNH</h2>
	    <div class="hot-topic" style="margin-top: 0px;">
			<ul>
	       	<c:forEach items="${thongBaoForm.listBenhXemNhieu}" var="list" varStatus="loopCounter">
	         	<li>
	         		<div class="numb"><i><c:out value="${loopCounter.count}"/></i></div>
	     			<div class="item1">
	                  	<a  href="/MSS/chi-tiet-benh.do?ma=${list.maBenh}" title="${list.tenBenh}"><c:out value="${list.tenBenh}"/></a>
	              		<span><i class="fa fa-eye"></i><c:out value="${list.luotXem}"/></span>
	                </div>               
	           	</li>
	        </c:forEach>
	        <li style="margin-bottom: 0px;"><a href="#"></a></li>
	        </ul>
	    </div>
	    <label for="tab-2" tabindex="0"></label>
	    <input id="tab-2" type="radio" name="tabs" aria-hidden="true">
	    <h2>THUỐC</h2>
	   <div class="hot-topic" style="margin-top: 0px;">
			<ul>
	       	<c:forEach items="${thongBaoForm.listThuocXemNhieu}" var="list" varStatus="loopCounter">
         	<li>
         		<div class="numb"><i><c:out value="${loopCounter.count}"/></i></div>
     			<div class="item1">
                  	<a  href="/MSS/chi-tiet-thuoc.do?ma=${list.maThuoc}" title="${list.tenThuoc}"><c:out value="${list.tenThuoc}"/></a>
              		<span><i class="fa fa-eye"></i><c:out value="${list.luotXem}"/></span>
                </div>               
           	</li>
        	</c:forEach>
	        <li style="margin-bottom: 0px;"><a href="#"></a></li>
	        </ul>
	    </div>
	    <label for="tab-3" tabindex="0"></label>
	    <input id="tab-3" type="radio" name="tabs" aria-hidden="true">
	    <h2>BÀI VIẾT</h2>
	    <div class="hot-topic" style="margin-top: 0px;">
			<ul>
	       	<c:forEach items="${thongBaoForm.listBaiVietXemNhieu}" var="list" varStatus="loopCounter">
         	<li>
         		<div class="numb"><i><c:out value="${loopCounter.count}"/></i></div>
     			<div class="item1">
                  	<a  href="/MSS/chi-tiet-bai-viet.do?maBaiViet=${list.maBaiViet}" title="${list.tieuDe}"><c:out value="${list.tieuDe}"/></a>
              		<span><i class="fa fa-eye"></i><c:out value="${list.luotXem}"/></span>
                </div>               
           	</li>
        	</c:forEach>
	        <li style="margin-bottom: 0px;"><a href="#"></a></li>
	        </ul>
	    </div>
  	</div>
  	</div>
</div>
</div>
</body>
</html>