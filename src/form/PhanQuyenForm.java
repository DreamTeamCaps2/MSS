package form;

import org.apache.struts.action.ActionForm;

public class PhanQuyenForm extends ActionForm{
	
	private int benh;
	private int thuoc;
	private int trieuChung;
	private int phanQuyen;
	private int dangBai;
	
	int maTaiKhoan;
	String submit;
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
	public int getMaTaiKhoan() {
		return maTaiKhoan;
	}
	public void setMaTaiKhoan(int maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	
	

}
