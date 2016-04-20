
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
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" />
<link href="css/style.css" rel="stylesheet" type="text/css"
	media="screen,print" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<%@ include file="quanLy_TrangChu.jsp"%>
<body>
	<div class="container">
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
		<div class="panel-body">
			<div class="table-responsive">
				<table class="table table-striped table-bordered table-hover"
					id="dataTables-example">
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
							<tr>
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
	</div>
</body>
</html>