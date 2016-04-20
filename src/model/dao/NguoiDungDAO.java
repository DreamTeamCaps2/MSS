package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.NguoiDung;

public class NguoiDungDAO extends DBHelper {

	
	public boolean checkLogin(String tenDangNhap, String matKhau) {
		connect();
		String sql = String.format("SELECT TenDangNhap FROM TAIKHOAN WHERE TenDangNhap = '%s' AND MatKhau = '%s'",
				tenDangNhap, matKhau);
		System.out.println(sql);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public String getMaLoai(String tenDangNhap) {
		connect();
		String sql = "Select MaLoai FROM TAIKHOAN WHERE TenDangNhap='"+ tenDangNhap+"'";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String maloai=null;
		try {
			while (rs.next()) {
				maloai = rs.getString("MaLoai");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maloai;
	}

	public boolean userNameExist(String tenDangNhap) {
		connect();
		String sql = String.format("SELECT TenDangNhap FROM TAIKHOAN WHERE TenDangNhap = '%s' ", tenDangNhap);
		
		ResultSet rs = null;
        try {
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

       String ten="";
        try {
            while(rs.next()){
                ten = rs.getString("TenDangNhap");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		if(tenDangNhap.equals(ten))
			return true;
		else
			return false;
	}

	public boolean emailExist(String email) {
		connect();
		String sql = String.format("SELECT email FROM THANHVIEN WHERE email = '%s' ", email);
		
		ResultSet rs = null;
        try {
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

       String email1="";
        try {
            while(rs.next()){
                email1 = rs.getString("Email");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }		
		if(email.equals(email1))
			return false;
		else
			return true;
	}

	public ArrayList<NguoiDung> getListNguoiDung() {
		connect();
		String sql = "Select * FROM TAIKHOAN";

		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<NguoiDung> listTen = new ArrayList<NguoiDung>();
		NguoiDung ch;
		try {
			int i=0;
			while (rs.next()) {
				ch = new NguoiDung();
				ch.setUserName(rs.getString("TenDangNhap"));
				System.out.println(rs.getString("TenDangNhap"));
				ch.setId(i++);
				listTen.add(ch);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listTen;
	}

	
}
