package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.TrieuChung;

public class TrieuChungForm extends ActionForm {

	private int maTrieuChung;
	private String tenTrieuChung;
	private ArrayList<TrieuChung> listTrieuChung;

	private String timTrieuChung;

	public String getTimTrieuChung() {
		return timTrieuChung;
	}

	public void setTimTrieuChung(String timTrieuChung) {
		this.timTrieuChung = timTrieuChung;
	}

	public ArrayList<TrieuChung> getListTrieuChung() {
		return listTrieuChung;
	}

	public void setListTrieuChung(ArrayList<TrieuChung> listTrieuChung) {
		this.listTrieuChung = listTrieuChung;
	}

	public int getMaTrieuChung() {
		return maTrieuChung;
	}

	public void setMaTrieuChung(int maTrieuChung) {
		this.maTrieuChung = maTrieuChung;
	}

	public String getTenTrieuChung() {
		return tenTrieuChung;
	}

	public void setTenTrieuChung(String tenTrieuChung) {
		this.tenTrieuChung = tenTrieuChung;
	}

}
