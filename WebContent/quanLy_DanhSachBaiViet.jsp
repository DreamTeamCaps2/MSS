<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<html>
<%@ include file="quanLy_TrangChu.jsp"%>
<head lang="en">
<meta charset="UTF-8">
<title>Danh Sách Bài Viết</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />	

</head>
<body>
	<html:form action="/quan-ly-bai-viet" method="get">
	<div class="container">
		<div class="col-lg-12" style="margin-bottom: 20px;">
			<a href="/MSS/them-bai-viet.do" class="btn btn-primary">THÊM BÀI VIẾT</a>
		</div>	
		<br>
		<div class="box">
			<div class="box-body">
					<table class="table table-striped table-bordered dt-bootstrap" id="dataTables-example">
						<thead>
							<tr>
								<th>Mã bài viết</th>
								<th>Tiêu đề</th>
								<th>Tóm tắt</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<logic:iterate name="baiVietForm" property="listBaiViet" id="tk">
								<tr>
									<th scope="row"><bean:write name="tk" property="maBaiViet" /></th>
									<td><bean:write name="tk" property="tieuDe" /></td>
									<td><bean:write name="tk" property="tomTat" /></td>
									<td>
									<bean:define id="maBaiViet" name="tk" property="maBaiViet"></bean:define> 
									<html:link action="/sua-bai-viet?maBaiViet=${maBaiViet}" style="margin-left: 20px;">
										<span class="glyphicon glyphicon-edit"></span>
									</html:link>
									<a onclick="xoaClick(${maBaiViet })" id="${maBaiViet}" href="#"><span class="glyphicon glyphicon-trash" style="margin-left: 20px;"></span></a>
									</td>
								</tr>
							</logic:iterate>
						</tbody>
					</table>
				</div>
			<script src="js/dataTables/jquery.dataTables.js"></script>
			<script src="js/dataTables/dataTables.bootstrap.js"></script>
			<script>
				$(document).ready(function() {
					$('#dataTables-example').dataTable({
						"order" : [ [ 3, "desc" ] ],
						"autoWidth" : false,
						"columnDefs" : [ 
						  	{"width": "10%", "targets": 0},
							{"width": "30%", "targets": 1},
							{"width": "50%", "targets": 2},
							{"width": "10%", "targets": 3} 
						  ]
					});
				});
				function xoaClick(maBaiViet) {
					var result = confirm('Bạn có chắc chắn muốn xóa  ?');
					if(result){
					   var requestData = {
							   maBaiVietXoa: maBaiViet
				            };
				            $.ajax({
				                url: '/MSS/quan-ly-bai-viet.do',
				                type: 'POST',
				                data: requestData,
				                dataType: 'json',
				                success:function(data,status){
								},
								error:function(data,status){
								}
				            });
				      window.location.assign("/MSS/quan-ly-bai-viet.do");
					}
				}
			</script>
		</div>
	</div>
	</html:form>
</body>
</html>