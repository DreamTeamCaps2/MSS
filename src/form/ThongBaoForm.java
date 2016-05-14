package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.BaiViet;
import model.bean.Benh;
import model.bean.LoaiBenh;
import model.bean.LoaiThuoc;
import model.bean.NhomThuoc;
import model.bean.TaiKhoan;
import model.bean.ThongBao;
import model.bean.Thuoc;

public class ThongBaoForm extends ActionForm {
	
	private ArrayList<ThongBao> listThongBao = new ArrayList<ThongBao>();
	private int soLuong,soLuongNhomThuoc,soLuongLoaiThuoc, soLuongLoaiBenh ;
	private int ma;
	private String timKiem;
	private ArrayList<NhomThuoc> listNhomThuoc;
	private ArrayList<LoaiBenh> listLoaiBenh;
	private ArrayList<LoaiThuoc> listLoaiThuoc;
	private ArrayList<TaiKhoan> listND;
	private ArrayList<BaiViet> listBaiViet, listBaiVietXemNhieu, listBaiVietSlider;
	private ArrayList<Benh> listBenhXemNhieu;
	private ArrayList<Thuoc> listThuocXemNhieu;
	
	private int maGopY,xoa,soQuyen;
	private int loaiGopY,tinhTrang,tinhTrangUpdate ;

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

	public int getMaGopY() {
		return maGopY;
	}

	public void setMaGopY(int maGopY) {
		this.maGopY = maGopY;
	}

	public int getXoa() {
		return xoa;
	}

	public void setXoa(int xoa) {
		this.xoa = xoa;
	}

	public int getSoQuyen() {
		return soQuyen;
	}

	public void setSoQuyen(int soQuyen) {
		this.soQuyen = soQuyen;
	}

	public int getLoaiGopY() {
		return loaiGopY;
	}

	public void setLoaiGopY(int loaiGopY) {
		this.loaiGopY = loaiGopY;
	}

	public int getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public int getTinhTrangUpdate() {
		return tinhTrangUpdate;
	}

	public void setTinhTrangUpdate(int tinhTrangUpdate) {
		this.tinhTrangUpdate = tinhTrangUpdate;
	}

	public ArrayList<Benh> getListBenhXemNhieu() {
		return listBenhXemNhieu;
	}

	public void setListBenhXemNhieu(ArrayList<Benh> listBenhXemNhieu) {
		this.listBenhXemNhieu = listBenhXemNhieu;
	}

	public ArrayList<Thuoc> getListThuocXemNhieu() {
		return listThuocXemNhieu;
	}

	public void setListThuocXemNhieu(ArrayList<Thuoc> listThuocXemNhieu) {
		this.listThuocXemNhieu = listThuocXemNhieu;
	}

	public ArrayList<BaiViet> getListBaiVietXemNhieu() {
		return listBaiVietXemNhieu;
	}

	public void setListBaiVietXemNhieu(ArrayList<BaiViet> listBaiVietXemNhieu) {
		this.listBaiVietXemNhieu = listBaiVietXemNhieu;
	}

	public ArrayList<BaiViet> getListBaiVietSlider() {
		return listBaiVietSlider;
	}

	public void setListBaiVietSlider(ArrayList<BaiViet> listBaiVietSlider) {
		this.listBaiVietSlider = listBaiVietSlider;
	}
	
}
