package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.TaiKhoan;

public class DangNhapForm extends ActionForm {

	private String tenDangNhap, matKhau, submit, thongBao;
	private ArrayList<TaiKhoan> listND;
	


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
}
