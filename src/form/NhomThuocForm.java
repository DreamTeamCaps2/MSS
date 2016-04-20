package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.LoaiThuoc;
import model.bean.NhomThuoc;

public class NhomThuocForm extends ActionForm{
	private String tenNhomThuoc;
	private int maNhomThuoc,maLoaiThuoc;
	private int tenLoaiThuoc;
	private String submit;
	private ArrayList<LoaiThuoc> listLoaiThuoc;
	private ArrayList<NhomThuoc> listNhomThuoc;
	private String thongBao;
	
	public String getThongBao() {
		return thongBao;
	}
	public void setThongBao(String thongBao) {
		this.thongBao = thongBao;
	}
	public ArrayList<NhomThuoc> getListNhomThuoc() {
		return listNhomThuoc;
	}
	public void setListNhomThuoc(ArrayList<NhomThuoc> listNhomThuoc) {
		this.listNhomThuoc = listNhomThuoc;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public ArrayList<LoaiThuoc> getListLoaiThuoc() {
		return listLoaiThuoc;
	}
	public void setListLoaiThuoc(ArrayList<LoaiThuoc> listLoaiThuoc) {
		this.listLoaiThuoc = listLoaiThuoc;
	}
	public int getTenLoaiThuoc() {
		return tenLoaiThuoc;
	}
	public void setTenLoaiThuoc(int tenLoaiThuoc) {
		this.tenLoaiThuoc = tenLoaiThuoc;
	}
	public String getTenNhomThuoc() {
		return tenNhomThuoc;
	}
	public void setTenNhomThuoc(String tenNhomThuoc) {
		this.tenNhomThuoc = tenNhomThuoc;
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
	
	

}
