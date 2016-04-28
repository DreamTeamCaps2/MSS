package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.Thuoc;

public class DanhSachGiaForm extends ActionForm {

	private ArrayList<Thuoc> listGiaThuoc;
	private int maThuoc, msv;
	private String loaiDiaDiem, kc;

	public String getKc() {
		return kc;
	}

	public void setKc(String kc) {
		this.kc = kc;
	}

	public String getLoaiDiaDiem() {
		return loaiDiaDiem;
	}

	public void setLoaiDiaDiem(String loaiDiaDiem) {
		this.loaiDiaDiem = loaiDiaDiem;
	}

	public ArrayList<Thuoc> getListGiaThuoc() {
		return listGiaThuoc;
	}

	public void setListGiaThuoc(ArrayList<Thuoc> listGiaThuoc) {
		this.listGiaThuoc = listGiaThuoc;
	}

	public int getMaThuoc() {
		return maThuoc;
	}

	public void setMaThuoc(int maThuoc) {
		this.maThuoc = maThuoc;
	}

	public int getMsv() {
		return msv;
	}

	public void setMsv(int msv) {
		this.msv = msv;
	}

}
