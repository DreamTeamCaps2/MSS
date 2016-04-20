package action;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DangNhapForm;
import model.bean.TaiKhoan;
import model.bo.NguoiDungBO;
import model.bo.TaiKhoanBO;

public class DangNhapAction extends Action {
	
	public static String encryptMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		DangNhapForm dangNhapForm = (DangNhapForm) form;

		String tenDangNhap = dangNhapForm.getTenDangNhap();
		String matKhau = dangNhapForm.getMatKhau();
		
		matKhau = encryptMD5(tenDangNhap + matKhau);
		
		NguoiDungBO nguoiDungBO = new NguoiDungBO();
		HttpSession session1 = request.getSession();	
		
		if(tenDangNhap==null){
			tenDangNhap = (String)session1.getAttribute("tenDangNhap");
			matKhau = (String)session1.getAttribute("matKhau");
		}
		
		if(nguoiDungBO.checkLogin(tenDangNhap, matKhau)){
			TaiKhoanBO taiKhoanBO = new TaiKhoanBO();
			TaiKhoan taiKhoan = taiKhoanBO.getThongTinTaiKhoan(tenDangNhap, "");
			
			request.getSession().setAttribute("dangNhapForm", dangNhapForm);
			session1.setAttribute("taiKhoan", taiKhoan);
			session1.setAttribute("tenDangNhap", tenDangNhap);
			session1.setAttribute("maTKDN", taiKhoan.getMaTK());
			session1.setAttribute("kiemtra", 2);
			if(taiKhoan.getLoaiTK().equals("1")||taiKhoan.getLoaiTK().equals("2"))
				session1.setAttribute("quanLy", 1);
			return mapping.findForward("dangNhapThanhCong");
		}
		else{
			session1.setAttribute("kiemtra", 1);
			return mapping.findForward("dangNhapThatBai");
		}
	}
}
