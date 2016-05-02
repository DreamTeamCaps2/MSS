package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ThongBaoForm;
import model.bean.ThongBao;
import model.bo.ThongBaoBO;

public class QuanLy_DanhSachGopYAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ThongBaoForm gopYForm  = (ThongBaoForm)form;
		ThongBaoBO thongBaoBO = new ThongBaoBO();
		String maTK =(String)request.getSession().getAttribute("maTKDN");
		int loaiGopY = gopYForm.getLoaiGopY();
		int tinhTrang = gopYForm.getTinhTrang();
		int tinhTrangUpdate = gopYForm.getTinhTrangUpdate();
		int xoa=gopYForm.getXoa();
		int maGopY= gopYForm.getMaGopY();
		
		HttpSession session1 = request.getSession();	
		ThongBaoForm form1 = (ThongBaoForm)session1.getAttribute("thongBaoForm");
		session1.removeAttribute("thongBaoForm");
		
		if(xoa!=0){
			thongBaoBO.xoaGopY(maGopY);
			ArrayList<ThongBao> listGopY = thongBaoBO.getListThongBaoGopY(maTK,0,0);
			form1.setListThongBao(listGopY);
			form1.setSoLuong(listGopY.size());
		}
		if(maGopY!=0){
			if(tinhTrangUpdate==0){
				thongBaoBO.updateDaXem(maGopY);
			}
			else{
				thongBaoBO.updateChuaXem(maGopY);
			}
			gopYForm.setMaGopY(0);
			ArrayList<ThongBao> listGopY = thongBaoBO.getListThongBaoGopY(maTK,0,0);
			form1.setListThongBao(listGopY);
			form1.setSoLuong(listGopY.size());
		}

		session1.setAttribute("thongBaoForm", form1);
		
		ArrayList<ThongBao> listGopY = thongBaoBO.getListThongBaoGopY(maTK,loaiGopY,tinhTrang);
		gopYForm.setListThongBao(listGopY);
		
		return mapping.findForward("danhSachGopY");
	}

}
