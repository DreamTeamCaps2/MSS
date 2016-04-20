package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.LoaiTaiKhoan;
import model.bean.Quyen;
import model.bean.TaiKhoan;

public class TaiKhoanForm extends ActionForm{
	
	private String maTK, tenDangNhap, matKhau, matKhau2, SDT, diaChi, maLoai, submit, loaiTK;
	private String tenPhongKham, moTa, thoiGian;
	private String cmnd, email;
	private String tenNhaThuoc;
	private ArrayList<TaiKhoan> listND;
	
	//TUAN
	private int maQuyen, maLoaiTaiKhoan;
	private String timTaiKhoan;
	private ArrayList<TaiKhoan> listTaiKhoan;
	private ArrayList<Quyen> listQuyen;
	private ArrayList<LoaiTaiKhoan>	listLoaiTaiKhoan;
	
	public String getMaTK() {
		return maTK;
	}

	public void setMaTK(String maTK) {
		this.maTK = maTK;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String getTenPhongKham() {
		return tenPhongKham;
	}

	public void setTenPhongKham(String tenPhongKham) {
		this.tenPhongKham = tenPhongKham;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTenNhaThuoc() {
		return tenNhaThuoc;
	}

	public void setTenNhaThuoc(String tenNhaThuoc) {
		this.tenNhaThuoc = tenNhaThuoc;
	}

	public String getMatKhau2() {
		return matKhau2;
	}

	public void setMatKhau2(String matKhau2) {
		this.matKhau2 = matKhau2;
	}

	public String getLoaiTK() {
		return loaiTK;
	}

	public void setLoaiTK(String loaiTK) {
		this.loaiTK = loaiTK;
	}

	public ArrayList<TaiKhoan> getListND() {
		return listND;
	}

	public void setListND(ArrayList<TaiKhoan> listND) {
		this.listND = listND;
	}

	public String getTimTaiKhoan() {
		return timTaiKhoan;
	}

	public void setTimTaiKhoan(String timTaiKhoan) {
		this.timTaiKhoan = timTaiKhoan;
	}

	public ArrayList<TaiKhoan> getListTaiKhoan() {
		return listTaiKhoan;
	}

	public void setListTaiKhoan(ArrayList<TaiKhoan> listTaiKhoan) {
		this.listTaiKhoan = listTaiKhoan;
	}

	public ArrayList<Quyen> getListQuyen() {
		return listQuyen;
	}

	public void setListQuyen(ArrayList<Quyen> listQuyen) {
		this.listQuyen = listQuyen;
	}

	public ArrayList<LoaiTaiKhoan> getListLoaiTaiKhoan() {
		return listLoaiTaiKhoan;
	}

	public void setListLoaiTaiKhoan(ArrayList<LoaiTaiKhoan> listLoaiTaiKhoan) {
		this.listLoaiTaiKhoan = listLoaiTaiKhoan;
	}

	public int getMaQuyen() {
		return maQuyen;
	}

	public void setMaQuyen(int maQuyen) {
		this.maQuyen = maQuyen;
	}

	public int getMaLoaiTaiKhoan() {
		return maLoaiTaiKhoan;
	}

	public void setMaLoaiTaiKhoan(int maLoaiTaiKhoan) {
		this.maLoaiTaiKhoan = maLoaiTaiKhoan;
	}
	
}
