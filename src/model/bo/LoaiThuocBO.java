package model.bo;

import model.dao.LoaiThuocDAO;

public class LoaiThuocBO {
	
	LoaiThuocDAO loaiThuocDAO = new LoaiThuocDAO();
	
	public int kt(String tenLoaiThuoc)
	{
		return loaiThuocDAO.kt(tenLoaiThuoc);
	}
	
	public void them(String tenLoaiThuoc)
	{
		loaiThuocDAO.them(tenLoaiThuoc);
	}
	
	public int ktXoa(int maLoaiThuoc)
	{
		return loaiThuocDAO.ktXoa(maLoaiThuoc);
	}

	public void xoa(int maLoaiThuoc)
	{
		loaiThuocDAO.xoa(maLoaiThuoc);
	}
}
