package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.TaiKhoanForm;

public class DoiMatKhauAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		TaiKhoanForm taiKhoanForm = (TaiKhoanForm) form;
		
		response.setContentType("text/text;charset=utf-8");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("Content-Type", "application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		
		PrintWriter printWriter = response.getWriter();
		if(taiKhoanForm.getMatKhau()!=null){
			if(taiKhoanForm.getMatKhau().equals("123")){
				System.out.println("dung mat khau");
				printWriter.write("true");
			}
			else{
				System.out.println("sai mat khau");
				printWriter.write("false");
			}
			printWriter.flush();
			
			return null;
		}
		
		return mapping.findForward("doiMK");
	}
	
}
