package action;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.TaiKhoanForm;
import model.bo.NguoiDungBO;
import model.bo.TaiKhoanBO;

public class LayMatKhauAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		TaiKhoanForm taiKhoanForm = (TaiKhoanForm)form;
		TaiKhoanBO taiKhoanBO = new TaiKhoanBO();
		NguoiDungBO nguoiDungBO = new NguoiDungBO();
		String tenDangNhap="";
		String maTK = taiKhoanForm.getMaTK();
		if(maTK!=null)
			tenDangNhap = taiKhoanBO.getTenDangNhap(Integer.parseInt(maTK));
		taiKhoanForm.setTenDangNhap(tenDangNhap);
		
		if(request.getParameter("token")!=null){
			if("OK".equals(taiKhoanForm.getSubmit()))
			{
				tenDangNhap = taiKhoanForm.getTenDangNhap();
				
				String matKhauMoi = taiKhoanForm.getMatKhau2();
				matKhauMoi = encryptMD5(tenDangNhap+matKhauMoi);
				nguoiDungBO.updateMatKhau(tenDangNhap, matKhauMoi);
				return mapping.findForward("layLaiMatKhauXong");
			}
		}
		return mapping.findForward("layLaiMatKhau");
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
