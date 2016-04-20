package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.Benh;

public class ThuocBenhForm extends ActionForm{
	
	ArrayList<Benh> listBenhChon;
	ArrayList<Benh> listBenhTim;
	int maBenhChon;
	int maBenhXoa;
	
	String timBenh;
	String submit;
	public ArrayList<Benh> getListBenhChon() {
		return listBenhChon;
	}
	public void setListBenhChon(ArrayList<Benh> listBenhChon) {
		this.listBenhChon = listBenhChon;
	}
	public ArrayList<Benh> getListBenhTim() {
		return listBenhTim;
	}
	public void setListBenhTim(ArrayList<Benh> listBenhTim) {
		this.listBenhTim = listBenhTim;
	}
	public int getMaBenhChon() {
		return maBenhChon;
	}
	public void setMaBenhChon(int maBenhChon) {
		this.maBenhChon = maBenhChon;
	}
	public int getMaBenhXoa() {
		return maBenhXoa;
	}
	public void setMaBenhXoa(int maBenhXoa) {
		this.maBenhXoa = maBenhXoa;
	}
	public String getTimBenh() {
		return timBenh;
	}
	public void setTimBenh(String timBenh) {
		this.timBenh = timBenh;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	
	
	
	

}
