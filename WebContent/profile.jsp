<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<html>
<%@ include file="login.jsp"%>
<head>
	<link rel="stylesheet" href="css/reviewdao.vn.css" />
    <meta charset="utf8">
    <title>jQuery Dropdown Login Freebie | The Finished Box</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
  	<style>
	    .active {
	    font-size: 14px;
	    border-bottom: 0px;
		}
		.image-preview-input {
		    position: relative;
			overflow: hidden;
			margin: 0px;    
		    color: #333;
		    background-color: #fff;
		    border-color: #ccc;    
		}
		.image-preview-input input[type=file] {
			position: absolute;
			top: 0;
			right: 0;
			margin: 0;
			padding: 0;
			font-size: 20px;
			cursor: pointer;
			opacity: 0;
			filter: alpha(opacity=0);
		}
		.image-preview-input-title {
		    margin-left:2px;
		}
  	</style>
  	<script type="text/javascript">

	  	$(document).on('click', '#close-preview', function(){ 
	  	    $('.image-preview').popover('hide');
	  	    // Hover befor close the preview
	  	    $('.image-preview').hover(
	  	        function () {
	  	           $('.image-preview').popover('show');
	  	        }, 
	  	         function () {
	  	           $('.image-preview').popover('hide');
	  	        }
	  	    );    
	  	});
	
	  	$(function() {
	  	    // Create the close button
	  	    var closebtn = $('<button/>', {
	  	        type:"button",
	  	        text: 'x',
	  	        id: 'close-preview',
	  	        style: 'font-size: initial;',
	  	    });
	  	    closebtn.attr("class","close pull-right");
	  	    // Set the popover default content
	  	    $('.image-preview').popover({
	  	        trigger:'manual',
	  	        html:true,
	  	        title: "<strong>Preview</strong>"+$(closebtn)[0].outerHTML,
	  	        content: "There's no image",
	  	        placement:'bottom'
	  	    });
	  	    // Clear event
	  	    $('.image-preview-clear').click(function(){
	  	        $('.image-preview').attr("data-content","").popover('hide');
	  	        $('.image-preview-filename').val("");
	  	        $('.image-preview-clear').hide();
	  	        $('.image-preview-input input:file').val("");
	  	        $(".image-preview-input-title").text("Browse"); 
	  	    }); 
	  	    // Create the preview image
	  	    $(".image-preview-input input:file").change(function (){     
	  	        var img = $('<img/>', {
	  	            id: 'dynamic',
	  	            width:250,
	  	            height:200
	  	        });      
	  	        var file = this.files[0];
	  	        var reader = new FileReader();
	  	        // Set preview image into the popover data-content
	  	        reader.onload = function (e) {
	  	            $(".image-preview-input-title").text("Change");
	  	            $(".image-preview-clear").show();
	  	            $(".image-preview-filename").val(file.name);            
	  	            img.attr('src', e.target.result);
	  	            $(".image-preview").attr("data-content",$(img)[0].outerHTML).popover("show");
	  	        }        
	  	        reader.readAsDataURL(file);
	  	    });  
	  	});
  	</script>
