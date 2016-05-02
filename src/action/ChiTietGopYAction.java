package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.GopYForm;
import form.ThongBaoForm;
import model.bean.ThongBao;
import model.bo.GopYBO;
import model.bo.ThongBaoBO;

public class ChiTietGopYAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		GopYForm gopYForm = (GopYForm)form;
		GopYBO gopYBO = new GopYBO();
		
		HttpSession session1 = request.getSession();	
		ThongBaoForm form1 = (ThongBaoForm)session1.getAttribute("thongBaoForm");
		
		int maGopY = gopYForm.getMaGopY();
		String maTK =(String)request.getSession().getAttribute("maTKDN");
		ArrayList<ThongBao> listGopY = gopYBO.getListGopY(maTK);
		ThongBao gopY ;
		if(maGopY==0){
			maGopY = listGopY.get(0).getMaGopY();
			gopY = gopYBO.getGopY(maGopY);
			gopYForm.setChuDe(gopY.getChuDe());
			gopYForm.setNoiDung(gopY.getNoiDung());
			gopYForm.setThoiGian(gopY.getThoiGian());
			gopYForm.setLoaiGopY(gopY.getLoaiGopY());
		}
		else{
			gopY = gopYBO.getGopY(maGopY);
			System.out.println(gopY.getLoaiGopY());
			gopYForm.setChuDe(gopY.getChuDe());
			gopYForm.setNoiDung(gopY.getNoiDung());
			gopYForm.setThoiGian(gopY.getThoiGian());
			gopYForm.setLoaiGopY(gopY.getLoaiGopY());
		}
		gopYForm.setListGopY(listGopY);
		ThongBaoBO thongBaoBO = new ThongBaoBO();
		thongBaoBO.updateDaXem(maGopY);
		
		session1.removeAttribute("thongBaoForm");
		
		ArrayList<ThongBao> listGopYDaXem = thongBaoBO.getListThongBaoGopY(maTK,0,0);
		
		form1.setListThongBao(listGopYDaXem);
		form1.setSoLuong(listGopYDaXem.size());
		
		session1.setAttribute("thongBaoForm", form1);
		
		return mapping.findForward("chiTietGopY");
	}
	

}
