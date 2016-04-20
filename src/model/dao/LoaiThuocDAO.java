package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoaiThuocDAO extends DBHelper{
	
	public int kt(String tenLoaiThuoc)
	{
		connect();
		String sql2 = String.format("SELECT MaLoaiThuoc "
				+ "FROM LOAITHUOC WHERE TenLoaiThuoc = N'%s'",tenLoaiThuoc);
		
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int dem=0;
		try {
			while(rs.next()){
				dem = dem  +1;
				if(rs.getInt("MaLoaiThuoc")==0)
					return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(dem==0)
			return 1;
		return 0;
	}

	public void them(String tenLoaiThuoc) {
		connect();
	    String sql =String.format("Insert into LOAITHUOC (TenLoaiThuoc) "
	    		+ "VALUES (N'%s')",tenLoaiThuoc);
	    try {
	        Statement stmt = connection.createStatement();
	        stmt.executeUpdate(sql);
	    } catch (SQLException e) {
	        e.printStackTrace();    
	    }
	    System.out.println("Da them loai thuoc");
	}

	public int ktXoa(int maLoaiThuoc) {
		connect();
		String sql2 = String.format("SELECT SUM(THUOC.MaThuoc) as DEM  "
				+ "FROM THUOC INNER JOIN NHOMTHUOC ON THUOC.MaNhomThuoc = NHOMTHUOC.MaNhomThuoc "
				+ "WHERE NHOMTHUOC.MaLoaiThuoc = N'%s'",maLoaiThuoc);
		
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		int dem=0;
		try {
			while(rs.next()){
//				dem = dem  +1;
				if(rs.getInt("DEM")==0)
					return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		if(dem==0)
//			return 1;
		return 0;
	}
	
	public void xoa(int maLoaiThuoc)
	{
		connect();
        String sql= String.format("DELETE FROM LOAITHUOC WHERE MaLoaiThuoc = %s", maLoaiThuoc);
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

}
