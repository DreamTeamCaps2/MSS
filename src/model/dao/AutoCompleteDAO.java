package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.AutoComplete;

public class AutoCompleteDAO extends DBHelper{

	public ArrayList<AutoComplete> getListBenh(String query) {
		connect();
		String sql2 = "Select maBenh,tenBenh from Benh where tenBenh like  N'%"+query+"%'";
		System.out.println(sql2);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<AutoComplete> list = new ArrayList<AutoComplete>();
		AutoComplete autoComplete;
		try {
			while(rs.next()){
				autoComplete = new AutoComplete();
				String name=rs.getString("tenBenh");
				int maBenh = rs.getInt("maBenh");
				String link="/MSS/chi-tiet-benh.do?"+"ma="+maBenh;
				autoComplete.setName(name);
				autoComplete.setLink(link);
				autoComplete.setMa(maBenh);
				list.add(autoComplete);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public  ArrayList<AutoComplete> getListThuoc(String query) {
		connect();
		String sql2 = "Select maThuoc,tenThuoc from Thuoc  where tenThuoc like  N'%"+query+"%'";
		System.out.println("1"+sql2);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<AutoComplete> list = new ArrayList<AutoComplete>();
		AutoComplete autoComplete;
		try {
			while(rs.next()){
				autoComplete = new AutoComplete();
				String name=rs.getString("tenThuoc");
				int maThuoc = rs.getInt("maThuoc");
				String link="/MSS/chi-tiet-thuoc.do?ma="+maThuoc;
				autoComplete.setName(name);
				autoComplete.setLink(link);
				autoComplete.setMa(maThuoc);
				list.add(autoComplete);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
