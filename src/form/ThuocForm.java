package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import model.bean.Benh;
import model.bean.LoaiThuoc;
import model.bean.LuotXem;
import model.bean.NhomThuoc;
import model.bean.Thuoc;

public class ThuocForm extends ActionForm {

	private ArrayList<NhomThuoc> listNhomThuoc;
	private ArrayList<LoaiThuoc> listLoaiThuoc;
	private ArrayList<Thuoc> listThuoc;
	private ArrayList<Thuoc> listThuocCuaHang;

	private int maNhomThuoc;
	private int maLoaiThuoc;
	private int ma, maThuoc;

	private String tenNhomThuoc;
	private String tenLoaiThuoc;
	private String tenThuoc;
	private String giaThuoc;

	private String congThuc;
	private String tenKhoaHoc;
	private String dieuChe;
	private String tinhChat;
	private String tacDung;
	private String chiDinh;
	private String baoQuan;
	private String thanTrong;
	private String DDH;

	private String timThuoc;
	private String submit;
	private String hinhAnh;

	private ArrayList<Benh> listBenh;
	private String change;
	
	private int kt,luotXem;
	private static ArrayList<LuotXem> listLuotXem =  new ArrayList<LuotXem>();
	
	private FormFile file;
	
	public static ArrayList<LuotXem> getListLuotXem() {
		return listLuotXem;
	}

	public static void setListLuotXem(ArrayList<LuotXem> listLuotXem1) {
		ThuocForm.listLuotXem = listLuotXem1;
	}

	public int getLuotXem() {
		return luotXem;
	}

	public void setLuotXem(int luotXem) {
		this.luotXem = luotXem;
	}

	

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String getTimThuoc() {
		return timThuoc;
	}

	public void setTimThuoc(String timThuoc) {
		this.timThuoc = timThuoc;
	}

	public ArrayList<NhomThuoc> getListNhomThuoc() {
		return listNhomThuoc;
	}

	public void setListNhomThuoc(ArrayList<NhomThuoc> listNhomThuoc) {
		this.listNhomThuoc = listNhomThuoc;
	}

	public ArrayList<LoaiThuoc> getListLoaiThuoc() {
		return listLoaiThuoc;
	}

	public void setListLoaiThuoc(ArrayList<LoaiThuoc> listLoaiThuoc) {
		this.listLoaiThuoc = listLoaiThuoc;
	}

	public ArrayList<Thuoc> getListThuoc() {
		return listThuoc;
	}

	public void setListThuoc(ArrayList<Thuoc> listThuoc) {
		this.listThuoc = listThuoc;
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

	public int getMaThuoc() {
		return maThuoc;
	}

	public void setMaThuoc(int maThuoc) {
		this.maThuoc = maThuoc;
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

	public String getTenThuoc() {
		return tenThuoc;
	}

	public void setTenThuoc(String tenThuoc) {
		this.tenThuoc = tenThuoc;
	}

	public String getCongThuc() {
		return congThuc;
	}

	public void setCongThuc(String congThuc) {
		this.congThuc = congThuc;
	}

	public String getTenKhoaHoc() {
		return tenKhoaHoc;
	}

	public void setTenKhoaHoc(String tenKhoaHoc) {
		this.tenKhoaHoc = tenKhoaHoc;
	}

	public String getDieuChe() {
		return dieuChe;
	}

	public void setDieuChe(String dieuChe) {
		this.dieuChe = dieuChe;
	}

	public String getTinhChat() {
		return tinhChat;
	}

	public void setTinhChat(String tinhChat) {
		this.tinhChat = tinhChat;
	}

	public String getTacDung() {
		return tacDung;
	}

	public void setTacDung(String tacDung) {
		this.tacDung = tacDung;
	}

	public String getChiDinh() {
		return chiDinh;
	}

	public void setChiDinh(String chiDinh) {
		this.chiDinh = chiDinh;
	}

	public String getBaoQuan() {
		return baoQuan;
	}

	public void setBaoQuan(String baoQuan) {
		this.baoQuan = baoQuan;
	}

	public String getThanTrong() {
		return thanTrong;
	}

	public void setThanTrong(String thanTrong) {
		this.thanTrong = thanTrong;
	}

	public String getDDH() {
		return DDH;
	}

	public void setDDH(String dDH) {
		DDH = dDH;
	}

	public String getGiaThuoc() {
		return giaThuoc;
	}

	public void setGiaThuoc(String giaThuoc) {
		this.giaThuoc = giaThuoc;
	}

	public int getMa() {
		return ma;
	}

	public void setMa(int ma) {
		this.ma = ma;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public ArrayList<Benh> getListBenh() {
		return listBenh;
	}

	public void setListBenh(ArrayList<Benh> listBenh) {
		this.listBenh = listBenh;
	}

	public String getChange() {
		return change;
	}

	public void setChange(String change) {
		this.change = change;
	}

	public int getKt() {
		return kt;
	}

	public void setKt(int kt) {
		this.kt = kt;
	}

	public ArrayList<Thuoc> getListThuocCuaHang() {
		return listThuocCuaHang;
	}

	public void setListThuocCuaHang(ArrayList<Thuoc> listThuocCuaHang) {
		this.listThuocCuaHang = listThuocCuaHang;
	}

	public FormFile getFile() {
		return file;
	}

	public void setFile(FormFile file) {
		this.file = file;
	}

}
