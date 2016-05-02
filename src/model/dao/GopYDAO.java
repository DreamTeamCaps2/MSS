package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.ThongBao;

public class GopYDAO extends DBHelper{

	public void updateGopY(String tenChuDe, int loaiGopY, String noiDung) throws SQLException {
		// TODO Auto-generated method stub
		connect();
		String sql;
		if(loaiGopY==1){
			 sql = String.format("SELECT MaThanhVien FROM PhanQuyen WHERE MaQuyen = 1");
		}
		else{
			if(loaiGopY==2)
				 sql = String.format("SELECT MaThanhVien FROM PhanQuyen WHERE MaQuyen = 2");
			else
				 sql = String.format("SELECT MaThanhVien FROM PhanQuyen WHERE MaQuyen = 4");
		}
		

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
				list.add(rs.getInt("MaThanhVien"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String query ="insert into GOPY(MaTK,LoaiGopY,ChuDe,NoiDung,TrangThai,ThoiGian) values (?,?,?,?,0,getDate())";
		ps = connection.prepareStatement(query);
		
		ps.setInt(2, loaiGopY);
		ps.setString(3, tenChuDe);
		ps.setString(4,noiDung);
		for(int i=0;i<list.size();i++){
			ps.setInt(1, list.get(i));
			ps.executeUpdate();
			
		}
		
		
	}

	public ThongBao getGopY(int maGopY) {
		// TODO Auto-generated method stub
		connect();
		String sql="Select * from GopY where maGopY="+maGopY;
		

		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ThongBao tb = new ThongBao();
		try {
			while (rs.next()) {
				tb.setChuDe(rs.getString("chuDe"));
				tb.setNoiDung(rs.getString("noiDung"));
				tb.setThoiGian(rs.getString("thoiGian"));
				tb.setLoaiGopY(rs.getInt("LoaiGopY"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tb;
	}

	public ArrayList<ThongBao> getListGopY(String maTK) {
		// TODO Auto-generated method stub
		connect();
		String sql="Select * from GopY where maTK="+maTK+" order by thoigian desc;";
		

		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<ThongBao> list = new ArrayList<ThongBao>();
		try {
			while (rs.next()) {
				ThongBao tb = new ThongBao();
				tb.setChuDe(rs.getString("chuDe"));
				tb.setNoiDung(rs.getString("noiDung"));
				tb.setThoiGian(rs.getString("thoiGian"));
				tb.setLoaiGopY(rs.getInt("loaiGopY"));
				list.add(tb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
