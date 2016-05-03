<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link rel="stylesheet" href="css/bootstrap.min.css" />
	<link rel="stylesheet" href="css/font-awesome.css" />
	<link rel="stylesheet" href="css/login.css" />
    <link rel="stylesheet" href="css/mss.css" />
    <link rel="stylesheet" href="css/simplePagination.css"/>
    <link rel="stylesheet" href="css/jquery.rateyo.min.css"/>
    <link href="js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />	
    <link rel="stylesheet" href="css/reviewdao.vn.css" />
  	
    <script src="js/jquery-1.11.2.min.js"></script>     
    <script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.easy-autocomplete.min.js" type="text/javascript"></script>
	<script src="js/jquery.simplePagination.js" type="text/javascript"></script>
	<script src="js/dataTables/jquery.dataTables.js"></script>
	<script src="js/dataTables/dataTables.bootstrap.js"></script>
	<script src="js/jquery.rateyo.min.js"></script>

    <link href="css/easy-autocomplete.min.css" rel="stylesheet">
	<link href="css/easy-autocomplete.themes.min.css" rel="stylesheet">
	<style>
	.eac-square input {
		background-image: url("images/ico-search.png");
		background-repeat: no-repeat;
		background-position: right 10px center;
	}
	</style>
	<script type="text/javascript">
		$(document).ready(function() {
			//set width and height for list nav thuoc
				var soLuongNhomThuoc = <bean:write name="thongBaoForm" property="soLuongNhomThuoc" />;
				var soLuongLoaiThuoc = <bean:write name="thongBaoForm" property="soLuongLoaiThuoc" />;
				var widthThuoc= parseInt(soLuongLoaiThuoc)*250;
				var heightThuoc = (parseInt(soLuongNhomThuoc)*40+60);
				$("ul .list-loai-thuoc").css("width",widthThuoc+"px");
				$("ul .list-loai-thuoc").css("height",heightThuoc+"px"); 
				$("div .dropdown.loaithuoc").css("width",80/soLuongLoaiThuoc+"%");
				//set width and height for list nav benh
				var soLuongLoaiBenh = <bean:write name="thongBaoForm" property="soLuongLoaiBenh" />;
			 
		});
	</script>
<script>

	function Click() {

		var ten = document.getElementById("square").value.split(" ");
		var chuoi = "";
		for (var i = 0; i < ten.length; i++) {
			if (i == ten.length - 1)
				chuoi = chuoi + ten[i];
			else
				chuoi = chuoi + ten[i] + "+";
		}
		var timKiem = "/MSS/tim-kiem.do?timKiem=" + chuoi;
		window.location.assign(timKiem);

	}
	function runScript(e) {
		if (e.keyCode == 13) {
			var ten = document.getElementById("square").value.split(" ");
			var chuoi = "";
			for (var i = 0; i < ten.length; i++) {
				if (i == ten.length - 1)
					chuoi = chuoi + ten[i];
				else
					chuoi = chuoi + ten[i] + "+";
			}
			var timKiem = "/MSS/tim-kiem.do?timKiem=" + chuoi;
			window.location.assign(timKiem);
		}
	}
    function clicked() {
		var a = document.getElementById("checkCLICK").checked;
		var tenDangNhap = document.getElementById("tenDangNhap").value;
		var matKhau = document.getElementById("matKhau").value;
		if(a == true ){
			setCookie('tenDangNhap', tenDangNhap, 10);
			setCookie('matKhau', matKhau, 10);
		}
			
    }

	function setCookie(cname, cvalue, exdays) {
	    var d = new Date();
	    d.setTime(d.getTime() + (exdays*24*60*60*1000));
	    var expires = "expires="+d.toUTCString();
	    document.cookie = cname + "=" + cvalue + "; " + expires;
	}
	function getCookie(cname) {
	    var name = cname + "=";
	    var ca = document.cookie.split(';');
	    for(var i=0; i<ca.length; i++) {
	        var c = ca[i];
	        while (c.charAt(0)==' ') c = c.substring(1);
	        if (c.indexOf(name) == 0) return c.substring(name.length, c.length);
	    }
	    return "";
	}
</script>
<script>
 
