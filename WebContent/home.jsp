<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@ include file="login.jsp"%>
<head>
    <meta charset="utf8">
    <title>TRANG CHỦ</title>
	<link rel="stylesheet"  href="css/lightslider.css"/>
	<link rel="stylesheet" href="css/pgwslider.min.css" />
	
	<script src="js/pgwslider.min.js"></script>
    <script src="js/lightslider.js"></script>    
   	<style>
	ul {
		list-style: none outside none;
		padding-left: 0;
		margin: 0;
	}
	
	.demo .item {
		margin-bottom: 60px;
	}
	
	.content-slider li {
		text-align: center;
		color: #FFF;
	}
	
	.content-slider h3 {
		margin: 0;
		padding: 70px 0;
	}
	
	.demo {
		width: 800px;
	}
	
	.container-fluid {
		padding-right: 15px;
		padding-left: 15px;
	}
	
	.mh-widget-title {
		font-size: 16px;
		margin-bottom: 20px;
		margin-bottom: 1.25rem;
		text-transform: uppercase;
		border-bottom: 3px solid #e64946;
		text-align: left;
	}
	
	.tabPanel-widget {
		position: relative; /* containing block for headings (top:0) */
		background: #999;
	}
	.tabPanel-widget>label {
		position: absolute;
		z-index: 1;
	}
	.tabPanel-widget>label, .tabPanel-widget>h2 {
		font-size: 1.1em;
		width: 6.3em;
		height: 2em;
		line-height: 2em;
	}
	.tabPanel-widget>h2 {
		position: relative;
		margin: 0;
		text-align: center;
		background: #999;
		color: #fff;
	}
	
	.tabPanel-widget>label {
		border-right: 1px solid #fff;
	}
	.tabPanel-widget>label ~ label, .tabPanel-widget>h2 ~ h2 {
		position: absolute;
		top: 0;
	}
	.tabPanel-widget label:nth-child(1), .tabPanel-widget h2:nth-child(3) {
		left: 0em;
	}
	.tabPanel-widget label:nth-child(5), .tabPanel-widget h2:nth-child(7) {
		left: 6.3em;
	}
	.tabPanel-widget label:nth-child(9), .tabPanel-widget h2:nth-child(11) {
		left: 12.7em;
	}
	.tabPanel-widget input+h2+div {
		position: absolute !important;
		clip: rect(1px, 1px, 1px, 1px);
		padding: 0 !important;
		border: 0 !important;
		height: 1px !important;
		width: 2px !important;
		overflow: hidden;
	}
	.tabPanel-widget input:checked+h2+div {
		position: static !important;
		padding: 1em !important;
		height: auto !important;
		width: auto !important;
	}
	.tabPanel-widget label:hover {
		cursor: pointer;
	}
	.tabPanel-widget>div {
		background: #f0f0f0;
		padding: 1em;
	}
	.tabPanel-widget input[name="tabs"] {
		opacity: 0;
		position: absolute;
	}
	.tabPanel-widget input[name="tabs"]:focus+h2 {
		outline: 1px dotted #000;
		outline-offset: 10px;
	}
	.tabPanel-widget:hover h2 {
		outline: none !important;
	}
	.tabPanel-widget input[name="tabs"]:checked+h2 {
		background: #333;
	}
	.tabPanel-widget input[name="tabs"]:checked+h2:after {
		content: '';
		margin: auto;
		position: absolute;
		bottom: -10px;
		left: 0;
		right: 0;
		width: 0;
		height: 0;
		border-left: 10px solid transparent;
		border-right: 10px solid transparent;
		border-top: 10px solid #333;
	}
	@media screen and (max-width: 45em) {
		/* hide unecessary label/control pairs */
		.tabPanel-widget label, .tabPanel-widget input[name="tabs"] {
			display: none;
		}
	
		.tabPanel-widget>input+h2+div {
			display: block !important;
			position: static !important;
			padding: 1em !important;
			height: auto !important;
			width: auto !important;
		}
	
		.tabPanel-widget h2 {
			width: auto;
			position: static !important;
			background: #999 !important;
		}
	
		.tabPanel-widget h2:after {
			display: none !important;
		}
	}
</style>
</head>
<body>
<div class="wrapper-page" style="width: 1000px; margin: 0 auto;">
<div class="wrap-body container" style="padding-bottom: 20px;">
<div class="container-fluid" style="width: 1000px; padding-top: 15px;"> 
<ul class="pgwSlider">
	<c:forEach items="${thongBaoForm.listND}" var="list">
		<c:if test="${list.id < 8}">
		<li>
			<a href="/MSS/thongTinTKChiTiet.do?tenDangNhap=${list.tenDangNhap}" target="_blank">
            	<img src="images/kitchen_adventurer_lemon.jpg">
	    		<span><h4><c:out value="${list.tenDangNhap}"></c:out></h4></span>
        	</a>
        </li>
        </c:if>
	</c:forEach>
