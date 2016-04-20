package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.LoaiBenh;

public class LoaiBenhForm extends ActionForm{
	
	int maLoaiBenh;
	String tenLoaiBenh;
	ArrayList<LoaiBenh> listLoaiBenh;
	String submit;
	public int getMaLoaiBenh() {
		return maLoaiBenh;
	}
	public void setMaLoaiBenh(int maLoaiBenh) {
		this.maLoaiBenh = maLoaiBenh;
	}
	public String getTenLoaiBenh() {
		return tenLoaiBenh;
	}
	public void setTenLoaiBenh(String tenLoaiBenh) {
		this.tenLoaiBenh = tenLoaiBenh;
	}
	public ArrayList<LoaiBenh> getListLoaiBenh() {
		return listLoaiBenh;
	}
	public void setListLoaiBenh(ArrayList<LoaiBenh> listLoaiBenh) {
		this.listLoaiBenh = listLoaiBenh;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	
	

}
