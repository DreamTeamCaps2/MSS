package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.TaiKhoan;

public class DangNhapForm extends ActionForm {

	private String tenDangNhap, matKhau, submit, thongBao;
	private ArrayList<TaiKhoan> listND;
	
	private int benh;
	private int thuoc;
	private int trieuChung;
	private int phanQuyen;
	private int dangBai;


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

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String getThongBao() {
		return thongBao;
	}

	public void setThongBao(String thongBao) {
		this.thongBao = thongBao;
	}

	public ArrayList<TaiKhoan> getListND() {
		return listND;
	}

	public void setListND(ArrayList<TaiKhoan> listND) {
		this.listND = listND;
	}

	public int getBenh() {
		return benh;
	}

	public void setBenh(int benh) {
		this.benh = benh;
	}

	public int getThuoc() {
		return thuoc;
	}

	public void setThuoc(int thuoc) {
		this.thuoc = thuoc;
	}

	public int getTrieuChung() {
		return trieuChung;
	}

	public void setTrieuChung(int trieuChung) {
		this.trieuChung = trieuChung;
	}

	public int getPhanQuyen() {
		return phanQuyen;
	}

	public void setPhanQuyen(int phanQuyen) {
		this.phanQuyen = phanQuyen;
	}

	public int getDangBai() {
		return dangBai;
	}

	public void setDangBai(int dangBai) {
		this.dangBai = dangBai;
	}
	
}
