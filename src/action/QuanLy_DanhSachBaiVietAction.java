package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.BaiVietForm;
import model.bo.BaiVietBO;

public class QuanLy_DanhSachBaiVietAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		BaiVietForm baiVietForm = (BaiVietForm)form;
		BaiVietBO baiVietBO = new BaiVietBO();
		
		if(request.getParameter("maBaiVietXoa")!=null){
			String maBaiVietXoa = request.getParameter("maBaiVietXoa");
			System.out.println(maBaiVietXoa);
			baiVietBO.xoaBaiViet(maBaiVietXoa);
		}
		
		baiVietForm.setListBaiViet(baiVietBO.getListBaiViet(-1));
		
		return mapping.findForward("danhSachBaiViet");
	}

}
