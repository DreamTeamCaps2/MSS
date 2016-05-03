<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<html>
<head lang="en">
<meta charset="UTF-8">
<title>Thêm thuốc</title>
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
						<div class="panel-heading">Thêm thuốc</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-12">
									<html:form action="/them-thuoc" method="post" enctype="multipart/form-data">
   
								        <div class="row form-group">
								            <label class="col-lg-2">Tên thuốc</label>
								            <div class="col-lg-3">
								            	<html:text property="tenThuoc" styleClass="form-control"  styleId="select-tenThuoc"></html:text>
								          <p style="color: red;font-size:13px; padding-top: 5px">
								            	<html:errors property="tenThuocError"/>
								            	</p>
								            </div>
								          <div class="col-lg-4" style="margin-top: 5px;font-size:13px" >(*)</div>  	
								        </div>
								        <div class="row form-group">
					                      <label class="col-lg-2" for="exampleInputFile">File input</label>
					                      <div class="col-lg-3">
					                      	<input name="file" type="file" id="exampleInputFile">
					                      </div>
					                    </div>
								        <div class="row form-group">
								            <label class="col-lg-2">Công thức</label>
								            <div class="col-lg-3">
								            	<html:text property="congThuc" styleClass="form-control"  styleId="select-congThuc"></html:text>
								            	<p style="color: red;font-size:13px; padding-top: 5px">
								            	<html:errors property="congThucError"/>
								            	</p></div>
								        </div>
								        <div class="row form-group">
								            <label class="col-lg-2">Tên khoa học </label>
								            <div class="col-lg-3">
								            	<html:text property="tenKhoaHoc" styleClass="form-control"  styleId="select-tenKhoaHoc"></html:text>
											<p style="color: red;font-size:13px; padding-top: 5px">
								            	<html:errors property="tenKhoaHocError"/>
								            	</p></div>
								        </div>        
								                   
								        <div class="row form-group">
								            <label class="col-lg-2">Điều chế</label>
								            <div class="col-lg-3">
								            	<html:textarea property="dieuChe" styleClass="form-control"  styleId="select-dieuChe"></html:textarea>
								           <p style="color: red;font-size:13px; padding-top: 5px">
								            	<html:errors property="dieuCheError"/>
								            	</p></div>	
								        </div>
								        <div class="row form-group">
								            <label class="col-lg-2">Tính chất</label>
								            <div class="col-lg-3">
								            	<html:textarea property="tinhChat" styleClass="form-control"  styleId="select-tinhChat"></html:textarea>
								           <p style="color: red;font-size:13px; padding-top: 5px">
								            	<html:errors property="tinhChatError"/>
								            	</p></div>	
								        </div>
								        <div class="row form-group">
								            <label class="col-lg-2">Tác dụng</label>
								            <div class="col-lg-3">
								            	<html:textarea property="tacDung" styleClass="form-control"  styleId="select-tacDung"></html:textarea>
								           <p style="color: red;font-size:13px; padding-top: 5px">
								            	<html:errors property="tacDungError"/>
								            	</p></div>	
								        </div>  
								        <div class="row form-group">
								            <label class="col-lg-2">Chỉ định</label>
								            <div class="col-lg-3">
								            	<html:textarea property="chiDinh" styleClass="form-control"  styleId="select-chiDinh"></html:textarea>
								           <p style="color: red;font-size:13px; padding-top: 5px">
								            	<html:errors property="chiDinhError"/>
								            	</p></div>	
								        </div>       
								        <div class="row form-group">
								            <label class="col-lg-2">Bảo quản</label>
								            <div class="col-lg-3">
								            	<html:textarea property="baoQuan" styleClass="form-control"  styleId="select-baoQuan"></html:textarea>
								           <p style="color: red;font-size:13px; padding-top: 5px">
								            	<html:errors property="baoQuanError"/>
								            	</p></div>	
								        </div> 
								        <div class="row form-group">
								            <label class="col-lg-2">Thận trọng</label>
								            <div class="col-lg-3">
								            	<html:textarea property="thanTrong" styleClass="form-control"  styleId="select-thanTrong"></html:textarea>
								           <p style="color: red;font-size:13px; padding-top: 5px">
								            	<html:errors property="thanTrongError"/>
								            	</p></div>	
								        </div> 
								        <div class="row form-group">
								            <label class="col-lg-2">DDH</label>
								            <div class="col-lg-3">
								            	<html:textarea property="DDH" styleClass="form-control"  styleId="select-DDH"></html:textarea>
								           <p style="color: red;font-size:13px; padding-top: 5px">
								            	<html:errors property="DDHError"/>
								            	</p></div>	
								        </div> 
								        <div class="row form-group">
								        	<label class="col-lg-2">Danh sách bệnh liên quan</label>
								        	<div class="col-lg-5">
													<table class="table table-striped table-bordered table-hover" id="dataTables-example" style="width : 90%">
																<thead>
																	<tr>
																		<th>Mã Bệnh</th>
																		<th>Tên Bệnh</th>
																		<th>Loại Bệnh</th>
																	</tr>
																</thead>
																<tbody>
																	<logic:iterate name="thuocForm"
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
																		</tr>
																	</logic:iterate>
																</tbody>
														</table>
												</div>
												<div class="col-lg-3 col-lg-offset-2">
								            		<html:submit styleClass="btn btn-primary" property="change" value="change">Sua benh</html:submit>
								            	</div>
								        </div>
								        <div class="row form-group">
								          <div class="col-lg-3" >
												<html:select property="maLoaiThuoc" styleClass="form-control" styleId="select-maLoaiThuoc">
													<option value="maLoaiThuoc">-- Chọn loại thuốc --</option>
													<html:optionsCollection name="thuocForm"
													property="listLoaiThuoc" label="tenLoaiThuoc" value="maLoaiThuoc" />
												</html:select>	
											</div>
											<div class="col-lg-4" style="margin-top: 5px;font-size:13px" >(*)</div>  
										</div>
											<script>
												$("#select-maLoaiThuoc").change(function(){
													
													var maLoaiThuoc= $("#select-maLoaiThuoc").val();
												   
													var tenThuoc = $("#select-tenThuoc").val();
													var congThuc = $("#select-congThuc").val();
													var tenKhoaHoc = $("#select-tenKhoaHoc").val();
													var dieuChe = $("#select-dieuChe").val();
													var tinhChat = $("#select-tinhChat").val();
													var tacDung = $("#select-tacDung").val();
													var chiDinh = $("#select-chiDinh").val();
													var baoQuan = $("#select-baoQuan").val();
													var thanTrong = $("#select-thanTrong").val();
													var DDH = $("#select-DDH").val();
													var maNhomThuoc= $("#select-maNhomThuoc").val();
													var link = "/MSS/them-thuoc.do?maLoaiThuoc="+maLoaiThuoc
													   +"&tenThuoc="+tenThuoc
													   +"&congThuc="+congThuc
													   +"&tenKhoaHoc="+tenKhoaHoc
													   +"&dieuChe="+dieuChe
													   +"&tinhChat="+tinhChat
													   +"&tacDung="+tacDung
													   +"&chiDinh="+chiDinh
													   +"&baoQuan="+baoQuan
													   +"&thanTrong="+thanTrong
													   +"&DDH="+DDH
													   +"&maNhomThuoc="+maNhomThuoc;
													
 													var requestData = {
 															tenThuoc: tenThuoc,
 															congThuc: congThuc,
 															tenKhoaHoc : tenKhoaHoc,
 															dieuChe : dieuChe,
 															tinhChat : tinhChat,
 															tacDung : tacDung,
 															chiDinh : chiDinh,
 															baoQuan : baoQuan,
 															thanTrong : thanTrong,
 															DDH : DDH,
 															maLoaiThuoc : maLoaiThuoc,
 															maNhomThuoc : maNhomThuoc,
 															check : 1
											  	      };
											            $.ajax({
											                url: '/MSS/them-thuoc.do',
											                type: 'POST',
											                data: requestData,
											                dataType: 'text',
											                success:function(data,status){
											                	alert(data);
											                	 window.location.assign("/MSS/them-thuoc.do");
											  				},
											  				error:function(data,status){
											  				}
											            }); 
														 //  window.location.assign("/MSS/them-thuoc.do");
												});
											</script>
										<div class="row form-group">
										 	<div class="col-lg-3">
											
												<html:select property="maNhomThuoc" styleClass="form-control" styleId="select-maNhomThuoc">
													<option value="maNhomThuoc">-- Chọn nhomThuoc --</option>
													<html:optionsCollection name="thuocForm"
													property="listNhomThuoc" label="tenNhomThuoc" value="maNhomThuoc" />
												</html:select>	
												<p style="color: red;font-size:13px; padding-top: 5px">
								            	<html:errors property="maNhomThuocError"/>
								            	</p>
											</div> 
											<div class="col-lg-4" style="margin-top: 5px;font-size:13px" >(*)</div>  
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