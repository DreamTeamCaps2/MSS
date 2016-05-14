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
</head>
<body>
	<div class="wrapper-page" style="width: 1000px; margin: 0 auto;">
		<div class="wrap-body container" style="padding-bottom: 20px;">
			<div class="container-fluid"
				style="width: 1000px; padding-top: 15px;">
				<ul class="pgwSlider">
					<c:forEach items="${thongBaoForm.listBaiVietSlider}" var="list"
						varStatus="loopCounter">
						<c:if test="${loopCounter.count < 6}">
							<li><h5><a
								href="/MSS/chi-tiet-bai-viet.do?maBaiViet=${list.maBaiViet}"
								target="_blank"> <img alt="" src="images/${list.hinhAnh }">
									<span>
											<c:out value="${list.tieuDe}"></c:out>
										</span>
							</a></h5></li>
						</c:if>
					</c:forEach>
				</ul>
			</div>

			<script type="text/javascript">
$(document).ready(function() {
    $('.pgwSlider').pgwSlider({
    	maxHeight:350
    });
	$('.dotdotdot').dotdotdot();		
});
</script>
			<div class="container">
				<div class="acolumn">

					<div class="opt">
						<a id="tab-label-new" class="link-post active"
							href="#tab-new-topic">new topic</a>
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
								<c:forEach items="${thongBaoForm.listBaiViet}" var="list"
									varStatus="loopCounter">
										<div class="itemBaiViet">
											<li style="border-bottom: 1px solid #dedede;"><a
												class="thumb"
												href="/MSS/chi-tiet-bai-viet.do?maBaiViet=${list.maBaiViet}">
													<img alt="" src="images/${list.hinhAnh }">
											</a> <html:link styleClass="title"
													style="margin-left: 0%; margin-right: 0%;"
													action="chi-tiet-bai-viet?maBaiViet=${list.maBaiViet}">
													<c:out value="${list.tieuDe}" />
												</html:link>
												<div class="dotdotdot" style="height: 100px">
													<p>
														<c:out value="${list.tomTat}"></c:out>
													</p>
												</div>
												<div class="st-post-feature">
													<span><i class="fa fa-eye"></i>
													<c:out value="${list.luotXem}"></c:out></span>
												</div></li>
										</div>
								</c:forEach>
							</ul>
						</div>
						<div class="page-navigation" id="pagination" align="center"></div>
						<script>
						 var pc = <%= request.getParameter("page") %>;
						 var tongBaiViet = <%= request.getAttribute("tongBaiViet") %>;
							jQuery(function($) {
								var items = $(".itemBaiViet");
								var numItems = tongBaiViet;
								
								var perPage = 10;
								items.slice(perPage).hide();
								$("#pagination").pagination({
									items : numItems,
									prevText: "<",
									nextText: ">",
									itemsOnPage : perPage,
									edges:1,
									cssStyle : "light-theme",
									hrefTextPrefix: "?page=",
									currentPage : pc,
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
					<div style="margin-left: 13px; width: 272px;">
						<p style=" font-size: 16px;font-weight: 700; text-align: center; padding-bottom: 5px; margin: 10px 0 0 0; border-bottom: 2px solid #25af61;">XEM NHIỀU</p>
						<div class="tabPanel-widget">
							<label for="tab-1" tabindex="0"></label> <input id="tab-1"
								type="radio" name="tabs" checked="true" aria-hidden="true">
							<h2>BỆNH</h2>
							<div class="hot-topic" style="margin-top: 0px;">
								<ul>
									<c:forEach items="${thongBaoForm.listBenhXemNhieu}" var="list"
										varStatus="loopCounter">
										<li>
											<div class="numb">
												<i><c:out value="${loopCounter.count}" /></i>
											</div>
											<div class="item1">
												<a href="/MSS/chi-tiet-benh.do?ma=${list.maBenh}"
													title="${list.tenBenh}"><c:out value="${list.tenBenh}" /></a>
												<span><i class="fa fa-eye"></i>
												<c:out value="${list.luotXem}" /></span>
											</div>
										</li>
									</c:forEach>
									<li style="margin-bottom: 0px;"><a href="#"></a></li>
								</ul>
							</div>
							<label for="tab-2" tabindex="0"></label> <input id="tab-2"
								type="radio" name="tabs" aria-hidden="true">
							<h2>THUỐC</h2>
							<div class="hot-topic" style="margin-top: 0px;">
								<ul>
									<c:forEach items="${thongBaoForm.listThuocXemNhieu}" var="list"
										varStatus="loopCounter">
										<li>
											<div class="numb">
												<i><c:out value="${loopCounter.count}" /></i>
											</div>
											<div class="item1">
												<a href="/MSS/chi-tiet-thuoc.do?ma=${list.maThuoc}"
													title="${list.tenThuoc}"><c:out
														value="${list.tenThuoc}" /></a> <span><i
													class="fa fa-eye"></i>
												<c:out value="${list.luotXem}" /></span>
											</div>
										</li>
									</c:forEach>
									<li style="margin-bottom: 0px;"><a href="#"></a></li>
								</ul>
							</div>
							<label for="tab-3" tabindex="0"></label> <input id="tab-3"
								type="radio" name="tabs" aria-hidden="true">
							<h2>BÀI VIẾT</h2>
							<div class="hot-topic" style="margin-top: 0px;">
								<ul>
									<c:forEach items="${thongBaoForm.listBaiVietXemNhieu}"
										var="list" varStatus="loopCounter">
										<li>
											<div class="numb">
												<i><c:out value="${loopCounter.count}" /></i>
											</div>
											<div class="item1">
												<a
													href="/MSS/chi-tiet-bai-viet.do?maBaiViet=${list.maBaiViet}"
													title="${list.tieuDe}"><c:out value="${list.tieuDe}" /></a>
												<span><i class="fa fa-eye"></i>
												<c:out value="${list.luotXem}" /></span>
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
		</div>
	</div>
	<%@ include file="_footer.jsp"%>
</body>
</html>