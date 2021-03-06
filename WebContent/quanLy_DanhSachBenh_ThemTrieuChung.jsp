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
						<div class="panel-heading">Thêm triệu chứng cho bệnh</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-12">
									<html:form action="/quan-ly-danh-sach-benh-them-trieu-chung" method="post">
										<div class="row form-group">
												<div class="col-lg-12">
													<div class="col-lg-6">
														<label >Những triệu chứng đã chọn</label>
													</div>
													<div class="col-lg-6">
														<div class="col-lg-3">
															<label >Tên triệu chứng</label>
														</div>
														<div class="col-lg-3">
										            		<html:text property="timTrieuChung"  style="margin-top: 0px;font-size:13px; height : 25px" styleClass="form-control"  styleId="select-timTrieuChung"></html:text>
										            	</div>
										            	<script>
															$("#select-timTrieuChung").change(function(){
																var timTrieuChung = $("#select-timTrieuChung").val();
															   
															   window.location.assign("/MSS/quan-ly-danh-sach-benh-them-trieu-chung.do?timTrieuChung="+timTrieuChung);
															});
														</script>
													</div>
												</div>
												<div class="col-lg-12">
													<div class="col-lg-6">
														<table class="table table-striped table-bordered table-hover" id="dataTables-example" style="width : 90%">
																<thead>
																	<tr>
																		<th>Mã triệu chứng</th>
																		<th>Tên triệu chứng</th>
																		<th></th>
																	</tr>
																</thead>
																<tbody>
																	<logic:iterate name="benhTrieuChungForm"
																		property="listTrieuChungChon" id="tc">
																		<tr>
																			<th scope="row">
																				<bean:write name="tc" property="maTrieuChung" />
																			</th>
																			<td>
																				<bean:write name="tc" property="tenTrieuChung" />
																			</td>
																			<td>
																				<bean:define id="maTrieuChung" name="tc" property="maTrieuChung"></bean:define>
																				<html:link action="/quan-ly-danh-sach-benh-them-trieu-chung?maTrieuChungXoa=${maTrieuChung}" >
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
																	<logic:iterate name="benhTrieuChungForm"
																		property="listTrieuChungTim" id="tc">
																		<tr>
																			<th scope="row">
																				<bean:write name="tc" property="maTrieuChung" />
																			</th>
																			<td>
																				<bean:write name="tc" property="tenTrieuChung" />
																			</td>
																			 <td>
																				<bean:define id="maTrieuChung" name="tc" property="maTrieuChung"></bean:define>
																				 <html:link action="/quan-ly-danh-sach-benh-them-trieu-chung?maTrieuChungChon=${maTrieuChung}" >
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
										                <html:link action="/them-benh?kt=${1}" >
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