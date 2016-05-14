package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.bean.BaiViet;
import model.bean.Benh;
import model.bean.LoaiBenh;
import model.bean.LoaiThuoc;
import model.bean.NhomThuoc;
import model.bean.Thuoc;
import model.bean.ThuocBenh;
import model.bean.TrieuChung;
import model.bean.TrieuChungBenh;


import java.text.Normalizer;  
import java.text.Normalizer.Form;  
import java.util.Locale;  
import java.util.regex.Pattern;  

public class GetJSONDAO extends DBHelper{
	
	public String getThuoc() throws JSONException{
		connect();
		String sql="select MaThuoc,MaNhomThuoc, TenThuoc, TenKhoaHoc,CongThuc, DieuChe, TinhChat,  TacDung, ChiDinh, BaoQuan, ThanTrong, DDH from THUOC";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);}
		catch(SQLException e){
			e.printStackTrace();
		}
		ArrayList<Thuoc> arr = new ArrayList<Thuoc>();
		Thuoc obj;
		try {
			while(rs.next()){
				obj = new Thuoc();
			
				obj.setTenThuoc(rs.getString("TenThuoc"));
				obj.setMaThuoc(rs.getInt("MaThuoc"));
				obj.setTenKhoaHoc(rs.getString("TenKhoaHoc"));
				obj.setCongThuc(rs.getString("CongThuc"));
				obj.setDieuChe(rs.getString("DieuChe"));
				obj.setTinhChat(rs.getString("TinhChat"));
				obj.setTacDung(rs.getString("TacDung"));
				obj.setChiDinh(rs.getString("Chidinh"));
				obj.setMaNhomThuoc(rs.getInt("MaNhomThuoc"));
				obj.setBaoQuan(rs.getString("BaoQuan"));
				obj.setThanTrong(rs.getString("ThanTrong"));
				obj.setDDH(rs.getString("DDH"));
				arr.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JSONArray ja = new JSONArray();
		for(int i =0;i<arr.size();i++){
			JSONObject js = new JSONObject();
			js.put("MaThuoc",arr.get(i).getMaThuoc());
			js.put("TenThuoc", arr.get(i).getTenThuoc());
			js.put("TenKhoaHoc", arr.get(i).getTenKhoaHoc()+"");
			js.put("CongThuc", arr.get(i).getCongThuc()+"");
			js.put("DieuChe",arr.get(i).getDieuChe()+"");
			js.put("TacDung", arr.get(i).getTacDung()+"");
			js.put("TinhChat", arr.get(i).getTinhChat()+"");
			js.put("Chidinh", arr.get(i).getChiDinh()+"");
			js.put("MaNhomThuoc", arr.get(i).getMaNhomThuoc()+"");
			js.put("BaoQuan", arr.get(i).getBaoQuan()+"");
			js.put("ThanTrong", arr.get(i).getThanTrong()+"");
			js.put("DDH", arr.get(i).getDDH()+"");
			js.put("Thich","0");
			ja.put(js);
			}
		System.out.println(ja);
		return ja.toString();
		
}
	public String getBenh() throws JSONException{
		connect();
		String sql="select  MaBenh, TenBenh, DinhNghia, NguyenNhan, ChanDoan, BienChung, DieuTri, CheDoDinhDuong, MaLoaiBenh from Benh";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);}
		catch(SQLException e){
			e.printStackTrace();
		}
		ArrayList<Benh> arr = new ArrayList<Benh>();
		Benh obj;
		try {
			while(rs.next()){
				obj = new Benh();
			
				obj.setTenBenh(rs.getString("TenBenh"));
				obj.setMaBenh(rs.getInt("MaBenh"));
				obj.setDinhNghia(rs.getString("DinhNghia"));
				obj.setNguyenNhan(rs.getString("NguyenNhan"));
				obj.setChanDoan(rs.getString("ChanDoan"));
				obj.setBienChung(rs.getString("BienChung"));
				obj.setDieuTri(rs.getString("DieuTri"));
				obj.setCheDoDinhDuong(rs.getString("CheDoDinhDuong"));
				obj.setMaLoaiBenh(rs.getInt("MaLoaiBenh"));
				arr.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JSONArray ja = new JSONArray();
		for(int i =0;i<arr.size();i++){
			JSONObject js = new JSONObject();
			js.put("MaBenh",arr.get(i).getMaBenh());
			js.put("TenBenh", arr.get(i).getTenBenh());
			js.put("DinhNghia", arr.get(i).getDinhNghia()+"");
			js.put("NguyenNhan", arr.get(i).getNguyenNhan()+"");
			js.put("ChanDoan",arr.get(i).getChanDoan()+"");
			js.put("BienChung", arr.get(i).getBienChung()+"");
			js.put("DieuTri", arr.get(i).getDieuTri()+"");
			js.put("CheDoDinhDuong", arr.get(i).getCheDoDinhDuong()+"");
			js.put("MaLoaiBenh", arr.get(i).getMaLoaiBenh()+"");
			js.put("Thich","0");
			ja.put(js);
			}
		return ja.toString();
		
}
	public String getTrieuChung() throws JSONException{
		connect();
		String sql="select * from TrieuChung";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);}
		catch(SQLException e){
			e.printStackTrace();
		}
		ArrayList<TrieuChung> arr = new ArrayList<TrieuChung>();
		TrieuChung obj;
		try {
			while(rs.next()){
				obj = new TrieuChung();
			
				obj.setTenTrieuChung(rs.getString(2));
				obj.setMaTrieuChung(rs.getInt(1));
				
				arr.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JSONArray ja = new JSONArray();
		for(int i =0;i<arr.size();i++){
			JSONObject js = new JSONObject();
			js.put("MaTrieuChung",arr.get(i).getMaTrieuChung());
			js.put("TenTrieuChung", arr.get(i).getTenTrieuChung());
			
			ja.put(js);
			}
		return ja.toString();
		
}
	
	public String getLoaiBenh() throws JSONException{
		connect();
		String sql="select * from LoaiBenh";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);}
		catch(SQLException e){
			e.printStackTrace();
		}
		ArrayList<LoaiBenh> arr = new ArrayList<LoaiBenh>();
		LoaiBenh obj;
		try {
			while(rs.next()){
				obj = new LoaiBenh();
			
				obj.setTenLoaiBenh(rs.getString(2));
				obj.setMaLoaiBenh(rs.getInt(1));
				
				arr.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JSONArray ja = new JSONArray();
		for(int i =0;i<arr.size();i++){
			JSONObject js = new JSONObject();
			js.put("MaLoaiBenh",arr.get(i).getMaLoaiBenh());
			js.put("TenLoaiBenh", arr.get(i).getTenLoaiBenh());
			
			ja.put(js);
			}
		return ja.toString();
		
}
	public String getLoaiThuoc() throws JSONException{
		connect();
		String sql="select * from LoaiThuoc";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);}
		catch(SQLException e){
			e.printStackTrace();
		}
		ArrayList<LoaiThuoc> arr = new ArrayList<LoaiThuoc>();
		LoaiThuoc obj;
		try {
			while(rs.next()){
				obj = new LoaiThuoc();
			
				obj.setTenLoaiThuoc(rs.getString(2));
				obj.setMaLoaiThuoc(rs.getInt(1));
				
				arr.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JSONArray ja = new JSONArray();
		for(int i =0;i<arr.size();i++){
			JSONObject js = new JSONObject();
			js.put("MaLoaiThuoc",arr.get(i).getMaLoaiThuoc());
			js.put("TenLoaiThuoc", arr.get(i).getTenLoaiThuoc());
			
			ja.put(js);
			}
		return ja.toString();
		
}
	public String getNhomThuoc() throws JSONException{
		connect();
		String sql="select * from NhomThuoc";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);}
		catch(SQLException e){
			e.printStackTrace();
		}
		ArrayList<NhomThuoc> arr = new ArrayList<NhomThuoc>();
		NhomThuoc obj;
		try {
			while(rs.next()){
				obj = new NhomThuoc();
			
				obj.setTenNhomThuoc(rs.getString(2));
				obj.setMaNhomThuoc(rs.getInt(1));
				obj.setMaLoaiThuoc(rs.getInt("MaLoaiThuoc"));
				arr.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JSONArray ja = new JSONArray();
		for(int i =0;i<arr.size();i++){
			JSONObject js = new JSONObject();
			js.put("MaNhomThuoc",arr.get(i).getMaNhomThuoc());
			js.put("TenNhomThuoc", arr.get(i).getTenNhomThuoc());
			js.put("MaLoaiThuoc", arr.get(i).getMaLoaiThuoc());
			ja.put(js);
			}
		return ja.toString();
		
}
	public String getTrieuChungBenh() throws JSONException{
		connect();
		String sql="select * from TrieuChungBenh";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);}
		catch(SQLException e){
			e.printStackTrace();
		}
		ArrayList<TrieuChungBenh> arr = new ArrayList<TrieuChungBenh>();
		TrieuChungBenh obj;
		try {
			while(rs.next()){
				obj = new TrieuChungBenh();
			
				obj.setMaBenh(rs.getInt(1));
				obj.setMaTrieuChung(rs.getInt(2));
				
				arr.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JSONArray ja = new JSONArray();
		for(int i =0;i<arr.size();i++){
			JSONObject js = new JSONObject();
			js.put("MaBenh",arr.get(i).getMaBenh());
			js.put("MaTrieuChung", arr.get(i).getMaTrieuChung());
			
			ja.put(js);
			}
		return ja.toString();
		
	}
	public String getThuocBenh() throws JSONException{
		connect();
		String sql="select * from ThuocBenh";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);}
		catch(SQLException e){
			e.printStackTrace();
		}
		ArrayList<ThuocBenh> arr = new ArrayList<ThuocBenh>();
		ThuocBenh obj;
		try {
			while(rs.next()){
				obj = new ThuocBenh();
			
				obj.setMaBenh(rs.getInt(2));
				obj.setMaThuoc(rs.getInt(1));
				
				arr.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JSONArray ja = new JSONArray();
		for(int i =0;i<arr.size();i++){
			JSONObject js = new JSONObject();
			js.put("MaBenh",arr.get(i).getMaBenh());
			js.put("MaThuoc", arr.get(i).getMaThuoc());
			
			ja.put(js);
			}
		return ja.toString();
	}
	
	public String getBaiViet() throws JSONException{
		connect();
		String sql = "Select * FROM BAIVIET ORDER BY MaBaiViet DESC";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<BaiViet> arr = new ArrayList<BaiViet>();
		BaiViet ch;
		try {
			while (rs.next()) {
				ch = new BaiViet();
				ch.setMaBaiViet(rs.getInt("MaBaiViet"));
				ch.setTieuDe(rs.getString("TieuDe")+"");
				ch.setHinhAnh(rs.getString("HinhAnh")+"");
				ch.setTomTat(rs.getString("TomTat")+"");
				ch.setLuotXem(rs.getInt("LuotXem"));
				ch.setThoiGian(rs.getString("ThoiGian")+"");
				ch.setNoiDung(rs.getString("NoiDung"));
				arr.add(ch);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JSONArray ja = new JSONArray();
		for(int i =0;i<arr.size();i++){
			JSONObject js = new JSONObject();
			js.put("MaBaiViet",arr.get(i).getMaBaiViet());
			js.put("TieuDe", arr.get(i).getTieuDe());
			js.put("TomTat", arr.get(i).getTomTat()+"");
			js.put("LuotXem", arr.get(i).getLuotXem());
			js.put("NoiDung", arr.get(i).getNoiDung());
			js.put("HinhAnh", "http://192.168.43.57:8080/MSS/images/"+arr.get(i).getHinhAnh());
			js.put("ThoiGian", arr.get(i).getThoiGian()+"");
			ja.put(js);
		}
		return ja.toString();
	}
	
	
	public String getJSON() throws JSONException{
		
		GetJSONDAO get= new GetJSONDAO();
		String benh=get.getBenh();
		String thuoc= get.getThuoc();
		String trieuChung= get.getTrieuChung();
		String trieuChungBenh = get.getTrieuChungBenh();
		String thuocBenh = get.getThuocBenh();
		String loaiBenh = get.getLoaiBenh();
		String nhomThuoc= get.getNhomThuoc();
		String loaiThuoc= get.getLoaiThuoc();
		String baiViet = get.getBaiViet();
		String test = "{"
				+ "\"benh\":"+benh+","
				+ "\"baiViet\":"+baiViet+","
				+ "\"thuoc\":"+thuoc+","
				+ "\"trieuChung\":"+trieuChung+","
				+ "\"trieuChungBenh\":"+trieuChungBenh+","
				+ "\"thuocBenh\":"+thuocBenh+","
				+ "\"loaiBenh\":"+loaiBenh+","
				+ "\"nhomThuoc\":"+nhomThuoc+","
				+ "\"loaiThuoc\":"+loaiThuoc+""
				+ "}";
		JSONObject mainOb= new JSONObject();
//		mainOb.put("benh", benh);
//		mainOb.put("trieuChung", trieuChung);
//		mainOb.put("trieuChungThuoc", trieuChungThuoc );
//		mainOb.put("thuocBenh", thuocBenh);
//		mainOb.put("loaiBenh", loaiBenh);
//		mainOb.put("nhomThuoc", nhomThuoc);
//		mainOb.put("loaiThuoc", loaiThuoc);
//		mainOb.put("thuoc", thuoc);
		System.out.println(test);
		return test;
		
	}
	public String getCapNhat() throws JSONException{
		connect();
		String sql="select * from phienban";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);}
		catch(SQLException e){
			e.printStackTrace();
		}
		ArrayList<LoaiThuoc> arr = new ArrayList<LoaiThuoc>();
		LoaiThuoc obj;
		try {
			while(rs.next()){
				obj = new LoaiThuoc();
				obj.setMaLoaiThuoc(rs.getInt(1));
				arr.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JSONArray ja = new JSONArray();
		for(int i =0;i<arr.size();i++){
			JSONObject js = new JSONObject();
			js.put("PhienBan",arr.get(i).getMaLoaiThuoc());
			
			
			ja.put(js);
			}
		return ja.toString();
	}

	public void updateJSON(){
		connect();
		String sql="update PHIENBAN set phienban=phienban+1";
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
			}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static int getWeek() {
        return Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
    }
	
	
	public static void main(String[] args) throws JSONException {
		GetJSONDAO d = new GetJSONDAO();
		//System.out.println(d.getBaiViet());
		//System.out.println(d.getLoaiThuoc());
		//System.out.println(d.makeSlug("tên là việt"));
	}
}