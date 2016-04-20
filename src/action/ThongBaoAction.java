package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.google.gson.Gson;

import form.ThongBaoForm;
import model.bo.ThongBaoBO;

public class ThongBaoAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ThongBaoForm thongBaoForm = (ThongBaoForm)form;
		//get danh sach cac thong bao co loai =  2 va ngay = ngay hien tai ;
		ThongBaoBO thongBaoBO = new ThongBaoBO();
		thongBaoForm.setListThongBao(thongBaoBO.getListThongBao());
		thongBaoForm.setSoLuong(thongBaoBO.getListThongBao().size());
		
//		PrintWriter printWriter = response.getWriter();
//		
//		Gson gson = new Gson();
//		String t1 = gson.toJson(form);
//		printWriter.print(t1);
		
		return mapping.findForward("thongBao");
	}

}
