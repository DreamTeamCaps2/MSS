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

	public int soLuongNhomThuoc() {
		connect();
		String sql2 = "	Select Count(maNhomThuoc) as soNhomThuoc,MaLoaiThuoc from NHOMTHUOC group by NhomThuoc.MaLoaiThuoc	order by count(maNhomThuoc) desc; ";
		
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		try {
			while(rs.next()){
				return rs.getInt("soNhomThuoc");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public ArrayList<ThongBao> getListThongBaoGopY(String maTK, int loaiGopY, int tinhTrang) {
		// TODO Auto-generated method stub
		connect();
		String sql2 = "Select TrangThai,noiDung,maGopY,chuDe,thoigian from GopY where maTK="+maTK;
		if(loaiGopY==1){
			sql2= sql2+" and loaiGopY=1";
		}
		if(loaiGopY==2){
			sql2= sql2+" and loaiGopY=2";
		}
		if(loaiGopY==4){
			sql2= sql2+" and loaiGopY=4";
		}
		if(tinhTrang==0){
			sql2= sql2+" and TrangThai=0";
		}
		if(tinhTrang==1){
			sql2= sql2+" and TrangThai=1";
		}
		System.out.println(sql2);
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
				tb.setChuDe(rs.getString("chude"));
				//tb.setThoiGian(rs.getString("ThoiGian"));
				tb.setThoiGian(rs.getString("thoigian"));
				tb.setMaGopY(rs.getInt("magopy"));
				tb.setNoiDung(rs.getString("noiDung"));
				tb.setTinhTrang(rs.getInt("TrangThai"));
				list.add(tb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void updateDaXem(int maGopY) {
		// TODO Auto-generated method stub
		connect();
		String sql2 = "update  GopY set TrangThai=1 where maGopY="+maGopY;
		
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateChuaXem(int maGopY) {
		// TODO Auto-generated method stub
		connect();
		String sql2 = "update  GopY set TrangThai=0 where maGopY="+maGopY;
		
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void xoaGopY(int maGopY) {
		// TODO Auto-generated method stub
		connect();
		String sql2 = "Delete from GOPY where MaGopY="+maGopY;
		
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
