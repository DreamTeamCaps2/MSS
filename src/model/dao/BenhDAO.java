package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.StringTokenizer;

import model.bean.Benh;
import model.bean.LoaiBenh;
import model.bean.TrieuChung;

public class BenhDAO extends DBHelper{

	public ArrayList<Benh> getListBenhLienQuan(String tenBenh){
		connect();
		String sql2 = "Select Top (5) luotXem,maBenh,tenBenh,bienChung,chanDoan,DieuTri,HinhAnh,DinhNghia,NguyenNhan,CheDoDinhDuong"
				+ " from Benh where ";
		StringTokenizer strTkn = new StringTokenizer(tenBenh, " ");
		ArrayList<String> arrLis = new ArrayList<String>(tenBenh.length());
		while(strTkn.hasMoreTokens())
			arrLis.add(strTkn.nextToken());
		if(arrLis.size()==1){
			
				sql2=sql2+"tenBenh like  N'%"+arrLis.get(0)+"%'";
			
		}
		else{
			for(int i=0;i<arrLis.size();i++){
				if(i==arrLis.size()-1)
					sql2=sql2+"tenBenh like  N'%"+arrLis.get(i)+"%'  ";
				else
					sql2=sql2+"tenBenh like  N'%"+arrLis.get(i)+"%' or ";
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
		ArrayList<Benh> list = new ArrayList<Benh>();
		Benh benh;
		try {
			while(rs.next()){
				benh = new Benh();
				String name=rs.getString("tenBenh");
				int maBenh = rs.getInt("maBenh");
				String bienChung= rs.getString("bienChung");
				String chanDoan= rs.getString("chanDoan");
				String dieuTri= rs.getString("dieuTri");
				String hinhAnh= rs.getString("hinhAnh");
				String dinhNghia= rs.getString("dinhNghia");
				String nguyenNhan=rs.getString("nguyenNhan");
				String cheDoDinhDuong=rs.getString("cheDoDinhDuong");
				int luotXem=rs.getInt("luotXem");

				benh.setTenBenh(name);
				benh.setMaBenh(maBenh);
				benh.setBienChung(bienChung);
				benh.setChanDoan(chanDoan);
				benh.setDieuTri(dieuTri);
				benh.setHinhAnh(hinhAnh);
				benh.setDinhNghia(dinhNghia);
				benh.setNguyenNhan(nguyenNhan);
				benh.setCheDoDinhDuong(cheDoDinhDuong);
				benh.setLuotXem(luotXem);
				list.add(benh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<Benh> getListBenhLienQuan(int maLoaiBenh) {
		connect();
		String sql2 = "Select Top (5) luotXem,maBenh,tenBenh,bienChung,chanDoan,DieuTri,HinhAnh,DinhNghia,NguyenNhan,CheDoDinhDuong"
				+ " from Benh where maLoaiBenh = "+maLoaiBenh;
		
		System.out.println(sql2);

		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<Benh> list = new ArrayList<Benh>();
		Benh benh;
		try {
			while(rs.next()){
				benh = new Benh();
				String name=rs.getString("tenBenh");
				int maBenh = rs.getInt("maBenh");
				String bienChung= rs.getString("bienChung");
				String chanDoan= rs.getString("chanDoan");
				String dieuTri= rs.getString("dieuTri");
				String hinhAnh= rs.getString("hinhAnh");
				String dinhNghia= rs.getString("dinhNghia");
				String nguyenNhan=rs.getString("nguyenNhan");
				String cheDoDinhDuong=rs.getString("cheDoDinhDuong");

				benh.setTenBenh(name);
				benh.setMaBenh(maBenh);
				benh.setBienChung(bienChung);
				benh.setChanDoan(chanDoan);
				benh.setDieuTri(dieuTri);
				benh.setHinhAnh(hinhAnh);
				benh.setDinhNghia(dinhNghia);
				benh.setNguyenNhan(nguyenNhan);
				benh.setCheDoDinhDuong(cheDoDinhDuong);
				benh.setLuotXem(rs.getInt("luotXem"));

				list.add(benh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<Benh> getListBenhTimKiem(String timKiem) {
		connect();
		String sql2 = "Select  luotXem,maBenh,tenBenh,bienChung,chanDoan,DieuTri,HinhAnh,DinhNghia,NguyenNhan,CheDoDinhDuong"
				+ " from Benh where ";
		StringTokenizer strTkn = new StringTokenizer(timKiem, "+");
		ArrayList<String> arrLis = new ArrayList<String>(timKiem.length());
		while(strTkn.hasMoreTokens())
			arrLis.add(strTkn.nextToken());
		if(arrLis.size()==1){
			
				sql2=sql2+"tenBenh like  N'%"+arrLis.get(0)+"%'";
			
		}
		else{
			for(int i=0;i<arrLis.size();i++){
				if(i==arrLis.size()-1)
					sql2=sql2+"tenBenh like  N'%"+arrLis.get(i)+"%'  ";
				else
					sql2=sql2+"tenBenh like  N'%"+arrLis.get(i)+"%' or ";
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
		ArrayList<Benh> list = new ArrayList<Benh>();
		Benh benh;
		try {
			while(rs.next()){
				benh = new Benh();
				String name=rs.getString("tenBenh");
				int maBenh = rs.getInt("maBenh");
				String bienChung= rs.getString("bienChung");
				String chanDoan= rs.getString("chanDoan");
				String dieuTri= rs.getString("dieuTri");
				String hinhAnh= rs.getString("hinhAnh");
				String dinhNghia= rs.getString("dinhNghia");
				String nguyenNhan=rs.getString("nguyenNhan");
				String cheDoDinhDuong=rs.getString("cheDoDinhDuong");

				benh.setTenBenh(name);
				benh.setMaBenh(maBenh);
				benh.setBienChung(bienChung);
				benh.setChanDoan(chanDoan);
				benh.setDieuTri(dieuTri);
				benh.setHinhAnh(hinhAnh);
				benh.setDinhNghia(dinhNghia);
				benh.setNguyenNhan(nguyenNhan);
				benh.setCheDoDinhDuong(cheDoDinhDuong);
				benh.setLuotXem(rs.getInt("luotXem"));
				list.add(benh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<LoaiBenh> getListLoaiBenh() {
		
		connect();
		String sql2 = "SELECT * FROM LOAIBENH";
		
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<LoaiBenh> list = new ArrayList<LoaiBenh>();
		LoaiBenh lb;
		try {
			while(rs.next()){
				lb = new LoaiBenh();
				lb.setMaLoaiBenh(rs.getInt("MaLoaiBenh"));
				lb.setTenLoaiBenh(rs.getString("TenLoaiBenh"));
				list.add(lb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<Benh> getListBenh() {
		
		connect();
		String sql2 = "SELECT b.MaBenh, b.TenBenh, lb.TenLoaiBenh FROM BENH b INNER JOIN LOAIBENH lb ON b.MaLoaiBenh = lb.MaLoaiBenh";
		
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<Benh> list = new ArrayList<Benh>();
		Benh b;
		try {
			while(rs.next()){
				b = new Benh();
				b.setMaBenh(rs.getInt("MaBenh"));
				b.setTenBenh(rs.getString("TenBenh"));
				b.setTenLoaiBenh(rs.getString("TenLoaiBenh"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<Benh> getListBenh(String timBenh, int maLoaiBenh) {
		
		connect();
		String sql2="";
		if(("".equals(timBenh)||timBenh==null)&&maLoaiBenh==0)
			sql2 = String.format("SELECT BENH.MaBenh,BENH.TenBenh,LOAIBENH.TenLoaiBenh "
					+ "FROM BENH INNER JOIN LOAIBENH ON BENH.MaLoaiBenh = LOAIBENH.MaLoaiBenh ");
		else	if("".equals(timBenh))			// tim kiem theo loai benh
				sql2 = String.format("SELECT BENH.MaBenh,BENH.TenBenh,LOAIBENH.TenLoaiBenh "
						+ "FROM BENH INNER JOIN LOAIBENH ON BENH.MaLoaiBenh = LOAIBENH.MaLoaiBenh "
					+ "WHERE BENH.MaLoaiBenh = %s",maLoaiBenh);
		else if(maLoaiBenh == 0)		// tim kiem theo ten benh
			sql2 = "SELECT BENH.MaBenh,BENH.TenBenh,LOAIBENH.TenLoaiBenh "
					+ "FROM BENH INNER JOIN LOAIBENH ON BENH.MaLoaiBenh = LOAIBENH.MaLoaiBenh "
					+ "WHERE BENH.TenBenh Like N'%"+timBenh+ "%'";
		else
			sql2 = "SELECT BENH.MaBenh,BENH.TenBenh,LOAIBENH.TenLoaiBenh "
					+ "FROM BENH INNER JOIN LOAIBENH ON BENH.MaLoaiBenh = LOAIBENH.MaLoaiBenh "
					+ "WHERE BENH.TenBenh Like N'%"+timBenh+ "%' AND BENH.MaLoaiBenh = "+maLoaiBenh;
		System.out.println(sql2);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<Benh> list = new ArrayList<Benh>();
		Benh b;
		try {
			while(rs.next()){
				b = new Benh();
				b.setMaBenh(rs.getInt("MaBenh"));
				b.setTenBenh(rs.getString("TenBenh"));
				b.setNguyenNhan(rs.getString("TenLoaiBenh"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<Benh> getListBenh(ArrayList<TrieuChung> listTrieuChung) {
		
		connect();
		String sql2="";
		sql2 = String.format("SELECT MaBenh,TenBenh, TenLoaiBenh FROM BENH INNER JOIN LOAIBENH ON BENH.MaLoaiBenh = LOAIBENH.MaLoaiBenh ");
		if(listTrieuChung.size()!=0)
		{
			sql2 = sql2 + " WHERE MaBenh IN (SELECT MaBenh FROM TRIEUCHUNGBENH WHERE MaTrieuChung = "+listTrieuChung.get(0).getMaTrieuChung()+")";
			for(int i=1;i<listTrieuChung.size();i++)
				sql2 = sql2 + " AND MaBenh IN (SELECT MaBenh FROM TRIEUCHUNGBENH WHERE MaTrieuChung = "+listTrieuChung.get(i).getMaTrieuChung()+")";
		}
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("--------------------------------");
		System.out.println(sql2);
		ArrayList<Benh> list = new ArrayList<Benh>();
		Benh b;
		try {
			while(rs.next()){
				b = new Benh();
				b.setMaBenh(rs.getInt("MaBenh"));
				b.setTenBenh(rs.getString("TenBenh"));
				b.setTenLoaiBenh(rs.getString("TenLoaiBenh"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void themBenh(String tenBenh, String nguyenNhan, String chanDoan, String bienChung, String dieuTri, String cheDoDinhDuong, String dinhNghia, int maLoaiBenh, int trangThai, String hinhAnh)
	{
		connect();
	    String sql =String.format("Insert into BENH (TenBenh, NguyenNhan, ChanDoan, BienChung, DieuTri, CheDoDinhDuong, DinhNghia, MaLoaiBenh,TrangThai, HinhAnh) "
	    		+ "values (N'%s',N'%s',N'%s',N'%s',N'%s',N'%s',N'%s',%s,%s,'%s')",tenBenh,nguyenNhan,chanDoan,bienChung,dieuTri,cheDoDinhDuong, dinhNghia, maLoaiBenh,trangThai, hinhAnh);
	    try {
	        Statement stmt = connection.createStatement();
	        stmt.executeUpdate(sql);
	    } catch (SQLException e) {
	        e.printStackTrace();    
	    }
	    System.out.println("Da them benh");
	}
	
	public void suaBenh(int maBenh, String tenBenh, String nguyenNhan, String chanDoan, String bienChung, String dieuTri, String cheDoDinhDuong, String dinhNghia, int maLoaiBenh, String hinhAnh)
	{
		connect();
	    String sql =String.format("UPDATE BENH "
	    		+ "SET TenBenh=N'%s', NguyenNhan=N'%s', ChanDoan=N'%s', BienChung=N'%s', DieuTri=N'%s', CheDoDinhDuong=N'%s', DinhNghia=N'%s', MaLoaiBenh=%s, HinhAnh = '%s' "
	    		+ "WHERE MaBenh = %s",tenBenh,nguyenNhan,chanDoan,bienChung,dieuTri,cheDoDinhDuong, dinhNghia, maLoaiBenh, hinhAnh, maBenh);
		    try {
	        Statement stmt = connection.createStatement();
	        stmt.executeUpdate(sql);
	    } catch (SQLException e) {
	        e.printStackTrace();    
	    }
	    System.out.println("Da sua benh");
	}
	
	public Benh getBenh(int maBenh)
	{
		connect();
		String sql2 = String.format("SELECT MaBenh,TenBenh,NguyenNhan,ChanDoan,BienChung,DieuTri,CheDoDinhDuong,MaLoaiBenh,TrangThai,HinhAnh, DinhNghia "
				+ "FROM BENH WHERE MaBenh = %s",maBenh);
		
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Benh b = new Benh();
		try {
			while(rs.next()){
				b.setMaBenh(rs.getInt("MaBenh"));
				b.setTenBenh(rs.getString("TenBenh"));
				b.setNguyenNhan(rs.getString("NguyenNhan"));
				b.setChanDoan(rs.getString("ChanDoan"));
				b.setBienChung(rs.getString("BienChung"));
				b.setDieuTri(rs.getString("DieuTri"));
				b.setCheDoDinhDuong(rs.getString("CheDoDinhDuong"));
				b.setMaLoaiBenh(rs.getInt("MaLoaiBenh"));
				b.setHinhAnh(rs.getString("HinhAnh"));
				b.setDinhNghia(rs.getString("DinhNghia"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public void xoaBenh(int maBenh)
	{
		connect();
        String sql= String.format("DELETE FROM BENH WHERE MaBenh = %s", maBenh);
        System.out.println(sql);
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        String sql1= String.format("DELETE FROM THUOCBENH WHERE MaBenh = %s", maBenh);
        System.out.println(sql);
        try {
            Statement stmt1 = connection.createStatement();
            stmt1.executeUpdate(sql1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public void themBenhThuoc(String tenBenh,int maThuoc)
	{
		connect();
	    String sql =String.format("Insert into THUOCBENH (MaBenh,MaThuoc) "
	    		+ "values ((SELECT MaBenh FROM BENH WHERE TenBenh = N'%s'),%s)",tenBenh,maThuoc);
	    System.out.println("----------");
	    System.out.println(sql);
	    try {
	        Statement stmt = connection.createStatement();
	        stmt.executeUpdate(sql);
	    } catch (SQLException e) {
	        e.printStackTrace();    
	    }
	    System.out.println("Da them benh thuoc");
	}
	public void themBenhTrieuChung(String tenBenh,int maTrieuChung)
	{
		connect();
	    String sql =String.format("Insert into TRIEUCHUNGBENH (MaBenh,MaTrieuChung) "
	    		+ "values ((SELECT MaBenh FROM BENH WHERE TenBenh = N'%s'),%s)",tenBenh,maTrieuChung);
	    System.out.println(sql);
	    try {
	        Statement stmt = connection.createStatement();
	        stmt.executeUpdate(sql);
	    } catch (SQLException e) {
	        e.printStackTrace();    
	    }
	    System.out.println("Da them benh trieu chung");
	}
	public Benh getBenhAuto(int ma) {
		connect();
		String sql2 = "Select  tenLoaiBenh,Benh.maLoaiBenh,Benh.maBenh,luotXem,tenBenh,bienChung,chanDoan,DieuTri,HinhAnh,DinhNghia,NguyenNhan,CheDoDinhDuong"
				+ " from Benh inner join LoaiBenh on Benh.MaLoaiBenh =LoaiBenh.MaLoaiBenh where maBenh = "+ma;
		System.out.println(sql2);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Benh benh = null;
		try {
			while(rs.next()){
				benh = new Benh();
				String name=rs.getString("tenBenh");
				int maBenh = rs.getInt("maBenh");
				String bienChung= rs.getString("bienChung");
				String chanDoan= rs.getString("chanDoan");
				String dieuTri= rs.getString("dieuTri");
				String hinhAnh= rs.getString("HinhAnh");
				String dinhNghia= rs.getString("dinhNghia");
				String nguyenNhan=rs.getString("nguyenNhan");
				String cheDoDinhDuong=rs.getString("cheDoDinhDuong");
				int maLoaiBenh = rs.getInt("maLoaiBenh");
				int luotXem=rs.getInt("luotXem");
				benh.setLuotXem(luotXem);
				benh.setTenBenh(name);
				benh.setMaBenh(maBenh);
				benh.setBienChung(bienChung);
				benh.setChanDoan(chanDoan);
				benh.setDieuTri(dieuTri);
				benh.setHinhAnh(hinhAnh);
				benh.setDinhNghia(dinhNghia);
				benh.setNguyenNhan(nguyenNhan);
				benh.setCheDoDinhDuong(cheDoDinhDuong);
				benh.setMaLoaiBenh(maLoaiBenh);
				benh.setTenLoaiBenh(rs.getString("tenLoaiBenh"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return benh;
	}
	
	public ArrayList<Benh> getListBenhDanhSach(int maLoaiDanhSach) {
		// TODO Auto-generated method stub
		connect();
		String sql2;
		if(maLoaiDanhSach==0){
			 sql2 = "Select   Benh.maLoaiBenh,tenLoaiBenh,maBenh,tenBenh,bienChung,chanDoan,DieuTri,HinhAnh,DinhNghia,NguyenNhan,CheDoDinhDuong"
						+ " from Benh inner join LoaiBenh on BENH.maLoaiBenh=LoaiBenh.maLoaiBenh ";
		}
		else{
			sql2 = "Select   Benh.maLoaiBenh,tenLoaiBenh,maBenh,tenBenh,bienChung,chanDoan,DieuTri,HinhAnh,DinhNghia,NguyenNhan,CheDoDinhDuong"
					+ " from Benh inner join LoaiBenh on BENH.maLoaiBenh=LoaiBenh.maLoaiBenh where Benh.maLoaiBenh = "+maLoaiDanhSach;
		}
		
		
		System.out.println(sql2);

		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<Benh> list = new ArrayList<Benh>();
		Benh benh;
		try {
			while(rs.next()){
				benh = new Benh();
				String name=rs.getString("tenBenh");
				int maBenh = rs.getInt("maBenh");
				String bienChung= rs.getString("bienChung");
				String chanDoan= rs.getString("chanDoan");
				String dieuTri= rs.getString("dieuTri");
				String hinhAnh= rs.getString("hinhAnh");
				String dinhNghia= rs.getString("dinhNghia");
				String nguyenNhan=rs.getString("nguyenNhan");
				
				String cheDoDinhDuong=rs.getString("cheDoDinhDuong");
				benh.setMaLoaiBenh(rs.getInt("maLoaiBenh"));
				benh.setTenLoaiBenh(rs.getString("tenLoaiBenh"));
				benh.setTenBenh(name);
				benh.setMaBenh(maBenh);
				benh.setBienChung(bienChung);
				benh.setChanDoan(chanDoan);
				benh.setDieuTri(dieuTri);
				benh.setHinhAnh(hinhAnh);
				benh.setDinhNghia(dinhNghia);
				benh.setNguyenNhan(nguyenNhan);
				benh.setCheDoDinhDuong(cheDoDinhDuong);
				benh.setLuotXem(10000);
				benh.setNgayCapNhat("4/11/2016");
				list.add(benh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void capNhatLuotXem(int ma, int i) {
		// TODO Auto-generated method stub
		connect();
	    String sql =String.format("Update  Benh set luotxem = %s "
	    		 +"where maBenh= %s",i+1,ma);
	    System.out.println("hehe"+sql);
	    try {
	        Statement stmt = connection.createStatement();
	        stmt.executeUpdate(sql);
	    } catch (SQLException e) {
	        e.printStackTrace();    
	    }
	    System.out.println("Cap nhat luot xem");
	}

	public ArrayList<Benh> getListBenhXemNhieu() {
		// TODO Auto-generated method stub
		connect();
		String sql2 = "Select Top (5) luotXem,maBenh,tenBenh,bienChung,chanDoan,DieuTri,HinhAnh,DinhNghia,NguyenNhan,CheDoDinhDuong from Benh order by LuotXem desc";
		
		System.out.println(sql2);

		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<Benh> list = new ArrayList<Benh>();
		Benh benh;
		try {
			while(rs.next()){
				benh = new Benh();
				String name=rs.getString("tenBenh");
				int maBenh = rs.getInt("maBenh");
				String hinhAnh= rs.getString("hinhAnh");
				benh.setTenBenh(name);
				benh.setMaBenh(maBenh);
				benh.setHinhAnh(hinhAnh);
				benh.setLuotXem(rs.getInt("luotXem"));
				list.add(benh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public int ktTenBenh(String tenBenh) {
		connect();
		String sql2 = String.format("SELECT MaBenh "
				+ "FROM BENH WHERE TenBenh = N'%s'",tenBenh);
		
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Benh b = new Benh();
		int dem = 0;
		try {
			while(rs.next()){
				dem = dem +1;
				if(rs.getInt("MaBenh")==0)
					return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(dem==0)
			return 1;
		return 0;
	}
	
	public int ktTenBenh(String tenBenh,int maBenh) {
		connect();
		String sql2 = String.format("SELECT MaBenh ,TenBenh "
				+ "FROM BENH WHERE TenBenh = N'%s' ",tenBenh);
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
				System.out.println("MaBenh = "+rs.getInt("MaBenh"));
				if(rs.getInt("MaBenh") == maBenh)
						return 1;
				else return 0;
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}

	public void xoaThuocBenh(int maBenh) {
		connect();
        String sql= String.format("DELETE FROM THUOCBENH WHERE MaBenh = %s", maBenh);
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public ArrayList<Benh> getListBenh(int maThuoc) {
		connect();
		String sql2 = String.format("SELECT BENH.MaBenh,BENH.TenBenh "
						+ "FROM THUOC  INNER JOIN THUOCBENH ON THUOC.MaThuoc = THUOCBENH.MaThuoc "
						+ 				"INNER JOIN BENH ON THUOCBENH.MaBenh = BENH.MaBenh "
						+ "WHERE THUOCBENH.MaThuoc = %s",maThuoc);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<Benh> list = new ArrayList<Benh>();
		Benh b;
		try {
			while(rs.next()){
				b = new Benh();
				b.setMaBenh(rs.getInt("MaBenh"));
				b.setTenBenh(rs.getString("TenBenh"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<Benh> getListBenhTimKiemFilter(String timKiem, boolean luotXem, boolean abc) {
		// TODO Auto-generated method stub
		connect();
		String sql2 = "Select  Benh.maLoaiBenh,tenLoaiBenh,luotXem,maBenh,tenBenh,bienChung,chanDoan,DieuTri,HinhAnh,DinhNghia,NguyenNhan,CheDoDinhDuong"
				+ " from Benh inner join LOAIBENH on LOAIBENH.maLoaiBenh=Benh.MALOAIBENH where ";
		StringTokenizer strTkn = new StringTokenizer(timKiem, "+");
		ArrayList<String> arrLis = new ArrayList<String>(timKiem.length());
		while(strTkn.hasMoreTokens())
			arrLis.add(strTkn.nextToken());
		if(arrLis.size()==1){
			
				sql2=sql2+"tenBenh like  N'%"+arrLis.get(0)+"%'";
			
		}
		else{
			for(int i=0;i<arrLis.size();i++){
				if(i==arrLis.size()-1)
					sql2=sql2+"tenBenh like  N'%"+arrLis.get(i)+"%'  ";
				else
					sql2=sql2+"tenBenh like  N'%"+arrLis.get(i)+"%' or ";
			}
		}
		if (luotXem&&abc){
			sql2=sql2+"  order by luotxem desc,tenBenh ";
		}
		else{
			if(luotXem)
				sql2=sql2+"  order by luotXem desc";
			if(abc)
				sql2=sql2+"  order by tenBenh";
		}
		System.out.println(sql2);

		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<Benh> list = new ArrayList<Benh>();
		Benh benh;
		try {
			while(rs.next()){
				benh = new Benh();
				String name=rs.getString("tenBenh");
				int maBenh = rs.getInt("maBenh");
				String bienChung= rs.getString("bienChung");
				String chanDoan= rs.getString("chanDoan");
				String dieuTri= rs.getString("dieuTri");
				String hinhAnh= rs.getString("hinhAnh");
				String dinhNghia= rs.getString("dinhNghia");
				String nguyenNhan=rs.getString("nguyenNhan");
				String cheDoDinhDuong=rs.getString("cheDoDinhDuong");
				
				benh.setTenBenh(name);
				benh.setMaBenh(maBenh);
				benh.setBienChung(bienChung);
				benh.setChanDoan(chanDoan);
				benh.setDieuTri(dieuTri);
				benh.setHinhAnh(hinhAnh);
				benh.setDinhNghia(dinhNghia);
				benh.setNguyenNhan(nguyenNhan);
				benh.setCheDoDinhDuong(cheDoDinhDuong);
				benh.setLuotXem(rs.getInt("luotXem"));
				benh.setTenLoaiBenh(rs.getString("tenLoaiBenh"));
				benh.setMaLoaiBenh(rs.getInt("maLoaiBenh"));
				list.add(benh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
