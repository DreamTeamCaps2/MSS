
<%@page import="form.ThongBaoForm"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<html>
<head lang="en">
<meta charset="UTF-8">
<title>Danh Sách Bệnh</title>
</head>
<%@ include file="quanLy_TrangChu.jsp"%>
<body>
	<div class="container" style="padding-bottom: 50px">
		<div class="row">
			<html:form action="/quan-ly-danh-sach-benh" method="get">
				<div class="col-lg-3">
					<html:select property="maLoaiBenh" styleClass="form-control" styleId="select-maLoaiBenh">
						<option value="">-- Chọn loại bệnh --</option>
						<html:optionsCollection name="benhForm" property="listLoaiBenh"
							label="tenLoaiBenh" value="maLoaiBenh" />
					</html:select>
					<script>
					$("#select-maLoaiBenh").change(function(){

					   var maLoaiBenh = $("#select-maLoaiBenh").val();
					   var timBenh = $("#select-timBenh").val();
					   
					   window.location.assign("/MSS/quan-ly-danh-sach-benh.do?maLoaiBenh="+maLoaiBenh+"&timBenh="+timBenh);
					});
					</script> 
				</div>
				<div class="col-lg-3">
					<html:text property="timBenh" name="benhForm"
						styleClass="form-control font-size:50px" styleId="select-timBenh"></html:text>
					<script>
					$("#select-timBenh").change(function(){

					   var maLoaiBenh = $("#select-maLoaiBenh").val();
					   var timBenh = $("#select-timBenh").val();
					   
					   window.location.assign("/MSS/quan-ly-danh-sach-benh.do?maLoaiBenh="+maLoaiBenh+"&timBenh="+timBenh);
					});
					</script> 
				</div>
				<div>
					<html:link styleClass="btn btn-primary font-size:500px"
						action="/them-benh">+</html:link>
				</div>
			</html:form>
		</div>
		<div class="box">
			<div class="box-body">
				<table class="table table-striped table-bordered dt-bootstrap" id="dataTables-example">
					<thead>
						<tr>
							<th>Mã Bệnh</th>
							<th>Tên Bệnh</th>
							<th>Loại Bệnh</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<logic:iterate name="benhForm" property="listBenh" id="b">
							<tr class="item">
								<th scope="row"><bean:write name="b" property="maBenh" />
								</th>
								<td><bean:write name="b" property="tenBenh" /></td>
								<td><bean:write name="b" property="tenLoaiBenh" /></td>
								<td><bean:define id="maBenh" name="b" property="maBenh"></bean:define>
									<html:link action="/sua-benh?maBenh=${maBenh}">
										<span class="glyphicon glyphicon-list"></span>
									</html:link> <html:link action="/xoa-benh?maBenh=${maBenh}"
										onclick="return confirm('Bạn có muốn xóa benh này ?')"
										style="margin-left: 20px;">
										<span class="glyphicon glyphicon-trash"></span>
									</html:link></td>
							</tr>
						</logic:iterate>
					</tbody>
				</table>
				
			</div>
		</div>
		<script type="text/javascript">
		$(document).ready(function() {
			$('#dataTables-example').dataTable({
				"order" : [ [ 0, "desc" ] ],
				"searching": false,
				"columnDefs" : [ 
				  	{"width": "10%", "targets": 0},
					{"width": "30%", "targets": 1},
					{"width": "30%", "targets": 2},
					{"width": "10%", "targets": 3},
					{ "orderable": false, "targets": -1 }
				  ]
			});
		});
		</script>
	</div>
</body>
</html>