package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.Benh;
import model.bean.TrieuChung;

public class BenhTrieuChungForm extends ActionForm{
	
	ArrayList<Benh> listBenh;
	ArrayList<TrieuChung> listTrieuChungChon;
	ArrayList<TrieuChung> listTrieuChungTim;
	String timTrieuChung;
	String submit;
	
	int maTrieuChungChon;
	int maTrieuChungXoa;
	
	
	
	
	
	
	
	
	public int getMaTrieuChungChon() {
		return maTrieuChungChon;
	}
	public void setMaTrieuChungChon(int maTrieuChungChon) {
		this.maTrieuChungChon = maTrieuChungChon;
	}
	public int getMaTrieuChungXoa() {
		return maTrieuChungXoa;
	}
	public void setMaTrieuChungXoa(int maTrieuChungXoa) {
		this.maTrieuChungXoa = maTrieuChungXoa;
	}
	public ArrayList<Benh> getListBenh() {
		return listBenh;
	}
	public void setListBenh(ArrayList<Benh> listBenh) {
		this.listBenh = listBenh;
	}
	public ArrayList<TrieuChung> getListTrieuChungChon() {
		return listTrieuChungChon;
	}
	public void setListTrieuChungChon(ArrayList<TrieuChung> listTrieuChungChon) {
		this.listTrieuChungChon = listTrieuChungChon;
	}
	public ArrayList<TrieuChung> getListTrieuChungTim() {
		return listTrieuChungTim;
	}
	public void setListTrieuChungTim(ArrayList<TrieuChung> listTrieuChungTim) {
		this.listTrieuChungTim = listTrieuChungTim;
	}
	public String getTimTrieuChung() {
		return timTrieuChung;
	}
	public void setTimTrieuChung(String timTrieuChung) {
		this.timTrieuChung = timTrieuChung;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	
	
	

}
