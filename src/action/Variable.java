package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import form.DangNhapForm;

public class Variable {

	public static void getTB(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response){
		DangNhapAction action = new DangNhapAction();
		DangNhapForm dangNhapForm = new DangNhapForm();
		try {
			action.execute(mapping,dangNhapForm , request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
