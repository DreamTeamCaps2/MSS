<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="toTop">
		<span class="glyphicon glyphicon-arrow-up"></span>
	</div>
	<script type="text/javascript">
		//roll top
		$(function() {
			$(window).scroll(function() {
				if ($(this).scrollTop() != 0) {
					$('#toTop').fadeIn();
				} else {
					$('#toTop').fadeOut();
				}
			});

			$('#toTop').click(function() {
				$('body,html').animate({
					scrollTop : 0
				}, 800);
			});
		});
	</script>
	<form name="FooterForm" id="FooterForm" method="post">
		<input type="hidden" name="form_block_id" value="49953">
		<footer>
			<div class="container"  style="background: inherit;"   >
				<ul class="main-menu">
					<li><a href="/MSS" title="TRANG CHỦ">TRANG CHỦ</a></li>
					<li><a title="THUỐC" href="/MSS/danh-sach-thuoc.do">THUỐC</a></li>
					<li><a title="BỆNH" href="/MSS/danh-sach-benh.do">BỆNH</a></li>
					<li><a title="CƠ SỞY TẾ" href="/MSS/dia-diem.do">CƠ SỞ Y TẾ</a></li>
					<li><a title="GÓP Ý" href="/MSS/gop-y.do">GÓP Ý</a></li>
					<li><a title="ABOUT" href="/MSS/gop-y.do">ABOUT</a></li>
				</ul>
				<ul class="network">
					<li><a target="_blank"
						href="https://www.facebook.com/reviewdaos"><i
							class="fa fa-facebook"></i></a></li>
					<li><a href="#"><i class="fa fa-twitter"></i></a></li>
					<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
					<li><a href="#"><i class="fa fa-rss"></i></a></li>
					<li><a target="_blank"
						href="https://www.youtube.com/channel/UC7MGCyKDw8iQX7Vs0-BH9uA"><i
							class="fa fa-youtube"></i></a></li>
					<li><a href="#">Điều khoản &amp; Quy định</a></li>
				</ul>
				<p>
				<div class="fl mt10">Copyright &copy;2016</div>
				<div class="c"></div>
			</div>
		</footer>
	</form>
</body>
</html>