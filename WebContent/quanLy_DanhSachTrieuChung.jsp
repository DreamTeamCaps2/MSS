<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<html>
<title>Danh Sách Triệu Chứng</title>
<%@ include file="quanLy_TrangChu.jsp"%>
<head lang="en">
<meta charset="UTF-8">

</head>
<body>
	<div class="container" style="padding-bottom: 50px">
	<html:form action="/quan-ly-trieu-chung">
		<div class="row">
			<div class="col-lg-12">
				<div class=row>
						<div class="col-lg-2">Tên triệu chứng</div>
						<div class=col-lg-5>
							<input type="text" name="tenTrieuChung"
								placeholder="Tên triệu chứng" size="50px;">
								<br>
							<html:errors property="tenTrieuChungError" />
						</div>
						<div class="col-lg-3">
							<html:submit styleClass="btn btn-primary" property="submit"
								value="Add"></html:submit>
						</div>	
				</div>
			</div>
		</div>
		<br>
		<div class="box">
			<div class="box-body">
					<table class="table table-striped table-bordered dt-bootstrap" id="dataTables-example">
						<thead>
							<tr>
								<th>Mã triệu chứng</th>
								<th>Tên triệu chứng</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<logic:iterate name="trieuChungForm" property="listTrieuChung" id="tk">
								<tr>
									<th scope="row"><bean:write name="tk" property="maTrieuChung" /></th>
									<td><bean:write name="tk" property="tenTrieuChung" /></td>
									<td>
										<bean:define id="maTrieuChung" name="tk" property="maTrieuChung"></bean:define> 
										<html:link action="/sua-trieu-chung?maTrieuChung=${maTrieuChung}">
											<span class="glyphicon glyphicon-edit"></span>
										</html:link>
										<a onclick="xoaClick(${maTrieuChung })" id="${maTrieuChung}" href="#"><span class="glyphicon glyphicon-trash" style="margin-left: 20px;"></span></a>
									</td>
								</tr>
							</logic:iterate>
						</tbody>
					</table>
				</div>
			<script>
				var bientoancuc = 0;
				function luuToanCuc(maTrieuChung){
					bientoancuc = maTrieuChung;
				}
				$(document).ready(function() {
					$('#dataTables-example').dataTable({
						"order" : [ [ 0, "desc" ] ],
						"columnDefs" : [ 
							{ "orderable": false, "targets": -1 } 
						]
					});
				});
				function xoaClick(maTrieuChung) {
					var result = confirm('Bạn có chắc chắn muốn xóa  ?');
					if(result){
					   var requestData = {
							   maTrieuChungXoa: maTrieuChung
				            };
				            $.ajax({
				                url: '/MSS/quan-ly-trieu-chung.do',
				                type: 'POST',
				                data: requestData,
				                dataType: 'json',
				                success:function(data,status){
								},
								error:function(data,status){
								}
				            });
				      window.location.assign("/MSS/quan-ly-trieu-chung.do");
					}
				}
			</script>
		</div>
		</html:form>		
	</div>
</body>
</html>