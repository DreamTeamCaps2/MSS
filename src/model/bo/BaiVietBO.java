package model.bo;

import java.util.ArrayList;

import model.bean.BaiViet;
import model.bean.BinhLuan;
import model.bean.DanhDau;
import model.dao.BaiVietDAO;

public class BaiVietBO {

	BaiVietDAO baiVietDAO = new BaiVietDAO();

	public ArrayList<BaiViet> getListBaiViet() {
		return baiVietDAO.getListBaiViet();
	}

	public BaiViet getBaiViet(int maBaiViet) {
		return baiVietDAO.getBaiViet(maBaiViet);
	}

	public void themBaiViet(String tieuDe, String tomTat, String hinhAnh, String noiDung) {
		baiVietDAO.themBaiViet(tieuDe, tomTat, hinhAnh, noiDung);
	}

	public void suaBaiViet(int maBaiViet, String tieuDe, String tomTat, String hinhAnh, String noiDung) {
		baiVietDAO.suaBaiViet(maBaiViet, tieuDe, tomTat, hinhAnh, noiDung);
	}

	public void addMark(String maTKDN, String maDangNhapKhach) {
		baiVietDAO.addMark(maTKDN, maDangNhapKhach);
	}
	
	public void removeMark(String maTKDN, String maTKPhu) {
		baiVietDAO.removeMark(maTKDN, maTKPhu);		
	}

	public void addRate(String maTKDN, String maDangNhapKhach, String rating, String datetime) {
		baiVietDAO.addRate(maTKDN, maDangNhapKhach, rating, datetime);
	}

	public void addReport(String maTKDN, String maDangNhapKhach, String datetime) {
		baiVietDAO.addReport(maTKDN, maDangNhapKhach, datetime);
	}

	public void addComment(String maTKDN, String maDangNhapKhach, String comment, String datetime) {
		baiVietDAO.addComment(maTKDN, maDangNhapKhach, comment, datetime);
	}

	public String getRate(String maTKDN, String maTKPhu) {
		return baiVietDAO.getRate(maTKDN, maTKPhu);	
	}

	public boolean getMark(String maTKDN, String maTKPhu) {
		return baiVietDAO.getMark(maTKDN, maTKPhu);
	}

	public boolean getReport(String maTKDN, String maTKPhu) {
		return baiVietDAO.getReport(maTKDN, maTKPhu);		
	}

	public ArrayList<BinhLuan> getListComment(String maTKPhu) {
		return baiVietDAO.getListComment(maTKPhu);			
	}

	public void updateRate(String maTKDN, String maTKPhu, String rating, String datetime) {
		baiVietDAO.updateRate(maTKDN, maTKPhu, rating, datetime);		
	}

	public void xoaBaiViet(String maBaiVietXoa) {
		baiVietDAO.xoaBaiViet(maBaiVietXoa);
	}

	public void capNhatLuotXem(int ma, int luotXem) {
		baiVietDAO.capNhatLuotXem(ma, luotXem);
	}

	public String getRateTB(String maTKPhu) {
		return baiVietDAO.getRateTB(maTKPhu);	
	}

	public ArrayList<DanhDau> getListDanhDau(String maTKDN) {
		return baiVietDAO.getListDanhDau(maTKDN);
	}

}
