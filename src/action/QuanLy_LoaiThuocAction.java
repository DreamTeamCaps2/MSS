package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import form.BenhForm;
import form.LoaiThuocForm;
import model.bo.BenhBO;
import model.bo.LoaiThuocBO;
import model.bo.ThuocBO;

public class QuanLy_LoaiThuocAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		LoaiThuocForm loaiThuocForm = (LoaiThuocForm) form;
		LoaiThuocBO loaiThuocBO = new LoaiThuocBO();
		ThuocBO thuocBO = new ThuocBO();
		
		
		
		if("submit".equals(loaiThuocForm.getSubmit()))
		{
			if(!"".equals(loaiThuocForm.getTenLoaiThuoc()) && loaiThuocForm.getTenLoaiThuoc() != null)
			{
				loaiThuocForm.setTenLoaiThuoc(new String(loaiThuocForm.getTenLoaiThuoc().getBytes("ISO-8859-1"),"UTF-8"));
				
				ActionErrors actionErrors=new ActionErrors();
				
				if(loaiThuocBO.kt(loaiThuocForm.getTenLoaiThuoc())==0)
					actionErrors.add("tenLoaiThuocError",new ActionMessage("error.exists"));
				else if(loaiThuocForm.getTenLoaiThuoc().length()>50)
					actionErrors.add("tenLoaiThuocError",new ActionMessage("error.ten"));
				saveErrors(request, actionErrors);
				if(actionErrors.size()==0)
					loaiThuocBO.them(loaiThuocForm.getTenLoaiThuoc());
			}
		}
		
		// list loai thuoc
				loaiThuocForm.setListLoaiThuoc(thuocBO.getListLoaiThuoc());
		
		return mapping.findForward("loaiThuoc");
		
	}

}
