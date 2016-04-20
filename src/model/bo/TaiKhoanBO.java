package model.bo;

import java.util.ArrayList;

import model.bean.LoaiTaiKhoan;
import model.bean.Quyen;
import model.bean.TaiKhoan;
import model.dao.TaiKhoanDAO;

public class TaiKhoanBO {

	TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();

	public void themTaiKhoan(String tenDangNhap, String matKhau, String diaChi, String sDT, String maLoai) {
		taiKhoanDAO.themTaiKhoan(tenDangNhap, matKhau, diaChi, sDT, maLoai);
	}

	public TaiKhoan getThongTinTaiKhoan(String tenDangNhap1, String maLoai) {
		return taiKhoanDAO.getThongTinTaiKhoan(tenDangNhap1, maLoai);
	}

	public void suaTaiKhoan(String tenDangNhap, String matKhau, String diaChi, String sDT, String maLoai) {
		taiKhoanDAO.suaTaiKhoan(tenDangNhap, matKhau, diaChi, sDT, maLoai);
	}

	public void suaTaiKhoan(String maTK, String tenDangNhap, String matKhau, String diaChi, String sDT, String maLoai,
			String cmnd, String email, String tenNhaThuoc, String tenPhongKham, String moTa, String thoiGian) {
		taiKhoanDAO.suaTaiKhoan(maTK, tenDangNhap, matKhau, diaChi, sDT, maLoai, cmnd, email, tenNhaThuoc, tenPhongKham,
				moTa, thoiGian);
	}

	public void themTaiKhoan(String tenDangNhap, String matKhau, String diaChi, String sDT, String loaiTK, String email,
			String cmnd, String tenNhaThuoc, String tenPhongKham, String moTa, String thoiGian) {
		taiKhoanDAO.themTaiKhoan(tenDangNhap, matKhau, diaChi, sDT, loaiTK, email, cmnd, tenNhaThuoc, tenPhongKham,
				moTa, thoiGian);
	}

	public ArrayList<TaiKhoan> getListNguoiDung() {
		return taiKhoanDAO.getListNguoiDung();
	}

	public ArrayList<LoaiTaiKhoan> getListLoaiTaiKhoan() {
		return taiKhoanDAO.getListLoaiTaiKhoan();
	}

	public ArrayList<TaiKhoan> getListTaiKhoan() {
		return taiKhoanDAO.getListTaiKhoan();
	}

	public ArrayList<TaiKhoan> getListTaiKhoan(String timTaiKhoan, int maLoaiTaiKhoan, int maQuyen) {
		return taiKhoanDAO.getListTaiKhoan(timTaiKhoan, maLoaiTaiKhoan, maQuyen);
	}

	public ArrayList<Quyen> getListQuyen() {
		return taiKhoanDAO.getListQuyen();
	}

}