</ul>
</div>

<script type="text/javascript">
$(document).ready(function() {
    $('.pgwSlider').pgwSlider({
    	maxHeight:350
    });
	$("#content-slider").lightSlider({
        loop:true,
        keyPress:true,
        auto:true,
        pauseOnHover: true,
        speed:500,
        slideMove:3,
        pager:false
    });
});
</script>
<br>
	<!-- 	
	<div class="container-fluid" style="width: 1200px;">
		<div class="col-xs-6 col-md-4" style="padding: 1px; width: 389px; height: 146px;">
			<a href="http://didongviet.vn/htc-one-m9-my-used.html" class="thumbnail">
	      		<img src="img/003.jpg" alt="...">
	    	</a>
		</div>
		<div class="col-xs-6 col-md-4" style="padding: 1px; width: 389px; height: 146px;">
			<a href="http://didongviet.vn/htc-one-m9-my-used.html" class="thumbnail">
	      		<img src="img/002.jpg" alt="...">
	    	</a>
		</div>
		<div class="col-xs-6 col-md-4" style="padding: 1px; width: 389px; height: 146px;">
			<a href="http://didongviet.vn/htc-one-m9-my-used.html" class="thumbnail">
	      		<img src="img/004.jpg" alt="...">
	    	</a>
		</div>		
	</div> 
	

	<div class="container-fluid" style="width: 1000px; margin-top: 20px;">
		<div class="item">
			<ul id="content-slider" class="content-slider">
				<c:forEach items="${thongBaoForm.listND}" var="list">
					<li>
						<a href="http://www.nyc.gov" target="_blank" class="thumbnail">
			            	<img src="img/003.jpg">
				    		<span style="padding-bottom: 10px"><c:out value="${list.tenDangNhap}"></c:out></span>
			        	</a>
			        </li>
				</c:forEach>
			</ul>
		</div>
	</div>
-->

	<div class="container-fluid" style="width: 1000px;">
		<div class="acolumn"  style="width: 680px;">
		
			<div class="opt">
				<a id="tab-label-new" class="link-post active" href="#tab-new-topic">new topic</a> 
				<!-- <div class="feature-post">
					<a href="javascript:void(0)" id="show_result">Sắp xếp<i
						class="fa fa-angle-down"></i></a>
					<ul id="ul_sort" class="_none">
						<li id="li_sort_id" class="_none"><a id="sort_id"
							href="javascript:void(0)">Sắp xếp</a></li>
						<li><a href="javascript:void(0)" id="sort_date">Sắp xếp
								theo ngày</a></li>
						<li><a href="javascript:void(0)" id="sort_view">Sắp xếp
								theo lượt xem</a></li>
					</ul>
				</div> -->
			</div>
			
		
			
			<div class="item-tabs" id="tab-new-topic" style="display: block;">
			<div id="item-result1">
            <ul class="list-post" id="new-topic">
	            <c:forEach items="${thongBaoForm.listBaiViet}" var="list">
	           	<div class="itemBaiViet">
	           		<li  style="   border-bottom: 1px solid #dedede; height: ">
	                    <a class="thumb" href="/MSS/chi-tiet-bai-viet.do?maBaiViet=${list.maBaiViet}">
	                    	<img alt="" src="images/${list.hinhAnh }">
	                    </a> 
	                    <html:link styleClass="title" style="margin-left: 0%;" action="chi-tiet-bai-viet?maBaiViet=${list.maBaiViet}">
	                    	<c:out value="${list.tieuDe}"/>
	                    </html:link>
	                    <p class="dotdotdot" style="max-height: 20%;">
	                    	<c:out value="${list.tomTat}"></c:out>
	                    </p>
	                    <div class="st-post-feature">
	                        <span><i class="fa fa-eye"></i><c:out value="${list.luotXem}"></c:out></span>
	                    </div>
		            </li>
		        </div>
	            </c:forEach>
            </ul>
            </div>
            <div class="page-navigation" id="pagination" align="center"></div>
			<script>
						jQuery(function($) {
							var items = $(".itemBaiViet");
							var numItems = items.length;
							var perPage = 10;
							items.slice(perPage).hide();
							$("#pagination").pagination({
								items : numItems,
								prevText: "<",
								nextText: ">",
								itemsOnPage : perPage,
								cssStyle : "light-theme",
								onPageClick : function(pageNumber) { // this is where the magic happens
									// someone changed page, lets hide/show trs appropriately
									var showFrom = perPage * (pageNumber - 1);
									var showTo = showFrom + perPage;
									items.hide() // first hide everything, then show for the new page
									.slice(showFrom, showTo).show();
								}
							});
						});
					</script>
