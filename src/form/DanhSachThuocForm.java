package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.LoaiThuoc;
import model.bean.NhomThuoc;
import model.bean.Thuoc;

public class DanhSachThuocForm extends ActionForm{
	private ArrayList<Thuoc> listThuoc;
	private ArrayList<NhomThuoc> listNhomThuoc;
	private ArrayList<LoaiThuoc> listLoaiThuoc;
	private int maNhomThuoc,maLoaiThuoc;
	public ArrayList<Thuoc> getListThuoc()	 {
		return listThuoc;
	}
	public void setListThuoc(ArrayList<Thuoc> listThuoc) {
		this.listThuoc = listThuoc;
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
