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
    
    <link rel="stylesheet" href="css/bootstrap.min.css" />
	<link rel="stylesheet" href="css/font-awesome.css" />
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js?ver=1.4.2"></script>
	<link rel="stylesheet" href="css/pgwslider.min.css" />
	<link rel="stylesheet" href="css/reviewdao.vn.css" />
    <script src="js/jquery-1.11.2.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/pgwslider.min.js"></script>
	
    <link rel="stylesheet"  href="css/lightslider.css"/>
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

	<div class="container-fluid" style="width: 1200px; margin-top: 50px;">
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

	<div class="container-fluid" style="width: 1200px; padding-top: 20px;">
		<div class="acolumn">
			<div class="opt">
				<a id="tab-label-new" class="link-post active" href="#tab-new-topic">new topic</a> 
				<a id="tab-label-review" class="link-post" href="#tab-review">review</a>
				<div class="feature-post">
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
				</div>
			</div>
			<div class="item-tabs" id="tab-new-topic" style="display: block;">
            <ul class="list-post" id="new-topic">
	            <c:forEach items="${thongBaoForm.listBaiViet}" var="list">
	            <li>
                    <a class="thumb" href="link">
                    	<img alt="" src="images/${list.hinhAnh }">
                    </a> 
                    <%-- <html:link styleClass="title" action="thongTinTK?tenDangNhap=${list.tenDangNhap}">
                    	<c:out value="${list.tenDangNhap}"/>
                    </html:link> --%>
                    <html:link styleClass="title" action="chi-tiet-bai-viet?maBaiViet=${list.maBaiViet}">
                    	<c:out value="${list.tieuDe}"/>
                    </html:link>
                    <%-- <a class="title" href="/MSS/thongTinTK?tenDangNhap=${list.tenDangNhap}"><c:out value="${list.tenDangNhap}"></c:out></a> --%>
                    <p>
                    	<c:out value="${list.tomTat}"></c:out>
                    </p>
                    <div class="st-post-feature">
                        <span><i class="fa fa-eye"></i><c:out value="${list.maBaiViet}"></c:out></span>
                    </div>
	            </li>
	            </c:forEach>
            </ul>
            <div id="list-page">
                <div class="paging-item">
                    <span class="current" lang="1">1</span><a class="page-numbers" href="javascript:void(0)" lang="2">2</a><a class="page-numbers" href="javascript:void(0)" lang="3">3</a><a class=
                    "page-numbers" href="javascript:void(0)" lang="4">4</a><a class="page-numbers" href="javascript:void(0)" lang="5">5</a><a class="page-numbers" href="javascript:void(0)" lang=
                    "2"><i class="fa fa-angle-right fs19"></i></a><a class="page-numbers" href="javascript:void(0)" lang="164"><i class="fa fa-angle-double-right fs19"></i></a>
                </div>
            </div>
        </div>

			<script>
        var homeTabSelect = "list-page";
        var catid = 5;

        $('#tab-label-new').click(function() {
            homeTabSelect = "list-page";
            catid = 5;
        });

        $('#tab-label-review').click(function() {
            homeTabSelect = "list-page-reviews";
            catid = 1;
        });

        jQuery(document).ready(function(){
            jQuery("#list-page").on("click",".page-numbers",function(){
                var page = jQuery(this).attr("lang");
                paging_ajax(page,"new_topic","new-topic","list-page",catid);
                $('html, body').animate({ scrollTop: 0 },100);
            });

            jQuery("#list-page-reviews").on("click",".page-numbers",function(){
                var page = jQuery(this).attr("lang");
                paging_ajax(page,"new_topic","reviews","list-page-reviews",catid);
                $('html, body').animate({ scrollTop: 0 },100);
            });

            var usort = "id";
        });
    </script>

</div>
	<div class="bcolumn">
<div class="frm-search">
    <form id="form_search" name="form_search" method="get" onsubmit="return false">
        <input type="text" placeholder="Tìm kiếm..." value="" name="keywords">
        <select name="type_search">
            <option value="item" selected="">Sản phẩm</option><option value="news">Tin tức</option>
        </select>
        <input type="button" onclick="javascript: return doSubmit('');" name="search" title="Tìm kiếm" value="">
    </form>
</div><div class="frm-sign-up">
            <h4>Đăng ký tài khoản để có được thông tin sản phẩm mới và đăng bài trên site</h4>
        <a class="btn-sign-up" href="javascript:void(0)">Đăng ký</a>
        <div class="divide">Hoặc</div>
        <a class="btn-sign-in" href="javascript:void(0)">Đăng nhập</a>
    </div>   
    
