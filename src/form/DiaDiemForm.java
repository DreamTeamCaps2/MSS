package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.DiaDiem;
import model.bean.ThongBao;

public class DiaDiemForm extends ActionForm {

	private ArrayList<DiaDiem> listDiaDiem;
	private int soLuong;
	private String longi = "106.689422";
	private String lati = "10.765974";

	public ArrayList<DiaDiem> getListDiaDiem() {
		return listDiaDiem;
	}

	public void setListDiaDiem(ArrayList<DiaDiem> listDiaDiem) {
		this.listDiaDiem = listDiaDiem;
	}

	public String getLongi() {
		return longi;
	}

	public void setLongi(String longi) {
		this.longi = longi;
	}

	public String getLati() {
		return lati;
	}

	public void setLati(String lati) {
		this.lati = lati;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

}
