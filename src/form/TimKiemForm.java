package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.Benh;
import model.bean.Thuoc;

public class TimKiemForm extends ActionForm {
	private String timKiem;
	private ArrayList<Benh> listBenh;
	private ArrayList<Thuoc> listThuoc;
	private int maLoaiTimKiem, soKetQua;
	private boolean luotXem, abc, macDinh;

	public boolean isLuotXem() {
		return luotXem;
	}

	public void setLuotXem(boolean luotXem) {
		this.luotXem = luotXem;
	}

	public boolean isAbc() {
		return abc;
	}

	public void setAbc(boolean abc) {
		this.abc = abc;
	}

	public boolean isMacDinh() {
		return macDinh;
	}

	public void setMacDinh(boolean macDinh) {
		this.macDinh = macDinh;
	}

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
