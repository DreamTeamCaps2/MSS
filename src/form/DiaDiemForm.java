package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.DiaDiem;
import model.bean.ThongBao;

public class DiaDiemForm extends ActionForm {

	private ArrayList<DiaDiem> listDiaDiem;
	
	private String loaiDiaDiem;
	private String search;
	private String submit, maDiaDiem;
	
	public String getMaDiaDiem() {
		return maDiaDiem;
	}

	public void setMaDiaDiem(String maDiaDiem) {
		this.maDiaDiem = maDiaDiem;
	}

	public String getLoaiDiaDiem() {
		return loaiDiaDiem;
	}

	public void setLoaiDiaDiem(String loaiDiaDiem) {
		this.loaiDiaDiem = loaiDiaDiem;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public ArrayList<DiaDiem> getListDiaDiem() {
		return listDiaDiem;
	}

	public void setListDiaDiem(ArrayList<DiaDiem> listDiaDiem) {
		this.listDiaDiem = listDiaDiem;
	}

	

	
}
