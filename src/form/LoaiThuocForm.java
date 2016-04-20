package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.LoaiThuoc;

public class LoaiThuocForm extends ActionForm{
	
	int maLoaiThuoc;
	String tenLoaiThuoc;
	ArrayList<LoaiThuoc> listLoaiThuoc;
	String submit;
	
	
	public int getMaLoaiThuoc() {
		return maLoaiThuoc;
	}
	public void setMaLoaiThuoc(int maLoaiThuoc) {
		this.maLoaiThuoc = maLoaiThuoc;
	}
	public String getTenLoaiThuoc() {
		return tenLoaiThuoc;
	}
	public void setTenLoaiThuoc(String tenLoaiThuoc) {
		this.tenLoaiThuoc = tenLoaiThuoc;
	}
	public ArrayList<LoaiThuoc> getListLoaiThuoc() {
		return listLoaiThuoc;
	}
	public void setListLoaiThuoc(ArrayList<LoaiThuoc> listLoaiThuoc) {
		this.listLoaiThuoc = listLoaiThuoc;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	
	

}
