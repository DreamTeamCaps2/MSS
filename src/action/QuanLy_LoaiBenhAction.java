package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import form.LoaiBenhForm;
import form.LoaiThuocForm;
import model.bo.BenhBO;
import model.bo.LoaiBenhBO;
import model.bo.LoaiThuocBO;
import model.bo.ThuocBO;

public class QuanLy_LoaiBenhAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		LoaiBenhForm loaiBenhForm = (LoaiBenhForm) form;
		LoaiBenhBO loaiBenhBO = new LoaiBenhBO();
		BenhBO benhBO = new BenhBO();
		
		
		
		if("submit".equals(loaiBenhForm.getSubmit()))
		{
			if(!"".equals(loaiBenhForm.getTenLoaiBenh()) && loaiBenhForm.getTenLoaiBenh() != null)
			{
				loaiBenhForm.setTenLoaiBenh(new String(loaiBenhForm.getTenLoaiBenh().getBytes("ISO-8859-1"),"UTF-8"));
				
				ActionErrors actionErrors=new ActionErrors();
				
				if(loaiBenhBO.kt(loaiBenhForm.getTenLoaiBenh())==0)
					actionErrors.add("tenLoaiBenhError",new ActionMessage("error.exists"));
				else if(loaiBenhForm.getTenLoaiBenh().length()>50)
					actionErrors.add("tenLoaiBenhError",new ActionMessage("error.ten"));
				saveErrors(request, actionErrors);
				if(actionErrors.size()==0)
					loaiBenhBO.them(loaiBenhForm.getTenLoaiBenh());
			}
		}
		
		// list loai thuoc
		loaiBenhForm.setListLoaiBenh(benhBO.getListLoaiBenh());
		
		return mapping.findForward("loaiBenh");
		
	}

}
