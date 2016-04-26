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
import model.bo.NguoiDungBO;

public class DoiMatKhauAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		TaiKhoanForm taiKhoanForm = (TaiKhoanForm) form;
		
		response.setContentType("text/text;charset=utf-8");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("Content-Type", "application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		
		PrintWriter printWriter = response.getWriter();
		
		HttpSession session1 = request.getSession();
		String tenDangNhap = (String)session1.getAttribute("tenDangNhap");
		NguoiDungBO nguoiDungBO = new NguoiDungBO();
		
		if("OK".equals(taiKhoanForm.getSubmit()))
		{
			String matKhauMoi = taiKhoanForm.getMatKhau2();
			System.out.println(matKhauMoi);
			matKhauMoi = encryptMD5(tenDangNhap+matKhauMoi);
			System.out.println(matKhauMoi);
			
			nguoiDungBO.updateMatKhau(tenDangNhap, matKhauMoi);
			return mapping.findForward("doiMKXong");
		}
		else{
			if(taiKhoanForm.getMatKhau()!=null){

				String matKhau = taiKhoanForm.getMatKhau();
				matKhau = encryptMD5(tenDangNhap+matKhau);
				
				if(nguoiDungBO.checkLogin(tenDangNhap, matKhau)){
					System.out.println("dung mat khau");
					printWriter.write("true");
				}
				else{
					System.out.println("sai mat khau");
					printWriter.write("false");
				}
				printWriter.flush();
				
				return null;
			}
		}
		return mapping.findForward("doiMK");
	}
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
}
