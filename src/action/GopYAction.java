package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import form.GopYForm;
import model.bo.GopYBO;

public class GopYAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		GopYForm gopYForm  = (GopYForm)form;
		GopYBO gopYBAO = new GopYBO();
		
		Variable.getTB(mapping,form,request,response);
		
		if("GopY".equals(gopYForm.getSubmit())){
			int loaiGopY = gopYForm.getLoaiGopY();
			String noiDung = gopYForm.getNoiDung();
			String tenChuDe = gopYForm.getChuDe();
			System.out.println(noiDung+"+++++++");
			ActionErrors actionErrors = new ActionErrors();

			if("".equals(noiDung)||noiDung==null){
				actionErrors.add("noiDungError",new ActionMessage("error.notNull"));
			}
			if("".equals(tenChuDe)||tenChuDe==null){
				actionErrors.add("chuDeError",new ActionMessage("error.notNull"));
			}
			if(loaiGopY==0||null==""+loaiGopY){
				actionErrors.add("loaiGopYError",new ActionMessage("error.notNull"));
				
			}
			saveErrors(request, actionErrors);
			if(actionErrors.size()>0){
        	}
			else{
				gopYBAO.updateGopY(tenChuDe,loaiGopY,noiDung);
			}
		}
		return mapping.findForward("gopY");
	}

	
}
