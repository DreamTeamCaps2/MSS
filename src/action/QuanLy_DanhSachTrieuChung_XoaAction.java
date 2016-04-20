package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class QuanLy_DanhSachTrieuChung_XoaAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		/*
		TrieuChungForm trieuChungForm = (TrieuChungForm) form;
		TrieuChungBO trieuChungBO = new TrieuChungBO();

		int maTrieuChung = trieuChungForm.getMaTrieuChung();
		trieuChungBO.xoaTrieuChung(maTrieuChung);
		*/
		return mapping.findForward("xoaTrieuChungXong");

	}

}
