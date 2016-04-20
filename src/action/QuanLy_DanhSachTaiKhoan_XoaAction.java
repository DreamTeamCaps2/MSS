package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class QuanLy_DanhSachTaiKhoan_XoaAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		/*
		TaiKhoanForm taiKhoanForm = (TaiKhoanForm) form;
		TaiKhoanBO taiKhoanBO = new TaiKhoanBO();

		int maTaiKhoan = taiKhoanForm.getMaTaiKhoan();
		taiKhoanBO.xoaTaiKhoan(maTaiKhoan);
		*/
		return mapping.findForward("xoaTaiKhoanXong");

	}


}
