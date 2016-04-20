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
<%@ include file="quanLy_TrangChu.jsp"%>
</head>
<body>
	<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Thêm bệnh</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-12">
									<html:form action="/them-benh" method="post">
   
								        <div class="row form-group">
								            <label class="col-lg-2">Tên bệnh</label>
								            <div class="col-lg-3">
								            	<html:text property="tenBenh" styleClass="form-control"  styleId="select-tenBenh"></html:text>
								          <p style="color: red;font-size:13px; padding-top: 5px">
								            	<html:errors property="tenBenhError"/>
								            	</p>
								            </div>
								          <div class="col-lg-4" style="margin-top: 5px;font-size:13px" >(*)</div>  	
								        </div>
								        <div class="row form-group">
								            <label class="col-lg-2">Nguyên nhân</label>
								            <div class="col-lg-3">
								            	<html:textarea property="nguyenNhan" styleClass="form-control"  styleId="select-nguyenNhan"></html:textarea>
								            	<p style="color: red;font-size:13px; padding-top: 5px">
								            	<html:errors property="nguyenNhanError"/>
								            	</p></div>
								        </div>
								        <div class="row form-group">
								            <label class="col-lg-2">Chẩn đoán </label>
								            <div class="col-lg-3">
								            	<html:textarea property="chanDoan" styleClass="form-control"  styleId="select-chanDoan"></html:textarea>
											<p style="color: red;font-size:13px; padding-top: 5px">
								            	<html:errors property="chanDoanError"/>
								            	</p></div>
								        </div>        
								                   
								        <div class="row form-group">
								            <label class="col-lg-2">Biến chứng</label>
								            <div class="col-lg-3">
								            	<html:textarea property="bienChung" styleClass="form-control"  styleId="select-bienChung"></html:textarea>
								           <p style="color: red;font-size:13px; padding-top: 5px">
								            	<html:errors property="bienChungError"/>
								            	</p></div>	
								        </div>
								        <div class="row form-group">
								            <label class="col-lg-2">Điều trị</label>
								            <div class="col-lg-3">
								            	<html:textarea property="dieuTri" styleClass="form-control"  styleId="select-dieuTri"></html:textarea>
								           <p style="color: red;font-size:13px; padding-top: 5px">
								            	<html:errors property="dieuTriError"/>
								            	</p></div>	
								        </div>
								        <div class="row form-group">
								            <label class="col-lg-2">Chế độ dinh dưỡng</label>
								            <div class="col-lg-3">
								            	<html:textarea property="cheDoDinhDuong" styleClass="form-control"  styleId="select-cheDoDinhDuong"></html:textarea>
								           <p style="color: red;font-size:13px; padding-top: 5px">
								            	<html:errors property="cheDoDinhDuongError"/>
								            	</p></div>	
								        </div>        
								        <div class="row form-group">
								        	<div class="col-lg-3">
												<html:select property="maLoaiBenh" styleClass="form-control"  styleId="select-maLoaiBenh">
													<option value="">-- Chọn loại bệnh --</option>
													<html:optionsCollection name="benhForm"
														property="listLoaiBenh" label="tenLoaiBenh" value="maLoaiBenh" />
												</html:select>	
												<p style="color: red;font-size:13px; padding-top: 5px">
								            	<html:errors property="maLoaiBenhError"/>
								            	</p>
								            </div>
								            <div class="col-lg-4" style="margin-top: 5px;font-size:13px" >(*)</div>  
										</div>
										<div class="row form-group">
								        	<label class="col-lg-2">Danh sách thuốc liên quan</label>
								        	<div class="col-lg-5">
													<table class="table table-striped table-bordered table-hover" id="dataTables-example" style="width : 90%">
																<thead>
																	<tr>
																		<th>Mã thuốc</th>
																		<th>Tên thuốc</th>
																	</tr>
																</thead>
																<tbody>
																	<logic:iterate name="benhForm"
																		property="listThuoc" id="t">
																		<tr>
																			<th scope="row">
																				<bean:write name="t" property="maThuoc" />
																			</th>
																			<td>
																				<bean:write name="t" property="tenThuoc" />
																			</td>
																		</tr>
																	</logic:iterate>
																</tbody>
														</table>
												</div>
												<div class="col-lg-3 col-lg-offset-2">
								            		<html:submit styleClass="btn btn-primary" property="changeThuoc" value="changeThuoc">Sua thuoc</html:submit>
								            	</div>
								        </div>
								        <div class="row form-group">
								        	<label class="col-lg-2">Danh sách triệu chứng liên quan</label>
								        	<div class="col-lg-5">
													<table class="table table-striped table-bordered table-hover" id="dataTables-example" style="width : 90%">
																<thead>
																	<tr>
																		<th>Mã triệu chứng</th>
																		<th>Tên triệu chứng</th>
																	</tr>
																</thead>
																<tbody>
																	<logic:iterate name="benhForm"
																		property="listTrieuChung" id="tc">
																		<tr>
																			<th scope="row">
																				<bean:write name="tc" property="maTrieuChung" />
																			</th>
																			<td>
																				<bean:write name="tc" property="tenTrieuChung" />
																			</td>
																		</tr>
																	</logic:iterate>
																</tbody>
														</table>
												</div>
												<div class="col-lg-3 col-lg-offset-2">
								            		<html:submit styleClass="btn btn-primary" property="changeTrieuChung" value="changeTrieuChung">Sua trieu chung</html:submit>
								            	</div>
								        </div>
														
								        <div class="row form-group">
								            <div class="col-lg-3 col-lg-offset-2">
								            	<html:submit styleClass="btn btn-primary" property="submit" value="submit">Thêm mới</html:submit>
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