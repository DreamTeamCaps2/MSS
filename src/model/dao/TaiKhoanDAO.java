package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.LoaiTaiKhoan;
import model.bean.Quyen;
import model.bean.TaiKhoan;
public class TaiKhoanDAO extends DBHelper{

	public void themTaiKhoan(String tenDangNhap, String matKhau, String diaChi, String sDT, String maLoai) {
		connect();
		//String maTK = "TK0007_TK";
		String sql=	String.format("INSERT INTO TAIKHOAN(tenDangNhap,matKhau,diaChi,sDT) "+
				" VALUES ( '%s','%s',N'%s','%s')",tenDangNhap, matKhau, diaChi, sDT);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public TaiKhoan getThongTinTaiKhoan(String tenDangNhap1, String maLoai) {
		connect();
		String sql="";
		sql = "SELECT * FROM TAIKHOAN LEFT JOIN THANHVIEN ON TAIKHOAN.MaTK = THANHVIEN.MaThanhVien "
				+ "LEFT JOIN NHATHUOC ON TAIKHOAN.MaTK = NHATHUOC.MaNhaThuoc "
				+ "LEFT JOIN PHONGKHAM ON TAIKHOAN.MaTK = PHONGKHAM.MaPhongKham "
				+ "WHERE TenDangNhap='"+ tenDangNhap1+"'";
		
		System.out.println(sql);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		TaiKhoan taiKhoan = new TaiKhoan();
		try {
			while(rs.next()){
				taiKhoan.setTenDangNhap(rs.getString("tenDangNhap"));
				taiKhoan.setMatKhau(rs.getString("matKhau"));
				taiKhoan.setSDT(rs.getString("sDT"));
				taiKhoan.setDiaChi(rs.getString("diaChi"));
				taiKhoan.setLoaiTK(rs.getString("MaLoaiTaiKhoan"));
				taiKhoan.setMaTK(rs.getString("MaTK"));
				taiKhoan.setTenPhongKham(rs.getString("TenPhongKham"));
				taiKhoan.setMoTa(rs.getString("MoTa"));
				taiKhoan.setThoiGian(rs.getString("ThoiGian"));
				taiKhoan.setTenNhaThuoc(rs.getString("TenNhaThuoc"));
				taiKhoan.setCmnd(rs.getString("CMND"));
				taiKhoan.setEmail(rs.getString("Email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return taiKhoan;
	}

	public void suaTaiKhoan(String tenDangNhap, String matKhau, String diaChi, String sDT, String maLoai) {
		connect();
		String sql=	String.format("UPDATE TAIKHOAN "+
					" SET matKhau = %s, diaChi = N'%s', SDT = '%s'" +
					" WHERE tenDangNhap = '%s'", matKhau, diaChi, sDT, tenDangNhap);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public void suaTaiKhoan(String maTK, String tenDangNhap, String matKhau, String diaChi, String sDT, String maLoai,
			String cmnd, String email, String tenNhaThuoc, String tenPhongKham, String moTa, String thoiGian) {
		connect();
		String sql=	String.format("UPDATE TAIKHOAN "+
					" SET diaChi = N'%s', SDT = '%s'" +
					" WHERE tenDangNhap = '%s'", diaChi, sDT, tenDangNhap);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(cmnd!=null )
		{
			sql = "UPDATE THANHVIEN SET CMND = '"+cmnd+"', Email = '"+email+"' WHERE MaThanhVien = '"+maTK+"'";
		}
		else if(tenNhaThuoc!=null ){
			sql = "UPDATE NHATHUOC SET TenNhaThuoc = N'"+tenNhaThuoc+"' WHERE MaNhaThuoc = '"+maTK+"'";
		}
		else if(tenPhongKham!=null ){
			sql = "UPDATE PHONGKHAM SET TenPhongKham = N'"+tenPhongKham+"', MoTa = N'"+moTa+"' , ThoiGian = N'"+thoiGian+"' WHERE MaPhongKham = '"+maTK+"'";
		}
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void themTaiKhoan(String tenDangNhap, String matKhau, String diaChi, String sDT, String loaiTK, String email,
			String cmnd, String tenNhaThuoc, String tenPhongKham, String moTa, String thoiGian) {
		connect();
		//Thêm vào bảng Tài Khoản	
		int xacNhan = 0;
		if(loaiTK.equals("1")){
			xacNhan = 1;
		}
		String sql=	String.format("INSERT INTO TAIKHOAN(tenDangNhap,matKhau,diaChi,sDT,MaLoaiTaiKhoan) "+
				" VALUES ( '%s','%s',N'%s','%s',%s)",tenDangNhap, matKhau, diaChi, sDT, loaiTK);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Lấy MaTK Theo tên Đăng nhập
		sql = "SELECT MaTK FROM TAIKHOAN WHERE TenDangNhap='"+ tenDangNhap+"'";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String maTK=null;
		try {
			while (rs.next()) {
				maTK = rs.getString("MaTK");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Thêm vào từng bảng riêng
		if(loaiTK.equals("3"))
		{
			sql = String.format("INSERT INTO THANHVIEN(MaThanhVien, CMND, Email) "+
					" VALUES ( %s,'%s','%s')",maTK, cmnd, email);
		}
		else if(loaiTK.equals("4")){
			sql = String.format("INSERT INTO NHATHUOC(MaNhaThuoc, TenNhaThuoc) "+
					" VALUES ( %s,N'%s')",maTK, tenNhaThuoc);
		}
		else if(loaiTK.equals("5")){
			sql = String.format("INSERT INTO PHONGKHAM(MaPhongKham, TenPhongKham, MoTa, ThoiGian) "+
					" VALUES ( %s,N'%s','%s','%s')",maTK, tenPhongKham, moTa, thoiGian);
		}
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<TaiKhoan> getListNguoiDung() {
		connect();
		String sql = "Select * FROM TAIKHOAN";

		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<TaiKhoan> listTen = new ArrayList<TaiKhoan>();
		TaiKhoan ch;
		try {
			int i=0;
			while (rs.next()) {
				ch = new TaiKhoan();
				ch.setTenDangNhap(rs.getString("TenDangNhap"));
				ch.setDiaChi(rs.getString("DiaChi"));
				ch.setId(i++);
				listTen.add(ch);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listTen;
	}

	//////TUAN
	public ArrayList<LoaiTaiKhoan> getListLoaiTaiKhoan()
	{
		connect();
		String sql2 = "SELECT MaLoaiTaiKhoan, TenLoaiTaiKhoan FROM LOAITAIKHOAN";
		
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<LoaiTaiKhoan> list = new ArrayList<LoaiTaiKhoan>();
		LoaiTaiKhoan ltk;
		try {
			while(rs.next()){
				ltk = new LoaiTaiKhoan();
				ltk.setMaLoaiTaiKhoan(rs.getInt("MaLoaiTaiKhoan"));
				ltk.setTenLoaiTaiKhoan(rs.getString("TenLoaiTaiKhoan"));
				list.add(ltk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public ArrayList<TaiKhoan> getListTaiKhoan()
	{
		connect();
		String sql2 = "SELECT tk.MaTK, tk.TenDangNhap, ltk.TenLoaiTaiKhoan, tk.MaLoaiTaiKhoan "
				+ "FROM TAIKHOAN tk INNER JOIN LOAITAIKHOAN ltk ON tk.MaLoaiTaiKhoan = ltk.MaLoaiTaiKhoan";
		System.out.println(sql2);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<TaiKhoan> list = new ArrayList<TaiKhoan>();
		TaiKhoan tk;
		try {
			while(rs.next()){
				tk = new TaiKhoan();
				tk.setMaTaiKhoan(rs.getInt("MaTK"));
				tk.setTenDangNhap(rs.getString("TenDangNhap"));
				tk.setTenLoaiTaiKhoan(rs.getString("TenLoaiTaiKhoan"));
				int loai = rs.getInt("MaLoaiTaiKhoan");
				if(loai <4)
					tk.setLoaiTK("1");
				list.add(tk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<TaiKhoan> getListTaiKhoan(String timTaiKhoan,int maLoaiTaiKhoan, int maQuyen)
	{
		connect();
		String sql2 = "SELECT tk.MaTK, tk.TenDangNhap, ltk.TenLoaiTaiKhoan, tk.MaLoaiTaiKhoan "
				+ "FROM TAIKHOAN tk INNER JOIN LOAITAIKHOAN ltk ON tk.MaLoaiTaiKhoan = ltk.MaLoaiTaiKhoan "
				+ "WHERE TenDangNhap LIKE N'%"+timTaiKhoan+ "%'";
		if(maLoaiTaiKhoan != 0)
			sql2 = sql2+"AND tk.MaLoaiTaiKhoan = "+maLoaiTaiKhoan;
		if(maQuyen != 0)
			sql2 = sql2+"AND tk.MaTK IN (SELECT THANHVIEN.MaThanhVien "
					+ "FROM PHANQUYEN INNER JOIN THANHVIEN ON PHANQUYEN.MaThanhVien=THANHVIEN.MaThanhVien "
					+ " WHERE MaQuyen = "+maQuyen+")";
		
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<TaiKhoan> list = new ArrayList<TaiKhoan>();
		TaiKhoan tk;
		try {
			while(rs.next()){
				tk = new TaiKhoan();
				tk.setMaTaiKhoan(rs.getInt("MaTK"));
				tk.setTenDangNhap(rs.getString("TenDangNhap"));
				tk.setTenLoaiTaiKhoan(rs.getString("TenLoaiTaiKhoan"));
				int loai = rs.getInt("MaLoaiTaiKhoan");
				if(loai <4)
					tk.setLoaiTK("1");
				list.add(tk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<Quyen> getListQuyen()
	{
		connect();
		String sql2 = "SELECT MaQuyen, TenQuyen FROM Quyen";
		
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<Quyen> list = new ArrayList<Quyen>();
		Quyen q;
		try {
			while(rs.next()){
				q = new Quyen();
				q.setMaQuyen(rs.getInt("MaQuyen"));
				q.setTenQuyen(rs.getString("TenQuyen"));
				list.add(q);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
}
