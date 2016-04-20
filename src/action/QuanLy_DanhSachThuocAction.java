package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.BenhForm;
import form.ThuocForm;
import model.bo.BenhBO;
import model.bo.ThuocBO;

public class QuanLy_DanhSachThuocAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ThuocForm thuocForm = (ThuocForm) form;
		ThuocBO thuocBO = new ThuocBO();
		request.getSession().invalidate();
		request.getSession().setAttribute("kt", 0);
		
		if(thuocForm.getTimThuoc() == null)
			thuocForm.setTimThuoc("");
		
		
		if(!"".equals(thuocForm.getTimThuoc()) && thuocForm.getTimThuoc() != null)
			thuocForm.setTimThuoc(new String(thuocForm.getTimThuoc().getBytes("ISO-8859-1"),"UTF-8"));
		
		// list loai thuoc
		thuocForm.setListLoaiThuoc(thuocBO.getListLoaiThuoc());
		
		// list nhom thuoc
		thuocForm.setListNhomThuoc(thuocBO.getListNhomThuoc(thuocForm.getMaLoaiThuoc()));
		
		
		if(("".equals(thuocForm.getTimThuoc()) || thuocForm.getTimThuoc() == null) && thuocForm.getMaLoaiThuoc() == 0 && thuocForm.getMaNhomThuoc() ==0)
		{
			thuocForm.setListThuoc(thuocBO.getListThuoc());
		}
		else 
		{
			thuocForm.setListThuoc(thuocBO.getListThuoc(thuocForm.getTimThuoc(),thuocForm.getMaLoaiThuoc(),thuocForm.getMaNhomThuoc()));
		}
		return mapping.findForward("danhSachThuoc");
		
	}

}
