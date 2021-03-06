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
<title>Thông tin</title>
<!-- <meta name="viewport" content="width=device-width, initial-scale=1">
 -->
</head>
<body>
    <div class="container" style="padding-top: 0px ;width: 1000px;">    
        <!-- 	<h3>THÔNG TIN CỬA HÀNG</h3> -->
	 <div class="row" style="width: inherit; margin-left: 0px; margin-right: 0px; margin-top: 15px;">
	    <div class="col-sm-3 text-center" style="">
	      <div class="well">
	        <p><a href="#">My Profile</a></p>
	        <img src="img/${taiKhoan1.anhDaiDien}" class="img-circle" height="180px" width="180px" alt="Avatar">
	      </div>
	      <logic:empty name="taiKhoanForm" property="loaiTK">
	      <div class="clearfix">
	      	<div id="rateYo" style="padding-left: 25px;"></div>
	      	<!-- <div class="counter"></div> -->
	      </div>
	      <p id="textRate"></p>
	      <div class="well">
	      	<input type="button" class="btn btn-block btn-primary" id="btnDanhDau" onclick="ClickDanhDau()" value="Đánh dấu">
	      	<input type="button" class="btn btn-block btn-primary" id="btnToCao" onclick="ClickToCao()" value="Tố cáo">
	      </div>
	      </logic:empty>
	    </div>
	    <div class="col-sm-9">
  <div class="nav-tabs-custom" style="box-shadow: 1px 1px 1px 1px rgb(155, 144, 144); height: auto">
  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#home">Profile</a></li>
    <li><a data-toggle="tab" href="#menu1">Bình Luận</a></li>
    <li><a data-toggle="tab" href="#menu2">Giá Thuốc</a></li>
  </ul>

  <div class="tab-content">
    <div id="home" class="tab-pane fade in active">
        	<div class="text-left">
				<html:form action="/thongTinTKChiTiet" method="post">
					 <div class="row form-group">
			            <label class="col-lg-4">Tên Tài Khoản</label>
			            <div class="col-lg-6">
			            	<bean:write name="taiKhoanForm" property="tenDangNhap"/>
			            </div>
			        </div>
					<logic:notEmpty name="taiKhoan1" property="tenPhongKham">  
			        <div class="row form-group">
			            <label class="col-lg-4">Tên Phòng Khám</label>
			            <div class="col-lg-6">
			            	<bean:write name="taiKhoanForm" property="tenPhongKham"/>
			            </div>
			        </div>      
			        </logic:notEmpty>
			        <logic:notEmpty name="taiKhoan1" property="tenNhaThuoc">          
			        <div class="row form-group">
			            <label class="col-lg-4">Tên Nhà Thuốc</label>
			            <div class="col-lg-6">
			            	<bean:write name="taiKhoanForm" property="tenNhaThuoc"/>
			            </div>
			        </div>              
			        </logic:notEmpty>
					<div class="row form-group">
			            <label class="col-lg-4">SDT</label>
			            <div class="col-lg-6">
			            	<bean:write name="taiKhoanForm" property="SDT"/>
			            </div>
			        </div>
			        <div class="row form-group">
			            <label class="col-lg-4">Địa chỉ</label>
			            <div class="col-lg-6">
			            	<bean:write name="taiKhoanForm" property="diaChi"/>
			            </div>
			        </div>       
			        <div class="row form-group">
			            <label class="col-lg-4">Loại tài khoản</label>
			            <div class="col-lg-6">
			            <logic:notEmpty name="taiKhoanForm" property="loaiTK">Thành Viên
			            	<%-- <html:text property="loaiTK" styleClass="form-control" value="Thành Viên" readonly="true"></html:text> --%>
			            </logic:notEmpty>
			            <logic:notEmpty name="taiKhoanForm" property="tenPhongKham">Phòng Khám
			            </logic:notEmpty>
			            <logic:notEmpty name="taiKhoanForm" property="tenNhaThuoc">Nhà Thuốc
			            </logic:notEmpty>
			            </div>
			        </div>      
			        <logic:notEmpty name="taiKhoan1" property="cmnd">     
			        <div class="row form-group">
			            <label class="col-lg-4">CMND</label>
			            <div class="col-lg-6">
			            	<bean:write name="taiKhoanForm" property="cmnd"/>
			            </div>
			        </div>       
			        </logic:notEmpty>     
			        <logic:notEmpty name="taiKhoan1" property="email">    
			        <div class="row form-group">
			            <label class="col-lg-4">Email</label>
			            <div class="col-lg-6">
			            	<bean:write name="taiKhoanForm" property="email"/>
			            </div>
			        </div>            
			        </logic:notEmpty>       

			        <logic:notEmpty name="taiKhoan1" property="moTa">  
			        <div class="row form-group">
			            <label class="col-lg-4">Mô tả</label>
			            <div class="col-lg-6">
			            	<bean:write name="taiKhoanForm" property="moTa"/>
			            </div>
			        </div>            
			        </logic:notEmpty>
			        <logic:notEmpty name="taiKhoan1" property="thoiGian">    
			        <div class="row form-group">
			            <label class="col-lg-4">Thời gian</label>
			            <div class="col-lg-6">
			            	<bean:write name="taiKhoanForm" property="thoiGian"/>
			            </div>
			        </div>              
			        </logic:notEmpty>
			    </html:form>
			    </div>
    </div>
    <div id="menu1" class="tab-pane fade">
      <logic:empty name="taiKhoanForm" property="loaiTK">
			<div class="box-footer box-comments" id="boxcomment" style="background: white;overflow-y: scroll;height: 300px;">
				<c:forEach items="${taiKhoanForm.listBinhLuan}" var="list">
					<div class="box-comment">
						<img class="img-circle img-sm" src="img/${list.hinhAnh }" alt="user image">
						 <div class="comment-text">
						 	<span class="username">
						 		<c:out value="${list.tenTK}"/>
						 		<span class="text-muted pull-right"><c:out value="${list.thoiGian}"/></span>
						 	</span>
						 	<c:out value="${list.noiDung}"/>
						 </div>
					</div>
				</c:forEach>
          	</div>
				<div class="box-footer">
					<logic:present name="taiKhoan">
                    	<img class="img-responsive img-circle img-sm" src="img/${taiKhoan.anhDaiDien}" alt="alt text">
                    </logic:present>
                    <logic:notPresent name="taiKhoan">
                    	<img class="img-responsive img-circle img-sm" src="img/bird.jpg" alt="alt text">
                    </logic:notPresent>
                    <div class="img-push">
                    <div class="form-group margin-bottom-none">
                      	<input class="col-lg-9" type="text" id="txtBinhLuan" class="form-control input-sm" placeholder="Press enter to post comment">
                        <div class="col-lg-3">
                        	<button class="btn btn-danger pull-right btn-block btn-sm" onclick="ClickBinhLuan()">GỬI</button>
                        </div>
                    </div>
                    </div>
                   
                </div>                
	</logic:empty>
    </div>
    <div id="menu2" class="tab-pane fade">
      <logic:empty name="taiKhoanForm" property="loaiTK">
		<!-- THUOC -->
		<div class="box">
			<div class="box-body">
				<table class="table table-striped table-bordered dt-bootstrap" id="dataTables-example">
								<thead>
									<tr>
										<th>Mã Thuốc</th>
										<th>Tên Thuốc</th>
										<th>Giá</th>
										<th>Thông tin</th>
									</tr>
								</thead>
								<tbody>
									<logic:iterate name="taiKhoanForm" property="listThuocCuaHang" id="ch">
										<tr>
											<th scope="row"><bean:write name="ch" property="maThuoc" /></th>
											<td><bean:write name="ch" property="tenThuoc" /></td>
											<td>
												<bean:write name="ch" property="giaThuoc" />
											</td>
											<td>
											</td>
										</tr>

									</logic:iterate>

								</tbody>
							</table>
						</div>	
						</div>
		</logic:empty>
    </div>
  </div>
