package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.Benh;
import model.bean.Thuoc;

public class BenhThuocForm extends ActionForm{
	
	ArrayList<Thuoc> listThuocChon;
	ArrayList<Thuoc> listThuocTim;
	int maThuocChon;
	int maThuocXoa;
	
	String timThuoc;
	String submit;
	public ArrayList<Thuoc> getListThuocChon() {
		return listThuocChon;
	}
	public void setListThuocChon(ArrayList<Thuoc> listThuocChon) {
		this.listThuocChon = listThuocChon;
	}
	public ArrayList<Thuoc> getListThuocTim() {
		return listThuocTim;
	}
	public void setListThuocTim(ArrayList<Thuoc> listThuocTim) {
		this.listThuocTim = listThuocTim;
	}
	public int getMaThuocChon() {
		return maThuocChon;
	}
	public void setMaThuocChon(int maThuocChon) {
		this.maThuocChon = maThuocChon;
	}
	public int getMaThuocXoa() {
		return maThuocXoa;
	}
	public void setMaThuocXoa(int maThuocXoa) {
		this.maThuocXoa = maThuocXoa;
	}
	public String getTimThuoc() {
		return timThuoc;
	}
	public void setTimThuoc(String timThuoc) {
		this.timThuoc = timThuoc;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	
	
	
	

}
