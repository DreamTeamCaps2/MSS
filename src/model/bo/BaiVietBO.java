package model.bo;

import java.util.ArrayList;

import model.bean.BaiViet;
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

}
