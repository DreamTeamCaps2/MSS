package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.LoaiBenhForm;
import form.LoaiThuocForm;
import model.bo.LoaiBenhBO;
import model.bo.LoaiThuocBO;

public class QuanLy_LoaiBenh_XoaAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		LoaiBenhForm loaiBenhForm = (LoaiBenhForm) form;
		LoaiBenhBO loaiBenhBO = new LoaiBenhBO();
		if(loaiBenhBO.ktXoa(loaiBenhForm.getMaLoaiBenh())==1)
		{
			System.out.println("duoc xoa");
			loaiBenhBO.xoa(loaiBenhForm.getMaLoaiBenh());
		}
		else
			System.out.println("khong duoc xoa");
		return mapping.findForward("xoaLoaiBenh");
	}

}
