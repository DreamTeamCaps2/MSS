package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.BenhForm;
import form.DangNhapForm;
import form.ThongBaoForm;
import model.bean.TaiKhoan;
import model.bo.BenhBO;

public class QuanLy_DanhSachBenhAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		BenhForm benhForm = (BenhForm) form;
		BenhBO benhBO = new BenhBO();
		
		HttpSession session1 = request.getSession();	
		String tenDangNhap = (String)session1.getAttribute("tenDangNhap");
		String matKhau = (String)session1.getAttribute("matKhau");
		DangNhapForm dangNhapForm = (DangNhapForm)session1.getAttribute("dangNhapForm");
		ThongBaoForm thongBaoForm = (ThongBaoForm)session1.getAttribute("thongBaoForm");
		TaiKhoan taiKhoan = (TaiKhoan)session1.getAttribute("taiKhoan");
		int kiemTra = (int)session1.getAttribute("kiemtra");
		int quanLy = (int)session1.getAttribute("quanLy");
		
		request.getSession().invalidate();
		request.getSession().setAttribute("kt", 0);
		
		request.getSession().setAttribute("tenDangNhap", tenDangNhap);
		request.getSession().setAttribute("matKhau", matKhau);
		request.getSession().setAttribute("dangNhapForm", dangNhapForm);
		request.getSession().setAttribute("thongBaoForm", thongBaoForm);
		request.getSession().setAttribute("taiKhoan", taiKhoan);
		request.getSession().setAttribute("maTKDN", taiKhoan.getMaTK());
		request.getSession().setAttribute("kiemtra", kiemTra);
		request.getSession().setAttribute("quanLy", quanLy);
		
		
		if(benhForm.getTimBenh() == null)
			benhForm.setTimBenh("");
		
		// list loai benh
		benhForm.setListLoaiBenh(benhBO.getListLoaiBenh());
		
		if(!"".equals(benhForm.getTimBenh()) && benhForm.getTimBenh() != null)
		benhForm.setTimBenh(new String(benhForm.getTimBenh().getBytes("ISO-8859-1"),"UTF-8"));
//		String timBenh = benhForm.getTimBenh();
//				timBenh = new String(timBenh.getBytes("ISO-8859-1"),"UTF-8");
		
			if(("".equals(benhForm.getTimBenh()) || benhForm.getTimBenh() == null) && benhForm.getMaLoaiBenh() == 0)
			{
				benhForm.setListBenh(benhBO.getListBenh());
			}
			else 
			{
				benhForm.setListBenh(benhBO.getListBenh(benhForm.getTimBenh(),benhForm.getMaLoaiBenh()));
			}
		return mapping.findForward("danhSachBenh");
		
	}

}
