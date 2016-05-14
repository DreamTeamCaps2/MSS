package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import model.bean.Benh;
import model.bean.LoaiBenh;
import model.bean.LuotXem;
import model.bean.Thuoc;
import model.bean.TrieuChung;

public class BenhForm extends ActionForm {

	private String dinhNghia,chanDoan,nguyenNhan,dieuTri,hinhAnh,bienChung,cheDoDinhDuong;
	
	private String timBenh;
	private int ma, maBenh, maLoaiBenh, soLuongThuoc,soLuongBenh;
	private String tenBenh, tenLoaiBenh;
	private ArrayList<Benh> listBenh,listBenhXemNhieu;
	private ArrayList<Thuoc> listThuoc,listThuocXemNhieu;
	private ArrayList<LoaiBenh> listLoaiBenh;
	private String submit;
	
	private ArrayList<Thuoc> listThuocTim;
	private String timThuoc;
	private int maThuocChon,luotXem;
	
	private ArrayList<Thuoc> listThuocChon;
	private String chonThuoc;
	private int maThuocXoa;
	private int kt;
	private ArrayList<TrieuChung> listTrieuChung;
	
	private String changeThuoc;
	private String changeTrieuChung;
	
	private static ArrayList<LuotXem> listLuotXem = new ArrayList<LuotXem>();
	
	private FormFile file;
	
	public static ArrayList<LuotXem> getListLuotXem() {
		return listLuotXem;
	}

	public static void setListLuotXem(ArrayList<LuotXem> listLuotXem) {
		BenhForm.listLuotXem = listLuotXem;
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

	public int getLuotXem() {
		return luotXem;
	}

	public void setLuotXem(int luotXem) {
		this.luotXem = luotXem;
	}
	

	public int getSoLuongBenh() {
		return soLuongBenh;
	}

	public void setSoLuongBenh(int soLuongBenh) {
		this.soLuongBenh = soLuongBenh;
	}

	public String getDinhNghia() {
		return dinhNghia;
	}

	public void setDinhNghia(String dinhNghia) {
		this.dinhNghia = dinhNghia;
	}

	public String getChanDoan() {
		return chanDoan;
	}

	public void setChanDoan(String chanDoan) {
		this.chanDoan = chanDoan;
	}

	public String getNguyenNhan() {
		return nguyenNhan;
	}

	public void setNguyenNhan(String nguyenNhan) {
		this.nguyenNhan = nguyenNhan;
	}

	public String getDieuTri() {
		return dieuTri;
	}

	public void setDieuTri(String dieuTri) {
		this.dieuTri = dieuTri;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public String getBienChung() {
		return bienChung;
	}

	public void setBienChung(String bienChung) {
		this.bienChung = bienChung;
	}

	public String getCheDoDinhDuong() {
		return cheDoDinhDuong;
	}

	public void setCheDoDinhDuong(String cheDoDinhDuong) {
		this.cheDoDinhDuong = cheDoDinhDuong;
	}

	public ArrayList<Benh> getListBenh() {
		return listBenh;
	}

	public void setListBenh(ArrayList<Benh> listBenh) {
		this.listBenh = listBenh;
	}

	public ArrayList<Thuoc> getListThuoc() {
		return listThuoc;
	}

	public void setListThuoc(ArrayList<Thuoc> listThuoc) {
		this.listThuoc = listThuoc;
	}

	public String getTenBenh() {
		return tenBenh;
	}

	public void setTenBenh(String tenBenh) {
		this.tenBenh = tenBenh;
	}

	public int getMa() {
		return ma;
	}

	public void setMa(int ma) {
		this.ma = ma;
	}

	public int getMaBenh() {
		return maBenh;
	}

	public void setMaBenh(int maBenh) {
		this.maBenh = maBenh;
	}

	public ArrayList<LoaiBenh> getListLoaiBenh() {
		return listLoaiBenh;
	}

	public void setListLoaiBenh(ArrayList<LoaiBenh> listLoaiBenh) {
		this.listLoaiBenh = listLoaiBenh;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public int getMaLoaiBenh() {
		return maLoaiBenh;
	}

	public void setMaLoaiBenh(int maLoaiBenh) {
		this.maLoaiBenh = maLoaiBenh;
	}

	public String getTimBenh() {
		return timBenh;
	}

	public void setTimBenh(String timBenh) {
		this.timBenh = timBenh;
	}

	public int getSoLuongThuoc() {
		return soLuongThuoc;
	}

	public void setSoLuongThuoc(int soLuongThuoc) {
		this.soLuongThuoc = soLuongThuoc;
	}

	public ArrayList<Thuoc> getListThuocTim() {
		return listThuocTim;
	}

	public void setListThuocTim(ArrayList<Thuoc> listThuocTim) {
		this.listThuocTim = listThuocTim;
	}

	public String getTimThuoc() {
		return timThuoc;
	}

	public void setTimThuoc(String timThuoc) {
		this.timThuoc = timThuoc;
	}

	public int getMaThuocChon() {
		return maThuocChon;
	}

	public void setMaThuocChon(int maThuocChon) {
		this.maThuocChon = maThuocChon;
	}

	public ArrayList<Thuoc> getListThuocChon() {
		return listThuocChon;
	}

	public void setListThuocChon(ArrayList<Thuoc> listThuocChon) {
		this.listThuocChon = listThuocChon;
	}

	public String getChonThuoc() {
		return chonThuoc;
	}

	public void setChonThuoc(String chonThuoc) {
		this.chonThuoc = chonThuoc;
	}

	public int getMaThuocXoa() {
		return maThuocXoa;
	}

	public void setMaThuocXoa(int maThuocXoa) {
		this.maThuocXoa = maThuocXoa;
	}

	public int getKt() {
		return kt;
	}

	public void setKt(int kt) {
		this.kt = kt;
	}

	public ArrayList<TrieuChung> getListTrieuChung() {
		return listTrieuChung;
	}

	public void setListTrieuChung(ArrayList<TrieuChung> listTrieuChung) {
		this.listTrieuChung = listTrieuChung;
	}

	public String getChangeThuoc() {
		return changeThuoc;
	}

	public void setChangeThuoc(String changeThuoc) {
		this.changeThuoc = changeThuoc;
	}

	public String getChangeTrieuChung() {
		return changeTrieuChung;
	}

	public void setChangeTrieuChung(String changeTrieuChung) {
		this.changeTrieuChung = changeTrieuChung;
	}

	public FormFile getFile() {
		return file;
	}

	public void setFile(FormFile file) {
		this.file = file;
	}

	public String getTenLoaiBenh() {
		return tenLoaiBenh;
	}

	public void setTenLoaiBenh(String tenLoaiBenh) {
		this.tenLoaiBenh = tenLoaiBenh;
	}
	
}
