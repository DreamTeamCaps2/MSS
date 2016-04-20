package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PhanQuyenDAO {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=Caps2_TUAN;";
	String userName = "sa";
	String password = "12345678";
	Connection connection;

	void connect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url, userName, password);
			System.out.println("Ket noi thanh cong");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Ket noi loi");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Ket noi loi");
		}
	}
	
	public ArrayList<Integer> getListQuyen(int maTaiKhoan) {
		connect();
		String sql = String.format("SELECT MaQuyen FROM PhanQuyen WHERE MaThanhVien = %s",maTaiKhoan);

		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		try {
			while (rs.next()) {
				list.add(rs.getInt("MaQuyen"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void themQuyen(int maTaiKhoan, int maQuyen)
	{
		connect();
		
		String sql = String.format("INSERT INTO PhanQuyen(MaThanhVien,MaQuyen) VALUES (%s,%s)",maTaiKhoan,maQuyen);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void xoaQuyen(int maTaiKhoan) {
        connect();
        String sql= String.format("DELETE FROM PhanQuyen WHERE MaThanhVien = '%s'", maTaiKhoan);
        System.out.println(sql);
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

}
