package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.StringTokenizer;

import model.bean.Benh;
import model.bean.LoaiThuoc;
import model.bean.NhomThuoc;
import model.bean.Thuoc;

public class ThuocDAO extends DBHelper {
	
	
	//VIET
	public ArrayList<Thuoc> getListThuocTimKiem(String timKiem) {
		connect();
		String sql2 = "Select  luotXem,maThuoc,tenThuoc,hinhAnh"
				+ " from Thuoc where ";
		StringTokenizer strTkn = new StringTokenizer(timKiem, "+");
		ArrayList<String> arrLis = new ArrayList<String>(timKiem.length());
		while(strTkn.hasMoreTokens())
			arrLis.add(strTkn.nextToken());
		if(arrLis.size()==1){
			
				sql2=sql2+"tenThuoc like  N'%"+arrLis.get(0)+"%'";
			
		}
		else{
			for(int i=0;i<arrLis.size();i++){
				if(i==arrLis.size()-1)
					sql2=sql2+"tenThuoc like  N'%"+arrLis.get(i)+"%'  ";
				else
					sql2=sql2+"tenThuoc like  N'%"+arrLis.get(i)+"%' or ";
			}
		}
		System.out.println(sql2);

		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<Thuoc> list = new ArrayList<Thuoc>();
		Thuoc thuoc;
		try {
			while(rs.next()){
				thuoc = new Thuoc();
				String name=rs.getString("tenThuoc");
				int maThuoc = rs.getInt("maThuoc");
				String hinhAnh=rs.getString("HinhAnh");
				
				thuoc.setTenThuoc(name);
				thuoc.setMaThuoc(maThuoc);
				thuoc.setHinhAnh(hinhAnh);
				thuoc.setLuotXem(rs.getInt("LuotXem"));

				list.add(thuoc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<Thuoc> getListThuocLienQuanBenh(int ma) {
		connect();
		String sql2 = "Select mathuoc ,tenthuoc from Thuoc where mathuoc in (select mathuoc from THUOCBENH where mabenh="+ma+")";

		System.out.println(sql2);

		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<Thuoc> list = new ArrayList<Thuoc>();
		Thuoc thuoc;
		try {
			while(rs.next()){
				thuoc = new Thuoc();
				String name=rs.getString("tenThuoc");
				int maThuoc = rs.getInt("maThuoc");

				thuoc.setTenThuoc(name);
				thuoc.setMaThuoc(maThuoc);

				list.add(thuoc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<Thuoc> getListThuocNhomThuoc(int maNhomThuoc) {
		// TODO Auto-generated method stub
		connect();
		String sql2;
		if(maNhomThuoc==0){
			sql2="Select * from Thuoc";
		}
		else{
			sql2="Select * from Thuoc where MaNhomThuoc ="+maNhomThuoc;
		}



		System.out.println(sql2);

		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<Thuoc> list = new ArrayList<Thuoc>();
		Thuoc thuoc;
		try {
			while(rs.next()){
				thuoc = new Thuoc();
				String name=rs.getString("tenThuoc");
				String tenKhoaHoc= rs.getString("tenKhoaHoc");
				String congThuc= rs.getString("congThuc");
				String dieuChe= rs.getString("dieuChe");
				String tinhChat= rs.getString("tinhChat");
				String tacDung= rs.getString("tacdung");
				String chiDinh=rs.getString("chidinh");
				String baoQuan=rs.getString("baoquan");
				String thanTrong= rs.getString("thantrong");
				String ddh= rs.getString("ddh");
				String hinhAnh=rs.getString("hinhanh");
				thuoc.setMaThuoc(rs.getInt("maThuoc"));
				thuoc.setTenThuoc(name);
				thuoc.setTenKhoaHoc(tenKhoaHoc);
				thuoc.setCongThuc(congThuc);
				thuoc.setDieuChe(dieuChe);
				thuoc.setTinhChat(tinhChat);
				thuoc.setTacDung(tacDung);
				thuoc.setChiDinh(chiDinh);
				thuoc.setBaoQuan(baoQuan);
				thuoc.setThanTrong(thanTrong);
				thuoc.setDDH(ddh);
				thuoc.setMaNhomThuoc(maNhomThuoc);
				thuoc.setHinhAnh(hinhAnh);
				thuoc.setLuotXem(10000);
				thuoc.setNgayCapNhat("4/11/2016");
				list.add(thuoc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<Thuoc> getListThuocLoaiThuoc(int maLoaiThuoc) {
		connect();
		String sql2;
		sql2="Select * from Thuoc where MaNhomThuoc in( Select MaNhomThuoc from NHOMTHUOC where MaLoaiThuoc  ="+maLoaiThuoc+" )";

		System.out.println(sql2);

		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<Thuoc> list = new ArrayList<Thuoc>();
		Thuoc thuoc;
		try {
			while(rs.next()){
				thuoc = new Thuoc();
				String name=rs.getString("tenThuoc");
				String tenKhoaHoc= rs.getString("tenKhoaHoc");
				String congThuc= rs.getString("congThuc");
				String dieuChe= rs.getString("dieuChe");
				String tinhChat= rs.getString("tinhChat");
				String tacDung= rs.getString("tacdung");
				String chiDinh=rs.getString("chidinh");
				String baoQuan=rs.getString("baoquan");
				String thanTrong= rs.getString("thantrong");
				String ddh= rs.getString("ddh");
				String hinhAnh=rs.getString("hinhanh");
				thuoc.setMaThuoc(rs.getInt("maThuoc"));
				thuoc.setTenThuoc(name);
				thuoc.setTenKhoaHoc(tenKhoaHoc);
				thuoc.setCongThuc(congThuc);
				thuoc.setDieuChe(dieuChe);
				thuoc.setTinhChat(tinhChat);
				thuoc.setTacDung(tacDung);
				thuoc.setChiDinh(chiDinh);
				thuoc.setBaoQuan(baoQuan);
				thuoc.setThanTrong(thanTrong);
				thuoc.setDDH(ddh);
				thuoc.setHinhAnh(hinhAnh);
				thuoc.setLuotXem(10000);
				thuoc.setNgayCapNhat("4/11/2016");
				list.add(thuoc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//TUAN
	public ArrayList<LoaiThuoc> getListLoaiThuoc() {
		
		connect();
		String sql2 = "SELECT * FROM LOAITHUOC";
		
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<LoaiThuoc> list = new ArrayList<LoaiThuoc>();
		LoaiThuoc lt;
		try {
			while(rs.next()){
				lt = new LoaiThuoc();
				lt.setMaLoaiThuoc(rs.getInt("MaLoaiThuoc"));
				lt.setTenLoaiThuoc(rs.getString("TenLoaiThuoc"));
				list.add(lt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<NhomThuoc> getListNhomThuoc(int maLoaiThuoc) {
		
		connect();
		String sql2 = "";
		if(maLoaiThuoc == 0)
			sql2 = "SELECT MaNhomThuoc,TenNhomThuoc FROM NhomThuoc";
		else
			sql2 = "SELECT MaNhomThuoc,TenNhomThuoc FROM NhomThuoc WHERE MaLoaiThuoc = "+maLoaiThuoc;
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<NhomThuoc> list = new ArrayList<NhomThuoc>();
		NhomThuoc nt;
		try {
			while(rs.next()){
				nt = new NhomThuoc();
				nt.setMaNhomThuoc(rs.getInt("MaNhomThuoc"));
				nt.setTenNhomThuoc(rs.getString("TenNhomThuoc"));
				list.add(nt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<Thuoc> getListThuoc() {
		
		connect();
//		String sql2 = "SELECT tt.MaThuoc,tt.TenThuoc, lt.TenLoaiThuoc, nt.TenNhomThuoc "
//				+ "FROM THUOC tt INNER JOIN NHOMTHUOC nt ON tt.MaNhomThuoc = nt.MaNhomThuoc "
//				+ "INNER JOIN LOAITHUOC lt ON nt.MaLoaiThuoc = lt.MaLoaiThuoc";
		String sql2 = "SELECT THUOC.MaThuoc,THUOC.TenThuoc, lt.TenLoaiThuoc, nt.TenNhomThuoc "
				+ "FROM THUOC  INNER JOIN NHOMTHUOC nt ON THUOC.MaNhomThuoc = nt.MaNhomThuoc "
				+ "INNER JOIN LOAITHUOC lt ON nt.MaLoaiThuoc = lt.MaLoaiThuoc";
		
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<Thuoc> list = new ArrayList<Thuoc>();
		Thuoc t;
		try {
			while(rs.next()){
				t = new Thuoc();
				t.setMaThuoc(rs.getInt("MaThuoc"));
				t.setTenThuoc(rs.getString("TenThuoc"));
				t.setTenLoaiThuoc(rs.getString("TenLoaiThuoc"));
				t.setTenNhomThuoc(rs.getString("TenNhomThuoc"));
				list.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<Thuoc> getListThuoc(int maBenh)
	{
		
		connect();
		String sql2 = String.format("SELECT THUOC.MaThuoc,THUOC.TenThuoc "
						+ "FROM THUOC  INNER JOIN THUOCBENH ON THUOC.MaThuoc = THUOCBENH.MaThuoc "
						+ 				"INNER JOIN BENH ON THUOCBENH.MaBenh = BENH.MaBenh "
						+ "WHERE THUOCBENH.MaBenh = %s",maBenh);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<Thuoc> list = new ArrayList<Thuoc>();
		Thuoc t;
		try {
			while(rs.next()){
				t = new Thuoc();
				t.setMaThuoc(rs.getInt("MaThuoc"));
				t.setTenThuoc(rs.getString("TenThuoc"));
				list.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<Thuoc> getListThuoc(String timThuoc,int maLoaiThuoc, int maNhomThuoc)
	{
		connect();
		String sql2 = "SELECT THUOC.MaThuoc,THUOC.TenThuoc, lt.TenLoaiThuoc, nt.TenNhomThuoc "
						+ "FROM THUOC  INNER JOIN NHOMTHUOC nt ON THUOC.MaNhomThuoc = nt.MaNhomThuoc "
						+ "INNER JOIN LOAITHUOC lt ON nt.MaLoaiThuoc = lt.MaLoaiThuoc "
						+ "WHERE THUOC.TenThuoc LIKE N'%"+timThuoc+"%'";
		if(maNhomThuoc != 0)
			sql2 = sql2 + "AND nt.MaNhomThuoc = "+maNhomThuoc;
		else if(maLoaiThuoc != 0)
			sql2 = sql2 + "AND nt.MaLoaiThuoc = "+maLoaiThuoc;
		
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<Thuoc> list = new ArrayList<Thuoc>();
		Thuoc t;
		try {
			while(rs.next()){
				t = new Thuoc();
				t.setMaThuoc(rs.getInt("MaThuoc"));
				t.setTenThuoc(rs.getString("TenThuoc"));
				t.setTenLoaiThuoc(rs.getString("TenLoaiThuoc"));
				t.setTenNhomThuoc(rs.getString("TenNhomThuoc"));
				list.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Thuoc getThuoc(int maThuoc)
	{
		connect();
		String sql2 = String.format("SELECT t.LuotXem,t.TenThuoc,t.CongThuc,t.TenKhoaHoc,t.DieuChe,t.TinhChat,t.TacDung,t.ChiDinh,t.BaoQuan,t.ThanTrong,t.DDH,t.MaNhomThuoc,nt.MaLoaiThuoc "
				+ "FROM THUOC t INNER JOIN NHOMTHUOC nt ON t.MaNhomThuoc = nt.MaNhomThuoc"
				+ " WHERE MaThuoc = %s",maThuoc);
		
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Thuoc t = new Thuoc();
		try {
			while(rs.next()){
				t.setMaThuoc(maThuoc);
				t.setTenThuoc(rs.getString("TenThuoc"));
				t.setCongThuc(rs.getString("CongThuc"));
				t.setTenKhoaHoc(rs.getString("TenKhoaHoc"));
				t.setDieuChe(rs.getString("DieuChe"));
				t.setTinhChat(rs.getString("TinhChat"));
				t.setTacDung(rs.getString("TacDung"));
				t.setChiDinh(rs.getString("ChiDinh"));
				t.setBaoQuan(rs.getString("BaoQuan"));
				t.setThanTrong(rs.getString("ThanTrong"));
				t.setDDH(rs.getString("DDH"));
				t.setMaNhomThuoc(rs.getInt("MaNhomThuoc"));
				t.setMaLoaiThuoc(rs.getInt("MaLoaiThuoc"));
				t.setLuotXem(rs.getInt("LuotXem"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}
	
	
	public void themThuoc(String tenThuoc, String congThuc, String tenKhoaHoc, String dieuChe, String tinhChat, String tacDung, String chiDinh, String baoQuan, String thanTrong, String DDH, int maNhomThuoc, int trangThai)
	{
		connect();
	    String sql =String.format("Insert into THUOC (TenThuoc,CongThuc,TenKhoaHoc,DieuChe,TinhChat,TacDung,ChiDinh,BaoQuan,ThanTrong,DDH,MaNhomThuoc,TrangThai) "
	    		+ "VALUES (N'%s',N'%s',N'%s',N'%s',N'%s',N'%s',N'%s',N'%s',N'%s',N'%s',%s,%s)",
	    		tenThuoc,congThuc,tenKhoaHoc,dieuChe,tinhChat,tacDung,chiDinh,baoQuan,thanTrong,DDH,maNhomThuoc,trangThai);
	    try {
	        Statement stmt = connection.createStatement();
	        stmt.executeUpdate(sql);
	    } catch (SQLException e) {
	        e.printStackTrace();    
	    }
	    System.out.println("Da them thuoc");
	}
	public void themThuocBenh(String tenThuoc, ArrayList<Benh> listBenh)
	{
		if(listBenh.size()!=0)
		{
			connect();
			for(int i=0; i<listBenh.size();i++)
			{
			    String sql =String.format("Insert into THUOCBENH (MaThuoc,MaBenh) "
			    		+ "VALUES ((SELECT MaThuoc FROM THUOC WHERE TenThuoc = N'%s'),%s)",tenThuoc,listBenh.get(i).getMaBenh());
			    try {
			        Statement stmt = connection.createStatement();
			        stmt.executeUpdate(sql);
			    } catch (SQLException e) {
			        e.printStackTrace();    
			    }
			}
		}
	}
	public void suaThuoc(int maThuoc, String tenThuoc, String congThuc, String tenKhoaHoc, String dieuChe, String tinhChat, String tacDung, String chiDinh, String baoQuan, String thanTrong, String DDH, int maNhomThuoc)
	{
		connect();
	    String sql =String.format("UPDATE THUOC "
	    		+ "SET TenThuoc=N'%s', CongThuc=N'%s', TenKhoaHoc=N'%s', DieuChe=N'%s', TinhChat=N'%s', TacDung=N'%s', ChiDinh=N'%s', BaoQuan=N'%s', ThanTrong=N'%s', DDH=N'%s', MaNhomThuoc= %s "
	    		+ "WHERE MaThuoc = %s",tenThuoc,congThuc,tenKhoaHoc,dieuChe,tinhChat,tacDung,chiDinh,baoQuan,thanTrong,DDH,maNhomThuoc,maThuoc);
		    try {
	        Statement stmt = connection.createStatement();
	        stmt.executeUpdate(sql);
	    } catch (SQLException e) {
	        e.printStackTrace();    
	    }
	    System.out.println("Da sua thuoc");
	}
	
	public void xoaThuoc(int maThuoc)
	{
		connect();
        String sql= String.format("DELETE FROM THUOC WHERE MaThuoc = %s", maThuoc);
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        String sql1= String.format("DELETE FROM THUOCBENH WHERE MaThuoc = %s", maThuoc);
        try {
            Statement stmt1 = connection.createStatement();
            stmt1.executeUpdate(sql1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(sql);
        System.out.println(sql1);
        System.out.println("Xoa thuoc xong 111");
	}
	
	public void xoaThuocBenh(int maBenh)
	{
		connect();
        String sql= String.format("DELETE FROM THUOCBENH WHERE MaBenh = %s", maBenh);
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	//DUC
	public ArrayList<Thuoc> getThuocCuaHang(String maTKDN) {
		connect();
		String sql = "SELECT * FROM NHATHUOC "
				+ "INNER JOIN BANGGIATHUOC ON NHATHUOC.MaNhaThuoc = BANGGIATHUOC.MaNhaThuoc "
				+ "INNER JOIN THUOC ON THUOC.MaThuoc = BANGGIATHUOC.MaThuoc "
				+ "WHERE NHATHUOC.MaNhaThuoc="+maTKDN;
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<Thuoc> listThuoc = new ArrayList<Thuoc>();
		Thuoc thuoc;
		try {
			while (rs.next()) {
				thuoc = new Thuoc();
				thuoc.setTenThuoc(rs.getString("TenThuoc"));
				thuoc.setMaThuoc(rs.getInt("MaThuoc"));
				thuoc.setGiaThuoc(rs.getString("Gia"));
				listThuoc.add(thuoc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listThuoc;
	}

	public void capNhatLuotXem(int ma, int luotXem) {
		// TODO Auto-generated method stub
		connect();
	    String sql =String.format("Update  Thuoc set luotxem = %s "
	    		 +"where maThuoc= %s",luotXem+1,ma);
	    System.out.println("hehe"+sql);
	    try {
	        Statement stmt = connection.createStatement();
	        stmt.executeUpdate(sql);
	    } catch (SQLException e) {
	        e.printStackTrace();    
	    }
	    System.out.println("Cap nhat luot xem thuoc");
	}

	public ArrayList<Thuoc> getListThuocXemNhieu() {
		// TODO Auto-generated method stub
		connect();
		String sql2 = "Select Top (5) luotXem,MaThuoc,TenThuoc,HinhAnh from THUOC order by LuotXem desc";
		
		System.out.println(sql2);

		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<Thuoc> list = new ArrayList<Thuoc>();
		Thuoc thuoc;
		try {
			while(rs.next()){
				thuoc = new Thuoc();
				String name=rs.getString("tenThuoc");
				int maThuoc = rs.getInt("maThuoc");

				thuoc.setTenThuoc(name);
				thuoc.setMaThuoc(maThuoc);
				thuoc.setLuotXem(rs.getInt("luotXem"));
				list.add(thuoc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public int ktTenThuoc(String tenThuoc) {
		connect();
		String sql2 = String.format("SELECT MaThuoc "
				+ "FROM THUOC WHERE TenThuoc = N'%s'",tenThuoc);
		
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
				if(rs.getInt("MaThuoc")==0)
					return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(dem==0)
			return 1;
		return 0;
	}

	public int ktTenThuoc(String tenThuoc, int maThuoc) {
		connect();
		String sql2 = String.format("SELECT MaThuoc ,TenThuoc "
				+ "FROM THUOC WHERE TenThuoc = N'%s' ",tenThuoc);
		System.out.println(sql2);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while(rs.next()){
				if(rs.getInt("MaThuoc") == 0)
					return 1;
				else if(rs.getInt("MaThuoc") == maThuoc)
						return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public ArrayList<NhomThuoc> getListNhomThuoc() {
		connect();
		String sql2 = "Select MaNhomThuoc,TenNhomThuoc,TenLoaiThuoc,NhomThuoc.MaLoaiThuoc from NHOMTHUOC inner join LOAITHUOC on NhomThuoc.MaLoaiThuoc=LOAITHUOC.MaLoaiThuoc";
		
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<NhomThuoc> list = new ArrayList<NhomThuoc>();
		NhomThuoc lt;
		try {
			while(rs.next()){
				lt = new NhomThuoc();
				lt.setMaLoaiThuoc(rs.getInt("MaLoaiThuoc"));
				lt.setTenLoaiThuoc(rs.getString("TenLoaiThuoc"));
				lt.setMaNhomThuoc(rs.getInt("maNhomThuoc"));
				lt.setTenNhomThuoc(rs.getString("tenNhomThuoc"));
				list.add(lt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void themNhomThuoc(String tenNhomThuoc, int maLoaiThuoc) {
		// TODO Auto-generated method stub
		connect();
				if(tenNhomThuoc.indexOf("'")!=-1){
					String t= ""+tenNhomThuoc.charAt(tenNhomThuoc.indexOf("'"));
					tenNhomThuoc=tenNhomThuoc.replaceAll(t, "''" );
					
				}
		String sql="insert into NHOMTHUOC(TenNhomThuoc,MaLoaiThuoc) values (N'"+tenNhomThuoc+"',"+maLoaiThuoc+")";
		 try {
		        Statement stmt = connection.createStatement();
		        stmt.executeUpdate(sql);
		    } catch (SQLException e) {
		        e.printStackTrace();    
		    }
		    System.out.println("Da them nhomThuoc");
	}

	public boolean kiemTraNhomThuoc(int maNhomThuoc) {
		// TODO Auto-generated method stub
		connect();
		String sql2;
		sql2="Select * from Thuoc where MaNhomThuoc ="+maNhomThuoc;



		System.out.println(sql2);

		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while(rs.next()){
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;

	}

	public void xoaNhomThuoc(int maNhomThuoc) {
		// TODO Auto-generated method stub
		connect();
        String sql= String.format("DELETE FROM NhomTHUOC WHERE maNhomThuoc = %s", maNhomThuoc);
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	//DUC
	public ArrayList<Thuoc> getListThuocHeThong(String maTKDN) {
		connect();
//		String sql = "SELECT * FROM NHATHUOC "
//				+ "INNER JOIN BANGGIATHUOC ON NHATHUOC.MaNhaThuoc = BANGGIATHUOC.MaNhaThuoc "
//				+ "INNER JOIN THUOC ON THUOC.MaThuoc = BANGGIATHUOC.MaThuoc "
//				+ "WHERE NHATHUOC.MaNhaThuoc="+maTKDN;
		String sql = "SELECT MaThuoc,TenThuoc FROM THUOC "
				+ "WHERE MaThuoc NOT IN (SELECT MaThuoc From BANGGIATHUOC WHERE MaNhaThuoc="+maTKDN+")";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<Thuoc> listThuoc = new ArrayList<Thuoc>();
		Thuoc thuoc;
		try {
			while (rs.next()) {
				thuoc = new Thuoc();
				thuoc.setTenThuoc(rs.getString("TenThuoc"));
				thuoc.setMaThuoc(rs.getInt("MaThuoc"));
				thuoc.setGiaThuoc("0");
				listThuoc.add(thuoc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listThuoc;
	}

	public void themGiaThuocCuaHang(String maTKDN, String idThuoc, String giaThuoc) {
		connect();
	    String sql =String.format("Insert into BANGGIATHUOC (MaNhaThuoc,MaThuoc,Gia) "
	    		+ "VALUES (%s,%s,'%s')",maTKDN, idThuoc, giaThuoc);
	    System.out.println(sql);
	    try {
	        Statement stmt = connection.createStatement();
	        stmt.executeUpdate(sql);
	    } catch (SQLException e) {
	        e.printStackTrace();    
	    }
	}
	
	//HUNG
	public ArrayList<Thuoc> getGiaListThuoc(int mathuoc) {
		connect();
		String sql=	"select TenNhaThuoc, Gia,nt.manhathuoc from NHATHUOC nt inner join BANGGIATHUOC gt on nt.MaNhaThuoc=gt.MaNhaThuoc "+ 
"inner join THUOC on gt.MaThuoc= thuoc.MaThuoc where thuoc.MaThuoc="+mathuoc;
	
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<Thuoc> list = new ArrayList<Thuoc>();
		Thuoc thuoc;
		try {
			while(rs.next()){
				thuoc = new Thuoc();
				thuoc.setTenTiem(rs.getString(1));
				thuoc.setGiaThuoc(rs.getString(2));
				thuoc.setMaTiem(rs.getString(3));
				
				list.add(thuoc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
		return list;
		
	}
	public ArrayList<Thuoc> getGiaListThuocTheoTen(int mathuoc) {
		connect();
		String sql=	"select TenNhaThuoc, Gia,nt.manhathuoc from NHATHUOC nt inner join BANGGIATHUOC gt on nt.MaNhaThuoc=gt.MaNhaThuoc "+ 
"inner join THUOC on gt.MaThuoc= thuoc.MaThuoc where thuoc.MaThuoc="+mathuoc+" order by tennhathuoc asc";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<Thuoc> list = new ArrayList<Thuoc>();
		Thuoc thuoc;
		try {
			while(rs.next()){
				thuoc = new Thuoc();
				thuoc.setTenTiem(rs.getString(1));
				thuoc.setGiaThuoc(rs.getString(2));
				thuoc.setMaTiem(rs.getString(3));
				
				list.add(thuoc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
		return list;
		
	}

	public ArrayList<Thuoc> getGiaListThuocTheoGia(int mathuoc) {
		connect();
		String sql=	"select TenNhaThuoc, Gia,nt.manhathuoc from NHATHUOC nt inner join BANGGIATHUOC gt on nt.MaNhaThuoc=gt.MaNhaThuoc "+ 
"inner join THUOC on gt.MaThuoc= thuoc.MaThuoc where thuoc.MaThuoc="+mathuoc+" order by gia asc";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<Thuoc> list = new ArrayList<Thuoc>();
		Thuoc thuoc;
		try {
			while(rs.next()){
				thuoc = new Thuoc();
				thuoc.setTenTiem(rs.getString(1));
				thuoc.setGiaThuoc(rs.getString(2));
				thuoc.setMaTiem(rs.getString(3));
				
				list.add(thuoc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public ArrayList<Thuoc> getListThuocTimKiemFilter(String timKiem, boolean luotXem, boolean abc) {
		connect();
		String sql2 = "Select  Thuoc.maNhomThuoc,tenNhomThuoc,luotXem,maThuoc,tenThuoc,hinhAnh"
				+ " from Thuoc inner join NhomThuoc on  Thuoc.MANHOMTHUOC=NHOMTHUOC.maNHomThuoc where ";
		StringTokenizer strTkn = new StringTokenizer(timKiem, "+");
		ArrayList<String> arrLis = new ArrayList<String>(timKiem.length());
		while(strTkn.hasMoreTokens())
			arrLis.add(strTkn.nextToken());
		if(arrLis.size()==1){
			
				sql2=sql2+"tenThuoc like  N'%"+arrLis.get(0)+"%'";
			
		}
		else{
			for(int i=0;i<arrLis.size();i++){
				if(i==arrLis.size()-1)
					sql2=sql2+"tenThuoc like  N'%"+arrLis.get(i)+"%'  ";
				else
					sql2=sql2+"tenThuoc like  N'%"+arrLis.get(i)+"%' or ";
			}
		}
		if (luotXem&&abc){
			sql2=sql2+"  order by luotxem desc,tenThuoc";
		}
		else{
			if(luotXem)
				sql2=sql2+"  order by luotXem desc";
			if(abc)
				sql2=sql2+"  order by tenThuoc";
		}
		System.out.println(sql2);

		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<Thuoc> list = new ArrayList<Thuoc>();
		Thuoc thuoc;
		try {
			while(rs.next()){
				thuoc = new Thuoc();
				String name=rs.getString("tenThuoc");
				int maThuoc = rs.getInt("maThuoc");
				String hinhAnh=rs.getString("HinhAnh");
				
				thuoc.setTenThuoc(name);
				thuoc.setMaThuoc(maThuoc);
				thuoc.setHinhAnh(hinhAnh);
				thuoc.setLuotXem(rs.getInt("LuotXem"));
				thuoc.setTenNhomThuoc(rs.getString("tenNhomThuoc"));
				thuoc.setMaNhomThuoc(rs.getInt("maNhomThuoc"));

				list.add(thuoc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