<div class="hot-topic">
    <h3>TOPIC hot trong tháng</h3>
            <ul>
                            <li>
                    <div class="numb"><i>1</i></div>
                    <div class="item">
                        <a href="/rv5/Tin-tuc-2212/Hinh-anh-tren-tay-Samsung-Galaxy-S7-camera-da-khong-con-loi.html" title="Hình ảnh trên tay Samsung Galaxy S7: camera đã không còn lồi.">Hình ảnh trên tay Samsung Galaxy S7: camera đã không còn lồi.</a>
                        <span><i class="fa fa-eye"></i> 42,073</span>
                    </div>
                </li>
                            <li>
                    <div class="numb"><i>2</i></div>
                    <div class="item">
                        <a href="/rv5/Tin-tuc-170/Huong-dan-fix-full-iPhone-lock-nhat-iOS-8-x-updated-to-8-4.html" title="Hướng dẫn fix full iPhone lock nhật iOS 8.x (updated to 8.4)">Hướng dẫn fix full iPhone lock nhật iOS 8.x (updated to 8.4)</a>
                        <span><i class="fa fa-eye"></i> 41,018</span>
                    </div>
                </li>
                            <li>
                    <div class="numb"><i>3</i></div>
                    <div class="item">
                        <a href="/rv5/Tin-tuc-1168/Ung-dung-My-iDol-tao-nhan-vat-3D-vui-nhon-tu-khuon-mat-cua-ban.html" title="Ứng dụng My iDol tạo nhân vật 3D vui nhộn từ khuôn mặt của bạn.">Ứng dụng My iDol tạo nhân vật 3D vui nhộn từ khuôn mặt của bạn.</a>
                        <span><i class="fa fa-eye"></i> 22,092</span>
                    </div>
                </li>
                            <li>
                    <div class="numb"><i>4</i></div>
                    <div class="item">
                        <a href="/rv5/Tin-tuc-1079/Doupai-phan-mem-ghep-mat-vo-video-hai-huoc.html" title="Doupai - phần mềm ghép mặt vô video hài hước">Doupai - phần mềm ghép mặt vô video hài hước</a>
                        <span><i class="fa fa-eye"></i> 20,659</span>
                    </div>
                </li>
                            <li>
                    <div class="numb"><i>5</i></div>
                    <div class="item">
                        <a href="/rv3/Nguoi-dung-review-305/Review-Danh-gia-chi-tiet-Samsung-Galaxy-J5-man-hinh-dep-hieu-nang-kha-pin-tot.html" title="Review Đánh giá chi tiết Samsung Galaxy J5: màn hình đẹp, hiệu năng khá, pin tôt">Review Đánh giá chi tiết Samsung Galaxy J5: màn hình đẹp, hiệu năng khá, pin tôt</a>
                        <span><i class="fa fa-eye"></i> 19,872</span>
                    </div>
                </li>
                        <li><a href="#"></a></li>
        </ul>
    </div>    
<div class="st-fun">
    <h3>ảnh vui công nghệ</h3>
            <ul>
                            <li>
                    <a class="thumb" href="#" title="Thực trạng hiện nay :v">
                                                    <img src="http://reviewdao.vn/img/thumb/120_80/news/2016/03/0/451/20160329162708_de7bb59.gif" alt="Thực trạng hiện nay :v">
                                            </a>
                    <a class="title" title="Thực trạng hiện nay :v" href="/rv4/Vui-cong-nghe-2677/Thuc-trang-hien-nay-v.html">Thực trạng hiện nay :v</a>
                    <span><i class="fa fa-eye"></i> 272</span>
                </li>
                            <li>
                    <a class="thumb" href="#" title="Năm nay chưa thấy a Quảng nhá hàng gì cả">
                                                    <img src="http://reviewdao.vn/img/thumb/120_80/news/2016/03/0/451/20160327142206_12512661_1591555697832879_3380251796.jpg" alt="Năm nay chưa thấy a Quảng nhá hàng gì cả">
                                            </a>
                    <a class="title" title="Năm nay chưa thấy a Quảng nhá hàng gì cả" href="/rv4/Vui-cong-nghe-2658/Nam-nay-chua-thay-a-Quang-nha-hang-gi-ca.html">Năm nay chưa thấy a Quảng nhá hàng gì cả</a>
                    <span><i class="fa fa-eye"></i> 318</span>
                </li>
                            <li>
                    <a class="thumb" href="#" title="Mỗi người có một lý do riêng để mua iPhone SE :3">
                                                    <img src="http://reviewdao.vn/img/thumb/120_80/news/2016/03/0/451/20160325102250_12884637_917193368401683_147189029_n.jpg" alt="Mỗi người có một lý do riêng để mua iPhone SE :3">
                                            </a>
                    <a class="title" title="Mỗi người có một lý do riêng để mua iPhone SE :3" href="/rv4/Vui-cong-nghe-2634/Moi-nguoi-co-mot-ly-do-rieng-de-mua-iPhone-SE-3.html">Mỗi người có một lý do riêng để mua iPhone SE :3</a>
                    <span><i class="fa fa-eye"></i> 396</span>
                </li>
                            <li>
                    <a class="thumb" href="#" title="Mình rất thích đút ra đút vào mình sẽ mua LG G5 :3">
                                                    <img src="http://reviewdao.vn/img/thumb/120_80/news/2016/03/0/451/20160323221555_anigif.gif" alt="Mình rất thích đút ra đút vào mình sẽ mua LG G5 :3">
                                            </a>
                    <a class="title" title="Mình rất thích đút ra đút vào mình sẽ mua LG G5 :3" href="/rv4/Vui-cong-nghe-2616/Minh-rat-thich-dut-ra-dut-vao-minh-se-mua-LG-G5-3.html">Mình rất thích đút ra đút vào mình sẽ mua LG G5 :3</a>
                    <span><i class="fa fa-eye"></i> 376</span>
                </li>
                            <li>
                    <a class="thumb" href="#" title="Khi mà Tim Cook nói: &quot;One more thing...&quot; ">
                                                    <img src="http://reviewdao.vn/img/thumb/120_80/news/2016/03/0/451/20160322122140_12801259_492960377554282_81990069866.jpg" alt="Khi mà Tim Cook nói: &quot;One more thing...&quot; ">
                                            </a>
                    <a class="title" title="Khi mà Tim Cook nói: &quot;One more thing...&quot; " href="/rv4/Vui-cong-nghe-2597/Khi-ma-Tim-Cook-noi-One-more-thing.html">Khi mà Tim Cook nói: "One more thing..." </a>
                    <span><i class="fa fa-eye"></i> 455</span>
                </li>
                        <li><a title="Xem thêm" href="/Vui-cong-nghe-nc4.html">xem thêm</a></li>
        </ul>
    </div>   
</div>
	</div>
<%@ include file="_footer.jsp"%>
</body>
</html>