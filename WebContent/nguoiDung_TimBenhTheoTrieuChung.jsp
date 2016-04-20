<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ include file="login.jsp"%>
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
						<div class="panel-heading">Tìm bệnh</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-12">
									<html:form action="/tim-benh-theo-trieu-chung" method="post">
										<div class="row form-group">
												<div class="col-lg-12">
													<div class="col-lg-6">
														<label >Những triệu chứng của bệnh cần tìm</label>
													</div>
													<div class="col-lg-6">
														<div class="col-lg-3">
															<label >Triệu chứng</label>
														</div>
														<div class="col-lg-3">
										            		<html:text property="timTrieuChung"  style="margin-top: 0px;font-size:13px; height : 25px" styleClass="form-control"  styleId="select-timTrieuChung"></html:text>
										            	</div>
										            	<script>
															$("#select-timTrieuChung").change(function(){
																var timTrieuChung = $("#select-timTrieuChung").val();
															   
															   window.location.assign("/MSS/tim-benh-theo-trieu-chung.do?timTrieuChung="+timTrieuChung);
															});
														</script>
													</div>
												</div>
												<div class="col-lg-12">
													<div class="col-lg-6">
														<table class="table table-striped table-bordered table-hover" id="dataTables-example" style="width : 90%">
																<thead>
																	<tr>
																		<th>Mã Triệu chứng</th>
																		<th>Tên triệu chứng</th>
																		<th></th>
																	</tr>
																</thead>
																<tbody>
																	<logic:iterate name="benhTrieuChungForm"
																		property="listTrieuChungChon" id="t">
																		<tr>
																			<th scope="row">
																				<bean:write name="t" property="maTrieuChung" />
																			</th>
																			<td>
																				<bean:write name="t" property="tenTrieuChung" />
																			</td>
																			<td>
																				<bean:define id="maTrieuChung" name="t" property="maTrieuChung"></bean:define>
																				<html:link action="/tim-benh-theo-trieu-chung?maTrieuChungXoa=${maTrieuChung}" >
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
																		<th>Mã Triệu chứng</th>
																		<th>Tên triệu chứng</th>
																		<th></th>
																	</tr>
																</thead>
																<tbody>
																	<logic:iterate name="benhTrieuChungForm"
																		property="listTrieuChungTim" id="t">
																		<tr>
																			<th scope="row">
																				<bean:write name="t" property="maTrieuChung" />
																			</th>
																			<td>
																				<bean:write name="t" property="tenTrieuChung" />
																			</td>
																			 <td>
																				<bean:define id="maTrieuChung" name="t" property="maTrieuChung"></bean:define>
																				 <html:link action="/tim-benh-theo-trieu-chung?maTrieuChungChon=${maTrieuChung}" >
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
														
												<div class="col-lg-12">
													<table class="table table-striped table-bordered table-hover" id="dataTables-example" style="width : 90%">
																<thead>
																	<tr>
																		<th>Mã Bệnh</th>
																		<th>Tên Bệnh</th>
																		<th>Loại Bệnh</th>
																		<th></th>
																	</tr>
																</thead>
																<tbody>
																	<logic:iterate name="benhTrieuChungForm"
																		property="listBenh" id="b">
																		<tr>
																			<th scope="row">
																				<bean:write name="b" property="maBenh" />
																			</th>
																			<td>
																				<bean:write name="b" property="tenBenh" />
																			</td>
																			<td>
																				<bean:write name="b" property="tenLoaiBenh" />
																			</td>
																			 <td>
																				<bean:define id="maBenh" name="b" property="maBenh"></bean:define>
																				 <html:link action="/chi-tiet-benh?maBenh=${maBenh}" >
																					<span class="glyphicon glyphicon-list"></span>
																				</html:link>  
																			</td> 
																		</tr>
																	</logic:iterate>
																</tbody>
														</table>
												</div>
												<div class="row form-group">
								            		<div class="col-lg-3 col-lg-offset-2">
										                <button class="btn btn-primary" onclick="history.go(-1);">Quay lại</button>
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