</script>
</head>
<body>
<nav class="navbar navbar-default navbar-inverse" role="navigation">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a href="/MSS" class="navbar-brand" >HOME</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="/MSS/danh-sach-thuoc.do">THUỐC
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu list-loai-thuoc ">
							<logic:iterate id="x" name="thongBaoForm"
								property="listLoaiThuoc">

								<div class="dropdown loaiThuoc" >
									<div class="title-loai-thuoc">
										<a
											href="/MSS/danh-sach-thuoc.do?maLoaiThuoc=<bean:write name="x" property="maLoaiThuoc"/>">
											<bean:write name="x" property="tenLoaiThuoc" />
										</a>
									</div>
									<bean:define id="prodName" name="x" property="maLoaiThuoc" />
									<logic:iterate name="thongBaoForm" property="listNhomThuoc"
										id="a">
										<logic:equal name="a" property="maLoaiThuoc"
											value="${prodName}">
											<li class="nhomThuoc"><a style="font-size: 15px;"
												href="/MSS/danh-sach-thuoc.do?maNhomThuoc=<bean:write name="a" property="maNhomThuoc"/>">
													<bean:write name="a" property="tenNhomThuoc" />
											</a></li>

										</logic:equal>
									</logic:iterate>
								</div>
							</logic:iterate>
						</ul></li>
					<li class="dropdown"><a href="/MSS/danh-sach-benh.do">BỆNH
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu list-benh-nav" style="width: 600px;">
							<logic:iterate id="x" name="thongBaoForm" property="listLoaiBenh">

								<li class="dropdown loai-benh-nav">
									<div>
										<a
											href="/MSS/danh-sach-benh.do?maLoaiDanhSach=<bean:write name="x" property="maLoaiBenh" />"><bean:write
												name="x" property="tenLoaiBenh" /> </a>

									</div>
								</li>

							</logic:iterate>
							<li class="divider"></li>
							<li><a href="/MSS/danh-sach-benh.do"
								style="font-size: 20px; text-align: center;">Tất Cả Loại
									Bệnh</a>
							<li><a href="/MSS/tim-benh-theo-trieu-chung.do"
								style="font-size: 20px; text-align: center;">Tìm bệnh theo
									triệu chứng</a></li>
						</ul></li>
					<logic:equal name="quanLy" value="1">
						<li><a href="/MSS/quanLy_TrangChu.jsp">QUẢN LÝ</a></li>
					</logic:equal>
					<li><a href="/MSS/dia-diem.do">CƠ SỞ Y TẾ</a></li>
					<li><a href="/MSS/gop-y.do">GÓP Ý</a></li>
					<li><a href="/MSS/gop-y.do">ABOUT</a></li>
				</ul>
				<div class="form-group col-sm-4" style="margin-top: 13px;">
        	   <input type="text" id="square" placeholder="Nhập Từ Khóa Cần Tìm" class="form-control"
						name="timKiem" size=30 onkeypress="return runScript(event)"> 
        		
					<script>
						var options = {

							url : function(phrase) {
								phrase = encodeURI(phrase);
								return "getJSON.jsp?phrase=" + phrase;
							},

							categories : [ {
								listLocation : "listBenh",
								maxNumberOfElements : 4,
								header : "----------Bệnh--------"
							}, {
								listLocation : "listThuoc",
								maxNumberOfElements : 4,
								header : "----------Thuốc--------"
							} ],

							getValue : function(element) {
								return element.name;
							},
							template: {
						        type: "links",
						        fields: {
						            link: "link"
						        }
						    },
							list : {
								maxNumberOfElements : 8,
								match : {
									enabled : true
								},
								sort : {
									enabled : true
								},
							},

							theme: "square"
						};

						$("#square").easyAutocomplete(options);
					</script>

		</div>  	
		
		<ul class="nav navbar-nav navbar-right">
		    <logic:notPresent name="taiKhoan">
        	<li><p class="navbar-text">Already have an account?</p></li>
        	<li class="dropdown1">
          		<a href="login_admin.jsp"><b>Login</b> <span class="caret"></span></a>
          		<!-- <a href="login_admin.jsp" class="dropdown-toggle" data-toggle="dropdown"><b>Login</b> <span class="caret"></span></a> -->
				<ul id="login-dp" class="dropdown-menu">
					<li>
					 <div class="row">
							<div class="col-md-12">
								 <html:form styleClass="form"  method="post" action="/login" acceptCharset="UTF-8" styleId="login-nav">
										<div class="form-group">
											 <input type="text" id="tenDangNhap" name="tenDangNhap" class="form-control" placeholder="Username" required>
										</div>
										<div class="form-group">
											 <input type="password" id="matKhau" name="matKhau" class="form-control" placeholder="Password" required>
                                             <div class="help-block text-right"><a href="/MSS/quen-mat-khau.do">Forget the password ?</a></div>
										</div>
										<div class="form-group">
											<html:submit styleId="btnDangNhap" property="submit" value="OK" onclick="clicked();" styleClass="btn btn-primary btn-block">Login</html:submit>   
										</div>
										<div class="checkbox">
											 <label>
											 <input type="checkbox" id="checkCLICK" onclick="clickCheck(this);"> Keep me logged-in
											 </label>
										</div>
								 </html:form>
							</div>
							<div class="bottom text-center">
								New here ? <html:link action="/dangKyTK"><b>Join Us</b></html:link>
							</div>
					 </div>
					</li>
				</ul>
			</li>
			</logic:notPresent>
			<logic:present name="taiKhoan">
			<li class="dropdown1">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown"><b><bean:write name="taiKhoan" property="tenDangNhap"/></b> <span class="caret"></span></a>
				<ul id="login-dp" class="dropdown-menu">
					<li>
					 <div class="row">
