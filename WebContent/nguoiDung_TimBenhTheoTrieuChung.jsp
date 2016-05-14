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
<title>Tìm bệnh theo triệu chứng</title>
<script src="js/jquery.easy-autocomplete.min.js" type="text/javascript"></script>
<link href="css/easy-autocomplete.min.css" rel="stylesheet">
<link href="css/easy-autocomplete.themes.min.css" rel="stylesheet">
</head>
<body>
	<div class="container timbenhtheotrieuchung" style="padding-top: 20px; padding-bottom: 40px;">
		<div class="row">
			<input type="text" id="trieuchungauto"
				placeholder="Nhập triệu chứng cần tìm" name="timKiem" style="width: 300px">
			<script>
				var t = {

					url : function(phrase) {
						phrase = encodeURI(phrase);
						return "trieuChungJSON.jsp?phrase=" + phrase
								+ "&format=json";
					},

					getValue : function(element) {
						return element.tenTrieuChung;
					},
					ajaxSettings : {
						dataType : "json",
						method : "POST",
						data : {
							dataType : "json"
						}
					},

					preparePostData : function(data) {
						data.phrase = $("#trieuchungauto").val();
						return data;
					},
					list : {
						onClickEvent : function() {
							var selectedItemValue = $("#trieuchungauto")
									.getSelectedItemData().maTrieuChung;
							window.location
									.assign("/MSS/tim-benh-theo-trieu-chung.do?maTrieuChungChon="
											+ selectedItemValue);
						},
					},

					theme : "square"
				};

				$("#trieuchungauto").easyAutocomplete(t);
			</script>
		</div>
		<div class="row">
			<div class="col-lg-1 col-md-1 col-sm-1"></div>
			<div class="col-lg-3 col-md-3 col-sm-3">
				<h4>Bảng Chọn Triệu Chứng</h4>
			</div>
			<div class="col-lg-3 col-md-3 col-sm-3">
				<h4>Bảng Triệu Chứng Đã Chọn</h4>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-4">
				<h4>Bệnh Liên Quan</h4>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-1 col-md-1 col-sm-1"></div>
			<div class="col-lg-3 col-md-3 col-sm-3">

				<div class="danhsachtrieuchung">
					<%-- <ul>
						<logic:iterate id="x" name="benhTrieuChungForm" property="listTrieuChungTim">
						
							<li> <bean:write name="x" property="tenTrieuChung" /> </li>
						</logic:iterate>
						
					</ul> --%>
					<table class="table table-striped table-bordered table-hover"
						id="dataTables-example">
						<thead>
							<tr>
								<th>Tên triệu chứng</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<logic:iterate name="benhTrieuChungForm"
								property="listTrieuChungTim" id="t">
								<tr>
									<td><bean:write name="t" property="tenTrieuChung" /></td>
									<td><bean:define id="maTrieuChung" name="t"
											property="maTrieuChung"></bean:define> <html:link
											action="/tim-benh-theo-trieu-chung?maTrieuChungChon=${maTrieuChung}">
											<span class="glyphicon glyphicon-plus"></span>
										</html:link></td>
								</tr>
							</logic:iterate>
						</tbody>
					</table>
				</div>
			</div>
			<div class="col-lg-3 col-md-3 col-sm-3">
				<div class="danhsachtrieuchung">
					<table class="table table-striped table-bordered table-hover"
						id="dataTables-example">
						<thead>
							<tr>
								<th>Tên triệu chứng</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<logic:iterate name="benhTrieuChungForm"
								property="listTrieuChungChon" id="t">
								<tr>
									<td><bean:write name="t" property="tenTrieuChung" /></td>
									<td><bean:define id="maTrieuChung" name="t"
											property="maTrieuChung"></bean:define> <html:link
											action="/tim-benh-theo-trieu-chung?maTrieuChungXoa=${maTrieuChung}">
											<span class="glyphicon glyphicon-trash"></span>
										</html:link></td>
								</tr>
							</logic:iterate>
						</tbody>
					</table>
				</div>
			</div>
			<div class="col-lg-5 col-md-5 col-sm-5">
				<div class="danhsachtrieuchung">
					<table class="table table-striped table-bordered table-hover"
						id="dataTables-example">
						<thead>
							<tr>
								<th>Tên Bệnh</th>
								<th style="width: 111px">Loại Bệnh</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<logic:iterate name="benhTrieuChungForm" property="listBenh"
								id="b">
								<tr>
									<td><bean:write name="b" property="tenBenh" /></td>
									<td><bean:write name="b" property="tenLoaiBenh" /></td>
									<td><bean:define id="maBenh" name="b" property="maBenh"></bean:define>
										<html:link action="/chi-tiet-benh?ma=${maBenh}">
											<span class="glyphicon glyphicon-list"></span>
										</html:link></td>
								</tr>
							</logic:iterate>
						</tbody>
					</table>
				</div>
			</div>

		</div>
		<div class="huongdansudung">
			<p>
				<span style="font-size: 16px"><em><strong>Hướng
							dẫn sử dụng :</strong></em></span>
			</p>

			<p style="text-align: justify;">+ Nhập th&ocirc;ng tin v&agrave;o
				&ocirc; &quot;Nhập Triệu Chứng Cần T&igrave;m&quot; để c&oacute; thể
				t&igrave;m kiếm triệu chứng bạn gặp phải , v&agrave; Click trực tiếp
				v&agrave;o c&aacute;c triệu chứng trong &ocirc; gợi &yacute; để
				th&ecirc;m triệu chứng&nbsp;</p>

			<p>
				+ Click v&agrave;o item <span class="glyphicon glyphicon-plus"></span>
				để th&ecirc;m triệu chứng m&agrave; bạn gặp phải .
			</p>

			<p>
				+ Click v&agrave;o item <span class="glyphicon glyphicon-trash"></span>
				để hủy bỏ triệu chứng m&agrave; bạn nhập sai .
			</p>

			<p>
				+ Click v&agrave;o item&nbsp; <span class="glyphicon glyphicon-list"></span>
				để xem chi tiết bệnh m&agrave; bạn c&oacute; thể gặp phải .
			</p>

		</div>
	</div>
	<%@ include file="_footer.jsp"%>
</body>
</html>