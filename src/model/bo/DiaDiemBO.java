package model.bo;

import java.util.ArrayList;

import model.bean.DiaDiem;
import model.dao.DiaDiemDAO;

public class DiaDiemBO {
	DiaDiemDAO diaDiemDAO = new DiaDiemDAO();

	public ArrayList<DiaDiem> getListDiaDiem() {
		return diaDiemDAO.getListDiaDiem();
	}

	public ArrayList<DiaDiem> getListBenhVienSearch(String search) {
		// TODO Auto-generated method stub
		return diaDiemDAO.getListBenhVienSearch(search);
	}
	public ArrayList<DiaDiem> getListNhaThuocSearch(String search) {
		// TODO Auto-generated method stub
		return diaDiemDAO.getListNhaThuocSearch(search);
	}
	public ArrayList<DiaDiem> getListPhongKhamSearch(String search) {
		// TODO Auto-generated method stub
		return diaDiemDAO.getListPhongKhamSearch(search);
	}
	public ArrayList<DiaDiem> getListDiaDiemSearch(String search) {
		// TODO Auto-generated method stub
		return diaDiemDAO.getListDiaDiem(search);
	}
}
