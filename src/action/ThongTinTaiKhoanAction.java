package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.TaiKhoanForm;
import model.bean.TaiKhoan;
import model.bo.TaiKhoanBO;

public class ThongTinTaiKhoanAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		
		TaiKhoanBO taiKhoanBO = new TaiKhoanBO();
		TaiKhoanForm taiKhoanForm = (TaiKhoanForm) form;
		HttpSession session1 = request.getSession();
		
		TaiKhoan taiKhoan = (TaiKhoan)session1.getAttribute("taiKhoan");
		String tenDangNhap = (String)session1.getAttribute("tenDangNhap");
		System.out.println(tenDangNhap);
		String maLoai = (String)session1.getAttribute("maLoai");
		
		//if(taiKhoan != null) {
			if("OK".equals(taiKhoanForm.getSubmit()))
			{		
				String maTK = taiKhoan.getMaTK();
				System.out.println(taiKhoanForm.getMaTK());
				
				String matKhau = taiKhoanForm.getMatKhau();
				String diaChi = taiKhoanForm.getDiaChi();
				String SDT = taiKhoanForm.getSDT();
				String cmnd = taiKhoanForm.getCmnd();
				String email = taiKhoanForm.getEmail();
				
				String tenNhaThuoc = taiKhoanForm.getTenNhaThuoc();
				
				String tenPhongKham = taiKhoanForm.getTenPhongKham();
				String moTa = taiKhoanForm.getMoTa();
				
				String thoiGian = taiKhoanForm.getThoiGian();
				
				taiKhoanBO.suaTaiKhoan(maTK, tenDangNhap, matKhau, diaChi, SDT, maLoai, cmnd, email, tenNhaThuoc, tenPhongKham, moTa, thoiGian);
				taiKhoan = taiKhoanBO.getThongTinTaiKhoan(tenDangNhap, maLoai);
				session1.setAttribute("taiKhoan", taiKhoan);
				session1.setAttribute("taiKhoan1", taiKhoan);
				
				return mapping.findForward("thongTinTKXong");
			}
			else {
				session1.setAttribute("taiKhoan1", taiKhoan);
				taiKhoanForm.setMaTK(taiKhoan.getMaTK());
				taiKhoanForm.setTenDangNhap(taiKhoan.getTenDangNhap());
				taiKhoanForm.setDiaChi(taiKhoan.getDiaChi());
				taiKhoanForm.setMatKhau(taiKhoan.getMatKhau());
				taiKhoanForm.setSDT(taiKhoan.getSDT());
				taiKhoanForm.setMaLoai(taiKhoan.getMaLoai());
				taiKhoanForm.setCmnd(taiKhoan.getCmnd());
				taiKhoanForm.setEmail(taiKhoan.getEmail());
				taiKhoanForm.setTenNhaThuoc(taiKhoan.getTenNhaThuoc());
				taiKhoanForm.setTenPhongKham(taiKhoan.getTenPhongKham());
				taiKhoanForm.setMoTa(taiKhoan.getMoTa());
				taiKhoanForm.setThoiGian(taiKhoan.getThoiGian());
				
				return mapping.findForward("thongTinTK");
			}
		}
}
