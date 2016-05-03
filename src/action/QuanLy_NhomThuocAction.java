package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import form.NhomThuocForm;
import model.bean.LoaiThuoc;
import model.bean.NhomThuoc;
import model.bo.ThuocBO;

public class QuanLy_NhomThuocAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		
		NhomThuocForm nhomThuocForm = (NhomThuocForm) form;
		ThuocBO thuocBO = new ThuocBO();
		ArrayList<LoaiThuoc> listLoaiThuoc = new ArrayList<LoaiThuoc>();
		listLoaiThuoc= thuocBO.getListLoaiThuoc();
		System.out.println("---"+listLoaiThuoc.size());
		nhomThuocForm.setListLoaiThuoc(listLoaiThuoc);
		//them nhomThuoc
		if("Add".equals(nhomThuocForm.getSubmit())){
			String tenNhomThuoc = nhomThuocForm.getTenNhomThuoc();
			int maLoaiThuoc = nhomThuocForm.getMaLoaiThuoc();

        	ActionErrors actionErrors  = new ActionErrors();

			if("".equals(tenNhomThuoc)||tenNhomThuoc==null){
				actionErrors.add("tenNhomThuocError",new ActionMessage("error.notNull"));
			}
			if(maLoaiThuoc==0||null==""+maLoaiThuoc){
				actionErrors.add("loaiThuocError",new ActionMessage("error.notNull"));
				
			}
			saveErrors(request, actionErrors);
			if(actionErrors.size()>0){
        	}
        	else{
        		thuocBO.themNhomThuoc(tenNhomThuoc,maLoaiThuoc);
        	}
		}
		
		
		
		ArrayList<NhomThuoc> listNhomThuoc = new ArrayList<NhomThuoc>();
		listNhomThuoc = thuocBO.getListNhomThuoc();
		nhomThuocForm.setListNhomThuoc(listNhomThuoc);
		
		
		String thongBao =(String)request.getSession().getAttribute("thongBao");
		
		if(thongBao!=null){
			nhomThuocForm.setThongBao(thongBao);
			request.getSession().removeAttribute("thongBao");
			
		}
		else{
			nhomThuocForm.setThongBao("??");
		}
		
		return mapping.findForward("nhomThuoc");
	}

}
