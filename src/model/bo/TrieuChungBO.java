package model.bo;

import java.util.ArrayList;

import model.bean.TrieuChung;
import model.dao.TrieuChungDAO;

public class TrieuChungBO {

	TrieuChungDAO trieuChungDAO = new TrieuChungDAO();

	public ArrayList<TrieuChung> getListTrieuChung(String timTrieuChung) {
		return trieuChungDAO.getListTrieuChung(timTrieuChung);
	}

	public ArrayList<TrieuChung> getListTrieuChung(int maBenh) {
		return trieuChungDAO.getListTrieuChung(maBenh);
	}

	public TrieuChung getTrieuChung(int maTrieuChung) {
		return trieuChungDAO.getTrieuChung(maTrieuChung);
	}

	public void xoaTrieuChungBenh(int maBenh) {
		trieuChungDAO.xoaTrieuChungBenh(maBenh);
	}
	
	//DUC
	public ArrayList<TrieuChung> getListTrieuChung() {
		return trieuChungDAO.getListTrieuChung();
	}

	public void themTrieuChung(String tenTrieuChung) {
		trieuChungDAO.themTrieuChung(tenTrieuChung);
	}

	public void xoaTrieuChung(String maTrieuChung) {
		trieuChungDAO.xoaTrieuChung(maTrieuChung);
	}

	public boolean checkExist(String tenTrieuChung) {
		return trieuChungDAO.checkExist(tenTrieuChung);
	}	
}
