package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.BaiViet;
import model.bean.BinhLuan;
import model.bean.DanhDau;

public class BaiVietDAO extends DBHelper{

	public void themBaiViet(String tieuDe, String tomTat, String hinhAnh, String noiDung) {
		connect();
		String sql=	String.format("INSERT INTO BAIVIET(TieuDe,TomTat,HinhAnh,NoiDung, ThoiGian) "+
				" VALUES ( N'%s',N'%s',N'%s',N'%s',getDate())",tieuDe, tomTat, hinhAnh, noiDung);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<BaiViet> getListBaiViet(int pageNum) {
		connect();
		String sql="";
		if(pageNum<0){
			sql = "Select * FROM BAIVIET ORDER BY MaBaiViet DESC";
		}
		else{
			int page = pageNum*10+5;
			sql = "SELECT  * FROM BAIVIET ORDER BY MaBaiViet DESC "
				+ "OFFSET "+ page + " ROWS "
				+ "FETCH NEXT 10 ROWS ONLY ";
		}
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
				ch.setLuotXem(rs.getInt("LuotXem"));
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
				baiViet.setLuotXem(rs.getInt("LuotXem"));
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

	public void addMark(String maTKDN, String maDangNhapKhach) {
		connect();
		String sql=	String.format("INSERT INTO DANHDAU(MaTK_Chinh, MaTK_Phu) "+
				" VALUES ( %s,%s)",maTKDN,maDangNhapKhach);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addRate(String maTKDN, String maDangNhapKhach, String rating, String datetime) {
		connect();
		String sql=	String.format("INSERT INTO DANHGIA(MaTK_Chinh, MaTK_Phu, DanhGia, ThoiGian) "+
				" VALUES ( %s, %s, %s, N'%s')",maTKDN,maDangNhapKhach, rating, datetime);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addReport(String maTKDN, String maDangNhapKhach, String datetime) {
		connect();
		String sql=	String.format("INSERT INTO TOCAO(MaTK_Chinh, MaTK_Phu, ThoiGian) "+
				" VALUES ( %s, %s, N'%s')",maTKDN,maDangNhapKhach, datetime);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addComment(String maTKDN, String maDangNhapKhach, String comment, String datetime) {
		connect();
		String sql=	String.format("INSERT INTO BINHLUAN(MaTK_Chinh, MaTK_Phu, NoiDung, ThoiGian) "+
				" VALUES ( %s, %s, N'%s', N'%s')",maTKDN,maDangNhapKhach, comment, datetime);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getRate(String maTKDN, String maTKPhu) {
		connect();
		String sql="SELECT * FROM DANHGIA WHERE MaTK_Chinh="+maTKDN + " and  MaTK_Phu="+maTKPhu;
		
		System.out.println(sql);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String rate="";
		try {
			while(rs.next()){
				rate = rs.getFloat("DanhGia")+"";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rate;
	}

	public boolean getMark(String maTKDN, String maTKPhu) {
		connect();
		String sql="SELECT * FROM DANHDAU WHERE MaTK_Chinh="+maTKDN + " and  MaTK_Phu="+maTKPhu;
		
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

	public boolean getReport(String maTKDN, String maTKPhu) {
		connect();
		String sql="SELECT * FROM TOCAO WHERE MaTK_Chinh="+maTKDN + " and  MaTK_Phu="+maTKPhu;
		
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

	public ArrayList<BinhLuan> getListComment(String maTKPhu) {
		connect();
		String sql = "SELECT TAIKHOAN.TenDangNhap, TAIKHOAN.AnhDaiDien, BINHLUAN.NoiDung, CONVERT(VARCHAR(20), ThoiGian, 100) FROM BINHLUAN "
				+ "INNER JOIN TAIKHOAN ON BINHLUAN.MaTK_Chinh = TAIKHOAN.MaTK "
				+ "WHERE MaTK_Phu = " + maTKPhu;

		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<BinhLuan> listBinhLuan = new ArrayList<BinhLuan>();
		BinhLuan ch;
		try {
			while (rs.next()) {
				ch = new BinhLuan();
				ch.setTenTK(rs.getString(1));
				ch.setHinhAnh(rs.getString(2));
				ch.setNoiDung(rs.getString(3));
				ch.setThoiGian(rs.getString(4));
				listBinhLuan.add(ch);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listBinhLuan;
	}

	public void removeMark(String maTKDN, String maTKPhu) {
		connect();
        String sql= String.format("DELETE FROM DANHDAU WHERE MaTK_Chinh = %s and MaTK_Phu = %s", maTKDN, maTKPhu);
        System.out.println(sql);
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public void updateRate(String maTKDN, String maTKPhu, String rating, String datetime) {
		connect();
		String sql=	String.format("UPDATE DANHGIA SET DanhGia = %s, ThoiGian= N'%s' "+
				" WHERE MaTK_Chinh = %s and MaTK_Phu = %s", rating, datetime, maTKDN, maTKPhu);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void xoaBaiViet(String maBaiVietXoa) {
		connect();
        String sql= String.format("DELETE FROM BAIVIET WHERE MaBaiViet = %s", maBaiVietXoa);
        System.out.println(sql);
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public void capNhatLuotXem(int ma, int luotXem) {
		connect();
	    String sql =String.format("Update BAIVIET set luotxem = %s "
	    		 +"where MaBaiViet= %s",luotXem+1,ma);
	    System.out.println("hehe"+sql);
	    try {
	        Statement stmt = connection.createStatement();
	        stmt.executeUpdate(sql);
	    } catch (SQLException e) {
	        e.printStackTrace();    
	    }
	    System.out.println("Cap nhat luot xem bài viết");
	}

	public String getRateTB(String maTKPhu) {
		connect();
		String sql="SELECT AVG(DanhGia) AS avgDanhGia FROM DANHGIA WHERE MaTK_Phu="+maTKPhu;
		
		System.out.println(sql);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String rate="";
		try {
			while(rs.next()){
				rate = rs.getFloat("avgDanhGia")+"";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rate;
	}

	public ArrayList<DanhDau> getListDanhDau(String maTKDN) {
		connect();
		String sql = "SELECT TenPhongKham, TenNhaThuoc From DANHDAU "
				+ "INNER JOIN TAIKHOAN ON TAIKHOAN.MaTK = DANHDAU.MaTK_Phu "
				+ "LEFT JOIN THANHVIEN ON TAIKHOAN.MaTK = THANHVIEN.MaThanhVien "
				+ "LEFT JOIN NHATHUOC ON TAIKHOAN.MaTK = NHATHUOC.MaNhaThuoc "
				+ "LEFT JOIN PHONGKHAM ON TAIKHOAN.MaTK = PHONGKHAM.MaPhongKham "
				+ "WHERE MaTK_Chinh="+ maTKDN;

		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<DanhDau> listTen = new ArrayList<DanhDau>();
		int i = 0;
		try {
			while (rs.next()) {
				DanhDau danhDau = new DanhDau();
				
				String tenPK = rs.getString(1);
				if(tenPK==null)
					tenPK = rs.getString(2);
				i++;
				danhDau.setTenDanhDau(tenPK);
				danhDau.setId(i);
				listTen.add(danhDau);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listTen;
	}

	public ArrayList<BaiViet> getListBaiVietXemNhieu() {
		connect();
		String sql = "Select Top (5) * FROM BAIVIET order by LuotXem desc";

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
			while (rs.next()) {
				ch = new BaiViet();
				ch.setMaBaiViet(rs.getInt("MaBaiViet"));
				ch.setTieuDe(rs.getString("TieuDe"));
				ch.setHinhAnh(rs.getString("HinhAnh"));
				ch.setTomTat(rs.getString("TomTat"));
				ch.setLuotXem(rs.getInt("LuotXem"));
				listBaiViet.add(ch);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listBaiViet;
	}
	
}
