<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<%@page import="javax.annotation.Resource"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="model.dao.DiaDiemDAO"%>
<%@page import="form.DiaDiemForm"%>
<%@page import="com.google.gson.Gson"%>
<%-- 
<%
	

	String query = request.getParameter("phrase");
	
	

	AutoCompleteDAO  autoCompleteDAO = new AutoCompleteDAO();
	AutoCompleteForm form = new AutoCompleteForm();
	form.setListBenh(autoCompleteDAO.getListBenh(query));  
	form.setListThuoc(autoCompleteDAO.getListThuoc(query)); 
	Gson gson = new Gson();
	String t = gson.toJson(form);
	out.print(t);
	


	
%> --%>


<%
	/* request.setCharacterEncoding("UTF-8");
	response.setContentType("text/text;charset=utf-8");
	String query = request.getParameter("phrase");
	byte[] isoBytes = query.getBytes("ISO-8859-1");
	String t= new String(isoBytes, "UTF-8"); */
	DiaDiemDAO diaDiem = new DiaDiemDAO();
	DiaDiemForm form = new DiaDiemForm();
	form.setJson(diaDiem.json());
	
	String t1 = form.getJson();
	out.print(t1);
%>
