
<script type="text/javascript">
var tim= '<bean:write name="diaDiemForm" property="search" />'
	tim = decodeURIComponent(escape(tim));
//tim = encodeURIComponent(tim);
var mode='<bean:write name="diaDiemForm" property="loaiDiaDiem" />'
var pra= tim +","+ mode;
	 var xhReq = new XMLHttpRequest();
	xhReq.open("POST", "JSON.jsp?tim="+tim+"&mode="+mode, false);

</script>