</div>
</div>
	<div class="bcolumn" style="width: 270px;">
	<div class="tabPanel-widget">
	    <label for="tab-1" tabindex="0"></label>
	      <input id="tab-1" type="radio" name="tabs" checked="true" aria-hidden="true">
	    <h2>BỆNH</h2>
	    <div class="hot-topic" style="margin-top: 0px;">
			<ul style="margin-left: 10px; margin-top: 5px">
	       	<c:forEach items="${thongBaoForm.listBenhXemNhieu}" var="list" varStatus="loopCounter">
	         	<li >
	         		<div class="numb"><i><c:out value="${loopCounter.count}"/></i></div>
	     			<div class="item">
	                  	<a  href="/MSS/chi-tiet-benh.do?mat=${list.maBenh}" title="${list.tenBenh}"><c:out value="${list.tenBenh}"/></a>
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
			<ul style="margin-left: 10px; margin-top: 5px">
	       	<c:forEach items="${thongBaoForm.listThuocXemNhieu}" var="list" varStatus="loopCounter">
         	<li>
         		<div class="numb"><i><c:out value="${loopCounter.count}"/></i></div>
     			<div class="item">
                  	<a  href="/MSS/chi-tiet-thuoc.do?mat=${list.maThuoc}" title="${list.tenThuoc}"><c:out value="${list.tenThuoc}"/></a>
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
			<ul style="margin-left: 10px; margin-top: 5px">
	       	<c:forEach items="${thongBaoForm.listBaiVietXemNhieu}" var="list" varStatus="loopCounter">
         	<li>
         		<div class="numb"><i><c:out value="${loopCounter.count}"/></i></div>
     			<div class="item">
                  	<a  href="/MSS/chi-tiet-bai-viet.do?maBaiViet=${list.maBaiViet}" title="${list.tieuDe}"><c:out value="${list.tieuDe}"/></a>
              		<span><i class="fa fa-eye"></i><c:out value="${list.luotXem}"/></span>
                </div>               
           	</li>
        	</c:forEach>
	        <li style="margin-bottom: 0px;"><a href="#"></a></li>
	        </ul>
	    </div>
  	</div>
    <div class="hot-topic">
    	<h3 class="mh-widget-title">
	    	<span>Bệnh Xem Nhiều Nhất</span>
    	</h3>
       	<ul style="margin-left: 10px;">
       	<c:forEach items="${thongBaoForm.listBenhXemNhieu}" var="list" varStatus="loopCounter">
         	<li >
         		<div class="numb"><i><c:out value="${loopCounter.count}"/></i></div>
     			<div class="item">
                  	<a  href="/MSS/chi-tiet-benh.do?mat=${list.maBenh}" title="${list.tenBenh}"><c:out value="${list.tenBenh}"/></a>
              		<span><i class="fa fa-eye"></i><c:out value="${list.luotXem}"/></span>
                </div>               
           	</li>
        </c:forEach>
        <li><a href="#"></a></li>
        </ul>
    </div>
    <div class="hot-topic">
    	<h3>Thuốc Xem Nhiều Nhất</h3>
       	<ul style="margin-left: 10px;">
       	<c:forEach items="${thongBaoForm.listThuocXemNhieu}" var="list" varStatus="loopCounter">
         	<li>
         		<div class="numb"><i><c:out value="${loopCounter.count}"/></i></div>
     			<div class="item">
                  	<a  href="/MSS/chi-tiet-thuoc.do?mat=${list.maThuoc}" title="${list.tenThuoc}"><c:out value="${list.tenThuoc}"/></a>
              		<span><i class="fa fa-eye"></i><c:out value="${list.luotXem}"/></span>
                </div>               
           	</li>
        </c:forEach>
        <li><a href="#"></a></li>
        </ul>
    </div>
   	<div class="hot-topic">
    	<h3>Bài Viết Xem Nhiều Nhất</h3>
       	<ul style="margin-left: 10px;">
       	<c:forEach items="${thongBaoForm.listBaiVietXemNhieu}" var="list" varStatus="loopCounter">
         	<li>
         		<div class="numb"><i><c:out value="${loopCounter.count}"/></i></div>
     			<div class="item">
                  	<a  href="/MSS/chi-tiet-bai-viet.do?maBaiViet=${list.maBaiViet}" title="${list.tieuDe}"><c:out value="${list.tieuDe}"/></a>
              		<span><i class="fa fa-eye"></i><c:out value="${list.luotXem}"/></span>
                </div>               
           	</li>
        </c:forEach>
        <li><a href="#"></a></li>
        </ul>
    </div>
	</div>
	</div>
	</div>
	</div>
	
	
		<script>
			$(document).ready(function(){
				$('.dotdotdot').dotdotdot();
			});
			
			</script>
	
	
<%@ include file="_footer.jsp"%>
</body>
</html>