package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.BenhForm;
import model.bo.BenhBO;


public class QuanLy_DanhSachBenh_XoaAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		
		BenhForm benhForm = (BenhForm) form;
		BenhBO benhBO = new BenhBO();

		int maBenh = benhForm.getMaBenh();
		benhBO.xoaBenh(maBenh);
		
		return mapping.findForward("xoaBenhXong");

	}

}
