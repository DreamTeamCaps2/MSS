<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<html>
<%@ include file="login.jsp"%>
<head>
<meta charset="utf8">
<title>jQuery Dropdown Login Freebie | The Finished Box</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/jquery.rateyo.min.css"/>
<link rel="stylesheet" href="css/login-register/AdminLTE.min.css" />
<style>
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}
</style>
</head>
<body>
    <div class="container text-center" style="padding-top: 0px">    
        <!-- 	<h3>THÔNG TIN CỬA HÀNG</h3> -->
	  <div class="row">
	    <div class="col-sm-3 well">
	      <div class="well">
	        <p><a href="#">My Profile</a></p>
	        <img src="img/${taiKhoan1.anhDaiDien}" class="img-circle" height="100" width="100" alt="Avatar">
	      </div>
	      <div class="clearfix">
	      	<div id="rateYo"></div><div class="counter"></div>
	      </div>
	      <div class="well">
	      	<input type="button" class="btn btn-block btn-primary" id="btnDanhDau" onclick="ClickDanhDau()" value="Đánh dấu">
	      	<input type="button" class="btn btn-block btn-primary" id="btnToCao" onclick="ClickToCao()" value="Tố cáo">
	      </div>
	      <div class="well">
	        <p><a href="#">Interests</a></p>
	        <p>
	          <span class="label label-default">News</span>
	          <span class="label label-primary">W3Schools</span>
	          <span class="label label-success">Labels</span>
	          <span class="label label-info">Football</span>
	          <span class="label label-warning">Gaming</span>
	          <span class="label label-danger">Friends</span>
	        </p>
	      </div>
	    </div>
    <div class="col-sm-6">
      <div class="row">
        <div class="col-sm-12">
        	<div class="panel panel-default text-left">
            <div class="panel-body">
				<html:form action="/thongTinTKChiTiet" method="post">
			        <div class="row form-group">
			            <label class="col-lg-4">Tên Đăng Nhập</label>
			            <div class="col-lg-6">
			            	<html:text name="taiKhoan1" property="tenDangNhap" styleClass="form-control" readonly="true"></html:text>
			            </div>
			        </div>
					<div class="row form-group">
			            <label class="col-lg-4">SDT</label>
			            <div class="col-lg-6">
			            	<html:text property="SDT" styleClass="form-control" readonly="true"></html:text>
			            </div>
			        </div>
			        <div class="row form-group">
			            <label class="col-lg-4">Địa chỉ</label>
			            <div class="col-lg-6">
			            	<html:text property="diaChi" styleClass="form-control" readonly="true"></html:text>
			            </div>
			        </div>       
			        <div class="row form-group">
			            <label class="col-lg-4">Loại tài khoản</label>
			            <div class="col-lg-6">
			            <logic:notEmpty name="taiKhoanForm" property="cmnd"><html:text property="loaiTK" styleClass="form-control" value="Thành Viên" readonly="true"></html:text>
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
			            	<html:text property="cmnd" styleClass="form-control" readonly="true"></html:text>
			            </div>
			        </div>       
			        </logic:notEmpty>     
			        <logic:notEmpty name="taiKhoan1" property="email">    
			        <div class="row form-group">
			            <label class="col-lg-4">Email</label>
			            <div class="col-lg-6">
			            	<html:text property="email" styleClass="form-control" readonly="true"></html:text>
			            </div>
			        </div>            
			        </logic:notEmpty>       
			        <logic:notEmpty name="taiKhoan1" property="tenPhongKham">  
			        <div class="row form-group">
			            <label class="col-lg-4">Tên Phòng Khám</label>
			            <div class="col-lg-6">
			            	<html:text property="tenPhongKham" styleClass="form-control" readonly="true"></html:text>
			            </div>
			        </div>      
			        </logic:notEmpty>
			        <logic:notEmpty name="taiKhoan1" property="tenNhaThuoc">          
			        <div class="row form-group">
			            <label class="col-lg-4">Tên Nhà Thuốc</label>
			            <div class="col-lg-6">
			            	<html:text property="tenNhaThuoc" styleClass="form-control" readonly="true"></html:text>
			            </div>
			        </div>              
			        </logic:notEmpty>
			        <logic:notEmpty name="taiKhoan1" property="moTa">  
			        <div class="row form-group">
			            <label class="col-lg-4">Mô tả</label>
			            <div class="col-lg-6">
			            	<html:text property="moTa" styleClass="form-control" readonly="true"></html:text>
			            </div>
			        </div>            
			        </logic:notEmpty>
			        <logic:notEmpty name="taiKhoan1" property="thoiGian">    
			        <div class="row form-group">
			            <label class="col-lg-4">Thời gian</label>
			            <div class="col-lg-6">
			            	<html:text property="thoiGian" styleClass="form-control" readonly="true"></html:text>
			            </div>
			        </div>              
			        </logic:notEmpty>
			    </html:form>
			   </div>
		    </div>
	    </div>

		</div>
	<div class="panel panel-default text-left">
		<div class="panel-body">
							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
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
	</div>
		<div class="col-sm-3 well" style="text-align: left;">
			BÌNH LUẬN
			<div class="box-footer box-comments" id="boxcomment" style="background: white;">
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
                    <img class="img-responsive img-circle img-sm" src="img/${taiKhoan.anhDaiDien}" alt="alt text">
                    <!-- .img-push is used to add margin to elements next to floating images -->
                    <div class="img-push">
                      <input type="text" id="txtBinhLuan" class="form-control input-sm" placeholder="Press enter to post comment">
                      <button onclick="ClickBinhLuan()">OK</button>
                    </div>
                </div>                
	    </div>
	</div>
	</div>
  	<script src="js/jquery.rateyo.min.js"></script>
  	<script type="text/javascript">
  	var rat = <%= request.getAttribute("rating") %>
  	$(function () {
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
			alert("The rating is set to " + data.rating + "!");
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
		});
	});
	function ClickDanhDau() {
		alert("Click DAnh DAu");
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
	function ClickToCao() {
		alert("Click To Cao");
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
	function ClickBinhLuan() {
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
                    		+ '<img class="img-circle img-sm" src="img/user4-128x128.jpg" alt="user image">'
                    		+ '<div class="comment-text">'
                    			+ '<span class="username">'
                    				+"${taiKhoan.tenDangNhap}"
                    				+ '<span class="text-muted pull-right">'+data+'</span>' 
                    			+ '</span>'
                    			+ x
                    		+ '</div>'
                    		+'<div>';

                    $( "#boxcomment").append(html);
                    $('#txtBinhLuan').val("");
                
                },
  				error:function(data,status){
  				}
            });
            
            /* $( "#boxcomment").append( $(txt2) ); */
	}
  	</script>
  	<script src="js/dataTables/jquery.dataTables.js"></script>
	<script src="js/dataTables/dataTables.bootstrap.js"></script>
	<script>
            $(document).ready(function () {
                $('#dataTables-example').dataTable({
                	"order": [[ 3, "desc" ]],
                	"autoWidth": false,
	                "columnDefs": [
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
</body>
</html>