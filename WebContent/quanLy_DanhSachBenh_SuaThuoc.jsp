<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<html>
<head lang="en">
<meta charset="UTF-8">
<title>Thêm bệnh</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" />
<link href="css/style.css" rel="stylesheet" type="text/css"
	media="screen,print" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
	<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Thêm thuốc cho bệnh</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-12">
									<html:form action="/quan-ly-danh-sach-benh-sua-thuoc" method="post">
										<div class="row form-group">
												<div class="col-lg-12">
													<div class="col-lg-6">
														<label >Những thuốc đã chọn</label>
													</div>
													<div class="col-lg-6">
														<div class="col-lg-3">
															<label >Tên thuốc</label>
														</div>
														<div class="col-lg-3">
										            		<html:text property="timThuoc"  style="margin-top: 0px;font-size:13px; height : 25px" styleClass="form-control"  styleId="select-timThuoc"></html:text>
										            	</div>
										            	<script>
															$("#select-timThuoc").change(function(){
																var timThuoc = $("#select-timThuoc").val();
															   
															   window.location.assign("/Caps2/quan-ly-danh-sach-benh-sua-thuoc.do?timThuoc="+timThuoc);
															});
														</script>
													</div>
												</div>
												<div class="col-lg-12">
													<div class="col-lg-6">
														<table class="table table-striped table-bordered table-hover" id="dataTables-example" style="width : 90%">
																<thead>
																	<tr>
																		<th>Mã thuốc</th>
																		<th>Tên thuốc</th>
																		<th></th>
																	</tr>
																</thead>
																<tbody>
																	<logic:iterate name="benhThuocForm"
																		property="listThuocChon" id="t">
																		<tr>
																			<th scope="row">
																				<bean:write name="t" property="maThuoc" />
																			</th>
																			<td>
																				<bean:write name="t" property="tenThuoc" />
																			</td>
																			<td>
																				<bean:define id="maThuoc" name="t" property="maThuoc"></bean:define>
																				<html:link action="/quan-ly-danh-sach-benh-sua-thuoc?maThuocXoa=${maThuoc}" >
																					<span class="glyphicon glyphicon-trash"></span>
																				</html:link> 
																			</td>
																		</tr>
																	</logic:iterate>
																</tbody>
														</table>
													</div>
													<div class="col-lg-6">
														<table class="table table-striped table-bordered table-hover" id="dataTables-example" style="width : 90%">
																<thead>
																	<tr>
																		<th>Mã thuốc</th>
																		<th>Tên thuốc</th>
																		<th></th>
																	</tr>
																</thead>
																<tbody>
																	<logic:iterate name="benhThuocForm"
																		property="listThuocTim" id="t">
																		<tr>
																			<th scope="row">
																				<bean:write name="t" property="maThuoc" />
																			</th>
																			<td>
																				<bean:write name="t" property="tenThuoc" />
																			</td>
																			 <td>
																				<bean:define id="maThuoc" name="t" property="maThuoc"></bean:define>
																				 <html:link action="/quan-ly-danh-sach-benh-sua-thuoc?maThuocChon=${maThuoc}" >
																					<span class="glyphicon glyphicon-plus"></span>
																				</html:link>  
																			</td> 
																		</tr>
																	</logic:iterate>
																</tbody>
															</table>
													</div>
												</div>
										</div>
														
												<div class="row form-group">
								            		<div class="col-lg-3 col-lg-offset-2">
										                <html:link action="/sua-benh?kt=${1}" >
																<span class="glyphicon glyphicon-repeat"></span>
														</html:link>
								            		</div>
								        </div>
								    </html:form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
</body>
</html>