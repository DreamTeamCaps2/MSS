package model.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.bean.DiaDiem;

public class DiaDiemDAO extends DBHelper{
	
	public ArrayList<DiaDiem> getListDiaDiem(){
		connect();
		
		String sql = "Select * from BenhVien ";
		String sql1 = "Select nt.manhathuoc, TenNhaThuoc, KinhDo, ViDo, sdt, diachi from TaiKhoan tk inner join nhathuoc nt on tk.matk=nt.manhathuoc ";
		String sql2 = "Select Maphongkham,TenPhongKham,mota, thoigian, KinhDo, ViDo, sdt, diachi from TaiKhoan tk inner join PHONGKHAM nt on tk.matk=nt.MaPhongKham";
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			Statement stmt1 = connection.createStatement();
			rs1 = stmt1.executeQuery(sql1);
			Statement stmt2 = connection.createStatement();
			rs2 = stmt2.executeQuery(sql2);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<DiaDiem> diadiem= new ArrayList<DiaDiem>();
		DiaDiem bv;
		DiaDiem nt;
		DiaDiem pk;
		try {
			while (rs.next()) {
				bv = new DiaDiem();
				bv.setMaDiaDiem(rs.getInt("MaBenhVien"));
				bv.setTen(rs.getString("TenBenhVien"));
				bv.setDiaChi(rs.getString("DiaChi"));
				bv.setMota(rs.getString("mota"));
				bv.setSdt(rs.getString("SDT"));
				bv.setLongi(rs.getFloat("KinhDo"));
				bv.setLati(rs.getFloat("ViDo"));
				bv.setLoai("1");
				diadiem.add(bv);
			
			}
			while (rs1.next()) {
				nt = new DiaDiem();
				nt.setMaDiaDiem(rs1.getInt("MaNhaThuoc"));
				nt.setTen(rs1.getString("TenNhaThuoc"));
				nt.setDiaChi(rs1.getString("DiaChi"));
				nt.setSdt(rs1.getString("SDT"));
				nt.setLongi(rs1.getFloat("KinhDo"));
				nt.setLati(rs1.getFloat("ViDo"));
				nt.setLoai("2");
				diadiem.add(nt);
		
			
			}
			while (rs2.next()) {
				pk = new DiaDiem();
				pk.setMaDiaDiem(rs2.getInt("MaPhongKham"));
				pk.setTen(rs2.getString("TenPhongKham"));
				pk.setThoiGian(rs2.getString("thoigian"));
				pk.setMota(rs2.getString("mota"));
				pk.setDiaChi(rs2.getString("DiaChi"));
				pk.setSdt(rs2.getString("SDT"));
				pk.setLongi(rs2.getFloat("KinhDo"));
				pk.setLati(rs2.getFloat("ViDo"));
				pk.setLoai("3");
				diadiem.add(pk);
			
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return diadiem;
	}


	public void json() throws JSONException {
		connect();
		String sql = "Select * from BenhVien ";
		String sql1 = "Select nt.manhathuoc, TenNhaThuoc, KinhDo, ViDo, sdt, diachi from TaiKhoan tk inner join nhathuoc nt on tk.matk=nt.manhathuoc ";
		String sql2 = "Select Maphongkham,TenPhongKham,mota, thoigian, KinhDo, ViDo, sdt, diachi from TaiKhoan tk inner join PHONGKHAM nt on tk.matk=nt.MaPhongKham";
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			Statement stmt1 = connection.createStatement();
			rs1 = stmt1.executeQuery(sql1);
			Statement stmt2 = connection.createStatement();
			rs2 = stmt2.executeQuery(sql2);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*ArrayList<ThongBao> list = new ArrayList<ThongBao>();
		ThongBao tb;*/
		ArrayList<DiaDiem> benhvien= new ArrayList<DiaDiem>();
		ArrayList<DiaDiem> nhathuoc= new ArrayList<DiaDiem>();
		ArrayList<DiaDiem> phongkham= new ArrayList<DiaDiem>();
		DiaDiem bv;
		DiaDiem nt;
		DiaDiem pk;
		try {
			while (rs.next()) {
				bv = new DiaDiem();
				bv.setMaDiaDiem(rs.getInt("MaBenhVien"));
				bv.setTen(rs.getString("TenBenhVien"));
				bv.setDiaChi(rs.getString("DiaChi"));
				bv.setMota(rs.getString("mota"));
				bv.setSdt(rs.getString("SDT"));
				bv.setLongi(rs.getFloat("KinhDo"));
				bv.setLati(rs.getFloat("ViDo"));
				benhvien.add(bv);
			}
			while (rs1.next()) {
				nt = new DiaDiem();
				nt.setMaDiaDiem(rs1.getInt("MaNhaThuoc"));
				nt.setTen(rs1.getString("TenNhaThuoc"));
				nt.setDiaChi(rs1.getString("DiaChi"));
				nt.setSdt(rs1.getString("SDT"));
				nt.setLongi(rs1.getFloat("KinhDo"));
				nt.setLati(rs1.getFloat("ViDo"));
				nhathuoc.add(nt);
			}
			while (rs2.next()) {
				pk = new DiaDiem();
				pk.setMaDiaDiem(rs2.getInt("MaPhongKham"));
				pk.setTen(rs2.getString("TenPhongKham"));
				pk.setThoiGian(rs2.getString("thoigian"));
				pk.setMota(rs2.getString("mota"));
				pk.setDiaChi(rs2.getString("DiaChi"));
				pk.setSdt(rs2.getString("SDT"));
				pk.setLongi(rs2.getFloat("KinhDo"));
				pk.setLati(rs2.getFloat("ViDo"));
				phongkham.add(pk);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JSONArray ja = new JSONArray();
		for(int i =0;i<benhvien.size();i++){
			JSONObject js = new JSONObject();
			js.put("ma",benhvien.get(i).getMaDiaDiem());
			js.put("ten", benhvien.get(i).getTen());
			js.put("diachi", benhvien.get(i).getDiaChi());
			js.put("mota", benhvien.get(i).getMota());
			js.put("sdt",benhvien.get(i).getSdt());
			js.put("lat", benhvien.get(i).getLati());
			js.put("longi", benhvien.get(i).getLongi());
			js.put("loai", "1");
			js.put("kc", "");
			ja.put(js);
		}
		for(int i =0;i<nhathuoc.size();i++){
			JSONObject js = new JSONObject();
			js.put("ma",nhathuoc.get(i).getMaDiaDiem());
			js.put("ten", nhathuoc.get(i).getTen());
			js.put("diachi", nhathuoc.get(i).getDiaChi());
			js.put("sdt",nhathuoc.get(i).getSdt());
			js.put("lat", nhathuoc.get(i).getLati());
			js.put("longi", nhathuoc.get(i).getLongi());
			js.put("loai", "2");
			js.put("kc", "");
			ja.put(js);
		}
		
		for(int i =0;i<phongkham.size();i++){
			JSONObject js = new JSONObject();
			js.put("ma",phongkham.get(i).getMaDiaDiem());
			js.put("ten", phongkham.get(i).getTen());
			js.put("mota", phongkham.get(i).getMota());
			js.put("thoigian", phongkham.get(i).getThoiGian());
			js.put("diachi", phongkham.get(i).getDiaChi());
			js.put("sdt",phongkham.get(i).getSdt());
			js.put("lat", phongkham.get(i).getLati());
			js.put("longi", phongkham.get(i).getLongi());
			js.put("loai", "3");
			js.put("kc", "");
			ja.put(js);
		}
		System.out.println(ja.toString());
		try {
			FileWriter file = new FileWriter("WebContent/js/diadiemkc1.json");
			file.write("data= '"+ja.toString()+"';");
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		//System.out.print(obj);

	     

	
	}

	public ArrayList<DiaDiem> getListDiaDiem(String search) {
		// TODO Auto-generated method stub
		String sql = "Select * from BenhVien where tenBenhVien like N'%"+search+"%'";
		String sql1 = "Select nt.manhathuoc, TenNhaThuoc, KinhDo, ViDo, sdt, diachi from TaiKhoan tk inner join nhathuoc nt on tk.matk=nt.manhathuoc where tennhathuoc like N'%"+search+"%'";
		String sql2 = "Select Maphongkham,TenPhongKham,mota, thoigian, KinhDo, ViDo, sdt, diachi from TaiKhoan tk inner join PHONGKHAM nt on tk.matk=nt.MaPhongKham  where tenphongkham like N'%"+search+"%'";
		System.out.println(sql);
		System.out.println(sql1);
		System.out.println(sql2);
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			Statement stmt1 = connection.createStatement();
			rs1 = stmt1.executeQuery(sql1);
			Statement stmt2 = connection.createStatement();
			rs2 = stmt2.executeQuery(sql2);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*ArrayList<ThongBao> list = new ArrayList<ThongBao>();
		ThongBao tb;*/
		ArrayList<DiaDiem> diadiem= new ArrayList<DiaDiem>();
		DiaDiem bv;
		DiaDiem nt;
		DiaDiem pk;
		try {
			while (rs.next()) {
				bv = new DiaDiem();
				bv.setMaDiaDiem(rs.getInt("MaBenhVien"));
				bv.setTen(rs.getString("TenBenhVien"));
				bv.setDiaChi(rs.getString("DiaChi"));
				bv.setMota(rs.getString("mota"));
				bv.setSdt(rs.getString("SDT"));
				bv.setLongi(rs.getFloat("KinhDo"));
				bv.setLati(rs.getFloat("ViDo"));
				bv.setLoai("1");
				diadiem.add(bv);
			/*	
				tb = new ThongBao();
				tb.setNoiDung(rs.getString("NoiDung"));
				tb.setLati(rs.getFloat("lati"));
				tb.setLongi(rs.getFloat("longii"));
				// tb.setThoiGian(rs.getString("ThoiGian"));
				list.add(tb);*/
			
			}
			while (rs1.next()) {
				nt = new DiaDiem();
				nt.setMaDiaDiem(rs1.getInt("MaNhaThuoc"));
				nt.setTen(rs1.getString("TenNhaThuoc"));
				nt.setDiaChi(rs1.getString("DiaChi"));
				nt.setSdt(rs1.getString("SDT"));
				nt.setLongi(rs1.getFloat("KinhDo"));
				nt.setLati(rs1.getFloat("ViDo"));
				nt.setLoai("2");
				diadiem.add(nt);
		
			
			}
			while (rs2.next()) {
				pk = new DiaDiem();
				pk.setMaDiaDiem(rs2.getInt("MaPhongKham"));
				pk.setTen(rs2.getString("TenPhongKham"));
				pk.setThoiGian(rs2.getString("thoigian"));
				pk.setMota(rs2.getString("mota"));
				pk.setDiaChi(rs2.getString("DiaChi"));
				pk.setSdt(rs2.getString("SDT"));
				pk.setLongi(rs2.getFloat("KinhDo"));
				pk.setLati(rs2.getFloat("ViDo"));
				pk.setLoai("3");
				diadiem.add(pk);
			
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return diadiem;
	}
	public static void main(String[] args) throws JSONException {
		DiaDiemDAO tb = new DiaDiemDAO();
		tb.json();
	}


	public ArrayList<DiaDiem> getListBenhVienSearch(String search) {

		// TODO Auto-generated method stub
		String sql = "Select * from BenhVien where tenBenhVien like N'%"+search+"%'";
		
		ResultSet rs = null;
	
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*ArrayList<ThongBao> list = new ArrayList<ThongBao>();
		ThongBao tb;*/
		ArrayList<DiaDiem> diadiem= new ArrayList<DiaDiem>();
		DiaDiem bv;
	
		try {
			while (rs.next()) {
				bv = new DiaDiem();
				bv.setMaDiaDiem(rs.getInt("MaBenhVien"));
				bv.setTen(rs.getString("TenBenhVien"));
				bv.setDiaChi(rs.getString("DiaChi"));
				bv.setMota(rs.getString("mota"));
				bv.setSdt(rs.getString("SDT"));
				bv.setLongi(rs.getFloat("KinhDo"));
				bv.setLati(rs.getFloat("ViDo"));
				bv.setLoai("1");
				diadiem.add(bv);
			
			
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return diadiem;
	}
	public ArrayList<DiaDiem> getListNhaThuocSearch(String search) {

		// TODO Auto-generated method stub
		String sql1 = "Select nt.manhathuoc, TenNhaThuoc, KinhDo, ViDo, sdt, diachi from TaiKhoan tk inner join nhathuoc nt on tk.matk=nt.manhathuoc where tennhathuoc like N'%"+search+"%'";
		
		System.out.println(sql1);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql1);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*ArrayList<ThongBao> list = new ArrayList<ThongBao>();
		ThongBao tb;*/
		ArrayList<DiaDiem> diadiem= new ArrayList<DiaDiem>();
		DiaDiem nt;
		try {
			
			while (rs.next()) {
				nt = new DiaDiem();
				nt.setMaDiaDiem(rs.getInt("MaNhaThuoc"));
				nt.setTen(rs.getString("TenNhaThuoc"));
				nt.setDiaChi(rs.getString("DiaChi"));
				nt.setSdt(rs.getString("SDT"));
				nt.setLongi(rs.getFloat("KinhDo"));
				nt.setLati(rs.getFloat("ViDo"));
				nt.setLoai("2");
				diadiem.add(nt);
		
			
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return diadiem;
	}
	public ArrayList<DiaDiem> getListPhongKhamSearch(String search) {

		// TODO Auto-generated method stub
		String sql2 = "Select Maphongkham,TenPhongKham,mota, thoigian, KinhDo, ViDo, sdt, diachi from TaiKhoan tk inner join PHONGKHAM nt on tk.matk=nt.MaPhongKham  where tenphongkham like N'%"+search+"%'";
		System.out.println(sql2);
		ResultSet rs2 = null;
		try {
			Statement stmt2 = connection.createStatement();
			rs2 = stmt2.executeQuery(sql2);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*ArrayList<ThongBao> list = new ArrayList<ThongBao>();
		ThongBao tb;*/
		ArrayList<DiaDiem> diadiem= new ArrayList<DiaDiem>();
		DiaDiem pk;
		try {
			while (rs2.next()) {
				pk = new DiaDiem();
				pk.setMaDiaDiem(rs2.getInt("MaPhongKham"));
				pk.setTen(rs2.getString("TenPhongKham"));
				pk.setThoiGian(rs2.getString("thoigian"));
				pk.setMota(rs2.getString("mota"));
				pk.setDiaChi(rs2.getString("DiaChi"));
				pk.setSdt(rs2.getString("SDT"));
				pk.setLongi(rs2.getFloat("KinhDo"));
				pk.setLati(rs2.getFloat("ViDo"));
				pk.setLoai("3");
				diadiem.add(pk);
			
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return diadiem;
	}

}