</div>
</div>
	</div>
	</div>
  	<script type="text/javascript">
  	var rat = <%= request.getAttribute("rating") %>;
  	var maTKDN = <%= request.getAttribute("maTKDN") %>;
  	var checkT ;
  	$(function () {
  		document.getElementById("textRate").innerHTML = rat;
  		$("#rateYo").rateYo({
  			rating: rat,
  		    halfStar: true
  		  });
  		$("#rateYo").rateYo()
	        .on("rateyo.change", function (e, data) {
	          var rating = data.rating;
	          $(this).next().text(rating);
        });

		$("#rateYo").rateYo().on("rateyo.set", function(e, data) {
			if(maTKDN!=false){
			  var tkkhach = "${taiKhoan1.maTK}";
	          var requestData = {
	  				rating: data.rating,
	  				tkkhach: tkkhach
	  	      };
	            $.ajax({
	                url: '/MSS/thongTinTKChiTiet.do',
	                type: 'POST',
	                data: requestData,
	                dataType: 'json',
	                success:function(data,status){
	  				},
	  				error:function(data,status){
	  				}
	            });
			}
			else{
				alert("Bạn cần phải đăng nhập mới có thể đánh giá");
			}
		});
	});
	function ClickDanhDau() {
		alert("Click DAnh DAu");
		if(maTKDN!=false){
			var mark = document.getElementById("btnDanhDau");
			if (mark.value=="Đánh dấu") 
				mark.value = "Đã Đánh Dấu";
			else mark.value = "Đánh dấu";
	        var requestData = {
	  				marked: true,
	  				tkkhach: "${taiKhoan1.maTK}"
	  	      };
	            $.ajax({
	                url: '/MSS/thongTinTKChiTiet.do',
	                type: 'POST',
	                data: requestData,
	                dataType: 'json',
	                success:function(data,status){
	  				},
	  				error:function(data,status){
	  				}
	            });
		}
		else{
			alert("Bạn cần phải đăng nhập mới có thể đánh dấu");
		}
	}
	function ClickToCao() {
		alert("Click To Cao");
		if(maTKDN!=false){
			var mark = document.getElementById("btnToCao");
			if (mark.value=="Tố cáo") {
				mark.value = "Đã Tố Cáo";
				mark.disabled = true;
			}
			else mark.value = "Tố cáo";
			
	        var requestData = {
	  				report: true,
	  				tkkhach: "${taiKhoan1.maTK}"
	  	      };
	            $.ajax({
	                url: '/MSS/thongTinTKChiTiet.do',
	                type: 'POST',
	                data: requestData,
	                dataType: 'json',
	                success:function(data,status){
	  				},
	  				error:function(data,status){
	  				}
	            });
		}
		else{
			alert("Bạn cần phải đăng nhập mới có thể tố cáo");
		}       
	}
	function ClickBinhLuan() {
		if(maTKDN!=false){
			var x = document.getElementById("txtBinhLuan").value;
	        
			alert(x);
	         var requestData = {
	  				comment: x,
	  				tkkhach: "${taiKhoan1.maTK}"
	  	      };
	            $.ajax({
	                url: '/MSS/thongTinTKChiTiet.do',
	                type: 'POST',
	                data: requestData,
	                dataType: 'text',
	                success:function(data,status){
	                	var html='';
	                    html = '<div class="box-comment">'
	                    		+ '<img class="img-circle img-sm" src="img/${taiKhoan.anhDaiDien}" alt="user image">'
	                    		+ '<div class="comment-text">'
	                    			+ '<span class="username">'
	                    				+"${taiKhoan.tenDangNhap}"
	                    				+ '<span class="text-muted pull-right">'+data+'</span>' 
	                    			+ '</span>'
	                    			+ x
	                    		+ '</div>'
	                    		+'<div>';
							checkT = data;
							alert(checkT);
	                    $( "#boxcomment").append(html);
	                    
	                
	                },
	  				error:function(data,status){
	  				}
	            });
		}
		else{
			alert("Bạn cần phải đăng nhập mới có thể bình luận");
		}  
		$('#txtBinhLuan').val("");
            /* $( "#boxcomment").append( $(txt2) ); */
	}
  	</script>

	<script>
            $(document).ready(function () {
                $('#dataTables-example').dataTable({
                	"order": [[ 0, "desc" ]],
                	"autoWidth" : false,
                	"columnDefs" : [ 
						{"width": "20%", "targets": 0},
						{"width": "30%", "targets": 1},
						{"width": "30%", "targets": 2},
						{"width": "20%", "targets": 3}, 
						{ "targets": [3], "searchable": false }			  	
	                 ]
                });
                
                var mark = <%= request.getAttribute("checkMark") %>;
                if(mark==true){
                	 document.getElementById("btnDanhDau").value = 'Đã Đánh Dấu';
                }
                var report = <%= request.getAttribute("checkReport") %>;
                if(report==true){
                	 document.getElementById("btnToCao").value = 'Đã Tố Cáo';
                	 document.getElementById("btnToCao").disabled = true;
                }
            });
    </script>
    <%@ include file="_footer.jsp"%>
</body>
</html>