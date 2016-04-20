package model.bo;

import java.util.ArrayList;

import model.bean.Benh;
import model.bean.LoaiThuoc;
import model.bean.NhomThuoc;
import model.bean.Thuoc;
import model.dao.ThuocDAO;

public class ThuocBO {
	ThuocDAO thuocDAO = new ThuocDAO();

	public ArrayList<Thuoc> getListThuocTimKiem(String timKiem) {
		return thuocDAO.getListThuocTimKiem(timKiem);
	}

	public ArrayList<LoaiThuoc> getListLoaiThuoc() {
		return thuocDAO.getListLoaiThuoc();
	}
	
	public ArrayList<NhomThuoc> getListNhomThuoc(int maLoaiThuoc) {
		return thuocDAO.getListNhomThuoc(maLoaiThuoc);
	}

	public ArrayList<Thuoc> getListThuoc() {
		return thuocDAO.getListThuoc();
	}
	
	public ArrayList<Thuoc> getListThuoc(int maBenh) {
		return thuocDAO.getListThuoc(maBenh);
	}

	public ArrayList<Thuoc> getListThuoc(String timThuoc, int maLoaiThuoc, int maNhomThuoc) {
		return thuocDAO.getListThuoc(timThuoc, maLoaiThuoc, maNhomThuoc);
	}

	public Thuoc getThuoc(int maThuoc) {
		return thuocDAO.getThuoc(maThuoc);
	}

	public void themThuoc(String tenThuoc, String congThuc, String tenKhoaHoc, String dieuChe, String tinhChat,
			String tacDung, String chiDinh, String baoQuan, String thanTrong, String DDH, int maNhomThuoc,
			int trangThai) {
		thuocDAO.themThuoc(tenThuoc, congThuc, tenKhoaHoc, dieuChe, tinhChat, tacDung, chiDinh, baoQuan, thanTrong, DDH,
				maNhomThuoc, trangThai);
	}

	public void themThuocBenh(String tenThuoc, ArrayList<Benh> listBenh) {
		thuocDAO.themThuocBenh(tenThuoc, listBenh);
	}

	public void suaThuoc(int maThuoc, String tenThuoc, String congThuc, String tenKhoaHoc, String dieuChe,
			String tinhChat, String tacDung, String chiDinh, String baoQuan, String thanTrong, String DDH,
			int maNhomThuoc) {
		thuocDAO.suaThuoc(maThuoc, tenThuoc, congThuc, tenKhoaHoc, dieuChe, tinhChat, tacDung, chiDinh, baoQuan,
				thanTrong, DDH, maNhomThuoc);
	}

	public void xoaThuoc(int maThuoc) {
		thuocDAO.xoaThuoc(maThuoc);
	}
	
	public void xoaThuocBenh(int maBenh) {
		thuocDAO.xoaThuocBenh(maBenh);
	}

	public ArrayList<Thuoc> getThuocCuaHang(String tenDangNhap) {
		return thuocDAO.getThuocCuaHang(tenDangNhap);
	}

	public ArrayList<Thuoc> getListThuocLienQuanBenh(int ma) {
		return thuocDAO.getListThuocLienQuanBenh(ma);
	}
	
	public ArrayList<Thuoc> getListThuocNhomThuoc(int maNhomThuoc) {
		return thuocDAO.getListThuocNhomThuoc(maNhomThuoc);
	}

	public ArrayList<Thuoc> getListThuocLoaiThuoc(int maLoaiThuoc) {
		return thuocDAO.getListThuocLoaiThuoc(maLoaiThuoc);
	}

	public void capNhatLuotXem(int ma, int luotXem) {
		thuocDAO.capNhatLuotXem(ma,luotXem);
	}

	public ArrayList<Thuoc> getListThuocXemNhieu() {
		return thuocDAO.getListThuocXemNhieu();
	}
	
	public int ktTenThuoc(String tenThuoc) {
		return thuocDAO.ktTenThuoc(tenThuoc);
	}

	public int ktTenThuoc(String tenThuoc, int maThuoc) {
		return thuocDAO.ktTenThuoc(tenThuoc, maThuoc);
	}
}
