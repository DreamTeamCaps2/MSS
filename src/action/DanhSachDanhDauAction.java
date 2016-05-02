package action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.TaiKhoanForm;
import model.bo.BaiVietBO;

public class DanhSachDanhDauAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		TaiKhoanForm taiKhoanForm = (TaiKhoanForm) form;
		String maTKDN = (String)request.getSession().getAttribute("maTKDN");
		
		BaiVietBO baiVietBO = new BaiVietBO();
		
		taiKhoanForm.setListDanhDau(baiVietBO.getListDanhDau(maTKDN));
		
		return mapping.findForward("danhSachDanhDau");
	}
}
