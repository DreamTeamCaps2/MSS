package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.LoaiBenh;
import model.bean.NhomThuoc;
import model.bean.ThongBao;

public class ThongBaoDAO extends DBHelper {
	

	public ArrayList<ThongBao> getListThongBao() {
		// TODO Auto-generated method stub
		connect();
		String sql2 = "Select noidung from THONGBAO where Loai= 2 and DATEDIFF(DD,ThoiGian,GETDATE())<7";
		
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<ThongBao> list = new ArrayList<ThongBao>();
		ThongBao tb;
		try {
			while(rs.next()){
				tb = new ThongBao();
				tb.setNoiDung(rs.getString("NoiDung"));
				//tb.setThoiGian(rs.getString("ThoiGian"));
				list.add(tb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<NhomThuoc> getListNhomThuoc() {
		// TODO Auto-generated method stub
		connect();
		String sql2 = "Select MaNhomThuoc,TenNhomThuoc,MaLoaiThuoc from NhomThuoc ";
		
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<NhomThuoc> list = new ArrayList<NhomThuoc>();
		NhomThuoc nhomThuoc;
		try {
			while(rs.next()){
				nhomThuoc = new NhomThuoc();
				nhomThuoc.setMaNhomThuoc(rs.getInt("MaNhomThuoc"));
				nhomThuoc.setTenNhomThuoc(rs.getString("TenNhomThuoc"));
				nhomThuoc.setMaLoaiThuoc(rs.getInt("maLoaiThuoc"));
				//tb.setThoiGian(rs.getString("ThoiGian"));
				list.add(nhomThuoc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<LoaiBenh> getListLoaiBenh() {
		// TODO Auto-generated method stub
		connect();
		String sql2 = "Select maLoaiBenh,tenLoaiBenh from LoaiBENH ";
		
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<LoaiBenh> list = new ArrayList<LoaiBenh>();
		LoaiBenh loaiBenh;
		try {
			while(rs.next()){
				loaiBenh = new LoaiBenh();
				loaiBenh.setMaLoaiBenh(rs.getInt("maLoaiBenh"));
				loaiBenh.setTenLoaiBenh(rs.getString("tenLoaiBenh"));
				list.add(loaiBenh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
