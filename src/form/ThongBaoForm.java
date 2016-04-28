package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.BaiViet;
import model.bean.LoaiBenh;
import model.bean.LoaiThuoc;
import model.bean.NhomThuoc;
import model.bean.TaiKhoan;
import model.bean.ThongBao;

public class ThongBaoForm extends ActionForm {
	
	private ArrayList<ThongBao> listThongBao = new ArrayList<ThongBao>();
	private int soLuong,soLuongNhomThuoc,soLuongLoaiThuoc, soLuongLoaiBenh ;
	private int ma;
	private String timKiem;
	private ArrayList<NhomThuoc> listNhomThuoc;
	private ArrayList<LoaiBenh> listLoaiBenh;
	private ArrayList<LoaiThuoc> listLoaiThuoc;
	private ArrayList<TaiKhoan> listND;
	private ArrayList<BaiViet> listBaiViet;

	public int getSoLuongNhomThuoc() {
		return soLuongNhomThuoc;
	}

	public void setSoLuongNhomThuoc(int soLuongNhomThuoc) {
		this.soLuongNhomThuoc = soLuongNhomThuoc;
	}

	public int getSoLuongLoaiThuoc() {
		return soLuongLoaiThuoc;
	}

	public void setSoLuongLoaiThuoc(int soLuongLoaiThuoc) {
		this.soLuongLoaiThuoc = soLuongLoaiThuoc;
	}

	public ArrayList<LoaiThuoc> getListLoaiThuoc() {
		return listLoaiThuoc;
	}

	public void setListLoaiThuoc(ArrayList<LoaiThuoc> listLoaiThuoc) {
		this.listLoaiThuoc = listLoaiThuoc;
	}

	public ArrayList<LoaiBenh> getListLoaiBenh() {
		return listLoaiBenh;
	}

	public void setListLoaiBenh(ArrayList<LoaiBenh> listLoaiBenh) {
		this.listLoaiBenh = listLoaiBenh;
	}

	public ArrayList<NhomThuoc> getListNhomThuoc() {
		return listNhomThuoc;
	}

	public void setListNhomThuoc(ArrayList<NhomThuoc> listLoaiThuoc) {
		this.listNhomThuoc = listLoaiThuoc;
	}

	public String getTimKiem() {
		return timKiem;
	}

	public void setTimKiem(String timKiem) {
		this.timKiem = timKiem;
	}


	public int getMa() {
		return ma;
	}

	public void setMa(int ma) {
		this.ma = ma;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public ArrayList<ThongBao> getListThongBao() {
		return listThongBao;
	}

	public void setListThongBao(ArrayList<ThongBao> listThongBao) {
		this.listThongBao = listThongBao;
	}

	public ArrayList<TaiKhoan> getListND() {
		return listND;
	}

	public void setListND(ArrayList<TaiKhoan> listND) {
		this.listND = listND;
	}

	public ArrayList<BaiViet> getListBaiViet() {
		return listBaiViet;
	}

	public void setListBaiViet(ArrayList<BaiViet> listBaiViet) {
		this.listBaiViet = listBaiViet;
	}

	public int getSoLuongLoaiBenh() {
		return soLuongLoaiBenh;
	}

	public void setSoLuongLoaiBenh(int soLuongLoaiBenh) {
		this.soLuongLoaiBenh = soLuongLoaiBenh;
	}
}
