package model.bo;

import model.dao.LoaiBenhDAO;
import model.dao.LoaiThuocDAO;

public class LoaiBenhBO {

	LoaiBenhDAO loaiBenhDAO = new LoaiBenhDAO();
	
	public int kt(String tenLoaiBenh)
	{
		return loaiBenhDAO.kt(tenLoaiBenh);
	}
	
	public void them(String tenLoaiBenh)
	{
		loaiBenhDAO.them(tenLoaiBenh);
	}
	
	public int ktXoa(int maLoaiBenh)
	{
		return loaiBenhDAO.ktXoa(maLoaiBenh);
	}

	public void xoa(int maLoaiBenh)
	{
		loaiBenhDAO.xoa(maLoaiBenh);
	}
}
