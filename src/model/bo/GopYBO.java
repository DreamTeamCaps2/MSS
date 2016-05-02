package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.ThongBao;
import model.dao.GopYDAO;

public class GopYBO {
	
	GopYDAO  gopYDAO = new GopYDAO();

	public void updateGopY(String tenChuDe, int loaiGopY, String noiDung) throws SQLException {
		// TODO Auto-generated method stub
		gopYDAO.updateGopY(tenChuDe,loaiGopY,noiDung);
		
	}

	public ThongBao getGopY(int maGopY) {
		// TODO Auto-generated method stub
		return gopYDAO.getGopY(maGopY);
	}

	public ArrayList<ThongBao> getListGopY(String maTK) {
		// TODO Auto-generated method stub
		return gopYDAO.getListGopY(maTK);
	}
}
