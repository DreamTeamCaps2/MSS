package model.bo;

import java.util.ArrayList;

import model.bean.Benh;
import model.bean.LoaiBenh;
import model.bean.TrieuChung;
import model.dao.BenhDAO;

public class BenhBO {
	BenhDAO benhDAO = new BenhDAO();

	public ArrayList<Benh> getListBenhLienQuan(String tenBenh) {
		return benhDAO.getListBenhLienQuan(tenBenh);
	}

	public ArrayList<Benh> getListBenhLienQuan(int maLoaiBenh) {
		return benhDAO.getListBenhLienQuan(maLoaiBenh);
	}

	public ArrayList<Benh> getListBenhTimKiem(String timKiem) {
		return benhDAO.getListBenhTimKiem(timKiem);
	}

	public ArrayList<Benh> getListBenhDanhSach(int maLoaiDanhSach) {
		return benhDAO.getListBenhDanhSach(maLoaiDanhSach);
	}

	public ArrayList<Benh> getListBenh() {
		return benhDAO.getListBenh();
	}

	public ArrayList<Benh> getListBenh(String timBenh, int maLoaiBenh) {
		return benhDAO.getListBenh(timBenh, maLoaiBenh);
	}

	public ArrayList<Benh> getListBenh(ArrayList<TrieuChung> listTrieuChung) {
		return benhDAO.getListBenh(listTrieuChung);
	}

	public ArrayList<LoaiBenh> getListLoaiBenh() {
		return benhDAO.getListLoaiBenh();
	}

	public void themBenh(String tenBenh, String nguyenNhan, String chanDoan, String bienChung, String dieuTri,
			String cheDoDinhDuong, int maLoaiBenh, int trangThai) {
		benhDAO.themBenh(tenBenh, nguyenNhan, chanDoan, bienChung, dieuTri, cheDoDinhDuong, maLoaiBenh, trangThai);
	}

	public void suaBenh(int maBenh, String tenBenh, String nguyenNhan, String chanDoan, String bienChung,
			String dieuTri, String cheDoDinhDuong, int maLoaiBenh) {
		benhDAO.suaBenh(maBenh, tenBenh, nguyenNhan, chanDoan, bienChung, dieuTri, cheDoDinhDuong, maLoaiBenh);
	}

	public Benh getBenh(int maBenh) {
		return benhDAO.getBenh(maBenh);
	}

	public void xoaBenh(int maBenh) {
		benhDAO.xoaBenh(maBenh);
	}

	public Benh getBenhAuto(int ma) {
		return benhDAO.getBenhAuto(ma);
	}

	public void themBenhThuoc(String tenBenh, int maThuoc) {
		benhDAO.themBenhThuoc(tenBenh, maThuoc);
	}

	public void themBenhTrieuChung(String tenBenh, int maTrieuChung) {
		benhDAO.themBenhTrieuChung(tenBenh, maTrieuChung);
	}

	public void capNhatLuotXem(int ma, int i) {
		benhDAO.capNhatLuotXem(ma, i);
	}

	public ArrayList<Benh> getListBenhXemNhieu() {
		return benhDAO.getListBenhXemNhieu();
	}

	public int ktTenBenh(String tenBenh) {
		return benhDAO.ktTenBenh(tenBenh);
	}

	public int ktTenBenh(String tenBenh, int maBenh) {
		return benhDAO.ktTenBenh(tenBenh, maBenh);
	}

	public void xoaThuocBenh(int maBenh) {
		benhDAO.xoaThuocBenh(maBenh);
	}

	public ArrayList<Benh> getListBenh(int maThuoc) {
		return benhDAO.getListBenh(maThuoc);
	}
}
