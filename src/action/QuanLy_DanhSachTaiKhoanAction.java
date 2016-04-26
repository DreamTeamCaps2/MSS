package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.TaiKhoanForm;
import model.bo.TaiKhoanBO;

public class QuanLy_DanhSachTaiKhoanAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		TaiKhoanForm taiKhoanForm = (TaiKhoanForm) form;
		TaiKhoanBO taiKhoanBO = new TaiKhoanBO();
		
		if(request.getParameter("maTaiKhoanKhoa")!=null){
			String maTaiKhoanKhoa = request.getParameter("maTaiKhoanKhoa");
			String trangThai = request.getParameter("trangThai");
			System.out.println("Ma Khoa: "+maTaiKhoanKhoa);
			System.out.println("Trang thai: "+trangThai);
			taiKhoanBO.khoaTaiKhoan(maTaiKhoanKhoa, trangThai);
		}
		
		
		
		if(taiKhoanForm.getTimTaiKhoan() == null)
			taiKhoanForm.setTimTaiKhoan("");
		
		if(!"".equals(taiKhoanForm.getTimTaiKhoan()) && taiKhoanForm.getTimTaiKhoan() != null)
			taiKhoanForm.setTimTaiKhoan(new String(taiKhoanForm.getTimTaiKhoan().getBytes("ISO-8859-1"),"UTF-8"));
		
		// list loai tai khoan
		taiKhoanForm.setListLoaiTaiKhoan(taiKhoanBO.getListLoaiTaiKhoan());
		// list quyen 
		taiKhoanForm.setListQuyen(taiKhoanBO.getListQuyen());
		
			if(("".equals(taiKhoanForm.getTimTaiKhoan()) || taiKhoanForm.getTimTaiKhoan() == null) && taiKhoanForm.getMaLoaiTaiKhoan() == 0 && taiKhoanForm.getMaQuyen() == 0)
			{
				taiKhoanForm.setListTaiKhoan(taiKhoanBO.getListTaiKhoan());
			}
			else 
			{
				taiKhoanForm.setListTaiKhoan(taiKhoanBO.getListTaiKhoan(taiKhoanForm.getTimTaiKhoan(),taiKhoanForm.getMaLoaiTaiKhoan(),taiKhoanForm.getMaQuyen()));
			}
			
		return mapping.findForward("danhSachTaiKhoan");
		
		
	}

}
