package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.NhomThuocForm;
import model.bo.ThuocBO;

public class QuanLy_NhomThuoc_XoaAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		NhomThuocForm nhomThuocForm = (NhomThuocForm) form;
		ThuocBO thuocBO = new ThuocBO();
		
		int maNhomThuoc=nhomThuocForm.getMaNhomThuoc();
		if(thuocBO.kiemTraNhomThuoc(maNhomThuoc)){
			thuocBO.xoaNhomThuoc(maNhomThuoc);
		}
		else{
			request.getSession().setAttribute("thongBao", "1");
		}
		
		return mapping.findForward("xoaNhomThuoc");
	}
	

}
