package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import form.BenhForm;
import model.bo.BenhBO;
import model.bo.NguoiDungBO;

public class QuanLy_DanhSachBenhAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		BenhForm benhForm = (BenhForm) form;
		BenhBO benhBO = new Benh
		request.getSession().invalidate();
		request.getSession().setAttribute("kt", 0);
		
		
		if(benhForm.getTimBenh() == null)
			benhForm.setTimBenh("");
		
		// list loai benh
		benhForm.setListLoaiBenh(benhBO.getListLoaiBenh());
		
		if(!"".equals(benhForm.getTimBenh()) && benhForm.getTimBenh() != null)
		benhForm.setTimBenh(new String(benhForm.getTimBenh().getBytes("ISO-8859-1"),"UTF-8"));
//		String timBenh = benhForm.getTimBenh();
//				timBenh = new String(timBenh.getBytes("ISO-8859-1"),"UTF-8");
		
			if(("".equals(benhForm.getTimBenh()) || benhForm.getTimBenh() == null) && benhForm.getMaLoaiBenh() == 0)
			{
				benhForm.setListBenh(benhBO.getListBenh());
			}
			else 
			{
				benhForm.setListBenh(benhBO.getListBenh(benhForm.getTimBenh(),benhForm.getMaLoaiBenh()));
			}
		return mapping.findForward("danhSachBenh");
		
	}

}
