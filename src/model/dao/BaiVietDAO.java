package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.BaiViet;

public class BaiVietDAO extends DBHelper{

	public void themBaiViet(String tieuDe, String tomTat, String hinhAnh, String noiDung) {
		connect();
		String sql=	String.format("INSERT INTO BAIVIET(TieuDe,TomTat,HinhAnh,NoiDung) "+
				" VALUES ( N'%s',N'%s',N'%s',N'%s')",tieuDe, tomTat, hinhAnh, noiDung);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<BaiViet> getListBaiViet() {
		connect();
		String sql = "Select * FROM BAIVIET";

		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<BaiViet> listBaiViet = new ArrayList<BaiViet>();
		BaiViet ch;
		try {
//			int i=0;
			while (rs.next()) {
				ch = new BaiViet();
				ch.setMaBaiViet(rs.getInt("MaBaiViet"));
				ch.setTieuDe(rs.getString("TieuDe"));
				ch.setHinhAnh(rs.getString("HinhAnh"));
				ch.setTomTat(rs.getString("TomTat"));
//				
//				ch.setTenDangNhap(rs.getString("TenDangNhap"));
//				ch.setDiaChi(rs.getString("DiaChi"));
//				ch.setId(i++);
				listBaiViet.add(ch);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listBaiViet;
	}

	public BaiViet getBaiViet(int maBaiViet) {
		connect();
		String sql="SELECT * FROM BAIVIET WHERE MaBaiViet="+maBaiViet;
		
		System.out.println(sql);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		BaiViet baiViet = new BaiViet();
		try {
			while(rs.next()){
				baiViet.setTieuDe(rs.getString("TieuDe"));
				baiViet.setTomTat(rs.getString("TomTat"));
				baiViet.setNoiDung(rs.getString("NoiDung"));
				baiViet.setHinhAnh(rs.getString("HinhAnh"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return baiViet;
	}

	public void suaBaiViet(int maBaiViet, String tieuDe, String tomTat, String hinhAnh, String noiDung) {
		connect();
		String sql=	String.format("UPDATE BAIVIET "+
					" SET TieuDe = N'%s', TomTat = N'%s', HinhAnh = '%s', NoiDung = N'%s'" +
					" WHERE MaBaiViet = %s", tieuDe, tomTat, hinhAnh, noiDung, maBaiViet);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
