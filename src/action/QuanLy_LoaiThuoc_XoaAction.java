package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.LoaiThuocForm;
import model.bo.LoaiThuocBO;

public class QuanLy_LoaiThuoc_XoaAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		LoaiThuocForm loaiThuocForm = (LoaiThuocForm) form;
		LoaiThuocBO loaiThuocBO = new LoaiThuocBO();
		if(loaiThuocBO.ktXoa(loaiThuocForm.getMaLoaiThuoc())==1)
		{
			System.out.println("duoc xoa");
			loaiThuocBO.xoa(loaiThuocForm.getMaLoaiThuoc());
		}
		else
			System.out.println("khong duoc xoa");
		return mapping.findForward("xoaLoaiThuoc");
	}

}
