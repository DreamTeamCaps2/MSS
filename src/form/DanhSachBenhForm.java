package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.Benh;
import model.bean.LoaiBenh;

public class DanhSachBenhForm  extends ActionForm{
	private ArrayList<Benh> listBenh;
	private ArrayList<LoaiBenh> listLoaiBenh;
	private int maLoaiDanhSach;
	
	public ArrayList<LoaiBenh> getListLoaiBenh() {
		return listLoaiBenh;
	}
	public void setListLoaiBenh(ArrayList<LoaiBenh> listLoaiBenh) {
		this.listLoaiBenh = listLoaiBenh;
	}

	public ArrayList<Benh> getListBenh() {
		return listBenh;
	}
	public void setListBenh(ArrayList<Benh> listBenh) {
		this.listBenh = listBenh;
	}
	public int getMaLoaiDanhSach() {
		return maLoaiDanhSach;
	}
	public void setMaLoaiDanhSach(int maLoaiDanhSach) {
		this.maLoaiDanhSach = maLoaiDanhSach;
	}
	
}
