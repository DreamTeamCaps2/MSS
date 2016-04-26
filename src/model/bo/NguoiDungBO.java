package model.bo;

import java.util.ArrayList;

import model.bean.NguoiDung;
import model.dao.NguoiDungDAO;

public class NguoiDungBO {

	NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
	
	public NguoiDung getNguoiDung(String userName) {
		NguoiDung nguoiDung = new NguoiDung();
		nguoiDung.setUserName(userName);
		
		return nguoiDung;
	}

	public boolean checkLogin(String userName, String passWord) {
		return nguoiDungDAO.checkLogin(userName, passWord);
	}

	public String getMaLoai(String tenDangNhap) {
		return nguoiDungDAO.getMaLoai(tenDangNhap);
	}

	public boolean userNameExist(String tenDangNhap) {
		return nguoiDungDAO.userNameExist(tenDangNhap);
	}
	
	public boolean emailExist(String email) {
		return nguoiDungDAO.emailExist(email);
	}

	public ArrayList<NguoiDung> getListNguoiDung() {
		return nguoiDungDAO.getListNguoiDung();
	}

	public void updateMatKhau(String tenDangNhap, String matKhauMoi) {
		nguoiDungDAO.updateMatKhau(tenDangNhap, matKhauMoi);
	}

}
