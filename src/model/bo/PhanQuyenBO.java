package model.bo;

import java.util.ArrayList;

import model.dao.PhanQuyenDAO;

public class PhanQuyenBO {

	PhanQuyenDAO phanQuyenDAO = new PhanQuyenDAO();

	public ArrayList<Integer> getListQuyen(int maNV) {
		return phanQuyenDAO.getListQuyen(maNV);
	}

	public void themQuyen(int maTaiKhoan, int maQuyen) {
		phanQuyenDAO.themQuyen(maTaiKhoan, maQuyen);
	}

	public void xoaQuyen(int maTaiKhoan) {
		phanQuyenDAO.xoaQuyen(maTaiKhoan);
	}

}
