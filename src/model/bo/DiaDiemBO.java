package model.bo;

import java.util.ArrayList;

import model.bean.DiaDiem;
import model.dao.DiaDiemDAO;

public class DiaDiemBO {
	DiaDiemDAO diaDiemDAO = new DiaDiemDAO();

	public ArrayList<DiaDiem> getListDiaDiem() {
		return diaDiemDAO.getListDiaDiem();
	}
}
