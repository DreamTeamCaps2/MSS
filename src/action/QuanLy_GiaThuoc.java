package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ThuocForm;
import model.bean.TaiKhoan;
import model.bean.Thuoc;
import model.bo.ThuocBO;

public class QuanLy_GiaThuoc extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session1 = request.getSession();
		
		TaiKhoan taiKhoan = (TaiKhoan)session1.getAttribute("taiKhoan");
		String maTKDN = (String)session1.getAttribute("maTKDN");
		
		ThuocBO thuocBO = new ThuocBO();
		ThuocForm thuocForm = (ThuocForm)form;
		
		ArrayList<Thuoc> listThuocCuaHang;
		listThuocCuaHang = thuocBO.getThuocCuaHang(maTKDN);
		thuocForm.setListThuocCuaHang(listThuocCuaHang);
		
		ArrayList<Thuoc> listThuocHeThong;
		listThuocHeThong = thuocBO.getListThuocHeThong(maTKDN);
		thuocForm.setListThuoc(listThuocHeThong);
		
		if(request.getParameter("idthuoc")!=null){
			String idThuoc = request.getParameter("idthuoc");
			String giaThuoc = request.getParameter("giathuoc");
			System.out.println(idThuoc+" "+ giaThuoc);
			thuocBO.themGiaThuocCuaHang(maTKDN, idThuoc, giaThuoc);
			//thuocForm.setListThuoc(thuocBO.getListThuocHeThong(maTKDN));
		}
		
		
		return mapping.findForward("listThuocCuaHang");
	}
	
	
	

}
