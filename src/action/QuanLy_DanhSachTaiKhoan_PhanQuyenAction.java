package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.PhanQuyenForm;
import model.bean.TaiKhoan;
import model.bo.PhanQuyenBO;
import model.bo.TaiKhoanBO;

public class QuanLy_DanhSachTaiKhoan_PhanQuyenAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		PhanQuyenBO phanQuyenBO = new PhanQuyenBO();
		PhanQuyenForm phanQuyenForm = (PhanQuyenForm) form;
		
		HttpSession session1 = request.getSession();
		
		int maTaiKhoan = phanQuyenForm.getMaTaiKhoan();
		System.out.println("ma nhan vien 1 "+maTaiKhoan);
		
		if("submit".equals(phanQuyenForm.getSubmit()))
		{	
			phanQuyenBO.xoaQuyen(maTaiKhoan);
			if(phanQuyenForm.getBenh()==1)
				phanQuyenBO.themQuyen(maTaiKhoan, 1);
			if(phanQuyenForm.getThuoc()==1)
				phanQuyenBO.themQuyen(maTaiKhoan, 2);
			if(phanQuyenForm.getTrieuChung()==1)
				phanQuyenBO.themQuyen(maTaiKhoan, 3);
			if(phanQuyenForm.getPhanQuyen()==1)
				phanQuyenBO.themQuyen(maTaiKhoan, 4);
			if(phanQuyenForm.getDangBai()==1)
				phanQuyenBO.themQuyen(maTaiKhoan, 5);
			return mapping.findForward("phanQuyenXong");
		}
		else
		{
			ArrayList<Integer> list = phanQuyenBO.getListQuyen(maTaiKhoan);
			for(int i=0;i<list.size();i++)
			{	
				switch (list.get(i)) {
				case 1: phanQuyenForm.setBenh(1);
					break;
				case 2: phanQuyenForm.setThuoc(1);
					break;
				case 3: phanQuyenForm.setTrieuChung(1);
					break;
				case 4: phanQuyenForm.setPhanQuyen(1);
					break;
				case 5: phanQuyenForm.setDangBai(1);
					break;
				}
			}
			
			TaiKhoanBO taiKhoanBO = new TaiKhoanBO();
			String tenDangNhap = taiKhoanBO.getTenDangNhap(maTaiKhoan);
			TaiKhoan taiKhoan = taiKhoanBO.getThongTinTaiKhoan(tenDangNhap, "");
			session1.setAttribute("taiKhoanPhanQuyen", taiKhoan);
			
			return mapping.findForward("phanQuyen");
		}

	}
	
}
