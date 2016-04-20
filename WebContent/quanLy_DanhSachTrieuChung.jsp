
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
<title>Danh Sách Triệu chứng</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" />
<link href="css/style.css" rel="stylesheet" type="text/css"
	media="screen,print" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="quanLy_TrangChu.jsp"%>
</head>
<body>
	<div class="container">
		<div class="row">
			<html:form action="/quan-ly-danh-sach-trieu-chung" method="get">
				<div>
					<html:text property="timTrieuChung" name="trieuChungForm"
						styleClass="form-control font-size:50px"></html:text>
				</div>
				<div>
					<html:link styleClass="btn btn-primary font-size:500px"
						action="/them-trieu-chung">+</html:link>
				</div>
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
									<th>Mã triệu chứng</th>
									<th>Tên triệu chứng</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<%-- 
							<logic:iterate name="trieuChungForm"
								property="listTrieuChung" id="tc">
								<tr>
									<th scope="row">
										<bean:write name="tc" property="maTrieuChung" />
									</th>
									<td>
										<bean:write name="tc" property="tenTrieuChung" />
									</td>
									<td>
										<bean:define id="maTrieuChung" name="tc" property="maTrieuChung"></bean:define>
										<html:link action="/xoa-trieu-chung?maTrieuChung=${maTrieuChung}"
											onclick="return confirm('Bạn có muốn xóa triệu chứng này ?')"
											style="margin-left: 20px;">
											<span class="glyphicon glyphicon-trash"></span>
										</html:link>
									</td>
								</tr>
							</logic:iterate>
							--%>
							</tbody>
						</table>
					</div>
				</div>
			</html:form>
		</div>
	</div>
</body>
</html>