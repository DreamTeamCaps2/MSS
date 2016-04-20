package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.BaiVietForm;
import model.bean.BaiViet;
import model.bo.BaiVietBO;

public class ChiTietBaiVietAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	
		BaiVietForm baiVietForm = (BaiVietForm)form;
		BaiVietBO baiVietBO = new BaiVietBO();
		
		int maBaiViet = baiVietForm.getMaBaiViet();
		
		BaiViet baiViet = baiVietBO.getBaiViet(maBaiViet);
		baiVietForm.setTieuDe(baiViet.getTieuDe());
		baiVietForm.setTomTat(baiViet.getTomTat());
		baiVietForm.setHinhAnh(baiViet.getHinhAnh());
		baiVietForm.setNoiDung(baiViet.getNoiDung());
		
		return mapping.findForward("chiTietBaiViet");
	}
	
}
