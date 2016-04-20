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
}