</head>
<body>
	<div class="container text-center" style="width: 1200px;">
	  <div class="row">
	    <div class="col-sm-3 well">
	      <div class="well">
	        <p><a href="#">My Profile</a></p>
	        <a href="#" id="pop">
	        	<img src="img/${taiKhoan1.anhDaiDien}" class="img-circle" height="100" width="100" alt="Avatar">
			</a>
	      </div>
	      <div class="well">
			<ul class="nav nav-pills nav-stacked" role="tablist">
			    <li class="active"><html:link action="thongTinTK">Thông tin tài khoản</html:link></li>
				<li><a href="/MSS/doi-mat-khau.do">Đổi mật khẩu</a></li>
			    <li><a href="#">Thông báo</a></li>
			    <li><a href="#">Tin nhắn</a></li>
			    <li><a href="#">Đã lưu</a></li>
			    <logic:notEmpty name="taiKhoan1" property="tenNhaThuoc">
			    <li><html:link action="/quan-ly-thuoc-cua-hang">Quản lý thuốc</html:link></li>
			    </logic:notEmpty>
			    <logic:notEmpty name="taiKhoan1" property="tenPhongKham">
			    <li><a href="#">Quản lý phòng khám</a></li>
			    </logic:notEmpty>
		  	</ul>
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
    <div class="col-sm-9">
    	<h3>THÔNG TIN TÀI KHOẢN	</h3>
      <div class="row">
        <div class="col-sm-12">
        	<div class="panel panel-default text-left">
            <div class="panel-body">
				<html:form action="/thongTinTK" method="post">
			        <div class="row form-group">
			            <label class="col-lg-4">Tên Đăng Nhập</label>
			            <div class="col-lg-6">
			            	<html:text name="taiKhoan1" property="tenDangNhap" styleClass="form-control" readonly="true"></html:text>
			            </div>
			        </div>
			   		<logic:notEmpty name="taiKhoan1" property="email">    
			        <div class="row form-group">
			            <label class="col-lg-4">Email</label>
			            <div class="col-lg-6">
			            	<html:text property="email" styleClass="form-control" readonly="true"></html:text>
			            </div>
			        </div>            
			        </logic:notEmpty>  
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
					<div class="row form-group">
			            <label class="col-lg-4">SDT</label>
			            <div class="col-lg-6">
			            	<html:text property="SDT" styleClass="form-control"></html:text>
			            </div>
			        </div>
			        <div class="row form-group">
			            <label class="col-lg-4">Địa chỉ</label>
			            <div class="col-lg-6">
			            	<html:text styleId="diaChi" property="diaChi" styleClass="form-control"></html:text>
			            </div>
			        </div>       
			        <logic:notEmpty name="taiKhoan1" property="cmnd">     
			        <div class="row form-group">
			            <label class="col-lg-4">CMND</label>
			            <div class="col-lg-6">
			            	<html:text property="cmnd" styleClass="form-control"></html:text>
			            </div>
			        </div>       
			        </logic:notEmpty>     
     
			        <logic:notEmpty name="taiKhoan1" property="tenPhongKham">  
			        <div class="row form-group">
			            <label class="col-lg-4">Tên Phòng Khám</label>
			            <div class="col-lg-6">
			            	<html:text property="tenPhongKham" styleClass="form-control"></html:text>
			            </div>
			        </div>      
			        </logic:notEmpty>
			        <logic:notEmpty name="taiKhoan1" property="tenNhaThuoc">          
			        <div class="row form-group">
			            <label class="col-lg-4">Tên Nhà Thuốc</label>
			            <div class="col-lg-6">
			            	<html:text property="tenNhaThuoc" styleClass="form-control"></html:text>
			            </div>
			        </div>              
			        </logic:notEmpty>
			        <logic:notEmpty name="taiKhoan1" property="moTa">  
			        <div class="row form-group">
			            <label class="col-lg-4">Mô tả</label>
			            <div class="col-lg-6">
			            	<html:text property="moTa" styleClass="form-control"></html:text>
			            </div>
			        </div>            
			        </logic:notEmpty>
			        <logic:notEmpty name="taiKhoan1" property="thoiGian">    
			        <div class="row form-group">
			            <label class="col-lg-4">Thời gian</label>
			            <div class="col-lg-6">
			            	<html:text property="thoiGian" styleClass="form-control"></html:text>
			            </div>
			        </div>              
			        </logic:notEmpty>
			        <logic:notEqual name="taiKhoanForm" property="submit" value="MEMBER">
			        <div class="row form-group">
			            <div class="col-lg-4 col-lg-offset-6">
			            	<html:submit styleClass="btn btn-primary" property="submit" value="OK">Thêm mới</html:submit>
			            	<html:link action="/home.do" styleClass="btn btn-primary">Trang chủ</html:link>
			            </div>
			        </div>
			        </logic:notEqual>
			    </html:form>
			   </div>
		    </div>
	    </div>

		</div>
	</div>
	</div>
	</div>
	<div class="modal fade" id="myModal" role="dialog"
		data-keyboard="false" data-backdrop="static">
		<div class="modal-dialog" style="width: 800px;background-color: white;margin-top: 100px;">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="myModalLabel">Đổi ảnh đại diện</h3>
		</div>
		<div class="modal-body">
			<div class="input-group image-preview">
				<input type="text" class="form-control image-preview-filename"
					disabled="disabled">
				<!-- don't give a name === doesn't send on POST/GET -->
				<span class="input-group-btn"> <!-- image-preview-clear button -->
					<button type="button" class="btn btn-default image-preview-clear"
						style="display: none;">
						<span class="glyphicon glyphicon-remove"></span> Clear
					</button> <!-- image-preview-input -->
					<div class="btn btn-default image-preview-input">
						<span class="glyphicon glyphicon-folder-open"></span> <span
							class="image-preview-input-title">Browse</span> <input
							type="file" accept="image/png, image/jpeg, image/gif"
							name="input-file-preview" />
						<!-- rename it -->
					</div>
				</span>
			</div>
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
			<button class="btn btn-primary">Save changes</button>
		</div>
		</div>
	</div>
	<%@ include file="_footer.jsp"%>
<script type="text/javascript">
	$("#pop").on("click", function() {
		$('#myModal').modal('show'); // imagemodal is the id attribute assigned to the bootstrap modal, then i use the show function
	});
</script>
</body>
</html>