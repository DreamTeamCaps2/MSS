package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoaiBenhDAO extends DBHelper{
	
	public int kt(String tenLoaiBenh)
	{
		connect();
		String sql2 = String.format("SELECT MaLoaiBenh "
				+ "FROM LOAIBENH WHERE TenLoaiBenh = N'%s'",tenLoaiBenh);
		
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
				if(rs.getInt("MaLoaiBenh")==0)
					return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(dem==0)
			return 1;
		return 0;
	}

	public void them(String tenLoaiBenh) {
		connect();
	    String sql =String.format("Insert into LOAIBENH (TenLoaiBenh) "
	    		+ "VALUES (N'%s')",tenLoaiBenh);
	    try {
	        Statement stmt = connection.createStatement();
	        stmt.executeUpdate(sql);
	    } catch (SQLException e) {
	        e.printStackTrace();    
	    }
	    System.out.println("Da them loai benh");
	}
	
	public int ktXoa(int maLoaiBenh) {
		connect();
		String sql2 = String.format("SELECT SUM(BENH.MaBenh) as DEM  "
				+ "FROM BENH "
				+ "WHERE MaLoaiBenh = N'%s'",maLoaiBenh);
		
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
	
	public void xoa(int maLoaiBenh)
	{
		connect();
        String sql= String.format("DELETE FROM LOAIBENH WHERE MaLoaiBENH = %s", maLoaiBenh);
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

}
