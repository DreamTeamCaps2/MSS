package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import form.TrieuChungForm;
import model.bo.TrieuChungBO;

public class QuanLy_DanhSachTrieuChungAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		TrieuChungForm trieuChungForm = (TrieuChungForm)form;
		TrieuChungBO trieuChungBO = new TrieuChungBO();
		
		
		if(request.getParameter("maTrieuChungXoa")!=null){
			String maTrieuChung = request.getParameter("maTrieuChungXoa");
			trieuChungBO.xoaTrieuChung(maTrieuChung);
		}
		
		if("Add".equals(trieuChungForm.getSubmit())){
			String tenTrieuChung = new String(trieuChungForm.getTenTrieuChung().getBytes("ISO-8859-1"),"UTF-8");
			
        	ActionErrors actionErrors  = new ActionErrors();

			if("".equals(tenTrieuChung)||tenTrieuChung==null){
				actionErrors.add("tenTrieuChungError",new ActionMessage("error.notNull"));
			}
			else if(trieuChungBO.checkExist(tenTrieuChung)==true){
				System.out.println("bitrung");
				actionErrors.add("tenTrieuChungError",new ActionMessage("error.exists"));
			}
			saveErrors(request, actionErrors);
			if(actionErrors.size()==0){
        		trieuChungBO.themTrieuChung(tenTrieuChung);
        	}
		}
		
		trieuChungForm.setListTrieuChung(trieuChungBO.getListTrieuChung());
		
		return mapping.findForward("danhSachTrieuChung");
		
	}
}
