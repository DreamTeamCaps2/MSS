package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import model.bean.BaiViet;
import model.bean.LuotXem;

public class BaiVietForm extends ActionForm{

	private int maBaiViet;
	private String tieuDe, tomTat, hinhAnh, noiDung, submit;
	private FormFile file;
	
	private ArrayList<BaiViet> listBaiViet;
	private static ArrayList<LuotXem> listLuotXem =  new ArrayList<LuotXem>();
	
	public int getMaBaiViet() {
		return maBaiViet;
	}
	public void setMaBaiViet(int maBaiViet) {
		this.maBaiViet = maBaiViet;
	}
	public String getTieuDe() {
		return tieuDe;
	}
	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}
	public String getTomTat() {
		return tomTat;
	}
	public void setTomTat(String tomTat) {
		this.tomTat = tomTat;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public ArrayList<BaiViet> getListBaiViet() {
		return listBaiViet;
	}
	public void setListBaiViet(ArrayList<BaiViet> listBaiViet) {
		this.listBaiViet = listBaiViet;
	}
	public FormFile getFile() {
		return file;
	}
	public void setFile(FormFile file) {
		this.file = file;
	}
	public static ArrayList<LuotXem> getListLuotXem() {
		return listLuotXem;
	}
	public static void setListLuotXem(ArrayList<LuotXem> listLuotXem) {
		BaiVietForm.listLuotXem = listLuotXem;
	}
	
	
}
