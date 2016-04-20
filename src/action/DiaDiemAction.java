package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DiaDiemForm;
import model.bo.DiaDiemBO;

public class DiaDiemAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		DiaDiemBO diaDiemBO = new DiaDiemBO();
		DiaDiemForm diaDiemForm = (DiaDiemForm) form;
		diaDiemForm.setListDiaDiem(diaDiemBO.getListDiaDiem());
		diaDiemForm.setLongi("106.689422");

		return mapping.findForward("diaDiem");
	}
}
