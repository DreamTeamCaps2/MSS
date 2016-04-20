package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.Benh;
import model.bean.Thuoc;

public class TimKiemForm extends ActionForm {
	private String timKiem;
	private ArrayList<Benh> listBenh;
	private ArrayList<Thuoc> listThuoc;
	private int maLoaiTimKiem,soKetQua;
	
	
	public String getTimKiem() {
		return timKiem;
	}
	public void setTimKiem(String timKiem) {
		this.timKiem = timKiem;
	}
	public ArrayList<Benh> getListBenh() {
		return listBenh;
	}
	public void setListBenh(ArrayList<Benh> listBenh) {
		this.listBenh = listBenh;
	}
	public ArrayList<Thuoc> getListThuoc() {
		return listThuoc;
	}
	public void setListThuoc(ArrayList<Thuoc> listThuoc) {
		this.listThuoc = listThuoc;
	}
	public int getMaLoaiTimKiem() {
		return maLoaiTimKiem;
	}
	public void setMaLoaiTimKiem(int maLoaiTimKiem) {
		this.maLoaiTimKiem = maLoaiTimKiem;
	}
	public int getSoKetQua() {
		return soKetQua;
	}
	public void setSoKetQua(int soKetQua) {
		this.soKetQua = soKetQua;
	}
	
}
