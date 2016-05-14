package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.Thuoc;

public class DanhSachGiaForm extends ActionForm {

	private ArrayList<Thuoc> listGiaThuoc;
	private int maThuoc, maNhomThuoc, maLoaiThuoc;
	private String loaiDiaDiem, khoangCach, tenNhomThuoc, tenLoaiThuoc, hinhAnh, tenThuoc;

	public String getTenThuoc() {
		return tenThuoc;
	}

	public void setTenThuoc(String tenThuoc) {
		this.tenThuoc = tenThuoc;
	}

	public void setKhoangCach(String khoangCach) {
		this.khoangCach = khoangCach;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public int getMaNhomThuoc() {
		return maNhomThuoc;
	}

	public void setMaNhomThuoc(int maNhomThuoc) {
		this.maNhomThuoc = maNhomThuoc;
	}

	public int getMaLoaiThuoc() {
		return maLoaiThuoc;
	}

	public void setMaLoaiThuoc(int maLoaiThuoc) {
		this.maLoaiThuoc = maLoaiThuoc;
	}

	public String getTenNhomThuoc() {
		return tenNhomThuoc;
	}

	public void setTenNhomThuoc(String tenNhomThuoc) {
		this.tenNhomThuoc = tenNhomThuoc;
	}

	public String getTenLoaiThuoc() {
		return tenLoaiThuoc;
	}

	public void setTenLoaiThuoc(String tenLoaiThuoc) {
		this.tenLoaiThuoc = tenLoaiThuoc;
	}

	public String getKhoangCach() {
		return khoangCach;
	}

	public void setKc(String kc) {
		this.khoangCach = kc;
	}

	public String getLoaiDiaDiem() {
		return loaiDiaDiem;
	}

	public void setLoaiDiaDiem(String loaiDiaDiem) {
		this.loaiDiaDiem = loaiDiaDiem;
	}

	public ArrayList<Thuoc> getListGiaThuoc() {
		return listGiaThuoc;
	}

	public void setListGiaThuoc(ArrayList<Thuoc> listGiaThuoc) {
		this.listGiaThuoc = listGiaThuoc;
	}

	public int getMaThuoc() {
		return maThuoc;
	}

	public void setMaThuoc(int maThuoc) {
		this.maThuoc = maThuoc;
	}

}
