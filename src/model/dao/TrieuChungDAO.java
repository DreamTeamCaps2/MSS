package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.TrieuChung;

public class TrieuChungDAO extends DBHelper{

	public ArrayList<TrieuChung> getListTrieuChung(String timTrieuChung)
	{
		connect();
		String sql2 = "SELECT MaTrieuChung,TenTrieuChung FROM TRIEUCHUNG WHERE TenTrieuChung LIKE N'%"+timTrieuChung+"%'";
		
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<TrieuChung> list = new ArrayList<TrieuChung>();
		TrieuChung lb;
		try {
			while(rs.next()){
				lb = new TrieuChung();
				lb.setMaTrieuChung(rs.getInt("MaTrieuChung"));
				lb.setTenTrieuChung(rs.getString("TenTrieuChung"));
				list.add(lb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<TrieuChung> getListTrieuChung(int maBenh)
	{
		connect();
		String sql2 = "SELECT TRIEUCHUNGBENH.MaTrieuChung,TenTrieuChung "
				+ "FROM TRIEUCHUNGBENH INNER JOIN TRIEUCHUNG ON TRIEUCHUNGBENH.MaTrieuChung = TRIEUCHUNG.MaTrieuChung "
				+ " WHERE MaBenh =  "+maBenh;
		
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<TrieuChung> list = new ArrayList<TrieuChung>();
		TrieuChung lb;
		try {
			while(rs.next()){
				lb = new TrieuChung();
				lb.setMaTrieuChung(rs.getInt("MaTrieuChung"));
				lb.setTenTrieuChung(rs.getString("TenTrieuChung"));
				list.add(lb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public TrieuChung getTrieuChung(int maTrieuChung)
	{
		connect();
		String sql2 = String.format("SELECT MaTrieuChung,TenTrieuChung "
				+ "FROM TRIEUCHUNG WHERE MaTrieuChung = %s",maTrieuChung);
		
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		TrieuChung tc = new TrieuChung();
		try {
			while(rs.next()){
				tc.setMaTrieuChung(rs.getInt("MaTrieuChung"));
				tc.setTenTrieuChung(rs.getString("TenTrieuChung"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tc;
	}

	public void xoaTrieuChungBenh(int maBenh) {
			connect();
	        String sql= String.format("DELETE FROM TRIEUCHUNGBENH WHERE MaBenh = %s", maBenh);
	        try {
	            Statement stmt = connection.createStatement();
	            stmt.executeUpdate(sql);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}
	
	//DUC
	public ArrayList<TrieuChung> getListTrieuChung() {
		connect();
		String sql2 = "SELECT MaTrieuChung,TenTrieuChung FROM TRIEUCHUNG";
		
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<TrieuChung> list = new ArrayList<TrieuChung>();
		TrieuChung lb;
		try {
			while(rs.next()){
				lb = new TrieuChung();
				lb.setMaTrieuChung(rs.getInt("MaTrieuChung"));
				lb.setTenTrieuChung(rs.getString("TenTrieuChung"));
				list.add(lb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void themTrieuChung(String tenTrieuChung) {
		connect();
		String sql=	String.format("INSERT INTO TRIEUCHUNG(TenTrieuChung) "+
				" VALUES ( N'%s')",tenTrieuChung);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	public void xoaTrieuChung(String maTrieuChung) {
		connect();
        String sql= String.format("DELETE FROM TRIEUCHUNG WHERE maTrieuChung = %s", maTrieuChung);
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql= String.format("DELETE FROM TRIEUCHUNGBENH WHERE maTrieuChung = %s", maTrieuChung);
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public boolean checkExist(String tenTrieuChung) {
		connect();
		String sql = String.format("SELECT TenTrieuChung FROM TRIEUCHUNG WHERE TenTrieuChung = N'%s' ", tenTrieuChung);
		
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
                ten = rs.getString("TenTrieuChung");
                System.out.println(ten);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		if(tenTrieuChung.equals(ten))
			return true;
		else
			return false;
	}
}
