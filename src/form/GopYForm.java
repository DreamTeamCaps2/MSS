package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.ThongBao;

public class GopYForm extends ActionForm{
	private int loaiGopY ;
	private String noiDung;
	private String submit;
	private String chuDe;
	private String thoiGian;
	private int maGopY;
	private ArrayList<ThongBao> listGopY;
	
	
	public String getThoiGian() {
		return thoiGian;
	}
	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}
	public int getMaGopY() {
		return maGopY;
	}
	public void setMaGopY(int maGopY) {
		this.maGopY = maGopY;
	}
	public ArrayList<ThongBao> getListGopY() {
		return listGopY;
	}
	public void setListGopY(ArrayList<ThongBao> listGopY) {
		this.listGopY = listGopY;
	}
	public String getChuDe() {
		return chuDe;
	}
	public void setChuDe(String chuDe) {
		this.chuDe = chuDe;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public int getLoaiGopY() {
		return loaiGopY;
	}
	public void setLoaiGopY(int loaiGopY) {
		this.loaiGopY = loaiGopY;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	

}
