package model.bo;

import java.util.ArrayList;

import model.bean.LoaiBenh;
import model.bean.NhomThuoc;
import model.bean.ThongBao;
import model.dao.ThongBaoDAO;

public class ThongBaoBO {
	ThongBaoDAO thongBaoDAO = new ThongBaoDAO();

	//get list tohng bao co loai = 2
	public ArrayList<ThongBao> getListThongBao() {
		// TODO Auto-generated method stub
		return thongBaoDAO.getListThongBao();
	}

	public ArrayList<NhomThuoc> getListNhomThuoc() {
		// TODO Auto-generated method stub
		return thongBaoDAO.getListNhomThuoc();
	}

	public ArrayList<LoaiBenh> getListLoaiBenh() {
		// TODO Auto-generated method stub
		return thongBaoDAO.getListLoaiBenh();
	}

	public int soLuongNhomThuoc() {
		return thongBaoDAO.soLuongNhomThuoc();
	}
	
	public ArrayList<ThongBao> getListThongBaoGopY(String maTK, int loaiGopY, int tinhTrang) {
		// TODO Auto-generated method stub
		return thongBaoDAO.getListThongBaoGopY(maTK,loaiGopY,tinhTrang);
	}

	public void updateDaXem(int maGopY) {
		// TODO Auto-generated method stub
		thongBaoDAO.updateDaXem(maGopY);
		
	}

	public void updateChuaXem(int maGopY) {
		// TODO Auto-generated method stub
		thongBaoDAO.updateChuaXem(maGopY);
	}

	public void xoaGopY(int maGopY) {
		// TODO Auto-generated method stub
		thongBaoDAO.xoaGopY(maGopY);
	}

}
