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
<title>Danh Sách Loại Bệnh</title>
</head>
<%@ include file="quanLy_TrangChu.jsp"%>
<body>
	<div class="container">
		<div class="row">
			<html:form action="/quan-ly-loai-benh" method="get">
				<div class="row form-group">
					<div class="col-lg-3">
						<html:text property="tenLoaiBenh" name="loaiBenhForm"
							styleClass="form-control font-size:50px"></html:text>
						<p style="color: red;font-size:13px; padding-top: 5px">
							<html:errors property="tenLoaiBenhError"/>
						</p>
					</div>
					<div class="col-lg-4 col-lg-offset-2">
						<html:submit styleClass="btn btn-primary" property="submit"
							value="submit">Thêm mới</html:submit>
					</div>
				</div>
			</html:form>
		</div>
		<div class="box">
			<div class="box-body">
				<table class="table table-striped table-bordered dt-bootstrap" id="dataTables-example">
					<thead>
						<tr>
							<th>Mã loại bệnh</th>
							<th>Tên loại bệnh</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<logic:iterate name="loaiBenhForm" property="listLoaiBenh" id="lb">
							<tr>
								<th scope="row"><bean:write name="lb" property="maLoaiBenh" />
								</th>
								<td><bean:write name="lb" property="tenLoaiBenh" /></td>
								<td><bean:define id="maLoaiBenh" name="lb" property="maLoaiBenh"></bean:define>
									<html:link action="/quan-ly-loai-benh-xoa?maLoaiBenh=${maLoaiBenh}"
										onclick="return confirm('Bạn có muốn xóa loại bệnh này ?')"
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
	<script type="text/javascript">
	$(document).ready(function() {
		$('#dataTables-example').dataTable({
			"order" : [ [ 0, "desc" ] ],
			"columnDefs" : [ 
				{ "orderable": false, "targets": -1 } 
			]
		});
	});
	</script>
</body>
</html>