package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DangNhapForm;
import form.ThongBaoForm;
import form.ThuocForm;
import model.bean.TaiKhoan;
import model.bo.ThuocBO;

public class QuanLy_DanhSachThuocAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ThuocForm thuocForm = (ThuocForm) form;
		ThuocBO thuocBO = new ThuocBO();
		
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
		
		if(thuocForm.getTimThuoc() == null)
			thuocForm.setTimThuoc("");
		
		
		if(!"".equals(thuocForm.getTimThuoc()) && thuocForm.getTimThuoc() != null)
			thuocForm.setTimThuoc(new String(thuocForm.getTimThuoc().getBytes("ISO-8859-1"),"UTF-8"));
		
		// list loai thuoc
		thuocForm.setListLoaiThuoc(thuocBO.getListLoaiThuoc());
		
		// list nhom thuoc
		thuocForm.setListNhomThuoc(thuocBO.getListNhomThuoc(thuocForm.getMaLoaiThuoc()));
		
		
		if(("".equals(thuocForm.getTimThuoc()) || thuocForm.getTimThuoc() == null) && thuocForm.getMaLoaiThuoc() == 0 && thuocForm.getMaNhomThuoc() ==0)
		{
			thuocForm.setListThuoc(thuocBO.getListThuoc());
		}
		else 
		{
			thuocForm.setListThuoc(thuocBO.getListThuoc(thuocForm.getTimThuoc(),thuocForm.getMaLoaiThuoc(),thuocForm.getMaNhomThuoc()));
		}
		return mapping.findForward("danhSachThuoc");
		
	}

}
