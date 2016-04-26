package action;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

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
import model.bo.PhanQuyenBO;
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
		
		PhanQuyenBO phanQuyenBO = new PhanQuyenBO();
		NguoiDungBO nguoiDungBO = new NguoiDungBO();
		HttpSession session1 = request.getSession();	
		
		if(tenDangNhap==null){
			tenDangNhap = (String)session1.getAttribute("tenDangNhap");
			matKhau = (String)session1.getAttribute("matKhau");
		}
		
		if(nguoiDungBO.checkLogin(tenDangNhap, matKhau)){
			TaiKhoanBO taiKhoanBO = new TaiKhoanBO();
			TaiKhoan taiKhoan = taiKhoanBO.getThongTinTaiKhoan(tenDangNhap, "");

			session1.setAttribute("taiKhoan", taiKhoan);
			session1.setAttribute("tenDangNhap", tenDangNhap);
			session1.setAttribute("maTKDN", taiKhoan.getMaTK());
			session1.setAttribute("kiemtra", 2);
			
			if(taiKhoan.getLoaiTK().equals("1")||taiKhoan.getLoaiTK().equals("2")||taiKhoan.getLoaiTK().equals("3")){
				session1.setAttribute("quanLy", 1);
				
				ArrayList<Integer> arr = new ArrayList<Integer>();
				
				arr = phanQuyenBO.getListQuyen(Integer.parseInt(taiKhoan.getMaTK()));
				
				for(int i=0;i<arr.size();i++)
				{
					if(arr.get(i)==1)
						dangNhapForm.setBenh(1);
					if(arr.get(i)==2)
						dangNhapForm.setThuoc(1);
					if(arr.get(i)==3)
						dangNhapForm.setTrieuChung(1);
					if(arr.get(i)==4)
						dangNhapForm.setPhanQuyen(1);
					if(arr.get(i)==5)
						dangNhapForm.setDangBai(1);
					System.out.println(arr.get(i));
				}
				
			}
			
			session1.setAttribute("dangNhapForm", dangNhapForm);
			
			return mapping.findForward("dangNhapThanhCong");
		}
		else{
			session1.setAttribute("kiemtra", 1);
			return mapping.findForward("dangNhapThatBai");
		}
	}
}
