package action;

import java.io.PrintWriter;
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

import form.TaiKhoanForm;
import model.bean.TaiKhoan;
import model.bo.NguoiDungBO;
import model.bo.TaiKhoanBO;

public class DangKyTaiKhoanAction extends Action{
	
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
		
		TaiKhoanForm taiKhoanForm = (TaiKhoanForm) form;
		NguoiDungBO nguoiDungBO = new NguoiDungBO();
		String tenDangNhap = taiKhoanForm.getTenDangNhap();
		
		response.setContentType("text/text;charset=utf-8");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("Content-Type", "application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		
		PrintWriter printWriter = response.getWriter();

		if("OK".equals(taiKhoanForm.getSubmit()))
		{		
			TaiKhoanBO taiKhoanBO = new TaiKhoanBO();
			
			tenDangNhap = taiKhoanForm.getTenDangNhap();
			String matKhau = taiKhoanForm.getMatKhau();
			String diaChi = taiKhoanForm.getDiaChi();
			String SDT = taiKhoanForm.getSDT();
			String loaiTK = taiKhoanForm.getLoaiTK();
			String email = taiKhoanForm.getEmail();
			String cmnd = taiKhoanForm.getCmnd();
			String tenNhaThuoc = taiKhoanForm.getTenNhaThuoc();
			String tenPhongKham = taiKhoanForm.getTenPhongKham();
			String moTa = taiKhoanForm.getMoTa();
			String thoiGian = taiKhoanForm.getThoiGian();
			
			if(!"".equals(diaChi) && diaChi != null)
				diaChi = new String(taiKhoanForm.getDiaChi().getBytes("ISO-8859-1"),"UTF-8");
			
			if(!"".equals(taiKhoanForm.getTenNhaThuoc()) && taiKhoanForm.getTenNhaThuoc() != null)
				tenNhaThuoc = new String(taiKhoanForm.getTenNhaThuoc().getBytes("ISO-8859-1"),"UTF-8");
			
			if(!"".equals(taiKhoanForm.getTenPhongKham()) && taiKhoanForm.getTenPhongKham() != null)
				tenPhongKham = new String(taiKhoanForm.getTenPhongKham().getBytes("ISO-8859-1"),"UTF-8");
			
			if(!"".equals(taiKhoanForm.getMoTa()) && taiKhoanForm.getMoTa() != null)
				moTa = new String(taiKhoanForm.getMoTa().getBytes("ISO-8859-1"),"UTF-8");
			
			matKhau = encryptMD5(tenDangNhap+matKhau);
			System.out.println("Pass MD5: "+matKhau);
			
			taiKhoanBO.themTaiKhoan(tenDangNhap, matKhau, diaChi, SDT, loaiTK, email, cmnd, tenNhaThuoc, tenPhongKham, moTa, thoiGian);
			
			TaiKhoan taiKhoan = taiKhoanBO.getThongTinTaiKhoan(tenDangNhap, "");
			
			HttpSession session1 = request.getSession();
			session1.setAttribute("tenDangNhap", tenDangNhap);
			session1.setAttribute("matKhau", matKhau);
			session1.setAttribute("taiKhoan", taiKhoan);
			session1.setAttribute("kiemtra", 2);
			
			return mapping.findForward("dangKyTKXong");
		}
		else {
			if(taiKhoanForm.getTenDangNhap()!=null ||taiKhoanForm.getEmail()!=null){
				if(taiKhoanForm.getTenDangNhap()!=null){
					if(nguoiDungBO.userNameExist(taiKhoanForm.getTenDangNhap())){
						System.out.println("bi trung ten");
						printWriter.write("false");
					}
					else{
						System.out.println("ko trung ten");
						printWriter.write("true");
					}
				}
				if(taiKhoanForm.getEmail()!=null){
					if(nguoiDungBO.emailExist(taiKhoanForm.getEmail())==false){
						System.out.println("bi trung");
						printWriter.write("false");
					}
					else{
						System.out.println("ko trung");
						printWriter.write("true");
					}
				}
				printWriter.flush();
				
				return null;
			}
		}
		return mapping.findForward("dangKyTK");
		
	}

}
