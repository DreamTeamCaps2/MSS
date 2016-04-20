package action;

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
			return mapping.findForward("dangXuatThanhCong");
		}catch(Exception e){
			return mapping.findForward("error");
		}
	}

}