<!-- 							<div class="col-md-12">
								 <form class="form" role="form" method="post" action="login" accept-charset="UTF-8" id="login-nav">
										<div class="form-group">
											 <button type="submit" class="btn btn-primary btn-block">Sign in</button>
										</div>
								 </form>
							</div>
 -->							<div class="bottom text-center">
 								<%-- <html:link action="/thongTinTK"> --%>
 								 <html:link styleClass="title" action="thongTinTK"><b>Thông tin tài khoản</b></html:link>
							</div>
							<div class="bottom text-center">
								<html:link action="/dang-xuat"><b>Đăng xuất</b></html:link>
							</div>
					 </div>
					</li>
				</ul>
				</li>
						<logic:notEqual value="0" property="soQuyen" name="thongBaoForm">
							<li class="dropdown">
								<logic:equal value="0" property="soLuong" name="thongBaoForm">
									<a href="#" class="dropdown-toggle" data-toggle="dropdown">
										<span class="glyphicon glyphicon-flag"></span>
									</a>
								</logic:equal> 
								<logic:notEqual value="0" property="soLuong" name="thongBaoForm">
									
										<a href="#" class="dropdown-toggle" data-toggle="dropdown">
										<p style="color: red;">
											<bean:write property="soLuong" name="thongBaoForm" /><span
											class="glyphicon glyphicon-flag"></span></p>
										</a>
									
								</logic:notEqual>
								<ul class="dropdown-menu" id="list-thong-bao"
									style="width: 500px; height: 500px;">
									<div>
										<div class="thong-bao-title">
											<h3>THÔNG BÁO</h3>
										</div>
										<logic:iterate id="x" name="thongBaoForm" property="listThongBao">
											<div class="thong-bao-chu-de">
												<a
													href="/MSS/chi-tiet-gop-y.do?maGopY=<bean:write name="x" property="maGopY" />"><b>(Góp
														Ý)<bean:write name="x" property="chuDe" />
												</b></a>
												<p style="margin-left: 10%;">
													<bean:write name="x" property="thoiGian" />
													"
												</p>
											</div>
										</logic:iterate>
										<div>
											<a href="/MSS/quan-ly-gop-y.do"> Xem Tất Cả Thông Báo</a>
										</div>
									</div>

								</ul></li>
						</logic:notEqual>				
			</logic:present>
      </ul>
     </div>
    </div>
</nav>
    <script type="text/javascript">
	    $(function() {
	        var button = $('#loginButton');
	        var box = $('#loginBox');
	        var form = $('#loginForm');
	        button.removeAttr('href');
	        button.mouseup(function(login) {
	            box.toggle();
	            button.toggleClass('active');
	        });
	        form.mouseup(function() { 
	            return false;
	        });
	        $(this).mouseup(function(login) {
	            if(!($(login.target).parent('#loginButton').length > 0)) {
	                button.removeClass('active');
	                box.hide();
	            }
	        });
	    });
	    $('ul.nav li.dropdown1').hover(function() {
	    	  $(this).find('.dropdown-menu').stop(true, true).delay(100).fadeIn(100);
	    	}, function() {
	    	  $(this).find('.dropdown-menu').stop(true, true).delay(3000).fadeOut(500);
	    	});
	    $('ul.nav li.dropdown').hover(function() {
	    	  $(this).find('.dropdown-menu').stop(true, true).delay(100).fadeIn(100);
	    	}, function() {
	    	  $(this).find('.dropdown-menu').stop(true, true).delay(100).fadeOut(200);
	    	});
    </script>

</body>
</html>