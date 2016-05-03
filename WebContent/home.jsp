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
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>TRANG CHỦ</title>
    
	<link rel="stylesheet"  href="css/lightslider.css"/>
	<link rel="stylesheet" href="css/pgwslider.min.css" />
	<link rel="stylesheet" href="css/reviewdao.vn.css" />
	
	<script src="js/pgwslider.min.js"></script>
    <script src="js/lightslider.js"></script>    
   	<style>
    	ul{
			list-style: none outside none;
		    padding-left: 0;
            margin: 0;
		}
        .demo .item{
            margin-bottom: 60px;
        }
		.content-slider li{
		    text-align: center;
		    color: #FFF;
		}
		.content-slider h3 {
		    margin: 0;
		    padding: 70px 0;
		}
		.demo{
			width: 800px;
		}
    </style>
</head>
<body>
<div class="container-fluid" style="width: 1200px;"> 
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
    	maxHeight:400	
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
	-->

	<div class="container-fluid" style="width: 1200px; margin-top: 20px;">
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

	<div class="container-fluid" style="width: 1200px;">
		<div class="acolumn">
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
	           		<li>
	                    <a class="thumb" href="/MSS/chi-tiet-bai-viet.do?maBaiViet=${list.maBaiViet}">
	                    	<img alt="" src="images/${list.hinhAnh }">
	                    </a> 
	                    <html:link styleClass="title" action="chi-tiet-bai-viet?maBaiViet=${list.maBaiViet}">
	                    	<c:out value="${list.tieuDe}"/>
	                    </html:link>
	                    <p>
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
	<div class="bcolumn">
    <div class="hot-topic">
    	<h3>Những Bệnh Xem Nhiều Nhất</h3>
       	<ul style="margin-left: 10px;">
       	<c:forEach items="${thongBaoForm.listBenhXemNhieu}" var="list" varStatus="loopCounter">
         	<li>
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
    	<h3>Những Thuốc Xem Nhiều Nhất</h3>
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
    	<h3>Những Bài Viết Xem Nhiều Nhất</h3>
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
<%@ include file="_footer.jsp"%>
</body>
</html>