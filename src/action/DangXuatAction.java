package action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DangNhapForm;

public class DangXuatAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			request.setCharacterEncoding("UTF-8");
			HttpSession session  = request.getSession();
			session.removeAttribute("dangNhapForm");
			session.removeAttribute("taiKhoan");
			session.removeAttribute("taiKhoan1");
			session.invalidate();
			request.getSession().invalidate();
			DangNhapForm dangNhapForm = (DangNhapForm)form;
			dangNhapForm.setThongBao("Tạm biệt bạn ! Hẹn gặp lại");
			
			Cookie cookie = null;
			Cookie[] cookies = null;
			// Get an array of Cookies associated with this domain
			cookies = request.getCookies();
			if (cookies != null) {
				System.out.println("<h2> Found Cookies Name and Value</h2>");
				for (int i = 0; i < cookies.length; i++) {
					cookie = cookies[i];
					if ((cookie.getName()).compareTo("tenDangNhap") == 0) {
						cookie.setMaxAge(0);
						response.addCookie(cookie);
						System.out.print("Deleted cookie: " + cookie.getName() + "<br/>");
					}
					if ((cookie.getName()).compareTo("matKhau") == 0) {
						cookie.setMaxAge(0);
						response.addCookie(cookie);
						System.out.print("Deleted cookie: " + cookie.getName() + "<br/>");
					}
					System.out.print("Name : " + cookie.getName() + ",  ");
					System.out.print("Value: " + cookie.getValue() + " <br/>");
				}
			} else {
				System.out.println("<h2>No cookies founds</h2>");
			}
			
			return mapping.findForward("dangXuatThanhCong");
		}catch(Exception e){
			return mapping.findForward("error");
		}
	}

}
